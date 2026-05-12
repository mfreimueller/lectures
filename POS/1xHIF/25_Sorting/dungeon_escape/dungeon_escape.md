# Dungeon Escape: Highscore-Liste

Implementiere eine Highscore-Liste fuer Dungeon Escape.

## Aufgabenstellung

1. Erstelle zwei parallele Arrays: `int[] scores` und `String[] namen`
2. Implementiere eine Methode `void highscoreEintragen(int score, String name)`, die einen neuen Eintrag hinzufuegt
3. Implementiere eine Methode `void highscoreAusgeben()`, die die Highscore-Liste sortiert (aufsteigend) ausgibt
4. Verwende Selection Sort und sortiere beide Arrays parallel

## Beispiel

```java
highscoreEintragen(85, "Aragorn");
highscoreEintragen(120, "Legolas");
highscoreEintragen(45, "Frodo");
highscoreEintragen(200, "Gandalf");

highscoreAusgeben();
// Erwartete Ausgabe (sortiert):
// 45 - Frodo
// 85 - Aragorn
// 120 - Legolas
// 200 - Gandalf
```

## Hinweise
- Die maximale Anzahl an Highscore-Eintraegen ist 10
- Verwendest du parallele Arrays, muessen beide Arrays beim Sortieren gleichzeitig umsortiert werden
- Tausche die Namen genauso wie die Scores
