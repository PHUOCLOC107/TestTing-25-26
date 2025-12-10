import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys

// 1. Mở trình duyệt và truy cập ShopVNB
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://shopvnb.com')

// 2. Click vào menu "Tin tức" (dùng object bạn đã có trước đó)
WebUI.waitForPageLoad(15)
WebUI.click(findTestObject('ShopVNB/TinTuc/a_Tin tc'))

// 3. Đợi trang Tin tức load xong + thanh tìm kiếm hiện ra
WebUI.waitForPageLoad(15)
WebUI.waitForElementVisible(findTestObject('ShopVNB/TinTuc/search_bar'), 10)

// 4. Nhập từ khóa "cầu lông" vào thanh tìm kiếm
WebUI.setText(findTestObject('ShopVNB/TinTuc/search_bar'), 'vot cau long')

// 5. Nhấn Enter để tìm kiếm (nhanh và ổn định hơn click nút kính lúp)
WebUI.sendKeys(findTestObject('ShopVNB/TinTuc/search_bar'), Keys.chord(Keys.ENTER))

// Nếu bạn thích click nút tìm kiếm thay vì Enter thì dùng dòng dưới:
// WebUI.click(findTestObject('ShopVNB/TinTuc/button_Search')) // nếu bạn có spy sẵn nút kính lúp

// 6. Đợi kết quả tìm kiếm hiện ra
WebUI.waitForPageLoad(15)
WebUI.delay(1) // đợi 1 giây cho kết quả render xong

// 7. Scroll tới + Click vào bài viết đầu tiên (object news1st bạn đã spy)
WebUI.scrollToElement(findTestObject('ShopVNB/TinTuc/div'), 10)
WebUI.click(findTestObject('ShopVNB/TinTuc/div'))


WebUI.delay(2)
//WebUI.closeBrowser()