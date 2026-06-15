# Jahresprojekt — Dungeon Crawler: Kampfmenü

Der Dungeon Crawler bekommt ein Kampfmenü in einer `do-while`-Schleife:

1. Angreifen
2. Heilen
3. Fliehen (beendet den Kampf)

Der Spieler und der Gegner haben Lebenspunkte. Bei "Angreifen" verliert der Gegner zufällig Schaden. Bei "Heilen" erhält der Spieler 10 HP (aber nicht über das Maximum). Der Kampf endet, wenn der Gegner besiegt ist, der Spieler flieht oder der Spieler stirbt (HP <= 0). Verwende `break` und `continue` sinnvoll.

### Aufgaben

1. Erstelle die Variablen:
   - `int spielerHp = 100`
   - `int gegnerHp = 50`
   - `int maxHp = 100`
   - `Random random = new Random()`

2. Implementiere eine `do-while`-Schleife für das Kampfmenü.

3. Bei Option 1 (Angreifen):
   - Berechne zufälligen Schaden: `int schaden = random.nextInt(20) + 5;`
   - Ziehe Schaden von `gegnerHp` ab.
   - Gib aus: "Du hast dem Gegner X Schaden zugefügt!"
   - Wenn der Gegner besiegt ist (`gegnerHp <= 0`), gib "Gegner besiegt!" aus und `break`.

4. Bei Option 2 (Heilen):
   - Erhöhe `spielerHp` um 10.
   - Aber nicht über `maxHp`: `spielerHp = Math.min(spielerHp + 10, maxHp);`
   - Gib "Du hast 10 HP geheilt." aus.
   - Verwende `continue`, um zum Menü zurückzukehren.

5. Bei Option 3 (Fliehen):
   - Gib "Du bist geflohen!" aus und `break`.

6. Nach jeder Aktion: Überprüfe, ob der Spieler gestorben ist (`spielerHp <= 0`).
   - Wenn ja: "Du wurdest besiegt!" und `break`.

7. Die `do-while`-Schleife läuft, solange beide Kämpfer noch leben.

**Beispielablauf:**

```
=== KAMPF ===
1. Angreifen
2. Heilen
3. Fliehen
Deine Wahl: 1
Du hast dem Gegner 15 Schaden zugefuegt! (Gegner HP: 35)

1. Angreifen
2. Heilen
3. Fliehen
Deine Wahl: 2
Du hast 10 HP geheilt. (HP: 100)

...
```

### Hinweise

- Verwende `Random` für den Schaden.
- `break` beendet den Kampf (Sieg, Flucht oder Tod).
- `continue` kann beim Heilen verwendet werden, um die Gegner-Attacke zu überspringen.
- Der Gegner könnte auch zurückschlagen — als Erweiterung.
