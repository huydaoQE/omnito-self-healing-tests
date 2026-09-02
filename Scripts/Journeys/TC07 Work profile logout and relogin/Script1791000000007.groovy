import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

if (!CustomKeywords.'omnito.AuthKeywords.requireCredentials'()) {
    return
}

WebUI.openBrowser('')
try {
    CustomKeywords.'omnito.AuthKeywords.login'()

    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/work/log')
    WebUI.click(findTestObject('App/Work_Log/button_Open_Log_Dialog'))
    WebUI.setText(findTestObject('App/Work_Log/input_Log_Title'), GlobalVariable.artifactPrefix + ' session validation')
    WebUI.setText(findTestObject('App/Work_Log/input_Log_Minutes'), '45')
    WebUI.setText(findTestObject('App/Work_Log/textarea_Log_Description'), 'Validate navigation, logout, and relogin behavior.')
    WebUI.verifyElementClickable(findTestObject('App/Work_Log/button_Submit_Log'))

    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/work/statistics')
    WebUI.verifyElementPresent(findTestObject('App/Work_Statistics/select_Range_Preset'), GlobalVariable.defaultTimeout)

    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/dashboard')
    WebUI.click(findTestObject('App/Common/button_Theme_Toggle'))
    WebUI.click(findTestObject('App/Common/link_User_Profile'))
    CustomKeywords.'omnito.BrowserKeywords.verifyUrlContains'('/profile')
    WebUI.click(findTestObject('App/Common/button_Logout'))
    WebUI.verifyElementPresent(findTestObject('Page_Auth/button_Submit'), GlobalVariable.defaultTimeout)

    WebUI.navigateToUrl(GlobalVariable.baseUrl + '/dashboard')
    WebUI.verifyElementPresent(findTestObject('Page_Auth/button_Submit'), GlobalVariable.defaultTimeout)
    CustomKeywords.'omnito.AuthKeywords.login'()
    WebUI.verifyElementPresent(findTestObject('App/Dashboard/page_Dashboard'), GlobalVariable.defaultTimeout)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
