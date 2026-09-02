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
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/work/statistics')
    WebUI.verifyElementPresent(findTestObject('App/Work_Statistics/select_Range_Preset'), GlobalVariable.defaultTimeout)
    WebUI.verifyElementPresent(findTestObject('App/Work_Statistics/input_Custom_Start'), GlobalVariable.shortTimeout, FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.verifyElementPresent(findTestObject('App/Work_Statistics/input_Custom_End'), GlobalVariable.shortTimeout, FailureHandling.CONTINUE_ON_FAILURE)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

