import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
try {
    WebUI.navigateToUrl('https://omnito.dev/plans')
    WebUI.waitForPageLoad(15)
    WebUI.verifyTextPresent('Pricing & Subscriptions', false)
} finally {
    WebUI.closeBrowser()
}
