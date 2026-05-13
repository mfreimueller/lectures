# K2: @ToString Annotation Processor

| Feld | Wert |
|------|------|
| Konzepte | @interface, @Retention, @Target, annotation-processing, Field.get/set |
| Schwierigkeit | 2/5 |
| Dauer | ca. 25 min |

### Aufgabenstellung

Implementiere eine `@ToString` Annotation und einen Prozessor, der automatisch einen String-Repräsentation eines Objekts erzeugt.

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ToString {
    boolean includeFields() default true;
    String[] excludeFields() default {};
}
```

Schreibe eine `ToStringProcessor` Klasse mit einer Methode:
```java
public static String toString(Object obj) throws Exception
```

Der Prozessor soll:
1. Prüfen, ob die Klasse mit `@ToString` annotiert ist
2. Alle deklarierten Felder via Reflection lesen
3. Felder in `excludeFields()` überspringen
4. Wenn `includeFields=false`, nur den Klassennamen ausgeben
5. Einen String im Format `ClassName{field1=value1, field2=value2, ...}` erzeugen

### Beispiel-Output

```
Person{name=Alice, age=30}
```

### Erweiterung

Füge ein `@ToStringExclude` Annotation hinzu, die auf einzelne Felder angewendet werden kann, um sie von der Ausgabe auszuschließen, unabhängig von der Klassen-Annotation.
