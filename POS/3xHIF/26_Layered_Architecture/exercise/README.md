# Exercise: Refactoring a Monolithic Servlet App (Pre-WMC)

**Type:** Refactoring (Type 1) — Given a working but poorly designed servlet application, students refactor it into a layered architecture.

**Domain:** Library Management System (Book, Member, Loan) — intentionally different from both the e-commerce katas and the invoice system.

**Assigned:** Week 30 (after Layered Architecture)
**Due:** Before WMC project kickoff (Week 32)

---

## Objective

You receive a **working** library management web application. It runs, responds to HTTP requests, and manages books, members, and loans. But it has **no architecture** — everything is crammed into servlets.

Your job is to refactor it into a proper layered architecture:
- **Front Controller** + Command Pattern
- **Service Layer** (business logic)
- **Repository Layer** (data access)
- **DTOs** (request/response separation)
- **Validation** (input checking)
- **Centralized error handling**

---

## The Codebase

The starter code is available as a Maven module in the live-coding repo: `exercise-layered-refactoring`.

It implements a library management system with embedded Tomcat:
- **Books**: CRUD operations (list, get by ID, create, update, delete)
- **Members**: CRUD operations
- **Loans**: Create a loan (member borrows a book), return a loan, list active loans

The codebase contains **~8-10 files** with these deliberate anti-patterns:
- All logic lives in servlets (no layers)
- No DTOs — domain objects are serialized directly to JSON
- No validation — invalid data is accepted silently
- Scattered error handling — `try-catch` with `500` everywhere
- No Front Controller — separate servlet per endpoint
- Static `ArrayList` for data storage (no repository abstraction)
- No service layer — business logic mixed with HTTP handling
- Thread-unsafe mutable state in servlets

---

## Target Architecture

After refactoring, your application should have:

```
at.spengergasse._3xhif.library/
├── framework/
│   ├── FrontControllerServlet.java      // Single entry point
│   ├── Command.java                     // Command interface
│   └── ErrorResponse.java               // Structured error responses
├── controller/
│   ├── BookController.java
│   ├── MemberController.java
│   └── LoanController.java
├── service/
│   ├── BookService.java
│   ├── MemberService.java
│   └── LoanService.java
├── repository/
│   ├── BookRepository.java
│   ├── MemberRepository.java
│   └── LoanRepository.java
├── domain/
│   ├── Book.java
│   ├── Member.java
│   └── Loan.java
├── dto/
│   ├── CreateBookRequest.java
│   ├── BookResponse.java
│   ├── CreateMemberRequest.java
│   ├── MemberResponse.java
│   ├── CreateLoanRequest.java
│   └── LoanResponse.java
├── validation/
│   ├── ValidationException.java
│   └── Validator.java
└── LibraryApp.java                       // Embedded Tomcat setup
```

---

## Requirements

1. **Write tests first** — Write tests for the service layer before refactoring. The existing behavior must be preserved.
2. **Refactor incrementally** — One layer at a time. Run tests after each change.
3. **Document your decisions** — In your PR description, explain:
   - What anti-patterns you found
   - How you restructured the code
   - How you tested each refactoring step
4. **Code review** — Review another student's PR. Leave at least 5 meaningful comments.

---

## Evaluation Criteria

| Criterion | Points |
|-----------|--------|
| Complete layered architecture implemented | 30% |
| Front Controller + Command Pattern | 15% |
| DTOs with validation | 15% |
| Service layer with business logic | 15% |
| Repository abstraction | 10% |
| Tests for service layer | 10% |
| PR documentation + peer code review | 5% |

---

## Hints

- Start with the **repository layer** — extract the data access logic first
- Then create the **service layer** — move business logic out of servlets
- Add **DTOs** — separate request/response objects from domain objects
- Finally, implement the **Front Controller** — replace individual servlets
- The application must still work exactly as before after each step
