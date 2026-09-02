import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/auth')
try {
    WebUI.click(findTestObject('Page_Auth/button_Submit'))
    CustomKeywords.'omnito.BrowserKeywords.verifyUrlContains'('/auth')
    WebUI.verifyElementPresent(findTestObject('Page_Auth/input_Email'), GlobalVariable.shortTimeout)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

