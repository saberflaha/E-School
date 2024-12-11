import javax.wsdl.Import as Import
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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import java.util.List as List
import java.util.Random as Random
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import org.openqa.selenium.WebElement as WebElement
import java.util.Random as Random

void login() {
	WebUI.openBrowser('https://www.joacademy.com/login')
	WebUI.maximizeWindow()

	WebUI.click(findTestObject('login/Page_- joacademy.com/by email button'))
	WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')
	WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__password'), '123456')
	WebUI.click(findTestObject('login/Page_- joacademy.com/button_join'))
	
	// Navigate to E-school
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
		WebUI.click(randomClassButton)
		WebUI.comment('✅ Successfully clicked on a random class button.')
	} else {
		WebUI.comment('❌ No class buttons were found.')
	}
}

void selectRandomSemester() {
	List<TestObject> semesterOptions = Arrays.asList(
		findTestObject('Object Repository/Check for 2 semesteres/Page_-   -   - joacademy.com/semester one'),
		findTestObject('Object Repository/Check for 2 semesteres/Page_-   -   - joacademy.com/semester 2')
	)

	Random random = new Random()
	TestObject selectedSemester = semesterOptions.get(random.nextInt(semesterOptions.size()))
	WebUI.comment('🔄 Trying to click on a random semester button.')
	WebUI.click(selectedSemester)
	WebUI.comment('✅ Successfully clicked on a random semester button.')
}

void selectValidMaterial() {
	List<WebElement> materialButtons = WebUI.findWebElements(findTestObject('Object Repository/random material and semester/Page_-   -   - joacademy.com/random material'), 30)

	if (!materialButtons.isEmpty()) {
		Random random = new Random()
		WebElement randomMaterialButton = materialButtons.get(random.nextInt(materialButtons.size()))
		WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(randomMaterialButton))
		WebUI.delay(2)
		randomMaterialButton.click()
		WebUI.delay(10)
		
		if (WebUI.verifyElementVisible(findTestObject('book index/Page_-   -     -   - joacademy.com/No content'), FailureHandling.OPTIONAL)) {
			WebUI.comment('❌ No content found. Closing the browser.')
			throw new Exception('No content found.')
		} else {
			WebUI.comment('✅ Successfully selected valid material.')
			WebUI.takeScreenshot()
		}
	} else {
		WebUI.comment('❌ No material buttons were found.')
		throw new Exception('No material buttons found.')
	}
}

try {
	login()
	selectRandomClass()
	selectRandomSemester()
	selectValidMaterial()

	WebUI.delay(10)
	
	// **Download file process**
	WebUI.click(findTestObject('Object Repository/material file/Page_-   -  -   - joacademy.com (1)/materila file button'))
	WebUI.delay(10)
	WebUI.click(findTestObject('Object Repository/Download file without login/Page_-   -  -   - joacademy.com/button_Download file'))

	if (WebUI.verifyElementVisible(findTestObject('downloade file/Page_-   -  -   - joacademy.com/Message The file has been uploaded successfully'), 
		FailureHandling.OPTIONAL)) {
		WebUI.comment('✅ Pass: The file upload message is visible.')
	} else {
		WebUI.comment('❌ Fail: The file upload message is not visible.')
	}

	WebUI.takeScreenshot()

} catch (Exception e) {
	WebUI.comment('⚠️ Error: ' + e.getMessage())
} finally {
	WebUI.comment('🛑 Closing the browser.')
	WebUI.closeBrowser()
}

