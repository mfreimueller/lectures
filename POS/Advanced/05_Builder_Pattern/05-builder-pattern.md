---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 05 - Builder Pattern
## POS - Advanced

---

## Problem: Telescoping Constructors

```java
public class Pizza {
    public Pizza() { }
    public Pizza(String size) { }
    public Pizza(String size, boolean cheese) { }
    public Pizza(String size, boolean cheese,
                 boolean pepperoni) { }
    public Pizza(String size, boolean cheese,
                 boolean pepperoni, boolean mushrooms) { }
    // ...
}
```

- Schlecht lesbar und fehleranfällig
- Reihenfolge der Parameter leicht zu verwechseln
- Viele Kombinationen nötig

---

## Builder Pattern — Grundidee

- Trennung von Konstruktion und Reprasentation
- Schrittweiser Aufbau des Objekts
- Letzter Schritt: build() erzeugt finales Objekt

<div class="highlight-box">
Typischerweise als statische innere Klasse implementiert
</div>

---

## Fluent Interface

```java
Pizza pizza = new Pizza.Builder()
    .size("large")
    .cheese(true)
    .pepperoni(true)
    .mushrooms(false)
    .build();
```

- Jede Setter-Methode gibt `return this;` zurück
- Ermöglicht Method Chaining
- Konfiguration auf einen Blick erfassbar

---

## Pizza Builder — Implementierung

```java
public class Pizza {
    private final String size;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }

    public static class Builder {
        private String size = "medium";
        private boolean cheese = false;
        // ...

        public Builder size(String size) {
            this.size = size; return this;
        }
        public Builder cheese(boolean v) {
            this.cheese = v; return this;
        }
        public Pizza build() { return new Pizza(this); }
    }
}
```

---

## Query Builder — Beispiel

```java
String query = new QueryBuilder()
    .select("name", "age")
    .from("users")
    .where("age > 18")
    .orderBy("name", "ASC")
    .build();

// Result: SELECT name, age FROM users
//        WHERE age > 18 ORDER BY name ASC
```

---

## Vor- und Nachteile

| Vorteile | Nachteile |
| --- | --- |
| Lesbarer Code | Mehr Code (zusätzliche Klasse) |
| Imutable Objekte möglich | Overkill bei wenigen Parametern |
| Wiederverwendbarer Builder | Builder muss gewartet werden |
| Validierung in build() | Thread-Safety beachten |

---

## Zusammenfassung

- Builder ersetzt Telescoping Constructors
- Fluent Interface = return this
- Ideal für Objekte mit vielen optionalen Feldern
- Nächstes Mal: Factory Pattern (Simple Factory, Factory Method, Abstract Factory)
