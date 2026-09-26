import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement as WebElement

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

// Login
WebUI.setText(findTestObject('Page_Login/input_Username'), Username)

WebUI.setText(findTestObject('Page_Login/input_Password'), Password)

WebUI.click(findTestObject('Page_Login/btn_Login'))

// --- Chọn Sort Z→A ---
WebUI.selectOptionByValue(findTestObject('Page_Products/select_Sort'), 'za', false)

// Lấy danh sách sản phẩm sau khi chọn Z→A
List<WebElement> elementsZA = WebUI.findWebElements(findTestObject('Page_Products/lbl_ProductNames'), 10)

List<String> productNamesZA = elementsZA.collect({ 
        it.getText()
    })

// Kiểm tra có đủ 6 sản phẩm
assert productNamesZA.size() == 6 : 'Không đủ 6 sản phẩm'

// Kiểm tra thứ tự Z→A
List<String> sortedZA = new ArrayList(productNamesZA)

Collections.sort(sortedZA, Collections.reverseOrder())

assert productNamesZA == sortedZA : 'Danh sách chưa được sort đúng Z→A'

// --- Chọn lại Sort A→Z ---
WebUI.selectOptionByValue(findTestObject('Page_Products/select_Sort'), 'az', false)

// Lấy danh sách sản phẩm sau khi chọn lại A→Z
List<WebElement> elementsAZ = WebUI.findWebElements(findTestObject('Page_Products/lbl_ProductNames'), 10)

List<String> productNamesAZ = elementsAZ.collect({ 
        it.getText()
    })

// Kiểm tra có đủ 6 sản phẩm
assert productNamesAZ.size() == 6 : 'Không đủ 6 sản phẩm'

// Kiểm tra thứ tự A→Z
List<String> sortedAZ = new ArrayList(productNamesAZ)

Collections.sort(sortedAZ)

assert productNamesAZ == sortedAZ : 'Danh sách chưa quay lại đúng A→Z'

