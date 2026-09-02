import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://omnito.dev/plans')
try {
    WebUI.navigateToUrl('https://omnito.dev/plans')
    WebUI.waitForPageLoad(30)
    WebUI.verifyTextPresnt('Plans & Benefits', false)
} finally {
    WebUI.closeBrowser()
}
