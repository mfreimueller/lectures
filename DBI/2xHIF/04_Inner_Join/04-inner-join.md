---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – INNER JOIN
## DBI 2xHIF — Combining Data from Multiple Tables

---

## Agenda

1. Introduction
2. Basic Concept of INNER JOIN
3. Syntax
4. Example

---

## Learning Goals

- I can explain what an `INNER JOIN` does conceptually
- I can write a `SELECT` statement that joins two or more tables
- I know that `INNER JOIN` only returns rows that match in **both** tables

---

## Introduction

How do we select and connect data from more than one table?

**Example task:** select the name of each teacher who is a *KV* (Klassenvorstand — class
representative), together with the name of their class.

That information lives in two separate tables: `Lehrer` and `Klasse`.

---

## Introduction

**Solution: `INNER JOIN`**

We need...

- all teachers, and all classes,
- but want to match each class with its respective KV

Because we only care about matches: `INNER JOIN`.

---

## Basic Concept of INNER JOIN

- An `INNER JOIN` returns the set of rows that match in **both** tables — an intersection
- Any number of tables can be joined, but the tables need matching values to produce a result
- Everything you already know (`WHERE`, `ORDER BY`, functions, ...) still applies to joined queries

---

## Basic Concept — Sample Data

**Klasse**

| K_Nr | K_Vorstand |
|---|---|
| 2AHIF | 5 |
| 2BHIF | 8 |
| 2CHIF | *(none)* |

**Lehrer**

| L_Nr | L_Name |
|---|---|
| 5 | Müller |
| 8 | Kramer |
| 9 | Novak |

---

## Basic Concept — Joined Result

```sql
SELECT k.K_Nr, l.L_Name
FROM Klasse k
INNER JOIN Lehrer l ON k.K_Vorstand = l.L_Nr;
```

| K_Nr | L_Name |
|---|---|
| 2AHIF | Müller |
| 2BHIF | Kramer |

`2CHIF` (no `K_Vorstand`) and `Novak` (no class references him) are both dropped — only
matching rows survive.

---

## Syntax

```sql
SELECT ...
FROM ...
    INNER JOIN <table name>
        ON <condition>
    INNER JOIN ...
WHERE ...
```

- You can join as many tables as you want by adding another `INNER JOIN` clause
- `ON` is the condition for the joined table
- `WHERE` applies to all tables in the query

---

## Example

Select the name of each teacher that is a KV, and the name of their class:

```sql
SELECT k.K_Nr, l.L_Name
FROM Klasse k
INNER JOIN Lehrer l
    ON k.K_Vorstand = l.L_Nr;
```

---

<!-- _class: invert -->

## Summary

- `INNER JOIN` returns only the rows that match in both tables — an intersection
- `ON` defines the join condition; `WHERE` still filters across the whole joined result
- You can chain multiple `INNER JOIN` clauses to combine more than two tables
