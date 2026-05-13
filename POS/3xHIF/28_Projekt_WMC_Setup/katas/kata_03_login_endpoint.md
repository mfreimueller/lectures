# Kata 3: Login Endpoint

| Field | Value |
|-------|-------|
| Concepts | Javalin, REST, authentication |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Implement a Javalin POST endpoint `/api/login` that:
1. Accepts a JSON body with `username` and `password`
2. Looks up the user in a database (simulate with a hardcoded map)
3. Verifies the password with BCrypt
4. Returns a JWT token and user info as JSON response

### Example Output

Request:
```json
{"username": "alice", "password": "secret123"}
```

Response (201):
```json
{"token": "eyJhbGciOiJIUzI1NiJ9...", "user": {"id": 1, "username": "alice", "role": "USER"}}
```

### Extension

Add input validation: return 400 if fields are missing, return 401 for invalid credentials.
