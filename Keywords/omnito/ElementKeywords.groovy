package omnito

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

class ElementKeywords {
    @Keyword
    TestObject byTestId(String testId) {
        TestObject object = new TestObject('dynamic-' + testId)
        object.addProperty('data-testid', ConditionType.EQUALS, testId)
        return object
    }

    @Keyword
    TestObject byExactText(String tag, String text) {
        TestObject object = new TestObject('dynamic-' + tag + '-' + text)
        object.addProperty('xpath', ConditionType.EQUALS,
            '//' + tag + '[normalize-space(.)=' + xpathLiteral(text) + ']')
        return object
    }

    @Keyword
    void verifyTestIdPresent(String testId) {
        WebUI.verifyElementPresent(byTestId(testId), GlobalVariable.defaultTimeout)
    }

    @Keyword
    void clickTestId(String testId) {
        WebUI.waitForElementClickable(byTestId(testId), GlobalVariable.defaultTimeout)
        WebUI.click(byTestId(testId))
    }

    @Keyword
    void replaceText(TestObject object, String value) {
        WebUI.waitForElementVisible(object, GlobalVariable.defaultTimeout)
        WebUI.clearText(object)
        WebUI.setText(object, value ?: '')
    }

    private String xpathLiteral(String value) {
        if (value.contains("'")) {
            throw new IllegalArgumentException('Exact-text helper does not accept apostrophes: ' + value)
        }
        return "'" + value + "'"
    }
}
