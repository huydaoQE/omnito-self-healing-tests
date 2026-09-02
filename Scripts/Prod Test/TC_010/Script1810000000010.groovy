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
    TestObject docsLink = new TestObject('docs-link')
    docsLink.addProperty('xpath', ConditionType.EQUALS, "//a[@href='/docs-legacy']")
    WebUI.click(docsLink)
    WebUI.verifyTextPresent('Omnito legacy functions', false)
    WebUI.click(findTestObject('Common/a_Logo'))
    WebUI.click(findTestObject('Common/a_Launch_Omnito'))
    CustomKeywords.'omnito.AuthKeywords.login'()
    WebUI.verifyElementPresent(findTestObject('App/Dashboard/page_Dashboard'), GlobalVariable.defaultTimeout)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
