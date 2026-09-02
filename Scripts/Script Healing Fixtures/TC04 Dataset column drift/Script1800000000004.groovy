import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'omnito.BrowserKeywords.openAt'('/')
try {
    def routes = findTestData('PublicRoutes')
    CustomKeywords.'omnito.BrowserKeywords.navigateTo'(routes.getValue('route', 2))
    WebUI.verifyTextPresent(routes.getValue('expectedText', 2), false)
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
