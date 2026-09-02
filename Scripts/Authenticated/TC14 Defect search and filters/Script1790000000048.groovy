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
    WebUI.setText(findTestObject('App/Defects/input_Defect_Search'), GlobalVariable.artifactPrefix)
    ['App/Defects/select_Status_Filter','App/Defects/select_Category_Filter',
     'App/Defects/select_Type_Filter','App/Defects/select_Priority_Filter'].each { String id ->
        WebUI.verifyElementPresent(findTestObject(id), GlobalVariable.defaultTimeout)
    }
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

