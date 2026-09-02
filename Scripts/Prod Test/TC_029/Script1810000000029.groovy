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
    for (int row = 2; row <= 4; row++) {
        String path = routes.getValue('path', row) + '-legacy'
        CustomKeywords.'omnito.BrowserKeywords.navigateTo'(path)
        WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.baseUrl + routes.getValue('path', row), false)
        WebUI.verifyTextPresent(routes.getValue('expectedCopy', row), false)
    }
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
