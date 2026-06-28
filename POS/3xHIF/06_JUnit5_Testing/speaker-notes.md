# Speaker Notes — 06: JUnit 5 Testing

**Woche 8** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- PLÜ 1 Besprechung (falls bereits geschrieben)
- Moderne Java-Features: var, Records, Optional, switch, sealed, Text Blocks
- **Frage:** Warum testen? → Sicherheit bei Refactoring, Dokumentation, Qualität

## 1. JUnit 5 Grundlagen (30 min)

- **Annotationen:** `@Test`, `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll`
- **Test-Lifecycle:**
  - `@BeforeAll` → einmal vor allen Tests (static)
  - `@BeforeEach` → vor jedem Test
  - `@Test` → der eigentliche Test
  - `@AfterEach` → nach jedem Test
  - `@AfterAll` → einmal nach allen Tests (static)
- **Assertions:** `assertEquals`, `assertTrue`, `assertThrows`, `assertAll`
- **Live Coding:** Calculator-Tests mit Given/When/Then

## 2. AssertJ — Fluent Assertions (25 min)

- `assertThat(actual).isEqualTo(expected)`
- `assertThat(list).hasSize(3).contains("a")`
- `assertThat(obj).extracting("name").isEqualTo("Alice")`
- `assertThat(exception).isInstanceOf(IllegalArgumentException.class)`
- `assertAll()` für gruppierte Assertions
- **Live Coding:** ShoppingCart-Tests mit AssertJ

## 3. Parameterized Tests (25 min)

- `@ParameterizedTest` + `@ValueSource`, `@CsvSource`, `@CsvFileSource`, `@MethodSource`
- **Beispiel:**
  ```java
  @ParameterizedTest
  @CsvSource({"hello, 5", "world, 5", "", 0"})
  void testLength(String input, int expected) {
      assertThat(input.length()).isEqualTo(expected);
  }
  ```
- **Live Coding:** String-Utility mit parameterisierten Tests

## 4. Test-Best-Practices (15 min)

- One assertion per test (oder assertAll für zusammengehörige)
- Aussagekräftige Testnamen: `shouldReturnEmptyWhenListIsEmpty`
- Given/When/Then-Struktur
- Tests isolieren — keine Abhängigkeiten zwischen Tests
- **Ab jetzt in ALLEN Übungen:** Tests schreiben!

## 5. Praxis-Übergang (10 min)

- Katas: K1 Calculator Tests, K2 ShoppingCart Lifecycle, K3 Exception Testing, K4 Boundary Testing, K5 StringUtils Parameterized

## 6. Wrap-up (10 min)

- Nächste Woche: TDD — Red-Green-Refactor
- Hausübung: Bestehende Klasse testen, parameterisierte Tests

---

## Häufige Fehler

- `assertEquals(expected, actual)` → Reihenfolge vertauscht! (AssertJ: `assertThat(actual).isEqualTo(expected)`)
- `@BeforeAll` ohne `static` → wird nicht ausgeführt
- Tests mit Seiteneffekten → Reihenfolge-abhängig
- Zu viele Assertions in einem Test → unklar, was schiefging
- `assertThrows` ohne Lambda → falsche Syntax
