# Kata 2: Zahlenratespiel mit Methoden

| Feld | Wert |
|------|------|
| Konzepte | Methoden, Random, while-Schleife, Parameter |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erweitere das Zahlenratespiel aus Woche 05. Lagere die Spiellogik in Methoden aus.

1. Schreibe eine Methode `generiereZahl()` die eine Zufallszahl zwischen 1 und 100 zurueckgibt
2. Schreibe eine Methode `rateZahl(int tip, int ziel)` die zurueckgibt, ob der Tip zu niedrig, zu hoch oder richtig ist (z.B. -1, 0, 1)
3. Schreibe eine Methode `zeigeErgebnis(int versuche)`, die die Anzahl der Versuche ausgibt
4. Die main-Methode steuert den Spielfluss

### Beispiel-Output

```
Ich denke mir eine Zahl zwischen 1 und 100...
Dein Tip: 50
Zu hoch!
Dein Tip: 25
Zu niedrig!
Dein Tip: 37
Richtig! Du hast 3 Versuche gebraucht.
```
