---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 01c - Factory Method
## POS - 3xHIF

---

## Agenda

1. Factory Method: Motivation
2. Factory Method: What Is It?
3. Factory Method: Implementation
4. Factory Method: Notable Examples
5. Summary

---

## Learning Objectives

- I can explain why a constructor alone isn't always enough
- I can explain the Factory Method pattern and implement it
- I can recognize Factory Method usage in the JDK (e.g. Optional.of)

---

## Factory Method: Motivation

```java
Shape shape = new Circle(5); // caller must know the concrete type
```

- Sometimes the caller shouldn't (or can't) know which concrete class to instantiate
- Sometimes object creation needs logic: validation, caching, choosing between subtypes
- `new` alone can't express that logic

---

## Factory Method: What Is It?

<div class="highlight-box"><p>Factory Method: a creational pattern that delegates object creation to a method instead of calling a constructor directly, so the caller depends on an abstraction, not a concrete class.</p></div>

- A static or instance method that returns an object
- Hides the concrete class behind an interface or supertype
- Can return a cached instance, a subtype, or throw for invalid input -- a constructor can't do any of that

---

## Factory Method: Implementation

```java
public interface Shape {
    static Shape circle(double radius) {
        if (radius <= 0) throw new IllegalArgumentException();
        return new Circle(radius);
    }
    static Shape rectangle(double w, double h) {
        return new Rectangle(w, h);
    }
    double area();
}

Shape s = Shape.circle(5); // caller never sees Circle
```

<div class="highlight-box"><p>The caller works with the Shape interface; which concrete class gets created is the factory method's decision.</p></div>

---

## Factory Method: Notable Examples

```java
Optional<String> present = Optional.of("value");
Optional<String> empty   = Optional.empty();
Optional<String> maybe   = Optional.ofNullable(getName());

List<String> names = List.of("Alice", "Bob");
Map<String, Integer> ages = Map.of("Alice", 30);

Calendar cal = Calendar.getInstance();
```

<div class="highlight-box"><p>None of these expose a public constructor -- Optional has no "new Optional()". The static factory method controls creation (and can return a shared EMPTY instance).</p></div>

---

## Summary

<div class="highlight-box">
<ul>
<li>Factory Method delegates object creation to a method instead of a direct constructor call</li>
<li>Callers depend on an abstraction (interface/supertype), not a concrete class</li>
<li>A factory method can validate input, return a cached instance, or choose a subtype -- a constructor can't</li>
<li>Notable JDK examples: Optional.of/empty/ofNullable, List.of, Map.of, Calendar.getInstance()</li>
</ul>
</div>
