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


// --- Mở trang ---
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com')
WebUI.waitForPageLoad(10)

// --- Click vào link sản phẩm ---
def productLink = findTestObject('Object Repository/Rating/ProductDetail/Link_VNB_V200_Xanh')
WebUI.scrollToElement(productLink, 10)
WebUI.delay(1)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(productLink)))
WebUI.delay(2)

// --- Click vào "Đánh giá ngay" ---
def rateButton = findTestObject('Object Repository/Rating/ProductDetail/Button_Danhgia')
WebUI.scrollToElement(rateButton, 10)
WebUI.delay(1)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(rateButton)))
WebUI.delay(2)

// --- Điền form đánh giá ---
WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'), 'Vo Phuoc Loc')

// ❗ NHẬP SAI ĐỊNH DẠNG SĐT
WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_SoDT'), '09abc1234')

// Không cần upload ảnh cho testcase này
WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/NoiDung'),
		'Test nhập sai số điện thoại')

WebUI.click(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Star5'))

// --- CHỜ NHẬP CAPTCHA ---
WebUI.comment("Vui lòng nhập Captcha trong 5 giây...")
WebUI.delay(5)

// --- Submit ---
def submitBtn = findTestObject('Object Repository/Rating/Form_DanhGia/Button_Submit')
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(submitBtn)))

// --- Chờ alert ---
WebUI.waitForAlert(10)

// --- Lấy nội dung alert ---
String msg = WebUI.getAlertText()
println("Alert: " + msg)

WebUI.delay(2)
WebUI.acceptAlert()

// --- Verify alert đúng expected ---
WebUI.verifyMatch(msg, '.*Số điện thoại không đúng.*', true)