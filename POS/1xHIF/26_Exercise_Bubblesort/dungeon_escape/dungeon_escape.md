# Dungeon Escape: Highscore mit Bubblesort

Verwende Bubblesort, um die Highscore-Liste von Dungeon Escape zu sortieren.

## Aufgabenstellung

1. Uebernimm die Highscore-Liste aus Woche 25 (int[] scores, String[] namen)
2. Implementiere Bubblesort auf dem Scores-Array
3. Sortiere die Namen parallel zu den Scores
4. Gib die Top 3 mit Namen und Punkten aus

## Beispiel

```java
highscoreEintragen(85, "Aragorn");
highscoreEintragen(120, "Legolas");
highscoreEintragen(45, "Frodo");
highscoreEintragen(200, "Gandalf");
highscoreEintragen(70, "Gimli");

top3Ausgeben();
// Erwartete Ausgabe:
// 1. Frodo - 45
// 2. Gimli - 70
// 3. Aragorn - 85
```

## Hinweise
- Bubblesort vergleicht und tauscht benachbarte Elemente
- Die Namen muessen parallel zu den Scores getauscht werden
- Gib nur die ersten drei Eintraege aus
