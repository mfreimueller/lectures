---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 09 - Schleifen – for
## POS - 1xHIF

---

## Agenda (1/2)

1. Wiederholung: Schleifentypen
2. Die for-Schleife: Syntax
3. for-Schleife: Ablauf
4. Beispiel: Zahlen 1 - 10

---

## Agenda (2/3)

5. Umbau while → for: Schritt 1
6. Umbau while → for: Schritt 2
7. Beispiel: Rückwärts zählen
8. Beispiel: Schrittweite

---

## Agenda (3/3)

9. Beispiel: Summe mit for
10. Vergleich: Wann welcher Schleifentyp?
11. Gemeinsamkeiten der Schleifen

---

## Lernziele

- Ich kann die for-Schleife anwenden
- Ich kann verschiedene Schleifentypen vergleichen und auswählen
- Ich kann for-Schleifen mit verschiedenen Schrittweiten einsetzen

---

## Wiederholung: Schleifentypen

- **while:** Kopfgesteuert — Bedingung vor dem Durchlauf
- **do-while:** Fußgesteuert — Bedingung nach dem Durchlauf
- Beide eignen sich für Zählschleifen, aber die Syntax ist etwas umständlich
- Es gibt einen spezialisierten Schleifentyp für das Zählen: **for**

---

## Partneraktivität: For-Schleifen im Vergleich

<div class="highlight-box">
<p>Schreibt einen for-Schleifen-Kopf, der die geraden Zahlen von 0 bis 10 ausgibt. Schreibt dann einen, der von 10 bis 0 rückwärts zählt. Vergleicht mit eurem Partner: Wie viele verschiedene Lösungen habt ihr gefunden?</p>
</div>

---

## Die for-Schleife: Syntax

```java
for (Initialisierung; Bedingung; Inkrement) {
    // Schleifenkörper
}
```

- **Initialisierung:** Wird einmal am Anfang ausgeführt (z. B. `int i = 0`)
- **Bedingung:** Wird vor jedem Durchlauf geprüft (z. B. `i < 10`)
- **Inkrement:** Wird nach jedem Durchlauf ausgeführt (z. B. `i++`)

---

## for-Schleife: Ablauf

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

1. `int i = 0` (Initialisierung — einmal)
2. `i < 5` prüfen → true → Schleifenkörper ausführen
3. `i++` (Inkrement)
4. Zurück zu Schritt 2: `i < 5` prüfen → ...
5. Wenn `i < 5` false ist → Ende

---

## Beispiel: Zahlen 1 - 10

```java
// while-Version
int i = 1;
while (i <= 10) {
    System.out.println(i);
    i++;
}

// for-Version
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```

Die for-Schleife ist kompakter — alles Wichtige in einer Zeile

---

## Umbau while → for: Schritt 1

Gegeben: Eine while-Zählschleife

```java
int i = 0;          // Initialisierung
while (i < 10) {    // Bedingung
    System.out.println(i);
    i++;            // Inkrement
}
```

---

## Umbau while → for: Schritt 2

Erkenne die drei Teile und setze sie in die for-Syntax:

```java
// Initialisierung: int i = 0
// Bedingung:       i < 10
// Inkrement:       i++

for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

<div class="highlight-box">
<p>Initialisierung → Bedingung → Inkrement</p>
</div>

---

## Beispiel: Rückwärts zählen

```java
// Von 10 bis 1 absteigend
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}
```

- Start: 10
- Bedingung: `i >= 1`
- Inkrement: `i--` (dekrementieren)

---

## Beispiel: Schrittweite

```java
// Alle geraden Zahlen von 0 bis 100
for (int i = 0; i <= 100; i += 2) {
    System.out.println(i);
}

// Alle Dreier-Schritte von 0 bis 30
for (int i = 0; i <= 30; i += 3) {
    System.out.println(i);
}
```

Das Inkrement muss nicht `i++` sein — jede Änderung ist möglich

---

## Beispiel: Summe mit for

```java
int summe = 0;
for (int i = 1; i <= 100; i++) {
    summe += i;
}
System.out.println("Summe 1..100 = " + summe);
```

Kompakt und lesbar — die for-Schleife ist ideal für Zählaufgaben

---

## Vergleich: Wann welcher Schleifentyp?

<div class="highlight-box">
<ul>
<li><strong>for:</strong> Wenn die Anzahl der Durchläufe bekannt ist (Zählschleife)</li>
<li><strong>while:</strong> Wenn die Bedingung vom Programmverlauf abhängt</li>
<li><strong>do-while:</strong> Wenn der Körper mindestens einmal ausgeführt werden muss</li>
</ul>
</div>

---

## Gemeinsamkeiten der Schleifen

- Alle drei können `break` und `continue` verwenden
- Alle drei brauchen eine Bedingung, die irgendwann false wird
- Alle drei können ineinander verschachtelt werden
- Die Wahl des Typs hängt vom **Einsatzzweck** ab

---

## Zusammenfassung

<div class="highlight-box">
<ul>
<li>Die <code>for</code>-Schleife ist eine spezialisierte Zählschleife</li>
<li>Syntax: <code>for (init; bedingung; inkrement)</code></li>
<li>Jede while-Zählschleife kann in eine for-Schleife umgebaut werden</li>
<li>for: bekannte Anzahl; while: unbekannte Dauer; do-while: mindestens einmal</li>
</ul>
</div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Der Dungeon Crawler bekommt mehrere Gegner. Der Spieler kämpft gegen eine Gruppe von 3 Goblins. Verwendet eine for-Schleife, um nacheinander gegen jeden Goblin anzutreten.</p>
</div>
