# Week 02 - PlantUML_ValueObjects

**Index:** 02
**Week in year:** 3
**Theory:** 2h | **Practice:** 2h

---

## Previously Learned Content

| Index | Week | Topics |
|-------|------|--------|
| 00 | Introduction | Spring Boot Setup, First REST Controller, GitHub Classroom |
| 01 | UML & DDD | UML Class Diagrams, Aggregation/Composition, DDD Concepts |

## Learning Objectives

- Write PlantUML diagrams from Java code and vice versa
- Model a domain with Value Objects and RichTypes
- Distinguish between Value Objects and Entities in practice
- Implement immutable Value Objects with validation

## Presentation (slides/)

Introduces PlantUML syntax for class diagrams, then deep-dives into Value Objects: immutability, equals/hashCode, factory methods, and validation. Covers RichTypes as a pattern to replace primitive obsession.

## Katas (katas/)

1. **K1: PlantUML from Code** — Write PlantUML for a set of Java entities.
2. **K2: ValueObject Implementation** — Implement an `Email`, `Money`, or `ISBN` ValueObject.
3. **K3: RichType Refactoring** — Refactor a class that uses String/Long for everything to use RichTypes.

## Materials

- PlantUML Guide: https://plantuml.com/class-diagram
- PlantUML Online Editor: https://www.plantuml.com/plantuml/uml/
- Vaughn Vernon — Implementing Domain-Driven Design
