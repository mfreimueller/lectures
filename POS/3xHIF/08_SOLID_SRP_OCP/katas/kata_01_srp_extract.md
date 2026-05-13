# Kata 1: SRP -- Extract Responsibilities

| Field | Value |
|-------|-------|
| Concepts | SRP, refactoring, class extraction |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

You are given a `UserService` class that violates SRP. It handles user validation, database persistence, email notifications, and logging.

Refactor it into separate classes, each with a single responsibility:
- `UserValidator` -- validates user data
- `UserRepository` -- saves/loads users
- `EmailService` -- sends emails
- `Logger` -- logs messages

The `UserService` should delegate to these classes.

```java
class UserService {
    void registerUser(String name, String email) {
        if (name == null || !email.contains("@")) {
            System.out.println("Validation failed");
            return;
        }
        System.out.println("Saving user to database: " + name);
        System.out.println("Sending welcome email to: " + email);
        System.out.println("Log: User registered: " + name);
    }
}
```

### Extension

Add unit tests for each extracted class using JUnit 5.
