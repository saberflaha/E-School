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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import java.util.Random as Random
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
	WebUI.delay(3) // إضافة وقت انتظار قبل النقر
	WebUI.click(findTestObject('login/Page_- joacademy.com/by email button'))
	WebUI.delay(3) // إضافة وقت انتظار بعد النقر
	WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')
	WebUI.delay(3) // إضافة وقت انتظار بعد الكتابة
	WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__password'), '123456')
	WebUI.delay(3) // إضافة وقت انتظار بعد الكتابة
	WebUI.click(findTestObject('login/Page_- joacademy.com/button_join'))
	WebUI.delay(3) // إضافة وقت انتظار بعد النقر
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
		WebUI.delay(3) // إضافة وقت انتظار قبل النقر
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

	WebUI.delay(3) // إضافة وقت انتظار قبل النقر
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
		WebUI.delay(3) // إضافة وقت انتظار قبل النقر
		randomMaterialButton.click()
		WebUI.delay(3) // إضافة وقت انتظار بعد النقر
		if (WebUI.verifyElementVisible(findTestObject('book index/Page_-   -     -   - joacademy.com/No content'), FailureHandling.OPTIONAL)) {
			WebUI.comment('رسالة: لا يوجد محتوى متوفر لهذه المادة.')
			WebUI.takeScreenshot() // التقاط لقطة شاشة كمرجع
			WebUI.closeBrowser()
			return true // إنهاء العملية مع عرض الرسالة
		} else {
			WebUI.comment('Passed: تم اختيار مادة صالحة.')
			WebUI.takeScreenshot() // التقاط لقطة شاشة كمرجع
			return true // المادة صالحة
		}
	} else {
		WebUI.comment('Failed: لم يتم العثور على أي أزرار مواد.')
		WebUI.closeBrowser()
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

	// بعد اختيار المادة الصالحة، قم بتنفيذ الخطوات الإضافية
	WebUI.click(findTestObject('Object Repository/lesson free/Page_-   -  -   - joacademy.com/free-lessons'))

	WebUI.delay(3) // إضافة وقت انتظار قبل التحقق
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/lesson free/Page_-   -  -   - joacademy.com/Free lesson card'))) {
		WebUI.comment('Pass: Free lesson card is visible.')
		
	} else {
		WebUI.verifyElementPresent(findTestObject('Object Repository/lesson free/Page_-   -  -   - joacademy.com/verify not fond viedo'), 10, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.comment('Fail: Free lesson card is not visible.')
	}
	WebUI.click(findTestObject('Object Repository/lesson free/Page_-   -  -   - joacademy.com/click on the lesson free'))
	WebUI.comment("Passed: Successfully clicked on the free lesson and closed the modal.")
	WebUI.takeScreenshot()
} finally {
	WebUI.closeBrowser()
}
