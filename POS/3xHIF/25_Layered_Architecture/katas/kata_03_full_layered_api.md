# Kata 3: Full Three-Layer API

| Field | Value |
|-------|-------|
| Concepts | Interfaces, DI, testability |
| Difficulty | 3/5 |
| Duration | approx. 35 min |

### Task

Build a complete three-layer Todo API with:
1. **Repository layer**: `TodoRepository` interface + `InMemoryTodoRepository`
2. **Service layer**: `TodoService` interface + `TodoServiceImpl` with validation and business rules
3. **Controller layer**: `TodoController` that registers routes on a Javalin instance
4. **DTOs**: `CreateTodoRequest`, `UpdateTodoRequest`, `TodoResponse`
5. **Wiring**: Constructor injection in main()

The API should support:
- GET /api/todos - list all todos (with optional ?completed=true/false filter)
- GET /api/todos/{id} - get single todo
- POST /api/todos - create todo
- PUT /api/todos/{id} - update todo
- DELETE /api/todos/{id} - delete todo

### Example Output

```
$ curl http://localhost:7070/api/todos
[]

$ curl -X POST -H "Content-Type: application/json" \
  -d '{"title":"Learn layered architecture","completed":false}' \
  http://localhost:7070/api/todos
{"id":1,"title":"Learn layered architecture","completed":false}
```

### Extension

Add integration tests that test the service layer with an in-memory repository without starting the HTTP server.
