# Kata 1: LSP -- Rectangle/Square

| Field | Value |
|-------|-------|
| Concepts | LSP, inheritance, composition |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

The following code violates LSP. Refactor it so that Square and Rectangle do not share an inheritance relationship but both implement a common `Shape` interface.

```java
class Rectangle {
    protected int width, height;
    void setWidth(int w) { width = w; }
    void setHeight(int h) { height = h; }
    int area() { return width * height; }
}

class Square extends Rectangle {
    void setWidth(int w) { super.setWidth(w); super.setHeight(w); }
    void setHeight(int h) { super.setWidth(h); super.setHeight(h); }
}
```

Create an interface `Shape` with `int area()` and let both Rectangle and Square implement it independently.

### Example Output

```java
Shape rect = new Rectangle(3, 4);
Shape square = new Square(5);
System.out.println(rect.area());   // 12
System.out.println(square.area()); // 25
```

### Extension

Add a `Circle` class implementing Shape.
