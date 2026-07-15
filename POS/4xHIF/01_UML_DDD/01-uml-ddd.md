---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 01 - UML & DDD
## POS - 4xHIF

---

## Recap: UML Class Diagrams

- Class: rectangle with name, attributes, methods
- `+` public, `-` private, `#` protected
- Relationships: association, aggregation, composition, inheritance

---

## Recap: Visibility Notation

```plaintext
+---------------------------+
|         Person            |
+---------------------------+
| - name: String            |
| - birthDate: LocalDate    |
+---------------------------+
| + getName(): String       |
| + getAge(): int           |
| # validateAge(): boolean  |
+---------------------------+
```

---

## Association

- A structural relationship between classes
- "Has-a" or "knows about" relationship
- Can have: multiplicity, role name, navigability

```plaintext
Person ──────────► Address
    works at    1       *
       (role)   (multiplicity)
```

---

## Association in Java

```java
public class Person {
    private Address address;  // association
}

public class Address {
    private String street;
    private String city;
}
```

The Person "knows about" an Address — but Address has its own lifecycle.

---

## Aggregation

- Special form of association — "has-a" with *shared* ownership
- The child can exist independently of the parent
- Drawn with an **empty diamond** on the parent side

```plaintext
Department ◊─────── Employee
    (empty diamond = aggregation)
```

---

## Aggregation Example

```java
public class Department {
    private List<Employee> employees;  // aggregation
}

public class Employee {
    // Employee exists independently
    // even if Department is deleted
}
```

---

## Composition

- Stronger form — "has-a" with *exclusive* ownership
- Child **cannot** exist without the parent
- Drawn with a **filled diamond** on the parent side
- Parent is responsible for child's lifecycle

```plaintext
Order ◆────── OrderItem
    (filled diamond = composition)
```

---

## Composition Example

```java
public class Order {
    private List<OrderItem> items;  // composition
    // items created with Order, destroyed with Order
}

public class OrderItem {
    // Cannot exist without an Order
}
```

---

## Aggregation vs. Composition

| Feature | Aggregation | Composition |
| --- | --- | --- |
| Ownership | Shared | Exclusive |
| Lifecycle | Independent | Dependent on parent |
| Diamond | Empty (◊) | Filled (◆) |
| Example | Department + Employee | Order + OrderItem |

---

## Inheritance (Generalization)

- "Is-a" relationship — arrow with **empty triangle**
- Child inherits all non-private members
- Java: `extends` for classes

```plaintext
     ┌───────┐
     │ Animal │
     └───┬───┘
         ▲
    ┌────┴────┐
    │         │
 ┌──┴───┐ ┌──┴────┐
 │ Dog  │ │ Cat   │
 └──────┘ └───────┘
```

---

## Realization (Interface)

- Dashed line with **empty triangle**
- Class implements interface
- Java: `implements`

```plaintext
---◇ «interface»
    │Borrowable│
    └────┬─────┘
         ⋮ (dashed)
    ┌────┴────┐
    │  Book   │
    └─────────┘
```

---

## What is Domain-Driven Design?

- A software design methodology by Eric Evans (2003)
- Focus on the **core domain** and domain logic
- Model software after real-world business concepts
- Bridge the gap between domain experts and developers

---

## DDD: Key Concepts

- **Ubiquitous Language** — common vocabulary used by developers AND domain experts
- **Bounded Context** — explicit boundary around a domain model
- **Entities** — objects with identity (e.g., a Person)
- **Value Objects** — objects defined by their attributes (e.g., an Address)

---

## Ubiquitous Language

- No translation layers: "Book", "Member", "Loan" in code = same terms in conversation
- Avoid technical terms in the domain model
- If the team says "check out a book", the code should have `checkOut(book, member)`

---

## Bounded Context

- A *Book* in the "Catalog" context may have different attributes than in "Sales"
- Each context has its own model and its own ubiquitous language
- Contexts communicate via events or APIs

```plaintext
┌──────────────────┐     ┌──────────────────┐
│  Catalog Context │     │  Lending Context │
│  Book: ISBN,     │     │  Book: copyId,   │
│  Title, Author   │     │  condition,      │
│                  │     │  location        │
└──────────────────┘     └──────────────────┘
```

---

## Entities vs. Value Objects

| Entities | Value Objects |
| --- | --- |
| Have identity (id) | No identity — defined by attributes |
| Mutable | Immutable |
| Equality by id | Equality by all attributes |
| Example: Person, Order | Example: Address, Money, Color |

---

## Project: Choosing Your Domain

- At least **6 entities**
- Meaningful business logic (beyond CRUD)
- Multiple relationship types (1:1, 1:n, n:m)
- Searchable, filterable lists
- Something you find interesting!

Next week: PlantUML your domain model

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>UML: Association, Aggregation, Composition, Inheritance</li>
<li>DDD: Ubiquitous Language, Bounded Context</li>
<li>Entities vs. Value Objects</li>
<li>How to evaluate a domain for the project</li>
</ul>
</div>
