# Kata 3: Bedingte Formatierung

## Ziel
Daten mit Farbskalen, Datenbalken, Symbolsätzen und Formelregeln visuell aufbereiten können.

## Aufgabenstellung

Erstelle eine Notentabelle für 15 Schüler mit folgenden Fächern:

```
Schüler | Deutsch | Englisch | Mathematik | Informatik | Durchschnitt
Anna    | 1       | 2        | 3          | 1          | 1,75
Ben     | 3       | 2        | 4          | 3          | 3,00
...     | ...     | ...      | ...        | ...        | ...
```

1. **Farbskala** auf die Noten (1–5) anwenden:
   - Rot (schlecht, 4–5) → Gelb → Grün (gut, 1)
2. **Datenbalken** auf die Durchschnittsspalte anwenden
3. **Symbolsatz** (Ampeln) auf die Informatik-Noten:
   - Grün: 1–2, Gelb: 3, Rot: 4–5
4. **Formelregel**: Hebe die gesamte Zeile hervor, wenn der Durchschnitt ≤ 2,0 ist (grün hinterlegt)
5. **Formelregel**: Hebe die gesamte Zeile hervor, wenn mindestens eine Note 5 ist (rot hinterlegt)
6. **Formelregel**: Markiere jeden Schüler, der in Mathematik besser ist als in Englisch

## Hinweise
- Start → Bedingte Formatierung → Farbskala / Datenbalken / Symbolsätze / Neue Regel
- Für Zeilen hervorheben: Formel verwenden mit gemischten Bezügen (z. B. `=ODE.&#36;A2="Kriterium"`)
- Achte auf absolute/relative Bezüge (&#36;E spalte fixieren)
- Mehrere Regeln überlagern sich – Priorität im Regelmanager anpassen
- Die Durchschnittswerte kannst du mit MITTELWERT() berechnen
