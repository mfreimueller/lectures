# Kata 3: Rechteck mit Konstruktor-Überladung

| Feld | Wert |
|------|------|
| Konzepte | Konstruktor-Überladung, Standardwerte, Methoden |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle die Klasse `Rechteck` mit:

1. Attributen: `laenge` (double), `breite` (double)
2. `Rechteck()` - länge = 1.0, breite = 1.0
3. `Rechteck(double laenge, double breite)` - beide Werte setzen
4. Methode: `berechneFlaeche()` gibt länge * breite zurück
5. Methode: `berechneUmfang()` gibt 2 * (länge + breite) zurück
6. Methode: `printInfo()` gibt alle Informationen aus

Erstelle eine Test-Klasse, die beide Konstruktoren testet.

### Beispiel-Output

```
Rechteck 1: Länge=1.0, Breite=1.0, Fläche=1.0, Umfang=4.0
Rechteck 2: Länge=5.0, Breite=3.0, Fläche=15.0, Umfang=16.0
```
