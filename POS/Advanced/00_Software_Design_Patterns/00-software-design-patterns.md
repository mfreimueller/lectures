---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 00 - Software Design Patterns
## POS - Advanced

---

## Was sind Design Patterns?

- Wiederkehrende Lösungen für wiederkehrende Probleme in der Softwareentwicklung
- Kein fertiger Code, sondern eine Vorlage / Schablone
- Ermoglichen eine gemeinsame Sprache zwischen Entwicklern

<aside class="highlight-box">
<p>Ein Pattern hat vier wesentliche Elemente: Name, Problem, Lösung, Konsequenzen</p>
</aside>

---

## Geschichte: Gang of Four (GoF)

- 1994: "Design Patterns: Elements of Reusable Object-Oriented Software"
- Autoren: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
- Enthalt 23 Patterns, kategorisiert in 3 Gruppen

```java
// Ein Pattern ist keine Bibliothek, sondern eine Idee
// "Program to an interface, not an implementation"
```

---

## Die drei GoF-Kategorien

| Kategorie | Fokus |
| --- | --- |
| Creational | Objekterzeugung |
| Structural | Zusammensetzung von Klassen/Objekten |
| Behavioral | Interaktion und Zustandigkeitsverteilung |

---

## Creational Patterns

- Abstraktion des Instanziierungsprozesses
- Beispiele: Singleton, Factory Method, Abstract Factory, Builder, Prototype

```java
// Factory Method
Pizza pizza = PizzaFactory.create("margherita");
```

---

## Structural Patterns

- Definieren, wie Klassen und Objekte zusammengesetzt werden
- Beispiele: Adapter, Decorator, Facade, Proxy, Composite

```java
// Adapter
LegacyLogger logger = new LoggerAdapter(new ModernLogger());
```

---

## Behavioral Patterns

- Beschreiben Kommunikation zwischen Objekten
- Beispiele: Observer, Strategy, Iterator, Command, Template Method

```java
// Strategy
PaymentStrategy strategy = new CreditCardStrategy();
checkout.pay(strategy, 99.99);
```

---

## Pattern Language

- Patterns stehen in Beziehung zueinander
- Ein Pattern kann auf hoherer Ebene andere Patterns kombinieren
- Beispiel: Ein Abstract Factory kann Singleton für Factory-Instanzen nutzen

<div class="highlight-box">
<p>Patterns bilden ein Vokabular: Sie ermoglichen praziose Kommunikation</p>
</div>

---

## Warum Patterns verwenden?

- Wiederverwendbarkeit erprobter Lösungen
- Verbesserte Kommunikation im Team ("Wir brauchen einen Observer hier")
- Erhohte Wartbarkeit durch klarere Strukturen
- Vermeidung von Anti-Patterns

---

## Code-Beispiel: Pattern erkennen

```java
public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy s) {
        this.paymentStrategy = s;
    }

    public void checkout() {
        paymentStrategy.pay(calculateTotal());
    }
}
```

Welche Kategorie? -> Behavioral (Strategy Pattern)

---

## Zusammenfassung

- GoF definiert 23 Patterns in 3 Kategorien
- Creational: Objekterzeugung (Singleton, Factory, Builder)
- Structural: Zusammensetzung (Adapter, Facade, Decorator)
- Behavioral: Interaktion (Strategy, Observer, Iterator)
- Patterns sind ein Kommunikationswerkzeug und keine fertigen Bibliotheken
- Nachste Lektion: Domain-Driven Design
