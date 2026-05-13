# Week 06 - CodeReview_JPA

**Index:** 06
**Week in year:** 7
**Theory:** 1h | **Practice:** 3h

---

## Previously Learned Content

| Index | Week | Topics |
|-------|------|--------|
| 04 | JPA Repositories | Entity Mapping, Relationships, Queries |
| 05 | Unit Testing JPA H2 | @DataJpaTest, CRUD Tests, Relationship Tests |

## Learning Objectives

- Apply systematic code review criteria to JPA entities and repositories
- Identify common JPA pitfalls (N+1 queries, inappropriate cascade types, missing indexes)
- Give constructive feedback to peer teams
- Fix identified issues in own project

## Presentation (slides/)

Short presentation on code review best practices and a JPA-specific review checklist. The rest of the lesson is dedicated to peer reviews and fixes.

## Katas (katas/)

No formal katas — the entire practice time is used for peer code reviews and implementing fixes.

## Review Checklist

Each team reviews another team's code against these criteria:

1. **Entities**: Correct @Entity, @Id, @GeneratedValue, @Column annotations? Table names sensible?
2. **Relationships**: Correct relationship type? mappedBy used correctly? Bidirectional helpers present?
3. **Cascade**: Cascade types appropriate? No accidental cascade REMOVE on critical relationships?
4. **Fetch**: LAZY used where appropriate? Any obvious N+1 risks?
5. **Queries**: Derived query methods follow naming conventions? @Query uses named parameters?
6. **Tests**: @DataJpaTest present? Tests cover CRUD, relationships, custom queries? AssertJ used?
7. **Code Style**: Consistent formatting? Meaningful names? Dead code or commented-out code?

## Materials

- Code Review Checklist (handout)
- JPA Best Practices Guide
