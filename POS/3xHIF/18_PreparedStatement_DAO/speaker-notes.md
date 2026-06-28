# Speaker Notes — 18: PreparedStatement & DAO

**Woche 21** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- JDBC: Connection, Statement, ResultSet, CRUD
- try-with-resources für Ressourcen-Management
- **Frage:** Was ist SQL Injection? → Sicherheitslücke durch String-Konkatenation

## 1. SQL Injection (20 min)

- **Problem:** `SELECT * FROM users WHERE name = '" + userInput + "'"`
- **Angriff:** `userInput = "' OR '1'='1"` → alle Datensätze
- **Demo:** SQL-Injection mit Statement zeigen
- **Lösung:** PreparedStatement mit Platzhaltern

## 2. PreparedStatement (25 min)

- **Parameterisierte Queries:** `?` Platzhalter
  ```java
  PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE name = ?");
  ps.setString(1, userInput);
  ```
- **Setter:** setString(), setInt(), setLong(), setDouble(), setDate(), setBoolean()
- **Batch Processing:** `addBatch()`, `executeBatch()`
- **Vorteile:** Sicherheit (kein SQL Injection), Performance (Pre-Compiled)
- **Live Coding:** Statement → PreparedStatement umbauen

## 3. DAO Pattern (30 min)

- **Data Access Object** — Abstraktionsschicht für Datenzugriff
- **Interface:**
  ```java
  public interface CustomerDao {
      Optional<Customer> findById(Long id);
      List<Customer> findAll();
      Customer save(Customer customer);
      void update(Customer customer);
      void delete(Long id);
  }
  ```
- **Implementierung:** JDBC-Code hinter Interface versteckt
- **Vorteil:** Testbarkeit, Austauschbarkeit, saubere Trennung
- **Live Coding:** CustomerDao implementieren

## 4. Praxis-Übergang (10 min)

- Katas: K1 SQL Injection Demo, K2 DAO Implementation, K3 Generic DAO

## 5. Wrap-up (10 min)

- Nächste Woche: JPA Entities & Relationships
- Hausübung: DAO für eigene Entität mit PreparedStatement

---

## Häufige Fehler

- PreparedStatement-Parameter-Index: 1-basiert!
- `setString` für int-Werte → SQL-Fehler
- Batch ohne executeBatch → nichts passiert
- DAO-Interface ohne Optional → null statt Optional.empty()
- SQL-Injection-Demo: Nur in sicherer Umgebung zeigen!
