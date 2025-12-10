import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// --- PHẦN 1: ĐĂNG NHẬP (Theo hình 1) ---
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/thanh-vien/dang-nhap')

// Nhập Email và Pass
WebUI.setText(findTestObject('Object Repository/Login/input_email'), '22130084@st.hcmuaf.edu.vn')
WebUI.setText(findTestObject('Object Repository/Login/input_password'), password) // Mật khẩu đăng nhập

// Submit form
WebUI.click(findTestObject("Object Repository/Login/btn_DangNhap"))
WebUI.delay(2) // Chờ đăng nhập xong

