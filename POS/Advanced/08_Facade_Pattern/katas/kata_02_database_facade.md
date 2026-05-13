# Kata 2: Database Facade

| Feld | Wert |
|------|------|
| Konzepte | Facade, JDBC, Ressourcenverwaltung |
| Schwierigkeit | 3/5 |
| Dauer | ca. 35 min |

## Aufgabenstellung

Implementieren Sie eine `Database`-Facade, die den gesamten JDBC-Boilerplate-Code kapselt. Die Facade soll folgende Methoden bereitstellen:

1. `Database(String url, String user, String password)` — Verbindungskonfiguration
2. `<T> List<T> query(String sql, RowMapper<T> mapper, Object... params)` — fuhrt ein SELECT aus und mappt Ergebnisse
3. `int executeUpdate(String sql, Object... params)` — fuhrt INSERT/UPDATE/DELETE aus
4. `void close()` — schliest die Verbindung

Erstellen Sie ein funktionales Interface `RowMapper<T>` mit der Methode `T mapRow(ResultSet rs)`.

Verwenden Sie H2 im In-Memory-Modus fur einen funktionsfahigen Test (oder simulieren Sie die Datenbankzugriffe mit System.out.println).

### Beispiel-Output

```
Database db = new Database("jdbc:h2:mem:test", "sa", "");
db.executeUpdate("CREATE TABLE users (id INT, name VARCHAR)");
db.executeUpdate("INSERT INTO users VALUES (?, ?)", 1, "Alice");
db.executeUpdate("INSERT INTO users VALUES (?, ?)", 2, "Bob");

List<String> names = db.query(
    "SELECT * FROM users",
    rs -> rs.getString("name")
);
System.out.println(names);  // [Alice, Bob]

db.close();
```

### Erweiterung

Fugen Sie `transactional(Supplier<T> operation)` hinzu, die eine Operation in einer Transaktion ausfuhrt und bei Erfolg committed, bei Fehler rollbackt.
