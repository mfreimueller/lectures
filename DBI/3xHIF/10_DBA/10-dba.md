---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# Database Administration
## Users & Privileges · DBI 3xHIF

---

## Recap: Views for Security

Last lecture: grant access to a **view** instead of a table, to expose only safe columns.

Today: the full picture — users, privileges, `GRANT`, and `REVOKE`.

---

## Why Database Administration Matters

- Real databases have **many** users: applications, developers, reporting tools
- Not everyone should be able to do everything
- Principle of **least privilege**: grant only what's actually needed

---

## Creating a User

```sql
CREATE USER 'maier'@'localhost' IDENTIFIED BY 'maier';
```

- `'user'@'host'` — a user is identified by **name + host**, not name alone
- The same username can exist multiple times with different hosts and different privileges

---

## The `%` Host Wildcard

```sql
CREATE USER 'app_user'@'%' IDENTIFIED BY 'secret';
```

- `%` means "any host" — the user can connect from anywhere
- Convenient, but a real security trade-off: prefer specific hosts/IP ranges where possible

---

## Applying Privilege Changes

```sql
FLUSH PRIVILEGES;
```

Reloads the grant tables so privilege changes take effect immediately.

---

## Dropping a User

```sql
DROP USER 'maier'@'localhost';
DROP USER 'app_user'@'%';
```

---

## Inspecting Users & Privileges

```sql
SELECT host, user FROM mysql.user;

SELECT * FROM mysql.db;
```

MySQL stores its own users and grants in the `mysql` system database.

---

## The GRANT Command

```sql
GRANT privilege_list
ON object
TO 'user'@'host';
```

```sql
GRANT SELECT ON company_db.employees TO 'hanser'@'localhost';
```

---

## Privilege Types

| Privilege | Applies to |
|---|---|
| `SELECT` | Read data from a table/view |
| `INSERT` | Add rows |
| `UPDATE` | Modify rows |
| `DELETE` | Remove rows |
| `ALTER` | Change a table's column definitions |
| `INDEX` | Create/drop indexes |
| `CREATE` | Create tables/databases |
| `ALL PRIVILEGES` | Everything above |

---

## Granting to Multiple Users / Multiple Privileges

```sql
GRANT INSERT, UPDATE
ON company_db.employees
TO 'hanser'@'localhost', 'maier'@'localhost';
```

Separate multiple privileges — and multiple users — with commas.

---

## Granting Database-Creation Rights

```sql
GRANT CREATE ON *.* TO 'hanser'@'localhost';
```

`*.*` means "every database, every table" — used sparingly.

```sql
GRANT ALL PRIVILEGES ON *.* TO 'hanser'@'localhost';
```

---

## PUBLIC

```sql
GRANT SELECT ON company_db.departments TO PUBLIC;
```

`PUBLIC` grants the privilege to **every** user on the server.

---

## WITH GRANT OPTION

```sql
GRANT SELECT ON company_db.employees
TO 'adams'@'localhost'
WITH GRANT OPTION;
```

- Normally a user **cannot** pass a privilege they hold on to someone else
- `WITH GRANT OPTION` allows exactly that

---

## Column-Level Privileges

```sql
GRANT SELECT (name, department_id)
ON company_db.employees
TO 'ga_dept'@'localhost';
```

- Restricts `SELECT` (or `UPDATE`/`INSERT`) to specific **columns**
- An alternative to building a view purely for column security

---

## Cross-Database Access

```sql
SELECT * FROM company_db.departments;
```

Qualifying a table with `database_name.table_name` lets different users work across databases without switching context.

---

## Revoking Privileges

```sql
REVOKE ALL ON company_db.employees FROM 'hanser'@'localhost';
```

- Removes the privilege from that user — and from anyone they granted it on to
- A user might still retain access via a separate `PUBLIC` grant

---

## Combining Views + GRANT for Column-Level Security

```sql
CREATE VIEW employee_public AS
SELECT employee_id, name, department_id
FROM employees;

GRANT SELECT ON employee_public TO PUBLIC;
```

The pattern from Lecture 09, now with the full privilege model behind it: grant on the **view**, never on the raw table.

---

<!-- _class: invert -->

## Summary

- Users are `'name'@'host'` — hosts control **where** a login can connect from
- `GRANT` / `REVOKE` manage privileges at the database, table, or column level
- `WITH GRANT OPTION` lets a user pass privileges on; `PUBLIC` grants to everyone
- Views + `GRANT` together give fine-grained, column-level security

**Course recap:** DDL → DML → DQL → Subqueries → UNION → Reverse Engineering → Normalization → Views → DBA
