# Kata 1: JPA Entity CRUD

| Field | Value |
|-------|-------|
| Concepts | @Entity, @Id, @GeneratedValue, EntityManager, persistence.xml |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Create a JPA project with H2 database and implement CRUD for a `Student` entity:

1. Define a `Student` entity with id, name, email, grade
2. Create `persistence.xml` for H2 in-memory database
3. Use EntityManager to: persist 3 students, find by id, query all with JPQL, update a grade, remove a student
4. Use try-with-resources pattern for EntityManager

### Example Output

```
--- JPA Entity CRUD ---
Persisted: Student{id=1, name='Alice', email='alice@school.com', grade=1}
Persisted: Student{id=2, name='Bob', email='bob@school.com', grade=2}
Persisted: Student{id=3, name='Charlie', email='charlie@school.com', grade=1}
All students: [Student{...}, Student{...}, Student{...}]
Found by id: Student{id=2, name='Bob', ...}
Updated Bob's grade to 1
After remove: 2 students remaining
```

### Extension

Add validation: throw an exception if email already exists (use JPQL count query before persist).
