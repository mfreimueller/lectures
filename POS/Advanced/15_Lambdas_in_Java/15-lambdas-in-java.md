---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 15 - Lambdas in Java
## POS - Advanced

---

## Agenda (1/2)

1. Was ist eine Lambda?
2. Functional Interfaces
3. Die wichtigsten Standard-FIs
4. Lambda-Syntax im Detail
5. Variable Capture & effectively final
6. Methodenreferenzen — 4 Arten
7. Methodenreferenzen — Praxisbeispiele

---

## Agenda (2/2)

8. Funktionskomposition
9. Lambda und this
10. Exception-Handling in Lambdas
11. Primitive Specializations
12. Currying mit Lambdas
13. Best Practices & Pitfalls

---

## Lernziele

- Ich kann Lambdas und funktionale Interfaces korrekt einsetzen
- Ich kenne die wichtigsten Standard-Functional-Interfaces
- Ich verstehe Variable Capture und effectively final
- Ich kann Methodenreferenzen und Funktionskomposition anwenden
- Ich kenne Best Practices und typische Pitfalls bei Lambdas

---

## Was ist eine Lambda?

- Kompakte Schreibweise für eine anonyme Funktion
- Ermöglicht funktionales Programmieren in Java (seit Java 8)
- Kann einer Variablen zugewiesen oder direkt übergeben werden

```java
// Anonyme Klasse
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked!");
    }
});

// Lambda
button.addActionListener(e -> System.out.println("Clicked!"));
```

---

## Functional Interfaces

- Ein Interface mit genau **einer** abstrakten Methode (SAM)
- Mit `@FunctionalInterface` annotiert (optional, aber empfohlen)

```java
@FunctionalInterface
interface Validator<T> {
    boolean isValid(T value);
    // Nur EINE abstrakte Methode erlaubt
}

// Lambda als Implementierung
Validator<String> nonEmpty = s -> s != null && !s.isEmpty();
```

---

## Die wichtigsten Standard-FIs

| Interface | Parameter | Rückgabe | Methode |
| --- | --- | --- | --- |
| Predicate<T> | T | boolean | test() |
| Consumer<T> | T | void | accept() |
| Function<T,R> | T | R | apply() |
| Supplier<T> | — | T | get() |
| UnaryOperator<T> | T | T | apply() |
| BinaryOperator<T> | T,T | T | apply() |

---

## Lambda-Syntax im Detail

```java
// Vollständige Form: (Parameter) -> { Rumpf }
(int x, int y) -> { return x + y; }

// Typ-Inferenz: Typen können weggelassen werden
(x, y) -> { return x + y; }

// Einzelner Ausdruck: return und {} können entfallen
(x, y) -> x + y

// Ein Parameter: Klammern optional
x -> x * x

// Keine Parameter: leere Klammern
() -> Math.random()

// Mehrere Anweisungen: Block mit return
s -> {
    String trimmed = s.trim();
    return trimmed.isEmpty() ? "default" : trimmed;
}
```

---

## Variable Capture & effectively final

- Lambdas können lokale Variablen der umschließenden Methode verwenden
- Diese müssen **effectively final** sein (seit Java 8)
- Eine Variable ist effectively final, wenn sie nach Initialisierung nicht mehr geändert wird

```java
String prefix = "User: ";  // effectively final
Function<String, String> greet = name -> prefix + name;

// NICHT erlaubt:
// prefix = "Admin: ";  // wurde Compiler-Fehler verursachen
```

<div class="highlight-box">
<p>Im Unterschied zu anonymen Klassen: <code>this</code> in Lambdas bezieht sich auf die umschließende Klasse, nicht auf die Lambda-Instanz.</p>
</div>

---

## Methodenreferenzen — 4 Arten

| Art | Syntax | Beispiel |
| --- | --- | --- |
| Statische Methode | Class::staticMethod | `Math::max` |
| Instanzmethode eines Objekts | instance::method | `System.out::println` |
| Instanzmethode einer Klasse | Class::instanceMethod | `String::length` |
| Konstruktor | Class::new | `ArrayList::new` |

```java
// Lambda vs. Methodenreferenz
names.stream().map(s -> s.toUpperCase())  // Lambda
names.stream().map(String::toUpperCase)   // Methodenreferenz

names.stream().map(s -> new Person(s))    // Lambda
names.stream().map(Person::new)           // Konstruktor-Referenz
```

---

## Methodenreferenzen — Praxisbeispiele

```java
// 1. Statische Methode
Stream.of(3, 7, 2, 9)
    .reduce(Integer::sum);  // Integer.sum(a, b)

// 2. Instanzmethode eines Objekts
names.forEach(System.out::println);

// 3. Instanzmethode einer Klasse (erstes Argument wird Empfänger)
List<String> sorted = names.stream()
    .sorted(String::compareToIgnoreCase)
    .toList();

// 4. Konstruktor
List<Person> people = names.stream()
    .map(Person::new)
    .toList();
```

