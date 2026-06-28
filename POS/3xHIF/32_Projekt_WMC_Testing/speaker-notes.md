# Speaker Notes — 32: Projekt WMC Testing

**Woche 36** | **Typ: Projekt — Sprint 5**

---

## 0. Check-in (15 min)

- Stand-up: API fertig?
- Probleme besprechen
- Nächste Ziele setzen

## 1. Fokus dieser Woche (10 min)

- **Testing & Integration**
- Service-Layer-Tests mit JUnit 5
- Integration-Tests mit H2
- Test-Coverage prüfen

## 2. Technische Guidance (20 min)

- **JUnit 5:** @Test, @BeforeEach, @ParameterizedTest
- **AssertJ:** Fluent Assertions
- **Mockito:** Service-Tests ohne DB
- **H2 für Integration-Tests:** create-drop schema
- **Test-Strategie:**
  - Unit-Tests für Service-Layer
  - Integration-Tests für Repository-Layer
  - Wenig bis keine Tests für Controller (HTTP-Logik)

## 3. Code Review (20 min)

- Tests reviewen
- Test-Coverage prüfen
- FIRST-Prinzipien anwenden

## 4. Arbeitsphase (2h)

- Schüler arbeiten eigenständig
- Individuelle Beratung bei Bedarf
- Check-in nach 1h: Fortschritt?

## 5. Wrap-up (15 min)

- Tests fertig?
- Nächste Woche: Finalisierung

---

## Häufige Probleme

- Keine Tests → Code-Qualität unbekannt
- Tests zu komplex → schwer zu warten
- Mockito falsch verwendet → Mock statt Real-Objekt
- Integration-Tests ohne Rollback → Test-Daten bleiben in DB
- Tests auf Implementation statt Verhalten → brittle
