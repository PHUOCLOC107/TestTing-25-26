import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
WebUI.callTestCase(findTestCase('TC_ForgotPass/TC_ForgotPass1'), [:], FailureHandling.STOP_ON_FAILURE)
// Điền Email của bạn
WebUI.setText(findTestObject('Object Repository/ForgotPass/Page_ForgotPass/input_RecoverEmail'), '22130066@st.hcmuaf.edu.vn')

// --- BẮT ĐẦU DELAY 60 GIÂY ---
// Script sẽ đứng im. Bạn hãy nhanh tay nhập Mã CAPTCHA vào ô bên cạnh.
WebUI.comment('SCRIPT ĐANG DỪNG 60S ĐỂ BẠN NHẬP CAPTCHA THỦ CÔNG...')
WebUI.delay(10) 
// -----------------------------

// Sau 60s, Script sẽ tự bấm nút "LẤY LẠI MẬT KHẨU"
// Hãy đảm bảo bạn đã nhập xong captcha trước khi hết giờ
WebUI.click(findTestObject('ForgotPass/Page_ForgotPass/btn_LayLaiMatKhau'))
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/ForgotPass/Page_ForgotPass/btn_XacNhan'))