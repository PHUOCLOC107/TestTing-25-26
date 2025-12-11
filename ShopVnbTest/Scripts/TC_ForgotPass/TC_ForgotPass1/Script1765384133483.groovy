import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Mở trình duyệt (Chỉ mở ở bước 1 này thôi)
WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/thanh-vien/dang-nhap')
WebUI.maximizeWindow()

// Click vào link "Quên mật khẩu"
WebUI.click(findTestObject('ForgotPass/Page_Login/link_QuenMatKhau')) // Cần check lại tên object trong kho của bạn