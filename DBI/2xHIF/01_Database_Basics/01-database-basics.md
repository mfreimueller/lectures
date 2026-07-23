---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# Database Basics
## DBI 2xHIF — Databases and Information Systems

---

## Agenda

1. Data & Data Storage
2. What is a Database?
3. Database vs. DBMS
4. Types of Databases
5. Intermission: ACID
6. Microsoft SQL Server

---

## Learning Goals

- I can explain why applications need structured, managed data storage
- I can distinguish a database from a database management system (DBMS)
- I can name and characterize the major types of databases
- I can name the four ACID properties
- I know which DBMS this course uses and its basic characteristics

---

## Data

Applications need data. But...

- How do we store and retrieve this data?
- How do we organize this data?
- How do we deal with large amounts of data?
- How do we manage who can access this data?

---

## Types of Data Storage

- Plain text files — CSV, JSON, XML, ...
- Binary files
- In-memory
- Cloud storage
- **Databases**

---

## What is a Database?

- An organized collection of data
- Stores information in a structured way
- Allows efficient access, modification, and management of data
- Managed by a **Database Management System (DBMS)**

---

## Database vs. DBMS

Microsoft SQL Server is a database *management system* — one DBMS can manage **many**
databases.

**Analogy:**
- Database → a library's books
- DBMS → the library's catalogue system

---

## Database vs. DBMS

| Database stores | DBMS stores |
|---|---|
| Tables | Databases |
| Rows | Users |
| Indices | Roles |
| Views | Policies |

---

## Types of Databases

- Hierarchical
- Relational
- NoSQL
- Object-oriented
- Cloud
- File-based

---

## Hierarchical Databases

- Tree-like structure — each record has exactly one parent
- One-to-many relationships only

| Pros | Cons |
|---|---|
| Good for nested, static data | Inflexible data structure |
| High-speed performance | |

---

## Relational Databases

- Data stored in **tables** — rows and columns
- Queried with **SQL** (Structured Query Language)
- Focus on relationships between data

| Pros | Cons |
|---|---|
| Highly flexible | Less efficient for large, unorganized data |
| Data integrity (via ACID) | |

---

## Intermission: ACID

- **A**tomicity
- **C**onsistency
- **I**solation
- **D**urability

---

## NoSQL ("Not Only SQL")

Built for large volumes of unstructured, semi-structured, and fast-changing data.

| Pros | Cons |
|---|---|
| Flexible schemas | No ACID guarantees |
| Highly scalable | Lack of standardization |

---

## Object-Oriented Databases

Stores data as objects — think back to object-oriented programming: inheritance and
polymorphism apply here too.

| Pros | Cons |
|---|---|
| Stores complex data types | Tight coupling with application code |
| Data defined in the domain layer | |

---

## Cloud Databases

A database offered as a service on a cloud platform.

| Pros | Cons |
|---|---|
| High availability | Vendor lock-in |
| Scalability, flexibility | Downtime risk |

---

## File-Based Databases

Data is stored in physical files directly on a device — no separate DBMS involved.

| Pros | Cons |
|---|---|
| Good for single-user applications | Multi-user access is difficult and error-prone |
| No DBMS necessary | Weaker performance at scale |

---

## Microsoft SQL Server

- Proprietary, **relational** DBMS
- Strong focus on ACID
- T-SQL — Microsoft's extension on top of standard SQL
- Initial release: April 24, 1989
- This is the DBMS we'll use throughout this course

---

<!-- _class: invert -->

## Summary

- A database stores structured data; a DBMS manages one or more databases
- Relational databases (like SQL Server) organize data into tables and guarantee ACID
- Other types — hierarchical, NoSQL, object-oriented, cloud, file-based — trade off flexibility, scale, and structure differently
- This course uses Microsoft SQL Server, a relational DBMS
