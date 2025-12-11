import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import org.openqa.selenium.WebElement
import java.util.Arrays
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

// --- Click vào nút "Đánh giá ngay" ---
def rateButton = findTestObject('Object Repository/Rating/ProductDetail/Button_Danhgia')
WebUI.scrollToElement(rateButton, 10)
WebUI.delay(1)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(rateButton)))
WebUI.delay(2)

// --- Điền thông tin đánh giá ---
WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_HoTen'), 'Vo Phuoc Loc')
WebUI.setText(findTestObject('Object Repository/Rating/Form_DanhGia/Input_SoDT'), '0987654321')
WebUI.uploadFile(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Img'),
		"C:\\Users\\Admin\\Pictures\\Screenshots\\calibar001c.jpg")
// Lấy WebElement từ TestObject
WebElement noiDungEl = WebUI.findWebElement(findTestObject('Rating/Form_DanhGia/NoiDung'))

// Set giá trị bằng JS
WebUI.executeJavaScript("arguments[0].value='Sản phẩm tốt 😊🔥👍!!!';", Arrays.asList(noiDungEl))
WebUI.click(findTestObject('Object Repository/Rating/Form_DanhGia/Input_Star5'))

// --- CHỜ BẠN NHẬP CAPTCHA 5 GIÂY ---
WebUI.comment("Vui lòng nhập Captcha trong 5 giây...")
WebUI.delay(5)

// --- TỰ ĐỘNG SUBMIT ---
// Click submit bằng JS (quan trọng)
def submitBtn = findTestObject('Object Repository/Rating/Form_DanhGia/Button_Submit')
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(submitBtn)))

// Chờ alert
WebUI.waitForAlert(10)

// Lấy text alert
String msg = WebUI.getAlertText()
println(msg)

// Xác nhận alert
WebUI.acceptAlert()

// Kiểm tra nội dung alert
WebUI.verifyMatch(msg, '.*kiểm duyệt.*|.*cám ơn.*', true)