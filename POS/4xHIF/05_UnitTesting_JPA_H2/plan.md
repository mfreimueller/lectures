# Week 05 - UnitTesting_JPA_H2

**Index:** 05
**Week in year:** 6
**Theory:** 2h | **Practice:** 2h

---

## Previously Learned Content

| Index | Week | Topics |
|-------|------|--------|
| 04 | JPA Repositories | @Entity, Repositories, Relationships, Custom Queries |

## Learning Objectives

- Write repository tests using `@DataJpaTest`
- Configure H2 as an in-memory test database
- Test CRUD operations and custom query methods
- Test entity relationships and cascade behavior
- Use `@BeforeEach` to set up test data

## Presentation (slides/)

Covers testing strategies for JPA repositories using `@DataJpaTest` and H2. Explains test isolation, test data setup, and how to test relationships and custom queries.

## Katas (katas/)

1. **K1: Repository CRUD Tests** — Test save, findById, findAll, delete for BookRepository.
2. **K2: Relationship Tests** — Test that relationships and cascades work correctly.
3. **K3: Custom Query Tests** — Test derived and JPQL queries with various parameters.

## Materials

- Spring Boot Testing: https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing
- Baeldung: @DataJpaTest Guide
