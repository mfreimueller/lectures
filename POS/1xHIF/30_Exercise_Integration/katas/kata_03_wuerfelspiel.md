# Kata 03: Wuerfelspiel

Modelliere ein Wuerfelspiel mit zwei Klassen.

## Anforderungen
- Klasse Wuerfel mit Attribut: seiten (int)
- Methode wuerfeln(): gibt eine Zufallszahl zwischen 1 und seiten zurueck
- Klasse Spieler mit Attributen: name (String), wuerfel (Wuerfel)
- Methode spieleRunde(): wuerfelt und gibt das Ergebnis aus
- Zwei Spieler spielen gegeneinander: Wer die hoechste Summe nach 3 Runden hat, gewinnt

## Beispiel
```java
Wuerfel w6 = new Wuerfel(6);
Spieler s1 = new Spieler("Anna", w6);
Spieler s2 = new Spieler("Ben", w6);
// Wer hat nach 3 Runden die hoechste Summe?
```
