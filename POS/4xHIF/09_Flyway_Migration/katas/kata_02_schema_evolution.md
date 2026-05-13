# Kata 2: Schema Evolution

| Field | Value |
|-------|-------|
| Concepts | ALTER TABLE, versioning, backward compatibility |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Create `V2__Add_Phone_And_Category.sql`:
   - Add a `phone` column (`VARCHAR(20)`) to the `member` table
   - Create a `category` table with `id` and `name`
   - Create a `book_category` join table for many-to-many between book and category

2. Create `V3__Add_Active_Flag.sql`:
   - Add an `active` boolean column to the `member` table (default `true`)

3. Verify:
   - Start the app — both new migrations should run
   - The schema should have all new columns and tables
   - Existing data from V1 should still be there

4. Test backward compatibility:
   - Add a `@ManyToMany` Set<Category> to your Book entity
   - Verify `ddl-auto: validate` passes

### Questions to Consider

- What happens if you delete a migration file that was already executed?
- Can you add a `NOT NULL` column to an existing table with data?

### Extension

Simulate a migration conflict: edit V2's checksum by changing whitespace, then restart. Observe the error. Use `./mvnw flyway:repair` to fix.
