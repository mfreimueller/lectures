---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 12 - Exception Handling & Validation
## POS - 4xHIF

---

## Das Problem

```json
// Heute: unterschiedliche Fehlerformate
{ "error": "not found" }

// Morgen:
{ "message": "Member with id 42 not found",
  "timestamp": "2024-11-20T10:30:00" }
```

---

## Das Problem — Lösung

Ziel: Einheitliches, standardisiertes Fehlerformat für die ganze API.

---

## @ControllerAdvice

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleNotFound(
            EntityNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problem.setTitle("Entity not found");
        problem.setDetail(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }
}
```

`@ControllerAdvice` = globaler Exception-Handler für ALLE Controller.

---

## ProblemDetail (RFC 7807)

```json
{
    "type": "about:blank",
    "title": "Entity not found",
    "status": 404,
    "detail": "Member with id 42 not found"
}
```

- Standardisiertes Fehlerformat (RFC 7807 / Problem Details)
- Wird von Spring ab Version 6 nativ unterstützt
- Maschinenlesbar + menschenlesbar

---

## Exception-Handler — 404 + 400

```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ProblemDetail handleNotFound(EntityNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handleBadArgument(IllegalArgumentException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
```

---

## Exception-Handler — 409

```java
@ExceptionHandler(DataIntegrityViolationException.class)
public ProblemDetail handleConstraintViolation(
        DataIntegrityViolationException ex) {
    ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.CONFLICT);
    problem.setTitle("Data integrity violation");
    problem.setDetail("This operation would violate a database constraint");
    return problem;
}
```

---

## Bean Validation — Motivation

```java
// Ohne Validation: viel Boilerplate im Controller
@PostMapping("/members")
public Member createMember(@RequestBody Member member) {
    if (member.getName() == null || member.getName().isBlank()) {
        throw new IllegalArgumentException("Name is required");
    }
    if (member.getEmail() == null || !member.getEmail().contains("@")) {
        throw new IllegalArgumentException("Invalid email");
    }
    return memberService.createMember(member);
}
```

Mit Bean Validation: deklarativ statt imperativ.

---

## Bean Validation — Annotations

```java
public record CreateMemberCommand(
    @NotBlank(message = "Name is required") String name,
    @NotBlank @Email String email,
    @Pattern(regexp = "^\\+?[0-9\\s-]{6,20}$") String phone
) {}
```

Wichtige Annotationen:

- `@NotBlank`, `@NotEmpty`, `@NotNull`
- `@Size(min, max)`, `@Min`, `@Max`
- `@Email`, `@Pattern`
- `@Past`, `@Future`

---

## @Valid im Controller

```java
@RestController @RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;
    @PostMapping
    public Member createMember(@Valid @RequestBody CreateMemberCommand cmd) {
        return memberService.createMember(cmd);
    }
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id,
            @Valid @RequestBody UpdateMemberCommand cmd) {
        return memberService.updateMember(id, cmd);
    }
}
```

---

## @Valid — Wirkung

`@Valid` löst die Validierung aus. Bei Fehlern → `MethodArgumentNotValidException`.

---

## Validation Errors — Handler

```java
@ExceptionHandler(MethodArgumentNotValidException.class)
public ProblemDetail handleValidationErrors(
        MethodArgumentNotValidException ex) {
    ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problem.setTitle("Validation failed");
    String errors = ex.getBindingResult()
        .getFieldErrors().stream()
        .map(e -> e.getField() + ": " + e.getDefaultMessage())
        .collect(Collectors.joining(", "));
    problem.setDetail(errors);
    return problem;
}
```

---

## Validation Errors — Response

```json
{
    "title": "Validation failed",
    "status": 400,
    "detail": "email: Must be a valid email address, name: Name is required"
}
```

---

## Custom Validator — Annotation

```java
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = IsbnValidator.class)
public @interface ValidIsbn {
    String message() default "Invalid ISBN format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
```

---

## Custom Validator — Implementierung

```java
public class IsbnValidator implements
        ConstraintValidator<ValidIsbn, String> {
    @Override
    public boolean isValid(String isbn, ConstraintValidatorContext ctx) {
        if (isbn == null) return false;
        return isbn.matches("^(\\d{13}|\\d{10})$");
    }
}
```

Verwendung: `@ValidIsbn String isbn`

---

## Validierung im Service

```java
@Service
@Validated  // Ermöglicht @Valid auf Methoden-Parametern
public class LibraryService {

    public Book createBook(@Valid CreateBookCommand command) {
        // command ist hier bereits validiert
        Book book = new Book(command.isbn(), command.title(), command.year());

        if (bookRepository.findByIsbn(command.isbn()).isPresent()) {
            throw new DuplicateIsbnException(command.isbn());
        }

        return bookRepository.save(book);
    }
}
```

Mit `@Validated` auf der Klasse und `@Valid` am Parameter.

---

## Projekt: Exception Handling

<div class="highlight-box">
<ol>
<li>Erstelle <code>GlobalExceptionHandler</code> mit @ControllerAdvice</li>
<li>Behandle: 404, 400, 409, 500</li>
<li>Füge Bean-Validation zu Command-Objekten hinzu</li>
<li>Erstelle einen Custom Validator (z.B. @ValidIsbn)</li>
<li>Teste: Sende ungültige Daten via curl/Postman</li>
</ol>
</div>

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>@ControllerAdvice + @ExceptionHandler für globale Fehlerbehandlung</li>
<li>ProblemDetail (RFC 7807) für standardisierte Fehler</li>
<li>Bean Validation: @NotBlank, @Email, @Pattern, @Valid</li>
<li>Custom Validator mit @Constraint</li>
<li>@Validated im Service für Methoden-Parameter</li>
</ul>
</div>
