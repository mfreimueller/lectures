# Kata 2: Flexible Constructor Bodies

| Field | Value |
|-------|-------|
| Concepts | constructor, super(), validation, initialization |
| Difficulty | 2/5 |
| Duration | approx. 15 min |

### Task

Create a class `PositiveDouble` that extends `Number`:

1. It wraps a double value that must be positive (> 0)
2. Use flexible constructor body to validate the value before calling `super()`
3. Implement the required abstract methods (`intValue`, `longValue`, `floatValue`, `doubleValue`)

### Example Output

```java
var pd = new PositiveDouble(3.14);
System.out.println(pd.doubleValue()); // 3.14
System.out.println(pd.intValue());    // 3

try {
    var invalid = new PositiveDouble(-1.0);
} catch (IllegalArgumentException e) {
    System.out.println("Invalid: " + e.getMessage());
}
```

### Extension

Add a constructor that accepts a String and parses it, validating the parsed value.
