# Katas - Week 09: Flyway_Migration

## K1: Initial Migration
**Concepts:** Flyway, V*__*.sql, schema creation
**Task:** Create `V1__Initial_Schema.sql` that creates all tables for your project domain. Disable `spring.jpa.generate-ddl` and verify Flyway creates the schema on startup.
**Duration:** 20 min

## K2: Schema Evolution
**Concepts:** ALTER TABLE, versioning, backward compatibility
**Task:** Create `V2__Add_Fields.sql` that adds a `phone` column to the member table and a `category` table with a foreign key to books. Verify existing data is preserved.
**Duration:** 25 min
