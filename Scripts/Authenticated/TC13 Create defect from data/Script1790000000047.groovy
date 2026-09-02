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
    def defect = CustomKeywords.'omnito.DataKeywords.row'('DefectSamples', 1)
    WebUI.click(findTestObject('App/Defects/button_Create_Defect'))
    WebUI.setText(findTestObject('App/Defects/input_Defect_Title'),
        CustomKeywords.'omnito.DataKeywords.uniqueName'(defect.title))
    WebUI.setText(findTestObject('App/Defects/textarea_Defect_Summary'), defect.summary)
    WebUI.setText(findTestObject('App/Defects/textarea_Defect_Steps'), defect.steps)
    WebUI.setText(findTestObject('App/Defects/textarea_Defect_Expected'), defect.expected)
    WebUI.setText(findTestObject('App/Defects/textarea_Defect_Actual'), defect.actual)
    WebUI.click(CustomKeywords.'omnito.ElementKeywords.byExactText'('button', 'Create Defect'))
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

