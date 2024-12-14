import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import java.util.Random as Random

// 🔐 Login to the website
WebUI.openBrowser('https://www.joacademy.com/login')
WebUI.maximizeWindow()

WebUI.click(findTestObject('login/Page_- joacademy.com/by email button'))
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__password'), '123456')
WebUI.click(findTestObject('login/Page_- joacademy.com/button_join'))

// 📘 Navigate to the E-school section
WebUI.click(findTestObject('E-school/Page_- joacademy.com/E-school'))

// 🟢 List of class buttons to choose from randomly
List<TestObject> classButtons = Arrays.asList(
	findTestObject('Object Repository/clases 1234/Page_- joacademy.com/class1'),
	findTestObject('Object Repository/clases 1234/Page_- joacademy.com/class 2'),
	findTestObject('Object Repository/clases 1234/Page_- joacademy.com/class 3'),
	findTestObject('Object Repository/clases 1234/Page_- joacademy.com/class 4')
)

if (!classButtons.isEmpty()) {
	Random random = new Random()
	TestObject randomClassButton = classButtons.get(random.nextInt(classButtons.size()))
	try {
		// 🟢 Click a random class button
		WebUI.click(randomClassButton)
		WebUI.comment('✅ Successfully clicked on a random class button.')
		
		// 📷 Take a screenshot for confirmation
		WebUI.takeScreenshot()
		
	} catch (Exception e) {
		WebUI.comment('❌ Failed: An error occurred while trying to click the random class button. Error: ' + e.getMessage())
	} finally {
		// ❌ Close the browser
		WebUI.closeBrowser()
	}
} else {
	// ❌ No class buttons found
	WebUI.comment('❌ Failed: No class buttons were found.')
	WebUI.closeBrowser()
}
