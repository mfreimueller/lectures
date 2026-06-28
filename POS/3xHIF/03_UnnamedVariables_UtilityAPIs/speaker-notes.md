# Speaker Notes — 03: Unnamed Variables, Flexible Constructors, Utility APIs

**Woche 4** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- Optional: Container für nullable, map/flatMap/filter
- switch Expressions: `->` Syntax, yield für Blöcke
- sealed Classes: Kontrollierte Vererbung, exhaustive switch
- **Frage:** Warum sealed besser als enum für komplexe Hierarchien?

## 1. Unnamed Variables `_` (20 min)

- `_` ignoriert ungenutzte Werte → lesbarer Code
- **Einsatzorte:**
  - catch-Block: `catch (IOException _) { ... }`
  - enhanced-for: `for (var _ : list) { counter++; }`
  - Pattern Matching: `if (obj instanceof Person(_, int age))`
  - switch Patterns: `case Person(_, var age) -> ...`
  - try-with-resources: `try (var _ = acquireLock()) { ... }`
- **Live Coding:** Code mit ungenutzten Variablen durch `_` ersetzen

## 2. Flexible Constructor Bodies (Java 22+) (20 min)

- Code VOR `super()` erlaubt → Validierung und Vorbereitung
- Bisher: `super()` musste erste Anweisung sein
- **Einschränkung:** Kein Zugriff auf `this` oder Instanzmember vor `super()`
- **Beispiel:**
  ```java
  public class ValidatingPerson extends Person {
      public ValidatingPerson(String name) {
          if (name == null || name.isBlank()) {
              throw new IllegalArgumentException("Name required");
          }
          super(normalize(name));
      }
  }
  ```

## 3. Moderne Utility APIs (30 min)

- **String:** `isBlank()`, `strip()`, `repeat(n)`, `lines()`, `transform()`, `formatted()`
- **Files:** `Files.readString(path)`, `Files.writeString(path, content)`
- **Collections:** `List.of()`, `Set.of()`, `Map.of()`, `List.copyOf()`
- **Unterschied:** `of()` = immutable, `copyOf()` = defensive copy
- **Live Coding:** Datei lesen, Zeilen filtern, transformieren, schreiben

## 4. Praxis-Übergang (10 min)

- Katas: K1 Unnamed Variables, K2 Flexible Constructor, K3 Utility APIs, K4 File Processor
- Hinweis: `List.of()` wirft bei null → `new ArrayList<>()` wenn null erlaubt

## 5. Wrap-up (10 min)

- Nächste Woche: Refactoring-Übung (Java 7 → Modern Java)
- Hausübung: Legacy-Code mit modernen Features refactorn

---

## Häufige Fehler

- `_` als Bezeichner verwenden → Compile-Fehler (ab Java 22 reserviert)
- Flexible Constructor: `this` vor `super()` verwenden → Compile-Fehler
- `List.of(null)` → NullPointerException (immutable Collections erlauben kein null)
- `Files.readString()` für große Dateien → Memory-Probleme, besser `Files.lines()`
