---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 10 - Arrays
## POS - 1xHIF

---

## Agenda (1/2)

1. Wiederholung: for-Schleife
2. Problem: Mehrere Werte verwalten
3. Array-Konzept
4. Array-Deklaration und Initialisierung

---

## Agenda (2/3)

5. Array mit Werten initialisieren
6. Zugriff über Index
7. Arrays mit for-Schleifen durchlaufen

---

## Agenda (3/3)

8. Die length-Eigenschaft
9. ArrayIndexOutOfBoundsException
10. Beispiel: Array befüllen und ausgeben

---

## Lernziele

- Ich kann Arrays deklarieren, initialisieren und auf Elemente zugreifen
- Ich kann Arrays mit for-Schleifen durchlaufen
- Ich kann die Grenzen von Arrays beachten (Index, Länge)

---

## Wiederholung: for-Schleife

```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

- Die for-Schleife ist ideal, um eine bekannte Anzahl von Durchläufen zu steuern
- Heute sehen wir, wofür Zählschleifen besonders nützlich sind

---

## Partnerdiskussion: Warum beginnt der Index bei 0?

<div class="highlight-box">
<p>Warum beginnt die Array-Indizierung bei 0 und nicht bei 1? Diskutiert mit eurem Partner: Wäre das Programmieren einfacher oder schwieriger, wenn man bei 1 beginnen würde? Was müsste sich sonst noch ändern?</p>
</div>

---

## Problem: Mehrere Werte verwalten

- Bisher: Eine Variable = ein Wert
- Was, wenn wir 100 Noten speichern wollen?
- Lösung: 100 einzelne Variablen? — Viel zu umständlich!
- Wir brauchen eine **Sammlung** von Werten

---

## Array-Konzept

<div class="highlight-box">
<p>Ein <strong>Array</strong> ist eine Sammlung von Werten <strong>desselben Datentyps</strong>.</p>
</div>

- Alle Werte liegen **hintereinander** im Speicher
- Jeder Wert hat eine **Nummer** (Index)
- Der Index beginnt bei **0**
- Die Größe eines Arrays ist **fest** (nach der Erstellung)

---

## Array-Deklaration und Initialisierung

```java
// Deklaration und Initialisierung in einer Zeile:
int[] zahlen = new int[5];
// Äquivalent separat:
int[] zahlen;
zahlen = new int[5];
```

- Die `[]` zeigen an: "Das ist ein Array"
- `new int[5]` erstellt ein Array mit 5 Plätzen
- Standardwerte: 0 für Zahlen, null für Objekte

---

## Array mit Werten initialisieren

```java
// Kurzform mit geschweiften Klammern:
int[] noten = {2, 3, 1, 4, 2};
// Äquivalent mit new int[]:
int[] noten = new int[]{2, 3, 1, 4, 2};
```

- Geschwungene Klammern `{ }` mit Komma-getrennten Werten
- Die Größe ergibt sich aus der Anzahl der Werte

---

## Zugriff über Index

```java
int[] noten = {2, 3, 1, 4, 2};
System.out.println(noten[0]);  // 2 (erstes Element)
System.out.println(noten[2]);  // 1 (drittes Element)
System.out.println(noten[4]);  // 2 (letztes Element)
noten[1] = 5;  // Wert ändern: {2, 5, 1, 4, 2}
```

- Index in eckigen Klammern `[ ]`
- Erster Index: `0`, letzter Index: `length - 1`

---

## Arrays mit for-Schleifen durchlaufen

```java
int[] zahlen = {4, 8, 15, 16, 23, 42};

// Alle Elemente ausgeben
for (int i = 0; i < zahlen.length; i++) {
    System.out.println("Index " + i + ": " + zahlen[i]);
}
```

- Arrays und for-Schleifen sind ein **natürliches Paar**
- Die Laufvariable `i` dient als Index

---

## Die length-Eigenschaft

```java
int[] zahlen = {4, 8, 15, 16, 23, 42};

System.out.println(zahlen.length);  // 6

// length ist eine Eigenschaft (keine Methode!)
// Keine Klammern bei length!
```

- Mit `length` bekommt man die Größe des Arrays
- Wichtig: `length` ist eine **Eigenschaft**, nicht `length()`
- Der letzte gültige Index ist immer `length - 1`

---

## ArrayIndexOutOfBoundsException

```java
int[] zahlen = {4, 8, 15, 16, 23, 42};
System.out.println(zahlen[6]);  // Fehler!
// Array hat Größe 6, gültige Indizes: 0-5
```

<div class="highlight-box">
<p>Das Programm stürzt ab mit:<br/>
<code>Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException</code></p>
</div>

- Zugriff auf einen Index außerhalb des gültigen Bereichs
- Tipp: Immer `< array.length` statt `<= array.length` verwenden

---

## Beispiel: Array befüllen und ausgeben

```java
int[] zahlen = new int[10];

// Befüllen mit Werten 1..10
for (int i = 0; i < zahlen.length; i++) {
    zahlen[i] = i + 1;
}

// Ausgeben
for (int i = 0; i < zahlen.length; i++) {
    System.out.println(zahlen[i]);
}
```

---

## Katas

Löst die folgenden Katas in eurer Entwicklungsumgebung:

- **Array erstellen und ausgeben** – Erstellt ein Array und gibt alle Elemente aus.
- **Summe und Durchschnitt** – Berechnet Summe und Durchschnitt eines Arrays.
- **Maximum suchen** – Findet das grösste Element in einem Array.
- **Array umkehren** – Kehrt die Reihenfolge eines Arrays um.

---

## Zusammenfassung

- Ein Array speichert mehrere Werte desselben Typs
- Deklaration: `int[] name = new int[größe];`
- Zugriff über Index: `name[index]` (beginnt bei 0)
- `length` gibt die Größe des Arrays an
- Arrays + for-Schleifen = ideale Kombination

---

## Jahresprojekt: Dungeon Crawler

Der Spieler bekommt ein Inventar als String-Array. Gebt mit einer for-Schleife alle Items aus. Der Spieler kann ein Item über den Index auswählen.
