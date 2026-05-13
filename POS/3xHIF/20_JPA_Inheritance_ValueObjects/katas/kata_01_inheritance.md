# Kata 1: Inheritance Mapping

| Field | Value |
|-------|-------|
| Concepts | @Inheritance, SINGLE_TABLE, JOINED, @DiscriminatorColumn |
| Difficulty | 1/5 |
| Duration | approx. 20 min |

### Task

Map a Person inheritance hierarchy using both SINGLE_TABLE and JOINED strategies:

1. Create abstract `Person` with id and name
2. Create `Student` subclass with studentId and grade
3. Create `Teacher` subclass with employeeId and subject
4. First implement using SINGLE_TABLE, then switch to JOINED
5. Persist one Student and one Teacher, then query all Persons polymorphically

### Example Output

```
--- SINGLE_TABLE Strategy ---
All persons: [Student{name='Alice', grade=1}, Teacher{name='Mr. Smith', subject='Math'}]
Discriminator values: [STU, TCH]
```

### Extension

Add a third subclass `AdminStaff` with `department` and `officeNumber` fields.
