---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 01 - Modern Java: Core Features
## POS - 3xHIF

---

## Agenda (1/2)

1. Local Variable Type Inference
2. var Restrictions
3. var with Collections
4. Records (Java 16+)
5. Record Features
6. Using Records

---

## Agenda (2/2)

7. Optional: Motivation
8. Creating Optionals
9. Using Optional
10. Optional Best Practices
11. Switch Expressions: Motivation
12. Switch Expressions: Arrow Syntax
13. Switch with Pattern Matching

---

## Learning Objectives

- I can use var to declare local variables when the type is obvious
- I can define and use Records as immutable data carriers
- I can use Optional to handle potentially absent values safely
- I can write switch expressions using arrow syntax and pattern matching

---

## Local Variable Type Inference

Introduced in Java 10: `var` keyword

```java
// Before (Java 9 and earlier)
String message = "Hello, World!";
List<String> names = new ArrayList<>();
// After (Java 10+)
var message = "Hello, World!";
var names = new ArrayList<String>();
```

<div class="highlight-box">
<p>
        Rule: Use var when the type is obvious from the right-hand side.
    </p>
</div>

---

## var Restrictions

- Only for local variables (not fields, method params, return types)
- Must be initialized at declaration
- Cannot be used with `null` initializer

```java
// Valid
var count = 42;
var name = "Alice";

// Invalid
var x;              // must initialize
var y = null;       // type cannot be inferred
```

---

## var with Collections

```java
var names = List.of("Alice", "Bob", "Charlie");
var map = new HashMap<String, List<Integer>>();

// Iterating
for (var entry : map.entrySet()) {
    var key = entry.getKey();
    var value = entry.getValue();
}
```

---

## Records (Java 16+)

A Record is a transparent carrier for immutable data.

```java
// After: Record
public record Person(String name, int age) {}
```

<div class="highlight-box"><p>Records automatically generate constructor, accessors, equals, hashCode, and toString.</p></div>

---

## Record Features

```java
public record Point(int x, int y) {
    // Compact constructor
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Negative coordinates");
        }
    }

    // Additional methods
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
}
```

---

## Reflection: When to Use Records?

<div class="highlight-box">
<p>Records are great for immutable data carriers, but when should you still use a full class? Consider: validation logic, mutable state, inheritance, and complex behavior. Can you think of a real-world example where a Record would be the wrong choice?</p>
</div>

---

## Using Records

```java
var p = new Point(3, 4);
System.out.println(p.x());    // 3 (accessor, not getX!)
System.out.println(p.y());    // 4
System.out.println(p);         // Point[x=3, y=4]
System.out.println(p.distanceFromOrigin()); // 5.0

// Pattern matching with records (Java 21)
if (p instanceof Point(int x, int y)) {
    System.out.println(x + ", " + y);
}
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

## Summary

<div class="highlight-box">
<ul>
<li><code>var</code> simplifies local variable declarations</li>
<li>Records provide concise immutable data carriers</li>
<li>Optional provides a null-safe container for values</li>
<li>Switch expressions use -&gt; syntax, yield values, and support pattern matching</li>
</ul>
</div>
