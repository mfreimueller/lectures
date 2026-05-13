# Katas - Week 05: UnitTesting_JPA_H2

## K1: Repository CRUD Tests
**Concepts:** @DataJpaTest, save, findById, findAll, delete
**Task:** Write a test class for BookRepository. Test: save and find, save multiple and findAll, update via save, delete by id. Use @BeforeEach to create test data.
**Duration:** 20 min

## K2: Relationship Tests
**Concepts:** cascade, lazy loading, bidirectional helpers
**Task:** Write tests for Member → Loan → Book relationships. Verify: cascade persist works, deleting a Member cascades to Loans, lazy loading does not throw LazyInitializationException with @Transactional.
**Duration:** 25 min

## K3: Custom Query Tests
**Concepts:** derived queries, @Query, edge cases
**Task:** Write tests for custom queries: find overdue loans, search books by title keyword, count books by author. Include edge cases: empty results, null parameters, case sensitivity.
**Duration:** 25 min
