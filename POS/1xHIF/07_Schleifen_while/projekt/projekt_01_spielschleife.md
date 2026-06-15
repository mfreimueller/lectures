# Jahresprojekt — Dungeon Crawler: Spielschleife

Der Dungeon Crawler bekommt eine Spielschleife: Der Spieler wird solange nach einer Aktion gefragt, bis er "quit" eingibt. Verwende eine `while`-Schleife mit einer `boolean`-Variable `spielLaeuft`. Gib bei jeder Runde die aktuellen Lebenspunkte des Spielers aus.

### Aufgaben

1. Erstelle eine Klasse `DungeonCrawler` mit einer `main`-Methode.
2. Definiere eine Variable `int hp = 100` für die Lebenspunkte des Spielers.
3. Definiere eine Variable `boolean spielLaeuft = true`.
4. Implementiere eine `while`-Schleife, die läuft, solange `spielLaeuft` true ist.
5. Frage den Spieler nach einer Aktion: `System.out.print("Aktion (quit zum Beenden): ");`
6. Lies die Eingabe mit `Scanner.nextLine()`.
7. Wenn der Spieler "quit" eingibt, setze `spielLaeuft = false`.
8. Gib am Ende jeder Runde die aktuellen HP aus.

**Beispielablauf:**

```
=== DUNGEON CRAWLER ===
Aktion (quit zum Beenden): gehe norden
HP: 100
Aktion (quit zum Beenden): kaempfe
HP: 100
Aktion (quit zum Beenden): quit
Spiel beendet.
```

### Hinweise

- Verwende `Scanner` für die Eingabe.
- Vergleiche Strings mit `equals()`.
- Die `while`-Schleife ist die Hauptschleife des Spiels — sie wird in den nächsten Wochen erweitert.
