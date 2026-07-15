---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – DDL
## Data Definition Language · DBI 3xHIF

---

## Agenda (1/2)

1. Categories of SQL Commands
2. DDL – Data Definition Language
3. List of the Most Important DDL Commands
4. SQL CREATE DATABASE Statement
5. SQL DROP DATABASE Statement
6. SQL CREATE TABLE Statement
7. Create Table Using Another Table
8. SQL DROP TABLE Statement
9. SQL TRUNCATE TABLE

---

## Agenda (2/2)

10. SQL ALTER TABLE Statement
11. SQL Constraints
12. Syntax – CREATE with Constraints
13. Syntax Example – ALTER for PRIMARY KEY
14. Commonly Used Constraints (1/2)
15. Commonly Used Constraints (2/2)
16. SQL AUTO_INCREMENT Field
17. Syntax Example – AUTO_INCREMENT

---

## Learning Goals

- I can distinguish between DDL, DML, DQL, and DCL SQL commands
- I can create, alter, and drop databases and tables
- I can define constraints (`NOT NULL`, `UNIQUE`, `PRIMARY KEY`, `FOREIGN KEY`, `CHECK`, `DEFAULT`) on a table
- I can use `AUTO_INCREMENT` to generate surrogate keys automatically

---

## Categories of SQL Commands

| Category | Purpose | Examples |
|---|---|---|
| **DDL** | Define / change the schema | `CREATE`, `DROP`, `ALTER`, `TRUNCATE` |
| **DML** | Manipulate data | `INSERT`, `UPDATE`, `DELETE` |
| **DQL** | Query data | `SELECT` |
| **DCL** | Control access | `GRANT`, `REVOKE` |

Today: **DDL**

---

## DDL – Data Definition Language

- SQL commands used to define the **database schema**
- DDL creates, modifies, and deletes database **structures** — not data
- Every table, column, and constraint starts with DDL

---

## List of the Most Important DDL Commands

- **CREATE** – create the database or its objects (tables, indexes, views, ...)
- **DROP** – delete objects from the database
- **ALTER** – alter the structure of an existing object
- **TRUNCATE** – remove all records from a table, keeping the table itself

---

## SQL CREATE DATABASE Statement

Creates a new SQL database.

```sql
CREATE DATABASE databasename;
```

In MySQL (MariaDB) you can add `IF NOT EXISTS`:

```sql
CREATE DATABASE IF NOT EXISTS testDb;
```

---

## SQL DROP DATABASE Statement

Drops (deletes) an existing SQL database.

```sql
DROP DATABASE databasename;
```

> Be careful before dropping a database — this destroys **all** data stored in it.

---

## SQL CREATE TABLE Statement

Creates a new table in a database.

```sql
CREATE TABLE table_name (
    column1 datatype,
    column2 datatype,
    column3 datatype,
    ....
);
```

---

## Create Table Using Another Table

A copy of an existing table can be created with `CREATE TABLE ... AS SELECT`. The new table gets the same column definitions.

```sql
CREATE TABLE new_table_name AS
SELECT column1, column2, ...
FROM existing_table_name
WHERE ....;
```

---

## SQL DROP TABLE Statement

Drops an existing table.

```sql
DROP TABLE table_name;
```

---

## SQL TRUNCATE TABLE

Deletes the **data** inside a table, but not the table itself.

```sql
TRUNCATE TABLE table_name;
```

---

## SQL ALTER TABLE Statement

- Adds, deletes, or modifies **columns** in an existing table
- Adds or drops **constraints** on an existing table

---

## SQL Constraints

- Specify rules for the data in a table
- Defined when the table is created (`CREATE TABLE`), or afterwards (`ALTER TABLE`)

---

## Syntax – CREATE with Constraints

```sql
CREATE TABLE table_name (
    column1 datatype constraint,
    column2 datatype constraint,
    column3 datatype constraint,
    ....
);
```

---

## Syntax Example – ALTER for PRIMARY KEY

```sql
ALTER TABLE Persons
ADD PRIMARY KEY (ID);
```

---

## Commonly Used Constraints (1/2)

- **NOT NULL** – column cannot have a `NULL` value
- **UNIQUE** – all values in a column must be different
- **PRIMARY KEY** – `NOT NULL` + `UNIQUE`; uniquely identifies each row
- **FOREIGN KEY** – prevents actions that would destroy links between tables

---

## Commonly Used Constraints (2/2)

- **CHECK** – ensures values satisfy a specific condition
- **DEFAULT** – sets a default value when none is specified
- **CREATE INDEX** – used to create and retrieve data very quickly

---

## SQL AUTO_INCREMENT Field

- Generates a unique number automatically for new records
- MySQL keyword: `AUTO_INCREMENT`
- Default starting value is `1`, incrementing by `1` per new record

---

## Syntax Example – AUTO_INCREMENT

```sql
CREATE TABLE Persons (
    Personid int NOT NULL AUTO_INCREMENT,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    PRIMARY KEY (Personid)
);
```

---

<!-- _class: invert -->

## Summary

- **DDL** defines database structures: `CREATE`, `DROP`, `ALTER`, `TRUNCATE`
- Constraints (`NOT NULL`, `UNIQUE`, `PRIMARY KEY`, `FOREIGN KEY`, `CHECK`, `DEFAULT`) keep data valid
- `AUTO_INCREMENT` generates surrogate keys automatically
