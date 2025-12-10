import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
// BƯỚC 1: Truy cập trang chủ ShopVNB
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://shopvnb.com')

// Đợi trang chủ load xong và logo hiện ra
WebUI.waitForPageLoad(15)
WebUI.waitForElementVisible(findTestObject('ShopVNB/TinTuc/a_Tin tc'), 10)

// BƯỚC 2: Click vào menu "Tin tức"
WebUI.click(findTestObject('ShopVNB/TinTuc/a_Tin tc'))

// Đợi trang Tin tức load xong
WebUI.waitForPageLoad(15)

// BƯỚC 3: Click vào bài viết có ảnh Review (đúng object bạn đã spy)
WebUI.scrollToElement(findTestObject('ShopVNB/TinTuc/news'), 10)
WebUI.click(findTestObject('ShopVNB/TinTuc/news'))

// Đợi trang chi tiết bài viết load xong
WebUI.waitForPageLoad(15)

// Đóng trình duyệt
WebUI.delay(2)
WebUI.click(findTestObject('ShopVNB/TinTuc/a_Tin tc'))

// Đợi trang Tin tức load xong
WebUI.waitForPageLoad(15)
WebUI.delay(5)
//WebUI.closeBrowser()