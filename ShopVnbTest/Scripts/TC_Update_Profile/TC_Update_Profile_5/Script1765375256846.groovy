import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// 1. Gọi Test Case Đăng nhập trước (để vào được hệ thống)
WebUI.callTestCase(findTestCase('Test Cases/TC_Change_Pwd/TC_Login'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. Vào trang Sửa thông tin
WebUI.navigateToUrl("https://shopvnb.com/thanh-vien")
WebUI.navigateToUrl("https://shopvnb.com/thanh-vien/thong-tin")


// 6. Chọn Giới tính (Nữ)
WebUI.selectOptionByLabel(findTestObject('Object Repository/UpdateProfile/input_gioiTinh'), 'Nữ', false)

// 7. Click nút Cập nhật
WebUI.click(findTestObject('Object Repository/UpdateProfile/btn_Update'))
WebUI.delay(3)
// 8. Đóng trình duyệt
WebUI.closeBrowser()