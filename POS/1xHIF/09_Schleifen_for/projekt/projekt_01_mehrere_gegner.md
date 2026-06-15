# Jahresprojekt — Dungeon Crawler: Mehrere Gegner

Der Dungeon Crawler bekommt mehrere Gegner in einer Begegnung. Der Spieler kämpft gegen eine Gruppe von 3 Goblins. Verwende eine `for`-Schleife, um nacheinander gegen jeden Goblin anzutreten. Gib nach jedem Kampf aus, wie viele Goblins noch übrig sind. Wenn der Spieler stirbt, brich die Schleife ab.

### Aufgaben

1. Definiere Variablen:
   - `int spielerHp = 100`
   - `int anzahlGegner = 3`
   - `int gegnerHp = 30` (pro Goblin)
   - `Random random = new Random()`

2. Implementiere eine `for`-Schleife, die für jeden Goblin einen Kampf durchführt:
   - `for (int i = 1; i <= anzahlGegner; i++)`

3. In jedem Durchlauf:
   - Gib aus: "Kaempfe gegen Goblin X von Y"
   - Simuliere den Kampf (Angriff des Spielers, Angriff des Goblins).
   - Wenn der Spieler stirbt (`spielerHp <= 0`), brich die Schleife mit `break` ab.
   - Sonst: Gib die verbleibenden Goblins aus.

**Beispielablauf:**

```
Kaempfe gegen Goblin 1 von 3!
Du hast den Goblin besiegt! (HP: 85)

Kaempfe gegen Goblin 2 von 3!
Du hast den Goblin besiegt! (HP: 70)

Kaempfe gegen Goblin 3 von 3!
Du hast den Goblin besiegt! (HP: 55)

Alle Gegner besiegt! Sieg!
```

### Hinweise

- Der Schaden kann zufällig sein (wie letzte Woche).
- Der Goblin kann auch zurückschlagen.
- Mit `break` kann der Kampf abgebrochen werden, wenn der Spieler stirbt.
- Zähle die besiegten Goblins und gib sie am Ende aus.
