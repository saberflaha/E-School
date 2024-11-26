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

WebUI.openBrowser('https://www.joacademy.com/login')

WebUI.maximizeWindow()

WebUI.click(findTestObject('login/Page_- joacademy.com/by email button'))

WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__email'), 'saber22@gmail.com')

WebUI.sendKeys(findTestObject('login/Page_- joacademy.com/input__password'), '123456')

WebUI.click(findTestObject('login/Page_- joacademy.com/button_join'))

WebUI.click(findTestObject('E-school/Page_- joacademy.com/E-school'))

boolean TextClases =WebUI.verifyElementText(findTestObject('E-school/Page_- joacademy.com/verify text clases'), 'إختر صفك الدراسي')

boolean buttonClases =WebUI.verifyElementVisible(findTestObject('E-school/Page_- joacademy.com/class button'), FailureHandling.STOP_ON_FAILURE)
if(TextClases) {
	WebUI.comment("passed")
	WebUI.takeScreenshot()
	
}
else{    WebUI.comment("Verification failed: The text does not match.")
	
}
if(buttonClases) {
	WebUI.comment("passed")
	
}
else{    WebUI.comment("Verification failed: The text does not match.")
	
}
WebUI.closeBrowser()



