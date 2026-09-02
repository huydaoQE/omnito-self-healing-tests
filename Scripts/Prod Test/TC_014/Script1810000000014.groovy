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
    def scenarios = findTestData('AuthScenarios')
    String email = scenarios.getValue('userEmail', 2)
    String password = scenarios.getValue('password', 2)
    CustomKeywords.'omnito.AuthKeywords.submitCredentials'(email, password)
    CustomKeywords.'omnito.AuthKeywords.verifyAuthenticationError'()
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
