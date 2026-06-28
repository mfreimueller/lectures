# Speaker Notes — 10: Streams I (Intermediate Operations)

**Woche 12** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- SOLID: SRP, OCP, LSP, ISP, DIP
- **Frage:** Wann Composition statt Vererbung? → LSP-Verletzungen vermeiden

## 1. Stream-Konzept (20 min)

- Stream = Datenverarbeitungspipeline, KEINE Datenstruktur
- **Drei Teile:**
  1. Source (List, Array, File, etc.)
  2. Intermediate Operations (lazy, verketten)
  3. Terminal Operation (trigger execution)
- **Lazy Evaluation:** Nichts passiert bis Terminal Operation
- Stream kann nur EINMAL verwendet werden
- **Live Coding:** Loop → Stream refactorn

## 2. Intermediate Operations (35 min)

- **filter(Predicate)** — Elemente filtern
- **map(Function)** — Transformieren
- **flatMap(Function)** — Verschachtelte Strukturen flach machen
- **distinct()** — Duplikate entfernen
- **sorted()** — Sortieren
- **peek(Consumer)** — Debugging (nicht für Seiteneffekte!)
- **Live Coding:** flatMap für verschachtelte Listen, map mit Method References

## 3. Terminal Operations (25 min)

- **forEach(Consumer)** — Iterieren (aber keine Seiteneffekte außerhalb!)
- **count()** — Anzahl zählen
- **anyMatch/allMatch/noneMatch(Predicate)** — Boolesche Checks
- **findFirst()/findAny()** — Erstes/beliebiges Element (Optional)
- **reduce(identity, accumulator, combiner)** — Aggregation
- **Live Coding:** reduce für Summe, Maximum, String-Verkettung

## 4. Streams vs. Loops (10 min)

- Wann Streams? → Datenverarbeitung, Transformation, Aggregation
- Wann Loops? → Seiteneffekte, komplexe Abbruchbedingungen
- Lesbarkeit > "coolness"

## 5. Praxis-Übergang (10 min)

- Katas: K1 Filter/Map, K2 Advanced flatMap, K3 flatMap, K4 Stream Debugging, K5 Reduce Pipeline

## 6. Wrap-up (10 min)

- Nächste Woche: Streams II — Collectors
- Hausübung: For-Schleifen durch Streams ersetzen

---

## Häufige Fehler

- Stream zweimal verwenden → IllegalStateException
- peek() für Seiteneffekte → nur für Debugging
- reduce ohne identity → falscher Startwert
- flatMap vs. map verwechselt → flatMap für Stream<Stream<T>> → Stream<T>
- Streams zu komplex → aufteilen in benannte Methoden
