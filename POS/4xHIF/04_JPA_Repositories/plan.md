# Week 04 - JPA_Repositories

**Index:** 04
**Week in year:** 5
**Theory:** 2h | **Practice:** 2h

---

## Previously Learned Content

| Index | Week | Topics |
|-------|------|--------|
| 03 | Milestone 1 | Domain Model Presentation, Spring Boot + JPA Setup |

## Learning Objectives

- Map entities with `@Entity`, `@Id`, `@GeneratedValue`
- Use Spring Data JPA `Repository<T, ID>` for CRUD operations
- Define `@OneToMany`, `@ManyToOne`, `@ManyToMany` relationships
- Configure cascade types and fetch strategies appropriately
- Write custom query methods using Spring Data naming conventions

## Presentation (slides/)

Covers JPA entity mapping with annotations, Spring Data repository interfaces, relationship mappings with cascade and fetch types, and custom query derivation from method names.

## Katas (katas/)

1. **K1: Entity Mapping** — Map a simple Book entity with @Entity and repository.
2. **K2: Relationships** — Add Member and Loan entities with `@ManyToOne`/`@OneToMany` relationships.
3. **K3: Custom Queries** — Write custom repository methods using naming conventions and `@Query`.

## Materials

- Spring Data JPA Reference Guide
- Baeldung: Spring Data JPA Tutorial
- Hibernate ORM Documentation
