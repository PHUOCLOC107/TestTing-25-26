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

WebUI.comment("=== TC_PDP_03: Tăng số lượng sản phẩm ===")

		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl("https://shopvnb.com")

		WebUI.waitForPageLoad(10)

		// B1: Mở trang chi tiết từ sản phẩm
		WebUI.click(findTestObject('Object Repository/Product Detail/click_product'))
		WebUI.waitForPageLoad(10)

		// B2: Lấy số lượng hiện tại
		String qtyBefore = WebUI.getAttribute(findTestObject('Object Repository/Product Detail/input_quantity'), 'value')
		int beforeValue = Integer.parseInt(qtyBefore)

		WebUI.comment("Số lượng trước khi tăng: " + beforeValue)

		// B3: Nhấn nút tăng số lượng
		WebUI.click(findTestObject('Object Repository/Product Detail/btn_increase_qty'))
		WebUI.delay(1)

		// B4: Lấy số lượng sau khi tăng
		String qtyAfter = WebUI.getAttribute(findTestObject('Object Repository/Product Detail/input_quantity'), 'value')
		int afterValue = Integer.parseInt(qtyAfter)

		WebUI.comment("Số lượng sau khi tăng: " + afterValue)

		// B5: Kiểm tra kết quả
		if (afterValue == beforeValue + 1) {
			WebUI.comment("PASSED: Tăng số lượng thành công")
		} else {
			WebUI.takeScreenshot()
			throw new Exception("FAILED: Giá trị số lượng không tăng đúng (Expected: " + (beforeValue + 1) + ", Actual: " + afterValue + ")")
		}

		WebUI.closeBrowser()