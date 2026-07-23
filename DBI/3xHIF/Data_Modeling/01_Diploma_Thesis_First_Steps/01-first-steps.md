---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# From Prose to Tables
## First Steps — DBI 3xHIF

---

## Agenda

1. Recap
2. From Prose Specification to Tables
3. Primary Keys
4. Foreign Keys
5. Worked Example: Photography Course
6. Summary

---

## Learning Goals

- I can turn a prose specification into a set of plain tables
- I can identify a primary key for a table
- I can identify a foreign key that links two tables

---

## Recap

Last lesson we informally sketched "classes" and sample tables for a real website.

Today we do the same thing, but starting from a **written specification** instead of
a website — the first step toward a formal notation.

---

## From Prose Specification to Tables

A typical specification describes **things** and how they relate, in plain sentences.
Our job: turn each "thing" into a table, and each of its properties into a column.

- Read carefully — every noun is a candidate table, every adjective/property a candidate column
- Watch for phrases like "each ... has exactly one ..." or "... can have several ..." — they describe **relationships**

---

## Primary Keys

Every table needs a column (or combination of columns) that **uniquely identifies**
each row — its **primary key (PK)**.

- Often a dedicated id column (`Member Nr`, `Order Nr`, ...)
- Sometimes a natural attribute already works (an email address, a national ID)

---

## Foreign Keys

When one table's rows relate to rows in another table, we add a **foreign key (FK)** —
a column that stores the related row's primary key.

Example: if every `Booking` belongs to exactly one `Member`, the `Booking` table gets
a `Member Nr` column referencing `Member`.

---

## Worked Example: Photography Course

*Specification:* A photography school offers a mentoring program.

- Each **student** (student id, name, class) is mentored by exactly one **mentor**
- Each **mentor** (abbreviation, name) mentors any number of students
- Each **student** submits exactly one **portfolio** (portfolio nr, title, submission date)

---

## Worked Example: Student Table

| Student |
|---|
| **Student Id** (PK) |
| Name |
| Class |
| Mentor Abbreviation (FK) |

---

## Worked Example: Portfolio Table

| Portfolio |
|---|
| **Portfolio Nr** (PK) |
| Title |
| Submission Date |
| Student Id (FK) |

---

<!-- _class: invert -->

## Summary

- A prose specification's **nouns** become tables, its **properties** become columns
- Every table needs a **primary key** that uniquely identifies each row
- A **foreign key** links a row to a row in another table
