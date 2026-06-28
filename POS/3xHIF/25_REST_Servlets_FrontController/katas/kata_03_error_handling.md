# Kata 3: Error Handling and Filtering

| Field | Value |
|-------|-------|
| Concepts | Centralized error handling, ErrorResponse, query filtering |
| Difficulty | 4/5 |
| Duration | approx. 30 min |

### Task

Add robust error handling and filtering to your Front Controller:
1. Wrap command execution in try-catch in the front controller servlet
2. On exception, return a `{"status":500,"message":"..."}` JSON error response
3. Create a `TodoNotFoundException` and handle it separately (404)
4. Add query parameter filtering: `GET /api/todos?completed=true` filters todos
5. Validate input in `CreateTodoCmd` — return 400 if title is blank

### Extension

Add an auth check in the front controller: if `req.getHeader("Authorization")` is missing, return 401 before dispatching to any command.