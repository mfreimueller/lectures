---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# SQL – Advanced SELECT
## DBI 2xHIF — Calculated Columns, Functions & DISTINCT

---

## Agenda

1. Recap
2. Calculated Columns
3. Functions
4. Concatenation
5. Nesting Functions
6. DISTINCT

---

## Learning Goals

- I can add calculated columns to a `SELECT` statement
- I can apply built-in functions to transform column values
- I can concatenate strings with `+` and `CONCAT`
- I can nest functions inside each other
- I can remove duplicate rows with `DISTINCT`

---

## Recap

We already know:

- `SELECT` statements
- Filtering with `WHERE`
- Sorting with `ORDER BY`

```sql
SELECT *
FROM Lehrer
WHERE L_Name LIKE 'F%'
ORDER BY L_Nr ASC;
```

---

## Calculated Columns

How would we calculate a teacher's salary next year (+5%)?

**Solution: calculated columns** — derive a new column from an existing one.

- Existing value: net price → calculate: price incl. tax
- Existing value: a date → calculate: just the year

Useful — and often necessary — for filtering, too.

---

## Calculated Columns

```sql
SELECT L_Nr
FROM Lehrer
WHERE YEAR(L_Gebdat) < 1999;
```

```sql
SELECT L_Gehalt * 1.05 AS Salary_Next_Year
FROM Lehrer;
```

---

## Functions

- Different functions apply depending on the column's data type
- Compare: string functions in Java — `substring`, `indexOf`, `toUpperCase`/`toLowerCase`
- Usage: `FUNCTION_NAME(arguments)`

---

## Functions

Show all teacher names in upper case:

```sql
SELECT UPPER(L_Name)
FROM Lehrer;
```

Show all teachers who started after 1990:

```sql
SELECT *
FROM Lehrer
WHERE YEAR(L_Eintrittsjahr) > 1990;
```

---

## Functions

Show the first three letters of every student's last name, next to their name:

```sql
SELECT LEFT(S_Zuname, 3) AS Kuerzel, S_Zuname
FROM Schueler;
```

---

## Functions — Reference

- **Mathematical**: `ROUND`, `FLOOR`, `CEILING`, ...
- **String**: `LEN`, `LEFT`, `SUBSTRING`, ...
- **Date**: `YEAR`, `MONTH`, `DATEDIFF`, ...

Consult the T-SQL documentation for the full list per category.

---

## Concatenation

How do we output a student's complete address as one column?

Two options:

```sql
SELECT S_Strasse + ' ' + S_Hausnummer
FROM Schueler;
```

```sql
SELECT CONCAT(CONCAT(S_Strasse, SPACE(1)), S_Hausnummer)
FROM Schueler;
```

`CONCAT` only takes two arguments per call — less flexible than `+`.

---

## Nesting Functions

How do we output a student's short name (first 3 letters) in upper case?

Nest functions inside each other — just like in Java:

```sql
SELECT S_Zuname, UPPER(LEFT(S_Zuname, 3)) AS Kuerzel
FROM Schueler;
```

---

## DISTINCT

```sql
SELECT S_Geschlecht, S_Klasse
FROM Schueler
WHERE S_Geschlecht = 2
ORDER BY S_Klasse;
```

What's the issue with this result set?

---

## DISTINCT

`DISTINCT` filters out duplicated row-combinations from the result:

```sql
SELECT DISTINCT S_Geschlecht, S_Klasse
FROM Schueler
WHERE S_Geschlecht = 2
ORDER BY S_Klasse;
```

---

<!-- _class: invert -->

## Summary

- Calculated columns derive new values from existing ones (`col * 1.05 AS alias`)
- Functions transform values based on their data type — string, math, date
- `+` and `CONCAT` join strings; functions can be nested inside each other
- `DISTINCT` removes duplicate row-combinations from the result set
