# Kata 4: Modern Java Mini-Project

| Field | Value |
|-------|-------|
| Concepts | Records, streams, Optional, switch expressions, text blocks |
| Difficulty | 3/5 |
| Duration | approx. 20 min |

### Task

Build a small `StudentManager` that:

1. Stores `Student` records with fields `String name, int grade, List<String> subjects`
2. Filters students by minimum grade using streams
3. Finds the top student (highest grade) using Optional
4. Formats a report using text blocks
5. Handles missing data via Optional
6. Uses switch expressions for grade classification (A: 90-100, B: 80-89, etc.)

### Example Output

```
=== Student Report ===
Alice (Grade: 95 - A)
 Subjects: Math, Physics, Chemistry

Bob (Grade: 82 - B)
 Subjects: History, English

=== Top Student ===
Alice with grade 95
```

### Extension

Add a sealed result type for operation outcomes (Success/Failure).
