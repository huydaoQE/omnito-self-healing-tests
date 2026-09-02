import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

if (!CustomKeywords.'omnito.AuthKeywords.requireCredentials'()) {
    return
}

try {
    WebUI.openBrowser('')

    CustomKeywords.'omnito.AuthKeywords.login'()
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/test-cases')

    def sample = CustomKeywords.'omnito.DataKeywords.row'('TestCaseSamples', 1)

    assert sample != null : 'TestCaseSamples row 1 was not found'
    assert sample.title : 'Test case title is empty'
    assert sample.precondition : 'Test case precondition is empty'
    assert sample.action : 'Test case action is empty'
    assert sample.expectedResult : 'Test case expected result is empty'

    def newTestCaseButton = findTestObject('App/Test_Cases/button_New_Test_Case')
    def titleInput = findTestObject('App/Test_Cases/input_Test_Case_Title')
    def preconditionInput = findTestObject('App/Test_Cases/textarea_Precondition')
    def submitButton = findTestObject('App/Test_Cases/button_Submit_Test_Case')

    WebUI.waitForElementVisible(newTestCaseButton, 10)
    WebUI.click(newTestCaseButton)

    WebUI.waitForElementVisible(titleInput, 10)
    WebUI.setText(titleInput, CustomKeywords.'omnito.DataKeywords.uniqueName'(sample.title))
    WebUI.setText(preconditionInput, sample.precondition)

    WebUI.setText(
        CustomKeywords.'omnito.ElementKeywords.byTestId'('textarea-step-action-0'),
        sample.action
    )

    WebUI.setText(
        CustomKeywords.'omnito.ElementKeywords.byTestId'('textarea-step-expected-0'),
        sample.expectedResult
    )

    WebUI.click(submitButton)

    WebUI.verifyMatch(WebUI.getUrl(), '.*/test-cases.*', true)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}