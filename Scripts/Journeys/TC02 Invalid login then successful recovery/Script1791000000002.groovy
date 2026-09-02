import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

if (!CustomKeywords.'omnito.AuthKeywords.requireCredentials'()) {
    return
}

WebUI.openBrowser('')
try {
    WebUI.navigateToUrl(GlobalVariable.baseUrl + '/auth')
    WebUI.waitForPageLoad(GlobalVariable.defaultTimeout)

    CustomKeywords.'omnito.AuthKeywords.submitCredentials'(String.valueOf(GlobalVariable.validEmail), 'incorrect-password')
    CustomKeywords.'omnito.AuthKeywords.verifyAuthenticationError'()

    WebUI.clearText(findTestObject('Page_Auth/input_Email'))
    WebUI.clearText(findTestObject('Page_Auth/input_Password'))
    CustomKeywords.'omnito.AuthKeywords.login'()

    WebUI.verifyElementPresent(findTestObject('App/Dashboard/page_Dashboard'), GlobalVariable.defaultTimeout)
    CustomKeywords.'omnito.BrowserKeywords.verifyUrlContains'('/dashboard')
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
