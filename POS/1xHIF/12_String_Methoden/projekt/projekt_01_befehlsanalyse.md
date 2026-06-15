# Jahresprojekt — Dungeon Crawler: Befehlsanalyse

Der Dungeon Crawler soll Spielerbefehle analysieren können. Der Spieler gibt Kommandos wie "gehe norden", "nimm Schluessel", "kaempfe". Verwende String-Methoden:

- `startsWith("gehe")` → Bewegung
- `endsWith("Schluessel")` → Item aufnehmen
- `length()` prüfen, ob der Befehl leer ist
- `charAt(0)` für den ersten Buchstaben (Abkürzung "g" für "gehe")

Gib aus, welcher Befehl erkannt wurde.

### Aufgaben

1. Verwende die Spielschleife aus Woche 07.

2. Analysiere die Benutzereingabe mit String-Methoden:
   - Wenn der Befehl leer ist (`length() == 0`): "Kein Befehl eingegeben."
   - Wenn der Befehl mit "gehe" beginnt: "Bewegungsbefehl erkannt."
   - Wenn der Befehl mit "nimm" beginnt: "Aufnahmebefehl erkannt."
   - Wenn der Befehl mit "k" beginnt (`charAt(0) == 'k'`): "Kampfbefehl erkannt."
   - Sonst: "Unbekannter Befehl."

3. Gib zusätzlich aus:
   - Die Länge des Befehls.
   - Das erste Zeichen des Befehls.

**Beispielablauf:**

```
Aktion (quit zum Beenden): gehe norden
  Befehl: gehe norden (Laenge: 12)
  Erstes Zeichen: g
  Erkannt: Bewegungsbefehl

Aktion (quit zum Beenden): kaempfe
  Befehl: kaempfe (Laenge: 7)
  Erstes Zeichen: k
  Erkannt: Kampfbefehl

Aktion (quit zum Beenden):
  Befehl ist leer!

Aktion (quit zum Beenden): quit
Spiel beendet.
```

### Hinweise

- Verwende `startsWith()` und nicht `==` für den Präfix-Vergleich.
- `charAt(0)` gibt das erste Zeichen — aber nur, wenn der String nicht leer ist.
- Prüfe zuerst auf leeren Befehl, sonst kommt eine `StringIndexOutOfBoundsException`.
- Du kannst die Befehlserkennung später mit weiteren Befehlen erweitern.
