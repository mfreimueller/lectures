# Dungeon Escape - Woche 02: Tuer-Entscheidung

## Aufgabenstellung

Der Spieler steht im Eingangsbereich und muss eine Tuer waehlen.

### Anforderungen

1. Deklariere eine Variable `wahl` vom Typ int (1 = linke Tuer, 2 = rechte Tuer)
2. Gib die beiden Tueren und ihre Beschreibungen aus
3. Verwende if/else, um die Wahl auszuwerten
4. Gib den gewaehlten Raum und eine Beschreibung aus

### Beispiel-Output (wahl = 1)

```
============================
Der Spieler steht vor zwei Tueren.
Links: Eine alte, verbogene Holztuer.
Rechts: Eine massive Eisentuer.

Du waehlst die linke Tuer ...
Du betrittst einen Raum voller Gold und Juwelen!
Herzlichen Glueckwunsch, du hast den Schatz gefunden!
============================
```

### Erweiterung

Veraendere die HP-basierend auf der Wahl und gib die neuen HP aus.
Starte mit `int hp = 100`.
- Schatz: hp += 10
- Drache: hp -= 20
