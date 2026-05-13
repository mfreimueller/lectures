# Kata 3: Validation

| Field | Value |
|-------|-------|
| Concepts | Input validation, Jakarta Validation |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Add validation to a REST endpoint:
1. Create a `CreateBookDto` with Jakarta Validation annotations (@NotBlank, @NotNull, @Pattern, @Min, @Max)
2. Implement a validation utility that checks the DTO and collects errors
3. Return a 400 response with all validation errors as a list

### Example Output

Request:
```json
{"title": "", "isbn": "invalid", "publishedYear": 1800}
```

Response (400):
```json
{"errors": ["title must not be blank", "isbn must be 13 digits", "publishedYear must be >= 1900"]}
```

### Extension

Use Jakarta Validation's `Validator` API instead of manual validation.