---

## Funktionskomposition

```java
// Function: andThen, compose
Function<String, String> trim = String::trim;
Function<String, String> capitalize = s ->
    s.substring(0, 1).toUpperCase() + s.substring(1);

Function<String, String> format = trim.andThen(capitalize);
// format.apply("  hello  ") -> "Hello"

// compose ist die Umkehrung: f.compose(g) = f(g(x))
Function<String, String> format2 = capitalize.compose(trim);
// Gleiches Ergebnis

// Predicate: and, or, negate
Predicate<String> nonNull = Objects::nonNull;
Predicate<String> nonEmpty = s -> !s.isEmpty();
Predicate<String> valid = nonNull.and(nonEmpty);
// valid.test(null) -> false
```

---

## Lambda und this

```java
public class ButtonHandler {
    private String label = "Button";

    public void handle() {
        // Anonyme Klasse: this bezieht sich auf das匿名 Klassenobjekt
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(this.label);  // Compiler-Fehler!
            }
        };

        // Lambda: this bezieht sich auf ButtonHandler-Instanz
        Runnable r2 = () -> System.out.println(this.label);  // "Button"
    }
}
```

<div class="highlight-box">
<p><code>this</code> in einem Lambda verhält sich wie <code>this</code> in der umschließenden Methode!</p>
</div>

---

## Exception-Handling in Lambdas

```java
// Problem: Standard-FIs werfen keine checked exceptions
Function<String, String> readFile = path -> {
    // Compiler-Fehler: IOException ist checked!
    // return Files.readString(Path.of(path));
};

// Lösung 1: Checked exception in unchecked wrappen
Function<String, String> readFile = path -> {
    try {
        return Files.readString(Path.of(path));
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
};

// Lösung 2: Eigenes ThrowingFunction-Interface
@FunctionalInterface
interface ThrowingFunction<T, R> {
    R apply(T t) throws Exception;
}

static <T, R> Function<T, R> wrap(ThrowingFunction<T, R> fn) {
    return t -> {
        try {
            return fn.apply(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };
}

// Verwendung
Function<String, String> safeRead = wrap(
    path -> Files.readString(Path.of(path))
);
```

---

## Primitive Specializations

- Generische FIs (z. B. `Function<T,R>`) vermeiden Boxing/Unboxing
- Für primitive Typen gibt es spezialisierte Interfaces

```java
// Statt Boxing:
Function<Integer, Integer> f1 = x -> x * 2;  // Boxing!

// Mit primitiver Specialization:
IntUnaryOperator f2 = x -> x * 2;  // Kein Boxing!

// Weitere Beispiele:
IntPredicate    // int -> boolean
DoubleConsumer  // double -> void
ToIntFunction<String>  // String -> int (keine Rückgabe-Boxing)
IntFunction<String>    // int -> String (kein Parameter-Boxing)
```

<div class="highlight-box">
<p>Bei Performance-kritischen Operationen auf primitiven Streams immer primitive FIs bevorzugen!</p>
</div>

---

## Currying mit Lambdas

```java
// Currying: Eine Funktion mit mehreren Parametern wird in
// eine Kette von Funktionen mit je einem Parameter zerlegt.

// Uncurried:
Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;
// add.apply(3).apply(4) -> 7

// Praxisbeispiel: Konfigurierbare Validierung
Function<Integer, Predicate<String>> lengthValidator =
    maxLen -> s -> s.length() <= maxLen;

Predicate<String> max10 = lengthValidator.apply(10);
Predicate<String> max255 = lengthValidator.apply(255);

// Wiederverwendbare Bausteine
Function<String, Function<String, String>> prefixer =
    separator -> prefix -> name -> prefix + separator + name;

Function<String, String> greet = prefixer.apply(" ").apply("Hallo");
greet.apply("Welt");  // "Hallo Welt"
```

---

## Best Practices & Pitfalls

- **Lambdas für einfache Logik** — bei komplexer Logik: benannte Methode extrahieren
- **Seiteneffekte vermeiden** — Lambdas sollten idealerweise zustandslos sein
- **Keine mutable State von außen modifizieren** — Variable Capture ist read-only
- **Methodenreferenzen bevorzugen** wenn möglich (lesbarer)
- **Lambdas nicht serialisieren** — Serialisierung von Lambdas ist implementierungsabhängig
- **Stacktrace kann verwirren** — Lambdas erscheinen als synthetic Methoden

---

## Zusammenfassung

- Lambdas: kurze Schreibweise für anonyme Funktionen
- Functional Interfaces: @FunctionalInterface, Predicate, Function, Consumer, Supplier
- Variable Capture: nur effectively final Variablen
- Methodenreferenzen: 4 Arten — statisch, Instanz, Klasse, Konstruktor
- Komposition: andThen, compose, and, or, negate
- Exception-Handling: Wrapper-Pattern mit eigenem ThrowingFunction
- Primitive Specializations vermeiden Boxing
