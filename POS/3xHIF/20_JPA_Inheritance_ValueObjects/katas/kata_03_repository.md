# Kata 3: Generic Repository

| Field | Value |
|-------|-------|
| Concepts | Repository pattern, generics, EntityTransaction, CRUD |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Build a generic JPA Repository with transaction support:

1. Define `Repository<T, ID>` interface with: findById, findAll, save, delete, deleteById, count
2. Implement `JpaRepository<T, ID>` using EntityManager
3. Create concrete repositories: `StudentRepository`, `CourseRepository`
4. Test the repositories with full CRUD and transaction rollback

### Example Output

```
--- Generic Repository ---
Saved student: Student{id=1, name='Alice'}
All students: [Student{...}, Student{...}]
Count: 2
Deleted student 1
Count after delete: 1

--- Transaction Rollback Test ---
Before rollback: 2 students
Rolling back...
After rollback: 1 student (rollback restored original state)
```

### Extension

Add `findByField(String fieldName, Object value)` using Criteria API for dynamic field queries.
