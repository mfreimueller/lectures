# Jahresprojekt: Dungeon Crawler — UML-Diagramm

Erstelle ein UML-Klassendiagramm (auf Papier oder digital) des gesamten Dungeon Crawlers.

## Enthaltene Klassen

- **Player**: name, hp, maxHp, attack, xp, level
- **Enemy**: name, hp, attack, xpReward
- **Item**: name, healing, damage
- **Room**: name, desc, north, south, east, west, enemy, item
- **Game**: player, currentRoom, running

## Anforderungen

1. Alle Klassen mit ihren Attributen und Methoden eintragen
2. Sichtbarkeiten (+ und -) richtig setzen
3. Assoziationen zwischen den Klassen einzeichnen
4. Multiplizitäten an den Assoziationen notieren

## Hinweise

- Der Game hat einen Player und einen aktuellen Room
- Room hat optional einen Enemy und ein Item (0..1)
- Room hat Referenzen auf Nachbarräume (0..1 north, south, east, west)
- Player hat eine Verbindung zum aktuellen Raum

Aus dem Diagramm soll eine Code-Struktur ablesbar sein. Prüfe am Ende, ob aus deinem Diagramm die bestehenden Klassen korrekt rekonstruiert werden könnten.