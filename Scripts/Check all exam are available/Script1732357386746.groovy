import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.util.Arrays as Arrays
import org.openqa.selenium.WebElement as WebElement
import java.util.List as List
import java.util.Random as Random
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.exception.StepFailedException as StepFailedException

void login() {
    WebUI.openBrowser('https://www.joacademy.com/login')
    WebUI.maximizeWindow()

    WebUI.click(findTestObject('login/Page_- joacademy.com/by email button'))
    WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')
    WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__password'), '123456')
    WebUI.click(findTestObject('login/Page_- joacademy.com/button_join'))
    // E-school
    WebUI.click(findTestObject('Object Repository/E-school/Page_- joacademy.com/E-school'))
}

void selectRandomClass() {
    List<TestObject> classButtons = Arrays.asList(
        findTestObject('Object Repository/clases 1234/Page_- joacademy.com/class1'), 
        findTestObject('Object Repository/clases 1234/Page_- joacademy.com/class 2'),
        findTestObject('Object Repository/clases 1234/Page_- joacademy.com/class 4'), 
        findTestObject('Object Repository/clases 1234/Page_- joacademy.com/class 3')
    )

    if (!classButtons.isEmpty()) {
        Random random = new Random()
        TestObject randomClassButton = classButtons.get(random.nextInt(classButtons.size()))
        try {
            WebUI.click(randomClassButton)
            WebUI.comment('Passed: A random class button was clicked successfully.')
        } catch (Exception e) {
            WebUI.comment('Failed: Error occurred while trying to click the class button. Error: ' + e.getMessage())
        }
    } else {
        WebUI.comment('Failed: No class buttons were found.')
    }
}

void selectRandomSemester() {
    List<TestObject> semesterOptions = Arrays.asList(
        findTestObject('Object Repository/Check for 2 semesteres/Page_-   -   - joacademy.com/semester one'),
        findTestObject('Object Repository/Check for 2 semesteres/Page_-   -   - joacademy.com/semester 2')
    )

    try {
        Random random = new Random()
        TestObject selectedSemester = semesterOptions.get(random.nextInt(semesterOptions.size()))
        WebUI.comment('Trying to click on a random semester button.')
        WebUI.click(selectedSemester)
        WebUI.comment('Passed: A random semester button was clicked successfully.')
    } catch (Exception e) {
        WebUI.comment('Failed: Error occurred while clicking a semester button. Error: ' + e.getMessage())
    }
}

boolean selectValidMaterial() {
    List<WebElement> materialButtons = WebUI.findWebElements(findTestObject('Object Repository/random material and semester/Page_-   -   - joacademy.com/random material'), 30)

    if (!materialButtons.isEmpty()) {
        Random random = new Random()
        WebElement randomMaterialButton = materialButtons.get(random.nextInt(materialButtons.size()))
        WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(randomMaterialButton))
        WebUI.delay(2)
        randomMaterialButton.click()
		WebUI.delay(10)
        if (WebUI.verifyElementVisible(findTestObject('book index/Page_-   -     -   - joacademy.com/No content'), FailureHandling.OPTIONAL)) {
            WebUI.comment('No content found. Closing the browser and retrying...')
            WebUI.closeBrowser()
            WebUI.delay(3)  
            return false 
        } else {
            WebUI.comment('Passed: A valid material was selected.')
            WebUI.takeScreenshot()
            return true 
        }
    } else {
        WebUI.comment('Failed: No material buttons were found.')
        return false
    }
}

// Step to execute everything in sequence and retry if no content is found
try {
	boolean validMaterialSelected = false
	while (!validMaterialSelected) {
		login()
		selectRandomClass()
		selectRandomSemester()
		validMaterialSelected = selectValidMaterial()
	}
	WebUI.delay(5)
	
	WebUI.click(findTestObject('Object Repository/exma material/Page_-   -  -   - joacademy.com/button exma material'))
	
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/exma material/Page_-   -  -   - joacademy.com/verify cart exma'))) {
		WebUI.comment('Passed: The exam page is visible.')
		WebUI.takeScreenshot()
		
	} else {
		WebUI.comment('Failed: The exam page is not visible.')
	}
	
} finally {
	WebUI.closeBrowser()
}
