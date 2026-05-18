# Kata 3: De Morgan

## Ziel
De Morgansche Gesetze anwenden, um logische Ausdrücke umzuformen.

## Aufgabenstellung
1. Wenden Sie die De Morganschen Gesetze auf folgende Ausdrücke an:
   - ¬(A ∧ B)
   - ¬(A ∨ B)
   - ¬(A ∧ ¬B)
   - ¬(¬A ∨ B)
2. Formen Sie die folgenden Ausdrücke so um, dass die Negation nur noch bei einzelnen Variablen steht:
   - ¬(A ∨ (B ∧ C))
   - ¬((A ∧ B) ∨ (C ∧ D))
   - ¬(¬A ∨ ¬B)
3. Vereinfachen Sie den Ausdruck ¬(x > 0 ∧ x < 10) und drücken Sie ihn als Bedingung in Java aus.

## Hinweise
- 1. De Morgan: ¬(A ∧ B) ≡ ¬A ∨ ¬B (NOT AND wird zu OR)
- 2. De Morgan: ¬(A ∨ B) ≡ ¬A ∧ ¬B (NOT OR wird zu AND)
- Wenden Sie die Gesetze schrittweise von außen nach innen an.
- ¬(¬A) ≡ A (Doppelnegation aufheben)
