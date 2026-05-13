# POS-WMC Project - Week 28: Setup, Authentication, Registration

## Task

Implement user registration and login with JPA, BCrypt, and JWT.

### Requirements

1. Create a `User` JPA entity with fields: id, username, email, passwordHash, role, createdAt
2. Create a `UserRepository` with methods for save and findByUsername
3. Create an `AuthService` with register and login methods
4. Hash passwords with BCrypt (cost factor 12)
5. Generate JWT tokens on successful login and registration
6. Create a `POST /api/register` endpoint that accepts username, email, password
7. Create a `POST /api/login` endpoint that accepts username, password
8. Return appropriate HTTP status codes (201 for registration, 200 for login, 400/401 for errors)

### Example Output

```
POST /api/register
Body: {"username": "alice", "email": "alice@example.com", "password": "secret123"}
Response 201: {"token": "eyJhbGci...", "user": {"id": 1, "username": "alice", "email": "alice@example.com", "role": "USER"}}
```

### Extension

Add input validation (email format, password minimum length) and username/email uniqueness checks.
