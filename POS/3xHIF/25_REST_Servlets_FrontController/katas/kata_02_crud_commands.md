# Kata 2: CRUD Commands with Jackson

| Field | Value |
|-------|-------|
| Concepts | ObjectMapper, Command pattern, CRUD, status codes |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Extend your Front Controller with Todo CRUD commands:
1. `ListTodosCmd` — GET `/api/todos`, returns all todos as JSON
2. `CreateTodoCmd` — POST `/api/todos`, reads JSON body with Jackson, returns 201
3. `GetTodoCmd` — GET `/api/todos/{id}`, uses regex to parse ID, returns 404 if not found
4. `DeleteTodoCmd` — DELETE `/api/todos/{id}`, returns 204

Use `ObjectMapper` for serialization and deserialization. Store todos in an in-memory `Map`.

### Extension

Add a `PUT:/api/todos/{id}` command for updating a todo. Return 404 if the ID does not exist.