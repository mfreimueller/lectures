---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 01a - Constants & Enums
## POS - 3xHIF

---

## Agenda (1/3)

1. Constants in Java: Motivation
2. Defining Constants: static final
3. Constants: Naming & Best Practices
4. Constants: Where to Put Them

---

## Agenda (2/3)

5. Why Enums?
6. Enum Basics: Syntax
7. Using Enums: values(), valueOf(), ordinal()
8. Enums in switch

---

## Agenda (3/3)

9. Enums with Fields and Constructor
10. Enums with Methods
11. Enums with Per-Constant Behavior
12. Summary

---

## Learning Objectives

- I can define constants using static final and follow naming conventions
- I can explain where constants should live, and avoid the "constant interface" anti-pattern
- I can explain why enums are safer than plain int constants
- I can define enums with fields, constructors, and methods
- I can use enums in switch statements and expressions
- I can give individual enum constants their own behavior

---

## Constants in Java: Motivation

- Some values are just... fixed: a tax rate, a max size, a config key
- Naming these values avoids "magic numbers/strings" scattered through the code

```java
if (retries > 3) { ... }        // what does 3 mean?
if (retries > MAX_RETRIES) { ... } // clear intent
```

---

## Defining Constants: static final

```java
public class Config {
    public static final int MAX_RETRIES = 3;
    public static final String DEFAULT_LOCALE = "en-US";
    public static final double TAX_RATE = 0.20;
}

Config.MAX_RETRIES
```

<div class="highlight-box"><p>static: one shared value per class, not per instance. final: the value can only be assigned once.</p></div>

---

## Constants: Naming & Best Practices

- `UPPER_SNAKE_CASE` by convention
- Prefer a small, related set of alternatives? Use an **enum**, not several constants
- Avoid the "constant interface" anti-pattern (implementing an interface just to import its constants)

```java
// Anti-pattern
interface Constants {
    int MAX_RETRIES = 3;
}
class Client implements Constants { ... } // leaks into public API
```

---

## Constants: Where to Put Them

- Close to where they're used (`private static final` inside the class)
- In a dedicated class if shared across the codebase (`Config`, `AppConstants`)
- Import statically when it improves readability: `import static Config.MAX_RETRIES;`

<div class="highlight-box"><p>Enums and constants both give names to fixed values -- enums when the value is one of a closed set of alternatives, constants for standalone fixed values.</p></div>

---

## Why Enums?

```java
public class Order {
    public static final int PENDING = 0;
    public static final int SHIPPED = 1;
    public static final int DELIVERED = 2;

    private int status;
}

order.status = 42; // compiles, but meaningless
```

<div class="highlight-box"><p>int constants dont restrict which values are valid, and printing them just shows a number.</p></div>

---

## Enum Basics: Syntax

```java
public enum OrderStatus {
    PENDING, SHIPPED, DELIVERED
}
```

```java
OrderStatus status = OrderStatus.PENDING;
System.out.println(status); // PENDING
```

<div class="highlight-box"><p>An enum is a type with a fixed, known set of instances. The compiler rejects any value that isnt one of them.</p></div>

---

## Using Enums: values(), valueOf(), ordinal()

```java
for (OrderStatus s : OrderStatus.values()) {
    System.out.println(s.ordinal() + ": " + s.name());
}
// 0: PENDING
// 1: SHIPPED
// 2: DELIVERED

OrderStatus s = OrderStatus.valueOf("SHIPPED");
```

<div class="highlight-box"><p>values() returns all constants in declaration order; valueOf() parses a String back into the constant (throws if unknown).</p></div>

---

## Enums in switch

```java
String label = switch (status) {
    case PENDING -> "Waiting for confirmation";
    case SHIPPED -> "On its way";
    case DELIVERED -> "Completed";
};
```

<div class="highlight-box"><p>Since all constants are known, the compiler can check exhaustiveness -- no default needed if every constant is covered.</p></div>

---

## Enums with Fields and Constructor

```java
public enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6);

    private final double mass;
    private final double radius;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
}
```

<div class="highlight-box"><p>Enum constructors are always private (implicitly) -- constants are the only instances that will ever exist.</p></div>

---

## Enums with Methods

```java
public enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    EARTH(5.976e+24, 6.37814e6);

    private static final double G = 6.67300E-11;
    private final double mass;
    private final double radius;

    Planet(double mass, double radius) { /* ... */ }

    double surfaceGravity() {
        return G * mass / (radius * radius);
    }
}

System.out.println(Planet.EARTH.surfaceGravity()); // 9.802...
```

---

## Enums with Per-Constant Behavior

```java
public enum Operation {
    PLUS  { public int apply(int a, int b) { return a + b; } },
    MINUS { public int apply(int a, int b) { return a - b; } };

    public abstract int apply(int a, int b);
}

int result = Operation.PLUS.apply(3, 4); // 7
```

<div class="highlight-box"><p>Each constant can override an abstract method with its own body -- an alternative to a switch inside apply().</p></div>

---

## Summary

<div class="highlight-box">
<ul>
<li>Constants (static final) name standalone fixed values -- static: one shared value, final: assigned once</li>
<li>Follow naming conventions (UPPER_SNAKE_CASE) and avoid the "constant interface" anti-pattern</li>
<li>Enums model a closed set of alternatives -- type-safe, with optional fields, constructors, and methods</li>
<li>Enums support switch (with exhaustiveness checking) and per-constant behavior overrides</li>
<li>Prefer enums over constants when the values are really a closed set of alternatives</li>
</ul>
</div>
