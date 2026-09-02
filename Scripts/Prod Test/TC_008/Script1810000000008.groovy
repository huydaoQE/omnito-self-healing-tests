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
    WebUI.executeJavaScript("setTimeout(function(){var b=document.createElement('button');b.id='late-action';b.textContent='Continue';document.body.appendChild(b);},1500);", null)
    TestObject lateAction = new TestObject('late-action')
    lateAction.addProperty('xpath', ConditionType.EQUALS, "//*[@id='late-action']")
    WebUI.click(lateAction)
    WebUI.click(findTestObject('Common/a_Nav_Docs'))
    WebUI.verifyElementVisible(findTestObject('Page_Docs/h1_Omnito_Functions'))
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
