# Speaker Notes — 00: Introduction, Tooling, var, Records

**Woche 1** | **Theorie 2h | Praxis 3h**

---

## 0. Einstieg (20 min)

- Kursvorstellung: POS3 = Programmieren und Software Entwicklung
- Bewertung: PLÜs (3×), Mini-Projekte (20%), Übungen (15%), Projekt WMC (35%), Mitarbeit (10%)
- Roter Faden: Sprache → Design → Daten → Metaebene → Persistenz → REST API
- Tooling-Check: JDK 17+, IntelliJ IDEA, Maven, Git

## 1. Tooling Setup (20 min)

- IntelliJ: Neues Projekt → Maven → JDK auswählen
- Maven-Archetype: `mvn archetype:generate` oder IntelliJ-Wizard
- Projektstruktur: `src/main/java`, `src/test/java`, `pom.xml`
- Erster Build: `mvn clean compile`
- Git: Repo initialisieren, `.gitignore` (target/, .idea/)

## 2. var — Local Variable Type Inference (20 min)

- `var` leitet Typ aus rechter Seite ab — nur für lokale Variablen
- Kein Ersatz für explizite Typen bei unklarem Kontext
- **Regeln:** Nicht für Felder, Methodenparameter, Rückgabetypen
- **Beispiel:**
  ```java
  var name = "Alice";        // String
  var list = List.of(1,2,3); // List<Integer>
  var now = LocalDate.now(); // LocalDate
  ```
- **Live Coding:** var in Schleife, var mit Stream, var mit Record

## 3. Records (30 min)

- Records = kompakte Datenklassen (Java 16+)
- Automatisch: Konstruktor, Getter (ohne `get`-Präfix), `equals`, `hashCode`, `toString`
- **Syntax:** `public record Person(String name, int age) {}`
- **Kompakter Konstruktor** für Validierung:
  ```java
  public record Person(String name, int age) {
      public Person {
          if (name == null || name.isBlank()) throw new IllegalArgumentException();
          if (age < 0) throw new IllegalArgumentException();
      }
  }
  ```
- **Live Coding:** Article-Record mit CSV-Parser (`static Article of(String csvLine)`)

## 4. Praxis-Übergang (10 min)

- Katas vorstellen: K1 Hello World, K2 Records, K3 Maven-Projekt
- Pair Programming: Driver/Navigator wechseln alle 15 min
- Abgabe: PR auf GitHub, Code Review durch Partner

## 5. Wrap-up (10 min)

- Was haben wir gelernt? Tooling, var, Records
- Nächste Woche: Interfaces, Pattern Matching, Text Blocks
- Hausübung: Eigenes Record mit Validierung, var sinnvoll einsetzen

---

## Häufige Fehler

- `var` für Klassenfelder verwenden → Compile-Fehler
- Record-Getter mit `get`-Präfix aufrufen → gibt es nicht, nur `name()`, `age()`
- Record-Konstruktor vergessen → Default-Konstruktor existiert nicht
- Maven `pom.xml` ohne `maven.compiler.source` → Java-Version falsch
