# Speaker Notes — 07: TDD & FIRST

**Woche 9** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- JUnit 5: @Test, Lifecycle, Assertions
- AssertJ: Fluent Assertions
- Parameterized Tests: @CsvSource, @ValueSource
- **Frage:** Wer hat letzte Woche Tests geschrieben? Welche Erfahrung?

## 1. TDD-Zyklus: Red-Green-Refactor (30 min)

- **RED:** Test schreiben, der fehlschlägt → beweist, dass Feature noch nicht existiert
- **GREEN:** Minimalste Implementierung, die den Test bestehen lässt
- **REFACTOR:** Code verbessern, während Tests grün bleiben
- **Baby Steps:** Nur eine Änderung auf einmal
- **Live Coding:** FizzBuzz im TDD — Schritt für Schritt zeigen

## 2. FIRST-Prinzipien (20 min)

- **F**ast — Tests müssen schnell sein (< 1s pro Test)
- **I**solated — Keine Abhängigkeiten zwischen Tests
- **R**epeatable — Immer gleiches Ergebnis, egal wo/wann
- **S**elf-validating — Test sagt klar: PASS oder FAIL
- **T**imely — Test VOR dem Code schreiben

## 3. String Calculator Kata (30 min)

- Regeln schrittweise einführen:
  1. Leerer String → 0
  2. Eine Zahl → diese Zahl
  3. Zwei Zahlen, Komma-getrennt → Summe
  4. Beliebig viele Zahlen → Summe
  5. Neue Zeilen als Trenner
  6. Negativzahlen → Exception
- **Live Coding:** TDD-Demo mit String Calculator
- Pair Programming: Driver/Navigator

## 4. TDD-Pitfalls (15 min)

- Zu viel Code in Green → nur das Nötigste implementieren
- Refactor-Schritt überspringen → Code wird unleserlich
- Zu große Tests → Baby Steps!
- Tests auf Implementation statt auf Verhalten → brittle Tests
- Mockito für Test-Isolation → Dependencies mocken

## 5. Praxis-Übergang (10 min)

- Katas: K1 String Calculator, K2 Roman Numerals, K3 Prime Factors, K4 TDD Mockito, K5 FizzBuzz
- TDD-Regel: Kein Produktionscode ohne roten Test!

## 6. Wrap-up (10 min)

- Nächste Woche: SOLID I (SRP, OCP)
- Hausübung: Eine Kata im TDD-Stil abschließen

---

## Häufige Fehler

- Green-Phase zu lang → Over-Engineering
- Refactor-Phase übersprungen → technische Schulden
- Tests zu komplex → schwer zu warten
- Mockito falsch verwendet → Mock statt Real-Objekt
- TDD als "Tests schreiben" missverstanden → TDD ist Design-Tool, nicht Test-Tool
