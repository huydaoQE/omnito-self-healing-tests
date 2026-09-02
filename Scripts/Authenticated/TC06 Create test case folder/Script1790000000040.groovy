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
    WebUI.click(findTestObject('App/Test_Cases/button_New_Folder'))
    WebUI.setText(CustomKeywords.'omnito.ElementKeywords.byTestId'('input-folder-name'),
        CustomKeywords.'omnito.DataKeywords.uniqueName'('Folder'))
    CustomKeywords.'omnito.ElementKeywords.clickTestId'('button-confirm-create-folder')
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

