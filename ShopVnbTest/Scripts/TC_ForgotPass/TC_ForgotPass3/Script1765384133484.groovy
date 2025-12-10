import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Chờ nút "XÁC NHẬN" hiện ra (đề phòng mạng lag)
WebUI.waitForElementVisible(findTestObject('Page_ForgotPass/btn_XacNhan_GuiEmail'), 30)

// Bấm nút Xác Nhận 
WebUI.click(findTestObject('Page_ForgotPass/btn_XacNhan_GuiEmail'))

// Sau khi bấm xác nhận, web thường hiện thông báo "Đã gửi mail", chờ nút "Đăng nhập ngay" hiện ra
WebUI.waitForElementVisible(findTestObject('Page_ForgotPass/btn_DangNhapNgay'), 30)

// Bấm nút "ĐĂNG NHẬP NGAY" để quay về màn hình login (Ảnh 4)
WebUI.click(findTestObject('Page_ForgotPass/btn_DangNhapNgay'))