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

WebUI.callTestCase(findTestCase('Preconditions/AddProductToCart'), [:], FailureHandling.STOP_ON_FAILURE)

// Kiểm tra số lượng đang là 1
int oldQty = Integer.parseInt(WebUI.getAttribute(findTestObject('Cart/Input_Qty'), 'value'))
println("OLD QTY = " + oldQty)

if (oldQty == 1) {

    TestObject minusBtn = findTestObject('Cart/Btn_DecreaseQty')

    WebUI.scrollToElement(minusBtn, 5)
    WebUI.waitForElementClickable(minusBtn, 5)

    WebUI.executeJavaScript(
        "arguments[0].click();",
        Arrays.asList(WebUI.findWebElement(minusBtn))
    )

    WebUI.delay(1)

    // Vì sản phẩm bị xóa → không còn Input_Qty → phải kiểm tra theo text giỏ hàng trống
    WebUI.verifyElementNotPresent(findTestObject('Cart/Item_Image'), 5)
}
else {
    WebUI.comment("Số lượng > 1, không phải test case này!")
}

WebUI.closeBrowser()