# Kata 03: Würfelspiel

Modelliere ein Würfelspiel mit zwei Klassen.

## Anforderungen
- Klasse Würfel mit Attribut: seiten (int)
- Methode würfeln(): gibt eine Zufallszahl zwischen 1 und seiten zurück
- Klasse Spieler mit Attributen: name (String), würfel (Würfel)
- Methode spieleRunde(): würfelt und gibt das Ergebnis aus
- Zwei Spieler spielen gegeneinander: Wer die höchste Summe nach 3 Runden hat, gewinnt

## Beispiel
```java
Wuerfel w6 = new Wuerfel(6);
Spieler s1 = new Spieler("Anna", w6);
Spieler s2 = new Spieler("Ben", w6);
// Wer hat nach 3 Runden die höchste Summe?
```
