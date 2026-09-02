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
    WebUI.executeJavaScript("var b=document.createElement('button');b.id='enabled-later';b.disabled=true;b.textContent='Continue';document.body.appendChild(b);setTimeout(function(){b.disabled=false;},3000);", null)
    TestObject enabledLater = new TestObject('enabled-later')
    enabledLater.addProperty('xpath', ConditionType.EQUALS, "//*[@id='enabled-later']")
    WebUI.waitForElementPresent(enabledLater, GlobalVariable.defaultTimeout)
    WebUI.waitForElementClickable(enabledLater, 1)
    WebUI.click(enabledLater)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
