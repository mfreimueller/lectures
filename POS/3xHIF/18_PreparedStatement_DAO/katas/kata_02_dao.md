# Kata 2: Student DAO Implementation

| Field | Value |
|-------|-------|
| Concepts | DAO pattern, PreparedStatement, List, interface |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

Implement the DAO pattern for a `Student` entity:

1. Define a `Student` record with fields: id, name, email, grade
2. Define a `StudentDao` interface with methods: findById, findAll, save, update, delete
3. Implement `StudentDaoJdbc` using PreparedStatement
4. Use a `DataSource` (HikariCP or simple DriverManager) for connection management

### Example Output

```
--- Student DAO Test ---
Saved: Student[id=1, name=Alice, email=alice@school.com, grade=1]
Found by id: Student[id=1, name=Alice, email=alice@school.com, grade=1]
All students: [Student[id=1, name=Alice, ...], ...]
Updated grade to 2
After delete: 2 students remaining
```

### Extension

Add a `findByGrade(int grade)` method that returns students filtered by grade level.
