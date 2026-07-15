---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 27 - CI/CD
## POS - 4xHIF

---

## Was ist CI/CD?

- **Continuous Integration:** Jeder Push wird gebaut + getestet
- **Continuous Delivery:** Automatischer Deploy in Test/Staging
- **Continuous Deployment:** Automatischer Deploy in Production

---

## GitHub Actions Workflow

```yaml
name: CI
on: [push, pull_request]
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with: { java-version: '17', distribution: 'temurin' }
      - run: mvn -B verify
```

---

## Docker Build + Push

```yaml
- name: Build and push Docker image
  uses: docker/build-push-action@v5
  with:
    context: .
    push: true
    tags: user/app:latest
```
