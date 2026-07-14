---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 01 - Interfaces, Pattern Matching
## POS - 3xHIF

---

## Agenda (1/2)

1. Recap: Records
2. Recap: var
3. Default Methods
4. Default Methods: Usage
5. Default Method Inheritance
6. Static Methods in Interfaces

---

## Agenda (2/2)

7. Pattern Matching for instanceof
8. Pattern Variables Scope
9. Pattern Matching with Records
10. Complex Pattern Matching
11. Text Blocks
12. Text Block Features

---

## Learning Objectives

- I can define interfaces with default and static methods
- I can resolve default method inheritance conflicts
- I can use pattern matching with instanceof and record patterns
- I can write multiline strings using Text Blocks

---

## Recap: Records

```java
// Last week: Records
public record Person(String name, int age) {}

var p = new Person("Alice", 30);
System.out.println(p.name()); // accessor
```

<div class="highlight-box"><p>Records model immutable data concisely.</p></div>

---

## Recap: var

```java
var message = "Hello";
var numbers = List.of(1, 2, 3);
// Type inferred from initializer
```

Use var when the right-hand side makes the type obvious.

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

## Now Kata 1: Default Methods

Define an Animal interface with a default speak() method and implement it with different animal records.

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

## Now Kata 2: Static Interface Methods

Create a MathUtils interface with static helper methods for common mathematical operations.

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

## Now Kata 3: Pattern Matching

Refactor instanceof/cast code to use pattern matching with record patterns for cleaner type checks.

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

## Now Kata 4: Text Blocks

Generate HTML and JSON output using text blocks with dynamic values inserted via formatted().

---

## Now Kata 5: Document Generator with Text Blocks

Define a Document interface with HtmlDocument and MarkdownDocument records that generate formatted output using text blocks.

---

## Summary

<div class="highlight-box">
<ul>
<li>Default methods add new behavior to interfaces without breaking implementors</li>
<li>Static interface methods provide utility functions</li>
<li>Pattern matching eliminates boilerplate instanceof/cast chains</li>
<li>Text Blocks make multiline strings readable</li>
</ul>
</div>
