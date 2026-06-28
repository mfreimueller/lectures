# Speaker Notes — 15: Annotations

**Woche 18** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- Reflection: Class<?>, Method.invoke, Field.get/set, setAccessible
- **Frage:** Wo habt ihr Reflection schon gesehen? → Frameworks, IDEs

## 1. Annotation-Definition (25 min)

- `@interface` Syntax — wie Interface, aber mit `@`
- **Elemente:** Primitiven, String, Class, enum, Arrays, Defaults
- **Beispiel:**
  ```java
  public @interface LogExecutionTime {
      String value() default "";
      int thresholdMs() default 100;
  }
  ```
- **Live Coding:** @LogExecutionTime definieren

## 2. Meta-Annotations (20 min)

- **@Retention:** SOURCE (nur Compiler), CLASS (in .class), RUNTIME (zur Laufzeit)
- **@Target:** TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
- **@Repeatable:** Wiederholbare Annotationen (Container-Pattern)
- **@Inherited:** Vererbung auf Subklassen (nur für Klassen, nicht Interfaces)
- **Wichtig:** RUNTIME nötig für Reflection-Processing!

## 3. Runtime Processing (25 min)

- `isAnnotationPresent(Annotation.class)` — prüfen
- `getAnnotation(Annotation.class)` — Annotation lesen
- **Felder:** `field.isAnnotationPresent(...)`, `field.getAnnotation(...)`
- **Methoden:** `method.isAnnotationPresent(...)`, `method.getAnnotation(...)`
- **Live Coding:** Validator.validate() — @NotBlank, @MinLength prüfen

## 4. Real-World Examples (15 min)

- **JPA:** @Entity, @Column, @Id, @OneToMany
- **Jackson:** @JsonProperty, @JsonIgnore, @JsonFormat
- **JUnit:** @Test, @DisplayName, @Tag, @ParameterizedTest
- **Spring:** @Component, @Autowired, @RestController, @GetMapping
- **Diskussion:** Wie funktionieren diese Frameworks intern? → Reflection!

## 5. Praxis-Übergang (10 min)

- Katas: K1 ToStringProcessor, K2 LogExecution, K3 JSON Serializer
- **Großübung:** Flipped Classroom Mini-Framework — siehe exercise/README.md

## 6. Wrap-up (10 min)

- Nächste Woche: Bean Mapping Übung
- Hausübung: Eigene Annotation + Processor bauen

---

## Häufige Fehler

- @Retention vergessen → Standard ist CLASS, nicht RUNTIME!
- @Target falsch gesetzt → Annotation an falscher Stelle erlaubt
- `getAnnotation()` ohne `isAnnotationPresent()` → null möglich
- Repeatable-Annotation: Container-Annotation vergessen
- Reflection-Processing zu langsam → Caching der Class-Objekte
