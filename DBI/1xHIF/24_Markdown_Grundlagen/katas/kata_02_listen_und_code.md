# Kata 2: Listen und Code

## Ziel

Vertiefe deine Markdown-Kenntnisse mit verschiedenen Listenarten, Code-Blöcken und Bildeinbindung, indem du ein Kochrezept erstellst.

---

## Aufgabenstellung

Erstelle eine Datei namens `rezept.md` für ein **Kochrezept** deiner Wahl (z.B. Spaghetti Carbonara, Kaiserschmarrn, Pizza).

### Schritt 1: Titel und Beschreibung

```markdown
# Spaghetti Carbonara

Ein *klassisches* italienisches Pastagericht. **Einfach** und **schnell** zubereitet in nur 20 Minuten.
```

Passe den Titel und Text an dein gewähltes Gericht an.

### Schritt 2: Zutaten (verschachtelte Liste)

Verwende eine **ungeordnete Liste** mit Unterpunkten für die Mengenangaben:

```markdown
## Zutaten (für 2 Personen)

- Pasta
  - 200 g Spaghetti
- Soße
  - 2 Eier
  - 100 g Pecorino
  - 100 g Guanciale (oder Speck)
  - Schwarzer Pfeffer
```

**Achtung:** Die Einrückung mit 2 Leerzeichen macht einen Unterpunkt!

### Schritt 3: Zubereitung (geordnete Liste)

```markdown
## Zubereitung

1. Einen großen Topf mit **Salzwasser** zum Kochen bringen
2. Spaghetti nach Packungsanweisung *al dente* kochen
3. Währenddessen den Guanciale in kleine Streifen schneiden
4. Guanciale in einer Pfanne ohne Öl knusprig braten
5. Eier mit geriebenem Pecorino verrühren
6. Vom Herd nehmen:
   - Pfanne vom Herd ziehen
   - Eier-Mischung unterrühren (nicht kochen lassen!)
   - Mit Pfeffer würzen
7. Sofort servieren und genießen!
```

**Beachte:** Eine geordnete Liste mit einem Unterpunkt (eingerückt) — hier mit `-`.

### Schritt 4: Code-Block (Küchen-Tipp)

Füge einen Tipp in einem Code-Block hinzu:

````markdown
## Tipp

Ein echter Italiener verwendet keinen Knoblauch und keine Sahne:

```text
Carbonara-Regel:
- Kein Knoblauch
- Keine Sahne
- Kein Parmesan (nur Pecorino)
- Kein Eigelb allein (ganzes Ei!)
```
````

### Schritt 5: Bild des Gerichts

Füge ein Bild deines Gerichts hinzu (suche ein freies Bild auf Unsplash oder Pixabay):

```markdown
## Das fertige Gericht

![Spaghetti Carbonara](https://images.unsplash.com/photo-1612874742237-6526221588e3?w=600)
```

### Schritt 6: Nützliche Links

```markdown
## Weiterführende Links

- [Original Rezept auf GialloZafferano](https://www.giallozafferano.com/)
- [Mehr über italienische Küche](https://example.com)
```

---

## Hinweise

- Verschachtelte Listen müssen mit **2 oder 4 Leerzeichen** eingerückt werden (ein Tab geht auch)
- In Code-Blöcken wird keine Markdown-Syntax interpretiert — das ist der Sinn!
- Bilder von Unsplash: `https://images.unsplash.com/photo-...?w=600`
- Du kannst auch ein lokales Bild verwenden: `![Bild](mein_foto.jpg)`
- Prüfe die Vorschau mit `Cmd+Shift+V` in VS Code

## Erweiterung (optional)

1. Füge eine **Tabelle** mit Nährwerten hinzu (z.B. Kalorien, Protein, Fett pro Portion)
2. Erstelle einen Abschnitt "Variationen" mit einer Liste von Abwandlungen
3. Füge ein Zitat hinzu: `> "Ein guter Koch..."` (kommt nächste Woche!)
4. Erstelle eine **Checkliste** für die benötigten Küchenutensilien (kommt nächste Woche!)
