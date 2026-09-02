import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/auth')
try {
    WebUI.click(findTestObject('Page_Auth/button_Register_Toggle'))
    WebUI.verifyTextPresent('Create Account', false)
    WebUI.verifyTextPresent('Already have an account? Sign in', false)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

