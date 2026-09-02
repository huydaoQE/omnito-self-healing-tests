import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

if (!CustomKeywords.'omnito.AuthKeywords.requireCredentials'()) {
    return
}

WebUI.openBrowser('')
try {
    WebUI.navigateToUrl(GlobalVariable.baseUrl)
    WebUI.waitForPageLoad(GlobalVariable.defaultTimeout)
    WebUI.click(findTestObject('Common/a_Nav_Docs'))
    WebUI.verifyElementVisible(findTestObject('Page_Docs/h1_Omnito_Functions'))
    WebUI.click(findTestObject('Common/a_Logo'))
    WebUI.click(findTestObject('Common/a_Launch_Omnito'))
    CustomKeywords.'omnito.AuthKeywords.login'()
    WebUI.verifyElementPresent(findTestObject('App/Dashboard/page_Dashboard'), GlobalVariable.defaultTimeout)
    TestObject essentialAction = new TestObject('essential-action')
    essentialAction.addProperty('xpath', ConditionType.EQUALS, "//button[normalize-space(.)='Export Workspace']")
    WebUI.click(essentialAction)
    WebUI.verifyTextPresent('Workspace export completed', false)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
