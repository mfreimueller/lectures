---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 07 - Schleifen – while
## POS - 1xHIF

---

## Agenda (1/2)

1. Wiederholung: User Input
2. Wiederholung im Alltag
3. Konzept der Wiederholung
4. Die while-Schleife: Syntax

---

## Agenda (2/3)

5. Beispiel: Zahlen 1 bis 10
6. Zählvariablen-Pattern
7. While mit Zählvariable: Ablauf
8. Endlosschleifen

---

## Agenda (3/3)

9. Endlosschleifen vermeiden
10. Beispiel: Summe 1 bis n
11. Beispiel: While mit User Input

---

## Lernziele

- Ich kann das Konzept von Wiederholungen erklären
- Ich kann die while-Schleife anwenden
- Ich kann Endlosschleifen erkennen und vermeiden
- Ich kann while-Schleifen mit Benutzereingaben kombinieren

---

## Wiederholung: User Input

- Mit `Scanner` können wir Benutzereingaben lesen
- `nextInt()` für ganze Zahlen, `nextLine()` für Text
- Mit `Random` können wir Zufallszahlen erzeugen
- Bisher: Einmalige Eingabe, einmalige Ausgabe

---

## Partnerdiskussion: Endlosschleifen

<div class="highlight-box">
<p>Seht euch diesen Code an: <code>while (true) { System.out.println("Hallo"); }</code>. Was passiert, wenn man ihn ausführt? Wie müsste man den Code ändern, damit «Hallo» genau 5 Mal ausgegeben wird? Diskutiert mit eurem Partner.</p>
</div>

---

## Wiederholung im Alltag

- Jeden Morgen: Wecker klingelt → aufstehen → Zähne putzen → ...
- Sport: 10 Wiederholungen einer Übung
- Musik: Ein Lied läuft in einer Schleife
- Immer das gleiche Muster: **etwas wiederholen**

---

## Konzept der Wiederholung

- Ein Programm soll manche Anweisungen mehrfach ausführen
- Beispiel: "Gib die Zahlen von 1 bis 10 aus"
- Ohne Schleife: 10 mal `System.out.println()`
- Mit Schleife: eine Anweisung, die 10 mal läuft
- Eine **Schleife** wiederholt Code, solange eine Bedingung gilt

---

## Die while-Schleife: Syntax

```java
while (Bedingung) {
    // Schleifenkörper - wird wiederholt
}
```

- **Bedingung:** Ein boolean-Ausdruck (true/false)
- **Schleifenkörper:** Wird ausgeführt, solange die Bedingung true ist
- Vor jedem Durchlauf wird die Bedingung geprüft
- Ist die Bedingung false, wird die Schleife beendet

---

## Beispiel: Zahlen 1 bis 10

```java
int i = 1;
while (i <= 10) {
    System.out.println(i);
    i++;
}
```

- `i` ist die **Zählvariable**
- Startwert: 1
- Bedingung: i <= 10
- `i++` erhöht i nach jedem Durchlauf

---

## Zählvariablen-Pattern

```java
int i = 0;          // 1. Initialisierung
while (i < 10) {    // 2. Bedingung
    // ... mache etwas ...
    i++;            // 3. Inkrement
}
```

- Drei Teile: **Initialisierung, Bedingung, Inkrement**
- Oft startet man bei 0 (Programmierkonvention)
- Oder bei 1 (mathematisch)
- Das `<` vs. `<=` bestimmt die Anzahl der Durchläufe

---

## While mit Zählvariable: Ablauf

```java
// Start: i=0 → 0<10 → true → ausführen → i=1
// ... i=1,2,...,8 → Bedingung true → ausführen
// i=9 → 9<10 → true → ausführen → i=10
// i=10 → 10<10 → false → ENDE
```

10 Durchläufe: i = 0, 1, 2, ..., 9

---

## Endlosschleifen

```java
int i = 1;
while (i <= 10) {
    System.out.println("Hallo");
    // i++ fehlt!
}
```

- Was passiert? `i` bleibt immer 1
- Die Bedingung `i <= 10` ist immer true
- Die Schleife läuft **ewig** → Endlosschleife
- Abbruch mit `Strg + C` (oder Stop-Knopf in IDE)

---

## Endlosschleifen vermeiden

<div class="highlight-box">
<p><strong>Merke:</strong> Jede Schleife muss die Bedingung irgendwann false machen!</p>
</div>

- Die Zählvariable muss sich **ändern**
- Das Inkrement darf nicht fehlen
- Die Bedingung muss **irgendwann** false werden
- Tipp: Schreibe zuerst die Zählvariable und das Inkrement

---

## Beispiel: Summe 1 bis n

```java
int n = 100;
int summe = 0;
int i = 1;

while (i <= n) {
    summe = summe + i;
    i++;
}

System.out.println("Summe 1.." + n + " = " + summe);
```

---

## Beispiel: While mit User Input

```java
Scanner scanner = new Scanner(System.in);
String eingabe = "";

while (!eingabe.equals("quit")) {
    System.out.print("Befehl: ");
    eingabe = scanner.nextLine();
    System.out.println("Eingegeben: " + eingabe);
} 
```

Die Schleife läuft, bis der Benutzer "quit" eingibt

---

## Katas

<div class="highlight-box">
<p>Löst die folgenden Katas in eurer Entwicklungsumgebung:</p>
<ul>
<li><strong>Zahlenreihe</strong> – Gibt Zahlen von 1 bis n mit einer while-Schleife aus.</li>
<li><strong>Summe berechnen</strong> – Berechnet die Summe von 1 bis n.</li>
<li><strong>Gerade Zahlen</strong> – Gibt alle geraden Zahlen bis n aus.</li>
<li><strong>Countdown</strong> – Zählt von n bis 0 rückwärts.</li>
</ul>
</div>

---

## Zusammenfassung

<div class="highlight-box">
<ul>
<li>Die <code>while</code>-Schleife wiederholt Code, solange eine Bedingung true ist</li>
<li>Zählvariablen-Pattern: Initialisierung, Bedingung, Inkrement</li>
<li>Endlosschleifen entstehen, wenn die Bedingung nie false wird</li>
<li>Mit while können wir benutzerdefinierte Wiederholungen steuern</li>
</ul>
</div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Der Dungeon Crawler bekommt eine Spielschleife: Der Spieler wird solange nach einer Aktion gefragt, bis er "quit" eingibt. Verwendet eine while-Schleife.</p>
</div>
