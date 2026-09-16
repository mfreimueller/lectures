---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 16 - Übung: REPL
## POS - 1xHIF

---

## Agenda

1. Was ist eine REPL?
2. Read-Eval-Print-Loop
3. REPL-Struktur in Code
4. Beispiel: Echo-REPL
5. REPL im Dungeon Crawler

---

## Lernziele

- Ich kann erklären, was eine REPL ist und wofür sie verwendet wird
- Ich kann die vier Schritte Read-Eval-Print-Loop beschreiben
- Ich kann eine REPL in Java umsetzen

---

## Partnerdiskussion: REPL im Alltag

<div class="highlight-box">
<p>Denkt an einen Chatbot oder eine Sprachassistentin (Siri, Alexa). Wie funktioniert deren Hauptschleife? Welche Schritte sind «Read», «Eval» und «Print» in diesem Kontext? Diskutiert die Parallelen zu einer REPL.</p>
</div>

---

## REPL — Die Schritte (1/2)

- **R**ead — Eingabe lesen
- **E**val — Eingabe verarbeiten
- **P**rint — Ergebnis ausgeben

---

## REPL — Loop und Beispiele (2/2)

- **L**oop — Wiederholen
- Eine REPL ist ein interaktiver Befehlsinterpreter
- Bekannte Beispiele: Python-REPL, Node.js-REPL, die Konsole in Minecraft

---

## Read-Eval-Print-Loop

<div class="highlight-box">
<pre style="font-size: 1.2em;">while (running) {
    eingabe = lesen();     // Read
    ergebnis = eval(eingabe); // Eval
    ausgeben(ergebnis);    // Print
}                          // Loop</pre>
</div>

---

## REPL-Struktur in Code

```java
boolean running = true;
while (running) {
    System.out.print("> ");
    String eingabe = scanner.nextLine();
    String[] teile = eingabe.split(" ", 2);
    String befehl = teile[0].toLowerCase();
    switch (befehl) {
        case "echo":
            System.out.println(teile[1]);
            break;
        case "exit":
            running = false;
            break;
        default:
            System.out.println("Unbekannt");
            break;
    }
}
```

---

## Beispiel: Echo-REPL

```java
import java.util.Scanner;
public class EchoRepl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("> ");
            String eingabe = scanner.nextLine();
            if (eingabe.equals("exit")) {
                running = false;
            } else {
                System.out.println(eingabe);
            }
        }
        System.out.println("Programm beendet.");
        scanner.close();
    }
}
```

---

## REPL im Dungeon Crawler

- Der Dungeon Crawler wird auf REPL umgestellt
- Befehle: hilfe, status, gehe, kämpfe, inventar, quit
- Die Befehlsauswertung erfolgt mit switch auf dem ersten Wort
- So wird das Spiel viel flexibler und erweiterbarer

<div class="highlight-box">
<p>Heute: Katas + Exercise — baut eure eigene REPL!</p>
</div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Stelle den Dungeon Crawler auf eine REPL-Architektur um.</p>
</div>
