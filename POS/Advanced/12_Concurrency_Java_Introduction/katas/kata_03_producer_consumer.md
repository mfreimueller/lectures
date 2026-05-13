# Kata 3: Producer-Consumer

| Feld | Wert |
|------|------|
| Konzepte | wait/notify, Bounded Buffer, Thread-Koordination |
| Schwierigkeit | 3/5 |
| Dauer | ca. 45 min |

### Aufgabenstellung

Implementiere einen Bounded Buffer mit dem Producer-Consumer Pattern.

1. Erstelle eine Klasse `BoundedBuffer`:
   - Interner Ringpuffer (Array) mit konfigurierbarer Kapazitat
   - Methoden `void put(int value)` und `int take()`
   - Beide Methoden sind `synchronized`
   - Bei vollem Puffer: `wait()` im Produzenten
   - Bei leerem Puffer: `wait()` im Konsumenten
   - Nach erfolgreichem put/take: `notifyAll()` aufrufen

2. Erstelle eine Klasse `Producer implements Runnable`:
   - Produziert 50 Werte (0 bis 49) und legt sie in den Puffer
   - Gibt jeden produzierten Wert aus

3. Erstelle eine Klasse `Consumer implements Runnable`:
   - Konsumiert 50 Werte aus dem Puffer
   - Gibt jeden konsumierten Wert aus

4. Starte in main():
   - 1 Producer und 2 Consumer Threads
   - Puffer-Kapazitat: 5
   - Warte auf alle Threads

### Beispiel-Output

```
[Producer] Put: 0
[Producer] Put: 1
[Producer] Put: 2
[Consumer-1] Took: 0
[Producer] Put: 3
[Consumer-2] Took: 1
...
All tasks completed.
```

### Erweiterung

Fuge einen zweiten Producer hinzu. Stelle sicher, dass die Gesamtzahl der produzierten Werte (100) und der konsumierten Werte (100) ubereinstimmt. Verwende `volatile` fur eine shared counter-Variable.
