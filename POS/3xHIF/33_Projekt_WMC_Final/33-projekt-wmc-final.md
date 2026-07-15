---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 33 - Projekt WMC Final
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: Project Requirements
2. Review: What We Built
3. Code Cleanup Checklist
4. Documentation: README
5. API Documentation

---

## Agenda (2/2)

6. Javadoc
7. Submission Package
8. Final Checklist
9. Project Demo Tips

---

## Learning Objectives

- I can write a comprehensive README with project description, setup instructions, and API documentation
- I can create an API documentation table listing all endpoints with methods, auth requirements, and responses
- I can clean up code by removing dead code, fixing warnings, and applying consistent formatting
- I can verify all project requirements are met using a final checklist

---

## Review: Project Requirements

- 6+ database tables
- 1:1, 1:n, inheritance relationships
- Authentication with JWT
- Full CRUD via REST API
- Unit and integration tests

---

## Review: What We Built

- Week 27: Project setup, domain choice, ER diagram
- Week 28: User registration, login, JWT auth
- Week 29: JPA entities, relationships, inheritance
- Week 30: REST API endpoints, DTOs, validation
- Week 31: Unit tests, integration tests, error handling

---

## Code Cleanup Checklist

- Remove unused imports and dead code
- Fix all compiler warnings
- Consistent formatting and naming conventions
- Remove System.out.println / debug statements
- Use constants instead of magic strings

---

## Reflection: Why Clean Code Matters

<div class="highlight-box">
<p>Why does clean code matter for grading and for your future self when revisiting this project months later?</p>
</div>

---

## Documentation: README

A good README should contain:

- Project title and description
- Domain explanation and ER diagram
- Technology stack
- Setup instructions (clone, configure, run)
- API documentation (endpoints table)

---

## Now Kata 1: README Documentation

Write a README.md with project description, domain, tech stack, setup instructions, and API endpoints.

---

## API Documentation

```
## API Endpoints

| Method | URL | Description | Auth |
|--------|-----|-------------|------|
| POST   | /api/register | Register user | No |
| POST   | /api/login | Login | No |
| GET    | /api/books | List all books | Yes |
| GET    | /api/books/{id} | Get book | Yes |
| POST   | /api/books | Create book | Admin |
| PUT    | /api/books/{id} | Update book | Admin |
| DELETE | /api/books/{id} | Delete book | Admin |
```

---

## Now Kata 2: API Documentation

Create an API documentation table listing all endpoints grouped by entity with methods, auth, and responses.

---

## Javadoc

```java
/**
 * Service for managing books.
 */
public class BookService {

    /**
     * Creates a new book from the given DTO.
     * @param dto the creation data
     * @return the persisted book
     * @throws BadRequestResponse if category not found
     */
    public Book create(CreateBookDto dto) { ... }
}
```

---

## Submission Package

Option A: Git tag

```bash
git tag -a v1.0 -m "Final submission"
git push origin v1.0
```

Option B: ZIP archive

```bash
git archive -o project.zip HEAD
```

---

## Final Checklist

- All 6+ entities implemented
- 1:1, 1:n, inheritance present
- Authentication working (register + login)
- All CRUD endpoints functional
- Tests pass (unit + integration)

---

## Now Kata 3: Final Review

Go through the final checklist verifying all project requirements are met.

---

## Project Demo Tips

- Prepare a short demo (3-5 minutes)
- Show the ER diagram first
- Demonstrate register/login
- Show CRUD operations on a few entities
- Run a test and show coverage

---

## Summary

<div class="highlight-box">
<ul>
<li>Clean up code and fix warnings</li>
<li>Write README and API documentation</li>
<li>Prepare submission (git tag or ZIP)</li>
<li>Verify all requirements are met</li>
<li>Prepare a short demo presentation</li>
</ul>
</div>
