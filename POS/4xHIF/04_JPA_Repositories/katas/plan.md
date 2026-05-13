# Katas - Week 04: JPA_Repositories

## K1: Entity Mapping
**Concepts:** @Entity, @Id, @GeneratedValue, CrudRepository
**Task:** Create a Book entity with id (auto-generated), isbn, title, year, and a BookRepository. Test CRUD operations in a main method.
**Duration:** 20 min

## K2: Relationships
**Concepts:** @OneToMany, @ManyToOne, cascade, fetch
**Task:** Add Member and Loan entities. A Member has many Loans, a Loan references one Book and one Member. Configure cascade types for deletions.
**Duration:** 25 min

## K3: Custom Queries
**Concepts:** derived queries, @Query, JPQL
**Task:** Write repository methods to: find books by author name, find loans overdue by a given date, count books by category. Use both derived naming and @Query.
**Duration:** 25 min
