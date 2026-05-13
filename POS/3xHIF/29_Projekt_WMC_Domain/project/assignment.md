# POS-WMC Project - Week 29: Domain Model, JPA Entities, Relationships

## Task

Define all JPA entities for your project domain with proper relationships and inheritance.

### Requirements

1. Create all JPA entity classes (at least 6 tables)
2. Implement at least one 1:1 relationship using @OneToOne
3. Implement at least one 1:n relationship using @OneToMany/@ManyToOne
4. Implement at least one inheritance hierarchy using JOINED strategy
5. Use @Embeddable for at least one value object
6. Create a Repository class for each entity
7. Write JPQL queries in repositories for common data access patterns
8. Ensure all entities have proper @Entity, @Table, @Id, @GeneratedValue annotations

### Example Output

Entities for a library:
- User, Address (1:1), Category, Book (1:n), PhysicalBook/EBook (inheritance), Loan, Review, Author

### Extension

Add lifecycle callbacks (@PrePersist, @PreUpdate) for automatic timestamp management.
