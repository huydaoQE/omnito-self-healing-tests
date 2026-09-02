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
    def modules = [[path: '/docs', object: 'Page_Plans/h1_Plans_Benefits']]
    modules.each { module ->
        CustomKeywords.'omnito.BrowserKeywords.navigateTo'(module.path)
        WebUI.verifyElementPresent(findTestObject(module.object), GlobalVariable.defaultTimeout)
    }
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
