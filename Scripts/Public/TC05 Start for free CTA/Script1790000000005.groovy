import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/')
try {
    WebUI.click(findTestObject('Page_Home/a_Start_For_Free'))
    CustomKeywords.'omnito.BrowserKeywords.verifyUrlContains'('/auth')
    WebUI.verifyElementVisible(findTestObject('Page_Auth/input_Email'))
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

