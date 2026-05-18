# Kata 2: Taktrate und Leistung berechnen

## Ziel
Den Zusammenhang zwischen Taktrate, IPC (Instructions per Cycle) und der Gesamtleistung einer CPU verstehen.

## Aufgabenstellung
1. Berechne die theoretische Befehlsrate (Millionen Befehle pro Sekunde) für folgende CPUs:
   - CPU A: 3,0 GHz, 1.0 IPC
   - CPU B: 4,5 GHz, 0.8 IPC
   - CPU C: 2,5 GHz, 1.6 IPC
   - Hinweis: Befehlsrate (MIPS) = Taktrate (GHz) × IPC × 1000
2. Eine CPU hat 8 Kerne mit je 3,2 GHz und einem IPC von 1.2.
   - Berechne die Gesamtleistung (in MIPS) bei voller Auslastung aller Kerne.
3. Vergleiche zwei CPUs:
   - CPU X: 4,0 GHz, 0.9 IPC, 6 Kerne
   - CPU Y: 3,0 GHz, 1.5 IPC, 6 Kerne
   - Welche CPU ist insgesamt schneller? Berechne die Gesamt-MIPS.
4. Diskutiere: Warum ist ein höherer IPC nicht immer besser? Welche Rolle spielt die Software?

## Hinweise
- IPC = Instructions per Cycle (Befehle pro Takt)
- MIPS = Millionen Instruktionen pro Sekunde
- Höhere Taktrate ≠ automatisch höhere Leistung (Architektur, IPC, Kühlung)
