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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://shopvnb.com')

WebUI.setText(findTestObject('Object Repository/Search/input_search'), "") // từ khóa trống
WebUI.click(findTestObject('Object Repository/Search/btn_search'))

// Lấy thuộc tính validationMessage từ input
String message = WebUI.getAttribute(findTestObject('Object Repository/Search/input_search'), 'validationMessage')
WebUI.comment("Validation message: " + message)

if (message.contains("Vui lòng") || message.contains("Please fill")) {
	WebUI.comment("Kết quả OK: hiển thị thông báo khi tìm kiếm từ khóa trống")
} else {
	WebUI.comment("Test Failed: thông báo không đúng hoặc không xuất hiện")
	WebUI.takeScreenshot()
	throw new Exception("Test Failed: tìm kiếm từ khóa trống không xử lý đúng")
}

WebUI.closeBrowser()