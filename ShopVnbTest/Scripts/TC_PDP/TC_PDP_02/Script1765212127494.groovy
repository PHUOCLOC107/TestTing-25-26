import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.comment("=== TC_PDP_02: Xem sản phẩm liên quan trong trang chi tiết ===")

		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl("https://shopvnb.com")

		WebUI.waitForPageLoad(10)

		// Mở sản phẩm đầu tiên để vào trang chi tiết
		WebUI.click(findTestObject('Object Repository/Product Detail/click_product'))
		WebUI.waitForPageLoad(10)

		// Cuộn xuống mục "Sản phẩm liên quan"
		WebUI.scrollToElement(findTestObject('Object Repository/Product Detail/check_title_product_related'), 10)

		boolean hasRelatedSection = WebUI.verifyElementPresent(
			findTestObject('Object Repository/Product Detail/title_product_detail'),
			10,
			FailureHandling.OPTIONAL
		)

		if (!hasRelatedSection) {
			WebUI.takeScreenshot()
			throw new Exception("FAILED: Không tìm thấy mục 'Sản phẩm liên quan'")
		}

		WebUI.comment("Tìm thấy mục Sản phẩm liên quan")

		// Nhấn vào sản phẩm liên quan
		WebUI.click(findTestObject('Object Repository/Product Detail/click_product_related'))
		WebUI.waitForPageLoad(10)

		// Kiểm tra rằng trang chi tiết của sản phẩm liên quan được mở
		boolean hasProductTitle = WebUI.verifyElementPresent(
			findTestObject('Object Repository/Product Detail/title_product_detail'),
			10,
			FailureHandling.OPTIONAL
		)

		if (!hasProductTitle) {
			WebUI.takeScreenshot()
			throw new Exception("FAILED: Không mở được trang chi tiết của sản phẩm liên quan")
		}

		WebUI.comment("PASSED: Mở trang chi tiết của sản phẩm liên quan thành công")

		WebUI.closeBrowser()