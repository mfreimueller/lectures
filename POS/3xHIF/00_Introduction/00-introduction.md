---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 00 - Introduction
## POS - 3xHIF

---

## Agenda (1/2)

1. Welcome to POS
2. Course Topics
3. Grading
4. Tooling Setup
5. Installing JDK
6. Maven Setup

---

## Agenda (2/2)

7. IDE Setup
8. Local Variable Type Inference
9. var Restrictions
10. var with Collections
11. Records (Java 16+)
12. Record Features
13. Using Records

---

## Learning Objectives

- I know the structure of this class
- I know the grading criteria of this class
- I can set up a Java development environment with JDK, Maven, and an IDE
- I can use var to declare local variables when the type is obvious
- I can define and use Records as immutable data carriers
- I can create a Maven project and manage dependencies

---

## Welcome to POS in 3rd grade HIF

Our (programming / SE) goals:

- Moving towards modern Java
- Creating our first complex(ish) software
- Thinking about software design

---

## Course Topics

- Java Language Features (Records, Sealed Classes, Pattern Matching)
- Streams and Functional Programming
- Testing with JUnit 5 and TDD
- SOLID Principles
- Project Work (WMC)

---

## Grading

<div class="highlight-box">
<p>Programming / SE: 75%</p>
<p>Logic: 25%</p>
</div>

**You must be positive in both parts of POS.**

---

## Grading

- PLÜs: 50%
- Mitarbeit: 50%
  - Practical exercises
  - Revisions
  - Active participation
  - WMC project

---

## Tooling Setup

Required tools for this course:

- JDK 25
- IntelliJ IDEA
- Maven
- Git for version control
- GitHub Account

---

## Installing JDK

Download from [Adoptium](https://adoptium.net) or use SDKMAN:

```bash
# Using SDKMAN
sdk install java 25.0.3-tem
java --version
javac --version
```

---

## Maven Setup

Install via IntelliJ or use SDKMAN:

```bash
# Using SDKMAN
sdk install maven
mvn --version
```

---

## IDE Setup

- IntelliJ IDEA: Open the pom.xml file
- Enable auto-import for Maven projects

---

## Homework

Complete the dev setup until the next POS lesson.

---

## 2nd grade - Brainstorming

What concepts and language constructs did you learn last year?

---

## Collaborative Review

- You will be put into groups.
- Each group will receive one of the concepts discussed before.
- You will work with this concept.
- You present your results.

---

## Collaborative Review

Your tasks in your group:

- What is it?
- What problem does it solve?
- Come up with a short code example.

<div class="highlight-box">
<p>Remember: You don't have to get everything right. This is about finding out what we still remember.</p>
</div>

---

# POS 3rd Grade 🥳

---

## Partner Discussion

- Open the Student Grade Refactoring project in IntelliJ.
- Discuss the following questions with your partner:
  1. What patterns do you notice about the variable declarations in GradeCalculator and Main?
  2. What do you notice about StudentGrade (boilerplate code, mutability etc.)?
  3. What problems could arise from having setters on StudentGrade?

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

## Now Kata 1: Hello World

Write a program using var to declare a greeting and print it along with the current date/time.

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

## Now Kata 2: Records

Define a Book record with validation in a compact constructor and an age() method that calculates years since publication.

---

## Now Kata 3: Maven Project

Setup a new Maven project and add an external dependency to count words from text files.

---

## Now Exercise: Student Grades Refactoring

Refactor an existing application and migrate it from Java 11 to Java 25.

---

## Summary

<div class="highlight-box">
<ul>
<li>Set up JDK, IDE, and Maven</li>
<li><code>var</code> simplifies local variable declarations</li>
<li>Records provide concise immutable data carriers</li>
</ul>
</div>
