import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

if (!CustomKeywords.'omnito.AuthKeywords.requireCredentials'()) {
    return
}

WebUI.openBrowser('')
try {
    CustomKeywords.'omnito.AuthKeywords.login'()

    def modules = [
        [path: '/dashboard', object: 'App/Dashboard/page_Dashboard'],
        [path: '/test-cases', object: 'App/Test_Cases/input_Search_Tree'],
        [path: '/test-plans', object: 'App/Test_Plans/input_Plan_Search'],
        [path: '/execution', object: 'App/Execution/overview_Execution'],
        [path: '/defects', object: 'App/Defects/input_Defect_Search'],
        [path: '/knowledge', object: 'App/Knowledge/button_Add_Knowledge'],
        [path: '/ai-generator', object: 'App/AI_Generator/textarea_AI_Input'],
        [path: '/settings', object: 'App/Settings/container_Integrations'],
        [path: '/work/log', object: 'App/Work_Log/button_Open_Log_Dialog'],
        [path: '/work/statistics', object: 'App/Work_Statistics/select_Range_Preset']
    ]

    modules.each { module ->
        CustomKeywords.'omnito.BrowserKeywords.navigateTo'(module.path)
        WebUI.verifyElementPresent(findTestObject(module.object), GlobalVariable.defaultTimeout)
        CustomKeywords.'omnito.BrowserKeywords.verifyUrlContains'(module.path)
    }
} finally {
    CustomKeywords.'omnito.BrowserKeywords.closeSafely'()
}
