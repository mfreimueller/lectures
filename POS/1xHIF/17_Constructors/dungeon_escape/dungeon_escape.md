# Dungeon Escape - Woche 17: Konstruktoren

## Aufgabe: Konstruktoren fuer Spieler und Raum

Erstelle Konstruktoren fuer deine Dungeon Escape Klassen.

### Spieler-Klasse

- Fuege einen Konstruktor `Spieler(String name)` hinzu
- Setzt name, hp = 100, angriff = 15
- Behalte die Methode `zeigeStatus()` bei

### Raum-Klasse

- Fuege einen Konstruktor `Raum(String name, String beschreibung)` hinzu
- Fuege einen zweiten Konstruktor `Raum(String name, String beschreibung, String gegner)` hinzu
- Das Attribut `gegner` speichert den Namen des Gegners in diesem Raum (oder null, wenn keiner da ist)

### Test-Klasse

Erzeuge Objekte mit den neuen Konstruktoren und gib alle Informationen aus.

### Beispiel-Output

```
Spieler: Held (HP: 100, Angriff: 15)
Raum: Eingangshalle - Du bist am Eingang.
Raum: Kampfarena - Hier ist ein Goblin! (Gegner: Goblin)
```
