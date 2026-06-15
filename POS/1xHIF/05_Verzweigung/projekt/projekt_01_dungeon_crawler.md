# Jahresprojekt — Dungeon Crawler: Spiellogik mit Verzweigungen

Der Dungeon Crawler bekommt erste Spiellogik. Setze drei Szenarien mit Verzweigungen um.

### Aufgaben

1. **Lebenspunkte-Prüfung:** Wenn der Spieler genügend Lebenspunkte hat (> 0), kann er weiterkämpfen. Sonst ist das Spiel vorbei.
2. **Gegner besiegt:** Wenn ein Gegner besiegt ist (HP <= 0), erhält der Spieler Erfahrung (EP += 10). Sonst nicht.
3. **Schlüssel gefunden:** Wenn der Spieler einen Schlüssel gefunden hat (boolean), kann er eine Tür öffnen. Sonst bleibt die Tür verschlossen.

### Beispiel

```java
public class DungeonCrawlerLogic {
    public static void main(String[] args) {
        int spielerHP = 50;
        int gegnerHP = 0;
        boolean hatSchluessel = true;

        // Szenario 1: Lebenspunkte-Prüfung
        if (spielerHP > 0) {
            System.out.println("Du kannst weiterkaempfen! (HP: " + spielerHP + ")");
        } else {
            System.out.println("Spiel vorbei! Du hast keine Lebenspunkte mehr.");
        }

        // Szenario 2: Gegner besiegt
        int ep = 0;
        if (gegnerHP <= 0) {
            ep += 10;
            System.out.println("Gegner besiegt! Du erhaeltst 10 EP.");
        } else {
            System.out.println("Der Gegner lebt noch.");
        }
        System.out.println("Aktuelle EP: " + ep);

        // Szenario 3: Schlüssel gefunden
        if (hatSchluessel) {
            System.out.println("Du oeffnest die Tuer mit dem Schluessel.");
        } else {
            System.out.println("Die Tuer ist verschlossen. Du brauchst einen Schluessel.");
        }
    }
}
```

### Erweiterung

Kombiniere die Szenarien: Der Spieler kann die Tür nur öffnen, wenn er den Schlüssel hat UND der Gegner besiegt ist.
