# Kata 2: JWT Token Utility

| Field | Value |
|-------|-------|
| Concepts | JWT, token generation, token validation |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Create a utility class `JwtUtil` with:
1. A method `generate(Long userId, String role)` that creates a JWT token valid for 24 hours
2. A method `validate(String token)` that parses and validates the token, returning the claims
3. Use HMAC-SHA256 with a secret key (at least 256 bits)

### Example Output

```
Token: eyJhbGciOiJIUzI1NiJ9...
Claims: {sub=42, role=USER, iat=..., exp=...}
```

### Extension

Add a method `getUserId(String token)` and `getRole(String token)` that extract individual claims.
