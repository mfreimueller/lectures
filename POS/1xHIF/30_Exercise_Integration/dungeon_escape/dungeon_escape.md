# Dungeon Escape - Wahlfeature

Waehle mindestens eines der folgenden Features fuer dein Dungeon Escape Spiel aus.

## Option (a): Mehrere Etagen
Erweitere den Dungeon auf mehrere Etagen mit einem 2D-Array von Raeumen.

Anforderungen:
- int[][] dungeon = new int[3][5] (3 Etagen, 5 Raeume pro Etage)
- Jede Etage hat andere Gegner (staerker in tieferen Etagen)
- Aufzug/Treppe zwischen den Etagen

## Option (b): Zufallsraeume
Raeume werden erst bei Betreten generiert (Inhalt zufaellig).

Anforderungen:
- Raum wird erst erzeugt, wenn der Spieler eintritt
- Zufaelliger Inhalt (Gegner, Schatz, leer, Fallen)
- Unterschiedliche Raumtypen

## Option (c): Items mit Effekten (Polymorphie)
Erstelle eine Hierarchie von Gegenstaenden mit unterschiedlichen Effekten.

Anforderungen:
- Abstrakte Klasse oder Interface Gegenstand
- Subklassen: Heiltrank, Waffe, Schild, Gold
- Jeder Gegenstand hat eine verwenden()-Methode
- Items koennen im Inventar gespeichert werden
