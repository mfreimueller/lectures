# Dungeon Escape - Woche 20: Gegenstande und Inventar

## Aufgabe

In dieser Woche erweiterst du dein Dungeon Escape um Gegenstande. Der Spieler kann Gegenstande finden, aufheben, im Inventar tragen und ablegen.

### Anforderungen

1. **Klasse Gegenstand**
   - Attribute: `name` (String), `gewicht` (int)
   - Konstruktor: `Gegenstand(String name, int gewicht)`
   - Methode `benutze()`: Gibt einen String zuruck, z. B. "Du benutzt das Schwert." oder "Du trinkst den Heiltrank. +10 HP"

2. **Spieler erweitern**
   - Neues Attribut: `inventar` (Gegenstand[5]), `anzahlGegenstaende` (int)
   - Methode `gegenstandAufnehmen(Gegenstand g)`: Fuge Gegenstand ins Inventar ein (falls Platz). Gib Erfolgsmeldung zuruck.
   - Methode `gegenstandAblegen(int index)`: Entferne Gegenstand aus dem Inventar (setze das Feld auf null und rucke auf). Gib den fallengelassenen Gegenstand zuruck.
   - Methode `zeigeInventar()`: Gib alle Gegenstande im Inventar aus.
   - Methode `benutzeGegenstand(int index)`: Rufe `benutze()` auf dem Gegenstand auf und gib das Ergebnis aus.

### Beispiel-Output

```
Gegenstand schwert = new Gegenstand("Schwert", 3);
Gegenstand heiltrank = new Gegenstand("Heiltrank", 1);

spieler.gegenstandAufnehmen(schwert);
// "Schwert (Gewicht: 3) wurde ins Inventar aufgenommen."

spieler.gegenstandAufnehmen(heiltrank);

spieler.zeigeInventar();
// Inventar:
// 1. Schwert (Gewicht: 3)
// 2. Heiltrank (Gewicht: 1)

spieler.benutzeGegenstand(1);
// "Du benutzt den Heiltrank."
```
