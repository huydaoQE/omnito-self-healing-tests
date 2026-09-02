import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/')
try {
    WebUI.click(findTestObject('Healing_Broken/h1_Home_Hero_Stale'))
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

