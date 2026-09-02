import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/')
try {
    WebUI.setViewPortSize(390, 844)
    WebUI.verifyElementPresent(findTestObject('Page_Home/h1_Hero'), GlobalVariable.defaultTimeout)
    WebUI.setViewPortSize(1440, 900)
    WebUI.verifyElementPresent(findTestObject('Common/a_Nav_Docs'), GlobalVariable.defaultTimeout)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

