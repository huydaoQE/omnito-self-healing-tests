import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/')
try {
    def data = findTestData('PublicRoutes')
    for (int row = 1; row <= data.getRowNumbers(); row++) {
        CustomKeywords.'omnito.BrowserKeywords.navigateTo'(data.getValue('path', row))
        WebUI.verifyTextPresent(data.getValue('expectedText', row), false)
    }
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

