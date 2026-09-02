# Omnito Script Self-Healing Test Project

Katalon Studio project for testing script self-healing against `https://omnito.dev`.

## Baseline

The scripts under `Scripts/Prod Test` are the intentional fault-injection baseline for `TC_001` through `TC_032`. Restore them with Git before a new full self-healing run so that changes from a previous run do not affect the next result.

```bash
git restore -- "Scripts/Prod Test"
```

The related test cases and suites are located under:

- `Test Cases/Prod Test`
- `Test Suites/Prod Test`

## Local credentials

`Profiles/default.glbl` is intentionally excluded from Git because the local profile may contain credentials. Copy `Profiles/default.example.glbl` to `Profiles/default.glbl`, then provide `validEmail`, `validPassword`, or `encryptedPassword` locally before running authenticated journeys.

Do not commit real passwords, encrypted passwords, tokens, reports, or machine-specific analytics settings.

See `README_TEST_COVERAGE.md` for the broader test coverage.
