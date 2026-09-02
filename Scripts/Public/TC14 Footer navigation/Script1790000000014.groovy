import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/')
try {
    WebUI.scrollToElement(findTestObject('Common/a_Footer_Documentation'), GlobalVariable.defaultTimeout)
    WebUI.click(findTestObject('Common/a_Footer_Documentation'))
    CustomKeywords.'omnito.BrowserKeywords.verifyUrlContains'('/docs')
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/')
    WebUI.scrollToElement(findTestObject('Common/a_Footer_Support'), GlobalVariable.defaultTimeout)
    WebUI.click(findTestObject('Common/a_Footer_Support'))
    CustomKeywords.'omnito.BrowserKeywords.verifyUrlContains'('/contact')
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

