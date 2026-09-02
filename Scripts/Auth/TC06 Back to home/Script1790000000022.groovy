import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/auth')
try {
    WebUI.click(findTestObject('Page_Auth/button_Back_Home'))
    WebUI.verifyElementVisible(findTestObject('Page_Home/h1_Hero'))
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

