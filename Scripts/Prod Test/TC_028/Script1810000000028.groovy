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
    def scenarios = findTestData('AuthScenarios')
    String email = scenarios.getValue('userEmail', 2)
    TestObject emailField = new TestObject('email-field')
    emailField.addProperty('xpath', ConditionType.EQUALS, "//input[@name='emailAddressLegacy']")
    TestObject passwordField = new TestObject('password-field')
    passwordField.addProperty('xpath', ConditionType.EQUALS, "//input[@name='passwordLegacy']")
    WebUI.setText(emailField, email)
    WebUI.setText(passwordField, scenarios.getValue('password', 2))
    WebUI.click(findTestObject('Page_Auth/button_Submit'))
    CustomKeywords.'omnito.AuthKeywords.verifyAuthenticationError'()
    WebUI.clearText(findTestObject('Page_Auth/input_Email'))
    CustomKeywords.'omnito.AuthKeywords.login'()
    WebUI.verifyElementPresent(findTestObject('App/Dashboard/page_Dashboard'), GlobalVariable.defaultTimeout)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
