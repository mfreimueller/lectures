# Dungeon Escape - Zufallszahlen

## Zufallsgegner
Erzeuge Gegner mit zufaelligen Staerken. Jeder Gegner hat einen Namen und Schadenswert,
die zufaellig bestimmt werden. Verwende die Random-Klasse fuer die Erzeugung.

Anforderungen:
- Mindestens 5 verschiedene Gegnertypen (Ork, Goblin, Troll, Skelett, Drache)
- Zufaellige Lebenspunkte (innerhalb eines Bereichs pro Typ)
- Zufaelliger Schaden (innerhalb eines Bereichs pro Typ)

## Kritische Treffer
Bei jedem Angriff besteht eine 20% Wahrscheinlichkeit auf einen kritischen Treffer,
der den doppelten Schaden verursacht.

Anforderungen:
- 20% Wahrscheinlichkeit (random.nextDouble() < 0.2)
- Doppelter Schaden bei kritischem Treffer
- Ausgabe "Kritischer Treffer!" bei Erfolg

## Zufaellige Schaetze
In jedem Raum soll ein zufaelliger Schatz gefunden werden koennen.

Moegliche Schaetze:
- Gold (10-50)
- Heiltrank (+20 Lebenspunkte)
- Waffe (+5 Schaden)
- Schild (Schaden halbieren fuer einen Kampf)
