import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('TC_ForgotPass/TC_ForgotPass3'), [:], FailureHandling.STOP_ON_FAILURE)
// 1. Script tự điền lại Email
WebUI.setText(findTestObject('Object Repository/ForgotPass/Page_Login/input_LoginEmail'), 'Nhập email của bạn')

// --- BẮT ĐẦU DELAY 60 GIÂY ---
// Script đứng im. mở tab khác, check mail trường, copy pass mới và DÁN VÀO ô mật khẩu.
WebUI.comment('SCRIPT ĐANG DỪNG 60S ĐỂ BẠN CHECK MAIL VÀ NHẬP MẬT KHẨU MỚI...')
WebUI.delay(60)
// -----------------------------

// Sau 60s, Script tự bấm nút "Đăng nhập"
// Lưu ý: Script không dùng lệnh setText(password) để tránh ghi đè lên cái bạn vừa nhập tay.
WebUI.click(findTestObject('Object Repository/ForgotPass/Page_Login/btn_DangNhap'))

// Kiểm tra đăng nhập thành công (Ví dụ tìm text tên bạn)