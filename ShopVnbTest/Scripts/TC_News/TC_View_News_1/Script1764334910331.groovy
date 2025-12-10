import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
// BƯỚC 1: Truy cập trang chủ ShopVNB
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://shopvnb.com')

// Đợi trang chủ load xong và logo hiện ra
WebUI.waitForPageLoad(15)
WebUI.waitForElementVisible(findTestObject('News/a_Tin tc'), 10)

// BƯỚC 2: Click vào menu "Tin tức"
WebUI.click(findTestObject('News/a_Tin tc'))

// Đợi trang Tin tức load xong
WebUI.waitForPageLoad(15)

// BƯỚC 3: Click vào bài viết có ảnh Review (đúng object bạn đã spy)
WebUI.scrollToElement(findTestObject('News/news'), 10)
WebUI.click(findTestObject('News/news'))

// Đợi trang chi tiết bài viết load xong
WebUI.waitForPageLoad(15)

// Verify đã vào đúng bài viết (kiểm tra tiêu đề hoặc URL)
// Đóng trình duyệt
WebUI.delay(10)
//WebUI.closeBrowser()