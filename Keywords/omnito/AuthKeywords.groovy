package omnito

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

class AuthKeywords {
    private String plainPassword() {
        return String.valueOf(GlobalVariable.validPassword ?: '').trim()
    }

    private String encryptedPassword() {
        return String.valueOf(GlobalVariable.encryptedPassword ?: '').trim()
    }

    @Keyword
    boolean credentialsConfigured() {
        boolean enabled = String.valueOf(GlobalVariable.authenticatedFlowsEnabled).toBoolean()
        return enabled && String.valueOf(GlobalVariable.validEmail).trim() &&
            (plainPassword() || encryptedPassword())
    }

    @Keyword
    boolean requireCredentials() {
        if (credentialsConfigured()) {
            return true
        }
        KeywordUtil.markWarning('Authenticated flow skipped: set validEmail, validPassword or encryptedPassword, and authenticatedFlowsEnabled=true in an execution profile.')
        return false
    }

    @Keyword
    void login() {
        WebUI.navigateToUrl(GlobalVariable.baseUrl + '/auth')
        WebUI.waitForPageLoad(GlobalVariable.defaultTimeout)
        submitConfiguredCredentials()
    }

    @Keyword
    void submitConfiguredCredentials() {
        WebUI.setText(findTestObject('Page_Auth/input_Email'), String.valueOf(GlobalVariable.validEmail))
        if (encryptedPassword()) {
            WebUI.setEncryptedText(findTestObject('Page_Auth/input_Password'), encryptedPassword())
        } else {
            WebUI.setText(findTestObject('Page_Auth/input_Password'), plainPassword())
        }
        WebUI.click(findTestObject('Page_Auth/button_Submit'))
        WebUI.waitForElementPresent(findTestObject('App/Dashboard/page_Dashboard'), GlobalVariable.defaultTimeout)
    }

    @Keyword
    void submitCredentials(String email, String password) {
        WebUI.setText(findTestObject('Page_Auth/input_Email'), email ?: '')
        WebUI.setText(findTestObject('Page_Auth/input_Password'), password ?: '')
        WebUI.click(findTestObject('Page_Auth/button_Submit'))
    }

    @Keyword
    void verifyAuthenticationError() {
        TestObject error = findTestObject('Page_Auth/p_Auth_Error')
        error.addProperty('xpath', ConditionType.EQUALS, "//*[@id='auth-error' or @role='alert' or contains(@class,'error') or contains(@class,'alert')]")
        WebUI.verifyElementPresent(error, GlobalVariable.defaultTimeout)
    }
}
