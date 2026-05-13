# Kata 1: Build + Test

| Field | Value |
|-------|-------|
| Concepts | GitHub Actions, workflow, Maven build |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Create `.github/workflows/ci.yml`:

```yaml
name: CI

on:
  push:
    branches: [main]
  pull_request:
    branches: [main]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
          cache: maven
      - name: Build with Maven
        run: mvn -B verify
```

2. Push to GitHub and verify the workflow runs

3. Check the Actions tab in the GitHub repository

### Extension

Add a matrix build that runs on both Ubuntu and Windows. Add a `workflow_dispatch` trigger so the workflow can be run manually.
