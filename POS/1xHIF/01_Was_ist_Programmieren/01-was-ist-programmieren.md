---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 01 - Was ist Programmieren?
## POS - 1xHIF

---

## Agenda (1/2)

1. Was ist ein Programm?
2. Programmiersprachen im Überblick
3. Vorteile verschiedener Sprachen
4. Kompiliert vs. interpretiert

---

## Agenda (2/3)

5. Java - Das Beste aus beiden Welten?
6. Die Java Virtual Machine (JVM)
7. Java Compiler und JVM
8. Computational Thinking

---

## Agenda (3/3)

9. Algorithmus - Beispiel "Kaffee kochen"
10. Flowchart - Ablauf visualisieren
11. Leitfrage der Stunde

---

## Lernziele

- Ich kann erklären, was ein Programm ist und wie es abläuft
- Ich kann verschiedene Programmiersprachen vergleichen
- Ich kann die Java-Plattform (Compiler + JVM) beschreiben
- Ich kann Algorithmen entwickeln und mit Flowcharts visualisieren
- Ich kann Computational Thinking als Problemlösungsmethode anwenden

---

## Was ist ein Programm?

- Ein Programm ist eine Folge von Anweisungen an den Computer
- Diese Anweisungen werden in einer Programmiersprache geschrieben
- Beispiele aus dem Alltag: Browser, Texteditor, Spiele, Navigations-App
- Ein Computer tut nichts ohne ein Programm

---

## Partneraktivität: Algorithmen im Alltag

<div class="highlight-box">
<p>Denkt an eine alltägliche Aufgabe (Zähne putzen, Brot schmieren, …). Schreibt die Schritte als Algorithmus auf. Tauscht mit eurem Partner und prüft: Fehlen Schritte? Ist ein Schritt mehrdeutig?</p>
</div>

---

## Programmiersprachen im Überblick

- Es gibt hunderte Programmiersprachen
- Jede hat ihre Stärken und Einsatzgebiete
- Beispiele: Java, Python, C++, JavaScript, Kotlin, Swift
- Frage: Warum nicht einfach alle in einer Sprache schreiben?

---

## Vorteile verschiedener Sprachen

- Python -- einfach zu lernen, gut für Datenanalyse
- C / C++ -- schnell, hardwarenah (Spiele, Betriebssysteme)
- JavaScript -- läuft im Browser, Webentwicklung
- Java -- plattformunabhängig, grosses Ökosystem
- Kotlin -- moderne Alternative zu Java (Android)

---

## Kompiliert

- **Kompiliert:** Quellcode wird in Maschinencode uebersetzt
- Beispiele: C, C++, Rust -- am Ende steht eine ausführbare Datei

---

## Interpretiert

- **Interpretiert:** Quellcode wird Zeile für Zeile ausgeführt
- Beispiele: Python, JavaScript -- kein separater Übersetzungsschritt
- Vorteil kompiliert: schneller, Fehler früher erkannt
- Vorteil interpretiert: flexibler, einfacher zu testen

---

## Java - Das Beste aus beiden Welten?

- Java ist **keine** rein kompilierte Sprache
- Java ist **keine** rein interpretierte Sprache
- Java kombiniert beide Ansätze

---

## Die Java Virtual Machine (JVM)

- Java-Quellcode (.java) wird zu Bytecode (.class) kompiliert
- Die JVM führt den Bytecode aus (interpretiert ihn)
- Die JVM ist selbst ein Programm -- eine "virtuelle Maschine"
- "Write once, run anywhere" -- einmal kompiliert, überall lauffähig

---

## Java Compiler und JVM

```java
// Quellcode: Hallo.java
public class Hallo {
    public static void main(String[] args) {
        System.out.println("Hallo Welt!");
    }
}
```

```
// Kompilieren mit javac:
// javac Hallo.java -> erzeugt Hallo.class

// Ausführen mit JVM:
// java Hallo -> gibt "Hallo Welt!" aus
```

---

## Computational Thinking

- Problemlösen mit den Methoden der Informatik
- **Dekomposition:** Problem in Teilprobleme zerlegen
- **Mustererkennung:** Ähnlichkeiten zu bekannten Problemen finden
- **Abstraktion:** Wesentliches vom Unwesentlichen trennen
- **Algorithmen:** Schritte zur Lösung formulieren

---

## Algorithmus — Vorbereitung (1/2)

1. Wasser in die Kanne füllen
2. Wasser in den Tank gießen
3. Filtertüte einlegen und Kaffeepulver einfüllen
4. Kaffeemaschine einschalten

---

## Algorithmus — Entscheidung (2/2)

5. Warten, bis der Kaffee durchgelaufen ist
6. Kaffee in die Tasse giessen
7. Entscheidung: Ist genug Kaffee da? --> Ja: Trinken / Nein: Wiederholen

---

## Flowchart - Ablauf visualisieren

- Ein Flowchart (Flussdiagramm) visualisiert einen Algorithmus
- **Rechteck:** Aktion / Schritt
- **Raute:** Entscheidung (ja/nein)
- **Pfeil:** Ablaufrichtung
- Ideal, um Logik zu planen, bevor man Code schreibt

---

## Leitfrage der Stunde

<div class="highlight-box">
<p>"Was machen wir, wenn wir programmieren?"</p>
<ul>
<li>Wir überlegen: Was soll das Programm tun?</li>
<li>Wir zerlegen das Problem in Schritte</li>
<li>Wir schreiben diese Schritte als Code</li>
<li>Wir testen, ob das Programm richtig arbeitet</li>
<li>Wir verbessern und wiederholen</li>
</ul>
</div>

---

## Summary

<div class="highlight-box">
<ul>
<li>Programme sind Anweisungen an den Computer</li>
<li>Verschiedene Sprachen fuer verschiedene Zwecke</li>
<li>Java: Compiliert + interpretiert, plattformunabhängig</li>
<li>Computational Thinking hilft beim Problemloesen</li>
<li>Flowcharts visualisieren Algorithmen</li>
</ul>
</div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Herzlich Willkommen zum Jahresprojekt! In diesem Schuljahr entwickeln wir Woche für Woche einen textbasierten Dungeon Crawler. Diese Woche lest ihr die Spielbeschreibung und zeichnet einen Flowchart zum groben Ablauf.</p>
</div>
