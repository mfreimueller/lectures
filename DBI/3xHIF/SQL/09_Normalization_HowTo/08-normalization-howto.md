---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# Normalization – A Step-by-Step Method
## DBI 3xHIF

---

## Recap

Last lecture introduced **why** normalization matters — insertion, update, and deletion anomalies — and the rules behind 1NF, 2NF, and 3NF.

Today: a repeatable **method** for getting from a raw problem description to normalized relations.

---

## Agenda (1/2)

1. Key Terms: Entity & Attribute
2. Key Terms: Relation & Null Value
3. Key Attribute Types
4. The Four-Step Method
5. Step 1: Identify Objects & Events
6. Step 2: Assign Attributes → Ur-Relations
7. 1NF: No Repeating Groups
8. 1NF Fix: Extract the Repeating Group

---

## Agenda (2/2)

9. 2NF: Full Functional Dependency
10. 2NF Example 1: Partial Dependency & Fix
11. 2NF Example 2: Partial Dependency & Fix
12. 3NF: No Transitive Dependency
13. 3NF Example 1: Transitive Dependency & Fix
14. 3NF Example 2: Transitive Dependency & Fix
15. Step 4: Finalize Key Attributes

---

## Learning Goals

- I know the core vocabulary of data analysis (entity, attribute, relation, key attribute types)
- I can apply the four-step method to derive normalized relations from a problem description
- I can identify and resolve repeating groups, partial dependencies, and transitive dependencies
- I can determine the final key attributes of a normalized schema

---

## Key Terms: Entity & Attribute

**Entity**
- An object or event describable by shared properties and characteristics
- Every entity must be distinguishable from every other entity

**Attribute**
- A property used to distinguish one entity from another

---

## Key Terms: Relation & Null Value

**Relation**
- Entities that share the same attributes are represented as a table — this table is called a **relation**

**Null Value**
- A missing attribute value. It arises for two reasons:
  1. The value is unknown for some reason
  2. The value is meaningless for this entity

---

## Key Attribute Types

| Term | Meaning |
|---|---|
| **Key attribute** | A set of attributes that uniquely identifies an entity |
| **Full key attribute** | An attribute that is a key entirely on its own |
| **Partial key attribute** | An attribute that is only part of a key, in combination with other partial key attributes |
| **Surrogate key** | An artificial key attribute (e.g. a running number) — not very descriptive, but simple |
| **Foreign key attribute** | An attribute that is a key attribute in *another* relation |

---

## The Four-Step Method

1. **Identify objects & events** related to the problem
2. **Assign attributes** to them → raw ("Ur-") relations
3. **Normalize** the relations (1NF → 2NF → 3NF)
4. **Finalize** the key attributes

Everything from here on works through these four steps on a running example: an exam administration system.

---

## Step 1: Identify Objects & Events

Given a problem statement, first separate what you're modeling into **objects** (things that exist) and **events** (things that happen).

**Exam administration example:**

| Objects | Events |
|---|---|
| Examiner | Exam |
| Student | ExamFeeSettlement |

---

## Step 2: Assign Attributes → Ur-Relations

For each object/event, list every attribute that seems relevant — no structural rules yet, just capture everything. This produces the **Ur-Relations** (raw, unnormalized relations).

| Examiner | Student | Exam | ExamFeeSettlement |
|---|---|---|---|
| ExaminerNo | StudentID | ExamID | ExaminerNo |
| ExaminerName | Name | StudentID | Amount |
| ExaminerData (address, phone, ...) | PersonalData | CourseNo | NumEnrolled |
| BankDetails | | Semester | NumExaminees |
| | | WeeklyHours | BankDetails |
| | | Grade | CourseNo |
| | | Failed | Semester |
| | | Date | Date |
| | | ExaminerNo | |

---

## 1NF: No Repeating Groups

> **Rule:** A relation is in **First Normal Form (1NF)** if and only if all attributes are atomic and no attribute repeats.

**Problem example:** a `University` relation with key `UniID`, plus `UniDescription`, `UniName`, and a `Student` attribute that repeats once per enrolled student (up to 10,000 times).

The key `UniID` can technically still identify the university, but the repeating group makes the relation unwieldy and not atomic — this violates 1NF.

---

## 1NF Fix: Extract the Repeating Group

Move the repeating attribute into its **own** relation, combined with the original key as a partial key attribute:

**University**
- `UniID` (key)
- `UniDescription`
- `UniName`

**Uni/Students**
- `UniID` (partial key)
- `Student` (partial key)

