# Kata 2: Pattern Matching and Switch Refactoring

| Field | Value |
|-------|-------|
| Concepts | pattern matching, switch expressions, Optional |
| Difficulty | 3/5 |
| Duration | approx. 20 min |

### Task

Refactor the following legacy code that uses instanceof with explicit casting to use pattern matching and switch expressions:

```java
public class ShapeProcessor {
    public double calculateArea(Object shape) {
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return Math.PI * c.getRadius() * c.getRadius();
        } else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.getWidth() * r.getHeight();
        } else if (shape instanceof Triangle) {
            Triangle t = (Triangle) shape;
            return 0.5 * t.getBase() * t.getHeight();
        }
        throw new IllegalArgumentException("Unknown shape");
    }
}
```

1. Define a sealed Shape interface
2. Change the classes to Records
3. Use a switch expression with pattern matching
4. Remove the default clause (sealed guarantees exhaustiveness)

### Extension

Add a `Triangle` type and verify the compiler forces the switch to be updated.
