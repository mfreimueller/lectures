# Kata 2: Migrate H2 to Testcontainers

| Field | Value |
|-------|-------|
| Concepts | test migration, database compatibility, CI setup |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Take an existing `@DataJpaTest` class that uses H2 (from week 05)
2. Migrate it to use Testcontainers by extending `RepositoryTest` (from K1)
3. Run all tests and verify they pass against PostgreSQL

4. Add a PostgreSQL-specific test case:

   ```java
   @Test
   void shouldStoreAndQueryJsonData() {
       // PostgreSQL unterstützt JSONB nativ
   }
   ```

5. Test what happens when you:
   - Use a PostgreSQL-specific SQL function in a `@Query`
   - Use `boolean` vs `int` for boolean fields

### Questions to Consider

- Why did all tests pass with H2 but one fails with PostgreSQL?
- What happens when the Docker daemon is not running?
- How would you handle this in CI (GitHub Actions)?

### Extension

Configure the Testcontainers setup to work with GitHub Actions using `testcontainers-cloud` or Docker service containers.
