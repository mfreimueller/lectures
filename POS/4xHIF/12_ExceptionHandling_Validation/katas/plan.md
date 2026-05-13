# Katas - Week 12: ExceptionHandling_Validation

## K1: Global Exception Handler
**Concepts:** @ControllerAdvice, @ExceptionHandler, ProblemDetail, HTTP status codes
**Task:** Create a `GlobalExceptionHandler` that handles: EntityNotFoundException (404), IllegalArgumentException (400), and DataIntegrityViolationException (409). Return structured ProblemDetail responses.
**Duration:** 20 min

## K2: Bean Validation
**Concept:** @Valid, Bean Validation annotations, custom validator
**Task:** Add validation annotations to service commands (CreateMemberCommand, CreateBookCommand). Create a custom `@ValidIsbn` annotation that validates ISBN-10/ISBN-13 format. Test validation failures.
**Duration:** 25 min
