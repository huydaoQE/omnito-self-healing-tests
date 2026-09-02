import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/auth')
try {
    WebUI.setText(findTestObject('Healing_Broken/input_Email_Stale'), 'qa@example.com')
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

