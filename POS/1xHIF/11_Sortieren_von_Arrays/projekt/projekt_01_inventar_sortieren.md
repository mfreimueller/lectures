# Jahresprojekt — Dungeon Crawler: Inventar sortieren

Das Inventar-Array des Spielers soll alphabetisch sortiert werden können. Der Spieler wählt im Menü "Inventar sortieren". Dann wird das Inventar mit Bubblesort sortiert und ausgegeben. Zusätzlich: Sortiere das Inventar nach Item-Länge (kurze Items zuerst).

### Aufgaben

1. Erweitere das Inventar aus Woche 10 um die Option "Inventar sortieren" (Option 3).

2. Implementiere Bubblesort für das String-Array:
   - Verwende `compareTo` für den String-Vergleich.
   - Tausche Elemente, wenn `items[j].compareTo(items[j+1]) > 0`.

3. Gib das Inventar vor und nach dem Sortieren aus.

4. **Zusatz:** Sortiere nach Item-Länge (statt alphabetisch):
   - Verwende `items[j].length() > items[j+1].length()` als Bedingung.
   - Kurze Items zuerst.

**Beispielablauf:**

```
=== INVENTAR ===
1. Inventar anzeigen
2. Item benutzen
3. Inventar sortieren
0. Zurueck

Auswahl: 3

Inventar vor dem Sortieren:
Schwert, Heiltrank, Schluessel, Fackel

Inventar nach alphabetischem Sortieren:
Fackel, Heiltrank, Schluessel, Schwert
```

### Hinweise

- Der Bubblesort funktioniert genau wie bei int-Arrays, nur mit `compareTo`.
- Für den Zusatz: Ändere die Vergleichsbedingung auf `length()`.
- Du kannst den Benutzer wählen lassen, ob alphabetisch oder nach Länge sortiert werden soll.
