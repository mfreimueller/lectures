---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 02 - PlantUML & Value Objects
## POS - 4xHIF

---

## Warum PlantUML?

- Textbasierte Diagramme — versionierungsfreundlich
- Diagramme automatisch aus Code generieren
- Keine Drag-and-Drop Layout-Probleme
- Integration mit IntelliJ, VS Code, CI Pipelines

---

## PlantUML Syntax: Klasse

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

## PlantUML: Beziehungen

```plaintext
@startuml
Person "1" --> "*" Address : lives at
Person "1" --> "*" Book : owns
@enduml
```

`-->` = Assoziation mit Richtung

---

## PlantUML: Aggregation & Komposition

```plaintext
@startuml
Department o-- Employee  ' aggregation (empty diamond)
Order *-- OrderItem     ' composition (filled diamond)
@enduml
```

---

## PlantUML: Vererbung & Realisierung

```plaintext
@startuml
Animal <|-- Dog            ' inheritance (extends)
interface Borrowable
Borrowable <|.. Book       ' realization (implements)
@enduml
```

---

## Was sind Value Objects?

- Objekte definiert **durch ihre Attribute**, nicht durch Identität
- **Unveränderlich** — können nach der Erstellung nicht geändert werden
- **Strukturelle Gleichheit** — zwei VOs sind gleich, wenn alle Felder übereinstimmen
- Keine Nebeneffekte — Operationen geben neue Instanzen zurück

---

## Value Object Beispiele

| Schlecht (Primitivtypen) | Gut (Value Objects) |
| --- | --- |
| `String email` | `Email email` |
| `double amount` | `Money price` |
| `String street` | `Address address` |
| `String color` | `Color color` |

---

## Ein Value Object implementieren

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

Records geben uns Unveränderlichkeit, equals/hashCode, toString gratis.

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

## RichTypes: Jenseits von Primitivtypen

- **Primitive Obsession** — String, int, long für alles verwenden
- **RichTypes** — Primitivtypen in domänensinnvolle Typen verpacken
- Compiler erkennt Fehler: `CustomerId` vs `OrderId`
- Validierung lebt im Typ, nicht verstreut über Services

---

## RichType Beispiel

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

## Was wir heute gelernt haben

- PlantUML Syntax für Klassendiagramme
- Value Objects: unveränderlich, strukturelle Gleichheit
- RichTypes zur Eliminierung von Primitive Obsession
- Validierung zur Konstruktionszeit
