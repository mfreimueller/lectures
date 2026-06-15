# Exercise: Bubblesort Visualisierung

Schreibe ein Programm, das ein Array mit 10 Zufallszahlen befüllt. Sortiere es mit Bubblesort und gib das Array nach **jedem** Durchlauf der äußeren Schleife aus. So kannst du sehen, wie sich das Array Schritt für Schritt sortiert.

**Beispielausgabe (mit 6 Elementen, verkürzt):**

```
Start:     [5, 2, 8, 1, 9, 3]
Durchlauf 1: [2, 5, 1, 8, 3, 9]
Durchlauf 2: [2, 1, 5, 3, 8, 9]
Durchlauf 3: [1, 2, 3, 5, 8, 9]
Durchlauf 4: [1, 2, 3, 5, 8, 9]
Sortiert:  [1, 2, 3, 5, 8, 9]
```

### Hinweise

- Verwende `Random` für Zufallszahlen (1–99).
- Befülle das Array mit einer `for`-Schleife.
- Führe Bubblesort aus und gib nach jedem Durchlauf der äußeren Schleife das Array aus.
- Verwende eine Methode, um das Array formatiert auszugeben.
- Beobachte: Wie viele Durchläufe sind nötig?

### Erweiterung

- Zähle die Tauschvorgänge und gib sie nach jedem Durchlauf aus.
- Implementiere den frühzeitigen Abbruch, wenn das Array bereits sortiert ist.
