# Week 08 - Testcontainers_PostgreSQL

**Index:** 08
**Week in year:** 10
**Theory:** 2h | **Practice:** 2h

---

## Previously Learned Content

| Index | Week | Topics |
|-------|------|--------|
| 07 | Configuration & Profiles | application.yml, @ConfigurationProperties, @Profile |

## Learning Objectives

- Explain why H2 is insufficient for testing JPA compatibility
- Configure Testcontainers for PostgreSQL in Spring Boot tests
- Use `@Testcontainers` and `@DynamicPropertySource` for container management
- Write repository tests that run against a real PostgreSQL database

## Presentation (slides/)

Introduces Testcontainers as a solution for testing against real databases. Covers setup, container lifecycle, dynamic property injection, and test configuration.

## Katas (katas/)

1. **K1: Testcontainers Setup** — Configure a PostgreSQL test container for repository tests.
2. **K2: Migrate H2 to Testcontainers** — Convert existing @DataJpaTest from H2 to Testcontainers.

## Materials

- Testcontainers for Java: https://testcontainers.com/guides/getting-started-with-testcontainers-for-java/
- Testcontainers Spring Boot Guide
