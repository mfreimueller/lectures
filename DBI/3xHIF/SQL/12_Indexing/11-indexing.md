---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – Indexing
## DBI 3xHIF

---

## Agenda (1/2)

1. What is an Index?
2. How Indexes Work
3. Benefits vs. Trade-offs
4. Types of Indexes
5. Simple, Unique & Primary Key Indexes
6. Fulltext & Descending Indexes
7. B-Tree Index
8. Hash Index

---

## Agenda (2/2)

9. R-Tree (Spatial) Index
10. Creating a Single-Column Index
11. Creating a Composite Index
12. Defining Indexes at Table Creation
13. When Should You Create an Index?
14. The Cost of Over-Indexing
15. Analyzing Queries with `EXPLAIN`
16. Reading `EXPLAIN` Output

---

## Learning Goals

- I can explain how an index speeds up query execution
- I know the trade-offs of adding an index (read speed vs. write speed & storage)
- I can distinguish B-Tree, Hash, and R-Tree indexes and when each applies
- I can create single-column, unique, and composite indexes
- I can use `EXPLAIN` to analyze how MySQL executes a query

---

## What is an Index?

- An index works like the index in a book — it lets the database **find data without reading every page**
- A separate data structure that stores a sorted subset of the data, plus a pointer to where the full row actually lives
- Crucial for query performance, especially on large tables

---

## How Indexes Work

Without an index, MySQL scans **every row** to answer a query.

With an index, MySQL can jump straight to the matching rows — used for:

- `WHERE` conditions
- `JOIN` operations
- Sorting with `ORDER BY`

---

## Benefits vs. Trade-offs

| Benefit | Trade-off |
|---|---|
| Much faster `SELECT` on indexed columns | Slower `INSERT` / `UPDATE` / `DELETE` |
| Less data scanned per query | Every index must be updated on every write |
| Speeds up `JOIN` and `ORDER BY` | Extra storage space per index |

---

## Types of Indexes

MySQL supports several index types, each for a different purpose:

| Type | Purpose |
|---|---|
| Simple Index | Basic index for quick searches |
| Unique Index | Enforces uniqueness of column values |
| Primary Key Index | Auto-created unique index on the primary key |
| Fulltext Index | Optimized for searching text content |
| Descending Index | Stores data in reverse order (MySQL 8.0+) |

---

## Simple, Unique & Primary Key Indexes

- **Simple Index** — no constraint, just speeds up lookups on a column
- **Unique Index** — ensures all values in the indexed column are distinct across the table
- **Primary Key Index** — automatically created for the primary key column(s); always unique

---

## Fulltext & Descending Indexes

- **Fulltext Index** — optimized for searching text-based content within a column (e.g. article bodies)
- **Descending Index** — available since MySQL 8.0; stores values in reverse order, useful for queries that want the most recent values first

---

## B-Tree Index

- (technically a **B\*Tree**) — an efficient, **ordered** key-value structure
- Can find a record by key **and** scan the data in order
- Makes range queries easy: *"all events between 9am and 5pm"*, *"last names starting with 'R'"*
- The default and most common index type — used by MyISAM and InnoDB
- InnoDB's primary key is a **clustered** B-Tree index

---

## Hash Index

- An **unordered** key-value map — even faster than B-Tree: `O(1)` instead of `O(log n)`
- No concept of order → **cannot** be used for range queries or to avoid sort operations
- The default index type for `MEMORY` tables (fast, non-transactional, in-memory-only)
- Ideal for primary-key style equality lookups only

---

## R-Tree (Spatial) Index

- A **spatial index** — quickly identifies "close" values across 2 or more dimensions
- Used in geographic/mapping databases
- Enables queries like *"all points within X meters from (x, y)"*

---

## Creating a Single-Column Index

```sql
CREATE INDEX idx_lastname ON Persons (LastName);
```

Speeds up any query that filters or sorts by `LastName`.

---

## Creating a Composite Index

```sql
CREATE INDEX idx_pname ON Persons (LastName, FirstName);
```

Beneficial for queries filtering or sorting by **both** `LastName` and `FirstName`.

```sql
SHOW INDEXES FROM Persons;
```

Lists all indexes defined on a table.

---

## Defining Indexes at Table Creation

Indexes can be declared directly inside `CREATE TABLE`:

```sql
CREATE TABLE example (
    col1 INT PRIMARY KEY,
    col2 INT NOT NULL,
    col3 INT NOT NULL,
    col4 VARCHAR(20),
    INDEX (col2, col3)
);
```

This creates the table **and** a composite index on `(col2, col3)` in one step.

---

## When Should You Create an Index?

- **Frequent reads** — many `SELECT` queries with `WHERE`, `ORDER BY`, or `GROUP BY`
- **Uniqueness constraints** — e.g. preventing duplicate emails in a `users` table
- **Join columns** — indexing join conditions helps the optimizer reduce processed rows
- **Large tables** — the bigger the table, the more a full scan costs without one
- **Geospatial queries** — R-Tree indexes for mapping/location data
- **Performance troubleshooting** — target the slowest, most frequent queries first

---

## The Cost of Over-Indexing

- Indexes are not free: they consume **storage** and slow down **writes**
- MySQL must update every relevant index on every `INSERT` / `UPDATE` / `DELETE`
- Over-indexing → increased storage requirements and slower write operations
- Analyze actual query patterns before adding an index — don't index "just in case"

---

## Analyzing Queries with `EXPLAIN`

- `EXPLAIN` shows how MySQL **executes** a query — its execution plan
- Similar in spirit to `DESCRIBE` (which shows table structure), but focused on execution strategy
- Applies to `SELECT`, `DELETE`, `INSERT`, `REPLACE`, and `UPDATE` — most commonly used with `SELECT`

```sql
EXPLAIN SELECT * FROM customers WHERE name LIKE 'k%';
```

---

## Reading `EXPLAIN` Output

`EXPLAIN` reveals:

- The **type of join** used
- Whether **indexes** are actually being used
- The **estimated number of rows** examined

Add `ANALYZE` for real timing and cost information:

```sql
EXPLAIN ANALYZE SELECT * FROM customers WHERE name LIKE 'k%';
```

---

## `EXPLAIN` Output Formats

`EXPLAIN FORMAT = <type>` controls how the plan is presented:

- **TRADITIONAL** — the classic tabular output
- **JSON** — structured, machine-readable detail
- **TREE** — a readable tree view of the execution plan

`TREE` and `JSON` formats are often easier to interpret for complex queries.

---

<!-- _class: invert -->

## Summary

- An index is a sorted structure + pointer that lets MySQL avoid full table scans
- Trade-off: faster reads, but slower writes and more storage
- **B-Tree** is the default (ordered, supports ranges); **Hash** is equality-only but `O(1)`; **R-Tree** is for spatial data
- Index columns used in `WHERE`, `JOIN`, and `ORDER BY` — but don't over-index
- `EXPLAIN` (optionally with `ANALYZE`) shows whether MySQL is actually using your indexes
