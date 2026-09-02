package omnito

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testdata.TestData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import internal.GlobalVariable

class DataKeywords {
    @Keyword
    Map<String, String> row(String dataId, int rowNumber) {
        TestData data = findTestData(dataId)
        Map<String, String> result = [:]
        data.columnNames.each { String column ->
            result[column] = data.getValue(column, rowNumber)
        }
        return result
    }

    @Keyword
    int rowCount(String dataId) {
        return findTestData(dataId).rowNumbers
    }

    @Keyword
    String uniqueName(String suffix) {
        String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern('yyyyMMdd-HHmmss'))
        return GlobalVariable.artifactPrefix + ' ' + suffix + ' ' + stamp
    }
}
