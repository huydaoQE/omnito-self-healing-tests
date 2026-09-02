import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

if (!CustomKeywords.'omnito.AuthKeywords.requireCredentials'()) {
    return
}

WebUI.openBrowser('')
try {
    CustomKeywords.'omnito.AuthKeywords.login'()

    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/test-cases')
    WebUI.setText(findTestObject('App/Test_Cases/input_Search_Tree'), 'Login')
    WebUI.click(findTestObject('App/Test_Cases/button_Toggle_Filters'))
    WebUI.verifyElementPresent(findTestObject('App/Test_Cases/button_New_Test_Case'), GlobalVariable.defaultTimeout)

    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/test-plans')
    WebUI.setText(findTestObject('App/Test_Plans/input_Plan_Search'), GlobalVariable.artifactPrefix)
    WebUI.verifyElementPresent(findTestObject('App/Test_Plans/select_Plan_Status'), GlobalVariable.defaultTimeout)

    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/execution')
    WebUI.setText(findTestObject('App/Execution/input_Search_Executions'), GlobalVariable.artifactPrefix)
    WebUI.verifyElementPresent(findTestObject('App/Execution/overview_Execution'), GlobalVariable.defaultTimeout)

    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/reports')
    WebUI.verifyElementPresent(findTestObject('App/Reports/button_Generate_PDF'), GlobalVariable.shortTimeout,
        FailureHandling.CONTINUE_ON_FAILURE)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
