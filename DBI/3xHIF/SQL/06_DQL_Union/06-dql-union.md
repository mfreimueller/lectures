---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – UNION
## DBI 3xHIF

---

## Agenda (1/2)

1. What is UNION?
2. Requirements for UNION
3. Basic Syntax
4. Example: Basic UNION
5. UNION vs. UNION ALL
6. Example: A Discriminator Column

---

## Agenda (2/2)

7. Rules to Remember
8. Common Mistakes
9. What is INTERSECT?
10. INTERSECT is Not Supported in MySQL/MariaDB
11. Simulating INTERSECT
12. Recap Table

---

## Learning Goals

- I can combine result sets with `UNION` and `UNION ALL`
- I know the requirements for combining `SELECT` statements (column count, types, order)
- I can avoid common `UNION` mistakes (mismatched columns/types, misplaced `ORDER BY`)
- I know that MySQL has no `INTERSECT` and can simulate it with `JOIN`, `IN`, or `EXISTS`

---

## What is UNION?

- Combines the result sets of **two or more** `SELECT` statements into one
- Removes duplicate rows by default — similar to `DISTINCT`
- `UNION ALL` keeps duplicates (and is faster, since no dedup step is needed)

---

## Requirements for UNION

Every `SELECT` in the `UNION` must have:

- The **same number of columns**
- **Compatible data types** in corresponding columns
- Columns in the **same order**

---

## Basic Syntax

```sql
SELECT column1, column2, ...
FROM table1
WHERE condition

UNION

SELECT column1, column2, ...
FROM table2
WHERE condition;
```

---

## Example: Basic UNION

```sql
SELECT name FROM employees
UNION
SELECT name FROM managers;
```

| employees.name | managers.name | → result |
|---|---|---|
| Alice, Bob | Charlie, Dana | Alice, Bob, Charlie, Dana |

Duplicate names (if any) appear only once.

---

## UNION vs. UNION ALL

```sql
SELECT name FROM employees
UNION ALL
SELECT name FROM managers;
```

- `UNION` — deduplicates, does extra work
- `UNION ALL` — keeps every row, including duplicates, and is cheaper to run
- Use `UNION ALL` whenever you know there won't be (or don't care about) duplicates

---

## Example: A Discriminator Column

```sql
SELECT id, name, 'Employee' AS role
FROM employees

UNION ALL

SELECT id, name, 'Manager' AS role
FROM managers;
```

| id | name | role |
|---|---|---|
| 1 | Alice | Employee |
| 10 | Charlie | Manager |

A literal value labels which query each row came from.

---

## Rules to Remember

| Rule | Description |
|---|---|
| Column count | Must match across all `SELECT`s |
| Data types | Must be compatible (no `INT` UNION `DATE`) |
| Column names | Result uses the names from the **first** `SELECT` |
| Ordering | `ORDER BY` goes once, after the **last** `SELECT` |

```sql
SELECT name FROM employees
UNION
SELECT name FROM managers
ORDER BY name;
```

---

## Common Mistakes

| Mistake | Fix |
|---|---|
| Mismatched column counts | Make every `SELECT` return the same number of columns |
| Mismatched types | `CAST` explicitly, e.g. `CAST(id AS CHAR)` |
| `ORDER BY` inside each `SELECT` | Only order the **final** combined result |

---

## What is INTERSECT?

Returns only the rows present in **both** result sets — a set intersection.

```sql
SELECT name FROM table_a
INTERSECT
SELECT name FROM table_b;
```

---

## INTERSECT is Not Supported in MySQL/MariaDB

- Standard SQL has `INTERSECT` — MySQL and MariaDB **do not**
- Using it raises a syntax error
- We need an alternative

---

## Simulating INTERSECT

Students enrolled in both 2023 and 2024:

```sql
-- INNER JOIN
SELECT s1.name
FROM students_2023 s1
JOIN students_2024 s2 ON s1.name = s2.name;

-- IN
SELECT name FROM students_2023
WHERE name IN (SELECT name FROM students_2024);

-- EXISTS
SELECT name FROM students_2023 s1
WHERE EXISTS (SELECT 1 FROM students_2024 s2 WHERE s2.name = s1.name);
```

---

## Recap Table

| Method | Notes |
|---|---|
| `INTERSECT` | Not supported in MySQL/MariaDB |
| `INNER JOIN` | Best for comparing values between tables |
| `IN` | Easy to read, potentially slower |
| `EXISTS` | Often best for complex subqueries / performance tuning |

---

<!-- _class: invert -->

## Summary

- `UNION` combines result sets, deduplicating; `UNION ALL` keeps duplicates and is cheaper
- Column count, types, and order must line up across every `SELECT`
- MySQL has no `INTERSECT` — use `INNER JOIN`, `IN`, or `EXISTS` instead
