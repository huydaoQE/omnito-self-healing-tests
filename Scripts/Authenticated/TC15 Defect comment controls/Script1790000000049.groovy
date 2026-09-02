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
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/defects')
    WebUI.verifyElementPresent(findTestObject('App/Defects/textarea_Defect_Comment'), GlobalVariable.shortTimeout, FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.verifyElementPresent(findTestObject('App/Defects/button_Post_Comment'), GlobalVariable.shortTimeout, FailureHandling.CONTINUE_ON_FAILURE)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

