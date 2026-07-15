---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 01 - Domain-Driven Design
## POS - Advanced

---

## Agenda (1/2)

1. Warum Domain-Driven Design?
2. Ubiquitous Language
3. Bounded Context
4. Entities
5. Value Objects

---

## Agenda (2/2)

6. Entities vs Value Objects — Entscheidung
7. Aggregates
8. Repositories
9. Domain Events

---

## Lernziele

- Ich kenne die Grundidee von Domain-Driven Design und die Ubiquitous Language
- Ich kann Bounded Contexts voneinander abgrenzen
- Ich kann zwischen Entities und Value Objects unterscheiden
- Ich verstehe die Rolle von Aggregates, Repositories und Domain Events

---

## Warum Domain-Driven Design?

- Software bildet reale Geschaftsprozesse ab
- Fachliche Komplexitat ist die groste Herausforderung
- Fachexperten und Entwickler sprechen oft verschiedene Sprachen
- DDD bringt den Fokus auf die Domäne (Fachlichkeit)

<aside class="highlight-box">
<p>"The heart of software is its ability to solve domain-related problems" — Eric Evans</p>
</aside>

---

## Ubiquitous Language

- Eine gemeinsame, verbindliche Sprache für alle Beteiligten
- Fachbegriffe werden im Code, in Dokumenten und in Gesprachen einheitlich verwendet
- Beispiel: "Ausleihe" statt "Transaction" oder "BorrowProcess"

```java
public class Ausleihe {
    private Mitglied mitglied;
    private Medium medium;
    private LocalDate ausleihdatum;
}
```

---

## Bounded Context

- Ein expliziter Grenzbereich um ein domanenspezifisches Modell
- Derselbe Begriff kann in verschiedenen Kontexten unterschiedliche Bedeutung haben
- Beispiel: "Produkt" im Verkaufskontext vs. im Lagerkontext

<div class="highlight-box">
<p>Ein Bounded Context grenzt die Gültigkeit der Ubiquitous Language ein</p>
</div>

---

## Entities

- Haben eine eindeutige Identitat (ID), die über die Zeit stabil bleibt
- Können ihren Zustand ändern, behalten aber ihre Identitat

```java
public class Kunde {
    private final String kundenId; // Identitat
    private String name;           // Anderbar

    @Override
    public boolean equals(Object o) {
        return o instanceof Kunde k && kundenId.equals(k.kundenId);
    }
}
```

---

## Value Objects

- Keine eigene Identitat — werden durch ihre Attribute definiert
- Unveranderlich (immutable)
- Zwei Value Objects sind gleich, wenn alle Attribute gleich sind

```java
public record Adresse(String strasse, String plz, String ort) {
    public Adresse {
        if (strasse == null || strasse.isBlank())
            throw new IllegalArgumentException();
    }
}
```

---

## Entities vs Value Objects — Entscheidung

| Kriterium | Entity | Value Object |
| --- | --- | --- |
| Identitat | Ja (ID) | Nein (Werte) |
| Immutability | Nein | Ja |
| Lebensdauer | Wird verfolgt | Austauschbar |
| Beispiel | Kunde, Bestellung | Adresse, Geldbetrag |

---

## Aggregates

- Eine Gruppe zusammengehoriger Objekte, die als Einheit behandelt werden
- Haben eine Aggregate Root (eine Entity) als Einstiegspunkt
- Auere Objekte durfen nur über die Root auf das Aggregate zugreifen

```java
public class Bestellung {          // Aggregate Root
    private final List<Bestellposition> positionen;

    public void addPosition(Produkt p, int menge) {
        positionen.add(new Bestellposition(p, menge));
    }
}
```

---

## Repositories

- Kapseln den Zugriff auf Aggregates (Speicherung, Wiederherstellung)
- Pro Aggregate Root ein Repository
- Bieten eine sammlungsahnliche Schnittstelle

```java
public interface BestellRepository {
    Optional<Bestellung> findById(String id);
    void save(Bestellung bestellung);
    void delete(Bestellung bestellung);
}
```

---

## Domain Events

- Dokumentieren etwas Bedeutendes, das in der Domäne passiert ist
- Typisch als vergangenes Ereignis benannt: "OrderPlaced", "PaymentReceived"
- Ermoglichen lose Kopplung zwischen Bounded Contexts

```java
public record BestellungAufgegeben(
    String bestellId,
    String kundenId,
    LocalDateTime zeitpunkt
) {}
```

---

## Zusammenfassung

- DDD stellt die Fachdomane in den Mittelpunkt
- Ubiquitous Language schafft eine gemeinsame Begriffswelt
- Bounded Context grenzt Modelle voneinander ab
- Entities haben Identitat, Value Objects sind Werte
- Aggregates, Repositories und Domain Events strukturieren das Modell
