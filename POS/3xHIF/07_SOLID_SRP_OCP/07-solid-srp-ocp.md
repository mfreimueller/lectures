---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 07 - SOLID, SRP, OCP
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: TDD Recap
2. Review: Why Design Matters
3. What are SOLID Principles?
4. SRP: Single Responsibility Principle
5. SRP: Violation Example
6. SRP: Solution

---

## Agenda (2/2)

7. SRP: Benefits
8. OCP: Open-Closed Principle
9. OCP: Violation Example
10. OCP: Solution
11. OCP: Benefits
12. Summary: SRP + OCP

---

## Learning Objectives

- I can explain the Single Responsibility Principle and identify violations
- I can refactor a class with multiple responsibilities into focused classes
- I can explain the Open-Closed Principle and its benefits
- I can use interfaces to extend behavior without modifying existing code
- I can apply SRP and OCP together to improve code design

---

## Review: TDD Recap

- Red: Write a failing test
- Green: Write the simplest code to pass
- Refactor: Improve code quality
- FIRST: Fast, Isolated, Repeatable, Self-validating, Timely

---

## Review: Why Design Matters

- TDD helps with correctness, but good design needs principles
- Without design, code becomes hard to change
- SOLID gives us guidelines for maintainable code

---

## What are SOLID Principles?

Five design principles for object-oriented programming:

- **S**ingle Responsibility Principle (SRP)
- **O**pen-Closed Principle (OCP)
- **L**iskov Substitution Principle (LSP)
- **I**nterface Segregation Principle (ISP)
- **D**ependency Inversion Principle (DIP)

Today: SRP and OCP

---

## SRP: Single Responsibility Principle

<div class="highlight-box">
<p>"A class should have only one reason to change."</p>
</div>

- Each class should do one thing well
- If a class has multiple responsibilities, changing one may break another

---

## SRP: Violation Example

```java
class Invoice {
    void calculateTotal() { /* ... */ }
    void printInvoice() { /* ... */ }
    void saveToDatabase() { /* ... */ }
    void sendEmail() { /* ... */ }
}
```

Four responsibilities: calculation, printing, persistence, notification

---

## Discussion: Where Do You Draw the Line?

<div class="highlight-box">
<p>How do you identify when a class has "too many" responsibilities? Is "one reason to change" always clear, or does it depend on context? Discuss in pairs: where would you split the Invoice class, and why?</p>
</div>

---

## SRP: Solution

```java
class InvoiceCalculator { /* calculate total */ }
class InvoicePrinter { /* print */ }
class InvoiceRepository { /* save/load */ }
class EmailService { /* send email */ }
```

Each class has exactly one reason to change.

---

## SRP: Benefits

- Easier to understand
- Easier to test (fewer dependencies)
- Easier to maintain (changes are localized)
- Better reuse (small classes compose well)

---

## OCP: Open-Closed Principle

<div class="highlight-box">
<p>"Software entities should be open for extension, closed for modification."</p>
</div>

- Add new functionality without changing existing code
- Use abstraction (interfaces, abstract classes)

---

## OCP: Violation Example

```java
class AreaCalculator {
    double area(Object shape) {
        if (shape instanceof Circle) { /* ... */ }
        else if (shape instanceof Rectangle) { /* ... */ }
        // Adding Square requires modifying this class
    }
}
```

Every new shape type requires changing AreaCalculator!

---

## OCP: Solution

```java
interface Shape {
    double area();
}

class Circle implements Shape {
    public double area() { return Math.PI * r * r; }
}

class Rectangle implements Shape {
    public double area() { return width * height; }
}
// Adding Square? Just implement Shape -- no changes needed!
```

---

## OCP: Benefits

- Reduces risk of introducing bugs in working code
- Encourages reuse through interfaces
- Supports plugin-like architectures

---

## Summary: SRP + OCP

- SRP: One reason to change per class
- OCP: Extend behavior without modifying existing code
- Both rely on clean abstractions
- Both make code more maintainable
