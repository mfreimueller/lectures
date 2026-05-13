# Kata 2: Query Builder

| Feld | Wert |
|------|------|
| Konzepte | Method Chaining, String Building, Fluent API |
| Schwierigkeit | 3/5 |
| Dauer | ca. 35 min |

## Aufgabenstellung

Implementieren Sie einen SQL-Query-Builder `QueryBuilder` mit Method Chaining. Der Builder soll folgende Methoden unterstutzen:

- `select(String... columns)` — Spalten auswahlen (Default: "*")
- `from(String table)` — Tabelle angeben
- `where(String condition)` — WHERE-Klausel
- `orderBy(String column, String direction)` — ORDER BY-Klausel (ASC/DESC)
- `build()` — gibt den fertigen SQL-String zuruck

### Beispiel-Output

```java
QueryBuilder qb = new QueryBuilder();
String query = qb.select("name", "age")
    .from("users")
    .where("age > 18")
    .orderBy("name", "ASC")
    .build();

System.out.println(query);
// SELECT name, age FROM users WHERE age > 18 ORDER BY name ASC
```

### Erweiterung

Fugen Sie Unterstutzung fur `limit(int n)` und `offset(int n)` hinzu. Die Methoden sollen ebenfalls Chaining unterstutzen und die Klauseln an der richtigen Position in der SQL-Abfrage einfugen.
