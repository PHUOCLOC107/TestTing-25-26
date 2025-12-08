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

WebUI.comment("=== TC_PDP_01: Mở trang chi tiết sản phẩm từ danh sách ===")

		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl("https://shopvnb.com")

		WebUI.waitForPageLoad(10)

		// Click vào sản phẩm đầu tiên
		WebUI.click(findTestObject('Object Repository/Product Detail/click_product'))

		WebUI.waitForPageLoad(10)

		// Verify trang chi tiết sản phẩm mở ra
		boolean hasTitle = WebUI.verifyElementPresent(
			findTestObject('Object Repository/Product Detail/title_product_detail'),
			10,
			FailureHandling.OPTIONAL
		)

		if (!hasTitle) {
			WebUI.takeScreenshot()
			throw new Exception("FAILED: Không mở được trang chi tiết sản phẩm")
		}

		WebUI.comment("PASSED: Trang chi tiết sản phẩm đã mở thành công")

		WebUI.closeBrowser()