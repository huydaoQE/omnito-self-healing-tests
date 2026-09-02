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
    TestObject emailField = new TestObject('email-field')
    emailField.addProperty('xpath', ConditionType.EQUALS, "//input[@name='emailAddressLegacy']")
    WebUI.setText(emailField, String.valueOf(GlobalVariable.validEmail))
    WebUI.setText(findTestObject('Page_Auth/input_Password'), 'incorrect-password')
    WebUI.click(findTestObject('Page_Auth/button_Submit'))
    CustomKeywords.'omnito.AuthKeywords.verifyAuthenticationError'()
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
