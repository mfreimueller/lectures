# Kata 2: Temperatur

| Feld | Wert |
|------|------|
| Konzepte | private, Getter, Setter, berechneter Getter |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle eine gekapselte Klasse `Temperatur`:

1. Attribut `private double celsius`
2. Getter `getCelsius()` gibt celsius zurück
3. Setter `setCelsius(double celsius)` setzt celsius
4. Getter `getFahrenheit()` berechnet und gibt Fahrenheit zurück (Formel: celsius * 9.0 / 5.0 + 32.0)
5. Methode `printInfo()` gibt beide Werte formatiert aus
6. Konstruktor `Temperatur(double celsius)`

### Beispiel-Output

```
Temperatur: 25.0 C = 77.0 F
```
