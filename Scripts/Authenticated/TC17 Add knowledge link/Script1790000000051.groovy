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
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/knowledge')
    WebUI.click(findTestObject('App/Knowledge/button_Add_Link'))
    WebUI.setText(CustomKeywords.'omnito.ElementKeywords.byTestId'('input-link-title'), 'Katalon Documentation')
    WebUI.setText(findTestObject('App/Knowledge/input_Link_URL'), 'https://docs.katalon.com')
    CustomKeywords.'omnito.ElementKeywords.clickTestId'('button-save-link')
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

