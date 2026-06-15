# Große Übung: Zahlenratespiel mit Limit

Der Computer denkt sich eine Zufallszahl zwischen 1 und 100. Der Spieler hat 10 Versuche, sie zu erraten. Nach jedem Tipp gibt das Programm "Zu hoch" oder "Zu niedrig" aus. Wenn der Spieler die Zahl errät, wird die Schleife mit `break` beendet und die Anzahl der benötigten Versuche ausgegeben. Am Ende wird verraten, ob gewonnen oder verloren wurde. Verwende `while` oder `do-while`.

**Beispielablauf (Zufallszahl = 42):**

```
Rate die Zahl (1-100). Du hast 10 Versuche.
Versuch 1: 50
Zu hoch!
Versuch 2: 30
Zu niedrig!
Versuch 3: 42
Gratulation! Du hast die Zahl in 3 Versuchen erraten!
```

**Bei Niederlage:**

```
...
Versuch 10: 55
Leider verloren! Die Zahl war 42.
```

### Hinweise

- Verwende `Random` für die Zufallszahl: `Random random = new Random(); int zahl = random.nextInt(100) + 1;`
- Verwende `Scanner` für die Eingabe.
- Zähle die Versuche mit einer Variable.
- Verwende `break`, wenn die Zahl erraten wurde.
- Nach 10 Versuchen endet die Schleife automatisch.

### Anforderungen

- Das Programm muss richtig auf "zu hoch" und "zu niedrig" reagieren.
- Bei Gewinn: Anzahl der benötigten Versuche ausgeben.
- Bei Verlust: Die gesuchte Zahl verraten.
