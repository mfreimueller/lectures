# Kata 2: Custom Validation Annotations

| Field | Value |
|-------|-------|
| Concepts | Annotations, reflection, validation |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

Write a Java program that:
1. Defines `@NotBlank` annotation with a message attribute
2. Defines `@MinLength` annotation with value and message attributes
3. Implements a `Validator` class that uses reflection to validate annotated fields
4. Creates a `CreateUserRequest` class with annotated fields
5. Tests validation with valid and invalid data

### Example Output

```
Validating valid request: []
Validating invalid request: [username: Username must not be blank, email: Email must not be blank, password: too short (min 8)]
```

### Extension

Add `@Email` annotation that validates email format using a regex.
