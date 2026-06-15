# Exercise: Quiz-Spiel

Schreibe ein Quiz mit drei Fragen. Der Benutzer gibt die Antwort ein. Nach jeder Frage wird gesagt, ob die Antwort richtig oder falsch war. Am Ende wird die Anzahl der richtigen Antworten ausgegeben.

### Anforderungen

1. Stelle drei Wissensfragen (z. B. Hauptstädte, Mathematik, Allgemeinwissen).
2. Der Benutzer gibt die Antwort als Text ein.
3. Prüfe die Antwort mit if (verwende String.equals() für Text-Vergleiche).
4. Zähle die richtigen Antworten.
5. Gib am Ende die Gesamtpunktzahl aus.

### Beispiel

```java
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int punkte = 0;

        System.out.println("=== Quiz ===");

        System.out.print("Frage 1: Was ist die Hauptstadt von Oesterreich? ");
        String antwort1 = scanner.nextLine();
        if (antwort1.equals("Wien")) {
            System.out.println("Richtig!");
            punkte++;
        } else {
            System.out.println("Falsch. Richtig waere Wien.");
        }

        System.out.print("Frage 2: Wie viel ist 7 * 8? ");
        String antwort2 = scanner.nextLine();
        if (antwort2.equals("56")) {
            System.out.println("Richtig!");
            punkte++;
        } else {
            System.out.println("Falsch. Richtig waere 56.");
        }

        System.out.print("Frage 3: In welchem Jahr begann der 2. Weltkrieg? ");
        String antwort3 = scanner.nextLine();
        if (antwort3.equals("1939")) {
            System.out.println("Richtig!");
            punkte++;
        } else {
            System.out.println("Falsch. Richtig waere 1939.");
        }

        System.out.println();
        System.out.println("Du hast " + punkte + " von 3 Fragen richtig beantwortet.");
    }
}
```

### Erweiterung

Füge eine vierte Frage hinzu, die eine Zahl erwartet und verwende nextInt() statt nextLine().
