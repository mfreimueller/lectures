# Jahresprojekt: Dungeon Crawler — OO Intro

Baue den Dungeon Crawler objektorientiert um.

## Aufgaben

1. **Player-Klasse:** Erstelle eine Klasse `Player` mit privaten Attributen `String name`, `int hp`, `int maxHp`, `int attack`.
2. **Methoden:**
   - `void takeDamage(int damage)` — reduziert HP (nicht unter 0)
   - `void heal(int amount)` — heilt (nicht über maxHp)
   - `boolean isAlive()` — prüft, ob HP > 0
   - `void showStatus()` — gibt die Werte aus
3. **main:** Erstelle ein `Player`-Objekt und führe den Kampf damit.
