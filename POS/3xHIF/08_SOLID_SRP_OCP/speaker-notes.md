# Speaker Notes — 08: SOLID I (SRP, OCP)

**Woche 10** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- TDD: Red-Green-Refactor, FIRST
- JUnit 5: Lifecycle, AssertJ, Parameterized Tests
- **Frage:** Warum TDD? → Besseres Design, nicht nur Tests

## 1. SOLID-Überblick (15 min)

- 5 Prinzipien für gutes Software-Design
- **S**RP — Single Responsibility Principle
- **O**CP — Open-Closed Principle
- **L**SP — Liskov Substitution Principle
- **I**SP — Interface Segregation Principle
- **D**IP — Dependency Inversion Principle
- Heute: SRP + OCP

## 2. SRP — Single Responsibility (30 min)

- "Eine Klasse, ein Grund sich zu ändern"
- **Problem:** God-Klasse die alles macht (berechnen, drucken, speichern, email)
- **Lösung:** Verantwortlichkeiten extrahieren
- **Beispiel:** Invoice-Klasse aufsplitten → Invoice, InvoiceCalculator, InvoicePrinter, InvoiceRepository, InvoiceNotifier
- **Live Coding:** Aufgeblähte Klasse nach SRP aufsplitten
- Tests als Safety Net während des Refactorings

## 3. OCP — Open-Closed (30 min)

- "Offen für Erweiterung, geschlossen für Modifikation"
- **Problem:** if-else-Kaskade für jeden neuen Typ
- **Lösung:** Abstraktion + Polymorphismus
- **Strategy Pattern:** Interface für Verhalten, konkrete Implementierungen austauschbar
- **Specification Pattern:** Komposition statt Vererbung für Queries
- **Live Coding:** Report-System mit Strategy Pattern erweiterbar machen

## 4. Praxis-Übergang (10 min)

- Katas: K1 SRP Extract, K2 SRP Validation, K3 OCP Reporting, K4 OCP Specification, K5 Payroll Refactoring
- Hinweis: Immer mit Tests absichern!

## 5. Wrap-up (10 min)

- Nächste Woche: SOLID II (LSP, ISP, DIP)
- Hausübung: SRP/OCP-Verletzungen in bestehendem Code finden

---

## Häufige Fehler

- SRP zu extrem → 1-Zeilen-Klassen für alles
- OCP zu früh → YAGNI, erst refactorn wenn Erweiterung nötig
- Strategy Pattern over-engineered → einfaches Interface reicht oft
- Tests während Refactoring vergessen → Code kann kaputtgehen
- "Verantwortlichkeit" zu breit definiert → "berechnet UND speichert UND druckt" = 3 Verantwortlichkeiten
