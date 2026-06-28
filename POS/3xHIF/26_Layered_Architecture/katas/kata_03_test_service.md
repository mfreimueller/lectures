# Kata 3: Test the Service Layer

| Field | Value |
|-------|-------|
| Concepts | Unit testing without HTTP, JUnit 5, AssertJ, mocks |
| Difficulty | 4/5 |
| Duration | approx. 30 min |

### Task

Write JUnit 5 tests for your `TodoService`:
1. Test `create()` with valid input — assert the returned todo has an ID
2. Test `create()` with blank title — assert it throws `IllegalArgumentException`
3. Test `getById()` for an existing and non-existing todo
4. Test `delete()` — assert the todo is no longer found after deletion
5. Test `getAll()` returns the correct count after adding items

Use AssertJ for fluent assertions. No servlet container or HTTP needed.

### Extension

Use Mockito to mock the `TodoRepository` interface and verify that the service calls the correct repository methods.