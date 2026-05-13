# Week 12 - ExceptionHandling_Validation

**Index:** 12
**Week in year:** 14
**Theory:** 2h | **Practice:** 2h

---

## Previously Learned Content

| Index | Week | Topics |
|-------|------|--------|
| 10-11 | Service Layer | @Service, @Transactional, Mockito |

## Learning Objectives

- Implement global exception handling with `@ControllerAdvice` and `@ExceptionHandler`
- Use Bean Validation (`@Valid`, `@NotBlank`, `@Size`, `@Pattern`) on DTOs
- Create custom validators for domain-specific rules
- Return structured error responses with `ProblemDetail` (RFC 7807)

## Presentation (slides/)

Covers Spring's exception handling mechanism: `@ControllerAdvice` for global handling, `@ExceptionHandler` for per-exception handling, Bean Validation annotations, custom validators, and the ProblemDetail format.

## Katas (katas/)

1. **K1: Global Exception Handler** — Create a @ControllerAdvice that handles common exceptions with structured responses.
2. **K2: Bean Validation** — Add @Valid annotations and custom validation to service commands.

## Materials

- Spring @ControllerAdvice docs
- Bean Validation 2.0 (JSR 380) specification
- RFC 7807 Problem Details
