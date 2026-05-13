# Katas - Week 08: Testcontainers_PostgreSQL

## K1: Testcontainers Setup
**Concepts:** @Testcontainers, PostgreSQLContainer, @DynamicPropertySource
**Task:** Create an abstract test base class that starts a PostgreSQL container and injects datasource properties for all repository tests.
**Duration:** 20 min

## K2: Migrate H2 to Testcontainers
**Concepts:** test migration, database compatibility, CI setup
**Task:** Take your existing @DataJpaTest classes and migrate them from H2 to Testcontainers. Verify all tests still pass. Add a test that catches a PostgreSQL-specific issue.
**Duration:** 25 min
