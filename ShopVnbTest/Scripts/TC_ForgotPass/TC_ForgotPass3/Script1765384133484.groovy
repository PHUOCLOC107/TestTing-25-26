import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('TC_ForgotPass/TC_ForgotPass2'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/ForgotPass/Page_ForgotPass/input_RecoverEmail'), 'Nhập email của bạn')
WebUI.delay(30) //nhập otp

// Bấm nút Xác Nhận 
WebUI.click(findTestObject('Object Repository/ForgotPass/Page_ForgotPass/btn_LayLaiMatKhau'))

// Sau khi bấm xác nhận, web thường hiện thông báo "Đã gửi mail", chờ nút "Đăng nhập ngay" hiện ra
WebUI.delay(5)

// Bấm nút "ĐĂNG NHẬP NGAY" để quay về màn hình login
WebUI.click(findTestObject('Object Repository/ForgotPass/Page_ForgotPass/btn_DangNhapNgay'))