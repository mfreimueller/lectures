---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL & Relational Databases
## DBI 2xHIF — Course Introduction

---

## Course Roadmap

![width:1150px Course roadmap: six chapters from database foundations to changing data and schema](mermaid/roadmap.svg)

We'll move from what a database even is, through querying and combining tables, to
summarizing results, and finally to changing data and its schema.

---

## Grading

*Details will be announced in a later lesson.*

---

## Learning Goals

- I can explain what a database and a DBMS are, and name the major types of databases
- I can write `SELECT` queries that filter, sort, and transform data
- I can combine data from multiple tables with `INNER`/`OUTER JOIN`
- I can summarize data with aggregate functions, `GROUP BY`, and `HAVING`
- I can change both data (`DML`) and schema (`DDL`) with SQL

---

## What You'll Need

- Access to **SchulDb**, the school's own database — every example and exercise in this
  course queries this same database
- SQL Server Management Studio (SSMS) or DBeaver
- A willingness to write a lot of `SELECT` statements

---

<!-- _class: invert -->

## Summary

- This course builds up SQL step by step: querying, combining tables, summarizing results, changing data
- Every lesson works against the same real database — SchulDb
- Next up: what a database actually is
