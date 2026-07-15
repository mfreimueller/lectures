---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 08 - Schleifen – do-while
## POS - 1xHIF

---

## Agenda (1/2)

1. Wiederholung: while-Schleife
2. Kopf- vs. fußgesteuerte Schleife
3. Die do-while-Schleife: Syntax
4. Beispiel: do-while

---

## Agenda (2/3)

5. while vs. do-while
6. break - Schleife vorzeitig beenden
7. break: Beispiel
8. continue - Durchlauf überspringen

---

## Agenda (3/3)

9. continue: Beispiel
10. break vs. continue
11. Menübeispiel mit do-while
12. do-while mit break

---

## Lernziele

- Ich kann kopf- und fußgesteuerte Schleifen unterscheiden
- Ich kann die do-while-Schleife anwenden
- Ich kann break und continue gezielt einsetzen
- Ich kann Menübeispiele mit do-while umsetzen

---

## Wiederholung: while-Schleife

```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}
```

- **Kopfgesteuert:** Bedingung wird vor dem Durchlauf geprüft
- Wenn die Bedingung von Anfang an false ist → 0 Durchläufe

---

## Partnerdiskussion: Wann do-while?

<div class="highlight-box">
<p>Stellt euch ein Menüprogramm vor, das immer wieder angezeigt wird, bis der Benutzer «Beenden» wählt. Warum ist do-while dafür perfekt? Könnte man das auch mit while lösen? Diskutiert die Vor- und Nachteile.</p>
</div>

---

## Kopf- vs. fußgesteuerte Schleife

<div class="highlight-box">
<p><strong>Kopfgesteuert (while):</strong> Prüfen → Ausführen → Prüfen → ...</p>
<p><strong>Fußgesteuert (do-while):</strong> Ausführen → Prüfen → Ausführen → ...</p>
</div>

- Der Unterschied: Eine fußgesteuerte Schleife läuft **mindestens einmal**
- Ideal, wenn etwas zuerst passieren muss (z. B. Menü anzeigen)

---

## Die do-while-Schleife: Syntax

```java
do {
    // Schleifenkörper - wird mindestens einmal ausgeführt
} while (Bedingung);
```

- Das `do` startet den Schleifenkörper
- Nach dem Durchlauf wird die Bedingung geprüft
- Solange die Bedingung true ist → wiederholen
- Wichtig: Das Semikolon nach `while(Bedingung)` nicht vergessen!

---

## Beispiel: do-while

```java
int i = 0;
do {
    System.out.println(i);
    i++;
} while (i < 5);
```

- Ergebnis: 0, 1, 2, 3, 4 — gleiche Ausgabe wie while
- Aber: Selbst wenn `i = 10` wäre, würde die Schleife mindestens einmal laufen

---

## while vs. do-while

```java
// while - wird nie ausgeführt
while (false) {
    System.out.println("While");
}

// do-while - wird einmal ausgeführt
do {
    System.out.println("Do-While");
} while (false);
```

Ausgabe: "Do-While" (einmal)

---

## break - Schleife vorzeitig beenden

```java
while (true) {
    int zahl = scanner.nextInt();
    if (zahl < 0) break;
    System.out.println("Quadrat: " + zahl * zahl);
}
```

- `break` beendet die Schleife **sofort**
- Das Programm läuft nach der Schleife weiter
- Nützlich bei "Abbruch bei bestimmter Eingabe"

---

## break: Beispiel

```java
int summe = 0;
while (true) {
    int zahl = scanner.nextInt();
    if (zahl == 0) {
        break;  // Eingabe von 0 beendet die Schleife
    }
    summe += zahl;
}
System.out.println("Summe: " + summe);
```

Der Benutzer gibt Zahlen ein, 0 beendet die Eingabe

---

## continue - Durchlauf überspringen

```java
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) {
        continue;  // Überspringt den Rest des Durchlaufs
    }
    System.out.println(i); // Nur ungerade Zahlen
}
```

- `continue` überspringt den **restlichen** Schleifenkörper
- Der nächste Durchlauf beginnt (bzw. die Bedingung wird neu geprüft)

---

## continue: Beispiel

```java
// Gib alle Zahlen 1..20 aus,
// überspringe aber Zahlen, die durch 3 teilbar sind
int i = 0;
while (i < 20) {
    i++;
    if (i % 3 == 0) {
        continue;
    }
    System.out.print(i + " ");
}
// Ausgabe: 1 2 4 5 7 8 10 11 13 14 16 17 19 20
```

---

## break vs. continue

<div class="highlight-box">
<p><strong>break:</strong> Beendet die gesamte Schleife sofort</p>
<p><strong>continue:</strong> Überspringt nur den aktuellen Durchlauf</p>
</div>

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) break;    // → 1 2
    if (i == 3) continue; // → 1 2 4 5
    System.out.print(i + " ");
}
```

---

## Menübeispiel mit do-while

```java
int auswahl;
do {
    System.out.println("=== MENÜ ===\n1: Option A\n2: Option B\n0: Beenden");
    System.out.print("Auswahl: ");
    auswahl = scanner.nextInt();
    if (auswahl == 1) { /* Option A */ }
    else if (auswahl == 2) { /* Option B */ }
} while (auswahl != 0);
```

Das Menü wird immer mindestens einmal angezeigt

---

## do-while mit break

```java
do {
    System.out.print("Passwort: ");
    String pw = scanner.nextLine();

    if (pw.equals("geheim")) {
        System.out.println("Zugriff gewährt!");
        break;
    }
    System.out.println("Falsches Passwort!");
} while (true);
```

Endlosschleife + break = "Wiederhole, bis richtig"

---

## Katas

<div class="highlight-box">
<p>Löst die folgenden Katas in eurer Entwicklungsumgebung:</p>
<ul>
<li><strong>do-while Grundlagen</strong> – Nutzt do-while für eine Schleife, die mindestens einmal läuft.</li>
<li><strong>break</strong> – Bricht eine Schleife vorzeitig ab.</li>
<li><strong>continue</strong> – Überspringt Durchläufe mit continue.</li>
<li><strong>Menü</strong> – Baut ein interaktives Menü mit do-while.</li>
</ul>
</div>

---

## Zusammenfassung

<div class="highlight-box">
<ul>
<li><code>do-while</code> führt den Körper mindestens einmal aus</li>
<li><code>break</code> beendet die Schleife vorzeitig</li>
<li><code>continue</code> überspringt den aktuellen Durchlauf</li>
<li>do-while ideal für Menüs und Eingabeprüfungen</li>
<li>while: Bedingung vorher prüfen; do-while: Bedingung nachher prüfen</li>
</ul>
</div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Der Dungeon Crawler bekommt ein Kampfmenü in einer do-while-Schleife. Der Spieler und der Gegner haben Lebenspunkte. Bei "Angreifen" verliert der Gegner Schaden, bei "Heilen" erhält der Spieler HP.</p>
</div>
