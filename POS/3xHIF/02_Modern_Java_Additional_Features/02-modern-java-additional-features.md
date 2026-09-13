---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 02 - Optional, Switch, Sealed
## POS - 3xHIF

---

## Agenda (1/2)

1. Recap: Pattern Matching
2. Recap: Text Blocks
3. Optional: Motivation
4. Creating Optionals
5. Using Optional
6. Optional with Streams
7. Optional Best Practices

---

## Agenda (2/2)

8. Switch Expressions: Motivation
9. Switch Expressions: Arrow Syntax
10. Switch with Pattern Matching
11. Sealed Classes: Motivation
12. Sealed Class Syntax
13. Sealed + Pattern Matching

---

## Learning Objectives

- I can use Optional to handle potentially absent values safely
- I can chain Optional operations with map and flatMap
- I can write switch expressions using arrow syntax
- I can define sealed class hierarchies with exhaustive pattern matching

---

## Recap: Pattern Matching

```java
if (obj instanceof String s) {
    System.out.println(s.length());
}

if (obj instanceof Point(int x, int y)) {
    System.out.println(x + ", " + y);
}
```

<div class="highlight-box"><p>Pattern matching eliminates casts and improves readability.</p></div>

---

## Recap: Text Blocks

```java
var json = """
    {
        "name": "%s",
        "age": %d
    }
    """.formatted(name, age);
```

---

## Optional: Motivation

Null references are a common source of NullPointerException.

```java
// Problematic
String name = getUserName();
System.out.println(name.toUpperCase()); // NPE if null

// Better with Optional
Optional<String> name = findUserName();
name.ifPresent(n -> System.out.println(n.toUpperCase()));
```

---

## Creating Optionals

```java
Optional<String> opt = Optional.of("Hello");
Optional<String> opt = Optional.ofNullable(nullableValue);
Optional<String> empty = Optional.empty();
```

<div class="highlight-box"><p>Always use Optional.ofNullable for values that may be null!</p></div>

---

## Using Optional

```java
Optional<String> opt = findUserEmail(42);

if (opt.isPresent()) {
    System.out.println(opt.get()); // traditional
}

opt.ifPresent(email -> System.out.println(email)); // preferred

// Default value
var email = opt.orElse("default@example.com");
var email = opt.orElseGet(() -> generateDefault());
var email = opt.orElseThrow(() -> new NotFoundException());
```

---

## Now Kata 1: Optional

Create a UserRepository with a findById method that returns Optional<User> and demonstrate safe access patterns.

---

## Optional with Streams

```java
var numbers = List.of(1, 2, 3, 4, 5);

// Find first even number
Optional<Integer> firstEven = numbers.stream()
    .filter(n -> n % 2 == 0)
    .findFirst();

// Map and filter with Optional
var result = findUser(42)
    .map(User::email)
    .filter(email -> email.endsWith(".com"))
    .orElse("no-email");
```

---

## Now Kata 2: Optional FlatMap Pipeline

Chain Optional operations with flatMap to safely navigate from a user to their order totals.

---

## Optional Best Practices

- Do NOT use Optional for fields or method parameters
- Do NOT use Optional.get() without isPresent() check
- Use Optional as a return type, not a parameter type
- Prefer orElse/orElseGet over checking isPresent

---

## Discussion: Optional for Fields?

<div class="highlight-box">
<p>The best practices say NOT to use Optional for fields, yet some developers find it useful. Why is the community divided on this? Consider serialization, memory overhead, and the intent of Optional as a return type only.</p>
</div>

---

## Switch Expressions: Motivation

Traditional switch has problems: fall-through, no return value.

```java
// Old switch
String result;
switch (day) {
    case MONDAY:
    case FRIDAY:
        result = "Work day";
        break;
    case SATURDAY:
    case SUNDAY:
        result = "Weekend";
        break;
    default:
        result = "Midweek";
}
```

---

## Switch Expressions: Arrow Syntax

```java
var result = switch (day) {
    case MONDAY, FRIDAY -> "Work day";
    case SATURDAY, SUNDAY -> "Weekend";
    default -> "Midweek";
};
```

<div class="highlight-box"><p>Arrow syntax eliminates fall-through and can yield values.</p></div>

---

## Now Kata 3: Switch Expressions

Convert a traditional switch statement with fall-through to a modern switch expression using arrow syntax.

---

## Switch with Pattern Matching

```java
// Java 21: pattern matching in switch
String formatted = switch (obj) {
    case Integer i -> "Integer: " + i;
    case String s -> "String: " + s;
    case null -> "null value";
    default -> "Unknown: " + obj;
};

// Exhaustive with sealed classes
double area = switch (shape) {
    case Circle c   -> Math.PI * c.radius() * c.radius();
    case Rectangle r -> r.width() * r.height();
};
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

## Now Kata 4: Sealed Classes

Define a sealed MediaItem interface with Book, Movie, and Song implementations, then use pattern matching switch to display details.

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

## Now Kata 5: Sealed Shape with Exhaustive Switch

Define a sealed Shape hierarchy with Circle, Rectangle, and Triangle, then write an exhaustive switch to calculate areas.

---

## Summary

<div class="highlight-box">
<ul>
<li>Optional provides a null-safe container for values</li>
<li>Switch expressions use -&gt; syntax and yield values</li>
<li>Sealed classes enable exhaustive pattern matching</li>
<li>Combined, these features lead to safer, more expressive code</li>
</ul>
</div>
