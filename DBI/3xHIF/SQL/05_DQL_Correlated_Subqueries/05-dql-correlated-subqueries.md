---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – Correlated Subqueries
## DBI 3xHIF

---

## Agenda (1/2)

1. What is a Correlated Subquery?
2. Execution Model
3. Syntax Pattern & Table Aliases
4. Use Case: Row-Specific Filtering
5. Use Case: Correlated UPDATE

---

## Agenda (2/2)

6. Use Case: Correlated DELETE
7. EXISTS with Correlated Subqueries
8. NOT EXISTS with Correlated Subqueries
9. Nested vs. Correlated Subqueries
10. Performance Considerations

---

## Learning Goals

- I can explain what makes a subquery "correlated" and how it executes
- I can write correlated subqueries for row-specific and per-group comparisons
- I can use correlated `UPDATE` and `DELETE` statements
- I can use `EXISTS` / `NOT EXISTS` with correlated subqueries
- I know the performance trade-offs between correlated and non-correlated subqueries

---

## Recap: Subqueries

```sql
SELECT name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);
```

Last lecture: subqueries that run **independently** of the outer query. Today: subqueries that don't.

---

## What is a Correlated Subquery?

- A subquery that references a column from the **outer query**
- It cannot be run on its own — it needs a row from the outer query to evaluate
- Runs **once per row** of the outer query, not once overall

---

## Execution Model

1. The outer query fetches a row
2. The subquery runs **using that row's values**
3. The result is applied (e.g. compared in `WHERE`)
4. Repeat for the next outer row

This row-by-row execution is what makes it "correlated."

---

## Syntax Pattern & Table Aliases

```sql
SELECT column1, column2
FROM table1 t1
WHERE column1 OPERATOR (
    SELECT column
    FROM table2 t2
    WHERE t2.some_column = t1.some_column
);
```

Table aliases (`t1`, `t2`) are what let the subquery "see" the outer row.

---

## Use Case: Row-Specific Filtering

Non-correlated (Lecture 04) — one company-wide average:

```sql
WHERE salary > (SELECT AVG(salary) FROM employees)
```

Correlated — average **per department**:

```sql
SELECT name, department_id, salary
FROM employees e1
WHERE salary > (
    SELECT AVG(salary)
    FROM employees e2
    WHERE e2.department_id = e1.department_id
);
```

---

## Use Case: Correlated UPDATE

Give every employee a raise to match their department average:

```sql
UPDATE employees e
SET salary = (
    SELECT AVG(e2.salary)
    FROM employees e2
    WHERE e2.department_id = e.department_id
);
```

---

## Use Case: Correlated DELETE

Remove departments that have no employees:

```sql
DELETE FROM departments d
WHERE NOT EXISTS (
    SELECT 1
    FROM employees e
    WHERE e.department_id = d.department_id
);
```

---

## EXISTS with Correlated Subqueries

Managers who have at least one report:

```sql
SELECT name
FROM employees m
WHERE EXISTS (
    SELECT 1
    FROM employees e
    WHERE e.manager_id = m.employee_id
);
```

---

## NOT EXISTS with Correlated Subqueries

Departments with no employees:

```sql
SELECT name
FROM departments d
WHERE NOT EXISTS (
    SELECT 1
    FROM employees e
    WHERE e.department_id = d.department_id
);
```

`NOT EXISTS` is usually the cleanest way to express "has none of these."

---

## Nested vs. Correlated Subqueries

| | Nested (non-correlated) | Correlated |
|---|---|---|
| Execution | Once, before the outer query | Once **per outer row** |
| Dependency | Independent | References the outer table |
| Performance | Generally faster on large data | Can be slow — repeated execution |

---

## Performance Considerations

- A correlated subquery re-runs for every row of the outer query
- Fine for small/medium tables; can get slow on large ones
- Often rewritable as a `JOIN` — worth comparing execution plans in practice

---

<!-- _class: invert -->

## Summary

- A correlated subquery references the **outer row** and runs once per row
- Common uses: per-row/per-group comparisons, correlated `UPDATE`/`DELETE`, `EXISTS`/`NOT EXISTS`
- Slower than independent subqueries on large tables — but often the clearest way to express the logic
