# Kata 3: REST Client Library

| Field | Value |
|-------|-------|
| Concepts | Multiple HTTP methods, error handling, reusable client |
| Difficulty | 3/5 |
| Duration | approx. 30 min |

### Task

Write a Java program that builds a reusable REST client with methods for GET, POST, PUT, DELETE. The client should:
1. Support generic type parameters for request/response bodies
2. Handle HTTP errors (non-2xx status codes) with custom exceptions
3. Accept a base URL and endpoint paths
4. Support custom headers

### Example Output

```
GET /posts/1 -> 200: {"userId":1,"id":1,"title":"sunt aut...","body":"..."}
POST /posts -> 201: {"id":101,"title":"foo","body":"bar","userId":1}
PUT /posts/1 -> 200: {"id":1,"title":"updated","body":"...","userId":1}
DELETE /posts/1 -> 200: {}
```

### Extension

Add support for query parameters and request timeout configuration.
