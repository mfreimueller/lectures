---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# Database Normalization
## DBI 3xHIF

---

## Agenda

1. The Problem: Anomalies in Unnormalized Tables
2. What is Normalization?
3. Worked Example Setup
4. First Normal Form (1NF)
5. Second Normal Form (2NF)
6. Third Normal Form (3NF)
7. Quick Look Ahead
8. Advantages & Disadvantages

---

## Learning Goals

- I can explain the anomalies that unnormalized tables cause
- I can bring a relation into 1NF, 2NF, and 3NF
- I know what BCNF, 4NF, 5NF, and 6NF address, at a high level
- I can weigh the advantages and disadvantages of normalization

---

## Recap: Why Table Design Matters

We already reverse-engineered a schema and *saw* good and bad structures. Today: the **rules** that separate the two.

---

## The Problem: Anomalies in Unnormalized Tables

A single flat table trying to hold everything causes:

- **Insertion anomaly** — can't add a fact without unrelated data being forced in too
- **Update anomaly** — the same fact repeated in many rows; update one, forget the others → inconsistency
- **Deletion anomaly** — deleting one fact accidentally deletes an unrelated one

---

## What is Normalization?

- The process of organizing columns and tables to **minimize redundancy**
- Introduced by Edgar Codd; formalized as a series of **normal forms** (1NF, 2NF, 3NF, BCNF, ...)
- Each normal form fixes a specific kind of anomaly

---

## Worked Example Setup

One flat, unnormalized `movies` table:

| title | year | genres | actors |
|---|---|---|---|
| Inception | 2010 | Thriller, Sci-Fi | DiCaprio, Page |
| Up | 2009 | Animation, Adventure | Reiner, Rippert |

Multiple genres and actors crammed into single columns.

---

## First Normal Form (1NF)

**Rule:** every column holds a single, atomic value — no lists, no repeating groups.

Fix: split `genres` into its own table with a many-to-many relationship.

```sql
CREATE TABLE movie_genres (
    movie_id INT,
    genre    VARCHAR(50)
);
```

Now each row has exactly one genre.

---

## Second Normal Form (2NF)

**Rule:** 1NF, plus every non-key column must depend on the **whole** primary key — no partial dependencies.

Applies to tables with a **composite** primary key. If `movie_id + actor_id` is the key, a column like `movie_title` (depends only on `movie_id`) doesn't belong here.

Fix: split into separate `movies` and `actors` tables, linked by a join table.

---

## Third Normal Form (3NF)

**Rule:** 2NF, plus no **transitive** dependencies — non-key columns must depend directly on the key, not on each other.

Example: an `orders` table storing `supplier_name` and `supplier_country` alongside the order — those depend on the supplier, not the order.

Fix: separate `customers`, `products`, and `suppliers` tables.

---

## Quick Look Ahead

| Form | Fixes |
|---|---|
| **BCNF** | Edge cases 3NF misses — every determinant must be a candidate key |
| **4NF** | Multi-valued dependencies |
| **5NF** | Reconstructing data from smaller, decomposed pieces |
| **6NF** | Temporal data — rarely used in practice |

Rarely needed day-to-day — 3NF covers the vast majority of real schemas.

---

## Advantages & Disadvantages

**Advantages**
- Improves data integrity
- Reduces redundancy
- Prevents insert/update/delete anomalies

**Disadvantages**
- More tables → more `JOIN`s needed to answer a question
- Can complicate simple reporting queries

---

<!-- _class: invert -->

## Summary

- Unnormalized tables cause insert/update/delete anomalies
- **1NF** — atomic columns · **2NF** — no partial dependency on a composite key · **3NF** — no transitive dependency
- Normalization trades some query simplicity for correctness and consistency
