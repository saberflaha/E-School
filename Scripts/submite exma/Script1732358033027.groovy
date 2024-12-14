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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory

// 🔐  login
WebUI.openBrowser('https://www.joacademy.com/login')
WebUI.maximizeWindow()
WebUI.click(findTestObject('login/Page_- joacademy.com/by email button'))
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__password'), '123456')
WebUI.click(findTestObject('login/Page_- joacademy.com/button_join'))

// 📘go to the material exma 
WebUI.click(findTestObject('Object Repository/E-school/Page_- joacademy.com/E-school'))
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/class 1'))
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/semesster 1'))
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/material 1'))

// 📝 open exma 
WebUI.waitForElementVisible(findTestObject('Object Repository/exma material/Page_-   -  -   - joacademy.com/button exma material'), 10)
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -  -   - joacademy.com/button exma material'))

WebUI.executeJavaScript("window.scrollBy(0, 200);", null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/start exma'))

WebUI.switchToWindowIndex(1)
WebUI.executeJavaScript('return document.readyState === "complete";', null)

TestObject answerOption = new TestObject('AnswerOption')
answerOption.addProperty('css', ConditionType.EQUALS, 'button[role="radio"][type="button"]')
List<WebElement> answerButtons = WebUiCommonHelper.findWebElements(answerOption, 10)

if (answerButtons != null && !answerButtons.isEmpty()) {
    int numOfAnswers = answerButtons.size()
    WebUI.comment("عدد الخيارات المتاحة: " + numOfAnswers)

    for (int i = 0; i < numOfAnswers; i++) {
        WebElement answerButton = answerButtons.get(i)
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
        
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", answerButton)
        
        js.executeScript("arguments[0].click();", answerButton)
        WebUI.comment("✅ تم اختيار الإجابة رقم: " + (i + 1))
    }
} else {
    WebUI.comment('❌ لم يتم العثور على أي إجابات باستخدام button[role="radio"][type="button"]')
}

TestObject finishExamButton = findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com/finsh exam')
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", WebUI.findWebElement(finishExamButton))
WebUI.waitForElementClickable(finishExamButton, 30)
js.executeScript("arguments[0].click();", WebUI.findWebElement(finishExamButton))
WebUI.comment('✅ تم النقر على زر إنهاء الامتحان.')
WebUI.delay(5)

WebUI.takeScreenshot()

// ❌ close 
WebUI.closeBrowser()
