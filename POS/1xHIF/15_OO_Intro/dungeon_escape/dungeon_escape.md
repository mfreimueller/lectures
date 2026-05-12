# Dungeon Escape - Woche 15: Erste Klassen

## Aufgabe: Spieler- und Raum-Klasse

In dieser Woche erstellst du die ersten eigenen Klassen fuer das Dungeon Escape Spiel.

### Anforderungen

1. Erstelle eine Klasse `Spieler` in `Spieler.java` mit:
   - Attributen: `name` (String), `hp` (int), `angriff` (int)
   - Einer Methode `zeigeStatus()`, die die Attribute ausgibt

2. Erstelle eine Klasse `Raum` in `Raum.java` mit:
   - Attributen: `name` (String), `beschreibung` (String)
   - Einer Methode `zeigeBeschreibung()`, die die Beschreibung ausgibt

3. Erstelle eine Datei `DungeonTest.java` mit main-Methode:
   - Erzeuge ein Spieler-Objekt
   - Erzeuge zwei Raum-Objekte
   - Rufe die Methoden auf

### Beispiel-Output

```
Spieler: Held, HP: 100, Angriff: 15
Raum: Eingangshalle - Du befindest dich am Dungeon-Eingang.
Raum: Gang - Ein langer, dunkler Gang.
```
