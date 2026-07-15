---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# Reverse Engineering Databases
## DBI 3xHIF

---

## Agenda (1/2)

1. Forward Engineering vs. Reverse Engineering
2. Why Reverse Engineer a Database?
3. What Gets Reverse-Engineered
4. What Can't Be Recovered Automatically
5. The General Process
6. MySQL Workbench: Reverse Engineering (1/3)

---

## Agenda (2/2)

7. MySQL Workbench: Reverse Engineering (2/3)
8. MySQL Workbench: Reverse Engineering (3/3)
9. Reading the Generated Diagram
10. Keeping Diagram and Schema in Sync
11. When to Reverse-, Forward-, or Round-Trip Engineer

---

## Learning Goals

- I can distinguish forward engineering from reverse engineering
- I know what reverse engineering can and cannot recover from an existing database
- I can reverse-engineer a MySQL database into an EER diagram with MySQL Workbench
- I can read crow's-foot notation in a generated diagram
- I know when to forward-, reverse-, or round-trip engineer

---

## Recap

So far, we've always started **from SQL** — writing `CREATE TABLE`, then querying it.

Today: what if you're handed a database with **no documentation at all**?

---

## Forward Engineering vs. Reverse Engineering

- **Forward engineering** — design a model first, then generate the database from it
  *(model → schema)*
- **Reverse engineering** — inspect an existing database and derive a model/diagram from it
  *(schema → model)*

Same relationship, opposite direction.

---

## Why Reverse Engineer a Database?

- You inherit a **legacy system** with no diagrams or docs
- Onboarding onto an unfamiliar project
- Auditing a schema before a refactor or migration
- Verifying that documentation still matches the real database

---

## What Gets Reverse-Engineered

- Tables and columns (names, data types, nullability)
- Primary keys and foreign keys
- Indexes
- The relationships **implied** by foreign key constraints

---

## What Can't Be Recovered Automatically

- Business rules that live only in application code
- The *intent* behind a naming choice
- Soft/implicit relationships not enforced by an actual `FOREIGN KEY`
- Anything the original developers only ever wrote down informally (or not at all)

---

## The General Process

1. Connect the tool to the live database
2. The tool inspects the catalog (in MySQL: `information_schema`)
3. A diagram is generated automatically
4. You **review and annotate** — automatic layout is rarely the final layout

---

## MySQL Workbench: Reverse Engineering (1/3)

- **Database → Reverse Engineer...**
- Choose the connection to your MySQL server
- Select the schema(s) to import

---

## MySQL Workbench: Reverse Engineering (2/3)

- Workbench reads tables, columns, keys, and indexes from `information_schema`
- Foreign keys are drawn automatically as relationship lines
- Import completes in seconds, even for large schemas

---

## MySQL Workbench: Reverse Engineering (3/3)

- Review the generated EER diagram
- Rearrange tables into logical groups
- Save the resulting `.mwb` model file alongside the project

---

## Reading the Generated Diagram

- Relationship lines use **crow's foot notation** (covered in depth in the data-modelling class)
- A crow's foot = "many"; a single tick = "one" or "exactly one"
- A generated diagram is a starting point — always relabel and reorganize for clarity

---

## Keeping Diagram and Schema in Sync

- The database keeps changing after the diagram is generated — this is called **schema drift**
- A reverse-engineered diagram is a **snapshot**, not a live view
- Re-run reverse engineering after significant schema changes, or use a sync/compare feature if the tool offers one

---

## When to Reverse-, Forward-, or Round-Trip Engineer

| Situation | Approach |
|---|---|
| New project, no database yet | Forward engineer (design → schema) |
| Inherited/undocumented database | Reverse engineer (schema → model) |
| Ongoing project, model and schema should stay aligned | Round-trip (sync both directions) |

---

<!-- _class: invert -->

## Summary

- Reverse engineering derives a model/diagram from an **existing** database
- Useful for legacy systems, onboarding, and pre-refactor audits
- Automatic keys/relationships, but business rules and intent still need a human
- MySQL Workbench: **Database → Reverse Engineer**
