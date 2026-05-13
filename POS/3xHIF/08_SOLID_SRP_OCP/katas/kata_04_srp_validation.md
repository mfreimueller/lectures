# Kata 4: SRP - Extract Validation

| Field | Value |
|-------|-------|
| Concepts | SRP, separation of concerns, class extraction |
| Difficulty | 2/5 |
| Duration | approx. 15 min |

### Task

Given a `UserController` class that handles HTTP requests, validation, persistence, and logging, refactor it by extracting responsibilities:

1. Extract validation logic into a `UserValidator` class
2. Extract persistence logic into a `UserRepository` class
3. The `UserController` should only handle HTTP concerns

The original class does:
- Validates user input (name not empty, email contains @, age >= 0)
- Saves user to a list/database
- Logs actions
- Returns HTTP-like responses

### Extension

Add a `UserService` layer between controller and repository so the dependency flow is: controller -> service -> repository.
