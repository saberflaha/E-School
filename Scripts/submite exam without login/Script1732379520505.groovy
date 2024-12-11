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
WebUI.openBrowser('https://www.joacademy.com/e-school')
WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/E-school/Page_- joacademy.com/E-school'))
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/class 1'))
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/semesster 1'))
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -   - joacademy.com (1)/material 1'))

WebUI.waitForElementVisible(findTestObject('Object Repository/exma material/Page_-   -  -   - joacademy.com/button exma material'), 10)
WebUI.click(findTestObject('Object Repository/exma material/Page_-   -  -   - joacademy.com/button exma material'))

WebUI.executeJavaScript("window.scrollBy(0, 200);", null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/submite exam without login/Page_-   -   - joacademy.com/choose exma'))
if (WebUI.verifyElementVisible(findTestObject('submite exam without login/Page_-   -  -   - joacademy.com/verify by login'), FailureHandling.OPTIONAL)  ) {
    WebUI.comment("Pass")
	WebUI.takeScreenshot()
	
} else {
    WebUI.comment("Fail")
}

WebUI.closeBrowser()

