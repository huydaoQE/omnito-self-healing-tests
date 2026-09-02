# Omnito Katalon Web Coverage

This project contains broad coverage for the public and authenticated Omnito web application.

## Suites

- `TS_Public_Smoke`: public landing pages, navigation, CTAs, documentation, plans, contact and responsive checks.
- `TS_Auth_And_Access_Control`: negative authentication and anonymous access to protected routes.
- `TS_Authenticated_Regression`: credential-gated dashboard, test cases, plans, executions, reports, defects, knowledge, AI Generator, settings and work tracking.
- `TS_Navigation_Login_Journeys`: eight longer end-to-end journeys covering public navigation, login recovery, authenticated modules, forms, logout/relogin, browser history and refresh.
- `TS_Status_And_Work_Log_Lifecycle`: state-changing tests that create and remove a custom bug status, then create and verify a Work Log record.
- `TS_Web_Regression_Parallel`: full non-healing regression using isolated parallel processes.
- `TS_Script_Self_Healing_Lab`: isolated parallel suite containing four intentional failures and two healthy controls.

## Authenticated execution

Authenticated scripts safely stop with a warning until these profile values are configured:

- `authenticatedFlowsEnabled=true`
- `validEmail=<runtime value>`
- either `validPassword=<runtime value>` or `encryptedPassword=<Katalon encrypted value>`

Prefer `encryptedPassword` with `WebUI.setEncryptedText`; do not store a plaintext password in scripts or test data files.

## Script Self-Healing lab

The `Healing Lab` folder intentionally contains:

1. A stale home-page heading locator.
2. A stale Docs route locator.
3. A stale authentication email-field locator.
4. An outdated Plans heading assertion.

Run `TS_Script_Self_Healing_Lab` in its configured `ISOLATED_PROCESS` mode. These cases are expected to fail before healing and should not be mixed into ordinary pass-rate reporting.

## Test data

- `PublicRoutes`
- `ProtectedRoutes`
- `AuthScenarios`
- `TestCaseSamples`
- `DefectSamples`

Selectors were derived from the live `https://omnito.dev` application. Stable `data-testid` selectors are preferred for authenticated application pages.
