# Jahresprojekt — Dungeon Crawler: Interaktiver Start

Der Dungeon Crawler wird interaktiv. Lese den Namen des Spielers ein und generiere einen zufälligen Gegner.

### Aufgaben

1. Lese den Namen des Spielers mit Scanner ein.
2. Generiere einen zufälligen Gegner:
   - Wähle einen zufälligen Namen aus einer Liste (z. B. "Ork", "Goblin", "Troll", "Spinne", "Skelett")
   - Gib dem Gegner zufällige Lebenspunkte (20–50)
3. Gib Spieler und Gegner aus.

### Beispiel

```java
import java.util.Scanner;
import java.util.Random;

public class DungeonCrawler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Gib deinen Heldennamen ein: ");
        String spielerName = scanner.nextLine();

        String[] gegnerNamen = {"Ork", "Goblin", "Troll", "Spinne", "Skelett"};
        int index = random.nextInt(gegnerNamen.length);
        String gegnerName = gegnerNamen[index];
        int gegnerHP = random.nextInt(31) + 20;

        System.out.println();
        System.out.println("=== Dungeon Crawler ===");
        System.out.println("Spieler: " + spielerName);
        System.out.println();
        System.out.println("Ein " + gegnerName + " erscheint!");
        System.out.println(gegnerName + " HP: " + gegnerHP);
    }
}
```

### Erweiterung

Gib dem Spieler auch zufällige Start-Lebenspunkte (80–120) und vergleiche die Werte mit dem Gegner.
