import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement

// 1. Về trang chủ
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/')

// 2. Tìm kiếm
//WebUI.setText(findTestObject('Object Reposity/Checkout/Page_Home/input_Search'), 'Vợt cầu lông Yonex')
//WebUI.click(findTestObject('Page_Home/btn_Search_Icon'))
WebUI.executeJavaScript("window.scrollTo(0, 800);", null)
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/Checkout/Page_Home/Product_CauLong'))
WebUI.delay(3)
WebUI.executeJavaScript("window.scrollTo(0, 800);", null)
WebUI.delay(10)
WebUI.click(findTestObject('Object Repository/Checkout/Page_Product/ThanhToanThe'))