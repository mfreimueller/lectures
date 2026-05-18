# Kata 3: Suchen & Verweisen

## Ziel
SVERWEIS und XVERWEIS für Tabellensuchen in Excel verwenden können.

## Aufgabenstellung
Öffne eine neue Excel-Arbeitsmappe und lege zwei Tabellen an.

### Tabelle 1 – Artikelstamm (A1:D6)

| A | B | C | D |
|---|----|----|----|
| **Artikel-ID** | **Bezeichnung** | **Kategorie** | **Preis** |
| A-101 | Tastatur | Eingabe | 45,00 € |
| A-102 | Maus | Eingabe | 25,00 € |
| A-103 | Monitor | Ausgabe | 299,00 € |
| A-104 | Drucker | Ausgabe | 149,00 € |
| A-105 | Headset | Audio | 79,00 € |

### Tabelle 2 – Bestellungen (ab A8)

| A | B | C | D |
|---|----|----|----|
| **Bestell-ID** | **Artikel-ID** | **Menge** | **Gesamtpreis** |
| B-001 | A-103 | 2 | |
| B-002 | A-101 | 5 | |
| B-003 | A-105 | 1 | |
| B-004 | A-104 | 3 | |
| B-005 | A-102 | 10 | |

1. Verwende SVERWEIS, um in Spalte D den Gesamtpreis (Menge × Preis) zu berechnen.
   - Suche die Artikel-ID aus Spalte B in Tabelle 1
   - Gib den Preis aus Spalte D von Tabelle 1 zurück
   - Multipliziere mit der Menge aus Spalte C
2. Verwende XVERWEIS, um in einer neuen Spalte E die Bezeichnung des Artikels anzuzeigen.
3. Verwende XVERWEIS, um in einer neuen Spalte F die Kategorie des Artikels anzuzeigen.

## Hinweise
- Vergiss nicht den Parameter `Bereich_Verweis = 0` (FALSCH) beim SVERWEIS für genaue Übereinstimmung.
- Verwende absolute Bezüge für den Tabellenbereich (z. B. `$A$1:$D$6`).
- XVERWEIS benötigt getrennte Such- und Rückgabematrix: `=XVERWEIS(B2; $A$2:$A$6; $B$2:$B$6)`.

## Erweiterung
Was passiert, wenn eine Artikel-ID in Tabelle 2 nicht in Tabelle 1 vorkommt? Verwende WENNFEHLER, um in diesem Fall "Unbekannter Artikel" anzuzeigen.
