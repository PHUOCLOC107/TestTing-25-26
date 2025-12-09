import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://shopvnb.com/he-thong-cua-hang') // Nhớ thay link web thật vào đây

// 1. Chọn Tỉnh: TPHCM
WebUI.click(findTestObject('Object Repository/StoreSystem/select_Province'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/StoreSystem/opt_Province_HCM'))

// 2. Chọn Quận: TP Thủ Đức
WebUI.click(findTestObject('Object Repository/StoreSystem/select_District'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/StoreSystem/opt_District_ThuDuc'))
WebUI.delay(2)

// ... (Các bước chọn Tỉnh/Quận ở trên giữ nguyên) ...

WebUI.delay(2)

// --- 3. CLICK VÀO CỬA HÀNG & XỬ LÝ TAB MỚI ---

// 3. Click vào cửa hàng (Sửa lại đoạn cuối này thôi)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/StoreSystem/link_Store_ThuDuc'))

// Đợi trang chi tiết load
WebUI.delay(3)

// 4. VERIFY (Kiểm tra ngay tại tab hiện tại)
String currentUrl = WebUI.getUrl()
WebUI.comment("Đang ở trang: " + currentUrl)

if (currentUrl.contains('vnb-premium')) {
    WebUI.comment("PASSED: Đã vào đúng trang chi tiết.")
} else {
    WebUI.comment("FAILED: URL không đúng.")
}

// KHÔNG CẦN CloseWindowIndex(1)
// KHÔNG CẦN SwitchToWindowIndex(0)

// Kết thúc test case
WebUI.closeBrowser()