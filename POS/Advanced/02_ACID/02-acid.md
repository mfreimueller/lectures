---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 02 - ACID
## POS - Advanced

---

## Warum Transaktionen?

- Datenbankoperationen müssen zuverlässig sein
- Gleichzeitiger Zugriff vieler Benutzer
- Systemabstürze können jederzeit auftreten
- Transaktionen garantieren Datenintegritat

<div class="highlight-box">
<p>Eine Transaktion ist eine logische Einheit von Arbeitsschritten</p>
</div>

---

## Das ACID-Akronym

| Buchstabe | Eigenschaft | Bedeutung |
| --- | --- | --- |
| A | Atomicity | Alles oder nichts |
| C | Consistency | Von einem konsistenten in den nachsten |
| I | Isolation | Nebenlaufige Transaktionen stören sich nicht |
| D | Durability | Abgeschlossene Änderungen bleiben erhalten |

---

## Atomicity

- Eine Transaktion wird entweder vollständig ausgeführt (Commit) oder gar nicht (Rollback)
- Es gibt keinen Zwischenzustand

```java
BEGIN TRANSACTION;
  UPDATE Konto SET saldo = saldo - 100 WHERE id = 1;
  UPDATE Konto SET saldo = saldo + 100 WHERE id = 2;
COMMIT;
-- Bei Fehler: ROLLBACK
```

---

## Atomicity — Beispiel

```java
try {
    db.beginTransaction();
    kontoA.auszahlen(100);
    kontoB.einzahlen(100);  // Fehler hier?
    db.commit();
} catch (Exception e) {
    db.rollback(); // Konto A wird nicht belastet
}
```

Entweder beide Konten werden aktualisiert oder keines

---

## Consistency

- Vor und nach der Transaktion sind alle Integritätsbedingungen erfüllt
- Die Datenbank wechselt von einem konsistenten Zustand in den nachsten
- Beispiel: Kontostand darf nicht negativ werden

```sql
ALTER TABLE Konto ADD CONSTRAINT
  CHECK (saldo >= 0);
```

---

## Isolation — Übersicht

- Nebenlaufige Transaktionen durfen sich gegenseitig nicht beeinflussen
- In der Praxis gibt es Abstufungen

| Stufe | Dirty Read | Non-Repeatable Read | Phantom Read |
| --- | --- | --- | --- |
| Read Uncommitted | möglich | möglich | möglich |
| Read Committed | verhindert | möglich | möglich |
| Repeatable Read | verhindert | verhindert | möglich |
| Serializable | verhindert | verhindert | verhindert |

---

## Dirty Read

```java
// Transaktion A
UPDATE Konto SET saldo = 200 WHERE id = 1;
// Noch kein Commit!

// Transaktion B (Read Uncommitted)
SELECT saldo FROM Konto WHERE id = 1;
// Liest 200 (obwohl A noch nicht committed hat)
```

Rollback von A -> B hat ungültige Daten gelesen

---

## Non-Repeatable Read

```java
// Transaktion A
SELECT saldo FROM Konto WHERE id = 1; // 100

// Transaktion B
UPDATE Konto SET saldo = 50 WHERE id = 1; COMMIT;

// Transaktion A (erneut)
SELECT saldo FROM Konto WHERE id = 1; // 50 (anders!)
```

---

## Phantom Read

```java
// Transaktion A
SELECT COUNT(*) FROM Konto WHERE saldo > 0; // 5

// Transaktion B
INSERT INTO Konto VALUES (3, 300); COMMIT;

// Transaktion A (erneut)
SELECT COUNT(*) FROM Konto WHERE saldo > 0; // 6 (Phantom!)
```

---

## Durability

- Nach einem Commit sind die Änderungen dauerhaft gespeichert
- Auch bei Stromausfall oder Systemabsturz
- Wichtigster Mechanismus: Write-Ahead Logging (WAL)

<div class="highlight-box">
<p>WAL: Logeintrage werden VOR den Daten auf die Festplatte geschrieben</p>
</div>

---

## Write-Ahead Logging (WAL)

```java
// 1. Log-Eintrag schreiben (vor den Daten!)
log.write("BEGIN T1");
log.write("T1: Konto 1: 100 -> 0");
log.write("T1: Konto 2: 200 -> 300");
log.flush(); // Log auf Festplatte garantieren

// 2. Daten ändern
konto1.saldo = 0;
konto2.saldo = 300;

// 3. Commit vermerken
log.write("COMMIT T1");
log.flush();
```

Bei Absturz: Log wird beim Neustart abgespielt (Redo/Undo)

---

## Zusammenfassung

- ACID garantiert verlassliche Transaktionsverarbeitung
- Atomicity: Alles oder nichts (Commit/Rollback)
- Consistency: Integritätsbedingungen bleiben erhalten
- Isolation: Vier Stufen mit unterschiedlichen Anomalien
- Durability: WAL sichert Daten gegen Abstürze
- Nachste Lektion: Optimistic Locking
