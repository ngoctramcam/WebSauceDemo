import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.llm.keyword.LlmKeywords as LLM
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

// Checkout thành công
WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

WebUI.setText(findTestObject('Page_Login/input_Username'), Username)

WebUI.setText(findTestObject('Page_Login/input_Password'), Password)

WebUI.click(findTestObject('Page_Login/btn_Login'))

// Add Backpack
WebUI.click(findTestObject('Page_Products/btn_AddToCart_Backpack'))

// Nhấn vào icon giỏ hàng để vào trang Cart
WebUI.click(findTestObject('Page_Cart/icon_CartBadge'))

// Trong Cart nhấn Checkout
WebUI.click(findTestObject('Page_Cart/btn_Checkout'))

// Nhập thông tin checkout
WebUI.setText(findTestObject('Page_Checkout/input_FirstName'), FirstName)

WebUI.setText(findTestObject('Page_Checkout/input_LastName'), LastName)

WebUI.setText(findTestObject('Page_Checkout/input_PostalCode'), PostalCode)

// Tiếp tục và hoàn tất
WebUI.click(findTestObject('Page_Checkout/btn_Continue'))

WebUI.click(findTestObject('Page_Checkout/btn_Finish'))

// Verify checkout thành công
WebUI.verifyTextPresent('Thank you for your order!', false)

WebUI.closeBrowser()

