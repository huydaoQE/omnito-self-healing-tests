import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

CustomKeywords.'omnito.BrowserKeywords.openAt'('/docs')
try {
    ['Page_Docs/button_Create_Manage_Test_Cases',
     'Page_Docs/button_AI_Generated_Test_Cases',
     'Page_Docs/button_Test_Plans',
     'Page_Docs/button_Test_Executions',
     'Page_Docs/button_Reporting_Analytics',
     'Page_Docs/button_Knowledge_Automation'].each { String id ->
        WebUI.click(findTestObject(id))
    }
    WebUI.verifyTextPresent('Watch the guided walkthrough', false)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}

