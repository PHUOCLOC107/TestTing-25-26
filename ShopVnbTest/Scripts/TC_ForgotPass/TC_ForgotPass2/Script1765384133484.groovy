import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Điền Email của bạn
WebUI.setText(findTestObject('Page_ForgotPass/input_EmailRecover'), '22130066@st.hcmauf.edu.vn')

// --- BẮT ĐẦU DELAY 60 GIÂY ---
// Script sẽ đứng im. Bạn hãy nhanh tay nhập Mã CAPTCHA vào ô bên cạnh.
WebUI.comment('SCRIPT ĐANG DỪNG 60S ĐỂ BẠN NHẬP CAPTCHA THỦ CÔNG...')
WebUI.delay(60) 
// -----------------------------

// Sau 60s, Script sẽ tự bấm nút "LẤY LẠI MẬT KHẨU"
// Hãy đảm bảo bạn đã nhập xong captcha trước khi hết giờ
WebUI.click(findTestObject('Page_ForgotPass/btn_LayLaiMatKhau'))