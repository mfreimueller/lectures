# Kata 1: SQL Injection Fix

| Field | Value |
|-------|-------|
| Concepts | SQL injection, PreparedStatement, parameterized queries |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

1. Write a method `findStudentByName(String name)` that uses **Statement** (vulnerable version) and demonstrates SQL injection.
2. Show that the input `' OR '1'='1` returns all students.
3. Rewrite the method using **PreparedStatement** to prevent injection.
4. Verify that the same malicious input returns no results (or only the intended match).

### Example Output

```
--- Vulnerable version (Statement) ---
Searching for: ' OR '1'='1
Result: ALL students returned! (SQL injection successful!)
Students: [Alice, Bob, Charlie, David]

--- Fixed version (PreparedStatement) ---
Searching for: ' OR '1'='1
Result: No students found. (Injection prevented!)
Students: []
```

### Extension

Also test input `'; DROP TABLE student; --` and show that PreparedStatement prevents it.
