# Kata 3: Excel-Projekt

## Ziel
Eine vollständige Aufgabenstellung selbstständig in Excel umsetzen – von der Dateneingabe über Berechnungen bis zur visuellen Aufbereitung.

## Aufgabenstellung

Ein kleiner Online-Shop möchte seine monatlichen Verkaufsdaten analysieren. Erstelle eine vollständige Excel-Arbeitsmappe mit den folgenden Teilaufgaben.

### Teil 1: Datenstruktur anlegen
Erstelle ein Tabellenblatt "Daten" mit folgenden Spalten:

| Bestell-ID | Datum | Kunde | Produkt | Kategorie | Menge | Einzelpreis (€) | Gesamtpreis (€) | Rabatt (€) | Zahlbetrag (€) |
|------------|-------|-------|---------|-----------|-------|-----------------|-----------------|------------|----------------|
| 1001 | 01.03.2025 | Maier | Laptop | Elektronik | 1 | 899,00 | | | |
| 1002 | 01.03.2025 | Berger | Maus | Elektronik | 3 | 29,90 | | | |
| 1003 | 02.03.2025 | Steiner | Buch | Bücher | 2 | 24,90 | | | |
| 1004 | 02.03.2025 | Maier | Tastatur | Elektronik | 1 | 79,90 | | | |
| 1005 | 03.03.2025 | Hofer | Buch | Bücher | 5 | 19,90 | | | |
| 1006 | 03.03.2025 | Berger | Laptop | Elektronik | 1 | 899,00 | | | |
| 1007 | 04.03.2025 | Steiner | Maus | Elektronik | 2 | 29,90 | | | |
| 1008 | 04.03.2025 | Hofer | Tastatur | Elektronik | 1 | 79,90 | | | |
| 1009 | 05.03.2025 | Maier | Buch | Bücher | 3 | 24,90 | | | |
| 1010 | 05.03.2025 | Berger | Buch | Bücher | 1 | 24,90 | | | |

### Teil 2: Berechnungen
1. Berechne den **Gesamtpreis** (Menge × Einzelpreis) in der Spalte "Gesamtpreis".
2. Der Rabatt beträgt 5 % des Gesamtpreises, wenn die Menge ≥ 3 ist, sonst 0 €. Verwende die Funktion **WENN**.
3. Berechne den **Zahlbetrag** (Gesamtpreis − Rabatt).
4. Erstelle eine zweite Tabelle (rechts daneben) mit **Teilergebnissen**:
   - Verwende die Funktion **SUMMEWENN**, um den Gesamtumsatz pro Kunde zu berechnen.
   - Verwende die Funktion **SUMMEWENN**, um den Gesamtumsatz pro Kategorie zu berechnen.
5. Verwende **SVERWEIS**, um zu einer Bestell-ID den Kundennamen und den Zahlbetrag auszulesen. Platziere dies in einem separaten Bereich.

### Teil 3: Diagramme
1. Erstelle ein **Kreisdiagramm**, das die Umsatzanteile der drei Kategorien zeigt.
2. Erstelle ein **Säulendiagramm**, das die Umsätze pro Kunde darstellt.
3. Füge Datenbeschriftungen und einen passenden Titel zu beiden Diagrammen hinzu.

### Teil 4: Datenanalyse mit Pivot
1. Erstelle eine **Pivot-Tabelle** auf einem neuen Tabellenblatt "Auswertung":
   - Zeilen: Kunde
   - Werte: Summe des Zahlbetrags
   - Zeilen: Produkt (als zweite Zeilenebene, unter Kunde)
2. Füge einen **Slicer** für die Kategorie hinzu.
3. Erstelle ein **Pivot-Chart** aus der Pivot-Tabelle (gruppierte Säulen).

### Teil 5: Formatierung
1. Formatiere die Tabelle als formatierte Tabelle (<kbd>Strg</kbd>+<kbd>T</kbd>).
2. Wende **bedingte Formatierung** an:
   - Alle Bestellungen mit einem Zahlbetrag über 500 € grün hervorheben.
   - Datenbalken in der Spalte "Menge".
3. Gestalte die Diagramme ansprechend (Farben, Titel, Achsen).

## Hinweise
- Arbeite strukturiert: Beginne mit Teil 1, dann Teil 2 usw.
- Speichere regelmäßig.
- Achte auf absolute Zellbezüge wo nötig (z. B. Rabattsatz, SVERWEIS-Matrix).
- Die Pivot-Tabelle sollte auf einem eigenen Blatt liegen.
