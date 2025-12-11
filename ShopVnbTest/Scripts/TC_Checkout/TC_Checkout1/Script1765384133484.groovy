import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Mở trình duyệt
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/thanh-vien/dang-nhap')
WebUI.maximizeWindow()

// 2. Nhập Email & Mật khẩu
WebUI.setText(findTestObject('Object Repository/Checkout/Page_Login/input_Email'), '22130066@st.hcmuaf.edu.vn')
WebUI.setText(findTestObject('Object Repository/Checkout/Page_Login/input_Password'), 'F9IPDKPO18') 
// (Lưu ý: Bạn nhớ sửa lại mật khẩu thật ở dòng trên)

// --- DELAY 45s: XỬ LÝ CAPTCHA ---
WebUI.comment('SCRIPT ĐANG DỪNG 45 GIÂY: Nhập email và mật khẩu')
WebUI.delay(10)

// 3. Script tự bấm nút Đăng nhập
WebUI.click(findTestObject('Object Repository/Checkout/Page_Login/btn_DangNhap'))
