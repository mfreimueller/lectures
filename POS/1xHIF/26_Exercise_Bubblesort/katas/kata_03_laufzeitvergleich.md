# Kata 03: Laufzeitvergleich

Schreibe ein Programm, das die Laufzeit von Selection Sort, Insertion Sort und Bubblesort vergleicht.

Aufgabenstellung:

1. Generiere drei Arrays mit 10.000 zufälligen Zahlen
2. Sortiere jedes Array mit einem anderen Algorithmus
3. Messe die Zeit mit `System.currentTimeMillis()`
4. Gib die Ergebnisse in Millisekunden aus

Beispielausgabe:

```
Selection Sort: 45 ms
Insertion Sort: 32 ms
Bubble Sort: 89 ms
```

Hinweise:
- Verwende `java.util.Random` zum Generieren der Zufallszahlen
- Kopiere das Array vor dem Sortieren, damit alle Algorithmen die gleichen Daten erhalten
- Verwende `System.currentTimeMillis()` vor und nach dem Sortieren
