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
    WebUI.waitForElementVisible(findTestObject('Page_Auth/input_Email'), 1)
    CustomKeywords.'omnito.AuthKeywords.submitCredentials'(String.valueOf(GlobalVariable.validEmail), 'incorrect-password')
    CustomKeywords.'omnito.AuthKeywords.verifyAuthenticationError'()
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
