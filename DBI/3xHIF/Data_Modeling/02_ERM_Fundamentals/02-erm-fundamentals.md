---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# ERM Fundamentals
## Chen Notation — DBI 3xHIF

---

## Agenda

1. From Tables to Entities
2. Entity, Relationship, Attribute
3. Attribute Types
4. Keys
5. Cardinality: 1:1, 1:n, n:m
6. Summary

---

## Learning Goals

- I can identify entities, relationships, and attributes in a scenario
- I can draw them using Chen notation (rectangle, diamond, oval)
- I can distinguish key, composite, multivalued, and derived attributes
- I can determine and notate 1:1, 1:n, and n:m cardinalities

---

## Recap: From Tables to Entities

Last lesson we turned a prose specification into plain tables by hand, and talked
about primary and foreign keys.

Today we give that process a **formal notation**: the **Entity-Relationship Model
(ERM)**, introduced by Peter Chen in 1976.

An ERM diagram describes the **static structure** of data — independent of any
specific database product.

---

## The Three Building Blocks

| Concept | Meaning | Notation |
|---|---|---|
| **Entity** | A distinguishable thing in the real world (Student, Car, Order) | Rectangle |
| **Relationship** | A meaningful association between entities (writes, supervises) | Diamond |
| **Attribute** | A property describing an entity or relationship (name, date) | Oval |

An **entity set** groups similar entities (all students); a single student is one *entity*.

---

## Example: Entity with Attributes

![width:650px Person entity with attribute types](dot/attribute-types.svg)

---

## Attribute Types

- **Key attribute** — uniquely identifies each entity → <u>underlined</u>
- **Composite attribute** — made up of smaller parts → `Name` splits into `First Name` / `Last Name`
- **Multivalued attribute** — an entity can have several values → double oval (`Phone Numbers`)
- **Derived attribute** — computed from other data, not stored → dashed oval (`Age` from birth date)

---

## Keys

- A **key** is a minimal set of attributes that uniquely identifies an entity
- An entity type can have several **key candidates** — one is chosen as the **primary key**, the rest are secondary keys
- Example: entity `City` — attributes `ZIP`, `Country`, `Population`, `Area Code` — both `ZIP` and `Area Code` could serve as a key

---

## Key Properties

1. Unique
2. Not Null
3. Stable
4. Minimal

---

## Unique

- A **key** must be one or multiple columns that uniquely identify an entity.
- Good example: entity `Student` is uniquely identified by `StudentNumber`
- Bad example: entity `Student` uses `Firstname` as identifier (duplicates!)

---

## Unique — Example

**Good:** `StudentNumber` as key — every row is distinguishable

| **<u>StudentNumber</u>** | Firstname | Lastname |
|---|---|---|
| 1001 | Anna | Huber |
| 1002 | Anna | Gruber |

**Bad:** `Firstname` as key — two students share the value `Anna`

| **<u>Firstname</u>** | Lastname |
|---|---|
| Anna | Huber |
| Anna | Gruber |

---

## Not Null

- A **key** must never be NULL
- Good example: entity `Student` is uniquely identified by `StudentNumber`
- Bad example: entity `Student` uses `SocialSecurityNumber` as identifier (may be null!)

---

## Not Null — Example

**Good:** `StudentNumber` as key — always filled in

| **<u>StudentNumber</u>** | Firstname | Lastname |
|---|---|---|
| 1001 | Anna | Huber |
| 1002 | Ben | Gruber |

**Bad:** `SocialSecurityNumber` as key — not every student has one yet

| **<u>SocialSecurityNumber</u>** | Firstname | Lastname |
|---|---|---|
| 1234 010203 | Anna | Huber |
| NULL | Ben | Gruber |
| NULL | Carla | Maier |

---

## Stable

- A **key** must never change
- Good example: entity `Student` is uniquely identified by `StudentNumber` (once assigned, never changes)
- Bad example: entity `Student` uses `Email` as identifier (may change at some point)

---

## Stable — Example

