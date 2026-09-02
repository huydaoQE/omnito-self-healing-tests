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

WebUI.openBrowser(null)

WebUI.navigateToUrl('https://omnito.dev')

WebUI.click(findTestObject('Page_Omnito  AI-Powered Test Management/a_Docs'))

WebUI.click(findTestObject('Page_Omnito  AI-Powered Test Management/a_Plans  Benefits'))

WebUI.click(findTestObject('Page_Omnito  AI-Powered Test Management/a_Contact'))

WebUI.click(findTestObject('Page_Omnito  AI-Powered Test Management/a_View plans  benefits'))

WebUI.click(findTestObject('Page_Omnito  AI-Powered Test Management/a_Choose this plan'))

WebUI.setText(findTestObject('Page_Omnito  AI-Powered Test Management/input_Email'), 'huydao226@gmail.com')

WebUI.click(findTestObject('Page_Omnito  AI-Powered Test Management/button_Sign In'))

WebUI.rightClick(findTestObject('Page_Omnito  AI-Powered Test Management/p_auth-error'))

WebUI.assertElementVisible(findTestObject('Page_Omnito  AI-Powered Test Management/p_auth-error'), 0)

