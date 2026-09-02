import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

if (!CustomKeywords.'omnito.AuthKeywords.requireCredentials'()) {
    return
}

WebUI.openBrowser('')
try {
    WebUI.navigateToUrl(GlobalVariable.baseUrl)
    WebUI.waitForPageLoad(GlobalVariable.defaultTimeout)
    WebUI.scrollToElement(findTestObject('Common/a_Footer_Documentation'), GlobalVariable.defaultTimeout)
    WebUI.click(findTestObject('Common/a_Footer_Documentation'))
    WebUI.verifyElementVisible(findTestObject('Page_Docs/h1_Omnito_Functions'))

    WebUI.click(findTestObject('Common/a_Nav_Home'))
    WebUI.scrollToElement(findTestObject('Common/a_Footer_Support'), GlobalVariable.defaultTimeout)
    WebUI.click(findTestObject('Common/a_Footer_Support'))
    WebUI.verifyElementVisible(findTestObject('Page_Contact/h1_Talk_With_Team'))

    WebUI.click(findTestObject('Common/a_Nav_Plans'))
    WebUI.verifyElementVisible(findTestObject('Page_Plans/h1_Plans_Benefits'))
    WebUI.click(findTestObject('Common/a_Logo'))
    WebUI.click(findTestObject('Common/a_Launch_Omnito'))

    CustomKeywords.'omnito.AuthKeywords.login'()
    WebUI.verifyElementPresent(findTestObject('App/Dashboard/dashboard_Metrics'), GlobalVariable.defaultTimeout)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
