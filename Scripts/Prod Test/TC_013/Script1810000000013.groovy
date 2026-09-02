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
    def routes = findTestData('PublicRoutes')
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'(routes.getValue('path', 2))
    WebUI.verifyTextPresent(routes.getValue('expectedCopy', 2), false)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
