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
    WebUI.click(findTestObject('App/Knowledge/button_Add_Knowledge'))
    WebUI.setText(findTestObject('App/Knowledge/input_Knowledge_Title'),
        CustomKeywords.'omnito.DataKeywords.uniqueName'('Knowledge'))
    WebUI.setText(findTestObject('App/Knowledge/textarea_Knowledge_Content'), 'Katalon-generated knowledge fixture for AI test design and self-healing context.')
    WebUI.setText(findTestObject('App/Knowledge/input_Knowledge_Tags'), 'katalon,automation,self-healing')
    WebUI.click(findTestObject('App/Knowledge/button_Save_Knowledge'))
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

