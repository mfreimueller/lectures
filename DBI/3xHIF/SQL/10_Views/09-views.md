---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – Views
## DBI 3xHIF

---

## Agenda (1/2)

1. What is a View?
2. Creating a View
3. Querying a View
4. Views with Expressions, Functions & GROUP BY
5. Why Use Views? (1) Simplify & Stay Consistent
6. Why Use Views? (2) Security
7. Why Use Views? (3) Backward Compatibility
8. Updatable Views

---

## Agenda (2/2)

9. Rules for Updatable Views
10. Example: Updating Through a View
11. Example: Deleting Through a View
12. Checking Updatability
13. Views on Multiple Tables Are Not Updatable
14. Dropping / Managing Views

---

## Learning Goals

- I can create and query a view
- I know the three main reasons to use views: simplification, security, backward compatibility
- I can determine whether a view is updatable
- I can `INSERT`/`UPDATE`/`DELETE` through an updatable view
- I can manage (drop, re-create) views when the base table changes

---

## Recap: Normalization Creates More Joins

```sql
SELECT e.name, d.name, p.name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN projects p ON e.project_id = p.project_id;
```

A properly normalized schema means this kind of query gets typed **a lot**. Views hide that repetition.

---

## What is a View?

- A view is a **named, stored query** — a "virtual table"
- It has **no data of its own**; querying it runs the underlying `SELECT` every time
- You can query, and sometimes update, a view just like a table

---

## Creating a View

```sql
CREATE VIEW employee_overview AS
SELECT e.name, d.name AS department, p.name AS project
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN projects p ON e.project_id = p.project_id;
```

The complex query is written **once**, at creation time.

---

## Querying a View

```sql
SELECT * FROM employee_overview;

SELECT * FROM employee_overview
WHERE department = 'Engineering';
```

Same syntax as querying a real table — that's the whole point.

---

## Views with Expressions, Functions & GROUP BY

```sql
CREATE VIEW department_stats AS
SELECT department_id,
       MIN(salary) AS lowest,
       AVG(salary) AS average,
       MAX(salary) AS highest
FROM employees
GROUP BY department_id;
```

```sql
SELECT * FROM department_stats;
```

---

## Why Use Views? (1) Simplify & Stay Consistent

- Write a complex query **once**, reference it everywhere as a simple `SELECT`
- If a calculation or business rule changes, fix it in **one place** (the view), not in every query that used it

---

## Why Use Views? (2) Security

```sql
CREATE VIEW employee_public AS
SELECT employee_id, name, department_id
FROM employees;   -- omits salary, SSN, address

GRANT SELECT ON employee_public TO 'ga_dept'@'localhost';
```

Grant access to the **view**, not the underlying table — expose only what's needed.

---

## Why Use Views? (3) Backward Compatibility

- After normalizing a big table into several smaller ones, existing applications would break
- Create a view with the **old table's name**, built from the new tables
- Applications keep working unchanged — they don't know they're querying a view

---

## Updatable Views

- MySQL views aren't just queryable — some are **updatable**
- `INSERT` / `UPDATE` / `DELETE` on the view modifies the underlying **base table**

```sql
UPDATE employee_overview
SET department = 'Engineering'
WHERE name = 'Ada Lovelace';
```

---

## Rules for Updatable Views

The defining `SELECT` must **not** contain:

- Aggregate functions (`MIN`, `MAX`, `SUM`, `AVG`, `COUNT`) or `GROUP BY` / `HAVING`
- `DISTINCT`, `UNION` / `UNION ALL`
- A `JOIN` across multiple tables
- A subquery referring back to the same table

---

## Example: Updating Through a View

```sql
CREATE VIEW office_info AS
SELECT office_code, phone, city
FROM offices;

UPDATE office_info
SET phone = '+43 1 234 5678'
WHERE office_code = 4;
```

The change is applied to the `offices` table directly.

---

## Example: Deleting Through a View

```sql
CREATE VIEW luxury_items AS
SELECT * FROM items WHERE price > 700;

DELETE FROM luxury_items WHERE id = 3;
```

Row `id = 3` is removed from the **base table** `items`, not just hidden from the view.

---

## Checking Updatability

```sql
SELECT table_name, is_updatable
FROM information_schema.views
WHERE table_schema = 'company_db';
```

Views built from a single table, without aggregates/`GROUP BY`/`JOIN`, report `is_updatable = YES`.

---

## Views on Multiple Tables Are Not Updatable

```sql
CREATE VIEW employee_overview AS
SELECT e.name, d.name AS department
FROM employees e
JOIN departments d ON e.department_id = d.department_id;
```

This view is great for **reading** — but not updatable, since it's built from a `JOIN`.

---

## Dropping / Managing Views

```sql
DROP VIEW employee_overview;
```

- Naming convention: suffix views with `_view` (or similar) to tell them apart from tables at a glance
- If a base table's structure changes, drop and recreate any views built on it

---

<!-- _class: invert -->

## Summary

- A view is a stored, named query — a virtual table with no data of its own
- Great for simplifying queries, enforcing consistent business logic, and column-level security
- Some views are updatable (single table, no aggregates/`JOIN`/`GROUP BY`) — `INSERT`/`UPDATE`/`DELETE` then hit the base table
