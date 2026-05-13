# Kata 1: Optional

| Field | Value |
|-------|-------|
| Concepts | Optional, orElse, orElseThrow, ifPresent |
| Difficulty | 2/5 |
| Duration | approx. 15 min |

### Task

1. Create a `UserRepository` class with a `findById(int id)` method returning `Optional<User>`
2. Pre-populate a map with a few users (e.g., Alice, Bob)
3. In main, look up users by ID and handle both present and absent cases
4. Use `orElse()`, `ifPresent()`, and `orElseThrow()` in different scenarios

### Example Output

```
Found: Alice (alice@example.com)
User 42 not found, using default: Guest (guest@example.com)
Error: User with ID 99 not found!
```

### Extension

Add a `findByEmail(String email)` method and chain Optional operations.
