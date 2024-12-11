// ✅ استيرادات منظمة ومختصرة 
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import org.openqa.selenium.WebElement as WebElement
import java.util.Random as Random

// 📘 تسجيل الدخول
void login() {
	WebUI.openBrowser('https://www.joacademy.com/login')
	WebUI.maximizeWindow()
	WebUI.click(findTestObject('login/Page_- joacademy.com/by email button'))
	WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')
	WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__password'), '123456')
	WebUI.click(findTestObject('login/Page_- joacademy.com/button_join'))
	WebUI.click(findTestObject('Object Repository/E-school/Page_- joacademy.com/E-school'))
}

// 📘 اختيار فصل عشوائي
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
		throw new Exception('❌ No class buttons were found.')
	}
}

// 📘 اختيار فصل دراسي عشوائي
void selectRandomSemester() {
	List<TestObject> semesterOptions = Arrays.asList(
		findTestObject('Object Repository/Check for 2 semesteres/Page_-   -   - joacademy.com/semester one'),
		findTestObject('Object Repository/Check for 2 semesteres/Page_-   -   - joacademy.com/semester 2')
	)

	Random random = new Random()
	TestObject selectedSemester = semesterOptions.get(random.nextInt(semesterOptions.size()))
	WebUI.click(selectedSemester)
	WebUI.comment('✅ Successfully clicked on a random semester button.')
}

// 📘 اختيار مادة والتحقق من المحتوى
boolean selectValidMaterial() {
	List<WebElement> materialButtons = WebUI.findWebElements(findTestObject('Object Repository/random material and semester/Page_-   -   - joacademy.com/random material'), 30)
	
	if (!materialButtons.isEmpty()) {
		Random random = new Random()
		WebElement randomMaterialButton = materialButtons.get(random.nextInt(materialButtons.size()))
		randomMaterialButton.click()
		WebUI.comment('✅ Clicked on a random material.')
		WebUI.delay(10)
		
		// التحقق من وجود المحتوى
		if (WebUI.verifyElementVisible(findTestObject('book index/Page_-   -     -   - joacademy.com/No content'), FailureHandling.OPTIONAL)) {
			throw new Exception('❌ No content found. Closing the browser.')
		} else {
			WebUI.comment('✅ Valid material selected successfully.')
			return true
		}
	} else {
		throw new Exception('❌ No material buttons found.')
	}
}

// 📘 اختيار درس عشوائي
void selectRandomLesson() {
WebUI.click(findTestObject('book index/Page_-   -   -   - joacademy.com/verify unit'))
WebUI.delay(5)

	List<WebElement> lessons = WebUI.findWebElements(findTestObject('Object Repository/book index/Page_-   -   -   - joacademy.com/lessons'), 10)
	
	if (!lessons.isEmpty()) {
		Random random = new Random()
		WebElement randomLesson = lessons.get(random.nextInt(lessons.size()))
		randomLesson.click()
		WebUI.comment('✅ Successfully clicked on a random lesson.')
	} else {
		throw new Exception('❌ No lessons found to select.')
	}
	
	WebUI.delay(10)
	
	// التحقق من العناصر المطلوبة في الدرس
	WebUI.verifyElementVisible(findTestObject('Object Repository/verify details lesson/explanation'), FailureHandling.OPTIONAL)
	WebUI.verifyElementVisible(findTestObject('Object Repository/verify details lesson/abstract-sheet'), FailureHandling.OPTIONAL)
	WebUI.verifyElementVisible(findTestObject('Object Repository/verify details lesson/work-sheets'), FailureHandling.OPTIONAL)
	WebUI.verifyElementVisible(findTestObject('Object Repository/verify details lesson/lesson-question'), FailureHandling.OPTIONAL)
	
	// التحقق من النصوص
	WebUI.verifyTextPresent('الشرح', false, FailureHandling.OPTIONAL)
	WebUI.verifyTextPresent('الملخص', false, FailureHandling.OPTIONAL)
	WebUI.verifyTextPresent('أوراق العمل', false, FailureHandling.OPTIONAL)
	WebUI.verifyTextPresent('حل اسئلة الدرس', false, FailureHandling.OPTIONAL)
}

// 📘 تنفيذ الخطوات بالترتيب
try {
	login()
	selectRandomClass()
	selectRandomSemester()
	selectValidMaterial()
	selectRandomLesson()

} catch (Exception e) {
	WebUI.comment('⚠️ Error: ' + e.getMessage())
} finally {
	WebUI.comment('🛑 Closing the browser.')
	WebUI.closeBrowser()
}
