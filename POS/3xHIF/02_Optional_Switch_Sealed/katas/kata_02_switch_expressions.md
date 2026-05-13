# Kata 2: Switch Expressions

| Field | Value |
|-------|-------|
| Concepts | switch expression, arrow syntax, yield |
| Difficulty | 2/5 |
| Duration | approx. 15 min |

### Task

Rewrite the following traditional switch as a switch expression:

```java
// Traditional switch
String priority;
switch (level) {
    case 1:
        priority = "Low";
        break;
    case 2:
        priority = "Medium";
        break;
    case 3:
        priority = "High";
        break;
    case 4:
        priority = "Critical";
        break;
    default:
        priority = "Unknown";
}
```

1. Convert to a switch expression using arrow syntax
2. Add a method that uses switch expression with yield for complex cases
3. Handle multiple labels in one case

### Extension

Use pattern matching in switch to handle different types of log messages (String, Exception, Record).
