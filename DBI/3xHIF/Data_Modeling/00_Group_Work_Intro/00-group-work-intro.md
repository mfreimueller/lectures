---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# Data Modeling
## DBI 3xHIF — Course Introduction

---

## Course Roadmap

![width:1100px Course roadmap: five high-level chapters](mermaid/roadmap.svg)

We'll move from the basic building blocks of data modeling to translating a full
model into database tables.

---

## Grading

<div class="highlight-box">
<p>Data Modeling: 67%</p>
<p>SQL: 33%</p>
</div>

**You must be positive in both parts of DBI.**

---

## Grading - Data Modeling

- Exams: 50%
- Class Participation (Mitarbeit): 50%
   - Revisions
   - Active Participation
   - Exercise Completion
   - Project

---

## Agenda

1. What is Data Modeling?
2. From Real World to "Classes"
3. Today's Group Task
4. Deliverable
5. Summary

---

## Learning Goals

- I can explain why we model data before building a database
- I can spot recurring "things" (entities) and their properties in a real system
- I can sketch a first, informal table for such an entity

---

## What is Data Modeling?

Before we build any database, we need a **plan** of what data it should hold and how
that data is structured.

**Data modeling** is the process of describing that structure — first informally,
later with a precise notation (coming in the next lessons).

---

## From Real World to "Classes"

You already know this idea from programming: a **class** groups a "thing" (an object)
and the properties that describe it.

Data modeling starts the same way — look at a real system and ask:

- What **things** does it keep track of?
- What **properties** does each thing have?
- How do these things **relate** to each other?

---

## Example: A Journey Planner

A public transit journey planner keeps track of things like:

- **Station** — name, address, platform count
- **Route** — line number, operator
- **Departure** — time, destination, delay

Even without any formal notation, we can already sketch a rough table for each.

---

## Today's Group Task

In groups, pick **one** of the assigned websites and, focusing on its core function:

1. Sketch the "classes" it must be keeping track of behind the scenes
2. Build a sample **Excel table** per class, filled with realistic-looking data
3. *(Bonus)* If someone in your group has used a database tool before, sketch a first
   real data model

---

## Deliverable

- Submit your tables to Moodle
- One person per group presents your findings briefly

---

<!-- _class: invert -->

## Summary

- Data modeling describes a system's data **before** we build the database for it
- Look for recurring **things** (entities) and their **properties** — just like classes in programming
- Today: practice this informally, on a real website of your choice
