# Kata 1: Formeln & Funktionen

## Ziel
Excel-Formeln und -Funktionen sicher in praktischen Aufgaben anwenden können.

## Aufgabenstellung

Gegeben ist die folgende Tabelle einer Schulklasse. Erstelle diese Tabelle in Excel und berechne die angegebenen Werte.

| Name | Punkte | Bonus | Fehltage | Note |
|------|--------|-------|----------|------|
| Anna | 85 | 5 | 2 | |
| Ben | 42 | 3 | 5 | |
| Clara | 73 | 0 | 0 | |
| David | 58 | 8 | 1 | |
| Elena | 91 | 2 | 3 | |
| Felix | 33 | 10 | 7 | |
| Greta | 67 | 5 | 0 | |

1. Berechne die **Gesamtpunktzahl** (Punkte + Bonus) in einer neuen Spalte.
2. Verwende die Funktion **WENN**, um die Note zu bestimmen:
   - ≥ 90: "Sehr gut"
   - ≥ 75: "Gut"
   - ≥ 60: "Befriedigend"
   - ≥ 50: "Genügend"
   - < 50: "Nicht genügend"
3. Verwende die Funktion **WENN**, um in einer neuen Spalte den Status ("Bestanden" / "Durchgefallen") auszugeben. Bestanden ist, wer mindestens 50 Gesamtpunkte hat.
4. Verwende **UND** oder **ODER**, um in einer neuen Spalte auszugeben, wer "Gefährdet" ist (Gesamtpunktzahl < 60 ODER Fehltage > 5).
5. Berechne den **Durchschnitt** der Gesamtpunkte mit der Funktion **MITTELWERT**.
6. Verwende **SVERWEIS**, um zu einer eingegebenen Schülerzahl (1–7) automatisch den Namen und die Note auszugeben. Lege dazu eine kleine Hilfstabelle mit Schüler-ID, Name und Note an.
7. Verwende **WENNFEHLER**, um in der SVERWEIS-Formel einen Fehler abzufangen (z. B. falls eine ungültige ID eingegeben wird).

## Hinweise
- Achte auf die korrekte Verwendung von absoluten und relativen Zellbezügen.
- Die SVERWEIS-Tabelle sollte mit absoluten Bezügen (z. B. `$A$1:$C$8`) fixiert werden.
- Teste deine Formeln, indem du die Werte änderst und prüfst, ob sich die Ergebnisse korrekt aktualisieren.
