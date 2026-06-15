# Große Übung: Notenspiegel

Erweitere die Notenverwaltung: Die Noten werden nicht fest codiert, sondern der Benutzer gibt sie ein (erst die Anzahl, dann die einzelnen Noten). Das Programm berechnet:

- Durchschnitt
- Minimum und Maximum
- Anzahl der Einser, Zweier, Dreier, Vierer, Fünfer
- Ob alle bestanden haben (keine Fünfer)

Verwende Arrays und `for`-Schleifen.

**Beispielablauf (Benutzereingaben fett):**

```
Wie viele Noten? 6
Note 1: 3
Note 2: 2
Note 3: 1
Note 4: 5
Note 5: 3
Note 6: 4

Notenspiegel:
Note 1: 1 mal
Note 2: 1 mal
Note 3: 2 mal
Note 4: 1 mal
Note 5: 1 mal

Durchschnitt: 3.0
Beste Note: 1
Schlechteste Note: 5
Alle bestanden? Nein (1 Fuenfer)
```

### Hinweise

- Frage zuerst nach der Anzahl der Noten.
- Erstelle ein Array mit dieser Größe: `int[] noten = new int[anzahl];`
- Befülle das Array mit einer Schleife.
- Für die Notenverteilung: Ein zweites Array mit 5 Plätzen (für Noten 1–5) oder 5 einzelne Variablen.
- Die Verteilung zählt, wie oft jede Note vorkommt.

### Erweiterung

- Gib zusätzlich die Noten in umgekehrter Reihenfolge aus.
- Gib aus, ob der Durchschnitt über oder unter 3,0 liegt.
- Sortiere die Noten mit Bubblesort und gib sie sortiert aus (Vorschau auf nächste Woche).
