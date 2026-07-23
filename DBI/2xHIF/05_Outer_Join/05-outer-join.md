---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – OUTER JOIN
## DBI 2xHIF — Keeping Rows Without a Match

---

## Agenda

1. Introduction
2. Syntax
3. Example
4. INNER vs. OUTER JOIN
5. Frequent Use Case

---

## Learning Goals

- I can explain why `INNER JOIN` sometimes loses rows I want to keep
- I can write a `LEFT`/`RIGHT OUTER JOIN`
- I can decide when to use `INNER JOIN` vs. `OUTER JOIN`
- I can find rows in one table that have no match in another

---

## Introduction

Remember: a join combines data from multiple tables.

**Problem:** `INNER JOIN` only returns the *intersection* between tables — rows without a
match on the other side disappear entirely.

**Example task:** return **all** teachers, and — if they are a KV — the name of their class too.

---

## Introduction

**Solution: `OUTER JOIN`**

An outer join returns the intersection between A and B, **plus** all remaining rows from
either table A (`LEFT JOIN`) or table B (`RIGHT JOIN`).

---

## Syntax

```sql
SELECT ...
FROM ...
    (LEFT | RIGHT) (OUTER)? JOIN <table name>
        ON <condition>
WHERE ...
```

- `ON` specifies the join condition
- You can combine `OUTER` and `INNER JOIN` clauses in the same query

---

## Example

Select the names of all teachers and, if they are a KV, the name of their class too:

```sql
SELECT l.L_Name, k.K_Nr
FROM Lehrer l
LEFT OUTER JOIN Klasse k
    ON k.K_Vorstand = l.L_Nr;
```

---

## Example — Result

| L_Name | K_Nr |
|---|---|
| Müller | 2AHIF |
| Kramer | 2BHIF |
| Novak | *(NULL)* |

Every teacher survives — `Novak` (not a KV) simply gets `NULL` for `K_Nr`, instead of
being dropped like it would be with `INNER JOIN`.

---

## INNER vs. OUTER JOIN

- Use `INNER JOIN` when you only want rows that match a foreign key (e.g. all teachers that *are* a KV)
- Use `OUTER JOIN` when you want all rows, plus extra information *if* it's available (e.g. all teachers, and their class *if* they're a KV)
- `LEFT` vs. `RIGHT` is just a matter of which table you list first — pick whichever reads more naturally

---

## Frequent Use Case for OUTER JOIN

Show all rows of one table where the primary key has **no** matching foreign key entry in
another table.

**Example:** show all teachers that are *not* a KV:

```sql
SELECT l.L_Name
FROM Lehrer l
LEFT OUTER JOIN Klasse k
    ON k.K_Vorstand = l.L_Nr
WHERE k.K_Vorstand IS NULL;
```

---

<!-- _class: invert -->

## Summary

- `OUTER JOIN` keeps unmatched rows from one (or both) sides, filling the gap with `NULL`
- `LEFT JOIN` keeps everything from the left table; `RIGHT JOIN` keeps everything from the right
- Filtering for `IS NULL` on the joined column is a common way to find "rows with no match"
