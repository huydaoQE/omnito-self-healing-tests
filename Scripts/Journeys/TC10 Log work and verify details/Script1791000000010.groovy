import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

if (!CustomKeywords.'omnito.AuthKeywords.requireCredentials'()) {
    return
}

String runId = new SimpleDateFormat('yyyyMMdd-HHmmss').format(new Date())
String workLogTitle = GlobalVariable.artifactPrefix + ' work log ' + runId
String workLogDescription = 'Verified navigation, login, status configuration, and Work Log behavior for run ' + runId + '.'
String workLogMinutes = '25'

TestObject workLogTitleCell = new TestObject('work-log-title-' + runId)
workLogTitleCell.addProperty('xpath', ConditionType.EQUALS,
    "//tr[.//td[normalize-space(.)='${workLogTitle}']]//td[normalize-space(.)='${workLogTitle}']")

WebUI.openBrowser(GlobalVariable.baseUrl)
try {
    CustomKeywords.'omnito.AuthKeywords.login'()
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/work/log')

    WebUI.waitForElementClickable(findTestObject('App/Work_Log/button_Open_Log_Dialog'), GlobalVariable.defaultTimeout)
    WebUI.click(findTestObject('App/Work_Log/button_Open_Log_Dialog'))

    WebUI.waitForElementVisible(findTestObject('App/Work_Log/input_Log_Title'), GlobalVariable.defaultTimeout)
    WebUI.setText(findTestObject('App/Work_Log/input_Log_Title'), workLogTitle)
    WebUI.setText(findTestObject('App/Work_Log/input_Log_Minutes'), workLogMinutes)
    WebUI.setText(findTestObject('App/Work_Log/textarea_Log_Description'), workLogDescription)
    WebUI.click(findTestObject('App/Work_Log/button_Submit_Log'))

    WebUI.waitForElementVisible(workLogTitleCell, GlobalVariable.defaultTimeout)
    WebUI.verifyElementText(workLogTitleCell, workLogTitle)
    WebUI.click(workLogTitleCell)

    WebUI.waitForElementVisible(findTestObject('App/Work_Log/input_Log_Title'), GlobalVariable.defaultTimeout)
    WebUI.verifyElementAttributeValue(findTestObject('App/Work_Log/input_Log_Title'), 'value', workLogTitle,
        GlobalVariable.defaultTimeout)
    WebUI.verifyElementAttributeValue(findTestObject('App/Work_Log/input_Log_Minutes'), 'value', workLogMinutes,
        GlobalVariable.defaultTimeout)
    WebUI.verifyElementAttributeValue(findTestObject('App/Work_Log/textarea_Log_Description'), 'value',
        workLogDescription, GlobalVariable.defaultTimeout)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
