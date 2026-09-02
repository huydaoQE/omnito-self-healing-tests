import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String expectedPath = '/plans'
String expectedHeading = 'Plans & Benefits'

CustomKeywords.'omnito.BrowserKeywords.openAt'('/pricing')
try {
    CustomKeywords.'omnito.BrowserKeywords.verifyUrlContains'(expectedPath)
    WebUI.verifyTextPresent(expectedHeading, false)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
