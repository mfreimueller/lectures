# Kata 2: School Domain Relationships

| Field | Value |
|-------|-------|
| Concepts | @OneToMany, @ManyToOne, @ManyToMany, @JoinTable, cascade |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

Model a school domain using JPA relationships:

1. **Course** `1---*` **Enrollment** (one course has many enrollments)
2. **Student** `1---*` **Enrollment** (one student can have many enrollments)
3. **Student** `*---*` **Elective** (students can choose multiple electives)

Define all entities with proper annotations, cascade types, and bidirectional navigation.

### Example Output

```
--- School Relationships ---
Course 'Mathematics' with 2 enrollments
Student 'Alice' enrolled in: Mathematics, Physics
Student 'Bob' chose electives: Chess, Robotics
```

### Extension

Add `orphanRemoval = true` to the Course-Enrollment relationship and test that removing an orphaned enrollment deletes it from the database.
