import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String expectedHeading = 'Plans & Benefits'

CustomKeywords.'omnito.BrowserKeywords.openAt'('/plans')
try {
    WebUI.verifyTextPresent(expectedHeadng, false)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
