import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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
    WebUI.click(findTestObject('App/Defects/button_Create_Defect'))
    WebUI.setText(findTestObject('App/Defects/input_Defect_Title'), GlobalVariable.artifactPrefix + ' draft defect')
    WebUI.setText(findTestObject('App/Defects/textarea_Defect_Summary'), 'Drafted by a non-destructive navigation journey.')
    WebUI.setText(findTestObject('App/Defects/textarea_Defect_Steps'), '1. Sign in\n2. Open Defects\n3. Complete the form')
    WebUI.setText(findTestObject('App/Defects/textarea_Defect_Expected'), 'Form values remain editable')
    WebUI.setText(findTestObject('App/Defects/textarea_Defect_Actual'), 'Form values remain editable')

    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/knowledge')
    WebUI.click(findTestObject('App/Knowledge/button_Add_Knowledge'))
    WebUI.setText(findTestObject('App/Knowledge/input_Knowledge_Title'), GlobalVariable.artifactPrefix + ' draft knowledge')
    WebUI.setText(findTestObject('App/Knowledge/textarea_Knowledge_Content'), 'Navigation, login, session, and locator recovery notes.')
    WebUI.setText(findTestObject('App/Knowledge/input_Knowledge_Tags'), 'navigation,login,self-healing')

    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/ai-generator')
    WebUI.setText(findTestObject('App/AI_Generator/textarea_AI_Input'),
        'Generate tests for login recovery, protected routes, browser history, and session persistence.')
    WebUI.verifyElementClickable(findTestObject('App/AI_Generator/button_Generate'))

    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/settings')
    WebUI.setText(findTestObject('App/Settings/input_Invite_Email'), 'invalid-email')
    WebUI.verifyElementPresent(findTestObject('App/Settings/button_Send_Invite'), GlobalVariable.defaultTimeout)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
