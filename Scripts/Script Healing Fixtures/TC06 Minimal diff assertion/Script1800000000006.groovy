import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String expectedHeading = 'Plans & Benefits'
String immutableSentinel = 'SELF_HEALING_SENTINEL'

CustomKeywords.'omnito.BrowserKeywords.openAt'('/plans')
try {
    WebUI.verifyTextPresent('Pricing & Subscriptions', false)
    WebUI.verifyMatch(immutableSentinel, 'SELF_HEALING_SENTINEL', false)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
