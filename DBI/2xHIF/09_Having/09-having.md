---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – HAVING
## DBI 2xHIF — Filtering Groups

---

## Agenda

1. The Problem with WHERE
2. HAVING Syntax
3. HAVING vs. WHERE
4. Putting It Together

---

## Learning Goals

- I know why aggregate functions can't be used in a `WHERE` clause
- I can filter groups with `HAVING`
- I know the difference between `WHERE` and `HAVING`
- I can combine `JOIN`, `WHERE`, `GROUP BY`, `HAVING`, and `ORDER BY` in the correct order

---

## The Problem with WHERE

You want to group students by class, but only show classes with **25 or more exams** and
an **average grade below 3**.

How do we do this?

**Problem:** aggregate functions don't work in `WHERE` clauses.

---

## HAVING — Syntax

```sql
SELECT ...
FROM ...
(WHERE ...)?
( GROUP BY <column> (, <column>)*
  ( HAVING <condition> (, <condition>)* )?
)?
(ORDER BY ...)?;
```

---

## HAVING vs. WHERE

**`WHERE`** filters your data **before** creating groups.

**`HAVING`** filters your **groups** — so it can only contain group (aggregate) functions.

---

## HAVING — Example

Classes with at least 25 exams and an average grade below 3:

```sql
SELECT k.K_Nr,
       COUNT(p.P_Kandidat) AS Pruefungsanzahl,
       AVG(p.P_Note) AS Notendurchschnitt
FROM Klasse k
    LEFT JOIN Schueler s ON k.K_Nr = s.S_Klasse
    LEFT JOIN Pruefung p ON p.P_Kandidat = s.S_Nr
GROUP BY k.K_Nr
HAVING COUNT(p.P_Kandidat) > 25 AND AVG(p.P_Note) < 3;
```

---

## Putting It Together

```sql
SELECT k.K_Nr,
       COUNT(p.P_Kandidat) AS Pruefungsanzahl,
       AVG(p.P_Note) AS Notendurchschnitt
FROM Klasse k
    LEFT JOIN Schueler s ON k.K_Nr = s.S_Klasse
    LEFT JOIN Pruefung p ON p.P_Kandidat = s.S_Nr
GROUP BY k.K_Nr
HAVING COUNT(p.P_Kandidat) > 25 AND AVG(p.P_Note) < 3
ORDER BY Notendurchschnitt ASC;
```

`JOIN` → `WHERE` → `GROUP BY` → `HAVING` → `ORDER BY` — the logical order matters.

---

<!-- _class: invert -->

## Summary

- `WHERE` filters rows before grouping; `HAVING` filters groups after grouping
- `HAVING` is required whenever a condition involves an aggregate function
- Clause order: `JOIN` → `WHERE` → `GROUP BY` → `HAVING` → `ORDER BY`
