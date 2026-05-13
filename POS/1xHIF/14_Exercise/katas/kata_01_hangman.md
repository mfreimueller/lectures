# Kata 1: Hangman

| Feld | Wert |
|------|------|
| Konzepte | while-Schleife, charAt, String-Manipulation |
| Schwierigkeit | 3/5 |
| Dauer | ca. 30 min |

### Aufgabenstellung

Schreibe ein einfaches Hangman-Spiel.

1. Lege ein Wort fest (z.B. "java", "programmieren", "computer")
2. Zeige dem Spieler den aktuellen Stand: unbekannte Buchstaben als _
3. Der Spieler gibt wiederholt einen Buchstaben ein
4. Prüfe mit charAt(), ob der Buchstabe im Wort vorkommt
5. Aktualisiere den sichtbaren Wortstand
6. Das Spiel endet, wenn alle Buchstaben erraten wurden

### Beispiel-Output

```
Willkommen bei Hangman!
Das Wort hat 4 Buchstaben: ____
Rate einen Buchstaben: j
Richtig! Wort: j___
Rate einen Buchstaben: a
Richtig! Wort: ja_a
Rate einen Buchstaben: v
Richtig! Wort: java
Gewonnen! Das Wort war: java
```

### Hinweise

- Verwende eine while-Schleife, die läuft, bis das Wort vollständig erraten ist
- charAt(index) gibt den Buchstaben an Stelle index zurück
- Baue den sichtbaren String neu auf: für jeden Buchstaben im Wort entweder den Buchstaben oder _
- equals() statt == für String-Vergleich
