---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 03 - Operatoren
## POS - 1xHIF

---

## Agenda (1/2)

1. Wiederholung: Datentypen
2. Der Plus-Operator (+)
3. Der Minus-Operator (-)
4. Der Mal-Operator (*)

---

## Agenda (2/3)

5. Der Geteilt-Operator (/)
6. Ganzzahl- vs. Gleitkommadivision
7. Punkt-vor-Strich-Regel

---

## Agenda (3/3)

8. Berechnungen mit Variablen
9. Beispiel: Fläche eines Rechtecks
10. Häufige Fehler

---

## Lernziele

- Ich kann arithmetische Operatoren korrekt anwenden
- Ich kann Ganzzahl- und Gleitkommadivision unterscheiden
- Ich kann Berechnungen mit Variablen durchführen
- Ich kann die Punkt-vor-Strich-Regel beachten
- Ich kann typische Fehler bei Operatoren vermeiden

---

## Wiederholung: Datentypen

- Variablen speichern Daten eines bestimmten Typs
- int für ganze Zahlen, double für Kommazahlen
- Heute lernen wir: Wie rechnet man mit diesen Werten?

---

## Partnerdiskussion: Ganzzahl- vs. Gleitkommadivision

<div class="highlight-box">
<p>Was ergibt <code>3 / 2</code> in Java? Was ergibt <code>3.0 / 2</code>? Diskutiert mit eurem Partner, warum die Ergebnisse unterschiedlich sind. Findet ein Beispiel aus dem Alltag, bei dem dieser Unterschied eine Rolle spielt.</p>
</div>

---

## Der Plus-Operator (+)

- Addiert zwei Zahlen
- Kann auch Texte verbinden (String-Konkatenation)

```java
int summe = 5 + 3;
System.out.println(summe);  // 8

String text = "Hallo " + "Welt";
System.out.println(text);   // Hallo Welt
```

---

## Der Minus-Operator (-)

- Subtrahiert zwei Zahlen
- Kann auch als Vorzeichen verwendet werden

```java
int differenz = 10 - 3;
System.out.println(differenz);  // 7

int negativ = -5;
System.out.println(negativ);    // -5
```

---

## Der Mal-Operator (*)

- Multipliziert zwei Zahlen

```java
int produkt = 4 * 6;
System.out.println(produkt);  // 24

double flaeche = 2.5 * 3.0;
System.out.println(flaeche);  // 7.5
```

---

## Der Geteilt-Operator (/)

- Dividiert zwei Zahlen
- Achtung: Das Ergebnis hängt vom Datentyp ab!

```java
int a = 5 / 2;
System.out.println(a);  // 2 (nicht 2.5!)

double b = 5.0 / 2.0;
System.out.println(b);  // 2.5
```

---

## Ganzzahl- vs. Gleitkommadivision

<div class="highlight-box">
<p><strong>Wichtig:</strong> Wenn beide Zahlen <code>int</code> sind, wird <strong>ganzzahlig</strong> dividiert!</p>
</div>

```java
int ergebnis1 = 7 / 3;     // 2 (Nachkommastellen fallen weg)
double ergebnis2 = 7 / 3;   // 2.0 (immer noch int-Division!)
double ergebnis3 = 7.0 / 3; // 2.333... (double-Division)
```

---

## Punkt-vor-Strich-Regel

- Auch in Java gilt: Punktrechnung vor Strichrechnung
- Klammern verändern die Reihenfolge

```java
int a = 3 + 4 * 2;     // 11 (weil 4*2=8, dann +3)
int b = (3 + 4) * 2;   // 14 (weil 3+4=7, dann *2)
int c = 10 - 2 * 3;    // 4  (weil 2*3=6, dann 10-6)
```

---

## Berechnungen mit Variablen

- Variablen können in Berechnungen verwendet werden
- Das Ergebnis kann in einer neuen Variable gespeichert werden

```java
int preis = 19, anzahl = 3;
int gesamt = preis * anzahl;
System.out.println("Gesamtpreis: " + gesamt);
double laenge = 5.5, breite = 3.2;
double flaeche = laenge * breite;
System.out.println("Flaeche: " + flaeche);
```

---

## Beispiel: Fläche eines Rechtecks

```java
public class Rechteck {
    public static void main(String[] args) {
        double laenge = 8.5;
        double breite = 4.2;

        double flaeche = laenge * breite;
        double umfang = 2 * (laenge + breite);

        System.out.println("Laenge: " + laenge);
        System.out.println("Breite: " + breite);
        System.out.println("Flaeche: " + flaeche);
        System.out.println("Umfang: " + umfang);
    }
}
```

---

## Häufige Fehler

<div class="highlight-box">
<ul>
<li><strong>Division vergessen:</strong> <code>5 / 2</code> ergibt 2, nicht 2.5!</li>
<li><strong>Division durch 0:</strong> Führt zu einem Laufzeitfehler (ArithmeticException)</li>
<li><strong>Falsche Klammerung:</strong> <code>3 + 4 * 2</code> ist nicht dasselbe wie <code>(3 + 4) * 2</code></li>
<li><strong>Typkonflikt:</strong> Ein <code>int</code>-Ergebnis in einer <code>double</code>-Variable speichern (Nachkommastellen gehen verloren)</li>
</ul>
</div>

---

## Summary

<div class="highlight-box">
<ul>
<li>Arithmetische Operatoren: +, -, *, /</li>
<li>Ganzzahldivision: int / int = int (Nachkommastellen fallen weg)</li>
<li>Gleitkommadivision: double / double = double</li>
<li>Punkt-vor-Strich-Regel, Klammern für abweichende Reihenfolge</li>
<li>Variablen können in Berechnungen kombiniert werden</li>
</ul>
</div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Der Spieler soll Schaden berechnen können. Legt Variablen für die Angriffskraft des Spielers und die Rüstung des Gegners an und berechnet den effektiven Schaden.</p>
</div>
