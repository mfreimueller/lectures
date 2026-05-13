# Kata 5: TDD with Mockito

| Field | Value |
|-------|-------|
| Concepts | TDD, Mockito, dependency injection, test doubles |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Build a `UserRegistrationService` using TDD. The service depends on a `UserRepository` interface.

Define:
- `User` record with `String email` and `String name`
- `UserRepository` interface with `boolean existsByEmail(String email)` and `void save(User user)`

Write JUnit 5 tests FIRST using Mockito mocks, then implement:
1. Registration succeeds when email is not taken
2. Registration returns error when email is duplicate
3. `repository.save()` is called exactly once on successful registration
4. Use `Mockito.verify` to verify interactions

### Extension

Add email validation (must contain `@`) and verify that validation happens before repository check using `verify(repository, never())`.
