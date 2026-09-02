import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/auth')
try {
    def data = findTestData('AuthScenarios')
    for (int row = 1; row <= data.getRowNumbers(); row++) {
        CustomKeywords.'omnito.BrowserKeywords.navigateTo'('/auth')
        CustomKeywords.'omnito.AuthKeywords.submitCredentials'(data.getValue('email', row), data.getValue('password', row))
        CustomKeywords.'omnito.BrowserKeywords.verifyUrlContains'('/auth')
    }
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

