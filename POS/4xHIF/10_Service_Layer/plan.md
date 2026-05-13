# Week 10 - Service_Layer

**Index:** 10
**Week in year:** 12
**Theory:** 2h | **Practice:** 2h

---

## Previously Learned Content

| Index | Week | Topics |
|-------|------|--------|
| 04-09 | JPA through Flyway | Persistence layer complete |

## Learning Objectives

- Separate business logic from persistence using the Service layer pattern
- Implement `@Service` classes with injected repositories
- Apply `@Transactional` for composite operations
- Use Command objects for complex service parameters

## Presentation (slides/)

Covers the Service layer pattern: separation of concerns, transactional boundaries, and when to use Command objects vs. simple parameters.

## Katas (katas/)

1. **K1: Basic Service** — Create a LibraryService with CRUD methods delegating to repositories.
2. **K2: Transactional Service** — Add a composite operation (check out a book) with @Transactional.

## Materials

- Spring @Service and @Transactional docs
- Patterns of Enterprise Application Architecture (Fowler)
