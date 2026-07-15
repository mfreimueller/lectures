---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 23 - Dateioperationen
## POS - 1xHIF

---

## Agenda (1/2)

1. Das Problem: Daten verschwinden
2. Datei lesen mit FileReader
3. BufferedReader - zeilenweise lesen
4. Datei schreiben mit FileWriter

---

## Agenda (2/3)

5. PrintWriter - bequemes Schreiben
6. Problem: Ressourcen-Leaks
7. try-with-resources

---

## Agenda (3/3)

8. try-with-resources für Schreiben
9. IOException behandeln
10. Relative vs. absolute Pfade
11. Häufige Fehler

---

## Lernziele

- Ich kann Dateien in Java einlesen und schreiben
- Ich kann mit BufferedReader und FileWriter arbeiten
- Ich kann Ausnahmen bei Dateioperationen behandeln

---

## Das Problem: Daten verschwinden

<div class="highlight-box"><p>Nach dem Programmende sind alle Daten im RAM weg!</p></div>

Lösung: Daten in Dateien speichern (dauerhafte Speicherung).

- Benutzereinstellungen speichern
- Spielstände sichern
- Daten zwischen Programmläufen erhalten

---

## Partnerdiskussion: Was passiert bei einem Absturz?

<div class="highlight-box">
<p>Was passiert, wenn euer Programm mitten beim Schreiben einer Datei abstürzt? Diskutiert: Ist die Datei halb geschrieben, leer oder beschädigt? Warum ist try-with-resources gerade bei Dateioperationen so wichtig?</p>
</div>

---

## Datei lesen mit FileReader

```java
import java.io.*;
public class DateiLesen {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(reader);
            String zeile = br.readLine();
            while (zeile != null) {
                System.out.println(zeile);
                zeile = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen: " + e.getMessage());
        }
    }
}
```

---

## BufferedReader - zeilenweise lesen

`BufferedReader` puffert das Lesen und bietet `readLine()`.

```java
FileReader fr = new FileReader("datei.txt");
BufferedReader br = new BufferedReader(fr);

String line = br.readLine();  // null am Ende
while (line != null) {
    System.out.println(line);
    line = br.readLine();
}

br.close();  // Wichtig: Ressource freigeben!
```

Der `FileReader` liest Zeichen, `BufferedReader` macht es effizient.

---

## Datei schreiben mit FileWriter

```java
import java.io.*;

public class DateiSchreiben {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("ausgabe.txt");
            PrintWriter pw = new PrintWriter(writer);

            pw.println("Erste Zeile");
            pw.println("Zweite Zeile");
            pw.printf("Zahl: %d%n", 42);

            pw.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben: " + e.getMessage());
        }
    }
}
```

---

## PrintWriter - bequemes Schreiben

`PrintWriter` bietet `println()`, `print()` und `printf()`.

```java
FileWriter fw = new FileWriter("datei.txt");
PrintWriter pw = new PrintWriter(fw);

pw.println("Text mit Zeilenumbruch");
pw.print("Text ohne Umbruch");
pw.printf("Name: %s, Alter: %d%n", "Anna", 25);

pw.close();

// Anhängen statt Überschreiben:
FileWriter fwAppend = new FileWriter("datei.txt", true);
PrintWriter pwAppend = new PrintWriter(fwAppend);
```

---

## Problem: Ressourcen-Leaks

```java
BufferedReader br = new BufferedReader(new FileReader("test.txt"));
String line = br.readLine();
// Was passiert bei einer Exception hier?
br.close();  // Wird nie erreicht!
```

<div class="highlight-box"><p>Die Datei bleibt offen — Ressourcen-Leak!</p></div>

---

## try-with-resources

Seit Java 7: Ressourcen werden automatisch geschlossen.

```java
try (BufferedReader br = new BufferedReader(
        new FileReader("test.txt"))) {

    String line = br.readLine();
    while (line != null) {
        System.out.println(line);
        line = br.readLine();
    }

} catch (IOException e) {
    System.out.println("Fehler: " + e.getMessage());
}
// br wird automatisch geschlossen!
```

Die Ressource wird im try-Block deklariert und automatisch am Ende geschlossen.

---

## try-with-resources für Schreiben

```java
try (PrintWriter pw = new PrintWriter(
        new FileWriter("ausgabe.txt"))) {

    pw.println("Zeile 1");
    pw.println("Zeile 2");

} catch (IOException e) {
    System.out.println("Fehler: " + e.getMessage());
}
// pw und FileWriter werden automatisch geschlossen!
```

Mehrere Ressourcen möglich:

```java
try (BufferedReader br = new BufferedReader(
        new FileReader("a.txt"));
     PrintWriter pw = new PrintWriter(
        new FileWriter("b.txt"))) {
    // ...
}
```

---

## IOException behandeln

Dateizugriffe können fehlschlagen — immer try-catch verwenden!

```java
try (BufferedReader br = new BufferedReader(
        new FileReader("nicht_da.txt"))) {
    // ...
} catch (FileNotFoundException e) {
    System.out.println("Datei nicht gefunden!");
} catch (IOException e) {
    System.out.println("Allgemeiner Fehler: " + e.getMessage());
}
```

`FileNotFoundException` ist ein Untertyp von `IOException`.

---

## Relative vs. absolute Pfade

| Typ | Beispiel |
| --- | --- |
| Relativ | `"test.txt"` |
| Relativ | `"data/input.txt"` |
| Absolut | `"/Users/name/test.txt"` |
| Absolut Windows | `"C:\\Users\\name\\test.txt"` |

Relative Pfade beziehen sich auf das Arbeitsverzeichnis (Projektordner in der IDE).

---

## Häufige Fehler

- **Datei nicht gefunden:** Falscher Pfad, Datei existiert nicht
- **Zugriffsverweigerung:** Datei ist schreibgeschützt
- **Datei geöffnet:** Von einem anderen Programm gesperrt
- **Encoding:** UTF-8 vs. Windows-1252 (Umlaute!)

---

## Katas

<div class="highlight-box">
<p>Löst die folgenden Katas in eurer Entwicklungsumgebung:</p>
<ul>
<li><strong>Textdatei lesen</strong> – Liest Text aus einer Datei.</li>
<li><strong>Text in Datei schreiben</strong> – Schreibt Text in eine Datei.</li>
<li><strong>Datei kopieren</strong> – Kopiert eine Datei.</li>
</ul>
</div>

---

## Zusammenfassung

- `FileReader` + `BufferedReader` = Dateien lesen
- `FileWriter` + `PrintWriter` = Dateien schreiben
- **try-with-resources** = automatisches Schließen
- Immer `IOException` mit try-catch behandeln
- Relative Pfade beziehen sich auf das Arbeitsverzeichnis

---

## Übungen

- **Exercise:** Notizblock (Menü-gesteuert)

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Der Dungeon Crawler erhält eine Speicherfunktion für Spielstände.</p>
</div>
