# Kata 2: Repository Layer

| Field | Value |
|-------|-------|
| Concepts | Repository pattern, generics, JPQL, EntityTransaction |
| Difficulty | 2/5 |
| Duration | approx. 30 min |

### Task

Implement a Repository layer for the school domain:

1. Define `Repository<T, ID>` interface with standard CRUD methods
2. Implement `JpaRepository<T, ID>` using EntityManager
3. Create concrete repositories: `StudentRepository`, `TeacherRepository`, `CourseRepository`
4. Add custom query methods using JPQL:
   - `StudentRepository`: findByGrade, findWithNoEnrollments, findByElective
   - `TeacherRepository`: findBySubject, findTeachersWithSalaryAbove
   - `CourseRepository`: findByTeacher, findCoursesWithEnrollmentCount
5. Test all repository methods with transaction management

### Example Output

```
--- Repository Layer ---
Created 3 students, 2 teachers, 3 courses
Students in grade 1: [Alice, Charlie]
Teachers of Mathematics: [Mr. Smith]
Courses with enrollments: Mathematics(2), Physics(1)
```

### Extension

Add pagination support: `findAll(int page, int size)` that returns a Page<T> with total count.
