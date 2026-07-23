---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – DML
## DBI 2xHIF — Data Manipulation Language

---

## Agenda

1. SQL Subsets
2. DML Introduction
3. INSERT
4. UPDATE
5. DELETE

---

## Learning Goals

- I can name the four subsets of SQL
- I can insert new rows with `INSERT INTO`
- I can change existing rows with `UPDATE`
- I can remove rows with `DELETE`

---

## SQL Subsets

| Category | Purpose | Examples |
|---|---|---|
| **DQL** | Query data | `SELECT` |
| **DDL** | Define/change the schema | `CREATE`, `DROP`, `ALTER` |
| **DML** | Manipulate data | `INSERT`, `UPDATE`, `DELETE` |
| **DCL** | Control access | `GRANT`, `REVOKE` |

Today: **DML**

---

## DML

A subset of SQL for performing data manipulation:

- **Insert** data (create a new row)
- **Update** data (change one, multiple, or no rows)
- **Delete** data (remove one, multiple, or no rows)

```sql
INSERT INTO Klassenbucheintrag VALUES (632, 'Text ...', '4DHIF');
UPDATE Klassenbucheintrag SET KB_Klasse = '5DHIF' WHERE KB_Nr = 632;
DELETE FROM Klassenbucheintrag WHERE KB_Klasse = '4DHIF';
```

---

## INSERT Statement

```sql
INSERT INTO <database>.<schema>.<table>
    [(<column>, <column>, ...)]
VALUES (
    <value>, <value>, ...
), (
    <value>, <value>, ...
), ...;
```

---

## INSERT Statement

```sql
INSERT INTO SchulDb.dbo.Klassenbucheintrag
    (KB_Nr, KB_Text, KB_Klasse)
VALUES
    (1, 'Note left during the lesson.', '1BHIF'),
    (2, 'Another note for a different class.', '4AHIF');
```

Multiple rows can be inserted in a single statement.

---

## UPDATE Statement

```sql
UPDATE <database>.<schema>.<table>
SET <column> = <new value>,
    <column> = <new value>, ...
[ WHERE <conditions> ];
```

---

## UPDATE Statement

```sql
UPDATE SchulDb.dbo.Klassenbucheintrag
SET KB_Klasse = '2DHIF'
WHERE KB_Klasse = '1DHIF';
```

Without `WHERE`, **every** row gets updated — always check your condition first.

---

## DELETE Statement

```sql
DELETE FROM <database>.<schema>.<table>
[ WHERE <conditions> ];
```

---

## DELETE Statement

```sql
DELETE FROM SchulDb.dbo.Klassenbucheintrag
WHERE KB_Klasse = '2EHIF';
```

Without `WHERE`, **every** row gets deleted — the table itself still exists, just empty.

---

<!-- _class: invert -->

## Summary

- SQL splits into DQL, DDL, DML, and DCL — today was **DML**
- `INSERT INTO table (columns) VALUES (...)` adds new rows, one statement can add many
- `UPDATE table SET column = value WHERE ...` and `DELETE FROM table WHERE ...` both act on **all** rows if you forget the `WHERE` clause
