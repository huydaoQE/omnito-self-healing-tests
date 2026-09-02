String expectedTitleFragment = 'Omnito'

CustomKeywords.'omnito.BrowserKeywords.openAt'('/')
try {
    CustomKeywords.'omnito.BrowserKeywords.verifyTitleContains'()
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
