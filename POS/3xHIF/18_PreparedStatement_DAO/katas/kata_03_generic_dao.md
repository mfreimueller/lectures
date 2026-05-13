# Kata 3: Generic Base DAO

| Field | Value |
|-------|-------|
| Concepts | Generics, DAO, PreparedStatement, reflection |
| Difficulty | 3/5 |
| Duration | approx. 30 min |

### Task

Build a generic base DAO that can work with any entity type:

1. Define a `BaseDao<T>` interface with: findById, findAll, save, update, deleteById
2. Implement `AbstractBaseDao<T>` using PreparedStatement that uses reflection to map fields
3. Create concrete `StudentDao` and `CourseDao` extending the abstract base
4. Demonstrate that both DAOs work correctly

### Example Output

```
--- Generic DAO Test ---
Students: [Student{...}, Student{...}]
Courses: [Course{...}, Course{...}]
```

### Extension

Add pagination support with `findAll(int page, int size)` returning a subset of results.
