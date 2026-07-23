---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – DDL
## DBI 2xHIF — Data Definition Language

---

## Agenda

1. SQL Subsets
2. DDL
3. CREATE
4. ALTER
5. TRUNCATE
6. DROP

---

## Learning Goals

- I can name the four subsets of SQL
- I can create a table with columns, a primary key, and a foreign key
- I can add, change, and drop columns with `ALTER TABLE`
- I know the difference between `TRUNCATE` and `DROP`

---

## SQL Subsets

| Category | Purpose | Examples |
|---|---|---|
| **DQL** | Query data | `SELECT` |
| **DDL** | Define/change the schema | `CREATE`, `DROP`, `ALTER` |
| **DML** | Manipulate data | `INSERT`, `UPDATE`, `DELETE` |
| **DCL** | Control access | `GRANT`, `REVOKE` |

Today: **DDL**

---

## DDL

A subset of SQL to define which data we want to store:

- its **structure** (tables & columns)
- its **relation** to other data (foreign keys)

```sql
CREATE TABLE Klassenbucheintrag (...);
ALTER TABLE Klasse (...);
DROP TABLE Pruefung;
```

---

## DDL — Four Common Operations

- **Create** tables
- **Alter** (modify) tables
- **Drop** (delete) tables
- **Truncate** (clear) tables

---

## CREATE Statement

```sql
CREATE TABLE <database>.<schema>.<table>
(
    <column> <datatype> [[NOT] NULL]
        [PRIMARY KEY]
        [FOREIGN KEY REFERENCES
            <database>.<schema>.<table> (<column with primary key>)],
    ...
);
```

---

## CREATE Statement

```sql
CREATE TABLE SchulDb.dbo.Klassenbucheintrag
(
    KB_Nr INT PRIMARY KEY,
    KB_Text VARCHAR(2048) NOT NULL,
    KB_Klasse VARCHAR(128) NOT NULL FOREIGN KEY
        REFERENCES Klasse (K_Nr)
);
```

What's wrong with this statement?

---

## CREATE Statement

```sql
CREATE TABLE SchulDb.dbo.Klassenbucheintrag
(
    KB_Nr INT PRIMARY KEY,
    KB_Text VARCHAR(2048) NOT NULL,
    KB_Klasse NVARCHAR(8) NOT NULL FOREIGN KEY
        REFERENCES Klasse (K_Nr)
);
```

A foreign key **must have the same data type** as the primary key it references —
`Klasse.K_Nr` is `NVARCHAR(8)`, not `VARCHAR(128)`.

---

## ALTER Statement

```sql
ALTER TABLE <database>.<schema>.<table>
    ALTER COLUMN <column> <datatype> [[NOT] NULL],
    ADD <column> <datatype> [[NOT] NULL],
    DROP COLUMN <column>;
```

Column definitions work the same way as in `CREATE`.

---

## ALTER Statement

```sql
ALTER TABLE SchulDb.dbo.Klassenbucheintrag
    ALTER COLUMN KB_Text VARCHAR(MAX),
    ADD KB_Datum DATETIME;

ALTER TABLE SchulDb.dbo.Klassenbucheintrag
    DROP COLUMN KB_Datum;
```

---

## ALTER Statement — Adding a Foreign Key Later

```sql
ALTER TABLE <database>.<schema>.<table>
    ADD FOREIGN KEY (<foreign key column>)
        REFERENCES <table>(<primary key column>);
```

```sql
ALTER TABLE SchulDb.dbo.Klassenbucheintrag
    ADD FOREIGN KEY (KB_Klasse)
        REFERENCES Klasse(K_Nr);
```

---

## TRUNCATE Statement

Deletes the **data** inside a table, but keeps the table itself.

```sql
TRUNCATE TABLE <database>.<schema>.<table>;
```

```sql
TRUNCATE TABLE SchulDb.dbo.Klassenbucheintrag;
```

---

## DROP Statement

Removes the table entirely — structure and data both gone.

```sql
DROP TABLE <database>.<schema>.<table>;
```

```sql
DROP TABLE SchulDb.dbo.Klassenbucheintrag;
```

---

<!-- _class: invert -->

## Summary

- **DDL** defines structure: `CREATE`, `ALTER`, `DROP`, `TRUNCATE`
- A foreign key's data type must exactly match the primary key it references
- `TRUNCATE` empties a table; `DROP` removes the table entirely