Both relations are now in 1NF.

---

## 2NF: Full Functional Dependency

> **Rule:** A relation is in **Second Normal Form (2NF)** if it is in 1NF, and every non-key attribute is fully functionally dependent on the **whole** key — not just part of it.

**Functional dependency:** attribute `B` is functionally dependent on attribute `A` if `A` uniquely determines `B`.

Notation: `A → B` (example: `StudentID → StudentName`)

2NF only matters for relations with a **composite** key.

---

## 2NF Example 1: Partial Dependency & Fix

**University** — key: `StudentID` + `CourseNo` + `Semester`, non-key: `Lecturer`

Functional dependency: `StudentID, CourseNo → Lecturer`

`Lecturer` depends on only **part** of the key (`StudentID` + `CourseNo`, not `Semester`) → violates 2NF.

**Fix:** extract the partially-dependent attribute into its own relation:

- `University` (`StudentID`, `CourseNo`, `Semester`)
- `Uni/Lecturer` (`StudentID`, `CourseNo`, `Lecturer`)

---

## 2NF Example 2: Partial Dependency & Fix

**OrderItem** — key: `OrderNo` + `ArticleNo`, non-key: `Price`, `Quantity`, `Manufacturer`

| OrderNo | ArticleNo | Price | Quantity | Manufacturer |
|---|---|---|---|---|
| 2378 | A15 | 24.99 | 3 | S234 |
| 2378 | A48 | 12.50 | 8 | S90 |
| 2379 | A15 | 24.99 | 2 | S234 |

`Price` and `Manufacturer` depend only on `ArticleNo` — redundant on every row.

**Fix:** `OrderItem` (`OrderNo`, `ArticleNo`, `Quantity`) + `Product` (`ArticleNo`, `Price`, `Manufacturer`)

---

## 3NF: No Transitive Dependency

> **Rule:** A relation is in **Third Normal Form (3NF)** if it is in 2NF, and no non-key attribute is functionally dependent on **another non-key attribute**.

If `A → B` and `B → C`, then `C` is only *transitively* dependent on `A` — it really belongs with `B`.

---

## 3NF Example 1: Transitive Dependency & Fix

**University** — key: `StudentID` + `CourseNo`, non-key: `Lecturer`, `Institute`

Functional dependencies: `StudentID, CourseNo → Lecturer` and `Lecturer → Institute`

`Institute` depends on `Lecturer` — a non-key attribute — not directly on the key → violates 3NF.

**Fix:** extract the transitively-dependent attribute into its own relation:

- `University` (`StudentID`, `CourseNo`, `Lecturer`)
- `Uni/Institute` (`Lecturer`, `Institute`)

---

## 3NF Example 2: Transitive Dependency & Fix

**Orders** — key: `OrderNo`, non-key: `Date`, `CustomerNo`, `SalespersonNo`, `SalespersonName`, `SalespersonRevenue`

| OrderNo | Date | CustomerNo | SalespersonNo | SalespersonName | SalespersonRevenue |
|---|---|---|---|---|---|
| 2378 | 02/12 | C4990 | S12 | J.Jones | 1200 |
| 2380 | 02/15 | C2244 | S12 | J.Jones | 1200 |

`SalespersonName` and `SalespersonRevenue` depend on `SalespersonNo`, not on `OrderNo` — redundant.

**Fix:** `Orders` (`OrderNo`, `Date`, `CustomerNo`, `SalespersonNo`) + `Salesperson` (`SalespersonNo`, `Name`, `Revenue`)

---

## Step 4: Finalize Key Attributes

Normalizing usually splits or recombines keys along the way — this final step writes down the **definitive** key for every relation.

| Relation | Key Attributes |
|---|---|
| Exam | `StudentID` \|\| `CourseNo` \|\| `Date` |
| ExamAppointment | `ExaminerNo` \|\| `CourseNo` \|\| `Date` |
| Examiner | `ExaminerNo` |
| Student | `StudentID` |
| Course | `CourseNo` |

Object relations tend to have a simple key; event relations tend to have a composite key.

---

<!-- _class: invert -->

## Summary

- Four-step method: identify objects/events → assign attributes → normalize (1NF–3NF) → finalize keys
- **1NF** removes repeating groups — every attribute must be atomic
- **2NF** removes partial dependencies — every non-key attribute must depend on the *whole* key
- **3NF** removes transitive dependencies — non-key attributes must depend only on the key, not on each other
- Every violation is fixed the same way: extract the offending attribute(s) into their own relation, keyed by what they actually depend on
