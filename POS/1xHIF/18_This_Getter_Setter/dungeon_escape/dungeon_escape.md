# Dungeon Escape - Woche 18: Kapselung

## Aufgabe: Kapselung der Spieler-Klasse

Mache die Spieler-Klasse sicher - wende das Prinzip der Kapselung an.

### Anforderungen

1. Mache alle Attribute private:
   - `private String name`
   - `private int hp`
   - `private int maxHp`
   - `private int angriff`
   - `private int verteidigung`

2. Erstelle Getter fuer:
   - `getName()`, `getHp()`, `getMaxHp()`, `getAngriff()`, `getVerteidigung()`

3. Erstelle setHp(int hp) mit diesen Regeln:
   - Wenn hp < 0, setze hp auf 0
   - Wenn hp > maxHp, setze hp auf maxHp
   - Sonst setze hp auf den uebergebenen Wert

4. Konstruktor: `Spieler(String name)` setzt:
   - this.name = name, hp = 100, maxHp = 100, angriff = 15, verteidigung = 8

5. Behalte: `nimmSchaden(int schaden)`, `heilen(int betrag)`, `istLebendig()`
   - Passe sie an: nimmSchaden verwendet setHp, heilen verwendet setHp

### Beispiel-Output

```
Held: HP=100/100, Angriff=15, Verteidigung=8
Held nimmt 30 Schaden. HP: 70
Held heilt 50 HP. HP: 100 (max)
Held erhaelt 200 Schaden. HP: 0 (begrenzt)
```
