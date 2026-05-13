# Kata 5: Flexible Builder Pattern

| Field | Value |
|-------|-------|
| Concepts | flexible constructor bodies, Records, validation before super() |
| Difficulty | 3/5 |
| Duration | approx. 20 min |

### Task

1. Create a `Person` record with fields `String name, String email, int age`
2. Use a compact constructor that:
   - Validates name is non-empty
   - Validates email contains '@'
   - Validates age is between 0 and 150
   - Normalizes: trims name, lowercases email
3. Use unnamed patterns `_` for exception handling
4. Write a main that creates valid and invalid persons to test validation

### Example Output

```
Valid: Person[name=Alice, email=alice@example.com, age=30]
Invalid: IllegalArgumentException: Name must not be empty
Invalid: IllegalArgumentException: Email must contain @
Invalid: IllegalArgumentException: Age must be between 0 and 150
```

### Extension

Add a Builder inner class for the Person record.
