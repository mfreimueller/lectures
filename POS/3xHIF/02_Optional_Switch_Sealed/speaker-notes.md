# Speaker Notes — 02: Optional, switch Expressions, sealed Classes

**Woche 3** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- Default/Static Methods: Interface-Entwicklung ohne Breaking Changes
- Pattern Matching instanceof: Kein Cast mehr nötig
- Text Blocks: `"""..."""` für mehrzeilige Strings
- **Frage:** Wann Default-Methode, wann abstrakte Methode?

## 1. Optional<T> (35 min)

- Optional = Container für nullable Werte → NullPointerException vermeiden
- **Erzeugung:** `Optional.of(value)`, `Optional.ofNullable(value)`, `Optional.empty()`
- **Konsum:** `isPresent()`, `ifPresent()`, `orElse()`, `orElseGet()`, `orElseThrow()`
- **Transformation:** `map()`, `flatMap()`, `filter()`
- **Best Practices:**
  - Nur als Rückgabetyp, NICHT für Felder oder Parameter
  - `orElseGet()` statt `orElse()` wenn Supplier teuer ist
  - `flatMap()` für verschachtelte Optionals
- **Live Coding:** ArticleRepository mit `Optional<Article> findById()`

## 2. switch Expressions (25 min)

- Pfeil-Syntax `->` → kein Fall-through, kein `break` nötig
- `yield` für Block-Ergebnisse
- Kann als Ausdruck verwendet werden: `var result = switch (x) { ... };`
- **Beispiel:**
  ```java
  var dayType = switch (day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "weekday";
      case SATURDAY, SUNDAY -> "weekend";
  };
  ```

## 3. sealed Classes/Interfaces (30 min)

- Kontrollierte Vererbung: `sealed permits A, B, C`
- Subklassen müssen `final`, `sealed` oder `non-sealed` sein
- **Vorteil:** Exhaustive switch — Compiler prüft Vollständigkeit
- **Kombination mit switch:** Kein `default`-Zweig nötig bei sealed Hierarchie
- **Live Coding:** Sealed OrderStatus → PENDING, SHIPPED, DELIVERED, CANCELLED

## 4. Praxis-Übergang (10 min)

- Katas: K1 Optional, K2 switch Expressions, K3 Sealed Classes, K4 Sealed Shape
- Hinweis: sealed + switch ohne default → Compiler prüft Vollständigkeit

## 5. Wrap-up (10 min)

- Nächste Woche: Unnamed Variables, Flexible Constructor Bodies, Utility APIs
- Hausübung: Optional-Pipeline, switch Expression, sealed Hierarchie

---

## Häufige Fehler

- `Optional` als Feld verwenden → Anti-Pattern
- `orElse()` mit teurer Berechnung → immer `orElseGet()` verwenden
- switch Expression ohne `yield` im Block → Compile-Fehler
- sealed class: permits-Liste unvollständig → Compile-Fehler
- switch mit sealed: `default`-Zweig → Compiler-Warnung (unnötig)
