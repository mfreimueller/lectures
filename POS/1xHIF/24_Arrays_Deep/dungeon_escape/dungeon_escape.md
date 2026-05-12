# Dungeon Escape: Inventar-Verwaltung

Erweitere dein Dungeon Escape Spiel um ein Inventar-System.

## Aufgabenstellung

1. Erstelle eine Klasse `Gegenstand` mit Attributen `name` (String) und `gewicht` (int).
2. Erstelle ein Inventar als Array von Gegenstaenden mit maximal 10 Plaetzen.
3. Implementiere folgende Methoden:
   - `void addGegenstand(Gegenstand g)` - fuegt einen Gegenstand hinzu, prueft ob Platz ist
   - `void entferneGegenstand(int index)` - entfernt den Gegenstand an der Position
   - `void zeigeInventar()` - gibt alle Gegenstaende im Inventar aus

## Beispiel

```java
Gegenstand schwert = new Gegenstand();
schwert.name = "Schwert";
schwert.gewicht = 5;

addGegenstand(schwert);
addGegenstand(new Gegenstand("Heiltrank", 1));
zeigeInventar();
```

## Hinweise
- Verwende eine Variable `int anzahl` um die belegten Plaetze zu zaehlen
- Pruefe vor dem Hinzufuegen, ob das Inventar voll ist
- Beim Entfernen: setze das letzte Element an die freie Position
- Setze den freigewordenen Platz auf null
