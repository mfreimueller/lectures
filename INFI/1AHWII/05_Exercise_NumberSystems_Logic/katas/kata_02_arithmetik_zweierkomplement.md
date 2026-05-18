# Kata 2: Arithmetik & Zweierkomplement

## Ziel
Das Rechnen mit Binärzahlen und die Darstellung negativer Zahlen im Zweierkomplement üben.

## Aufgabenstellung
1. Führe folgende binäre Additionen durch:
   - `1011_2 + 0110_2`
   - `1101_2 + 1010_2`
   - `0111_2 + 1001_2`

2. Stelle folgende Dezimalzahlen als 8-Bit-Zweierkomplement dar:
   - `-5_{10}`
   - `-42_{10}`
   - `-128_{10}`

3. Berechne die folgenden Subtraktionen mit dem Zweierkomplement (8 Bit):
   - `42 - 17`
   - `100 - 55`
   - `12 - 30`

## Hinweise
- Bei der Addition: $1+1 = 10$ (schreibe 0, übertrage 1).
- Zweierkomplement: Alle Bits invertieren (NOT), dann +1.
- Bei der Subtraktion mit Zweierkomplement: Subtrahend negieren (Zweierkomplement) und addieren.
- Ein eventueller neunter Bit (Überlauf) wird ignoriert.
