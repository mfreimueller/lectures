# Kata 2: Todo CRUD API

| Field | Value |
|-------|-------|
| Concepts | CRUD endpoints, in-memory storage, JSON serialization |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

Write a Java program that builds a REST API for Todos with:
1. GET /api/todos - list all todos
2. GET /api/todos/{id} - get a single todo
3. POST /api/todos - create a new todo
4. PUT /api/todos/{id} - update a todo
5. DELETE /api/todos/{id} - delete a todo

Use a List to store todos in memory. Use a Todo record with id, title, completed fields.

### Example Output

```
$ curl http://localhost:7070/api/todos
[]

$ curl -X POST -H "Content-Type: application/json" \
  -d '{"id":1,"title":"Learn Javalin","completed":false}' \
  http://localhost:7070/api/todos
{"id":1,"title":"Learn Javalin","completed":false}
```

### Extension

Add input validation: title must not be empty, return 400 status for invalid data.
