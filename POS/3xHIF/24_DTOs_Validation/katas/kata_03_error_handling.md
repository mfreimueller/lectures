# Kata 3: Error Handling Framework

| Field | Value |
|-------|-------|
| Concepts | Exception mappers, structured error responses, global handlers |
| Difficulty | 3/5 |
| Duration | approx. 30 min |

### Task

Write a Java program that builds an error handling framework for a Javalin API:
1. Define a `ErrorResponse` record (status, message, details list)
2. Create custom exceptions: `ResourceNotFoundException`, `ValidationException`
3. Register exception mappers in Javalin
4. Create endpoints that use the error handling
5. Return consistent JSON error responses

### Example Output

```
$ curl http://localhost:7070/api/users/999
{"status":404,"message":"User not found","details":["No user exists with id 999"]}

$ curl http://localhost:7070/api/users -X POST \
  -H "Content-Type: application/json" \
  -d '{"username":"","email":"bad","password":"short"}'
{"status":400,"message":"Validation failed","details":["Username must not be blank","Invalid email format","Password too short"]}
```

### Extension

Add a global exception handler that catches all unhandled exceptions and returns a 500 error with a correlation ID.
