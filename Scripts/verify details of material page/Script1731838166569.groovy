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

if (semesterButtons != null && semesterButtons.size() > 0) {
	Random random = new Random()
	WebUI.comment("Semester buttons found: " + semesterButtons.size())
	
	WebElement randomSemesterButton = semesterButtons.get(random.nextInt(semesterButtons.size()))
	
	try {
		if (randomSemesterButton.isDisplayed() && randomSemesterButton.isEnabled()) {
			WebUI.comment("Trying to click a random semester button.")
			randomSemesterButton.click()
			WebUI.comment("Passed: A random semester button was clicked successfully.")
		} else {
			WebUI.comment("Failed: The selected semester button is not clickable.")
		}
	} catch (Exception e) {
		WebUI.comment("Failed: Error occurred while trying to click the semester button. Error: " + e.getMessage())
	}
} else {
	WebUI.comment("Failed: No semester buttons were found.")
}

// Randomly click a material and verify "No content"
boolean isValid = false
while (!isValid) {
	List<WebElement> materialButtons = WebUI.findWebElements(findTestObject('Object Repository/random material and semester/Page_-   -   - joacademy.com/random material'), 30)

	if (materialButtons.size() > 0) {
		Random random3 = new Random()
		WebElement randomMaterialButton = materialButtons.get(random3.nextInt(materialButtons.size()))
		
		WebUI.waitForElementClickable(findTestObject('Object Repository/random material and semester/Page_-   -   - joacademy.com/random material'), 10)
		
		WebUI.comment('Trying to click a random material button.')
		WebUI.delay(2)
		WebUI.executeJavaScript("window.scrollBy(0, 500);", null)
		randomMaterialButton.click()
		WebUI.comment('Clicked a random material button.')
		
		// Check if "No content" is visible
		if (WebUI.verifyElementVisible(findTestObject('book index/Page_-   -     -   - joacademy.com/No content'), FailureHandling.OPTIONAL)) {
			WebUI.comment('No content found. Retrying with another material...')
		} else {
			isValid = true
			WebUI.comment('Passed: A valid material was selected.')
			WebUI.takeScreenshot()
		}
	} else {
		WebUI.comment('Failed: No material buttons were found.')
		break
	}
}
WebUI.takeScreenshot()
WebUI.verifyElementText(findTestObject('material page/Page_-   -  -   - joacademy.com/button school'), 'المدرسة')
WebUI.comment('Verification passed: The text "المدرسة" is correct.')

WebUI.verifyElementText(findTestObject('material page/Page_-   -  -   - joacademy.com/button Book Index'), 'فهرس الكتاب')
WebUI.comment('Verification passed: The text "فهرس الكتاب" is correct.')

WebUI.verifyElementText(findTestObject('material page/Page_-   -  -   - joacademy.com/button exma material'),'اختبارات المادة')

WebUI.comment('Verification passed: The text "ملفات المادة" is correct.')

WebUI.verifyElementText(findTestObject('material page/Page_-   -  -   - joacademy.com/button lesson free'), 'دروس مجانية')
WebUI.comment('Verification passed: The text "دروس مجانية" is correct.')

WebUI.verifyElementText(findTestObject('material page/Page_-   -  -   - joacademy.com/button material file'), 'ملفات المادة')
WebUI.comment('Verification passed: The text "اختبارات المادة" is correct.')



