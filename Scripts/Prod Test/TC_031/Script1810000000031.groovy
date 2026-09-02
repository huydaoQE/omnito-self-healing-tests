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
    TestObject passwordField = new TestObject('password-field')
    passwordField.addProperty('xpath', ConditionType.EQUALS, "//input[@name='passwordLegacy']")
    WebUI.setText(findTestObject('Page_Auth/input_Email'), String.valueOf(GlobalVariable.validEmail))
    WebUI.setText(passwordField, 'incorrect-password')
    WebUI.click(findTestObject('Page_Auth/button_Submit'))
    CustomKeywords.'omnito.AuthKeywords.verifyAuthenticationError'()
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
