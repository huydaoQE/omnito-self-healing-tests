import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/')
try {
    WebUI.click(findTestObject('Common/a_Nav_Plans'))
    WebUI.verifyElementVisible(findTestObject('Page_Plans/h1_Plans_Benefits'))
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

