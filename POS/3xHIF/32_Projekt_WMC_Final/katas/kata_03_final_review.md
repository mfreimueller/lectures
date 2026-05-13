# Kata 3: Final Review

| Field | Value |
|-------|-------|
| Concepts | Code review, checklist, quality assurance |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Go through the final checklist and verify your project meets all requirements:

1. At least 6 JPA entities exist
2. At least one 1:1 relationship
3. At least one 1:n relationship
4. At least one inheritance case
5. User registration and login work
6. JWT authentication is implemented
7. All CRUD endpoints exist (GET, POST, PUT, DELETE)
8. DTOs are used for request/response
9. Input validation is implemented
10. Unit tests exist (at least 10)
11. Error handling is consistent
12. Layered architecture (Controller, Service, Repository)

### Example Output

```
Final Review Checklist:
[x] 6+ entities: User, Address, Category, Book, PhysicalBook, EBook, Loan, Review, Author
[x] 1:1 relationship: User - Address
[x] 1:n relationship: Category - Book
[x] Inheritance: Book -> PhysicalBook, EBook
[x] Authentication: /api/register, /api/login
[x] JWT: implemented with jjwt
[x] CRUD: GET, POST, PUT, DELETE for books, categories, loans
[x] DTOs: BookDto, CreateBookDto, etc.
[x] Validation: title, isbn, year validated
[x] Tests: 15 unit tests, 5 integration tests
[x] Error handling: 400, 401, 404, 500
[x] Layered: controller, service, repository packages
```

### Extension

Add a code quality section: check for unused imports, formatting, and naming conventions.
