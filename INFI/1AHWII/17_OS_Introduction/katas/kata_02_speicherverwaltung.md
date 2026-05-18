# KATA 2: Speicherverwaltung – Paging-Berechnung

**Dauer:** 20 Minuten

## Ziel
Paging-Mechanismen verstehen und praktische Berechnungen durchführen.

## Aufgaben

### Aufgabe 1: Grundlegende Berechnung (8 Min.)

Ein System verwendet Paging mit folgenden Parametern:
- Virtueller Adressraum: 32 Bit
- Seitengröße: 4 KiB (4096 Byte)
- Physischer Speicher: 512 MiB

Berechnen Sie:

a) Wie viele Bits werden für den **Offset** innerhalb einer Seite benötigt?
b) Wie viele Bits bleiben für die **Seitennummer** (VPN)?
c) Wie viele virtuelle Seiten kann ein Prozess maximal adressieren?
d) Wie viele physische Frames hat das System?

### Aufgabe 2: Adressübersetzung (7 Min.)

Gegeben sei eine Seitentabelle mit folgenden Einträgen:

| Virtuelle Seite | Frame-Nummer | Im Speicher? |
|-----------------|-------------|--------------|
| 0               | 12          | Ja           |
| 1               | –           | Nein (ausgelagert) |
| 2               | 7           | Ja           |
| 3               | 4           | Ja           |

Seitengröße: 4 KiB

Übersetzen Sie folgende virtuelle Adressen in physische Adressen oder geben Sie an, dass ein Page Fault auftritt:

a) Virtuelle Adresse `0x0000` (Seite 0, Offset 0)
b) Virtuelle Adresse `0x2400` (Hinweis: Berechnen Sie Seite und Offset)
c) Virtuelle Adresse `0x1000` (Seite 1, Offset 0)

### Aufgabe 3: Seitengrößen-Vergleich (5 Min.)

Ein Prozess greift sequenziell auf 64 KiB Daten zu. Vergleichen Sie die Anzahl der Page Faults bei:

a) Seitengröße 4 KiB
b) Seitengröße 64 KiB

Gehen Sie davon aus, dass zu Beginn keine Seite geladen ist und immer die gesamte Seite auf einmal geladen wird. Was ist der Vorteil einer größeren Seitengröße? Was ist der Nachteil?

---

## Lösungshinweise

**Aufgabe 1:**
a) 4 KiB = 2¹² → 12 Bits für Offset
b) 32 - 12 = 20 Bits für Seitennummer
c) 2²⁰ = 1.048.576 virtuelle Seiten
d) 512 MiB = 512 * 2²⁰ Byte = 2²⁹ Byte; Frame-Größe = 2¹² Byte → 2²⁹ / 2¹² = 2¹⁷ = 131.072 Frames

**Aufgabe 2:**
a) Frame 12, Offset 0 → 12 * 4096 + 0 = 0x3000 (da 12 × 4 KiB = 48 KiB = 0xC000)
   Korrekt: 12 × 0x1000 = 0xC000
b) 0x2400 = 9216 Byte. Seite = 9216 / 4096 = 2 (Seite 2), Offset = 9216 - 2*4096 = 1024 = 0x400 → Frame 7, 7*4096+1024 = 29696 = 0x7400
c) Seite 1 ist nicht im Speicher → **Page Fault**

**Aufgabe 3:**
a) 64 KiB / 4 KiB = 16 Seiten → bis zu 16 Page Faults
b) 64 KiB / 64 KiB = 1 Seite → 1 Page Fault
   Vorteil: Weniger Page Faults, geringerer Verwaltungsaufwand
   Nachteil: Höhere interne Fragmentierung, mehr Speicherverschwendung bei kleinem Datenzugriff
