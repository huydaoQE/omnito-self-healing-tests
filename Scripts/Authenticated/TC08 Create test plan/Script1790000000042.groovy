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
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/test-plans')
    WebUI.click(findTestObject('App/Test_Plans/button_Create_Test_Plan'))
    WebUI.setText(findTestObject('App/Test_Plans/input_Plan_Name'),
        CustomKeywords.'omnito.DataKeywords.uniqueName'('Plan'))
    WebUI.setText(findTestObject('App/Test_Plans/textarea_Plan_Description'), 'Automated regression plan created by Katalon Studio')
    WebUI.setText(findTestObject('App/Test_Plans/input_Plan_Environment'), 'Staging')
    WebUI.setText(findTestObject('App/Test_Plans/input_Plan_Platform'), 'Web')
    WebUI.click(findTestObject('App/Test_Plans/button_Submit_Test_Plan'))
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

