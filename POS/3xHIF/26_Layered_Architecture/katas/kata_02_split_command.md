# Kata 1: Split a Fat Command

| Field | Value |
|-------|-------|
| Concepts | Layer separation, Repository interface, InMemoryRepository |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Take a monolithic `ListTodosCmd` that contains all data access logic inline, and:
1. Extract a `TodoRepository` interface with `findAll()`, `findById()`, `save()`, `delete()`
2. Implement `InMemoryTodoRepository`
3. Refactor the command to depend on the repository interface
4. Wire the repository into the command in your bootstrap code

Verify that the API still works with curl after the refactor.