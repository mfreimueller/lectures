---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 15 - Funktionen
## POS - 1xHIF

---

## Agenda (1/2)

1. Problem: Code wiederholt sich
2. Was sind Funktionen?
3. Methoden-Syntax
4. Beispiel: sayHello

---

## Agenda (2/3)

5. Parameter
6. Rückgabewerte
7. void - kein Rückgabewert
8. Aufruf einer Funktion

---

## Agenda (3/3)

9. Imperatives Paradigma
10. Beispiele: addiere, istGerade
11. Vorteile von Funktionen

---

## Lernziele

- Ich kann das Problem von Code-Wiederholungen beschreiben
- Ich kann Methoden mit Parametern und Rückgabewerten definieren
- Ich kann void und Rückgabetypen unterscheiden
- Ich kann die Vorteile von Funktionen nennen

---

## Problem: Code wiederholt sich

```java
int a = 5, b = 3;
int sum1 = a + b;
System.out.println("Summe: " + sum1);

int c = 10, d = 7;
int sum2 = c + d;
System.out.println("Summe: " + sum2);
// Gleicher Code, nur andere Variablen!
```

Das verletzt das **DRY-Prinzip**: Don't Repeat Yourself!

---

## Partneraktivität: Methodensignaturen entwerfen

<div class="highlight-box">
<p>Euer Partner beschreibt eine Berechnung (z. B. «Fläche eines Rechtecks»). Ihr schreibt die Methodensignatur auf Papier. Wechselt und prüft: Ist der Methodenname aussagekräftig? Sind die Parameternamen hilfreich?</p>
</div>

---

## Was sind Funktionen?

- Eine Funktion (Methode) ist ein wiederverwendbarer Code-Block
- Sie hat einen Namen, optional Parameter und einen Rückgabewert
- Einmal definiert — beliebig oft aufrufbar
- In Java schreiben wir Methoden in einer Klasse

---

## Methoden-Syntax

```java
public static Rückgabetyp methodenName(Parameterliste) {
    // Methodenkörper
    return wert; // nur wenn Rückgabetyp != void
}
```

- `public static` — Zugriffsmodifizierer (später mehr)
- `Rückgabetyp` — z. B. `int`, `double`, `boolean`, `void`
- `methodenName` — frei wählbar (CamelCase)
- `Parameterliste` — Eingabewerte, z. B. `int a, int b`

---

## Beispiel: sayHello

```java
public static void sayHello() {
    System.out.println("Hallo!");
}

public static void main(String[] args) {
    sayHello(); // Aufruf der Methode
    sayHello(); // nochmal aufrufen
}
```

Ausgabe: "Hallo!" zweimal

---

## Parameter

- Parameter sind Eingabewerte für die Methode
- Sie werden in der Klammer nach dem Methodennamen definiert

```java
public static void greet(String name) {
    System.out.println("Hallo, " + name + "!");
}
// Aufruf: greet("Anna"); greet("Max");
```

Ausgabe: "Hallo, Anna!" und "Hallo, Max!"

---

## Rückgabewerte

- Eine Methode kann ein Ergebnis zurückgeben (mit `return`)
- Der Rückgabetyp wird vor dem Methodennamen angegeben

```java
public static int add(int a, int b) {
    return a + b;
}
// Aufruf: int sum = add(3, 5); // 8
```

---

## void - kein Rückgabewert

- `void` bedeutet: Die Methode gibt nichts zurück
- Sie führt Anweisungen aus, liefert aber kein Ergebnis
- Kein `return`-Wert nötig (nur `return;` zum vorzeitigen Beenden)

```java
public static void printMenu() {
    System.out.println("1: Angreifen");
    System.out.println("2: Inventar");
    System.out.println("3: Beenden");
    // kein return nötig
}
```

---

## Aufruf einer Funktion

- Methodenaufruf: `methodenName(wert1, wert2, ...)`
- Die Werte müssen den Parametertypen entsprechen
- Bei `void`: Aufruf als eigene Anweisung
- Bei Rückgabewert: Aufruf in einem Ausdruck

```java
sayHello();                     // void-Aufruf
greet("Anna");                  // void-Aufruf mit Parameter
int ergebnis = add(3, 5);       // Aufruf mit Rückgabewert
System.out.println(add(10, 20));// Aufruf direkt in Ausgabe
```

---

## Imperatives Paradigma

- Bisher haben wir **imperativ** programmiert
- Ein Programm ist eine Abfolge von Anweisungen
- Funktionen helfen, diese Abfolge zu strukturieren
- Das Programm wird zu einer Abfolge von Funktionsaufrufen

```java
public static void main(String[] args) {
    printMenu();
    int wahl = readChoice();
    executeAction(wahl);
}
```

---

## Beispiele: addiere, istGerade

```java
public static int addiere(int a, int b) {
    return a + b;
}

public static boolean istGerade(int number) {
    return number % 2 == 0;
}

public static void main(String[] args) {
    System.out.println(addiere(5, 3));
    System.out.println(istGerade(4));
    System.out.println(istGerade(7));
}
```

---

## Vorteile von Funktionen

- **Wiederverwendbarkeit:** Einmal schreiben, mehrfach nutzen
- **Lesbarkeit:** Code wird durch Methodennamen selbstdokumentierend
- **Wartbarkeit:** Änderungen nur an einer Stelle
- **Testbarkeit:** Einzelne Methoden können isoliert getestet werden
- **Struktur:** Programm wird in überschaubare Teile zerlegt

---

## Zusammenfassung

<div class="highlight-box">
<ul>
<li>Funktionen gliedern Code in wiederverwendbare Blöcke</li>
<li>Syntax: <code>public static Rückgabe name(Parameter) { ... }</code></li>
<li><code>void</code> = kein Rückgabewert</li>
<li>Parameter = Eingabewerte, <code>return</code> = Rückgabewert</li>
<li>DRY-Prinzip: Don't Repeat Yourself</li>
</ul>
</div>

---

## Ausblick

<div class="highlight-box"><p>Nächste Woche ist eine reine Übungsstunde: Wir bauen eine REPL (Read-Eval-Print-Loop) — einen interaktiven Befehlsinterpreter.</p></div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Strukturiere deinen Dungeon Crawler mit Funktionen um.</p>
</div>
