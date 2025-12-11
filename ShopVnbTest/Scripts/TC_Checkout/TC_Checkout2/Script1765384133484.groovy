import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement

// 1. Về trang chủ
WebUI.callTestCase(findTestCase('TC_Checkout/TC_Checkout1'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('https://shopvnb.com/')

// 2. Tìm kiếm
//WebUI.setText(findTestObject('Object Reposity/Checkout/Page_Home/input_Search'), 'Vợt cầu lông Yonex')
//WebUI.click(findTestObject('Page_Home/btn_Search_Icon'))
WebUI.executeJavaScript("window.scrollTo(0, 1200);", null)
WebUI.delay(1)

WebUI.click(findTestObject('Home/Cat_GiayCauLong'))
WebUI.click(findTestObject('Home/Product_Taro024'))
WebUI.click(findTestObject('Product Detail/Color_TrangDo'))
WebUI.executeJavaScript("window.scrollTo(0, 800);", null)

WebUI.click(findTestObject('Product Detail/Btn_AddToCart'))
WebUI.waitForElementVisible(findTestObject('Popup/Btn_XemGioHang'), 10)

WebUI.click(findTestObject('Popup/Btn_XemGioHang'))
WebUI.waitForElementVisible(findTestObject('Checkout/Page_Checkout/btn_DatHang'), 10)

WebUI.click(findTestObject('Checkout/Page_Checkout/btn_DatHang'))

