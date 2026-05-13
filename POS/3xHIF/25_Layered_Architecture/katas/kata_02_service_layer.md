# Kata 2: Add Service Layer

| Field | Value |
|-------|-------|
| Concepts | Service layer, constructor injection, business logic |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

Extend the previous kata by adding a Service layer:
1. Create a `UserService` interface with methods: createUser, getUser, getAllUsers, deleteUser
2. Implement `UserServiceImpl` with:
   - Validation (name and email must not be blank)
   - Business rule: email must be unique
   - Mapping between domain User and response DTO
3. Inject UserRepository via constructor
4. Demonstrate the service in main()

### Example Output

```
Creating user alice... UserResponse[id=1, name=Alice, email=alice@test.com]
Creating duplicate email... ValidationException: Email already exists
Getting user 1... UserResponse[id=1, name=Alice, email=alice@test.com]
All users: [UserResponse[id=1, name=Alice, email=alice@test.com]]
```

### Extension

Add a `updateUser` method with partial update support.
