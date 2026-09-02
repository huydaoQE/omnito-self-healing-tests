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
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/ai-generator')
    WebUI.setText(findTestObject('App/AI_Generator/textarea_AI_Input'), 'Generate authentication and access-control tests for Omnito.')
    WebUI.verifyElementClickable(findTestObject('App/AI_Generator/button_Generate'))
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

