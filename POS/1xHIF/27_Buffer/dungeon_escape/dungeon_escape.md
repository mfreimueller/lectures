# Dungeon Escape: Highscore-Verbesserung

Verbessere die Highscore-Liste von Dungeon Escape.

## Aufgabenstellung

1. Erstelle eine Highscore-Liste mit int[] scores und String[] namen
2. Gib die Highscore-Liste in absteigender Reihenfolge aus (hoechster Score zuerst)
3. Implementiere eine Methode, um einen neuen Highscore hinzuzufuegen
4. Wenn ein neuer Highscore erreicht wird, soll der Name hinzugefuegt werden
5. Initiale Werte sind fest im Code vorgegeben

## Beispiel

```java
highscoreEintragen(85, "Aragorn");
highscoreEintragen(120, "Legolas");
highscoreEintragen(45, "Frodo");
highscoreEintragen(200, "Gandalf");
highscoreEintragen(150, "Gimli");

highscoreAusgebenAbsteigend();
// Erwartete Ausgabe:
// 1. Gandalf - 200
// 2. Gimli - 150
// 3. Legolas - 120
// 4. Aragorn - 85
// 5. Frodo - 45
```

## Hinweise
- Sortiere absteigend (groesster zuerst)
- Verwende Selection Sort oder Bubblesort
- Vergleiche nicht nur Scores, sondern vertausche auch die Namen
- Achte auf die maximale Anzahl an Eintraegen
