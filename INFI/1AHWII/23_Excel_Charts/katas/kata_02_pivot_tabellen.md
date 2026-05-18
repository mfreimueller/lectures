# Kata 2: Pivot-Tabellen

## Ziel
Einen größeren Datensatz mit Pivot-Tabellen analysieren und mit Pivot-Charts visualisieren können.

## Aufgabenstellung

Erstelle folgende Tabelle mit Verkaufsdaten (mindestens 20 Zeilen):

```
Datum      | Region   | Produktkategorie | Produkt      | Verkäufer  | Menge | Stückpreis
02.01.2025 | Nord     | Elektronik       | Kopfhörer    | Meier      | 15    | 49,00
05.01.2025 | Süd      | Büro            | Drucker      | Berger     | 3     | 129,00
08.01.2025 | West     | Elektronik       | Laptop       | Fischer    | 2     | 899,00
...        | ...      | ...             | ...          | ...        | ...   | ...
```

Ergänze mindestens 3 Regionen, 3 Produktkategorien, 4 Verkäufer und Daten von Jänner bis März 2025.
Füge eine Spalte "Umsatz" (= Menge × Stückpreis) hinzu.

1. Erstelle eine **Pivot-Tabelle** mit:
   - **Zeilen**: Region
   - **Spalten**: Produktkategorie
   - **Werte**: Summe des Umsatzes
2. Erstelle eine zweite Pivot-Tabelle:
   - **Zeilen**: Monat (Datum gruppieren)
   - **Spalten**: Verkäufer
   - **Werte**: Anzahl der Verkäufe
3. Füge einen **Slicer** für die Region hinzu und filtere die Ansicht
4. Erstelle ein **Pivot-Chart** (gruppierte Säulen) aus der ersten Pivot-Tabelle
5. Gruppiere die Datumsangaben in der zweiten Pivot-Tabelle nach Monaten

## Hinweise
- Markiere alle Daten → Einfügen → Pivot-Tabelle
- Drag & Drop die Felder in Zeilen, Spalten, Werte, Filter
- Für den Slicer: Pivot-Tabelle → Analysieren → Slicer einfügen
- Datum gruppieren: Rechtsklick auf Datum in der Pivot-Tabelle → Gruppieren
- Achtung: Die Quelldaten als Tabelle formatieren (Strg+T) erleichtert Erweiterungen
