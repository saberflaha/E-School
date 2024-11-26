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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import java.util.Random as Random

WebUI.openBrowser('https://www.joacademy.com/login')
WebUI.maximizeWindow()

WebUI.click(findTestObject('login/Page_- joacademy.com/by email button'))
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')
WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__password'), '123456')
WebUI.click(findTestObject('login/Page_- joacademy.com/button_join'))

WebUI.click(findTestObject('E-school/Page_- joacademy.com/E-school'))
WebUI.click(findTestObject('Object Repository/E-school/Page_- joacademy.com/class button'))
List<WebElement> buttonClasses = WebUI.findWebElements(findTestObject('Object Repository/E-school/Page_- joacademy.com/class button'), 30)

if (buttonClasses.size() > 0) {
    Random random = new Random()
    WebElement randomButtonClass = buttonClasses.get(random.nextInt(buttonClasses.size()))
    
    WebUI.waitForElementClickable(findTestObject('Object Repository/E-school/Page_- joacademy.com/class button'), 10)
    
    randomButtonClass.click()
    
    WebUI.comment("Passed: A random class button was clicked successfully.")
	WebUI.takeScreenshot()
	
    WebUI.closeBrowser()
} else {
    WebUI.comment("Failed: No class buttons were found.")
    WebUI.closeBrowser()
}
