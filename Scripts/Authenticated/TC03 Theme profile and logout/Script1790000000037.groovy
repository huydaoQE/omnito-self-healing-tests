import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

if (!CustomKeywords.'omnito.AuthKeywords.requireCredentials'()) {
    return
}
WebUI.openBrowser('')
try {
    CustomKeywords.'omnito.AuthKeywords.login'()
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/dashboard')
    WebUI.click(findTestObject('App/Common/button_Theme_Toggle'))
    WebUI.click(findTestObject('App/Common/link_User_Profile'))
    CustomKeywords.'omnito.BrowserKeywords.verifyUrlContains'('/profile')
    WebUI.click(findTestObject('App/Common/button_Logout'))
    WebUI.verifyElementPresent(findTestObject('Page_Auth/button_Submit'), GlobalVariable.defaultTimeout)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

