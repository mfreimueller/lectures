---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 02 - Datentypen
## POS - 1xHIF

---

## Agenda (1/2)

1. Wiederholung: Was ist ein Programm?
2. Variablen - Wofür brauchen wir sie?
3. Datentyp boolean
4. Datentyp int

---

## Agenda (2/3)

5. Datentyp float
6. Datentyp String
7. Datentyp char
8. Speicherbedarf der Datentypen
9. Deklaration und Initialisierung

---

## Agenda (3/3)

10. Ausgabe mit System.out.println
11. Erste Programme schreiben
12. Übersicht: Die fünf Datentypen
13. Häufige Fehler

---

## Lernziele

- Ich kann Variablen deklarieren und initialisieren
- Ich kann die fünf grundlegenden Datentypen nennen und einsetzen
- Ich kann einfache Programme mit Ausgabe schreiben
- Ich kann typische Anfängerfehler bei Datentypen vermeiden

---

## Wiederholung: Was ist ein Programm?

- Ein Programm ist eine Folge von Anweisungen
- Diese Anweisungen verarbeiten Daten
- Daten können Zahlen, Texte oder Wahrheitswerte sein
- Frage: Wie merkt sich ein Programm Daten?

---

## Variablen - Wofür brauchen wir sie?

- Eine Variable ist ein "Behälter" für einen Wert
- Jede Variable hat einen Namen und einen Datentyp
- Der Datentyp bestimmt, welche Werte gespeichert werden können
- Beispiel: `int alter = 17;`

---

## Partnerdiskussion: Werte und ihre Typen

<div class="highlight-box">
<p>Seht euch diese Werte an: <code>42</code>, <code>"42"</code>, <code>42.0</code>, <code>true</code>, <code>'A'</code>. Welchen Datentyp würdet ihr für jeden wählen? Diskutiert mit eurem Partner: Warum ist die Wahl des richtigen Typs wichtig?</p>
</div>

---

## Datentyp boolean

- Nur zwei Werte: `true` oder `false`
- Wird für Wahrheitswerte verwendet
- Beispiel: Ist die Tür offen? Ist der Spieler am Leben?

```java
boolean istTuerOffen = true;
boolean spielerLebt = false;
```

---

## Datentyp int

- Ganze Zahlen (ohne Nachkommastellen)
- Beispiele: 42, -3, 0, 1_000_000
- Wird für Zählungen, Alter, Punktestände verwendet

```java
int alter = 17;
int punkte = 2500;
```

---

## Datentyp float

- Gleitkommazahlen (mit Nachkommastellen)
- Beispiele: 3.14, -0.5, 99.99
- Wird für Größen, Gewichte, Preise verwendet
- Wichtig: Endet mit **f**

```java
float koerpergroesse = 1.78f;
float preis = 19.99f;
```

---

## Datentyp String

- Text — eine Zeichenkette
- Wird in doppelten Anführungszeichen geschrieben
- Beispiele: "Hallo", "Max Mustermann", "123"

```java
String name = "Max Mustermann";
String begruessung = "Hallo Welt!";
```

---

## Datentyp char

- Ein einzelnes Zeichen
- Wird in einfachen Anführungszeichen geschrieben
- Beispiele: 'A', '?', '3', '\n' (Zeilenumbruch)

```java
char anfangsbuchstabe = 'M';
char buchstabe = 'A';
```

---

## Speicherbedarf der Datentypen

- Jeder Datentyp belegt eine feste Anzahl an Bits/Bytes im Speicher
- Je mehr Bits, desto mehr verschiedene Werte sind darstellbar
- `String` hat keine feste Größe -- die Länge hängt vom Text ab

| Typ | Größe | Wertebereich |
| --- | --- | --- |
| `boolean` | 1 Bit | `true`, `false` |
| `int` | 4 Byte (32 Bit) | -2.147.483.648 … 2.147.483.647 |
| `float` | 4 Byte (32 Bit) | ca. ±1,4·10⁻⁴⁵ … ±3,4·10³⁸ |
| `char` | 2 Byte (16 Bit) | 0 … 65.535 |
| `String` | variabel | abhängig von der Zeichenanzahl |

---

## Deklaration und Initialisierung

- **Deklaration:** Datentyp und Name festlegen
- **Initialisierung:** Ersten Wert zuweisen
- Beides kann in einer Zeile passieren

```java
// Deklaration ohne Initialisierung
int x;
// Initialisierung (später)
x = 10;
// Deklaration + Initialisierung in einer Zeile
int y = 20;
```

---

## Ausgabe mit System.out.println

- Mit `System.out.println()` geben wir Werte aus
- Wir können Text und Variablen kombinieren
- Der `+`-Operator verbindet Texte

```java
String name = "Anna";
int alter = 16;
System.out.println("Name: " + name);
System.out.println("Alter: " + alter);
```

---

## Erste Programme schreiben

- Eine Java-Klasse mit `main`-Methode erstellen
- Variablen deklarieren, initialisieren und ausgeben
- Compilieren mit `javac`, ausführen mit `java`

```java
String name = "Max";
int alter = 17;
float groesse = 1.85f;
char initial = 'M';
boolean istVolljaehrig = false;
System.out.println("Name: " + name);
```

---

## Übersicht: Die fünf Datentypen

| Typ | Beschreibung | Beispiel |
| --- | --- | --- |
| `boolean` | Wahrheitswert | `true`, `false` |
| `int` | Ganze Zahl | `42`, `-7` |
| `float` | Kommazahl | `3.14f`, `2.5f` |
| `String` | Text | `"Hallo"` |
| `char` | Einzelnes Zeichen | `'A'`, `'?'` |

---

## Häufige Fehler

<div class="highlight-box">
<ul>
<li><strong>Falscher Typ:</strong> <code>int text = "Hallo";</code> → Compiler-Fehler</li>
<li><strong>Fehlende Initialisierung:</strong> Variable wird vor der Wertzuweisung verwendet</li>
<li><strong>Falsche Anführungszeichen:</strong> String braucht <code>"..."</code>, char braucht <code>'...'</code></li>
<li><strong>Semikolon vergessen:</strong> Jede Anweisung endet mit <code>;</code></li>
</ul>
</div>

---

## Summary

<div class="highlight-box">
<ul>
<li>Variablen speichern Daten in festgelegten Datentypen</li>
<li>Fünf grundlegende Typen: boolean, int, float, String, char</li>
<li>Deklaration: Typ + Name; Initialisierung: erste Wertzuweisung</li>
<li>Ausgabe mit System.out.println</li>
<li>Compiler prüft Typ-Korrektheit</li>
</ul>
</div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Der Spieler-Charakter bekommt erste Eigenschaften. Legt Variablen für die grundlegenden Attribute des Helden an und gebt sie aus.</p>
</div>
