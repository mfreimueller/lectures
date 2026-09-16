---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 14 - switch-case
## POS - 1xHIF

---

## Agenda (1/2)

1. Problem: Lange if-else-Kaskaden
2. switch-case Syntax
3. Beispiel: Wochentag
4. Fall-through (ohne break)

---

## Agenda (2/3)

5. default-Zweig
6. switch mit int
7. switch mit char

---

## Agenda (3/3)

8. switch mit String
9. switch vs. if-else
10. Beispiel: Menüauswahl

---

## Lernziele

- Ich kann switch-case als Alternative zu if-else-Kaskaden einsetzen
- Ich kann die switch-case-Syntax mit break und default anwenden
- Ich kann switch mit verschiedenen Datentypen verwenden

---

## Problem: Lange if-else-Kaskaden

```java
if (tag == 1) {
    System.out.println("Montag");
} else if (tag == 2) {
    System.out.println("Dienstag");
} else if (tag == 3) {
    System.out.println("Mittwoch");
} // ... und so weiter
```

Das ist umständlich und schwer lesbar!

---

## Partnerdiskussion: switch vs. if-else

<div class="highlight-box">
<p>Euer Partner nennt einen Wochentag. Ihr sagt, was ihr an diesem Tag macht. Schreibt dann gemeinsam eine switch-Anweisung dafür. Warum ist switch hier besser als 7 if-else-Anweisungen? Gibt es auch Nachteile?</p>
</div>

---

## switch-case Syntax

```java
switch (ausdruck) {
    case wert1: /* Code */ break;
    case wert2: /* Code */ break;
    default: /* Code */ break;
}
```

- `ausdruck` — ein int, char oder String
- `case` — ein möglicher Wert
- `break` — beendet den switch-Block
- `default` — für alle nicht abgedeckten Fälle

---

## Beispiel: Wochentag (1/2)

```java
switch (tag) {
    case 1:
        System.out.println("Montag");
        break;
    case 2:
        System.out.println("Dienstag");
        break;
    case 3:
        System.out.println("Mittwoch");
        break;
```

---

## Beispiel: Wochentag (2/2)

```java
    case 4:
        System.out.println("Donnerstag");
        break;
    case 5:
        System.out.println("Freitag");
        break;
    case 6:
        System.out.println("Samstag");
        break;
    case 7:
        System.out.println("Sonntag");
        break;
}
```

---

## Fall-through (ohne break)

- Fehlt ein `break`, fällt der Code in den nächsten `case` durch
- Kann nützlich sein für gemeinsame Aktionen

```java
switch (note) {
    case 1: case 2: System.out.println("Bestanden"); break;
    case 3: case 4: System.out.println("Knapp bestanden"); break;
    default: System.out.println("Durchgefallen");
}
```

---

## Fall-through — Wirkung

Hier haben Noten 1 und 2 die gleiche Ausgabe.

---

## default-Zweig

- `default` wird ausgeführt, wenn kein `case` passt
- Vergleichbar mit dem letzten `else` bei if-else
- Sollte immer am Ende stehen

```java
switch (tag) {
    case 1: System.out.println("Montag"); break;
    case 2: System.out.println("Dienstag"); break;
    default: System.out.println("Ungültige Eingabe!"); break;
}
```

---

## switch mit int

- Der häufigste Fall: `switch` auf einer int-Variable
- Perfekt für Menüauswahl (1, 2, 3, ...)

```java
switch (auswahl) {
    case 1: System.out.println("Spiel starten"); break;
    case 2: System.out.println("Optionen"); break;
    case 3: System.out.println("Beenden"); break;
    default: System.out.println("Unbekannt"); break;
}
```

---

## switch mit char

- `char` ist ein einzelnes Zeichen (in einfachen Anführungszeichen)

```java
char buchstabe = 'A';
switch (buchstabe) {
    case 'A': System.out.println("Anfangen"); break;
    case 'B': System.out.println("Beenden"); break;
    default: System.out.println("Unbekannt"); break;
}
```

---

## switch mit String

- Seit Java 7 kann `switch` auch Strings auswerten

```java
String tier = scanner.nextLine();
switch (tier) {
    case "Hund": System.out.println("Wuff"); break;
    case "Katze": System.out.println("Miau"); break;
    default: System.out.println("Unbekanntes Tier"); break;
}
```

---

## switch vs. if-else

| switch-case | if-else |
| --- | --- |
| Nur ein Ausdruck | Beliebige Bedingungen |
| Nur Gleichheit prüfbar | Vergleiche (<, >, etc.) möglich |
| Lesbarer bei vielen Fällen | Unübersichtlich bei vielen else-ifs |
| int, char, String | Beliebige boolean-Ausdrücke |

---

## Beispiel: Menüauswahl

```java
System.out.println("1: Angreifen");
System.out.println("2: Inventar");
System.out.println("3: Heilen");
System.out.println("4: Fliehen");
int wahl = scanner.nextInt();

switch (wahl) {
    case 1: System.out.println("Du greifst an!"); break;
    case 2: System.out.println("Dein Inventar:"); break;
    case 3: System.out.println("Du heilst dich."); break;
    case 4: System.out.println("Du fliehst!"); break;
    default: System.out.println("Ungültige Wahl!"); break;
}
```

---

## Zusammenfassung

<div class="highlight-box">
<ul>
<li><code>switch-case</code> ist eine Alternative zu langen if-else-Kaskaden</li>
<li>Syntax: <code>switch(ausdruck) { case wert: ... break; }</code></li>
<li>Ohne <code>break</code> kommt es zum Fall-through</li>
<li><code>default</code> fängt alle nicht abgedeckten Fälle</li>
<li>Funktioniert mit <code>int</code>, <code>char</code> und <code>String</code></li>
</ul>
</div>

---

## Ausblick

<div class="highlight-box"><p>Nächste Woche lernen wir Funktionen (Methoden) kennen — Code in wiederverwendbare Blöcke auslagern.</p></div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Baue switch-case in deinen Dungeon Crawler ein.</p>
</div>
