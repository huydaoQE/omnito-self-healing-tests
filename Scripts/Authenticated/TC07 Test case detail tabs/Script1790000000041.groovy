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
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/test-cases')
    WebUI.verifyElementPresent(findTestObject('App/Test_Cases/tab_Procedure'), GlobalVariable.defaultTimeout, FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.verifyElementPresent(findTestObject('App/Test_Cases/tab_Details'), GlobalVariable.defaultTimeout, FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.verifyElementPresent(findTestObject('App/Test_Cases/tab_Test_Data'), GlobalVariable.defaultTimeout, FailureHandling.CONTINUE_ON_FAILURE)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

