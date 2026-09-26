 // Import các hàm cần thiết từ Katalon
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Mở trang login
WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

// Nhập username và password đúng
WebUI.setText(findTestObject('Page_Login/input_Username'), Username)

WebUI.setText(findTestObject('Page_Login/input_Password'), Password)

WebUI.click(findTestObject('Page_Login/btn_Login'))

// Verify: hệ thống chuyển sang trang danh sách sản phẩm
WebUI.verifyElementPresent(findTestObject('Page_Products/lbl_Products'), 5)

WebUI.closeBrowser()

