# Kata 3: Zweierkomplement

## Ziel
Negative Zahlen im Zweierkomplement darstellen und erkennen.

## Aufgabenstellung
1. Bilde das Zweierkomplement (8 Bit) von:
   - -1
   - -12
   - -64
   - -127
   - -128
2. Welche Dezimalzahlen werden durch folgende 8-Bit-Zweierkomplement-Werte dargestellt?
   - 11111100
   - 10000001
   - 11110111
   - 10000000
3. Addiere im Zweierkomplement:
   - 0000 1101 + 1111 0011 (13 + (-13))
   - 0111 1111 + 0000 0001 (127 + 1)
   - Was passiert im zweiten Beispiel? Erkläre.

## Hinweise
- Zweierkomplement = bitweise invertieren + 1.
- Das MSB (Bit 7) zeigt das Vorzeichen an: 1 = negativ, 0 = positiv.
- Bei 8 Bit reicht der Wertebereich von -128 bis +127.
- Ein Überlauf kann auftreten, wenn das Ergebnis außerhalb des Wertebereichs liegt.
