# Speaker Notes — 16: Exercise Bean Mapping

**Woche 19** | **Theorie 2h | Praxis 3h** | **Typ: Übung**

---

## 0. Wiederholung (15 min)

- Reflection: Class<?>, Method.invoke, Field.get/set
- Annotations: @interface, @Retention, @Target, Runtime-Processing
- **Frage:** Wie funktioniert Jackson intern? → Reflection + Annotations

## 1. Übungseinleitung (15 min)

- Ziel: BeanMapper — generischer Objekt-Mapper
- **Wie MapStruct, aber selbst gebaut**
- **Features:**
  - Felder via Reflection kopieren (gleicher Name)
  - Typkonvertierung: int ↔ String, long ↔ Long, double ↔ Double
  - @Mapping-Annotation für Feld-Umbenennung
- **Verständnis:** Wie Hibernate, MapStruct, Dozer arbeiten intern

## 2. Kata 1: Basic BeanMapper (30 min)

- `BeanMapper.map(source, targetClass)`
- `getDeclaredFields()` durchlaufen
- `setAccessible(true)` für private Felder
- Felder nach Name matchen, Werte kopieren
- TDD: Einfache POJOs mappen

## 3. Kata 2: Type Converting BeanMapper (30 min)

- Automatische Typkonvertierung:
  - int → String: `String.valueOf(value)`
  - String → int: `Integer.parseInt(value)`
  - long ↔ Long, double ↔ Double, boolean ↔ Boolean
- switch-Expression für Typkonvertierung
- TDD: Konvertierungsfälle testen

## 4. Kata 3: Annotation BeanMapper (30 min)

- Custom @Mapping(source="...", target="...") Annotation
- Felder mit unterschiedlichen Namen mappen
- Custom Converter-Interface für spezielle Typen
- TDD: Annotation-gesteuertes Mapping testen

## 5. Besprechung (20 min)

- Musterlösungen zeigen
- Diskussion: Wie machen es echte Frameworks?
  - MapStruct: Compile-time Code Generation (schneller)
  - Dozer: Runtime Reflection (langsamer, flexibler)
  - Hibernate: Bytecode Enhancement

## 6. Wrap-up (10 min)

- Nächste Woche: JDBC Basics
- Abschluss Reflection-Phase

---

## Häufige Fehler

- `setAccessible(true)` vergessen → IllegalAccessException
- Typkonvertierung ohne Prüfung → NumberFormatException
- @Mapping-Annotation: Retention nicht auf RUNTIME → nicht lesbar
- Nur gleiche Namen mappen → Felder mit unterschiedlichen Namen ignoriert
- Performance: Reflection bei jeder Mapping-Operation → Class-Objekte cachen
