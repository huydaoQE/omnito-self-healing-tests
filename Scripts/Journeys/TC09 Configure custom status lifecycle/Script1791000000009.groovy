import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.SimpleDateFormat as SimpleDateFormat
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

if (!(CustomKeywords.'omnito.AuthKeywords.requireCredentials'())) {
}

String statusLabel = 'KS Status ' + new SimpleDateFormat('yyyyMMdd-HHmmss').format(new Date())

def statusRow = findTestObject('App/Settings/row_Bug_Status_By_Label', [('statusLabel') : statusLabel])

def deleteStatusButton = findTestObject('App/Settings/button_Delete_Status_By_Label', [('statusLabel') : statusLabel])

TestObject projectSelector = new TestObject('sidebar-project-selector')

projectSelector.addProperty('xpath', ConditionType.EQUALS, '(//button[@role="combobox"])[1]')

TestObject targetProjectOption = new TestObject('target-project-option')

targetProjectOption.addProperty('xpath', ConditionType.EQUALS, '//*[@role="option" and normalize-space(.)="Katalon Purchase"]')

TestObject selectedTargetProject = new TestObject('selected-target-project')

selectedTargetProject.addProperty('xpath', ConditionType.EQUALS, '(//button[@role="combobox"])[1]//*[normalize-space(.)="Katalon Purchase"]')

boolean statusCreated = false

WebUI.openBrowser(GlobalVariable.baseUrl)

try {
    CustomKeywords.'omnito.AuthKeywords.login'()

    WebUI.waitForElementClickable(projectSelector, GlobalVariable.defaultTimeout)

    WebUI.click(projectSelector)

    WebUI.waitForElementClickable(targetProjectOption, GlobalVariable.defaultTimeout)

    WebUI.click(targetProjectOption)

    WebUI.waitForElementVisible(selectedTargetProject, GlobalVariable.defaultTimeout)

    WebUI.waitForElementVisible(findTestObject('App/Settings/input_Status_Label'), GlobalVariable.defaultTimeout)

    WebUI.setText(findTestObject('App/Settings/input_Status_Label'), statusLabel)

    WebUI.waitForElementVisible(statusRow, GlobalVariable.defaultTimeout)

    WebUI.verifyTextPresent(statusLabel, false)

    statusCreated = true

    WebUI.waitForElementClickable(deleteStatusButton, GlobalVariable.defaultTimeout)

    WebUI.click(deleteStatusButton)

    WebUI.waitForElementNotPresent(statusRow, GlobalVariable.defaultTimeout)

    WebUI.verifyTextNotPresent(statusLabel, false)

    statusCreated = false
}
finally { 
    if (statusCreated) {
        try {
            if (WebUI.verifyElementPresent(deleteStatusButton, 2, FailureHandling.OPTIONAL)) {
                WebUI.click(deleteStatusButton, FailureHandling.OPTIONAL)

                WebUI.waitForElementNotPresent(statusRow, GlobalVariable.defaultTimeout, FailureHandling.OPTIONAL)
            }
        }
        catch (Exception ignored) {
        } // Keep the original test failure while making a best-effort cleanup.
    }
    
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}