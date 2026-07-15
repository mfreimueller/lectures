---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 16 - Java Streams - Advanced
## POS - Advanced

---

## Review: Stream-Grundlagen

- **3xHIF Lektion 10:** filter, map, flatMap, reduce
- **3xHIF Lektion 11:** toList, toSet, toMap, joining, groupingBy, partitioningBy
- **Lektion 15:** Lambdas — funktionale Interfaces, Methodenreferenzen

```java
// Typische Pipeline (bekannt)
List<String> result = people.stream()
    .filter(p -> p.age() >= 18)
    .map(Person::name)
    .sorted()
    .toList();
```

<div class="highlight-box">
<p>Heute: Was kommt danach? Parallelisierung, eigene Collectors, moderne Stream-APIs.</p>
</div>

---

## Parallel Streams

- `parallelStream()` statt `stream()` — nutzt den gemeinsamen ForkJoinPool
- Daten werden in Teilaufgaben zerlegt (Spliterator)
- Teilaufgaben werden parallel in mehreren Threads bearbeitet
- Ergebnisse werden wieder zusammengeführt

```java
// Sequentiell
long count1 = words.stream()
    .filter(w -> w.length() > 5)
    .count();

// Parallel (gleiche Pipeline, ein Methodenaufruf Unterschied)
long count2 = words.parallelStream()
    .filter(w -> w.length() > 5)
    .count();

// Oder: stream().parallel()
long count3 = words.stream()
    .parallel()
    .filter(w -> w.length() > 5)
    .count();
```

---

## Parallel Streams — Wann hilft es?

| Gut geeignet | Schlecht geeignet |
| --- | --- |
| Große Datenmengen (>10.000 Elemente) | Kleine Datenmengen (Overhead > Nutzen) |
| CPU-intensive Operationen (Berechnungen) | I/O-intensive Operationen (Datenbank, Files) |
| Unabhängige Elemente (keine gemeinsame mutable State) | Diese Abhängigkeit zwischen Elementen (sorted, distinct) |
| Gut splittbare Quellen (ArrayList, IntStream.range) | Schlecht splittbare Quellen (LinkedList, Iterator-basiert) |

<div class="highlight-box">
<p>Faustregel: Vor Parallelisierung immer messen! (Benchmark mit JMH)</p>
</div>

---

## Custom Collectors — Collector-Interface

```java
public interface Collector<T, A, R> {
    Supplier<A> supplier();       // neuen Behälter erzeugen
    BiConsumer<A, T> accumulator(); // Element hinzufügen
    BinaryOperator<A> combiner();   // Behälter zusammenführen
    Function<A, R> finisher();      // Behälter in Ergebnis umwandeln
    Set<Characteristics> characteristics(); // Eigenschaften
}

// Characteristics:
// - CONCURRENT: threadsicherer Akkumulator
// - IDENTITY_FINISH: finisher ist Identität (kann direkt verwendet werden)
// - UNORDERED: Reihenfolge der Elemente egal
```

---

## Custom Collector Beispiel: toHistogram

```java
public static <T> Collector<T, Map<T, Integer>, Map<T, Integer>>
       toHistogram() {
    return Collector.of(
        HashMap::new,                 // supplier
        (map, element) -> map.merge(element, 1, Integer::sum), // accumulator
        (m1, m2) -> {                 // combiner
            m2.forEach((k, v) -> m1.merge(k, v, Integer::sum));
            return m1;
        },
        Collector.Characteristics.IDENTITY_FINISH
    );
}

// Verwendung
Map<String, Integer> freq = words.stream()
    .collect(toHistogram());

// Oder mit groupingBy und downstream:
Map<String, Long> freq2 = words.stream()
    .collect(Collectors.groupingBy(
        Function.identity(), Collectors.counting()
    ));
```

---

## Advanced Collectors — teeing

`Collectors.teeing()` (Java 12+): Zwei Collectors parallel anwenden und Ergebnisse kombinieren.

```java
// Statistik aus einem Durchlauf: Summe und Anzahl
IntSummaryStatistics stats = numbers.stream()
    .collect(Collectors.teeing(
        Collectors.summingInt(i -> i),
        Collectors.counting(),
        (sum, count) -> {
            IntSummaryStatistics s = new IntSummaryStatistics();
            s.accept(sum.intValue());
            return s;
        }
    ));

// Elegant: Durchschnitt und Standardabweichung berechnen
record AvgAndStd(double average, double stdDev) {}

AvgAndStd result = numbers.stream()
    .collect(Collectors.teeing(
        Collectors.averagingDouble(i -> i),
        Collectors.mapping(i -> i * i, Collectors.averagingDouble(i -> i)),
        (avg, avgSq) -> new AvgAndStd(avg, Math.sqrt(avgSq - avg * avg))
    ));
```

---

## Advanced Collectors — filtering & flatMapping

```java
// filtering (Java 9+): filtert bevor der downstream-Collector sammelt
Map<String, List<Person>> adultsByCity = people.stream()
    .collect(Collectors.groupingBy(
        Person::city,
        Collectors.filtering(p -> p.age() >= 18, Collectors.toList())
    ));

// flatMapping (Java 9+): flatten bevor der downstream-Collector sammelt
Map<String, List<String>> wordsByCity = people.stream()
    .collect(Collectors.groupingBy(
        Person::city,
        Collectors.flatMapping(
            p -> Arrays.stream(p.bio().split("\\s+")),
            Collectors.toList()
        )
    ));

// Ohne flatMapping ware eine ZwischenMap nötig:
// person -> [wohnort, [woerter]] -> flatMap -> group
```

