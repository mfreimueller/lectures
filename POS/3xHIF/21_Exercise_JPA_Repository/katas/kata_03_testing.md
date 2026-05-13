# Kata 3: Integration Tests

| Field | Value |
|-------|-------|
| Concepts | H2 database, JUnit, EntityManagerFactory, test lifecycle |
| Difficulty | 3/5 |
| Duration | approx. 30 min |

### Task

Write JUnit 5 integration tests for the Repository layer using H2 in-memory database:

1. Create a test base class that sets up EntityManagerFactory for H2
2. Test StudentRepository:
   - Save and find a student
   - Update a student's grade
   - Delete a student
   - Find students by grade
   - Count students
3. Test CourseRepository:
   - Save course with teacher relationship
   - Find courses by teacher
   - Find courses with enrollment count
4. Test transaction rollback behavior

### Example Output

```
--- Integration Tests (JUnit + H2) ---
[TEST] testSaveAndFindStudent: PASSED
[TEST] testUpdateStudent: PASSED
[TEST] testDeleteStudent: PASSED
[TEST] testFindByGrade: PASSED
[TEST] testRollback: PASSED
[TEST] testCourseWithTeacher: PASSED
[TEST] testEnrollmentCount: PASSED
```

### Extension

Add a test for cascade persist with orphan removal, verifying that removing an enrollment from a course deletes it from the database.
