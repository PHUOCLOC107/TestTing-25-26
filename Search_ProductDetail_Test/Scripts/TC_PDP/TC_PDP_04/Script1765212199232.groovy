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

WebUI.comment("TC_PDP_04: Hiển thị bảng Thông số kỹ thuật khi nhấn vào tab")

		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl("https://shopvnb.com/vot-cau-long-vnb-v200-xanh.html")
		WebUI.waitForPageLoad(10)

		// Click vào tab "Thông số kỹ thuật"
		WebUI.click(findTestObject('Product Detail/tab_specifications'))
		WebUI.delay(1)  // đợi bảng load

		// Kiểm tra bảng thông số kỹ thuật xuất hiện
		boolean isVisible = WebUI.verifyElementPresent(findTestObject('Product Detail/table_specifications'), 5, FailureHandling.OPTIONAL)
		if (isVisible) {
			WebUI.comment("PASSED: Bảng Thông số kỹ thuật hiển thị đúng khi nhấn tab")
		} else {
			WebUI.takeScreenshot()
			throw new Exception("FAILED: Bảng Thông số kỹ thuật không hiển thị khi nhấn tab")
		}

		WebUI.closeBrowser()