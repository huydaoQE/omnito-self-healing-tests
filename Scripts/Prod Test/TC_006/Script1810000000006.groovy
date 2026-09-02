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
    WebUI.navigateToUrl(GlobalVariable.baseUrl + '/auth')
    WebUI.waitForPageLoad(GlobalVariable.defaultTimeout)
    CustomKeywords.'omnito.AuthKeywords.verifyAuthenticationError'()
    CustomKeywords.'omnito.AuthKeywords.login'()
    WebUI.verifyElementPresent(findTestObject('App/Dashboard/page_Dashboard'), GlobalVariable.defaultTimeout)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
