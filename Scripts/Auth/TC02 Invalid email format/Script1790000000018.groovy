import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/auth')
try {
    CustomKeywords.'omnito.AuthKeywords.submitCredentials'('not-an-email', 'Password123!')
    CustomKeywords.'omnito.BrowserKeywords.verifyUrlContains'('/auth')
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

