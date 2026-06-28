# Kata 4: Optional FlatMap Pipeline

| Field | Value |
|-------|-------|
| Concepts | Optional, flatMap, map, orElseThrow |
| Difficulty | 2/5 |
| Duration | approx. 15 min |

### Task

1. Define a `User` record with fields `int id, String name, String email`
2. Define an `Order` record with fields `int id, int userId, double total`
3. Write a service class that:
   - Maintains a `List<User>` and a `List<Order>`
   - Has a method `findUserById(int id)` returning `Optional<User>`
   - Has a method `findOrderByUserId(int userId)` returning `Optional<Order>`
   - Combines them using `flatMap` to get the order total for a user
4. Print the result or "User or order not found"

### Example Output

```
Order total for user 1: 149.99
```

### Extension

Replace `orElse` with `orElseThrow` using a custom `UserNotFoundException`.
