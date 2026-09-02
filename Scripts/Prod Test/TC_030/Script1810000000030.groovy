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
    WebUI.executeJavaScript("var f=document.querySelector('input[type=email]');if(f){var p=f.parentNode;var n=f.nextSibling;var c=f.cloneNode(true);f.remove();setTimeout(function(){p.insertBefore(c,n);},3000);}", null)
    TestObject emailField = new TestObject('email-field')
    emailField.addProperty('xpath', ConditionType.EQUALS, "//input[@name='emailAddressLegacy']")
    WebUI.waitForElementVisible(emailField, 1)
    CustomKeywords.'omnito.ElementKeywords.replaceText'(emailField, String.valueOf(GlobalVariable.validEmail))
    CustomKeywords.'omnito.AuthKeywords.verifyAuthenticationError'()
    CustomKeywords.'omnito.AuthKeywords.login'()
    WebUI.verifyElementPresent(findTestObject('App/Dashboard/page_Dashboard'), GlobalVariable.defaultTimeout)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
