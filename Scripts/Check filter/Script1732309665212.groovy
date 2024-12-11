import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import java.util.Random as Random
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys

// open browser
WebUI.openBrowser('https://www.joacademy.com/login')

WebUI.maximizeWindow()

// login
WebUI.click(findTestObject('Object Repository/login/Page_- joacademy.com/by email button'))

WebUI.sendKeys(findTestObject('Object Repository/login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')

WebUI.sendKeys(findTestObject('Object Repository/login/Page_- joacademy.com/input__password'), '123456')

WebUI.click(findTestObject('Object Repository/login/Page_- joacademy.com/button_join'))

// اE-school
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

List<WebElement> materialButtons = WebUI.findWebElements(findTestObject('Object Repository/random material and semester/Page_-   -   - joacademy.com/random material'), 30)

if (materialButtons != null && materialButtons.size() > 0) {
	Random random = new Random()
	WebUI.comment("Material buttons found: " + materialButtons.size())
	
	WebElement randomMaterialButton = materialButtons.get(random.nextInt(materialButtons.size()))
	
	try {
		if (randomMaterialButton.isDisplayed() && randomMaterialButton.isEnabled()) {
			WebUI.comment("Trying to click a random material button.")
			randomMaterialButton.click()
			WebUI.comment("Passed: A random material button was clicked successfully.")
		} else {
			WebUI.comment("Failed: The selected material button is not clickable.")
		}
	} catch (Exception e) {
		WebUI.comment("Failed: Error occurred while trying to click the material button. Error: " + e.getMessage())
	}
} else {
	WebUI.comment("Failed: No material buttons were found.")
}

WebUI.click(findTestObject('Object Repository/material file/Page_-   -  -   - joacademy.com (1)/materila file button'))


// Set text for the input field
WebUI.setText(findTestObject('Object Repository/material file/Page_-   -  -   - joacademy.com (1)/input text'), 'علوم / الصف الاول')

// Verify the visibility of "verify file2"
// ✅ التحقق من النص وظهور الملف
boolean isTextVisible = WebUI.verifyElementVisible(findTestObject('Object Repository/material file/Page_-   -  -   - joacademy.com (1)/verify text not found file'), FailureHandling.OPTIONAL)
boolean isFile2Visible = WebUI.verifyElementVisible(findTestObject('Object Repository/material file/Page_-   -  -   - joacademy.com (1)/verify file2'), FailureHandling.OPTIONAL)

if (isTextVisible || isFile2Visible) {
    WebUI.comment('✅ Passed: At least one of the conditions is met (either "Verify text not found file" or "Verify file2" is visible).')
    WebUI.takeScreenshot()
    WebUI.closeBrowser()
} else {
    WebUI.comment('❌ Failed: Neither "Verify text not found file" nor "Verify file2" is visible.')
    WebUI.takeScreenshot()
    WebUI.closeBrowser()
}


