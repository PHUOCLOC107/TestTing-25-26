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


// PRECONDITION
WebUI.callTestCase(findTestCase('Preconditions/AddProductToCart2'), [:], FailureHandling.STOP_ON_FAILURE)

// Lấy số lượng ban đầu
int oldQty = Integer.parseInt(WebUI.getAttribute(findTestObject('Cart/Input_Qty'), 'value'))
println("OLD = " + oldQty)

// Lấy object nút "+"
TestObject plusBtn = findTestObject('Cart/Btn_IncreaseQty')

// Scroll + click bằng JS để đảm bảo chạy
WebUI.scrollToElement(plusBtn, 5)
WebUI.waitForElementClickable(plusBtn, 5)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(plusBtn)))

WebUI.delay(1)

// Kiểm tra qty tăng
int newQty = Integer.parseInt(WebUI.getAttribute(findTestObject('Cart/Input_Qty'), 'value'))
println("NEW = " + newQty)

WebUI.verifyGreaterThan(newQty, oldQty)
WebUI.closeBrowser()