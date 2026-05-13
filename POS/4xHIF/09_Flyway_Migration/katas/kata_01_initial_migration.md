# Kata 1: Initial Migration

| Field | Value |
|-------|-------|
| Concepts | Flyway, V*__*.sql, schema creation |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Add Flyway dependency to `pom.xml`:
   - `flyway-core`
   - `flyway-database-postgresql`

2. Create `src/main/resources/db/migration/V1__Initial_Schema.sql`:
   - Create all tables for your project domain (at least: book, member, loan)
   - Use `BIGSERIAL` for primary keys
   - Add `NOT NULL`, `UNIQUE`, and foreign key constraints
   - Add `created_at` timestamps with `DEFAULT NOW()`

3. Configure `application.yml`:
   ```yaml
   spring:
     flyway:
       enabled: true
       baseline-on-migrate: true
     jpa:
       hibernate:
         ddl-auto: validate
   ```

4. Disable `spring.jpa.generate-ddl` and `spring.jpa.hibernate.ddl-auto: update`

5. Start the application and verify:
   - Tables are created by Flyway (check PostgreSQL)
   - The `flyway_schema_history` table exists
   - Entity mappings match the schema

### Example

```sql
CREATE TABLE book (
    id       BIGSERIAL PRIMARY KEY,
    isbn     VARCHAR(13) NOT NULL UNIQUE,
    title    VARCHAR(255) NOT NULL,
    year     INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);
```

### Extension

Add a `V1_1__Seed_Data.sql` migration that inserts sample data (at least 3 books and 2 members).