**Good:** `StudentNumber` as key — the email changes, the identity stays

| | **<u>StudentNumber</u>** | Email |
|---|---|---|
| before | 1001 | anna.huber@school.at |
| after | 1001 | anna.gruber@school.at |

**Bad:** `Email` as key — the key itself has to change

| | **<u>Email</u>** | StudentNumber |
|---|---|---|
| before | anna.huber@school.at | 1001 |
| after | anna.gruber@school.at | 1001 |

Every row referencing the old email is now orphaned.

---

## Minimal

- A **key** must be as small as possible
- Good example: entity `Student` is uniquely identified by `StudentNumber` alone
- Bad example: entity `Student` is identified by `Firstname`, `Lastname` and `Birthdate`
- ... One student might be inserted more than once with various name/birthdate combinations

---

## Minimal — Example

**Good:** `StudentNumber` alone is enough

| **<u>StudentNumber</u>** | Firstname | Lastname | Birthdate |
|---|---|---|---|
| 1001 | Anna | Huber | 2007-03-12 |

**Bad:** `Firstname` + `Lastname` + `Birthdate` — more columns than needed, and a typo creates a "second" Anna

| **<u>Firstname</u>** | **<u>Lastname</u>** | **<u>Birthdate</u>** |
|---|---|---|
| Anna | Huber | 2007-03-12 |
| Anna | Huber | 2007-03-21 |

---

## Two types of keys

When modeling our entities, we need to think about the kind of key we want to use:

- **Natural** key
- **Surrogate** key

---

## Natural Key

A **natural key** is part of the attributes of an entity.

- Example: entity `City` uses `ZipCode` as primary key
- ... each city has one zip code already

---

## Surrogate Key

A **surrogate key** is added to the entity for the *purpose* of identification.

- Example: entity `Student` uses new attribute `StudentNumber` as primary key
- ... `StudentNumber` doesn't exist naturally on a student - it was **introduced**

---

## Natural vs. Surrogate — Example

![width:1000px City with natural key, Student with surrogate key](dot/natural-surrogate.svg)

A city already *has* a zip code. A student has no number until the school *hands one out*.

---

## Pitfalls

<div class="highlight-box">
<p><strong>surrogate</strong> =/= <strong>artificial</strong></p>
</div>

For a `Student` entity, `SocialSecurityNumber` would be *natural*, as it is already *given*.

For the social security institute, `SocialSecurityNumber` is a *surrogate* key, as they *introduce* it.

---

## Pitfall — Example

Same attribute, two different verdicts:

| Entity | Key | Where does the value come from? | Verdict |
|---|---|---|---|
| `Student` | `SocialSecurityNumber` | already exists — the school just records it | **natural** |
| `Insured Person` | `SocialSecurityNumber` | issued by the institute when a person registers | **surrogate** |

A key that feels *natural* can still be a surrogate — it depends on **who introduced it**, not on how "real" it feels.

---

## Cardinality

Cardinality describes **how many** instances of one entity relate to instances of another, through a relationship.

Three basic shapes:

- **1:1** — one-to-one
- **1:n** — one-to-many
- **n:m** — many-to-many

---

## 1:1 — Driver has License

![width:900px Driver has License, 1:1](dot/cardinality-1to1.svg)

Each driver has exactly one license; each license belongs to exactly one driver.

---

## 1:n — Customer places Order

![width:900px Customer places Order, 1:n](dot/cardinality-1ton.svg)

A customer can place many orders (or none); each order belongs to exactly one customer.

---

## n:m — Tourist visits City

![width:900px Tourist visits City, n:m](dot/cardinality-nton.svg)

A tourist visits many cities; a city is visited by many tourists.

---

<!-- _class: invert -->

## Summary

- **Entity** = rectangle · **Relationship** = diamond · **Attribute** = oval
- Attributes can be **key**, **composite**, **multivalued**, or **derived**
- Cardinality — **1:1**, **1:n**, **n:m** — describes how entities relate through a relationship
- You now have every building block needed to model your own scenario in Chen notation
