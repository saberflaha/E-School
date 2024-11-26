import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import java.util.Random as Random

WebUI.openBrowser('https://www.joacademy.com/login')
WebUI.maximizeWindow()

WebUI.click(findTestObject('login/Page_- joacademy.com/by email button'))
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__password'), '123456')
WebUI.click(findTestObject('login/Page_- joacademy.com/button_join'))

WebUI.click(findTestObject('E-school/Page_- joacademy.com/E-school'))


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

List<WebElement> semesterButtons = WebUI.findWebElements(findTestObject('Object Repository/random material and semester/Page_-   -   - joacademy.com/random semester'), 30)

if (semesterButtons.size() > 0) {
    Random random2 = new Random()
    WebElement randomSemesterButton = semesterButtons.get(random2.nextInt(semesterButtons.size()))
    
    WebUI.comment("Trying to click a random semester button.")
    randomSemesterButton.click()
    WebUI.comment("Passed: A random semester button was clicked successfully.")
} else {
    WebUI.comment("Failed: No semester buttons were found.")
}

List<WebElement> materialButtons = WebUI.findWebElements(findTestObject('Object Repository/random material and semester/Page_-   -   - joacademy.com/random material'), 30)

if (materialButtons.size() > 0) {
    Random random3 = new Random()
    WebElement randomMaterialButton = materialButtons.get(random3.nextInt(materialButtons.size()))
    
    WebUI.comment("Trying to click a random material button.")
    randomMaterialButton.click()
    WebUI.comment("Passed: A random material button was clicked successfully.")
	WebUI.takeScreenshot()
	
} else {
    WebUI.comment("Failed: No material buttons were found.")
}

WebUI.closeBrowser()
