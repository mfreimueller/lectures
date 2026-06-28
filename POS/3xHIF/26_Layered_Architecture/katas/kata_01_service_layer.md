# Kata 2: Add a Service Layer

| Field | Value |
|-------|-------|
| Concepts | Service interface, business logic, constructor injection |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Add a Service layer between your Commands and Repository:
1. Define a `TodoService` interface with `getAll()`, `getById()`, `create()`, `delete()`
2. Implement `TodoServiceImpl` that depends on `TodoRepository` via constructor injection
3. Move validation logic into the service (e.g., reject blank titles)
4. Update commands to depend on `TodoService` instead of `TodoRepository`

Wire everything manually in your bootstrap code.

### Extension

Add a `findByCompleted(boolean)` method to the service for filtering completed/incomplete todos.