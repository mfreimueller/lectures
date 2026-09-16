---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 06 - User Input – Scanner, Random
## POS - 1xHIF

---

## Agenda (1/2)

1. Wiederholung: Verzweigung
2. Interaktive Programme
3. Die Scanner-Klasse
4. Scanner: nextLine() für Text

---

## Agenda (2/3)

5. Scanner: nextInt() für Zahlen
6. Zufallszahlen mit Random
7. Random: nextInt(bound)

---

## Agenda (3/3)

8. Vollständiges Beispiel: Zahlenraten
9. Hinweis: Integer.parseInt
10. Häufige Fehler

---

## Lernziele

- Ich kann mit der Scanner-Klasse Benutzereingaben einlesen
- Ich kann mit Random Zufallszahlen erzeugen
- Ich kann Strings mit Integer.parseInt in Zahlen umwandeln
- Ich kann interaktive Programme entwickeln

---

## Wiederholung: Verzweigung

- Verzweigungen mit if, else if, else
- Bisher: Alle Werte fest im Code (hartcodiert)
- Heute: Programme reagieren auf Benutzereingaben!

---

## Partneraktivität: Ein Zahlenratespiel entwerfen

<div class="highlight-box">
<p>Entwerft zu zweit ein einfaches Zahlenratespiel auf Papier. Eine Person denkt sich die Regeln aus, die andere fragt: «Was passiert, wenn der Benutzer … eingibt?» Spielt 2–3 Runden und besprecht Grenzfälle.</p>
</div>

---

## Interaktive Programme

- Bisher: Werte direkt in den Quellcode geschrieben
- Interaktive Programme lesen Eingaben vom Benutzer
- Ablauf: **Eingabe → Verarbeitung → Ausgabe**

<div class="highlight-box">
<p>Eingabe mit <code>Scanner</code>, Ausgabe mit <code>System.out.println</code></p>
</div>

---

## Die Scanner-Klasse

- `Scanner` liest Benutzereingaben von der Tastatur
- Muss importiert werden: `import java.util.Scanner;`
- Erzeugung: `Scanner scanner = new Scanner(System.in);`

```java
import java.util.Scanner;
public class Eingabe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
}
```

---

## Scanner: nextLine() für Text

- `nextLine()` liest eine ganze Textzeile ein
- Gibt einen String zurück

```java
Scanner scanner = new Scanner(System.in);
System.out.print("Wie heisst du? ");
String name = scanner.nextLine();
System.out.println("Hallo, " + name + "!");
```

---

## Scanner: nextInt() für Zahlen

- `nextInt()` liest eine ganze Zahl ein
- Gibt einen int zurück

```java
Scanner scanner = new Scanner(System.in);
System.out.print("Wie alt bist du? ");
int alter = scanner.nextInt();
if (alter >= 18) {
    System.out.println("Du bist volljaehrig.");
}
```

---

## Zufallszahlen mit Random

- Die Klasse `Random` erzeugt Zufallszahlen
- Muss importiert werden: `import java.util.Random;`
- Erzeugung: `Random random = new Random();`

```java
import java.util.Random;
Random random = new Random();
int zahl = random.nextInt(10);       // 0 bis 9
int zahl2 = random.nextInt(10) + 1;  // 1 bis 10
double komma = random.nextDouble();  // 0.0 bis 1.0
```

---

## Random: nextInt(bound)

- `random.nextInt(bound)` → 0 bis bound-1
- Für 1 bis 10: `random.nextInt(10) + 1`
- Für Würfel (1–6): `random.nextInt(6) + 1`

```java
Random random = new Random();
int wuerfel = random.nextInt(6) + 1;
System.out.println("Du hast eine " + wuerfel + " gewuerfelt.");
int muenze = random.nextInt(2);  // 0 oder 1
System.out.println(muenze == 0 ? "Kopf" : "Zahl");
```

---

## Zahlenraten — Setup

```java
import java.util.Scanner;
import java.util.Random;

public class Zahlenraten {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int geheimzahl = random.nextInt(10) + 1;
        System.out.print("Rate eine Zahl (1-10): ");
```

---

## Zahlenraten — Tipp prüfen

```java
        int tipp = scanner.nextInt();
        if (tipp == geheimzahl) {
            System.out.println("Richtig! Du hast gewonnen!");
        } else {
            System.out.println("Falsch. Die Zahl war " + geheimzahl);
        }
    }
}
```

---

## Hinweis: Integer.parseInt

- Manchmal möchte man einen String in eine Zahl umwandeln
- `Integer.parseInt(text)` wandelt "123" in 123 um
- Das Konzept wird später ausführlich behandelt (Thema Convert)

```java
String eingabe = "42";
int zahl = Integer.parseInt(eingabe);
System.out.println(zahl + 1);  // 43 (nicht "421")
```

---

## Häufige Fehler

<div class="highlight-box">
<ul>
<li><strong>Import vergessen:</strong> <code>Scanner</code> und <code>Random</code> müssen importiert werden</li>
<li><strong>nextInt() nach nextLine():</strong> nextInt() lässt oft einen Zeilenumbruch im Puffer — Vorsicht!</li>
<li><strong>Falscher bound:</strong> <code>random.nextInt(10)</code> = 0–9, nicht 1–10</li>
<li><strong>Eingabe-Fehler:</strong> Bei Text auf nextInt() → Programm stürzt ab</li>
</ul>
</div>

---

## Summary

<div class="highlight-box">
<ul>
<li>Scanner liest Benutzereingaben (nextLine, nextInt)</li>
<li>Random erzeugt Zufallszahlen (nextInt, nextDouble)</li>
<li>Importieren nicht vergessen: java.util.Scanner, java.util.Random</li>
<li>Interaktive Programme: Eingabe → Verarbeitung → Ausgabe</li>
<li>Integer.parseInt zum Umwandeln von String in int</li>
</ul>
</div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Der Dungeon Crawler wird interaktiv. Lest den Namen des Spielers ein und generiert einen zufälligen Gegner.</p>
</div>
