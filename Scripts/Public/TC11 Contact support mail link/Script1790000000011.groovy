import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/contact')
try {
    WebUI.verifyElementAttributeValue(findTestObject('Page_Contact/a_Email_Support'), 'href', 'mailto:support@omnibox.com.vn', GlobalVariable.shortTimeout)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

