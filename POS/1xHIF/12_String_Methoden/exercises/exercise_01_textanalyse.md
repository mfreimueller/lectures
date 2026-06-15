# Exercise: Text-Analyse

Schreibe ein Programm, das einen vom Benutzer eingegebenen Satz analysiert:

- Länge des Satzes
- Anzahl der Leerzeichen (durchlaufe den Satz mit `charAt`)
- Ob der Satz mit einer bestimmten Frage beginnt (z. B. "Wie")
- Ob der Satz mit einem Fragezeichen endet
- Gib das erste und das letzte Zeichen aus

**Beispielablauf (Benutzereingabe fett):**

```
Gib einen Satz ein: Wie heißt du?
Analyse:
  Laenge: 13 Zeichen
  Anzahl Leerzeichen: 2
  Beginnt mit "Wie": true
  Endet mit ?: true
  Erstes Zeichen: W
  Letztes Zeichen: ?
```

**Weiteres Beispiel:**

```
Gib einen Satz ein: Hallo Welt.
Analyse:
  Laenge: 11 Zeichen
  Anzahl Leerzeichen: 1
  Beginnt mit "Wie": false
  Endet mit ?: false
  Erstes Zeichen: H
  Letztes Zeichen: .
```

### Hinweise

- Verwende `String.length()` für die Länge.
- Durchlaufe den String mit `charAt(i)` in einer Schleife, um Leerzeichen zu zählen.
- Verwende `startsWith("Wie")` und `endsWith("?")`.
- Das erste Zeichen ist `charAt(0)`, das letzte ist `charAt(satz.length() - 1)`.
