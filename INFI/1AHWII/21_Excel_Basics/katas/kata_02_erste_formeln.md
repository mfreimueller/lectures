# Kata 2: Erste Formeln

## Ziel
Einfache Berechnungen mit Formeln in Excel durchführen können.

## Aufgabenstellung
Erstelle eine neue Arbeitsmappe und gib folgende Tabelle ab Zelle A1 ein:

| A | B | C | D |
|---|---|---|---|
| Artikel | Preis | Menge | Gesamt |
| Apfel | 1,20 | 10 | |
| Birne | 0,80 | 15 | |
| Banane | 1,50 | 8 | |
| Orange | 1,10 | 12 | |

1. Berechne in Zelle D2 die Gesamtsumme für Äpfel mit der Formel `=B2*C2`. Ziehe die Formel mit dem AutoAusfüllen-Kästchen nach unten bis D5.
2. Berechne in Zelle B7 den Mittelwert aller Preise mit `=MITTELWERT(B2:B5)`.
3. Berechne in Zelle C7 die Summe aller Mengen mit `=SUMME(C2:C5)`.
4. Berechne in Zelle B8 den günstigsten und in B9 den teuersten Preis mit MIN und MAX.
5. Verwende in Zelle D7 die Funktion `=SUMME(D2:D5)`, um den Gesamtumsatz zu berechnen.
6. Schreibe in Zelle A10 "Anzahl Artikel:" und in B10 die Anzahl der Einträge mit `=ANZAHL(B2:B5)`.

## Hinweise
- Achte auf das richtige Zahlenformat: Dezimaltrennzeichen ist in Excel standardmäßig das Beistrich (,) in der deutschen Version.
- Der Doppelpunkt (:) trennt den Anfang und das Ende eines Zellbereichs (z. B. A1:A10).
- Mit `=SUMME(B2:B5)` addierst du alle Werte von B2 bis B5.
- Wenn eine Formel einen Fehler anzeigt (#NAME?), überprüfe die Schreibweise der Funktion – Excel erwartet deutsche Funktionsnamen.
