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

//TC4 – Add product without choosing variation
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com')
WebUI.executeJavaScript("window.scrollTo(0, 1200);", null)
WebUI.delay(1)
WebUI.click(findTestObject('Home/Cat_GiayCauLong'))
WebUI.click(findTestObject('Home/Product_Taro024'))
WebUI.click(findTestObject('Product Detail/Btn_AddToCart'))
if (WebUI.waitForAlert(3)) {
	String alertText = WebUI.getAlertText()
	println("ALERT: " + alertText)
	WebUI.acceptAlert()
}
WebUI.verifyTextPresent("Chọn", false)
WebUI.closeBrowser()
