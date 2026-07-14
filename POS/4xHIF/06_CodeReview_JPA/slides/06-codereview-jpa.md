---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 06 - Code Review: JPA & Tests
## POS - 4xHIF

---

## Why Code Reviews?

- Catch bugs before they reach production
- Share knowledge across teams
- Enforce consistent code quality
- Learn from others' approaches

---

## Review Etiquette

- Be specific: "Line 42: fetch type LAZY would be better here because..."
- Ask questions, don't accuse: "Why did you choose CascadeType.ALL?"
- Praise good solutions too!
- Focus on the code, not the person

---

## Checklist: Entities

- @Entity on all persistent classes?
- @Id and @GeneratedValue configured correctly?
- @Column annotations with nullable, unique, length where needed?
- Table names follow naming convention (lowercase, plural)?

---

## Checklist: Relationships

- Correct relationship type (@OneToMany vs @ManyToMany)?
- mappedBy used on the inverse side of bidirectional relationships?
- Helper methods (addLoan, removeLoan) present?
- Join table names follow convention?

---

## Checklist: Cascade & Fetch

- Cascade types not too aggressive (avoid CascadeType.ALL on @ManyToMany)?
- CascadeType.REMOVE only where it makes sense?
- FetchType.LAZY used everywhere (except rare cases)?
- Any obvious N+1 query risks?

---

## Checklist: Tests

- @DataJpaTest used for repository tests?
- Tests cover: CRUD, relationships, custom queries?
- Edge cases tested (empty results, nulls)?
- AssertJ used for readable assertions?
- Test data set up in @BeforeEach?

---

## Review Process

1. **Assign** — Each team is paired with another (30 min)
2. **Review** — Walk through checklist, file GitHub issues (30 min)
3. **Discuss** — Reviewers present findings to reviewed team (15 min)
4. **Fix** — Each team fixes issues in their own repo (30 min)
5. **Verify** — Reviewers check fixes were applied (15 min)
