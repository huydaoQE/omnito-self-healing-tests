package omnito

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

class BrowserKeywords {
    private String absoluteUrl(String path) {
        if (path == null || path.trim().isEmpty() || path == '/') {
            return GlobalVariable.baseUrl + '/'
        }
        if (path.startsWith('http://') || path.startsWith('https://')) {
            return path
        }
        return GlobalVariable.baseUrl + (path.startsWith('/') ? path : '/' + path)
    }

    @Keyword
    void openAt(String path = '/') {
        WebUI.openBrowser('')
        WebUI.navigateToUrl(absoluteUrl(path))
        WebUI.waitForPageLoad(GlobalVariable.defaultTimeout)
    }

    @Keyword
    void navigateTo(String path) {
        WebUI.navigateToUrl(absoluteUrl(path))
        WebUI.waitForPageLoad(GlobalVariable.defaultTimeout)
    }

    @Keyword
    void verifyUrlContains(String fragment) {
        WebUI.verifyMatch(WebUI.getUrl(), '.*' + java.util.regex.Pattern.quote(fragment) + '.*', true)
    }

    @Keyword
    void verifyTitleContains(String text) {
        WebUI.verifyMatch(WebUI.getWindowTitle(), '.*' + java.util.regex.Pattern.quote(text) + '.*', true)
    }

    @Keyword
    void verifyHomeFallback() {
        WebUI.verifyTextPresent('Test Management platform for fast-moving teams', false)
    }

    @Keyword
    void closeSafely() {
        try {
            WebUI.closeBrowser()
        } catch (Exception ignored) {
            KeywordUtil.logInfo('Browser was already closed')
        }
    }
}
