# Kata 3: Rechteck mit Konstruktor-Ueberladung

| Feld | Wert |
|------|------|
| Konzepte | Konstruktor-Ueberladung, Standardwerte, Methoden |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle die Klasse `Rechteck` mit:

1. Attributen: `laenge` (double), `breite` (double)
2. `Rechteck()` - laenge = 1.0, breite = 1.0
3. `Rechteck(double laenge, double breite)` - beide Werte setzen
4. Methode: `berechneFlaeche()` gibt laenge * breite zurueck
5. Methode: `berechneUmfang()` gibt 2 * (laenge + breite) zurueck
6. Methode: `printInfo()` gibt alle Informationen aus

Erstelle eine Test-Klasse, die beide Konstruktoren testet.

### Beispiel-Output

```
Rechteck 1: Laenge=1.0, Breite=1.0, Flaeche=1.0, Umfang=4.0
Rechteck 2: Laenge=5.0, Breite=3.0, Flaeche=15.0, Umfang=16.0
```
