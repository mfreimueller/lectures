---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 09 - SOLID, LSP, ISP, DIP
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: SRP & OCP
2. Review: Why SOLID Matters
3. LSP: Liskov Substitution Principle
4. LSP: Classic Violation
5. LSP: Solution
6. ISP: Interface Segregation Principle
7. ISP: Violation Example

---

## Agenda (2/2)

8. ISP: Solution
9. DIP: Dependency Inversion Principle
10. DIP: Violation Example
11. DIP: Solution
12. DIP: Benefits
13. Summary: All SOLID Principles

---

## Learning Objectives

- I can explain the Liskov Substitution Principle and identify inheritance violations
- I can refactor Square/Rectangle inheritance to use a common Shape interface
- I can split fat interfaces into smaller, client-specific interfaces
- I can apply Dependency Inversion to decouple high-level and low-level modules
- I can refactor code to depend on abstractions using dependency injection

---

## Review: SRP & OCP

- SRP: One reason to change per class
- OCP: Open for extension, closed for modification
- Both rely on clean abstractions

---

## Review: Why SOLID Matters

- Code that is easy to change is valuable
- SOLID reduces coupling and increases cohesion
- Today we finish the remaining three principles

---

## LSP: Liskov Substitution Principle

<div class="highlight-box">
<p>"Objects of a superclass should be replaceable with objects of a subclass without affecting correctness."</p>
</div>

- Subtypes must be substitutable for their base types
- A subclass should not weaken the parent's contract

---

## LSP: Classic Violation

```java
class Rectangle {
    void setWidth(int w) { this.width = w; }
    void setHeight(int h) { this.height = h; }
    int area() { return width * height; }
}

class Square extends Rectangle {
    void setWidth(int w) {
        super.setWidth(w);
        super.setHeight(w);  // Breaks LSP!
    }
}
```

Client code expecting Rectangle behavior breaks with Square.

---

## Reflection: Why Is Square/Rectangle So Common?

<div class="highlight-box">
<p>The Square-is-a-Rectangle problem appears in almost every OOP course. Why is this violation so tempting? What does it teach us about the limits of inheritance and when composition might be a better choice?</p>
</div>

---

## LSP: Solution

- Use composition instead of inheritance
- Or use a common interface with no mutators

```java
interface Shape {
    int area();
}
```

---

## Now Kata 1: LSP -- Rectangle/Square

Refactor a Square/Rectangle inheritance hierarchy to use a common Shape interface with no mutators.

---

## ISP: Interface Segregation Principle

<div class="highlight-box">
<p>"No client should be forced to depend on methods it does not use."</p>
</div>

- Large interfaces should be split into smaller ones
- Clients should only know about methods they actually call

---

## ISP: Violation Example

```java
interface Worker {
    void work();
    void eat();
    void sleep();
}
// A RobotWorker doesn't eat or sleep,
// but is forced to implement those methods!
```

Solution: Split into Workable, Eatable, Sleepable interfaces.

---

## ISP: Solution

```java
interface Workable { void work(); }
interface Eatable { void eat(); }
interface Sleepable { void sleep(); }

class HumanWorker implements Workable, Eatable, Sleepable { /* all */ }
class RobotWorker implements Workable { /* only work */ }
```

---

## Now Kata 2: ISP -- Printer Interface

Split a bloated MultiFunctionPrinter interface into smaller interfaces: Printer, Scanner, FaxMachine, and Stapler.

---

## DIP: Dependency Inversion Principle

<div class="highlight-box">
<p>"Depend on abstractions, not on concrete implementations."</p>
</div>

- High-level modules should not depend on low-level modules
- Both should depend on abstractions

---

## DIP: Violation Example

```java
class NotificationService {
    private EmailSender email = new EmailSender();
    void notify(String msg) {
        email.send(msg);
    }
}
// NotificationService depends directly on EmailSender
```

---

## DIP: Solution

```java
interface MessageSender {
    void send(String message);
}

class EmailSender implements MessageSender { /* ... */ }
class SmsSender implements MessageSender { /* ... */ }

class NotificationService {
    private final MessageSender sender;
    NotificationService(MessageSender sender) {
        this.sender = sender;  // Dependency Injection
    }
    void notify(String msg) { sender.send(msg); }
}
```

---

## Now Kata 3: DIP -- Notification System

Refactor NotificationService to use a MessageSender abstraction with constructor-based dependency injection.

---

## DIP: Benefits

- Loosely coupled code
- Easier to test (mock abstractions)
- Easier to swap implementations
- Follows naturally from OCP

---

## Now Kata 4: DIP with Factory Pattern

Refactor ReportGenerator to depend on a Report abstraction via a Factory pattern for creating report types.

---

## Summary: All SOLID Principles

- **SRP:** One reason to change
- **OCP:** Extend without modifying
- **LSP:** Subtypes must be substitutable
- **ISP:** Small, focused interfaces
- **DIP:** Depend on abstractions

---

## Now Kata 5: Full SOLID Refactoring

Refactor a monolithic Printer class that violates LSP, ISP, and DIP into a clean, SOLID-compliant design.
