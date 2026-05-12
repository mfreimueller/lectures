# Dungeon Escape - Woche 01: Erste Schritte

## Aufgabenstellung

Der Spieler betritt den Dungeon. Dein Programm gibt den Spieler-Status aus und berechnet die erste Kampfrunde.

### Anforderungen

1. Lege diese Variablen an:
   - `name` (String): "Heldenname"
   - `hp` (int): 100
   - `angriff` (double): 15.5
   - `verteidigung` (double): 8.3

2. Gib den Status formatiert aus

3. Berechne: `schaden = angriff - verteidigung`

4. Gib den Schaden und die neuen HP aus

### Beispiel-Output

```
============================
Spieler: Heldenname
HP: 100
Angriff: 15.5
Verteidigung: 8.3
============================
Angriff verursacht 7.2 Schaden!
Neue HP: 92.8
```

### Erweiterung

Berechne einen kritischen Treffer: `kritischerSchaden = schaden * 2`.
