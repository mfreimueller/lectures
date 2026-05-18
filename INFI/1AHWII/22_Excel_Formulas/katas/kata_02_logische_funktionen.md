# Kata 2: Logische Funktionen

## Ziel
Logische Funktionen (WENN, UND, ODER) in praktischen Beispielen einsetzen können.

## Aufgabenstellung
Öffne eine neue Excel-Arbeitsmappe und lege folgende Tabelle an:

| A | B | C | D | E | F |
|---|----|----|----|----|----|
| **Name** | **Punkte** | **Anwesenheit** | **Projekt** | **Status** | **Prämie** |
| Anna Müller | 85 | Ja | 92 | | |
| Ben Weber | 42 | Ja | 55 | | |
| Clara Stein | 73 | Nein | 78 | | |
| David Koch | 91 | Ja | 88 | | |
| Emma Bauer | 38 | Ja | 45 | | |
| Finn Richter | 67 | Nein | 71 | | |

1. **Status (Spalte E):**
   - "Bestanden" wenn Punkte ≥ 50 UND Anwesenheit "Ja" ist
   - "Nicht bestanden" sonst
2. **Prämie (Spalte F):**
   - 100 € wenn (Punkte ≥ 80 ODER Projekt ≥ 85) UND Anwesenheit "Ja" ist
   - 50 € wenn Punkte ≥ 60 UND Anwesenheit "Ja" ist
   - 0 € sonst

## Hinweise
- Verwende WENN mit UND für den Status.
- Verwende eine verschachtelte WENN-Funktion mit UND/ODER für die Prämie.
- Achte auf die korrekte Syntax: `=WENN(UND(B2>=50; C2="Ja"); "Bestanden"; "Nicht bestanden")`

## Erweiterung
Füge eine zusätzliche Bedingung ein: Wenn das Projekt ≥ 90 ist, erhält die Person unabhängig von den Punkten automatisch den Status "Ausgezeichnet".
