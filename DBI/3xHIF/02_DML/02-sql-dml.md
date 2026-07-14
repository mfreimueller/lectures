---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – DML
## Data Manipulation Language · DBI 3xHIF

---

## Recap: DDL vs. DML vs. DQL

| Category | Purpose | Examples |
|---|---|---|
| **DDL** | Define / change the schema | `CREATE`, `DROP`, `ALTER`, `TRUNCATE` |
| **DML** | Manipulate data | `INSERT`, `UPDATE`, `DELETE` |
| **DQL** | Query data | `SELECT` |

Today: **DML**

---

## DML – Data Manipulation Language

- SQL commands used to work with the **data** inside tables
- Unlike DDL, DML does not change the table structure
- The three core commands: `INSERT`, `UPDATE`, `DELETE`

---

## List of DML Commands

- **INSERT** – add new rows to a table
- **UPDATE** – change existing rows
- **DELETE** – remove rows from a table

---

## SQL INSERT INTO Statement

```sql
INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);
```

```sql
INSERT INTO employees (name, department_id, salary)
VALUES ('Ada Lovelace', 3, 4200);
```

---

## INSERT INTO ... Without Column Names

```sql
INSERT INTO employees
VALUES (101, 'Ada Lovelace', 3, 4200);
```

- Works, but values must match the table's column **order exactly**
- Breaks silently if the table structure ever changes
- Prefer always naming the columns explicitly

---

## Inserting Multiple Rows

```sql
INSERT INTO employees (name, department_id, salary)
VALUES
    ('Ada Lovelace', 3, 4200),
    ('Alan Turing', 3, 4600),
    ('Grace Hopper', 1, 4900);
```

One statement, three new rows.

---

## SQL UPDATE Statement

```sql
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
```

```sql
UPDATE employees
SET salary = 4400
WHERE name = 'Ada Lovelace';
```

The `WHERE` clause decides **which** rows change.

---

## Common Mistake: UPDATE Without WHERE

```sql
UPDATE employees
SET salary = 4400;
```

- No `WHERE` clause → **every row** in the table is updated
- Always check your `WHERE` clause before running an `UPDATE`
- Good habit: run the equivalent `SELECT` first to preview affected rows

---

## SQL DELETE Statement

```sql
DELETE FROM table_name
WHERE condition;
```

```sql
DELETE FROM employees
WHERE name = 'Ada Lovelace';
```

The `WHERE` clause decides **which** rows are removed.

---

## Common Mistake: DELETE Without WHERE

```sql
DELETE FROM employees;
```

- No `WHERE` clause → **every row** is deleted
- The table itself still exists, just empty
- Same safety habit as `UPDATE`: preview with `SELECT` first

---

## DELETE vs. TRUNCATE

| | `DELETE FROM table` | `TRUNCATE TABLE table` |
|---|---|---|
| Type | DML | DDL |
| Can use `WHERE`? | Yes | No — always removes everything |
| Resets `AUTO_INCREMENT`? | No | Yes |

---

<!-- _class: invert -->

## Summary

- **DML** manipulates data: `INSERT`, `UPDATE`, `DELETE`
- `UPDATE` and `DELETE` **without** `WHERE` affect the entire table
- `DELETE` is DML (row-by-row); `TRUNCATE` is DDL (whole table, resets auto-increment)

**Next lecture:** DQL basics — SELECT, WHERE, JOINs, GROUP BY (comprehensive recap)
