import javax.wsdl.Import
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import java.util.Random as Random
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
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

	WebUI.waitForElementVisible(findTestObject('Object Repository/book index/Page_-   -   -   - joacademy.com/book index'), 3)
	WebUI.click(findTestObject('Object Repository/book index/Page_-   -   -   - joacademy.com/book index'))
 
	WebUI.takeScreenshot()
	
	WebUI.click(findTestObject('book index/Page_-   -   -   - joacademy.com/verify uint'))
	
	WebUI.takeScreenshot()
	
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/book index/Page_-   -  -   - joacademy.com/verify button_ uint questiona'), FailureHandling.OPTIONAL)) {
		WebUI.comment('تم العثور على العنصر المحدد: "verify button uint questiona".')
	} else {
		WebUI.comment('العنصر غير موجود. سيتم متابعة باقي الخطوات...')
	
		WebUI.closeBrowser()
	}
	
	  
	WebUI.closeBrowser()

} catch (Exception e) {
	WebUI.comment('⚠️ Error: ' + e.getMessage())
} finally {
	WebUI.comment('🛑 Closing the browser.')
	WebUI.closeBrowser()
}
	
 
