# Speaker Notes — 01: Interfaces, Pattern Matching, Text Blocks

**Woche 2** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- var: Nur lokale Variablen, Typ wird abgeleitet
- Records: Kompakte Datenklassen, kompakter Konstruktor für Validierung
- Tooling: Maven build, Git workflow
- **Frage:** Warum Records statt Klassen? → Weniger Boilerplate, immutable by default

## 1. Default Methods in Interfaces (25 min)

- Interface-Methoden mit Implementierung → Evolution ohne Breaking Changes
- **Beispiel:** `List.sort()` (Java 8) — alle Listen bekommen Sortierung gratis
- **Konfliktregeln:**
  - Klasse gewinnt immer gegenüber Interface
  - Subtyp-Interface gewinnt gegenüber Super-Interface
  - Bei Gleichstand: `override` muss explizit sein
- **Live Coding:** Payment-Interface mit `default void refund()`

## 2. Static Methods in Interfaces (15 min)

- Utility-Methoden direkt im Interface → kein separates `Utils`-Klasse nötig
- **Beispiel:** `Payment.processBatch(List<Payment> payments)`
- Nicht vererbbar, nur über Interface-Namen aufrufbar

## 3. Pattern Matching for instanceof (25 min)

- Alt: `if (obj instanceof String) { String s = (String) obj; ... }`
- Neu: `if (obj instanceof String s) { ... }` — kein Cast nötig
- Pattern-Variable gilt nur im `if`-Block (scope)
- **Record Patterns:** `if (obj instanceof Person(String name, int age)) { ... }`
- **Live Coding:** instanceof-Kaskade mit Pattern Matching ersetzen

## 4. Text Blocks (20 min)

- `"""..."""` für mehrzeilige Strings (Java 15+)
- Einrückung wird automatisch entfernt (leading whitespace)
- `\s` = trailing space erhalten, `\` = Zeilenumbruch unterdrücken
- `formatted()` = `String.format()` für Text Blocks
- **Live Coding:** HTML-Template, JSON-Template, SQL-Query als Text Block

## 5. Praxis-Übergang (10 min)

- Katas: K1 Default Methods, K2 Pattern Matching, K3 Text Blocks, K4 Document Generator
- Hinweis: Default-Methoden-Konflikte bewusst provozieren und auflösen

## 6. Wrap-up (10 min)

- Nächste Woche: Optional, switch Expressions, sealed Classes
- Hausübung: Interface mit Default-Methode, instanceof refactorn, Text Block verwenden

---

## Häufige Fehler

- Default-Methode in Klasse überschreiben, aber `@Override` vergessen
- Pattern-Variable außerhalb des if-Blocks verwenden → Scope-Fehler
- Text Block ohne schließende `"""` → Compile-Fehler
- `instanceof` mit Record Pattern: Record muss public sein
