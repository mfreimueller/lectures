# Kata 1: DTO Mapping

| Field | Value |
|-------|-------|
| Concepts | Records, DTOs, mapping between layers |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Write a Java program that:
1. Defines a `User` record (id, username, email, passwordHash, createdAt)
2. Defines a `CreateUserRequest` record (username, email, password)
3. Defines a `UserResponse` record (id, username, email)
4. Implements a mapper that converts CreateUserRequest to User and User to UserResponse
5. Demonstrates the mapping in main()

### Example Output

```
Creating user from request...
User created: User[id=1, username=alice, email=alice@example.com, passwordHash=***, createdAt=2026-05-13T10:00:00]
Public response: UserResponse[id=1, username=alice, email=alice@example.com]
```

### Extension

Add a `UserUpdateRequest` DTO and implement partial update mapping.
