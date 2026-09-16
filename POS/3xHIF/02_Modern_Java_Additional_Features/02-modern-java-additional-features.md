---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 02 - Modern Java - Additional Features (Bonus)
## POS - 3xHIF

---

## Agenda (1/4)

1. Default Methods
2. Default Methods: Usage
3. Default Method Inheritance
4. Static Methods in Interfaces
5. Pattern Matching for instanceof
6. Pattern Variables Scope

---

## Agenda (2/4)

7. Pattern Matching with Records
8. Complex Pattern Matching
9. Text Blocks
10. Text Block Features
11. Sealed Classes: Motivation
12. Sealed Class Syntax

---

## Agenda (3/4)

13. Sealed + Pattern Matching
14. Unnamed Variables: Motivation
15. Unnamed Variables in Loops
16. Unnamed Variables in Pattern Matching
17. Unnamed Pattern Variables
18. Flexible Constructor Bodies

---

## Agenda (4/4)

19. Common Use Cases
20. Modern String APIs
21. Files and Collection APIs
22. Compact Source Files

---

## Learning Objectives

- I can define interfaces with default and static methods
- I can resolve default method inheritance conflicts
- I can use pattern matching with instanceof and record patterns
- I can write multiline strings using Text Blocks
- I can define sealed class hierarchies with exhaustive pattern matching
- I can use unnamed variables (_) to signal intentionally unused values
- I can write validation logic before super() calls in constructors
- I can use modern String, Files, and Collection APIs to reduce boilerplate
- I can write compact Java programs using implicit classes and instance main methods

---

## Recap: Core Features

```java
var p = new Point(3, 4);

Optional<String> email = findUserEmail(42);
var greeting = email.orElse("unknown@example.com");

var result = switch (day) {
    case MONDAY, FRIDAY -> "Work day";
    default -> "Midweek";
};
```

<div class="highlight-box"><p>Last lesson: var, Records, Optional, and switch expressions. This lesson adds more modern Java features on top.</p></div>

---

## Default Methods

Interfaces can now provide method implementations.

```java
public interface Greeter {
    String name();

    default String greet() {
        return "Hello, " + name() + "!";
    }
}
```

<div class="highlight-box"><p>Default methods allow adding functionality to interfaces without breaking existing implementations.</p></div>

---

## Default Methods: Usage

```java
public record Person(String name) implements Greeter {}

public static void main(String[] args) {
    var p = new Person("Alice");
    System.out.println(p.greet()); // Hello, Alice!
}
```

---

## Default Method Inheritance

- A class wins over an interface (class wins rule)
- Subtype wins over supertype
- Otherwise, the class must override the conflicting method

```java
public interface A {
    default void sayHi() { System.out.println("Hi from A"); }
}
public interface B {
    default void sayHi() { System.out.println("Hi from B"); }
}
public class C implements A, B {
    public void sayHi() { A.super.sayHi(); }
}
```

---

## Discussion: The Diamond Problem

<div class="highlight-box">
<p>Java allows a class to implement multiple interfaces with default methods, which can lead to conflicts. Is multiple interface inheritance a good design choice, or does it introduce unnecessary complexity? How does Java's "class wins" and "subtype wins" rules help mitigate this?</p>
</div>

---

## Static Methods in Interfaces

```java
public interface MathUtils {
    static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    static double celsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }
}
```

<div class="highlight-box"><p>Static interface methods are utility methods that belong to the interface, not to instances.</p></div>

---

## Pattern Matching for instanceof

With pattern matching (Java 16+):

```java
if (obj instanceof String s) {
    System.out.println(s.length());
}
```

<div class="highlight-box"><p>No explicit cast needed; the pattern variable is already in scope.</p></div>

---

## Pattern Variables Scope

```java
// Pattern variable is in scope in the true block
if (obj instanceof String s && s.length() > 5) {
    System.out.println(s); // s is available
}

// Not available after the condition
if (!(obj instanceof String s)) {
    return; // s is NOT available here
}
// s is available here (definite assignment)
System.out.println(s.length());
```

---

## Pattern Matching with Records

```java
public record Point(int x, int y) {}

public static void printPoint(Object obj) {
    if (obj instanceof Point(int x, int y)) {
        System.out.println("Point at (" + x + ", " + y + ")");
    }
}
```

<div class="highlight-box"><p>Record patterns destructure the record into its components.</p></div>

---

## Complex Pattern Matching

```java
// Nested pattern matching
record Address(String street, String city) {}
record Person(String name, Address address) {}

if (obj instanceof Person(var name, Address(var street, var city))) {
    System.out.println(name + " lives on " + street + " in " + city);
}
```

---

## Text Blocks

Multiline strings introduced in Java 13 (preview) and finalized in Java 15.

```java
// Before
String html = "<html>\n" +
              "    <body>\n" +
              "        <p>Hello</p>\n" +
              "    </body>\n" +
              "</html>";

// After
String html = """
    <html>
        <body>
            <p>Hello</p>
        </body>
    </html>
    """;
```

---

## Text Block Features

- Leading whitespace is stripped (based on indentation of closing delimiter)
- Escape sequences work inside text blocks
- New escape: `\s` (space) and `\` (line continuation)

```java
var json = """
    {
        "name": "Alice",
        "age": 30
    }
    """;
```

---

## Sealed Classes: Motivation

Sealed classes restrict which classes can extend them.

```java
public sealed interface Shape
    permits Circle, Rectangle, Triangle {}

public record Circle(double radius) implements Shape {}
public record Rectangle(double w, double h) implements Shape {}
public record Triangle(double a, double b, double c) implements Shape {}
```

<div class="highlight-box"><p>With sealed classes, the compiler knows all subtypes, enabling exhaustive pattern matching without a default clause.</p></div>

---

## Sealed Class Syntax

```java
// Sealed class
public abstract sealed class Vehicle
    permits Car, Truck, Motorcycle {}

