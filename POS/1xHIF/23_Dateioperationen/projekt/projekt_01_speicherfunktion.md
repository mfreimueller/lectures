# Jahresprojekt: Dungeon Crawler — Speicherfunktion

Der Dungeon Crawler erhält eine Speicherfunktion für Spielstände.

## saveGame(String datei)

Speichert den aktuellen Spielstand in eine Textdatei. Verwende try-with-resources.

```java
public void saveGame(String dateiname) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(dateiname))) {
        pw.println(player.getName());
        pw.println(player.getHp());
        pw.println(player.getMaxHp());
        pw.println(player.getAttack());
        pw.println(player.getXp());
        pw.println(player.getLevel());
        pw.println(currentRoom.getName());
        System.out.println("Spiel gespeichert!");
    } catch (IOException e) {
        System.out.println("Fehler beim Speichern: " + e.getMessage());
    }
}
```

## loadGame(String datei)

Liest die Datei und stellt den Spielstand wieder her. Verwende try-with-resources.

```java
public void loadGame(String dateiname) {
    try (BufferedReader br = new BufferedReader(new FileReader(dateiname))) {
        String name = br.readLine();
        int hp = Integer.parseInt(br.readLine());
        int maxHp = Integer.parseInt(br.readLine());
        int attack = Integer.parseInt(br.readLine());
        int xp = Integer.parseInt(br.readLine());
        int level = Integer.parseInt(br.readLine());
        String roomName = br.readLine();
        // Player und aktuellen Raum wiederherstellen
        System.out.println("Spiel geladen!");
    } catch (IOException e) {
        System.out.println("Fehler beim Laden: " + e.getMessage());
    }
}
```

## Startmenü

Beim Start des Programms soll der Spieler wählen können:

```
=== Dungeon Crawler ===
1 - Neues Spiel
2 - Spiel laden
3 - Beenden
```

Die Methode `loadGame` wird nur beim Start aufgerufen. Danach läuft das Spiel normal weiter.