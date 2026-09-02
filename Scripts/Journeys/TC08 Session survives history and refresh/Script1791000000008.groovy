import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

if (!CustomKeywords.'omnito.AuthKeywords.requireCredentials'()) {
    return
}

WebUI.openBrowser('')
try {
    CustomKeywords.'omnito.AuthKeywords.login'()

    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/test-cases')
    WebUI.verifyElementPresent(findTestObject('App/Test_Cases/input_Search_Tree'), GlobalVariable.defaultTimeout)

    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/defects')
    WebUI.verifyElementPresent(findTestObject('App/Defects/input_Defect_Search'), GlobalVariable.defaultTimeout)

    WebUI.back()
    WebUI.waitForPageLoad(GlobalVariable.defaultTimeout)
    WebUI.verifyElementPresent(findTestObject('App/Test_Cases/input_Search_Tree'), GlobalVariable.defaultTimeout)

    WebUI.forward()
    WebUI.waitForPageLoad(GlobalVariable.defaultTimeout)
    WebUI.verifyElementPresent(findTestObject('App/Defects/input_Defect_Search'), GlobalVariable.defaultTimeout)

    WebUI.refresh()
    WebUI.waitForPageLoad(GlobalVariable.defaultTimeout)
    WebUI.verifyElementPresent(findTestObject('App/Defects/input_Defect_Search'), GlobalVariable.defaultTimeout)
    CustomKeywords.'omnito.BrowserKeywords.verifyUrlContains'('/defects')
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
