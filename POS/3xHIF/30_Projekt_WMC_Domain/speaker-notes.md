# Speaker Notes — 30: Projekt WMC Domain

**Woche 34** | **Typ: Projekt — Sprint 3**

---

## 0. Check-in (15 min)

- Stand-up: Auth fertig?
- Probleme besprechen
- Nächste Ziele setzen

## 1. Fokus dieser Woche (10 min)

- **Domain Model & JPA Entities**
- Alle Entities mit Relationships
- Vererbung wo sinnvoll
- Value Objects für Address, Money, etc.

## 2. Technische Guidance (20 min)

- **Entity-Design:**
  - @Entity, @Id, @GeneratedValue
  - @OneToMany, @ManyToOne, @ManyToMany
  - Cascade-Types richtig setzen
- **Inheritance:**
  - SINGLE_TABLE, JOINED, TABLE_PER_CLASS — welche Strategie?
- **Value Objects:**
  - @Embeddable, @Embedded
  - Address, Money, Email

## 3. Code Review (20 min)

- Entity-Modelle reviewen
- ER-Diagramm vs. Implementierung vergleichen
- JPA-Annotationen prüfen

## 4. Arbeitsphase (2h)

- Schüler arbeiten eigenständig
- Individuelle Beratung bei Bedarf
- Check-in nach 1h: Fortschritt?

## 5. Wrap-up (15 min)

- Entities fertig?
- Nächste Woche: REST API

---

## Häufige Probleme

- Cascade-Types falsch → orphaned records oder unendliche Rekursion
- @ManyToMany ohne @JoinTable → falsche Tabellenstruktur
- Vererbung ohne @DiscriminatorColumn → SINGLE_TABLE funktioniert nicht
- Value Objects ohne @Embeddable → werden als separate Entität behandelt
- Lazy vs. Eager Loading → Performance-Probleme
