# Kata 1: Entity Layer

| Field | Value |
|-------|-------|
| Concepts | @Entity, @Inheritance, @Embeddable, relationships |
| Difficulty | 2/5 |
| Duration | approx. 30 min |

### Task

Define all entity classes for a school management system:

1. **Person** (abstract) with inheritance: Student and Teacher subclasses (JOINED strategy)
2. **Address**, **Email**, **Money** as @Embeddable value objects
3. **Course** with @OneToMany to Enrollment
4. **Enrollment** as join entity with @ManyToOne to both Student and Course
5. **Elective** with @ManyToMany to Student

Create `persistence.xml` for H2 in-memory database with `hibernate.hbm2ddl.auto=create-drop`.

### Expected Entity List

- `Person` (abstract, JOINED inheritance)
- `Student` extends Person (studentId, grade, @Embedded Address, @Embedded Email, @ManyToMany Elective)
- `Teacher` extends Person (employeeId, subject, @Embedded Address, @Embedded Email, @Embedded Money salary)
- `Course` (title, @OneToMany Enrollment)
- `Enrollment` (@ManyToOne Student, @ManyToOne Course, grade, semester)
- `Elective` (name, maxStudents, @ManyToMany Student)

### Extension

Add `@Entity Listeners` for audit logging (e.g., log creation and modification timestamps).
