---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – Basic SELECT
## Querying Data · DBI 2xHIF

---

## Agenda

1. The SchulDb Schema
2. The SELECT Statement
3. General SELECT Syntax
4. WHERE — Comparison Operators
5. WHERE — Combining Conditions
6. WHERE — Pattern Matching with LIKE
7. NULL vs. Zero
8. ORDER BY

---

## Learning Goals

- I can write a `SELECT` statement to retrieve specific columns from a table
- I can filter rows with `WHERE` using comparison operators, `AND`/`OR`/`NOT`, `BETWEEN`, `IN`, and `LIKE`
- I know that `NULL` and `0` are not the same thing
- I can sort results with `ORDER BY`, ascending or descending, across multiple columns

---

## The SchulDb Schema

This course works against the school's own database, **SchulDb** — the same database you query live in SSMS/DBeaver.

| Table | Contains |
|---|---|
| `Lehrer` | teachers |
| `Schueler` | students |
| `Klasse` | classes |
| `Stunde` | timetable entries |
| `Pruefung` | exams |

Column names follow a prefix convention, e.g. `L_Name`, `S_Zuname`, `K_Nr`.

---

## The SELECT Statement

```sql
SELECT column1, column2, ...
FROM table_name;
```

```sql
SELECT L_Vorname, L_Name
FROM Lehrer;
```

`SELECT *` returns every column — fine for exploring, avoid in real code.

---

## Tool-Generated SELECT

SSMS generates this when you right-click a table → "Select Top 1000 Rows":

```sql
SELECT TOP (1000) L_Nr, L_Name, L_Vorname, L_Gehalt
FROM SchulDb.dbo.Lehrer;
```

- `TOP (1000)` — SQL Server-specific, limits the result to 1000 rows
- `SchulDb.dbo.Lehrer` — fully qualified as `<database>.<schema>.<table>`

---

## General SELECT Syntax

```sql
SELECT <columns>
FROM <table>
WHERE <conditions>
GROUP BY <columns>
ORDER BY <columns>
```

Today: `SELECT`, `FROM`, `WHERE`, `ORDER BY` — `GROUP BY` follows in a later lesson.

---

## WHERE — Comparison Operators

```sql
SELECT L_Name
FROM Lehrer
WHERE L_Gehalt < 3000;
```

- `=`, `<>`, `<`, `>`, `<=`, `>=`
- `WHERE` filters **rows**, evaluated before the result set is built

---

## WHERE — Combining Conditions

```sql
SELECT L_Name
FROM Lehrer
WHERE L_Name LIKE 'F%' AND L_Gehalt > 2000;
```

- `AND`, `OR`, `NOT` combine conditions
- `WHERE L_Chef = 'HEB'` — exact match
- `WHERE L_Eintrittsjahr BETWEEN 1999 AND 2010` — inclusive range
- `WHERE L_Chef IN ('HEB', 'MUE', 'KOW')` — matches any value in a list

---

## WHERE — Pattern Matching with LIKE

```sql
SELECT L_Nr
FROM Lehrer
WHERE L_Nr LIKE '%Z';
```

- `%` — any number of characters (including none)
- `_` — exactly one character
- Use `LIKE` for text; comparison operators for numbers

---

## NULL vs. Zero

```sql
SELECT L_Name
FROM Lehrer
WHERE L_Sprechstunde IS NULL;
```

- `NULL` means "unknown" — it is **not** the same as `0` or an empty string
- `column = NULL` never matches — always use `IS NULL` / `IS NOT NULL`

---

## ORDER BY

```sql
SELECT L_Name, L_Gehalt
FROM Lehrer
ORDER BY L_Gehalt DESC;
```

```sql
SELECT S_Zuname, S_Vorname
FROM Schueler
ORDER BY S_Zuname, S_Vorname;
```

Default direction is `ASC`. Sort by multiple columns left to right.

---

<!-- _class: invert -->

## Summary

- `SELECT columns FROM table` — fully qualified as `database.schema.table`
- `WHERE` filters rows: comparison operators, `AND`/`OR`/`NOT`, `BETWEEN`, `IN`, `LIKE`
- `NULL` is unknown, not zero — always use `IS NULL`
- `ORDER BY` sorts results, `ASC` by default, left to right across columns
