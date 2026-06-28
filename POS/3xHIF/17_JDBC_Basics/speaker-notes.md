# Speaker Notes — 17: JDBC Basics

**Woche 20** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (10 min)

- Reflection, Annotations, Bean Mapping
- **Frage:** Warum brauchen wir eine Datenbank? → Persistenz über Programmneustarts

## 1. JDBC-Architektur (20 min)

- **JDBC** = Java Database Connectivity
- **Schichten:**
  - DriverManager → Connection
  - Connection → Statement
  - Statement → ResultSet
- **PostgreSQL JDBC Driver:** `org.postgresql.Driver`
- **Connection URL:** `jdbc:postgresql://host:port/dbname`
- **Setup:** PostgreSQL lokal oder Docker starten

## 2. Connection & Statement (25 min)

- **Connection aufbauen:**
  ```java
  Connection conn = DriverManager.getConnection(url, user, password);
  ```
- **Statement erstellen:**
  ```java
  Statement stmt = conn.createStatement();
  ```
- **executeQuery()** → SELECT → ResultSet
- **executeUpdate()** → INSERT/UPDATE/DELETE → int (betroffene Zeilen)
- **Live Coding:** Verbindung aufbauen, Tabelle erstellen, Daten einfügen

## 3. ResultSet (25 min)

- **Navigation:** `next()` — Zeile für Zeile
- **Getter:** `getInt()`, `getString()`, `getBoolean()`, `getDate()`, `getTimestamp()`, `getBigDecimal()`
- **Spalten:** Per Index (1-basiert!) oder Name
- **Ressourcen-Management:** try-with-resources für Connection, Statement, ResultSet
- **Live Coding:** SELECT mit ResultSet durchlaufen, Objekte erstellen

## 4. CRUD komplett (25 min)

- **CREATE:** INSERT mit executeUpdate
- **READ:** SELECT mit ResultSet
- **UPDATE:** UPDATE mit executeUpdate
- **DELETE:** DELETE mit executeUpdate
- **SQLException handling:** getErrorCode(), getSQLState(), chained exceptions
- **Live Coding:** Komplette CRUD-Operationen für Article-Tabelle

## 5. Praxis-Übergang (10 min)

- Katas: K1 JDBC Connect, K2 CRUD, K3 Transactions
- PostgreSQL einrichten (lokal oder Docker)

## 6. Wrap-up (10 min)

- Nächste Woche: PreparedStatement & DAO Pattern
- Hausübung: JDBC CRUD für eigene Entität

---

## Häufige Fehler

- ResultSet-Spaltenindex: 1-basiert, NICHT 0-basiert!
- Ressourcen nicht geschlossen → Connection-Leaks
- try-with-resources vergessen → manuelles close() in finally
- SQLException nicht behandelt → Programm stürzt ab
- Connection-URL falsch → Connection refused
- executeQuery für INSERT verwendet → muss executeUpdate sein
