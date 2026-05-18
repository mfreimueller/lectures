# Kata 1: Excel-Datenanalyse

## Ziel
Daten in Excel erfassen, mit Formeln auswerten und als aussagekräftige Diagramme darstellen können.

## Aufgabenstellung

Die <strong>TechZone GmbH</strong> – ein Onlineshop für Elektronik – möchte seine Verkaufszahlen des ersten Quartals analysieren. Erstelle eine Excel-Tabelle mit mindestens **20 Datensätzen** und werte sie aus.

Verwende das folgende Schema:

| Datum | Artikel | Kategorie | Menge | Einzelpreis (€) | Gesamtpreis (€) | Kunde | Bundesland |
|-------|---------|-----------|-------|-----------------|-----------------|-------|------------|
| 02.01.2025 | Notebook Pro 15 | Laptops | 2 | 1.299,00 | | Huber | Wien |
| 02.01.2025 | Wireless Mouse M1 | Zubehör | 5 | 29,90 | | Berger | NÖ |
| 03.01.2025 | USB-C Hub 7in1 | Zubehör | 3 | 49,90 | | Steiner | OÖ |
| … | … | … | … | … | | … | … |

Ergänze die Tabelle selbstständig auf mindestens **20 Zeilen** mit weiteren Artikeln und Daten.

### Teil 1: Berechnungen
1. Berechne den **Gesamtpreis** (Menge × Einzelpreis) in der Spalte "Gesamtpreis".
2. Berechne in einem separaten Bereich die **Summe**, den **Mittelwert** und das **Maximum** des Gesamtpreises.
3. Erstelle eine Spalte "Rabatt (€)": 5 % Rabatt auf den Gesamtpreis, wenn die Menge ≥ 3 beträgt, sonst 0 € (verwende **WENN**).
4. Erstelle eine Spalte "Zahlbetrag (€)" (Gesamtpreis − Rabatt).
5. Verwende **SUMMEWENN**, um den Gesamtumsatz pro Kategorie zu berechnen.
6. Verwende **SUMMEWENN**, um den Gesamtumsatz pro Bundesland zu berechnen.
7. Verwende **MITTELWERTWENN**, um den durchschnittlichen Zahlbetrag pro Kategorie zu ermitteln.

### Teil 2: Diagramme
1. Erstelle ein **gruppiertes Säulendiagramm**, das den Umsatz (Zahlbetrag) pro Kategorie zeigt.
   - Diagrammtitel: "Umsatz pro Kategorie – Q1 2025"
   - Achsenbeschriftungen: X = Kategorie, Y = Umsatz in €
   - Datenbeschriftungen über den Säulen

2. Erstelle ein **Kreisdiagramm**, das die Verteilung der Verkäufe (Anzahl der verkauften Stück) auf die Kategorien zeigt.
   - Diagrammtitel: "Verkaufsanteile nach Kategorie"
   - Prozentangaben als Datenbeschriftung

### Teil 3: Formatierung
1. Formatiere die Datentabelle als formatierte Tabelle (<kbd>Strg</kbd>+<kbd>T</kbd>).
2. Formatiere alle Geldbeträge im Format **Währung (€)** mit zwei Nachkommastellen.
3. Wende eine **Farbskala** auf die Spalte "Gesamtpreis" an (niedrig = rot, hoch = grün).
4. Richte die Diagramme ansprechend ein (Farben passend zum Thema, lesbare Schriftgröße).

## Hinweise
- Achte auf korrekte absolute Zellbezüge (z. B. für den Rabattsatz) mit <kbd>F4</kbd>.
- Speichere die Datei als <code>Nachname_Vorname_Excel.xlsx</code> – du brauchst sie für die nächsten Kata.
- Verwende passende, realistische Daten für die restlichen Zeilen (z. B. Tablet Pro, Gaming-Maus X2, Webcam HD, externe Festplatte usw.).
