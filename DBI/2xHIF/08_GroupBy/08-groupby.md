---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – GROUP BY
## DBI 2xHIF — Grouping Rows Before Aggregating

---

## Agenda

1. GROUP BY
2. Aggregation with GROUP BY

---

## Learning Goals

- I can explain what `GROUP BY` does to a result set
- I can only select columns that are part of the grouping (or wrapped in an aggregate function)
- I can combine `GROUP BY` with `COUNT`, `SUM`, `AVG`, `MIN`, and `MAX`

---

## GROUP BY

Groups rows by one or more attributes (columns).

**Example:** group all students by their gender.

- Returns *n* groups (one per gender)
- Doesn't return any individual rows anymore — just the groups

---

## GROUP BY — Syntax

```sql
SELECT ...
FROM ...
(WHERE ...)?
(GROUP BY <column> (, <column>)*)?;
```

```sql
SELECT L_Gehalt
FROM Lehrer
GROUP BY L_Gehalt;
```

---

## GROUP BY — A Rule to Remember

You can only select columns that are part of your `GROUP BY` — every other column must be
wrapped in an aggregate function.

```sql
-- this fails: S_Zuname is neither grouped nor aggregated
SELECT S_Klasse, S_Zuname
FROM Schueler
GROUP BY S_Klasse;
```

---

## Aggregation

Typically, groups are combined with aggregate (group) functions:

- `COUNT()`
- `MIN()`
- `MAX()`
- `SUM()`
- `AVG()`

---

## Aggregation — Example

Group students by gender and count how many students are in each group:

```sql
SELECT S_Geschlecht, COUNT(*) AS Anzahl_Schueler
FROM Schueler
GROUP BY S_Geschlecht;
```

---

## Aggregate Functions Without GROUP BY

Placing an aggregate function in `SELECT` without a `GROUP BY` treats the **whole table**
as a single group:

```sql
SELECT COUNT(*) AS Anzahl FROM Schueler;
```

```sql
SELECT COUNT(*) AS Anzahl,
       MAX(S_Gebdatum) AS Juengster,
       MIN(S_Gebdatum) AS Aeltester
FROM Schueler;
```

---

## Aggregate Functions — What Does This Do?

```sql
SELECT S_Vorname, COUNT(S_Vorname) AS Anz
FROM Schueler
GROUP BY S_Vorname
ORDER BY Anz DESC;
```

---

<!-- _class: invert -->

## Summary

- `GROUP BY` collapses rows into groups, one per distinct combination of the grouped columns
- Every selected column must either be grouped or wrapped in an aggregate function
- Aggregate functions without `GROUP BY` treat the entire result set as one group