// Sealed interface
public sealed interface JsonValue
    permits JsonObject, JsonArray, JsonString, JsonNumber {}

// Subclasses must be: final, sealed, or non-sealed
public final class Car extends Vehicle {}
public sealed class Truck extends Vehicle permits DumpTruck {}
public non-sealed class Motorcycle extends Vehicle {}
```

---

## Sealed + Pattern Matching

```java
public static double calculateArea(Shape shape) {
    return switch (shape) {
        case Circle c   -> Math.PI * c.radius() * c.radius();
        case Rectangle r -> r.width() * r.height();
    };
}
```

<div class="highlight-box"><p>When all sealed subtypes are covered in a switch, the compiler verifies exhaustiveness.</p></div>

---

## Unnamed Variables: Motivation

Sometimes you need a variable only for structure, not for its value.

```java
// Before: unused variable
try {
    int count = processItems();
} catch (Exception e) {
    // e is never used
    System.out.println("Error occurred");
}

// After: unnamed variable
try {
    int count = processItems();
} catch (Exception _) {
    System.out.println("Error occurred");
}
```

---

## Unnamed Variables in Loops

```java
for (var item : items) {
    counter++;
}

for (var _ : items) {
    counter++;
}
```

<div class="highlight-box"><p>Use _ when you need to iterate but dont need the element value.</p></div>

---

## Unnamed Variables in Pattern Matching

```java
// Record pattern with unused components
if (obj instanceof Point(int x, int _)) {
    System.out.println("x = " + x);
}

// Switch with unnamed patterns
String result = switch (obj) {
    case Integer _ -> "It's a number";
    case String _ -> "It's a string";
    default -> "Unknown";
};
```

---

## Unnamed Pattern Variables

```java
// Multiple unused components
record Person(String name, int age, String email) {}

if (obj instanceof Person(var name, int _, String _)) {
    System.out.println("Name: " + name);
}

// Try-with-resources
try (var _ = new Scanner(System.in)) {
    // resource is opened but not directly used
}
```

---

## Flexible Constructor Bodies

Before Java 22, statements in a constructor had to come after super().

```java
// Before: error - cannot use this before super()
public class PositiveInt extends Number {
    private final int value;

    public PositiveInt(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Must be positive");
        }
        super(); // super MUST be first
        this.value = value;
    }
}
```

---

## Flexible Constructor Bodies (Java 22+)

```java
public class PositiveInt extends Number {
    private final int value;

    public PositiveInt(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Must be positive");
        }
        super();
        this.value = value;
    }
}
```

<div class="highlight-box"><p>Statements that dont reference the instance being constructed can appear before super().</p></div>

---

## Reflection: Constructor Design

<div class="highlight-box">
<p>Java 22 allows statements before super() calls, breaking a long-standing rule. How does this change affect traditional constructor design? Does it make code safer by enabling early validation, or more complex by blurring the initialization boundary?</p>
</div>

---

## Common Use Cases

```java
// Validation before super
public class ValidatedHashMap<K, V> extends HashMap<K, V> {
    public ValidatedHashMap(Map<K, V> source) {
        if (source == null) {
            throw new IllegalArgumentException("source must not be null");
        }
        super(source); // super is not first, but thats fine now
    }
}

// Preparation before super
public class Logger extends PrintWriter {
    public Logger(String path) throws IOException {
        var file = new File(path);
        file.getParentFile().mkdirs(); // preparation
        super(file); // Now OK
    }
}
```

---

## Modern String APIs

```java
var text = "  Hello, World!  ";

// New methods
System.out.println(text.isBlank());     // false
System.out.println(text.strip());       // "Hello, World!"
System.out.println(text.repeat(3));     // repeat string
System.out.println("  ".isBlank());     // true

// Lines
"line1\nline2\nline3".lines()
    .forEach(System.out::println);

// Transform
var upper = "hello".transform(s -> s.toUpperCase());
```

---

## Files and Collection APIs

```java
// Files
var content = Files.readString(Path.of("data.txt"));
Files.writeString(Path.of("out.txt"), content);

// Collection factory methods
var list = List.of("a", "b", "c");
var set = Set.of(1, 2, 3);
var map = Map.of("key1", "value1", "key2", "value2");

// Copy of
var copy = List.copyOf(list);
```

---

## Compact Source Files: Motivation

Traditional "Hello World" requires a class and a static main method just to print one line.

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

<div class="highlight-box"><p>JDK 25 (JEP 477) lets small programs skip this boilerplate with implicitly declared classes and instance main methods.</p></div>

---

## Compact Source Files: Syntax

```java
// HelloWorld.java - no class declaration needed
void main() {
    System.out.println("Hello, World!");
}
```

- The compiler wraps the file in an implicit, unnamed top-level class
- `main` can be an instance method and needs no `String[] args`
- Fields and helper methods can live in the same file

```java
int counter = 0;

void increment() {
    counter++;
}

void main() {
    increment();
    increment();
    System.out.println("Counter: " + counter);
}
```

<div class="highlight-box"><p>Meant for small programs, scripts, and learning - not a replacement for regular classes in larger projects.</p></div>

---

## Summary

<div class="highlight-box">
<ul>
<li>Default methods and static methods extend interfaces without breaking implementors</li>
<li>Pattern matching and Text Blocks reduce boilerplate for type checks and multiline strings</li>
<li>Sealed classes enable exhaustive, compiler-checked pattern matching</li>
<li>Unnamed variables, flexible constructor bodies, and modern String/Files/Collection APIs round out the toolbox</li>
<li>Compact source files make small programs quick to write and read</li>
</ul>
</div>
