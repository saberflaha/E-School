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
// open browser
import org.openqa.selenium.WebElement as WebElement
import java.util.Random as Random

// Open browser and navigate to the login page
WebUI.openBrowser('https://www.joacademy.com/login')

WebUI.maximizeWindow()

try {
    // Perform login
    WebUI.click(findTestObject('Object Repository/login/Page_- joacademy.com/by email button'))

    WebUI.setText(findTestObject('Object Repository/login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')

    WebUI.setText(findTestObject('Object Repository/login/Page_- joacademy.com/input__password'), '123456')

    WebUI.click(findTestObject('Object Repository/login/Page_- joacademy.com/button_join'))

    // Navigate to the E-school page
    WebUI.click(findTestObject('Object Repository/E-school/Page_- joacademy.com/E-school'))

    // Select a random class
    interactWithRandomElement('Object Repository/E-school/Page_- joacademy.com/class button', 'Class buttons')

    // Select a random semester
    interactWithRandomElement('Object Repository/random material and semester/Page_-   -   - joacademy.com/random semester', 
        'Semester buttons')

    // Select a random material
    interactWithRandomElement('Object Repository/random material and semester/Page_-   -   - joacademy.com/random material', 
        'Material buttons')

    // Open the material and share the link on social media
    WebUI.click(findTestObject('Object Repository/material file/Page_-   -  -   - joacademy.com (1)/materila file button'))

    WebUI.click(findTestObject('Object Repository/Check if you can share the link on social media/Page_-   -  -   - joacademy.com/share button'))

    WebUI.verifyElementVisible(findTestObject('Object Repository/Check if you can share the link on social media/Page_-   -  -   - joacademy.com/share the link on social media'))

    WebUI.takeScreenshot()

    // Copy the link and verify the text
    WebUI.click(findTestObject('Object Repository/Check if you can share the link on social media/Page_-   -  -   - joacademy.com/copy link share button'))

    WebUI.verifyElementText(findTestObject('Object Repository/Check if you can share the link on social media/Page_-   -  -   - joacademy.com/copy link successfully'), 
        'تم النسخ بنجاح')

    WebUI.takeScreenshot()
}
catch (Exception e) {
    WebUI.comment('Error occurred: ' + e.getMessage())
} 
finally { 
    // Close the browser
    WebUI.closeBrowser()
}
/**
 * Function to select a random element from a list and interact with it.
 * 
 * @param objectPath Path of the object in the Object Repository
 * @param elementDescription Description of the element (used for logging)
 */

void interactWithRandomElement(String objectPath, String elementDescription) {
    List<WebElement> elements = WebUI.findWebElements(findTestObject(objectPath), 30)

    if ((elements != null) && (elements.size() > 0)) {
        Random random = new Random()

        WebElement randomElement = elements.get(random.nextInt(elements.size()))

        try {
            if (randomElement.isDisplayed() && randomElement.isEnabled()) {
                WebUI.comment("Trying to click a random $elementDescription.")

                randomElement.click()

                WebUI.comment("Passed: A random $elementDescription was clicked successfully.")
            } else {
                WebUI.comment("Failed: The selected $elementDescription is not clickable.")
            }
        }
        catch (Exception e) {
            WebUI.comment("Failed: Error occurred while trying to click the $elementDescription. Error: " + e.getMessage())
        } 
    } else {
        WebUI.comment("Failed: No $elementDescription were found.")
    }
}
WebUI.closeBrowser()

