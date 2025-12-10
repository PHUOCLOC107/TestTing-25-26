import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Script tự điền lại Email
WebUI.setText(findTestObject('Page_Login/input_Email'), '22130066@st.hcmauf.edu.vn')

// --- BẮT ĐẦU DELAY 60 GIÂY ---
// Script đứng im. mở tab khác, check mail trường, copy pass mới và DÁN VÀO ô mật khẩu.
WebUI.comment('SCRIPT ĐANG DỪNG 60S ĐỂ BẠN CHECK MAIL VÀ NHẬP MẬT KHẨU MỚI...')
WebUI.delay(60)
// -----------------------------

// Sau 60s, Script tự bấm nút "Đăng nhập"
// Lưu ý: Script không dùng lệnh setText(password) để tránh ghi đè lên cái bạn vừa nhập tay.
WebUI.click(findTestObject('Page_Login/btn_DangNhap'))

// Kiểm tra đăng nhập thành công (Ví dụ tìm text tên bạn)
WebUI.verifyElementPresent(findTestObject('Page_Home/txt_TenTaiKhoan'), 10, FailureHandling.OPTIONAL)

// Đóng trình duyệt (Hoàn tất quy trình)
WebUI.closeBrowser()