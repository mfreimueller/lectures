# Proofreading Report

**Course:** 1xHIF -- Programmieren und Software Entwicklung (POS)
**Scope:** all (00_Introduction .. 32_Buffer_End)
**Focus:** terminology
**Date:** 2026-05-12

---

## Summary

| Severity | Terminology | Cross-References | Total |
|----------|-------------|------------------|-------|
| Error    | 4           | 0                | 4     |
| Warning  | 1           | 0                | 1     |
| Info     | 1           | 0                | 1     |
| **Total**| **6**       | **0**            | **6** |

---

## 1. Terminology Issues

### ERROR-T1-01: "Funktionen" statt "Methoden" in Kata-Beschreibung

| Field | Value |
|-------|-------|
| File | `18_This_Getter_Setter/katas/kata_01_konto_gekapselt.md:26` |
| Severity | Error |
| Category | Terminology: Java standard violation |
| Found | `Funktionen` |
| Expected | `Methoden` |
| Context | `Erstelle eine Test-Klasse, die alle Funktionen testet, inklusive Fehlerfaelle.` |

**Vorschlag:** Ersetze `Funktionen` durch `Methoden`.

---

### ERROR-T1-02: "Funktionen" statt "Methoden" in Dungeon Escape Plan

| Field | Value |
|-------|-------|
| File | `31_Exercise_Final/dungeon_escape/plan.md:4` |
| Severity | Error |
| Category | Terminology: Java standard violation |
| Found | `Funktionen` |
| Expected | `Methoden` |
| Context | `- Testen aller Funktionen` |

**Vorschlag:** Ersetze `Funktionen` durch `Methoden`.

---

### ERROR-T1-03: "Funktionen" statt "Methoden" in Folien

| Field | Value |
|-------|-------|
| File | `31_Exercise_Final/slides/index.html:54` |
| Severity | Error |
| Category | Terminology: Java standard violation |
| Found | `Funktionen` |
| Expected | `Methoden` |
| Context | `<li>Testen aller Funktionen</li>` |

**Vorschlag:** Ersetze `Funktionen` durch `Methoden`.

---

### ERROR-T1-04: "Funktionen" statt "Methoden" in Methoden-UEbung

| Field | Value |
|-------|-------|
| File | `07_Methods_Scanner/dungeon_escape/dungeon_escape.md:6` |
| Severity | Error |
| Category | Terminology: Java standard violation |
| Found | `Lagere diese Funktionen in Methoden aus` |
| Expected | `Lagere diese Code-Bloecke in Methoden aus` |
| Context | `Lagere diese Funktionen in Methoden aus: - zeigeStatus(...)` |

**Vorschlag:** Ersetze `Funktionen` durch `Code-Bloecke` oder `Methoden`, um die Java-Terminologie nicht zu verletzen.

---

### WARNING-T2-01: Inconsistente Verwendung von "Zaehlvariable" / "Schleifenvariable"

| Field | Value |
|-------|-------|
| File | `04_For_Loops/plan.md:23-24` |
| Severity | Warning |
| Category | Terminology: inconsistent usage |
| Issue | Konzept `loop variable` verwendet `"Zaehlvariablen"` (Z. 23) und `"Schleifenvariable"` (Z. 24) in derselben Woche. |
| Context | `Z.23: Zaehlvariablen (int i = 0; i < n; i++)\nZ.24: Schleifenkoerper und Schleifenvariable` |

**Vorschlag:** Vereinheitliche auf einen Begriff. Empfehlung: `"Zaehlvariable"` (da in Wochen 05 und 14 ebenfalls verwendet). `"Schleifenvariable"` ist zwar nicht falsch, aber die Mischung innerhalb einer Woche kann verwirren.

---

### INFO-T3-01: "For-Schleife" mit falscher Grossschreibung

| Field | Value |
|-------|-------|
| File | `23_Arrays/slides/index.html:307` |
| Severity | Info |
| Category | Terminology: hybrid formation |
| Issue | `For-Schleife` weicht vom Muster `lowercase-keyword-hyphen-German` ab. |
| Context | `<li>For-Schleife: <code>for (int i = 0; i &lt; arr.length; i++)</code></li>` |

