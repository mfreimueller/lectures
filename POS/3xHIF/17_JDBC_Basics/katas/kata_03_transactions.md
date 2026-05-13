# Kata 3: Transactional Batch Insert

| Field | Value |
|-------|-------|
| Concepts | Transaction, batch insert, rollback, SQLException |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Write a Java program that inserts multiple students within a transaction. If any insert fails (e.g., duplicate email), the entire transaction must roll back and no partial data should remain.

1. Disable auto-commit on the connection
2. Insert 4 students in a loop
3. The 3rd insert deliberately uses a duplicate email to trigger an error
4. On error, rollback the transaction and print "Transaction rolled back"
5. On success, commit the transaction and print "Transaction committed"
6. After rollback, verify the table is empty

### Example Output

```
Starting batch insert...
Inserting: David (david@school.com)
Inserting: Eva (eva@school.com)
Inserting: Frank (frank@school.com)
Inserting: Grace (alice@school.com) -- duplicate!
Error: ERROR: duplicate key value violates unique constraint
Transaction rolled back.
Student count after rollback: 0
```

### Extension

Use Savepoints to allow partial commits even when some inserts fail.
