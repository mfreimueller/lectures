# Jahresprojekt — Dungeon Crawler: Schaden berechnen

Der Spieler soll Schaden berechnen können. Lege Variablen für die Angriffskraft des Spielers und die Rüstung des Gegners an und berechne den effektiven Schaden.

### Aufgaben

1. Lege eine Variable für die Angriffskraft des Spielers (`int`, z. B. 18) an.
2. Lege eine Variable für die Rüstung des Gegners (`int`, z. B. 5) an.
3. Berechne den effektiven Schaden als `angriff - rüstung`.
4. Gib die Werte und das Ergebnis aus.
5. Probiere auch aus, was passiert, wenn die Rüstung höher ist als der Angriff (z. B. Angriff=10, Rüstung=15).

### Beispiel-Output

```
Angriffskraft: 18
Ruestung: 5
Effektiver Schaden: 13
---
Angriffskraft: 10
Ruestung: 15
Effektiver Schaden: -5
```

### Erweiterung

Stelle sicher, dass der Schaden nie negativ wird. Falls der berechnete Wert negativ ist, setze ihn auf 0. (Hinweis: Dafür brauchst du eine Verzweigung — die lernst du in einer späteren Stunde. Du kannst es aber mit den aktuellen Mitteln notieren.)
