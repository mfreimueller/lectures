---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – Aggregation
## DBI 2xHIF — Summarizing Data with Aggregate Functions

---

## Agenda

1. Aggregation
2. Aggregate Functions
3. COUNT in Detail

---

## Learning Goals

- I can explain what an aggregate function does
- I can use `COUNT`, `SUM`, `AVG`, `MIN`, and `MAX` in a `SELECT` statement
- I know why aggregate functions can't be freely mixed with plain columns
- I know the difference between `COUNT(column)` and `COUNT(*)`

---

## Aggregation

- How do we count the number of teachers?
- How do we find the highest salary?
- How do we calculate the average salary?

**Solution: aggregate functions**

> *aggregate, v.* — to combine into a single group or total

---

## Aggregation

For now, aggregate functions belong to the `SELECT` clause:

```sql
SELECT MAX(L_Eintrittsjahr)
FROM Lehrer;
```

They can be combined with `WHERE`, `JOIN`, and `ORDER BY`.

---

## Aggregation — A Rule to Remember

Use *either* aggregate functions *or* plain columns — not both at once.

This won't work:

```sql
SELECT MIN(S_Gebdat), S_Zuname
FROM Schueler;
```

Aggregate functions collapse your rows into a single group — there's no longer one row
per student to pair `S_Zuname` with (more on this in the `GROUP BY` lesson).

---

## Aggregate Functions

- **`SUM(column)`** — sum the values in the column
- **`AVG(column)`** — calculate the average for the column
- **`MIN(column)` / `MAX(column)`** — lowest/highest value; works for numbers, dates, and strings
- **`COUNT(column)`** — count the number of rows

---

## COUNT in Detail

**`COUNT(column)`**

Counts all rows where `column` is **not** `NULL`. Use this to count only non-null values.

**`COUNT(*)`**

Counts all rows, including those containing `NULL`. Use this to count everything.

---

<!-- _class: invert -->

## Summary

- Aggregate functions (`COUNT`, `SUM`, `AVG`, `MIN`, `MAX`) combine many rows into a single value
- Don't mix aggregate functions with plain columns in the same `SELECT` without `GROUP BY`
- `COUNT(column)` skips `NULL`s; `COUNT(*)` counts every row
