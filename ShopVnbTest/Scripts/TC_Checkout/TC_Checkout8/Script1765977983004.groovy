import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('TC_Checkout/TC_Checkout7'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Checkout/Page_Checkout/Payment_Choose'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Checkout/Page_Checkout/btn_ATM'))