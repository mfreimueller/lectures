---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – DQL Basics
## Comprehensive Recap · DBI 3xHIF

---

## Agenda (1/2)

1. SQL SELECT Statement
2. SELECT with WHERE — Comparison Operators
3. SELECT with WHERE — Combining Conditions
4. DISTINCT
5. ORDER BY
6. NULL Handling
7. Aggregate Functions

---

## Agenda (2/2)

8. INNER JOIN
9. LEFT / RIGHT OUTER JOIN
10. FULL OUTER JOIN
11. Multi-Table Joins
12. GROUP BY
13. HAVING vs. WHERE
14. Putting It Together

---

## Learning Goals

- I can filter, sort, and deduplicate rows with `WHERE`, `ORDER BY`, and `DISTINCT`
- I can combine tables with `INNER`, `LEFT`, and `RIGHT JOIN`
- I can aggregate data with `COUNT`/`SUM`/`AVG`/`MIN`/`MAX` and `GROUP BY`
- I know the difference between `WHERE` and `HAVING`
- I can combine `JOIN`, `WHERE`, `GROUP BY`, `HAVING`, and `ORDER BY` in the correct logical order

---

## Recap: DDL vs. DML vs. DQL

| Category | Purpose | Examples |
|---|---|---|
| **DDL** | Define / change the schema | `CREATE`, `DROP`, `ALTER`, `TRUNCATE` |
| **DML** | Manipulate data | `INSERT`, `UPDATE`, `DELETE` |
| **DQL** | Query data | `SELECT` |

Today: everything you already know about **DQL** — in one lecture.

---

## SQL SELECT Statement

```sql
SELECT column1, column2, ...
FROM table_name;
```

```sql
SELECT name, salary
FROM employees;
```

`SELECT *` returns every column — fine for exploring, avoid in real code.

---

## SELECT with WHERE — Comparison Operators

```sql
SELECT name, salary
FROM employees
WHERE salary > 4000;
```

- `=`, `!=` / `<>`, `<`, `>`, `<=`, `>=`
- `WHERE` filters **rows**, evaluated before the result set is built

---

## SELECT with WHERE — Combining Conditions

```sql
SELECT name
FROM employees
WHERE department_id = 3 AND salary > 4000;
```

- `AND`, `OR`, `NOT` combine conditions
- `IN (1, 2, 3)` — matches any value in a list
- `BETWEEN 4000 AND 5000` — inclusive range
- `LIKE 'A%'` — pattern matching (`%` = any chars, `_` = one char)

---

## DISTINCT

```sql
SELECT DISTINCT department_id
FROM employees;
```

Removes duplicate rows from the result set.

---

## ORDER BY

```sql
SELECT name, salary
FROM employees
ORDER BY salary DESC;
```

```sql
SELECT name, department_id, salary
FROM employees
ORDER BY department_id ASC, salary DESC;
```

Default direction is `ASC`. Sort by multiple columns left to right.

---

## NULL Handling

```sql
SELECT name
FROM employees
WHERE department_id IS NULL;
```

- `NULL` means "unknown" — it is never equal to anything, not even `NULL`
- `column = NULL` never matches — always use `IS NULL` / `IS NOT NULL`

---

## Aggregate Functions

```sql
SELECT COUNT(*), AVG(salary), MIN(salary), MAX(salary), SUM(salary)
FROM employees;
```

- `COUNT` – number of rows
- `SUM` / `AVG` – total / average of a numeric column
- `MIN` / `MAX` – smallest / largest value

---

## INNER JOIN

```sql
SELECT e.name, d.name AS department
FROM employees e
INNER JOIN departments d ON e.department_id = d.department_id;
```

Returns only rows that have a match in **both** tables.

---

## LEFT / RIGHT OUTER JOIN

```sql
SELECT e.name, d.name AS department
FROM employees e
LEFT JOIN departments d ON e.department_id = d.department_id;
```

- `LEFT JOIN` – all rows from the left table, matched rows (or `NULL`) from the right
- `RIGHT JOIN` – the mirror image; all rows from the right table

---

## FULL OUTER JOIN

- Conceptually: all rows from **both** tables, matched where possible
- MySQL/MariaDB has **no `FULL OUTER JOIN`**
- Workaround: `LEFT JOIN UNION RIGHT JOIN` — a preview of Lecture 06 (`UNION`)

---

## Multi-Table Joins

```sql
SELECT e.name, d.name AS department, p.name AS project
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN projects p ON e.project_id = p.project_id;
```

Chain as many `JOIN`s as you need — each one adds one more table.

---

## GROUP BY

```sql
SELECT department_id, COUNT(*) AS headcount, AVG(salary) AS avg_salary
FROM employees
GROUP BY department_id;
```

Collapses rows into groups; aggregate functions then operate per group.

---

## HAVING vs. WHERE

```sql
SELECT department_id, AVG(salary) AS avg_salary
FROM employees
GROUP BY department_id
HAVING AVG(salary) > 4000;
```

- `WHERE` filters **rows** before grouping
- `HAVING` filters **groups** after grouping — required for conditions on aggregates

---

## Putting It Together

```sql
SELECT d.name AS department, COUNT(*) AS headcount, AVG(e.salary) AS avg_salary
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE e.salary > 3000
GROUP BY d.name
HAVING COUNT(*) > 1
ORDER BY avg_salary DESC;
```

`JOIN` → `WHERE` → `GROUP BY` → `HAVING` → `ORDER BY` — the logical order matters.

---

<!-- _class: invert -->

## Summary

- `SELECT` / `WHERE` / `ORDER BY` / `DISTINCT` — filtering and shaping rows
- `JOIN`s combine tables; `GROUP BY` / `HAVING` aggregate them
- MySQL has no `FULL OUTER JOIN` — `UNION` fills the gap (Lecture 06)
