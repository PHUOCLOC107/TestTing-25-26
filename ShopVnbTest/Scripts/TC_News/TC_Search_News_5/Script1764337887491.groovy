import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://shopvnb.com')

// 1. Vào Tin tức
WebUI.click(findTestObject('News/a_Tin tc'))
WebUI.waitForPageLoad(15)

// 2. Tìm kiếm "cầu lông"
WebUI.setText(findTestObject('News/search_bar'), 'cầu lông')
WebUI.sendKeys(findTestObject('News/search_bar'), Keys.chord(Keys.ENTER))
WebUI.waitForPageLoad(20)

// 3. Cuộn xuống cuối trang để load phân trang
// Cuộn xuống 60% chiều cao trang web
WebUI.executeJavaScript("window.scrollTo({ top: document.body.scrollHeight * 0.4, behavior: 'smooth' })", null)
WebUI.delay(3)

// Cuộn xuống 60% chiều cao trang web
WebUI.executeJavaScript("window.scrollTo({ top: document.body.scrollHeight * 0.45, behavior: 'smooth' })", null)
WebUI.delay(3)

// Click trang 2, 3, 4 bằng text (chắc chắn đúng dù có tìm kiếm hay không)
WebUI.executeJavaScript("window.scrollTo({ top: document.body.scrollHeight * 0.45, behavior: 'smooth' })", null)
WebUI.delay(3)
WebUI.click(findTestObject('News/paging2'))
WebUI.waitForPageLoad(15)

WebUI.executeJavaScript("window.scrollTo({ top: document.body.scrollHeight * 0.45, behavior: 'smooth' })", null)
WebUI.delay(3)
WebUI.click(findTestObject('News/paging3'))
WebUI.waitForPageLoad(15)

WebUI.executeJavaScript("window.scrollTo({ top: document.body.scrollHeight * 0.45, behavior: 'smooth' })", null)
WebUI.delay(3)
WebUI.click(findTestObject('News/paging4'))
WebUI.waitForPageLoad(15)
WebUI.executeJavaScript("window.scrollTo({ top: document.body.scrollHeight * 0.45, behavior: 'smooth' })", null)
WebUI.delay(3)

WebUI.comment("ĐÃ CHUYỂN QUA 3 TRANG PHÂN TRANG THÀNH CÔNG VỚI TỪ KHÓA CẦU LÔNG!")
WebUI.delay(3)
//WebUI.closeBrowser()