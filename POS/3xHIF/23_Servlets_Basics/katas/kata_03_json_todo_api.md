# Kata 3: JSON Todo API

| Field | Value |
|-------|-------|
| Concepts | Servlet routing, JSON, in-memory CRUD, status codes |
| Difficulty | 3/5 |
| Duration | approx. 30 min |

### Task

Build a servlet mapped at `/api/todos/*` that:
1. GET `/api/todos` — returns all todos as JSON
2. GET `/api/todos/{id}` — returns one todo or 404
3. POST `/api/todos` — reads JSON body, creates a todo, returns 201
4. DELETE `/api/todos/{id}` — deletes a todo, returns 204

Use `getPathInfo()` to parse the ID. Store todos in an in-memory `Map`. Set appropriate Content-Type and status codes.

### Example Output

```
$ curl http://localhost:8080/api/todos
[{"id":1,"title":"Learn Servlets","completed":false}]

$ curl -X POST -H "Content-Type: application/json" \
    -d '{"title":"Build API","completed":false}' \
    http://localhost:8080/api/todos
{"id":2,"title":"Build API","completed":false}

$ curl -X DELETE http://localhost:8080/api/todos/1
(204 No Content)
```

### Extension

Add PUT for updating a todo. Add a `GET /api/todos?completed=true` filter using `getParameter()`.