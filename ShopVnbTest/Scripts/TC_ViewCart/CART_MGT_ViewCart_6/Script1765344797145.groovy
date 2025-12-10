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

// PRECONDITION – thêm sản phẩm vào giỏ
WebUI.callTestCase(findTestCase('Preconditions/AddProductToCart2'), [:], FailureHandling.STOP_ON_FAILURE)

// Lấy object nút Xóa
TestObject removeBtn = findTestObject('Cart/Btn_RemoveItem')

// Scroll để thấy nút
WebUI.scrollToElement(removeBtn, 5)
WebUI.waitForElementClickable(removeBtn, 5)

// Click bằng JS để không lỗi
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(removeBtn)))

// Đợi trang cập nhật
WebUI.delay(1)

// Kiểm tra rằng item đã biến mất
WebUI.verifyElementNotPresent(findTestObject('Cart/Item_Image'), 5)

// Kiểm tra giao diện giỏ hàng trống (nếu shop có text)
WebUI.verifyTextPresent("giỏ hàng", false)

// Đóng browser
WebUI.closeBrowser()