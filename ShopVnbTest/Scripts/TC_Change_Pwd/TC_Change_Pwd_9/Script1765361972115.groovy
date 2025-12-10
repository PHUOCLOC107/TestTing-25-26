import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// --- BƯỚC 1: GỌI TEST CASE LOGIN TRƯỚC ---
WebUI.callTestCase(findTestCase('Test Cases/TC_Change_Pwd/TC_Login',), [('password') : 'Linh hoai'], FailureHandling.STOP_ON_FAILURE)

// --- BƯỚC 2: SAU KHI LOGIN XONG THÌ LÀM TIẾP ---
// (Lúc này trình duyệt đang mở và đã đăng nhập rồi)

// Vào trang cá nhân -> Sửa thông tin
WebUI.navigateToUrl("https://shopvnb.com/thanh-vien/thong-tin")

// Nhập mật khẩu cũ
WebUI.setText(findTestObject('Object Repository/ChangePassword/input_matKhau'), 'Linh hoai')

// Nhập mật khẩu mới
WebUI.setText(findTestObject('Object Repository/ChangePassword/input_pass'), 'Linhhoai123')

// Nhập lại mật khẩu mới
WebUI.setText(findTestObject('Object Repository/ChangePassword/input_re_pass'), 'Linh hoai123')

// Click nút Lưu/Đổi
WebUI.click(findTestObject('Object Repository/ChangePassword/btn_DoiMatKhau'))

// Đóng trình duyệt sau khi xong hết mọi việc
WebUI.delay(3)
WebUI.closeBrowser()