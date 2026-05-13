# Kata 2: CRUD Operations

| Field | Value |
|-------|-------|
| Concepts | Statement, ResultSet, executeQuery, executeUpdate |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Write a Java program that performs CRUD operations on a `student` table using Statement:
1. **Create:** Insert 3 new students
2. **Read:** Select and print all students
3. **Update:** Change the grade of one student
4. **Delete:** Remove one student by id

Assume the table schema:
```sql
CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    grade INT DEFAULT 1
);
```

### Example Output

```
Inserted 3 students.
All students:
1: Alice (alice@school.com) - Grade 1
2: Bob (bob@school.com) - Grade 2
3: Charlie (charlie@school.com) - Grade 1
Updated grade for student 1.
Deleted student 2.
Remaining: 2 students.
```

### Extension

Add error handling for duplicate email violations and print the SQL error code.
