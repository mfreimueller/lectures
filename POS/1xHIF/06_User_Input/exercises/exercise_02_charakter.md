# Große Übung: Charakter-Erstellung

Der Benutzer erstellt einen Spieler-Charakter durch Eingaben. Eigenschaften werden teils eingegeben, teils zufällig gewürfelt.

### Anforderungen

1. Frage den Benutzer nach dem Namen des Charakters (String).
2. Frage nach der Klasse (String: Krieger, Magier oder Schurke).
3. Würfle die Werte für Stärke, Geschicklichkeit und Intelligenz jeweils mit Random (1–10).
4. Bestimme zufällig eine Startausrüstung:
   - Krieger: "Schwert +3", "Streitaxt" oder "Schild +2"
   - Magier: "Zauberstab", "Magierbuch" oder "Amulett"
   - Schurke: "Dolch", "Bogen" oder "Giftflasche"
5. Gib den fertigen Charakter mit allen Werten aus.

### Beispiel

```java
import java.util.Scanner;
import java.util.Random;

public class CharakterErstellung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== Charakter-Erstellung ===");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Klasse (Krieger, Magier, Schurke): ");
        String klasse = scanner.nextLine();

        int staerke = random.nextInt(10) + 1;
        int geschicklichkeit = random.nextInt(10) + 1;
        int intelligenz = random.nextInt(10) + 1;

        String ausruestung;
        if (klasse.equals("Krieger")) {
            int wahl = random.nextInt(3);
            if (wahl == 0) ausruestung = "Schwert +3";
            else if (wahl == 1) ausruestung = "Streitaxt";
            else ausruestung = "Schild +2";
        } else if (klasse.equals("Magier")) {
            int wahl = random.nextInt(3);
            if (wahl == 0) ausruestung = "Zauberstab";
            else if (wahl == 1) ausruestung = "Magierbuch";
            else ausruestung = "Amulett";
        } else if (klasse.equals("Schurke")) {
            int wahl = random.nextInt(3);
            if (wahl == 0) ausruestung = "Dolch";
            else if (wahl == 1) ausruestung = "Bogen";
            else ausruestung = "Giftflasche";
        } else {
            ausruestung = "Keine";
        }

        System.out.println();
        System.out.println("=== Charakter-Profil ===");
        System.out.println("Name: " + name);
        System.out.println("Klasse: " + klasse);
        System.out.println("Staerke: " + staerke);
        System.out.println("Geschicklichkeit: " + geschicklichkeit);
        System.out.println("Intelligenz: " + intelligenz);
        System.out.println("Ausrüstung: " + ausruestung);
    }
}
```

### Erweiterung

Gib zusätzlich aus, ob der Charakter für seine Klasse gut geeignet ist (z. B. Krieger mit Stärke > 7 ist optimal).
