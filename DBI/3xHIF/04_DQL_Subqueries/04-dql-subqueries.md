---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – Subqueries
## DBI 3xHIF

---

## Recap

```sql
SELECT d.name, COUNT(*), AVG(e.salary)
FROM employees e
JOIN departments d ON e.department_id = d.department_id
GROUP BY d.name;
```

`SELECT`, `WHERE`, `JOIN`, and aggregate functions — today we nest queries inside each other.

---

## What is a Subquery?

- A **subquery** (inner query / nested query) is a `SELECT` placed inside another query
- The query that contains it is the **outer query**
- The outer query can be `SELECT`, `INSERT`, `UPDATE`, or `DELETE`

```sql
SELECT name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);
```

---

## Rules for Subqueries

- Always wrapped in parentheses `( ... )`
- Must always include `SELECT` and `FROM`
- Can be nested inside other subqueries
- Supports `WHERE`, `GROUP BY`, `HAVING`, `DISTINCT`
- `ORDER BY` is only allowed together with `LIMIT`/`TOP`

---

## What Can a Subquery Return?

- A **scalar** value — a single number/string (e.g. `AVG(salary)`)
- A **list** of values — used with `IN` / `NOT IN` / `EXISTS`
- A **table** — used as a derived table in `FROM`

---

## Scalar Subqueries

Employees who earn more than the company average:

```sql
SELECT name, salary
FROM employees
WHERE salary > (
    SELECT AVG(salary)
    FROM employees
);
```

1. The subquery computes **one** value: the average salary
2. The outer query compares every row against that value

---

## Multi-Value Subqueries

Employees who belong to a department based in Vienna:

```sql
SELECT name
FROM employees
WHERE department_id IN (
    SELECT department_id
    FROM departments
    WHERE city = 'Vienna'
);
```

The subquery returns a **list** of department IDs; `IN` checks membership.

---

## Subqueries with EXISTS

Employees who have made at least one sale:

```sql
SELECT name
FROM employees e
WHERE EXISTS (
    SELECT 1
    FROM sales s
    WHERE s.employee_id = e.employee_id
);
```

`EXISTS` only checks whether the subquery returns **any** row — often faster than `IN`.

---

## Subqueries in the FROM Clause (Derived Tables)

Highest salary per department:

```sql
SELECT department_id, MAX(salary) AS highest_salary
FROM (
    SELECT department_id, salary
    FROM employees
) AS by_department
GROUP BY department_id;
```

The subquery result is treated like a regular (temporary) table — it needs an alias (`AS by_department`).

---

## Subqueries with INSERT

```sql
INSERT INTO high_earners (name, salary)
SELECT name, salary
FROM employees
WHERE salary > 5000;
```

---

## Subqueries with UPDATE / DELETE

```sql
UPDATE employees
SET salary = salary * 1.05
WHERE department_id IN (
    SELECT department_id FROM departments WHERE city = 'Vienna'
);
```

```sql
DELETE FROM employees
WHERE department_id NOT IN (
    SELECT department_id FROM departments
);
```

---

## Preview: Correlated Subqueries

```sql
SELECT name, department_id, salary
FROM employees e1
WHERE salary > (
    SELECT AVG(salary)
    FROM employees e2
    WHERE e2.department_id = e1.department_id
);
```

This subquery references the **outer row** (`e1.department_id`) — it can't run on its own. That's a **correlated subquery**, the topic of next lecture.

---

## Benefits & Best Practices

- Break complex logic into smaller, readable pieces
- Reuse a calculation without writing it twice
- For performance-critical queries, a `JOIN` is often faster than a subquery
- Correlated subqueries run once **per outer row** — watch out on large tables

---

<!-- _class: invert -->

## Summary

- A subquery is a `SELECT` nested inside another query, always in parentheses
- Can return a scalar, a list (`IN`, `EXISTS`), or a table (`FROM` clause)
- Works with `SELECT`, `INSERT`, `UPDATE`, `DELETE`

**Next lecture:** Correlated subqueries — subqueries that depend on the outer row
