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
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/work/log')
    WebUI.click(findTestObject('App/Work_Log/button_Open_Log_Dialog'))
    WebUI.setText(findTestObject('App/Work_Log/input_Log_Title'), GlobalVariable.artifactPrefix + ' exploratory testing')
    WebUI.setText(findTestObject('App/Work_Log/input_Log_Minutes'), '30')
    WebUI.setText(findTestObject('App/Work_Log/textarea_Log_Description'), 'Explored core Omnito web flows.')
    WebUI.verifyElementClickable(findTestObject('App/Work_Log/button_Submit_Log'))
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

