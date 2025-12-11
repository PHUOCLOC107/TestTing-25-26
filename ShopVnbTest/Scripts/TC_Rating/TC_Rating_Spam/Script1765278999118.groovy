import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint


import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable


// --- Mở trình duyệt và load trang sản phẩm ---
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com')
WebUI.waitForPageLoad(10)

def productLink = findTestObject('Object Repository/Rating/ProductDetail/Link_VNB_V200_Xanh')
WebUI.scrollToElement(productLink, 10)
WebUI.delay(1)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(productLink)))
WebUI.delay(2)

def rateButton = findTestObject('Object Repository/Rating/ProductDetail/Button_Danhgia')
WebUI.scrollToElement(rateButton, 10)
WebUI.delay(1)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(rateButton)))
WebUI.delay(2)

// --- Loop spam 3 lần ---
for (int i = 1; i <= 3; i++) {
	println("===== SPAM LẦN ${i} =====")

	// --- Nếu form đang mở → đóng lại để tránh double layer ---
	try {
		WebUI.click(findTestObject('Object Repository/Rating/Form_DanhGia/Button_Close'), FailureHandling.OPTIONAL)
		WebUI.delay(1)
	} catch (Exception e) { }

	// --- Mở form đánh giá lại ---
	WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(rateButton)))
	WebUI.delay(2)

	// --- Chờ input có thể tương tác ---
	WebUI.waitForElementClickable(findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'), 10)

	// --- Điền thông tin đánh giá ---
	WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'), 'Vo Phuoc Loc')
	WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_SoDT'), '0987654321')
	WebUI.uploadFile(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Img'),
			"C:\\Users\\Admin\\Pictures\\Screenshots\\calibar001c.jpg")
	WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/NoiDung'),
			'Nội dung đánh giá lần ' + i)
	WebUI.click(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Star5'))

	// --- Chờ CAPTCHA nhập liệu ---
	WebUI.delay(5)  // chỉnh thời gian phù hợp

	// --- Submit đánh giá ---
	def submitBtn = findTestObject('Object Repository/Rating/Form_DanhGia/Button_Submit')
	WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(submitBtn)))

	// --- Lấy và xử lý alert ---
	try {
		WebUI.waitForAlert(10)
		String msg = WebUI.getAlertText()
		println("Kết quả lần ${i}: " + msg)

		// Xác nhận alert
		WebUI.acceptAlert()

		// --- Kiểm tra nội dung alert nhưng không dừng script nếu fail ---
		try {
			WebUI.verifyMatch(msg, '.*kiểm duyệt.*|.*cám ơn.*', true, FailureHandling.CONTINUE_ON_FAILURE)
		} catch (Exception e) {
			println("Lỗi verifyMatch lần ${i}: " + e.getMessage())
		}
	} catch (Exception e) {
		println("Không tìm thấy alert lần ${i}, có thể do captcha hoặc lỗi web: " + e.getMessage())
	}

	WebUI.delay(2)
}