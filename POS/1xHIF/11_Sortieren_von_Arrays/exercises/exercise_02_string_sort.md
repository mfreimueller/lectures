# Große Übung: String-Array sortieren

Statt `int`-Arrays soll ein `String`-Array (Namen von Schülern) mit Bubblesort sortiert werden. Verwende `compareTo` für den String-Vergleich. Gib das Array vor und nach dem Sortieren aus. Zusätzlich: Gib aus, ob das Array bereits sortiert war (d. h. ob Tauschvorgänge nötig waren).

**Beispielausgabe:**

```
Vorher: [Ben, Anna, Clara, Daniel, Eva]
Nachher: [Anna, Ben, Clara, Daniel, Eva]
Tauschvorgaenge: 2
War bereits sortiert? Nein
```

### Hinweise

- Erstelle ein String-Array mit mindestens 5 Namen.
- `compareTo` vergleicht Strings lexikografisch:
  - `str1.compareTo(str2) < 0` → str1 kommt vor str2
  - `str1.compareTo(str2) > 0` → str1 kommt nach str2
- Verwende Bubblesort wie bei int-Arrays, aber mit `compareTo` statt `>`.
- Zähle die Tauschvorgänge.
- Wenn 0 Tauschvorgänge: "War bereits sortiert: Ja".

### Erweiterung

- Frage den Benutzer nach den Namen (erst Anzahl, dann Namen eingeben).
- Sortiere absteigend (Z–A) mit `compareTo`.
- Gib nach jedem Durchlauf das Array aus (wie in der Visualisierungs-Übung).
