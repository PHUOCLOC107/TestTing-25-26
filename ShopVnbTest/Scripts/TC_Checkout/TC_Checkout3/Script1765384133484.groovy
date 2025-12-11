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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Điền thông tin (Máy tự điền)
WebUI.setText(findTestObject('Page_Checkout/input_HoTen'), 'Sinh Vien Test')
WebUI.setText(findTestObject('Page_Checkout/input_SDT'), '0901234567')
WebUI.setText(findTestObject('Page_Checkout/input_DiaChi'), 'So 1 duong ABC')
WebUI.setText(findTestObject('Page_Checkout/textarea_GhiChu'), 'Giao gio hanh chinh')

// --- DELAY 60s: CHỌN ĐỊA CHỈ & KIỂM TRA ---
WebUI.comment('SCRIPT ĐANG DỪNG 60 GIÂY: Bạn hãy chọn Tỉnh/Thành, Quận/Huyện thủ công...')
WebUI.delay(60)

// 2. Cuộn xuống nút Đặt hàng
WebUI.scrollToElement(findTestObject('Page_Checkout/btn_DatHang'), 3)

// 3. Bấm đặt hàng (Bỏ comment dòng dưới nếu muốn chạy thật)
// WebUI.click(findTestObject('Page_Checkout/btn_DatHang'))

WebUI.comment('Đã điền xong thông tin. Kết thúc quá trình test.')
WebUI.closeBrowser()