**Vorschlag:** `for-Schleife` (engl. Keyword `for` klein, Bindestrich, deutsches Nomen `Schleife`).

---

## 2. Cross-Reference Issues

*Keine Cross-Reference-Checks durchgefuehrt (Fokus: terminology).*

---

## Appendix: Concept Timeline

| Index | Topic | Eingefuhrte Konzepte |
|-------|-------|----------------------|
| 00 | Introduction | `println`, `print`, `printf`, `main`, `Klasse`, `IDE`, `Escape-Sequenzen` |
| 01 | Datatypes/Arithmetics | `JVM`, `Bytecode`, `int`, `double`, `boolean`, `char`, `Variable`, `Arithmetik`, `+`, `-`, `*`, `/`, `%`, `Modulo` |
| 02 | Assignment/Branching | `Zuweisung`, `if`, `else`, `else if`, `==`, `!=`, `<`, `>`, `<=`, `>=`, `Scanner` (Vorgriff) |
| 03 | Nested Branching | `&&`, `\|\|`, `!`, geschachtelte ifs, Kurzschluss-Evaluierung |
| 04 | For Loops | `for`, `Zaehlvariable`, `Schleifenvariable`, verschachtelte for (Vorgriff) |
| 05 | Exercise Consolidation | for + if + Modulo Kombination |
| 06 | While/DoWhile | `while`, `do-while`, `break`, Endlosschleife |
| 07 | Methods/Scanner | `Methode`, `Parameter`, `Rueckgabetyp`, `return`, `public static`, `Scanner`, `nextInt`, `nextDouble`, `nextLine` |
| 08 | String Methods | `length()`, `equals()`, `charAt()`, `startsWith()`, `endsWith()` |
| 09 | Conversion | `Integer.parseInt`, `Float.parseFloat`, `Boolean.parseBoolean` |
| 10 | Switch/Case | `switch`, `case`, `break`, `default` |
| 11 | Exercise REPL | `while(true)`, `Scanner`, `switch`, `REPL`-Prinzip |
| 12 | Buffer | Wiederholung Wochen 00-11 |
| 13 | Buffer | Wiederholung Wochen 00-11 |
| 14 | Exercise | Gesamtwiederholung Wochen 00-13 |
| 15 | OO Intro | `Klasse`, `Objekt`, `Attribut`, `Methode` (nicht-static), `new` |
| 16 | Exercise OO | Methoden mit Parametern und Rueckgabewerten, Objektorientierung |
| 17 | Constructors | `Konstruktor`, Standardkonstruktor, parametrisierter Konstruktor, Konstruktor-Ueberladung |
| 18 | This/Getter/Setter | `this`, `private`, `public`, `Getter`, `Setter`, Kapselung |
| 19 | References | `Referenz`, Stack vs. Heap, `null`, `NullPointerException`, Objekte als Attribute/Parameter |
| 20 | Exercise OO Deep | Assoziationen, Gegenstand-Klasse, Inventar |
| 21 | Buffer | OO-Wiederholung, OO-Quiz, Game of Life |
| 22 | UML | `UML`, Klassendiagramm, Assoziation, Multiplizitaet, Code <-> UML |
| 23 | Arrays | `Array`, Deklaration, `Index`, `.length`, for ueber Array, Array als Parameter/Rueckgabewert |
| 24 | Arrays Deep | erweiterte for (for-each), `Arrays.toString()`, mehrdimensionale Arrays (`int[][]`) |
| 25 | Sorting | `Selection Sort`, `Insertion Sort`, Zeitkomplexitaet O(n²) |
| 26 | Exercise Bubblesort | `Bubblesort`, Early Break, Laufzeitvergleich |
| 27 | Buffer | Arrays/Sortieren Wiederholung |
| 28 | Random Numbers | `Math.random()`, `Random`-Klasse |
| 29 | JavaDoc | `/** */`, `@param`, `@return`, `@author` |
| 30 | Exercise Integration | Integration aller Themen |
| 31 | Exercise Final | Code-Golf, Pair-Programming, Bugfixes |
| 32 | Buffer End | Jahresabschluss, Ausblick 2. Klasse |
