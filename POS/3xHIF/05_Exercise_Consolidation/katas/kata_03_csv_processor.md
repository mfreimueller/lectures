# Kata 3: CSV Processor

| Field | Value |
|-------|-------|
| Concepts | Files API, streams, Records, pattern matching, switch |
| Difficulty | 3/5 |
| Duration | approx. 30 min |

### Task

Write a CSV processor that reads a CSV file with the following format:

```
id,name,age,department,salary
1,Alice,30,Engineering,75000
2,Bob,25,Sales,65000
3,Charlie,35,Engineering,82000
4,Diana,28,Marketing,58000
```

1. Define a `Employee` record
2. Read the file using `Files.lines()` or `Files.readString()`
3. Parse each line into an `Employee` record
4. Use streams to:
   - Find the employee with the highest salary
   - Calculate the average salary per department
   - List employees older than 30
5. Handle invalid lines gracefully (skip with warning)

### Example Output

```
Highest paid: Charlie (82000)
Average salary per department:
  Engineering: 78500.0
  Sales: 65000.0
  Marketing: 58000.0
Employees older than 30:
  Charlie (35)
```

### Extension

Write the summary report to a JSON file using text blocks.
