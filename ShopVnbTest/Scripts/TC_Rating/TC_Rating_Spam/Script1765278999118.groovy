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

import java.util.Arrays

// =======================
// HÀM CLEAR INPUT BẰNG JS
// =======================
def clearInputByJS = { TestObject to ->
	WebUI.executeJavaScript(
		"""
		arguments[0].value = '';
		arguments[0].dispatchEvent(new Event('input', { bubbles: true }));
		arguments[0].dispatchEvent(new Event('change', { bubbles: true }));
		""",
		Arrays.asList(WebUI.findWebElement(to))
	)
}

// --- Mở trình duyệt và load trang ---
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com')
WebUI.waitForPageLoad(10)

// --- Mở trang chi tiết sản phẩm ---
def productLink = findTestObject('Object Repository/Rating/ProductDetail/Link_VNB_V200_Xanh')
WebUI.scrollToElement(productLink, 10)
WebUI.delay(1)
WebUI.executeJavaScript(
	"arguments[0].click();",
	Arrays.asList(WebUI.findWebElement(productLink))
)
WebUI.delay(2)

// --- Button đánh giá ---
def rateButton = findTestObject('Object Repository/Rating/ProductDetail/Button_Danhgia')

// =======================
// LOOP SPAM 3 LẦN
// =======================
for (int i = 1; i <= 3; i++) {

	println("===== SPAM LẦN ${i} =====")

	// =======================
	// RESET TRANG → RESET CAPTCHA
	// =======================
	WebUI.refresh()
	WebUI.waitForPageLoad(10)
	WebUI.delay(2)

	// --- Mở lại form đánh giá ---
	WebUI.scrollToElement(rateButton, 10)
	WebUI.delay(1)
	WebUI.executeJavaScript(
		"arguments[0].click();",
		Arrays.asList(WebUI.findWebElement(rateButton))
	)
	WebUI.delay(2)

	// --- Chờ input ---
	WebUI.waitForElementClickable(
		findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'),
		10
	)

	// =======================
	// CLEAR INPUT (QUAN TRỌNG)
	// =======================
	clearInputByJS(findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'))
	clearInputByJS(findTestObject('Object Repository/Rating/Form_DanhGia/Input_SoDT'))
	clearInputByJS(findTestObject('Object Repository/Rating/Form_DanhGia/NoiDung'))

	// --- Nhập thông tin ---
	WebUI.setText(
		findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'),
		'Vo Phuoc Loc'
	)

	WebUI.setText(
		findTestObject('Object Repository/Rating/Form_DanhGia/Input_SoDT'),
		'0987654321'
	)

	WebUI.setText(
		findTestObject('Object Repository/Rating/Form_DanhGia/NoiDung'),
		'Nội dung đánh giá lần ' + i
	)

	WebUI.click(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Star5'))

	// --- Chờ nhập CAPTCHA thủ công ---
	WebUI.delay(5)

	// --- Submit ---
	def submitBtn = findTestObject('Object Repository/Rating/Form_DanhGia/Button_Submit')
	WebUI.executeJavaScript(
		"arguments[0].click();",
		Arrays.asList(WebUI.findWebElement(submitBtn))
	)

	// --- Xử lý alert ---
	try {
		WebUI.waitForAlert(10)
		String msg = WebUI.getAlertText()
		println("Kết quả lần ${i}: " + msg)

		WebUI.acceptAlert()

		WebUI.verifyMatch(
			msg,
			'.*kiểm duyệt.*|.*cám ơn.*',
			true,
			FailureHandling.CONTINUE_ON_FAILURE
		)
	} catch (Exception e) {
		println("Không tìm thấy alert lần ${i}: " + e.getMessage())
	}

	WebUI.delay(2)
}
