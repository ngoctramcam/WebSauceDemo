import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement as WebElement

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

// Login
WebUI.setText(findTestObject('Page_Login/input_Username'), Username)

WebUI.setText(findTestObject('Page_Login/input_Password'), Password)

WebUI.click(findTestObject('Page_Login/btn_Login'))

// --- Sort Low→High ---
WebUI.selectOptionByValue(findTestObject('Page_Products/select_Sort'), 'lohi', false)

WebUI.waitForElementVisible(findTestObject('Page_Products/lbl_ProductPrices'), 10)

List<WebElement> elementsLowHigh = WebUI.findWebElements(findTestObject('Page_Products/lbl_ProductPrices'), 10)

List<Double> pricesLowHigh = elementsLowHigh.collect({ 
        it.getText().replace('$', '').toDouble()
    })

println('Giá sản phẩm (Low→High): ' + pricesLowHigh)

assert pricesLowHigh.size() == 6

List<Double> sortedLowHigh = new ArrayList(pricesLowHigh)

Collections.sort(sortedLowHigh)

assert pricesLowHigh == sortedLowHigh : 'Danh sách chưa được sort đúng Low→High'

// --- Sort High→Low ---
WebUI.selectOptionByValue(findTestObject('Page_Products/select_Sort'), 'hilo', false)

WebUI.waitForElementVisible(findTestObject('Page_Products/lbl_ProductPrices'), 10)

List<WebElement> elementsHighLow = WebUI.findWebElements(findTestObject('Page_Products/lbl_ProductPrices'), 10)

List<Double> pricesHighLow = elementsHighLow.collect({ 
        it.getText().replace('$', '').toDouble()
    })

println('Giá sản phẩm (High→Low): ' + pricesHighLow)

assert pricesHighLow.size() == 6

List<Double> sortedHighLow = new ArrayList(pricesHighLow)

Collections.sort(sortedHighLow, Collections.reverseOrder())

assert pricesHighLow == sortedHighLow : 'Danh sách chưa được sort đúng High→Low'

WebUI.closeBrowser()

