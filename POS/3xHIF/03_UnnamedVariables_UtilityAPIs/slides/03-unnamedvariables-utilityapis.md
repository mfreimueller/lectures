---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 03 - Unnamed Variables, Utility AP Is
## POS - 3xHIF

---

## Agenda (1/2)

1. Recap: Optional
2. Recap: Sealed + Pattern Matching
3. Unnamed Variables: Motivation
4. Unnamed Variables in Loops
5. Unnamed Variables in Pattern Matching
6. Unnamed Pattern Variables

---

## Agenda (2/2)

7. Flexible Constructor Bodies
8. Flexible Constructor Bodies (Java 22+)
9. Common Use Cases
10. Modern String APIs
11. Files and Collection APIs

---

## Learning Objectives

- I can use unnamed variables (_) to signal intentionally unused values
- I can write validation logic before super() calls in constructors
- I can use modern String, Files, and Collection APIs to reduce boilerplate
- I can read and write files using the Files API

---

## Recap: Optional

```java
var email = findUser(42)
    .map(User::email)
    .orElse("unknown@example.com");
```

<div class="highlight-box"><p>Optional helps avoid NullPointerException.</p></div>

---

## Recap: Sealed + Pattern Matching

```java
sealed interface Shape permits Circle, Rectangle {}

double area = switch (shape) {
    case Circle c -> Math.PI * c.radius() * c.radius();
    case Rectangle r -> r.width() * r.height();
};
```

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

## Now Kata 1: Unnamed Variables

Refactor existing code to use _ for unused variables in catch blocks, loops, and pattern matching.

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

## Now Kata 2: Flexible Builder Pattern

Create a Person record with validation logic in the compact constructor that checks constraints before delegating.

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

## Now Kata 3: Flexible Constructor Bodies

Create a PositiveDouble class extending Number with validation before the super() call.

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

## Now Kata 4: Utility APIs

Read and write files using the Files API, then count words per line in a text file.

---

## Now Kata 5: File Processor with Files API

Walk a directory tree, find all .txt files, and count the total words across all files.

---

## Summary

<div class="highlight-box">
<ul>
<li>Unnamed variables (_) clarify intent when values are unused</li>
<li>Flexible constructor bodies allow validation before super()</li>
<li>Modern APIs (String, Files, Collections) reduce boilerplate</li>
</ul>
</div>