---

## takeWhile / dropWhile

- **takeWhile:** Nimm Elemente, solange das Prädikat true ist, dann brich ab
- **dropWhile:** Überspringe Elemente, solange das Prädikat true ist, dann nimm den Rest

```java
// takeWhile: Nimm solange Werte kleiner 10 sind
Stream.of(2, 4, 6, 8, 9, 12, 3)
    .takeWhile(n -> n < 10)
    .toList();
// Ergebnis: [2, 4, 6, 8, 9]

// dropWhile: Überspringe Werte kleiner 10, nimm den Rest
Stream.of(2, 4, 6, 8, 9, 12, 3)
    .dropWhile(n -> n < 10)
    .toList();
// Ergebnis: [12, 3]
```

<div class="highlight-box">
<p>Wichtig: takeWhile/dropWhile arbeiten auf der <strong>Reihenfolge</strong> der Stream-Quelle. Bei ungeordneten Quellen (z. B. HashSet) ist das Verhalten nicht deterministisch!</p>
</div>

---

## Stream-Quellen (Java 9+)

```java
// ofNullable: Optional-ahnlich, null-sicherer Stream
Stream.ofNullable(getMiddleName())
      .map(String::toUpperCase)
      .forEach(System.out::println);
// Liefert leeren Stream bei null, sonst Stream mit einem Element

// iterate mit Predicate (Java 9): Bedingung für Abbruch
Stream.iterate(0, n -> n < 100, n -> n + 1)
      .filter(n -> n % 2 == 0)
      .toList();
// Alte Variante (Java 8): kein Predicate -> unendlicher Stream
Stream.iterate(0, n -> n + 1).limit(100);

// concat: zwei Streams zusammenführen
Stream<String> abc = Stream.of("a", "b", "c");
Stream<String> xyz = Stream.of("x", "y", "z");
Stream.concat(abc, xyz).toList();  // [a, b, c, x, y, z]
```

---

## Primitive Streams

- IntStream, LongStream, DoubleStream — spezialisiert für primitive Typen
- Vermeiden Boxing/Unboxing — performanter

```java
// IntStream.range: inklusive/exklusive Grenzen
IntStream.range(0, 10)       // 0 bis 9
IntStream.rangeClosed(1, 10) // 1 bis 10

// Spezielle Operationen
int sum = IntStream.rangeClosed(1, 100).sum();
IntSummaryStatistics stats = IntStream.rangeClosed(1, 100)
    .summaryStatistics();
// stats.getSum(), getAverage(), getMin(), getMax(), getCount()

// Konvertierung: boxed(), mapToObj()
List<String> labels = IntStream.rangeClosed(1, 5)
    .mapToObj(i -> "Item #" + i)
    .toList();

// Primitive Streams erzeugen: mapToInt, mapToLong, mapToDouble
int totalAge = people.stream()
    .mapToInt(Person::age)
    .sum();
```

---

## Gatherers (Java 22+)

- Neues Feature (Preview in Java 22, finalized in Java 23+)
- Ermöglicht **custom Intermediate Operations** (bisher nur terminale Custom Collectors)

```java
// Integrierte Gatherer:
// - Gatherers.windowFixed(n): Fenster fester Größe
// - Gatherers.windowSliding(n): Überlappende Fenster
// - Gatherers.mapConcurrent(n): Parallele Verarbeitung mit max n Threads

// Beispiel: Feste Fenster
List<List<Integer>> windows = IntStream.rangeClosed(1, 10)
    .boxed()
    .gather(Gatherers.windowFixed(3))
    .toList();
// [[1,2,3], [4,5,6], [7,8,9], [10]]

// Beispiel: Eigener Gatherer (vereinfacht)
// Gatherer<T, A, R> mit initializer, integrator, combiner, finisher
```

<div class="highlight-box">
<p>Gatherers schließen die Lücke: Bisher nur custom Collectors (terminal), jetzt auch custom Intermediate Operations!</p>
</div>

---

## Stream-Pitfalls

- **Keine Wiederverwendung:** Ein Stream kann nur einmal konsumiert werden

```java
Stream<String> stream = names.stream();
stream.toList();  // OK
stream.toList();  // IllegalStateException: stream has already been operated upon or closed
```

- **Seiteneffekte in Lambdas vermeiden:** Lambdas sollten zustandslos sein

```java
// SCHLECHT: mutable externer State
List<String> result = new ArrayList<>();
stream.filter(s -> s.length() > 3)
      .forEach(result::add);  // Nicht threadsicher, nebenläufiges Problem!

// GUT: Collectors verwenden
List<String> result = stream
    .filter(s -> s.length() > 3)
    .toList();
```

- **Unendliche Streams:** Immer mit limit() oder short-circuit ops arbeiten
- **Parallel mit sorted/limit:** Kann teurer sein als sequentiell (Merge-Overhead)

---

## Zusammenfassung

- Parallel Streams: Ähnliche API, aber nicht immer schneller — messen!
- Custom Collectors: supplier, accumulator, combiner, finisher, characteristics
- Advanced Collectors: teeing (2 Ergebnisse parallel), filtering, flatMapping
- takeWhile/dropWhile: Stateful, aber nur auf geordneten Quellen deterministisch
- Primitive Streams: IntStream, LongStream, DoubleStream — kein Boxing
- Gatherers (Java 22+): Custom Intermediate Operations als Preview
- Pitfalls: Keine Wiederverwendung, keine Seiteneffekte, unendliche Streams begrenzen
