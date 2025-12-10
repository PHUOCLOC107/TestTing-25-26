import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Về trang chủ
WebUI.navigateToUrl('https://shopvnb.com/')

// 2. Tìm kiếm
WebUI.setText(findTestObject('Page_Home/input_Search'), 'Vợt cầu lông Yonex')
WebUI.click(findTestObject('Page_Home/btn_Search_Icon'))

// 3. Chọn sản phẩm đầu tiên
WebUI.delay(2)
WebUI.click(findTestObject('Page_Product/link_SanPhamDauTien'))

// 4. Thêm vào giỏ
WebUI.scrollToElement(findTestObject('Page_Product/btn_ThemVaoGio'), 3)
WebUI.click(findTestObject('Page_Product/btn_ThemVaoGio'))

// 5. Bấm nút Thanh toán (trên Popup hoặc chuyển trang)
WebUI.waitForElementVisible(findTestObject('Page_Product/btn_ThanhToan_Popup'), 10)
WebUI.click(findTestObject('Page_Product/btn_ThanhToan_Popup'))