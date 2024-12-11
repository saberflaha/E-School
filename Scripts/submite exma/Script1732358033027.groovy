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
// فتح المتصفح وتسجيل الدخول
WebUI.openBrowser('https://www.joacademy.com/login')
WebUI.maximizeWindow()

WebUI.click(findTestObject('login/Page_- joacademy.com/by email button'))
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__password'), '123456')
WebUI.click(findTestObject('login/Page_- joacademy.com/button_join'))

WebUI.click(findTestObject('Object Repository/E-school/Page_- joacademy.com/E-school'))
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/class 1'))
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/semesster 1'))
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/material 1'))

WebUI.waitForElementVisible(findTestObject('Object Repository/exma material/Page_-   -  -   - joacademy.com/button exma material'), 10)
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -  -   - joacademy.com/button exma material'))

WebUI.executeJavaScript("window.scrollBy(0, 200);", null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/start exma'))


WebUI.switchToWindowIndex(1)
WebUI.executeJavaScript('return document.readyState === "complete";', null)

List<TestObject> buttons = [
	findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/button true'),
	findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/button true 2'),
	findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/button true 3'),
	findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/button true 4'),
	findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/button true 5'),
	findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/button true 6'),
	findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/button true 7'),
	findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/button true 8'),
	findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/button true 9'),
	findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/button true 10')
]

for (TestObject button : buttons) {
	if (WebUI.verifyElementPresent(button, 5, FailureHandling.OPTIONAL)) {
		WebUI.scrollToElement(button, 0)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUiCommonHelper.findWebElement(button, 5)))
		WebUI.delay(2)
	} else {
		WebUI.comment("الزر غير مرئي أو غير موجود: ${button.getObjectId()}")
	}
}

WebUI.waitForElementVisible(findTestObject("Object Repository/submet exam/Page_- joacademy.com/finsh exma"), 10)
if (WebUI.verifyElementPresent(findTestObject('Object Repository/submet exam/Page_- joacademy.com/finsh exma'), 10, FailureHandling.OPTIONAL)) {
	WebUI.scrollToElement(findTestObject('Object Repository/submet exam/Page_- joacademy.com/finsh exma'), 0)
	WebUI.click(findTestObject('Object Repository/submet exam/Page_- joacademy.com/finsh exma'))
	
	boolean errorWhenCompletingExam = WebUI.verifyElementText(findTestObject('Object Repository/book index/Page_-   -  -   - joacademy.com/verify button_ uint questiona'), 'جميع الحقول مطلوبة')
	if (errorWhenCompletingExam) {
		WebUI.comment('Pass')
	} else {
		WebUI.comment('Fail')
	}
	WebUI.closeBrowser()
} else {
	WebUI.comment("'Finish Exam' button is not present.")
}

WebUI.takeScreenshot()


//WebUI.closeBrowser()

