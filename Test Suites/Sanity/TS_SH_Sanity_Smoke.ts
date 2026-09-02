<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description>Minimal AI script self-healing smoke: heal one deterministic keyword typo, then continue to one healthy control.</description>
   <name>TS_SH_Sanity_Smoke</name>
   <tag>script-self-healing,sanity,smoke</tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <maxConcurrentInstances>1</maxConcurrentInstances>
   <numberOfRerun>0</numberOfRerun>
   <orchestration>ISOLATED_PROCESS</orchestration>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>false</rerunImmediately>
   <testSuiteGuid>9a7fd115-1a1e-4a13-9000-000000000100</testSuiteGuid>
   <testCaseLink>
      <guid>9a7fd115-1a1e-4a13-9000-000000000101</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Script Healing Fixtures/TC01 Misspelled WebUI keyword</testCaseId>
      <usingDataBindingAtTestSuiteLevel>false</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>9a7fd115-1a1e-4a13-9000-000000000102</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Script Healing Fixtures/TC07 Healthy continuation control</testCaseId>
      <usingDataBindingAtTestSuiteLevel>false</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
</TestSuiteEntity>
