# Speaker Notes — 11: Streams II (Collectors)

**Woche 13** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- Streams: filter, map, flatMap, reduce
- Lazy Evaluation, Terminal Operations
- **Frage:** Wann flatMap statt map? → Verschachtelte Strukturen aufbrechen

## 1. collect() mit Collectors (30 min)

- **toList(), toSet(), toMap()** — Sammeln in Collections
- **joining()** — Strings verketten mit Delimiter
- **toUnmodifiableList()** — Immutable Collections (Java 10+)
- **Live Coding:** Stream → Map gruppieren, Stream → String joinen

## 2. groupingBy (30 min)

- `groupingBy(classifier)` — Gruppieren nach Schlüssel
- **Downstream Collectors:**
  - `groupingBy(..., counting())` — Anzahl pro Gruppe
  - `groupingBy(..., summingInt())` — Summe pro Gruppe
  - `groupingBy(..., averagingInt())` — Durchschnitt
  - `groupingBy(..., mapping(..., toList()))` — Transformieren + Sammeln
- **Multi-level grouping:** `groupingBy(..., groupingBy(...))`
- **Live Coding:** Kunden nach Stadt gruppieren, Summe pro Stadt

## 3. partitioningBy (20 min)

- Binäre Aufteilung: true/false
- `partitioningBy(predicate)` → Map<Boolean, List<T>>
- **Vorteil:** Immer zwei Einträge (true + false), auch wenn leer
- **Downstream Collectors:** Wie groupingBy
- **Live Coding:** Premium vs. Normal-Kunden partitionieren

## 4. Custom Collector (15 min)

- `Collector.of(supplier, accumulator, combiner, finisher)`
- Wann nötig? → Spezielle Sammel-Logik
- Meistens: groupingBy + downstream reicht

## 5. Praxis-Übergang (10 min)

- Katas: K1 Custom Collector, K2 Collect Variants, K3 Multi-level Grouping, K4 groupingBy, K5 partitioningBy
- PLÜ 2 nächste Woche — Vorbereitung!

## 6. Wrap-up (10 min)

- Nächste Woche: PLÜ 2
- Stoff: Testing, TDD, SOLID, Streams
- Weihnachtspause danach

---

## Häufige Fehler

- `collect(toList())` statt `toList()` → veraltete API
- groupingBy mit falschem Classifier → unerwartete Gruppierung
- partitioningBy vs. filtering verwechselt → partitioning gibt immer 2 Gruppen
- Custom Collector zu komplex → erst groupingBy + downstream prüfen
- Stream nach collect() weiterverwenden → collect ist Terminal Operation
