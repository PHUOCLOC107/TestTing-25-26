import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Mở trình duyệt
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/account/login')
WebUI.maximizeWindow()

// 2. Nhập Email & Mật khẩu
WebUI.setText(findTestObject('Page_Login/input_Email'), '22130066@st.hcmauf.edu.vn')
WebUI.setText(findTestObject('Page_Login/input_Password'), 'MatKhauCuaBanNhapVaoDay') 
// (Lưu ý: Bạn nhớ sửa lại mật khẩu thật ở dòng trên)

// --- DELAY 45s: XỬ LÝ CAPTCHA ---
WebUI.comment('SCRIPT ĐANG DỪNG 45 GIÂY: Bạn hãy nhập CAPTCHA nếu có...')
WebUI.delay(45)

// 3. Script tự bấm nút Đăng nhập
WebUI.click(findTestObject('Page_Login/btn_DangNhap'))

// 4. Kiểm tra đăng nhập thành công chưa
WebUI.waitForElementVisible(findTestObject('Page_Home/txt_TenTaiKhoan'), 30)