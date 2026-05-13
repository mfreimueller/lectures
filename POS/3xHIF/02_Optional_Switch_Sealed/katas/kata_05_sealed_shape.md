# Kata 5: Sealed Shape with Exhaustive Switch

| Field | Value |
|-------|-------|
| Concepts | sealed classes, pattern matching, switch expressions, exhaustiveness |
| Difficulty | 3/5 |
| Duration | approx. 20 min |

### Task

1. Define a sealed interface `Shape` with permits `Circle`, `Rectangle`, `Triangle`
2. Each permitted type is a record with appropriate fields:
   - `Circle(double radius)`
   - `Rectangle(double width, double height)`
   - `Triangle(double base, double height)`
3. Write a method `double area(Shape s)` using a switch expression with pattern matching
4. The switch must be exhaustive (no default branch needed)
5. Write a main method that creates instances of each shape and prints their areas

### Example Output

```
Circle radius 5.0: area = 78.54
Rectangle 4.0 x 6.0: area = 24.00
Triangle base 3.0 height 8.0: area = 12.00
```

### Extension

Add a `Triangle` type if not yet present and observe the compile error from a non-exhaustive switch.
