# Kata 2: Pattern Matching

| Field | Value |
|-------|-------|
| Concepts | instanceof pattern matching, record patterns |
| Difficulty | 2/5 |
| Duration | approx. 15 min |

### Task

Refactor the following code to use pattern matching for instanceof and record patterns:

```java
// Old style
if (shape instanceof Circle) {
    Circle c = (Circle) shape;
    System.out.println("Circle radius: " + c.radius());
} else if (shape instanceof Rectangle) {
    Rectangle r = (Rectangle) shape;
    System.out.println("Rectangle: " + r.width() + " x " + r.height());
}
```

1. Define records `Circle(double radius)` and `Rectangle(double width, double height)` with an interface `Shape`
2. Add a method `area()` to each record
3. In a main method, use pattern matching in a switch or if-else chain to print shape details

### Extension

Use a `sealed` interface for Shape and handle all cases with a pattern matching switch.
