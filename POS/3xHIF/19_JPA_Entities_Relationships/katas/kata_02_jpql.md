# Kata 3: JPQL Queries

| Field | Value |
|-------|-------|
| Concepts | JPQL, JOIN, aggregate functions, named queries, TypedQuery |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Using the school domain from Kata 2, write and execute the following JPQL queries:

1. Find all students enrolled in a specific course (by course name)
2. Find the average grade per course
3. Count students per elective
4. Find students who are not enrolled in any course
5. Use a named query to find students by grade level

### Example Output

```
--- JPQL Queries ---
Students in 'Mathematics': [Alice, Bob]
Average grade per course: Mathematics=2.5, Physics=1.0
Students per elective: Chess=2, Robotics=1
Students with no enrollments: [Charlie]
Grade 1 students: [Alice, Charlie]
```

### Extension

Write a JPQL UPDATE query (using `UPDATE ... SET ... WHERE`) to increase all grades by 1 for a specific course.
