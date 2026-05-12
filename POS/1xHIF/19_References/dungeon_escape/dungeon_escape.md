# Dungeon Escape - Woche 19: Raum-Verweise und Navigation

## Aufgabe

In dieser Woche erweiterst du dein Dungeon Escape um Raum-Verweise. Jeder Raum kennt seine Nachbarn, und der Spieler kann sich durch den Dungeon bewegen.

### Anforderungen

1. **Klasse Raum**
   - Attribute: `name` (String), `beschreibung` (String)
   - Attribute: `norden`, `sueden`, `osten`, `westen` (jeweils Raum)
   - Konstruktor mit name und beschreibung
   - Getter und Setter fur die vier Richtungen

2. **Klasse Spieler**
   - Attribute: `name` (String), `aktuellerRaum` (Raum)
   - Konstruktor mit name und Start-Raum
   - Methode `geheNorden()`: Setzt `aktuellerRaum` auf den nordlichen Nachbarn, wenn vorhanden. Sonst: "Dort ist keine Tur."
   - Methode `geheSueden()`: Analog
   - Methode `geheOsten()`: Analog
   - Methode `geheWesten()`: Analog

3. **Hauptprogramm**
   - Erstelle 4 Raume: Startraum, Wald, Turm, Schatzraum
   - Verlinke die Raume: Startraum -> Norden: Wald, Startraum -> Osten: Turm, Turm -> Norden: Schatzraum
   - Erstelle einen Spieler im Startraum
   - Gib die Position und die verfugbaren Ausgange aus
   - Teste die Navigation

### Beispiel-Output

```
Du bist im: Startraum
Du bist in einem kleinen, dunklen Raum.
Ausgange: norden, osten

> norden
Du gehst nach Norden.

Du bist im: Wald
Du bist in einem dichten, mystischen Wald.
Ausgange: suden
```
