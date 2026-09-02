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
    TestObject plansLink = new TestObject('plans-link')
    plansLink.addProperty('xpath', ConditionType.EQUALS, "//a[@href='/plans-legacy']")
    WebUI.click(docsLink)
    WebUI.verifyElementVisible(findTestObject('Page_Docs/h1_Omnito_Functions'))
    WebUI.click(plansLink)
    WebUI.verifyElementVisible(findTestObject('Page_Plans/h1_Plans_Benefits'))
    WebUI.click(findTestObject('Common/a_Logo'))
    WebUI.click(findTestObject('Common/a_Launch_Omnito'))
    CustomKeywords.'omnito.AuthKeywords.login'()
    WebUI.verifyElementPresent(findTestObject('App/Dashboard/page_Dashboard'), GlobalVariable.defaultTimeout)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
