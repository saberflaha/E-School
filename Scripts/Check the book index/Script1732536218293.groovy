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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
WebUI.openBrowser('https://www.joacademy.com/login')
WebUI.maximizeWindow()
WebUI.click(findTestObject('login/Page_- joacademy.com/by email button'))
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__password'), '123456')
WebUI.click(findTestObject('login/Page_- joacademy.com/button_join'))

//   E-school
WebUI.click(findTestObject('Object Repository/E-school/Page_- joacademy.com/E-school'))


List<TestObject> classButtons = Arrays.asList(
	findTestObject('Object Repository/clases 1234/Page_- joacademy.com/class1'),
	findTestObject('Object Repository/clases 1234/Page_- joacademy.com/class 2'),
	findTestObject('Object Repository/clases 1234/Page_- joacademy.com/class 4'),
	findTestObject('Object Repository/clases 1234/Page_- joacademy.com/class 3')
)

if (classButtons != null && classButtons.size() > 0) {
	Random random = new Random()
	
	TestObject randomClassButton = classButtons.get(random.nextInt(classButtons.size()))
	
	try {
		WebUI.click(randomClassButton)
		WebUI.comment("Passed: A random class button was clicked successfully.")
	} catch (Exception e) {
		WebUI.comment("Failed: Error occurred while trying to click the class button. Error: " + e.getMessage())
	}
} else {
	WebUI.comment("Failed: No class buttons were found.")
}
def selectRandomButton(testObjectPath, label) {
    List<WebElement> buttons = WebUI.findWebElements(findTestObject(testObjectPath), 30)
    if (buttons != null && buttons.size() > 0) {
        Random random = new Random()
        WebUI.comment("${label} buttons found: " + buttons.size())
        WebElement randomButton = buttons.get(random.nextInt(buttons.size()))
        try {
            if (randomButton.isDisplayed() && randomButton.isEnabled()) {
                WebUI.comment("Trying to click a random ${label} button.")
                randomButton.click()
                WebUI.comment("Passed: A random ${label} button was clicked successfully.")
            } else {
                WebUI.comment("Failed: The selected ${label} button is not clickable.")
            }
        } catch (Exception e) {
            WebUI.comment("Failed: Error occurred while trying to click the ${label} button. Error: " + e.getMessage())
        }
    } else {
        WebUI.comment("Failed: No ${label} buttons were found.")
    }
}

    selectRandomButton('Object Repository/random material and semester/Page_-   -   - joacademy.com/random semester', 'semester')
    selectRandomButton('Object Repository/random material and semester/Page_-   -   - joacademy.com/random material', 'material')

   WebUI.waitForElementVisible(findTestObject('Object Repository/book index/Page_-   -   -   - joacademy.com/book index'), 3)
   WebUI.click(findTestObject('Object Repository/book index/Page_-   -   -   - joacademy.com/book index'))
   

   boolean uint= WebUI.verifyElementVisible(findTestObject('book index/Page_-   -   -   - joacademy.com/verify uint'))
   if(uint) {	println('Pass')}else {	println('Fail')}
   
   WebUI.takeScreenshot()
   
   WebUI.click(findTestObject('book index/Page_-   -   -   - joacademy.com/verify uint'))
   
   WebUI.takeScreenshot()
   
 boolean lesones=  WebUI.verifyElementVisible(findTestObject('book index/Page_-   -   -   - joacademy.com/lessons'))
 if(lesones) {	println('Pass')}else {	println('Fail')}
   WebUI.closeBrowser()