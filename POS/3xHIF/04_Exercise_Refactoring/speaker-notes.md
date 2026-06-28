# Speaker Notes — 04: Exercise Refactoring (Java 7 → Modern Java)

**Woche 5** | **Theorie 2h | Praxis 3h** | **Typ: Übung**

---

## 0. Wiederholung (10 min)

- var, Records, Interfaces, Pattern Matching, Text Blocks
- Optional, switch Expressions, sealed Classes
- Unnamed Variables, Flexible Constructors, Utility APIs
- **Frage:** Welche Features haben euch am meisten gebracht?

## 1. Übungseinleitung (20 min)

- Ziel: Java-7-Code aus 1./2. Klasse mit modernen Features refactorn
- **Refactoring-Checkliste:**
  - Klasse → Record (wenn nur Daten)
  - `if-else instanceof` → Pattern Matching
  - traditionelles switch → switch Expression
  - null-Checks → Optional
  - Schleifen → Streams
  - `String.format` → Text Blocks
  - anonyme Klassen → Lambdas/Method References
- Pair Programming empfohlen

## 2. Refactoring-Katas (2h Theorie + 3h Praxis)

### K1: Basic Refactoring
- equals/hashCode/toString durch Record ersetzen
- Schleifen durch Streams ersetzen
- **Zeit:** 30 min

### K2: Pattern Matching & Switch
- Type-dispatching mit instanceof refactorn
- if-else-Kaskaden durch switch Expressions ersetzen
- **Zeit:** 30 min

### K3: Full Refactoring
- Komplette Java-7-Klasse zu modernem Java 21 migrieren
- Alle Features kombinieren
- **Zeit:** 45 min

### K4: Streams Refactoring
- Datenverarbeitungspipeline mit filter, map, reduce
- **Zeit:** 30 min

## 3. Besprechung (30 min)

- Musterlösungen zeigen
- Häufige Fehler besprechen
- Fragen beantworten

## 4. Wrap-up (10 min)

- Nächste Woche: Konsolidierungsübung (Wochen 1–4)
- PLÜ 1 in Woche 7 — Vorbereitung!

---

## Häufige Fehler

- Record für mutable Daten verwenden → Records sind immutable
- switch Expression ohne alle Fälle → Compile-Fehler (bei sealed)
- `Optional.get()` ohne Prüfung → kann NPE werfen
- Streams zu komplex → lesbarkeit geht verloren, besser aufteilen
