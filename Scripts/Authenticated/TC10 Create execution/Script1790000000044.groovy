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
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/execution')
    WebUI.click(findTestObject('App/Execution/button_Create_Execution'))
    WebUI.setText(findTestObject('App/Execution/input_Execution_Name'),
        CustomKeywords.'omnito.DataKeywords.uniqueName'('Execution'))
    WebUI.verifyElementPresent(findTestObject('App/Execution/select_Execution_Status'), GlobalVariable.defaultTimeout)
    WebUI.click(findTestObject('App/Execution/button_Submit_Execution'))
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

