# Kata 2: Bean Validation

| Field | Value |
|-------|-------|
| Concept | @Valid, Bean Validation annotations, custom validator |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Add validation annotations to command records:

```java
public record CreateMemberCommand(
    @NotBlank(message = "Name is required")
    String name,

    @NotBlank
    @Email(message = "Must be a valid email address")
    String email,

    @Pattern(regexp = "^\\+?[0-9\\s-]{6,20}$",
             message = "Invalid phone number format")
    String phone
) {}

public record CreateBookCommand(
    @NotBlank
    @ValidIsbn
    String isbn,

    @NotBlank
    @Size(min = 1, max = 255)
    String title,

    @Min(1900)
    int year
) {}
```

2. Create a custom `@ValidIsbn` validator:
   - Annotation: `@ValidIsbn` with `@Constraint(validatedBy = IsbnValidator.class)`
   - Validator: Checks ISBN-10 (10 digits) or ISBN-13 (13 digits) format

3. Add `@Valid` to controller methods and test with MockMvc:
   ```java
   @Test
   void createMember_withInvalidEmail_shouldReturn400() throws Exception {
       String invalidJson = """
           { "name": "Alice", "email": "not-an-email" }
           """;

       mockMvc.perform(post("/api/members")
               .contentType(MediaType.APPLICATION_JSON)
               .content(invalidJson))
           .andExpect(status().isBadRequest())
           .andExpect(jsonPath("$.title").value("Validation failed"));
   }
   ```

### Extension

Create a class-level validator `@ValidLoan` that checks `returnDate` is after `borrowDate` on a `CreateLoanCommand`.
