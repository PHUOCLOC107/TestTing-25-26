import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('TC_Checkout/TC_Checkout9'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/Checkout/Page_Checkout/select_frame'), 20)
WebUI.switchToFrame(findTestObject('Object Repository/Checkout/Page_Checkout/select_frame'), 10)

// Chờ và click vào phương án (h4)
WebUI.waitForElementVisible(findTestObject('Object Repository/Checkout/Page_Home/lbl_PhuongAn'), 10)
WebUI.click(findTestObject('Object Repository/Checkout/Page_Home/lbl_PhuongAn'))

WebUI.click(findTestObject('Object Repository/Checkout/Page_Home/btn_CheckLogo1'))
WebUI.delay(5)

// Click vào link 'Tiếp tục'
WebUI.click(findTestObject('Object Repository/Checkout/Page_Home/lnk_TiepTuc'))
WebUI.delay(11)
WebUI.click(findTestObject('Object Repository/Checkout/Page_Home/lnk_next'))