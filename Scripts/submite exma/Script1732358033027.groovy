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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import java.util.Random as Random
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
WebUI.openBrowser('https://www.joacademy.com/login')
WebUI.maximizeWindow()
WebUI.click(findTestObject('login/Page_- joacademy.com/by email button'))
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__password'), '123456')
WebUI.click(findTestObject('login/Page_- joacademy.com/button_join'))

// E-school
WebUI.click(findTestObject('Object Repository/E-school/Page_- joacademy.com/E-school'))
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/class 1'))

WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/semesster 1'))

WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/material 1'))

WebUI.waitForElementVisible(findTestObject('Object Repository/exma material/Page_-   -  -   - joacademy.com/button exma material'), 3)
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -  -   - joacademy.com/button exma material'))

List<WebElement> startExamButtons = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/start exma 111'), 10)
if (startExamButtons != null && !startExamButtons.isEmpty()) {
    Random random = new Random()
    int randomIndex = random.nextInt(startExamButtons.size())
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(startExamButtons.get(randomIndex)))
} else {
    WebUI.comment('No start exam buttons found!')
    return
}

WebUI.delay(5)
// Switch to the second window (index starts at 0)
WebUI.switchToWindowIndex(1)

// Define TestObject for selecting questions
TestObject questionsSelector = new TestObject('DynamicQuestions')
questionsSelector.addProperty('css', ConditionType.EQUALS, 'div.tw-w-full .tw-border-slate-200.tw-p-5.tw-rounded-lg.tw-shadow-sm.tw-text-slate-950')

// Find all questions
List<WebElement> questions = WebUiCommonHelper.findWebElements(questionsSelector, 10)

if (questions != null && !questions.isEmpty()) {
	int numOfQuestions = questions.size()
	WebUI.comment("Number of questions found: " + numOfQuestions)

	Random random = new Random()

	for (int i = 0; i < numOfQuestions; i++) {
		try {
			// Create dynamic CSS selector for each question
			String cssSelector = "div.tw-flex.tw-gap-1.tw-items-center.tw-rounded-md .tw-cursor-pointer.tw-ring-offset-white.tw-rounded-full";
			TestObject questionTestObject = new TestObject("DynamicObject" + i)
			questionTestObject.addProperty('css', ConditionType.EQUALS, cssSelector)

			// Verify element presence and select a random answer
			if (WebUI.verifyElementPresent(questionTestObject, 10, FailureHandling.OPTIONAL)) {
				List<WebElement> answerOptions = WebUiCommonHelper.findWebElements(questionTestObject, 10)
				if (answerOptions != null && !answerOptions.isEmpty()) {
					// Randomly select an answer
					int randomIndex = random.nextInt(answerOptions.size())
					WebElement randomAnswer = answerOptions.get(randomIndex)

					// Click the randomly selected answer
					WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(randomAnswer))
					WebUI.comment("Answered question " + (i + 1) + " with option: " + (randomIndex + 1))
				} else {
					WebUI.comment("No answer options found for question " + (i + 1))
				}
			} else {
				WebUI.comment("Question " + (i + 1) + " is not present.")
			}
		} catch (Exception e) {
			WebUI.comment("An error occurred while processing question " + (i + 1) + ". Error: " + e.getMessage())
		}
	}
} else {
	WebUI.comment("No questions were found.")
}


// Wait for the "Finish Exam" button to appear and click it
WebUI.waitForElementVisible(findTestObject("Object Repository/submet exam/Page_- joacademy.com/finsh exma"), 10)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/submet exam/Page_- joacademy.com/finsh exma'), 10, FailureHandling.OPTIONAL)) {
    WebUI.scrollToElement(findTestObject('Object Repository/submet exam/Page_- joacademy.com/finsh exma'), 0)
    WebUI.click(findTestObject('Object Repository/submet exam/Page_- joacademy.com/finsh exma'))
	
	boolean Error_when_completing_the_exam =  WebUI.verifyElementText(findTestObject('Object Repository/book index/Page_-   -  -   - joacademy.com/verify button_ uint questiona'),'جميع الحقول مطلوبة')
	if(Error_when_completing_the_exam) {println('Pass')}else {println('Fail')}
	  WebUI.closeBrowser()
   
    WebUI.comment("Clicked on the 'Finish Exam' button.")
} else {
    WebUI.comment("'Finish Exam' button is not present.")
}

// Take a screenshot for verification
WebUI.takeScreenshot()
//WebUI.closeBrowser()

