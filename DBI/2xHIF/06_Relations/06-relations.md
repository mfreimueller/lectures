---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# Relationships in SQL
## Referential Integrity & Cardinality · DBI 2xHIF

---

## Agenda

1. Referential Integrity
2. Data Integrity
3. One-to-One
4. One-to-Many
5. Many-to-Many

---

## Learning Goals

- I know what referential integrity means and why it matters
- I can name the four aspects of data integrity
- I can identify one-to-one, one-to-many, and many-to-many relationships
- I know where to place the foreign key for each relationship type

---

## Referential Integrity

Relational databases connect data through **foreign keys** that reference **primary keys**.

Example: `Schueler.S_Klasse` (foreign key) → `Klasse.K_Nr` (primary key)

Should `S_Klasse` be allowed to contain a class number that doesn't exist? Why (not)?

---

## Referential Integrity

**Referential integrity**: a foreign key column may only contain values that exist as a primary key in the referenced table.

- Only valid class numbers can be written to `S_Klasse`
- Writing an invalid value raises a **referential integrity violation** — the database rejects it

---

## Data Integrity

| Aspect | Meaning |
|---|---|
| **Accuracy** | data is free of errors |
| **Consistency** | the same data looks the same everywhere |
| **Completeness** | all necessary data is present |
| **Reliability** | data stays stable over time, produces consistent results |

---

## Three Kinds of Relationships

When connecting tables, every relationship falls into one of three categories:

- **One-to-One** (1:1)
- **One-to-Many** (1:N)
- **Many-to-Many** (N:M)

---

## One-to-One

Each row on one side is connected to **at most one** row on the other side.

![width:550px 1:1 relationship: PERSON_A connects to exactly one PERSON_B](puml/one-to-one.svg)

Example: *Anna* loves *Bob*, *Bob* loves *Anna* — and no one else.

---

## One-to-One — Foreign Key Placement

- The foreign key can live on **either** side
- It must be **UNIQUE** — otherwise one person could love two people, which turns it into a 1:N relationship

---

## One-to-Many

One row on the "one" side connects to **multiple** rows on the "many" side.

![width:550px 1:N relationship: one PERSON_A connects to many PERSON_B](puml/one-to-many.svg)

Example: *Anna* loves *Bob*, *Claus*, and *Doug* — but each of them only loves *Anna* back.

---

## One-to-Many — Foreign Key Placement

- The foreign key goes on the **many** side (Bob, Claus, and Doug each store Anna's key)
- The primary key stays on the **one** side (Anna)
- This is the relationship you already know from `S_Klasse → K_Nr`

---

## Many-to-Many

Many rows on one side connect to many rows on the other side.

![width:550px N:M relationship: many PERSON_A connect to many PERSON_B](puml/many-to-many.svg)

Example: *Anna*, *Eva*, and *Francesca* all love *Bob*, *Claus*, and *Doug* — and vice versa.

---

## Many-to-Many — the Problem

- Placing the foreign key on one side only captures "one partner per row" on the *other* side → 1:N
- The reverse placement has the same problem, just mirrored
- Neither side alone can hold **both** directions of the relationship

---

## Many-to-Many — the Solution

A **bridge table** sits between both tables and stores one row per connection, with a foreign key to each side.

```sql
CREATE TABLE Loves (
    PersonA_ID INT FOREIGN KEY REFERENCES Person(ID),
    PersonB_ID INT FOREIGN KEY REFERENCES Person(ID)
);
```

---

<!-- _class: invert -->

## Summary

- Referential integrity: a foreign key may only reference an existing primary key
- Data integrity: accuracy, consistency, completeness, reliability
- 1:1 → FK on either side, UNIQUE; 1:N → FK on the "many" side; N:M → bridge table with two FKs
