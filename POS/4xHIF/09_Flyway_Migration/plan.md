# Week 09 - Flyway_Migration

**Index:** 09
**Week in year:** 11
**Theory:** 2h | **Practice:** 2h

---

## Previously Learned Content

| Index | Week | Topics |
|-------|------|--------|
| 08 | Testcontainers | PostgreSQL containers for testing |

## Learning Objectives

- Understand why schema migration tools are necessary in enterprise projects
- Integrate Flyway with Spring Boot
- Write versioned migration scripts (V1__*.sql, V2__*.sql)
- Add and modify tables using new migration files
- Handle migration failures and repair scenarios

## Presentation (slides/)

Introduces Flyway for database schema version control. Covers migration file conventions, Flyway integration with Spring Boot, and best practices for evolving database schemas.

## Katas (katas/)

1. **K1: Initial Migration** — Create the first Flyway migration for the project schema.
2. **K2: Schema Evolution** — Add a second migration that extends an existing table.

## Materials

- Flyway Documentation: https://documentation.red-gate.com/flyway/
- Baeldung: Flyway with Spring Boot
