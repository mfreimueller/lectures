# Kata 1: Thread Creation

| Feld | Wert |
|------|------|
| Konzepte | Thread, Runnable, start(), run() |
| Schwierigkeit | 1/5 |
| Dauer | ca. 30 min |

### Aufgabenstellung

Implementiere einen Countdown-Timer auf zwei verschiedene Arten:

1. **Variante A: extends Thread**
   - Erstelle eine Klasse `CountdownThread extends Thread`
   - Der Konstruktor nimmt `name` und `startValue` entgegen
   - In `run()`: Zahle von `startValue` abwarts bis 0 und gib jede Zahl aus
   - Lege eine Pause von 500ms zwischen den Zahlen (Thread.sleep(500))

2. **Variante B: implements Runnable**
   - Erstelle eine Klasse `CountdownTask implements Runnable`
   - Gleiche Funktionalität wie Variante A

3. **main-Methode:**
   - Starte 3 CountdownThreads mit verschiedenen Startwerten (10, 8, 5)
   - Starte 3 CountdownTasks über Thread-Objekte mit Startwerten (7, 6, 3)
   - Beobachte die verschrankte Ausgabe

### Beispiel-Output

```
[Thread-10] 10
[Task-7] 7
[Thread-8] 8
[Task-6] 6
[Thread-5] 5
[Task-3] 3
[Thread-10] 9
...
```

### Erweiterung

Implementiere einen verketteten Countdown: Thread 2 startet erst, wenn Thread 1 fertig ist (join()).
