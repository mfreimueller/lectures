# Speaker Notes — 14: Reflection

**Woche 17** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (10 min)

- CLI Todo App, Markdown Converter
- Streams, Records, sealed Classes, TDD
- **Frage:** Wie funktioniert JUnit intern? → Reflection!

## 1. Class<?> Objekt (25 min)

- Jede Klasse hat ein Class-Objekt zur Laufzeit
- **Erzeugung:** `MyClass.class`, `obj.getClass()`, `Class.forName("...")`
- **Inspektion:**
  - `getMethods()` / `getDeclaredMethods()` — public vs. alle
  - `getFields()` / `getDeclaredFields()` — public vs. alle
  - `getConstructors()` / `getDeclaredConstructors()`
- **Unterschied:** `get*()` = public (inkl. inherited), `getDeclared*()` = nur diese Klasse
- **Live Coding:** Class Inspector — alle Methoden/Felder einer Klasse auflisten

## 2. Dynamic Invocation (25 min)

- **Method.invoke(obj, args)** — Methode zur Laufzeit aufrufen
- **Constructor.newInstance(args)** — Objekt dynamisch erzeugen
- **Field.get(obj) / Field.set(obj, value)** — Felder lesen/schreiben
- **setAccessible(true)** — private Member zugreifbar machen
- **Modul-System:** `--add-opens` nötig für Java 9+
- **Live Coding:** Dynamischer Getter/Setter-Aufruf

## 3. Performance & Use Cases (15 min)

- Reflection ist langsamer als direkter Aufruf
- **Alternative:** MethodHandles, invokedynamic
- **Praktische Use Cases:**
  - Spring: @Autowired, @Component
  - JPA: @Entity, @Column
  - Jackson: @JsonProperty
  - JUnit: @Test

## 4. Praxis-Übergang (10 min)

- Katas: K1 Class Inspector, K2 Dynamic Getter/Setter, K3 Private Field Accessor

## 5. Wrap-up (10 min)

- Nächste Woche: Annotations
- Hausübung: Reflection-basierten Validator bauen

---

## Häufige Fehler

- `getMethods()` vs `getDeclaredMethods()` verwechselt → Methoden nicht gefunden
- `setAccessible(true)` vergessen → IllegalAccessException
- `Method.invoke()` mit falscher Objekt-Instanz → IllegalArgumentException
- Modul-System: `--add-opens` nicht gesetzt → InaccessibleObjectException
- Reflection für alles verwenden → Overhead, nur wo nötig
