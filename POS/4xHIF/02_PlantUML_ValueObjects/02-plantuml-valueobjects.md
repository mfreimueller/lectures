---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 02 - Plant UML & Value Objects
## POS - 4xHIF

---

## Why PlantUML?

- Text-based diagrams — version control friendly
- Automatically generate diagrams from code
- No drag-and-drop layout problems
- Integrates with IntelliJ, VS Code, CI pipelines

---

## PlantUML Syntax: Class

```plaintext
@startuml
class Person {
  - String name
  - LocalDate birthDate
  + getName(): String
  + getAge(): int
}
@enduml
```

`-` private, `#` protected, `+` public

---

## PlantUML: Relationships

```plaintext
@startuml
Person "1" --> "*" Address : lives at
Person "1" --> "*" Book : owns
@enduml
```

`-->` = association with direction

---

## PlantUML: Aggregation & Composition

```plaintext
@startuml
Department o-- Employee  ' aggregation (empty diamond)
Order *-- OrderItem     ' composition (filled diamond)
@enduml
```

---

## PlantUML: Inheritance & Realization

```plaintext
@startuml
Animal <|-- Dog            ' inheritance (extends)
interface Borrowable
Borrowable <|.. Book       ' realization (implements)
@enduml
```

---

## What are Value Objects?

- Objects defined **by their attributes**, not by identity
- **Immutable** — cannot change after creation
- **Structural equality** — two VOs are equal if all fields match
- No side effects — operations return new instances

---

## Value Object Examples

| Bad (primitives) | Good (Value Objects) |
| --- | --- |
| `String email` | `Email email` |
| `double amount` | `Money price` |
| `String street` | `Address address` |
| `String color` | `Color color` |

---

## Implementing a Value Object

```java
public record Email(String value) {
    public Email {
        if (value == null || !value.contains("@")) {
            throw new IllegalArgumentException(
                "Email must contain @");
        }
    }

    public static Email of(String value) {
        return new Email(value);
    }
}
```

Records give us immutability, equals/hashCode, toString for free.

---

## Money Value Object

```java
public record Money(BigDecimal amount, Currency currency) {
    public Money {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                "Amount cannot be negative");
        }
    }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException(
                "Currency mismatch");
        }
        return new Money(this.amount.add(other.amount),
                         this.currency);
    }
}
```

---

## RichTypes: Beyond Primitives

- **Primitive Obsession** — using String, int, long for everything
- **RichTypes** — wrap primitives in domain-meaningful types
- Compiler catches errors: `CustomerId` vs `OrderId`
- Validation lives in the type, not scattered across services

---

## RichType Example

```java
// Before
public void placeOrder(String customerId,
                       String productId) { ... }

// After
public record CustomerId(String value) {
    public CustomerId {
        if (!value.matches("CUST-\\d{3}")) {
            throw new IllegalArgumentException(
                "Invalid customer ID format");
        }
    }
}

public record ProductId(String value) { ... }

public void placeOrder(CustomerId customerId,
                       ProductId productId) { ... }
```

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>PlantUML syntax for class diagrams</li>
<li>Value Objects: immutable, structural equality</li>
<li>RichTypes to eliminate primitive obsession</li>
<li>Validation at construction time</li>
</ul>
</div>
