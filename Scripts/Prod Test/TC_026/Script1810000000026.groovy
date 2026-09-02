import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

WebUI.openBrowser('')
try {
    WebUI.navigateToUrl(GlobalVariable.baseUrl)
    WebUI.waitForPageLoad(GlobalVariable.defaultTimeout)
    WebUI.executeJavaScript("setTimeout(function(){var a=document.createElement('button');a.id='late-one';a.textContent='One';document.body.appendChild(a);},3000);", null)
    TestObject lateOne = new TestObject('late-one')
    lateOne.addProperty('xpath', ConditionType.EQUALS, "//*[@id='late-one']")
    TestObject lateTwo = new TestObject('late-two')
    lateTwo.addProperty('xpath', ConditionType.EQUALS, "//*[@id='late-two']")
    WebUI.waitForElementClickable(lateOne, 1)
    WebUI.click(lateOne)
    WebUI.executeJavaScript("setTimeout(function(){var b=document.createElement('button');b.id='late-two';b.textContent='Two';document.body.appendChild(b);},3000);", null)
    WebUI.waitForElementClickable(lateTwo, 1)
    WebUI.click(lateTwo)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
