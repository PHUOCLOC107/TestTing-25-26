import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('TC_Checkout/TC_Checkout6'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/Checkout/Page_Checkout/select_frame'), 20)
WebUI.switchToFrame(findTestObject('Object Repository/Checkout/Page_Checkout/select_frame'), 10)

WebUI.click(findTestObject('Object Repository/Checkout/Page_Checkout/input_BuyerName'))
WebUI.delay(10)
WebUI.setText(findTestObject('Object Repository/Checkout/Page_Checkout/input_BuyerName'), 'Đức Hải')
WebUI.setText(findTestObject('Object Repository/Checkout/Page_Checkout/input_BuyerPhone'), '0975 433 632')
WebUI.setText(findTestObject('Object Repository/Checkout/Page_Checkout/input_BuyerEmail'), '22130066@st.hcmuaf.edu.vn')
WebUI.delay(5)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Checkout/Page_Checkout/select_City'), 'Thành phố Hồ Chí Minh', false)

WebUI.setText(findTestObject('Object Repository/Checkout/Page_Checkout/input_CustomField'), 'sdef')
WebUI.delay(10)

WebUI.click(findTestObject('Object Repository/Checkout/Page_Checkout/container_District'))
WebUI.delay(15)//chọn quận muốn giao

WebUI.click(findTestObject('Object Repository/Checkout/Page_Checkout/container_Ward'))
WebUI.delay(15)//chọn huyện muốn giao

WebUI.setText(findTestObject('Object Repository/Checkout/Page_Checkout/input_Address'), 'Đường số 6')

WebUI.click(findTestObject('Object Repository/Checkout/Page_Checkout/btn_tieptuc'))
