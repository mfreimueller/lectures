---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 04 - Zuweisung, Anweisung
## POS - 1xHIF

---

## Agenda (1/2)

1. Wiederholung: Operatoren
2. Ausdruck (Expression)
3. Anweisung (Statement)
4. Zuweisung als Ausdruck

---

## Agenda (2/2)

5. Werte überschreiben
6. Zusammengesetzte Zuweisungen
7. Beispiel: Zusammengesetzte Zuweisungen
8. Zuweisung vs. Vergleich
9. Praktisches Beispiel: Kontostand

---

## Lernziele

- Ich kann Ausdrücke (Expressions) und Anweisungen (Statements) unterscheiden
- Ich kann Zuweisungen als Ausdruck verstehen
- Ich kann zusammengesetzte Zuweisungen verwenden
- Ich kann Zuweisung und Vergleich auseinanderhalten

---

## Wiederholung: Operatoren

- Arithmetische Operatoren: +, -, *, /
- Berechnungen mit Variablen
- Heute: Was ist der Unterschied zwischen einer Zuweisung und einer Anweisung?

---

## Partnerdiskussion: = vs. ==

<div class="highlight-box">
<p>Lest diese beiden Zeilen laut vor: <code>x = 5</code> und <code>x == 5</code>. Hören sie sich gleich an? Warum ist die Verwechslung einer der häufigsten Programmierfehler? Welche Konsequenzen kann das haben?</p>
</div>

---

## Ausdruck (Expression)

- Ein Ausdruck ist ein Code-Stück, das einen Wert ergibt
- Beispiele: `5`, `3 + 4`, `x * 2`
- Jeder Ausdruck hat einen Wert und einen Typ

```java
3 + 4           // Ausdruck, Wert: 7, Typ: int
"Hallo" + "!"   // Ausdruck, Wert: "Hallo!", Typ: String
x > 5           // Ausdruck, Wert: true/false, Typ: boolean
```

---

## Anweisung (Statement)

- Eine Anweisung ist eine vollständige Handlung im Programm
- Endet immer mit Semikolon `;`
- Beispiele: Deklaration, Zuweisung, Ausgabe

```java
int x;                      // Deklarations-Anweisung
x = 5;                      // Zuweisungs-Anweisung
System.out.println(x);      // Ausgabe-Anweisung
int y = 3 + 4;              // Deklaration + Zuweisung (Anweisung)
```

---

## Zuweisung als Ausdruck

- Eine Zuweisung `x = wert` ist selbst ein Ausdruck!
- Der Wert einer Zuweisung ist der zugewiesene Wert
- Erst mit dem Semikolon wird daraus eine Anweisung

```java
int x;
int y;
y = (x = 5);    // x = 5 ist ein Ausdruck mit Wert 5
System.out.println(x);  // 5
System.out.println(y);  // 5
```

---

## Werte überschreiben

- Eine Variable kann mehrfach einen neuen Wert bekommen
- Der alte Wert wird überschrieben und ist verloren

```java
int x = 10;
System.out.println(x);  // 10
x = 20;
System.out.println(x);  // 20
x = x + 5;
System.out.println(x);  // 25
```

---

## Zusammengesetzte Zuweisungen

- Kurzschreibweisen für "Variable = Variable Operator Wert"

| Operator | Bedeutung | Beispiel | Ergebnis (x startet bei 10) |
| --- | --- | --- | --- |
| `+=` | Addition | `x += 5` | 15 |
| `-=` | Subtraktion | `x -= 3` | 7 |
| `*=` | Multiplikation | `x *= 2` | 20 |
| `/=` | Division | `x /= 4` | 2 |

---

## Beispiel: Zusammengesetzte Zuweisungen

```java
int punkte = 100;
System.out.println("Start: " + punkte);     // 100

punkte += 50;   // punkte = punkte + 50
System.out.println("Nach +50: " + punkte);  // 150

punkte -= 30;   // punkte = punkte - 30
System.out.println("Nach -30: " + punkte);  // 120

punkte *= 2;    // punkte = punkte * 2
System.out.println("Nach *2: " + punkte);   // 240

punkte /= 3;    // punkte = punkte / 3
System.out.println("Nach /3: " + punkte);   // 80
```

---

## Zuweisung vs. Vergleich

<div class="highlight-box">
<p><strong>Achtung Verwechslungsgefahr!</strong></p>
<ul>
<li><code>=</code> ist die <strong>Zuweisung</strong> (weist einen Wert zu)</li>
<li><code>==</code> ist der <strong>Vergleich</strong> (prüft auf Gleichheit)</li>
<li>Beides zu verwechseln ist einer der häufigsten Anfängerfehler!</li>
</ul>
</div>

```java
int x = 5;      // Zuweisung: x bekommt den Wert 5
boolean istGleich = (x == 5);  // Vergleich: ist x gleich 5? → true
```

---

## Praktisches Beispiel: Kontostand

```java
public class Konto {
    public static void main(String[] args) {
        double kontostand = 1000.0;
        System.out.println("Start: " + kontostand + " EUR");

        kontostand += 250.0;    // Einzahlung
        System.out.println("Nach Einzahlung: " + kontostand + " EUR");

        kontostand -= 80.0;     // Auszahlung
        System.out.println("Nach Auszahlung: " + kontostand + " EUR");

        kontostand *= 1.02;     // 2% Zinsen
        System.out.println("Nach Zinsen: " + kontostand + " EUR");
    }
}
```

---

## Summary

<div class="highlight-box">
<ul>
<li>Ausdruck (Expression): Code, der einen Wert ergibt</li>
<li>Anweisung (Statement): vollständige Handlung, endet mit ;</li>
<li>Zuweisung = Ausdruck + Semikolon = Anweisung</li>
<li>Zusammengesetzte Zuweisungen: +=, -=, *=, /=</li>
<li>= vs. ==: Zuweisung vs. Vergleich</li>
</ul>
</div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Der Spieler hat jetzt Lebenspunkte, die sich im Kampf ändern. Simuliert eine Kampfrunde mit zusammengesetzten Zuweisungen.</p>
</div>
