import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/')
try {
    WebUI.click(findTestObject('Page_Home/a_Watch_Product_Tour'))
    WebUI.verifyElementVisible(findTestObject('Page_Docs/h1_Omnito_Functions'))
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

