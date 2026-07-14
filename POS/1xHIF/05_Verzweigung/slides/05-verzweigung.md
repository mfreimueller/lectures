---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 05 - Verzweigung
## POS - 1xHIF

---

## Agenda (1/2)

1. Wiederholung: Zuweisung und Anweisung
2. Vergleichsoperatoren
3. Die if-Anweisung
4. Der else-Zweig

---

## Agenda (2/2)

5. if-else if-else-Kaskaden
6. Verschachtelte if-Anweisungen
7. Häufiger Fehler: = vs. ==
8. Beispiel: Temperatur
9. Beispiel: Punktestand

---

## Lernziele

- Ich kann Vergleichsoperatoren einsetzen
- Ich kann if-else-Verzweigungen programmieren
- Ich kann if-else-if-Kaskaden und verschachtelte if-Anweisungen anwenden
- Ich kann Zuweisung (=) und Vergleich (==) unterscheiden
- Ich kann praktische Beispiele mit Verzweigungen umsetzen

---

## Wiederholung: Zuweisung und Anweisung

- Ausdruck (Expression) = Code, der einen Wert ergibt
- Anweisung (Statement) = vollständige Handlung mit ;
- Heute: Programme, die Entscheidungen treffen!

---

## Partneraktivität: Entscheidungen programmieren

<div class="highlight-box">
<p>Euer Partner beschreibt eine tägliche Entscheidung (z. B. Was frühstücken? Regenschirm mitnehmen?). Schreibt eine if-else-Anweisung dafür. Wechselt die Rollen und überprüft gegenseitig eure Logik.</p>
</div>

---

## Vergleichsoperatoren

---

## Die if-Anweisung

- Mit `if` führen wir Code nur unter einer Bedingung aus
- Die Bedingung ist ein boolean-Ausdruck

```java
int alter = 17;

if (alter >= 18) {
    System.out.println("Du bist volljaehrig.");
}
```

Was passiert hier? → Nichts, weil 17 < 18 ist.

---

## Der else-Zweig

- Mit `else` legen wir fest, was passiert, wenn die Bedingung falsch ist

```java
int alter = 17;
if (alter >= 18) {
    System.out.println("Du bist volljaehrig.");
} else {
    System.out.println("Du bist noch nicht volljaehrig.");
}
```

---

## if-else if-else-Kaskaden

- Mehrere Bedingungen nacheinander prüfen
- Die erste zutreffende Bedingung wird ausgeführt

```java
int punkte = 85;
if (punkte >= 90) {
    System.out.println("Note 1");
} else if (punkte >= 75) {
    System.out.println("Note 2");
} else { System.out.println("Note 3 oder schlechter"); }
```

---

## Verschachtelte if-Anweisungen

- If-Blöcke können ineinander verschachtelt werden

```java
int alter = 20;
boolean hatFuehrerschein = true;
if (alter >= 18) {
    if (hatFuehrerschein) { System.out.println("Du darfst Auto fahren."); }
    else { System.out.println("Du darfst noch nicht fahren."); }
} else { System.out.println("Du bist noch nicht volljaehrig."); }
```

---

## Häufiger Fehler: = vs. ==

<div class="highlight-box">
<p><strong>Achtung!</strong></p>
<ul>
<li><code>if (x = 5)</code> → Compiler-Fehler! (x = 5 ist eine Zuweisung, kein Vergleich)</li>
<li>Richtig: <code>if (x == 5)</code> → prüft, ob x gleich 5 ist</li>
<li>Bei <code>boolean</code>-Variablen: <code>if (istWahr)</code> nicht <code>if (istWahr == true)</code></li>
</ul>
</div>

---

## Beispiel: Temperatur

```java
public class Temperatur {
    public static void main(String[] args) {
        int temperatur = 35;

        if (temperatur > 30) {
            System.out.println("Es ist heiss!");
        } else if (temperatur > 20) {
            System.out.println("Es ist warm.");
        } else if (temperatur > 10) {
            System.out.println("Es ist mild.");
        } else {
            System.out.println("Es ist kalt.");
        }
    }
}
```

---

## Beispiel: Punktestand

```java
public class Punktestand {
    public static void main(String[] args) {
        int punkte = 75;

        if (punkte >= 100) {
            System.out.println("Herzlichen Glueckwunsch!");
            System.out.println("Du hast die Hoechstpunktzahl erreicht.");
        } else if (punkte >= 50) {
            System.out.println("Gut gemacht!");
            System.out.println("Du hast mehr als die Haelfte erreicht.");
        } else {
            System.out.println("Weiter ueben!");
            System.out.println("Du hast weniger als die Haelfte erreicht.");
        }
    }
}
```

---

## Katas

<div class="highlight-box">
<p>Löst die folgenden Katas in eurer Entwicklungsumgebung:</p>
<ul>
<li><strong>Positiv, negativ oder null</strong> – Prüft mit if-else, ob eine Zahl positiv, negativ oder null ist.</li>
<li><strong>Notenstufen</strong> – Übersetzt Punktzahlen in Notenstufen.</li>
<li><strong>Schaltjahr</strong> – Prüft, ob ein Jahr ein Schaltjahr ist.</li>
<li><strong>Drei Zahlen vergleichen</strong> – Findet die grösste von drei Zahlen.</li>
</ul>
</div>

---

## Summary

<div class="highlight-box">
<ul>
<li>Vergleichsoperatoren: &lt;, &gt;, &lt;=, &gt;=, ==, !=</li>
<li>if-Bedingung: Code wird nur ausgeführt, wenn die Bedingung true ist</li>
<li>else-Zweig: Code für den Fall, dass die Bedingung false ist</li>
<li>if-else if-else: mehrere Bedingungen nacheinander prüfen</li>
<li>= ist Zuweisung, == ist Vergleich — nicht verwechseln!</li>
</ul>
</div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Der Dungeon Crawler bekommt erste Spiellogik. Setzt drei Szenarien mit Verzweigungen um: Lebenspunkte-Prüfung, Gegner besiegt, Schlüssel gefunden.</p>
</div>
