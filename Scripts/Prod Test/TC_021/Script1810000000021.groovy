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
    def routes = findTestData('PublicRoutes')
    TestObject plansLink = new TestObject('plans-link')
    plansLink.addProperty('xpath', ConditionType.EQUALS, "//a[@href='/plans-legacy']")
    WebUI.click(plansLink)
    String plansPath = routes.getValue('path', 3) + '-legacy'
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'(plansPath)
    WebUI.verifyTextPresent(routes.getValue('expectedText', 3), false)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
