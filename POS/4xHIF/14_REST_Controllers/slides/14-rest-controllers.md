---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 14 - REST Controllers
## POS - 4xHIF

---

## Was ist REST?

- **RE**presentational **S**tate **T**ransfer
- Architekturstil für verteilte Systeme
- Ressourcen werden über URIs identifiziert
- HTTP-Methoden definieren Aktionen auf Ressourcen
- Zustandslos: Jeder Request enthält alle nötigen Informationen

---

## HTTP-Methoden im Überblick

| Methode | Aktion | Erfolgsstatus |
| --- | --- | --- |
| `GET` | Ressource lesen | `200 OK` |
| `POST` | Ressource erstellen | `201 Created` |
| `PUT` | Ressource ersetzen | `200 OK` |
| `PATCH` | Ressource teilweise aktualisieren | `200 OK` |
| `DELETE` | Ressource löschen | `204 No Content` |

Idempotent: GET, PUT, DELETE, PATCH — Mehrfachausführung gleiches Ergebnis

---

## @RestController vs @Controller

```java
// @Controller + @ResponseBody = @RestController
@RestController
@RequestMapping("/api/books")
public class BookController {
    // ...
}
```

- `@Controller` — gibt View-Namen (Thymeleaf) zurück
- `@RestController` — gibt Daten (JSON/XML) direkt zurück
- `@RestController` ist **kurz** für `@Controller + @ResponseBody`
- Jackson serialisiert Rückgabewerte automatisch zu JSON

---

## @GetMapping — Lesen von Ressourcen

```java
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository repository;

    // GET /api/books — alle Bücher
    @GetMapping
    public List<Book> getAll() {
        return repository.findAll();
    }

    // GET /api/books/42 — ein Buch
    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Book not found"));
    }
}
```

---

## @PostMapping — Ressourcen erstellen

```java
// POST /api/books — neues Buch anlegen
@PostMapping
public Book create(@RequestBody Book book) {
    return repository.save(book);
}
```

```json
// Request Body
{
    "isbn": "9783161484100",
    "title": "Clean Code",
    "author": "Robert C. Martin",
    "publicationYear": 2008
}
```

Der Client sendet JSON → Jackson wandelt in `Book`-Record um.

---

## @PutMapping / @DeleteMapping / @PatchMapping

```java
// PUT /api/books/42 — komplett ersetzen
@PutMapping("/{id}")
public Book update(@PathVariable Long id, @RequestBody Book book) {
    return repository.update(id, book);
}

// DELETE /api/books/42 — löschen
@DeleteMapping("/{id}")
public void delete(@PathVariable Long id) {
    repository.deleteById(id);
}

// PATCH /api/books/42 — teilweise aktualisieren
@PatchMapping("/{id}")
public Book partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
    return repository.partialUpdate(id, fields);
}
```

---

## @RequestParam — Query-Parameter

```java
@GetMapping List<Book> search(
        @RequestParam(required = false) String author,
        @RequestParam(required = false) Integer year,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size) {
    return repository.search(author, year, page, size); }
```

- `required = false` — Parameter ist optional
- `defaultValue` — Standardwert falls nicht angegeben
- Automatische Typkonvertierung (String → int, Integer, etc.)

---

## @PathVariable — Pfadvariablen

```java
@GetMapping("/{bookId}/reviews/{reviewId}")
public Review getReview(
        @PathVariable Long bookId,
        @PathVariable Long reviewId) {
    return reviewService.findReview(bookId, reviewId);
}
```

- Werte aus dem URI-Pfad (geschweifte Klammern)
- Variablenname muss mit dem Pfadplatzhalter übereinstimmen
- Oder explizit: `@PathVariable("book-id") Long bookId`

---

## @RequestBody — JSON empfangen

```java
@PostMapping
public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
    Book saved = repository.save(book);
    URI location = URI.create("/api/books/" + saved.id());
    return ResponseEntity.created(location).body(saved);
}
```

- `@RequestBody` bindet JSON Payload an Java-Objekt
- Jackson konfiguriert: Datumsformate, Ignorieren unbekannter Felder
- `@Valid` aktiviert Bean-Validation

---

## ResponseEntity — Volle Kontrolle

```java
@GetMapping("/{id}")
public ResponseEntity<Book> getById(@PathVariable Long id) {
    return repository.findById(id)
        .map(book -> ResponseEntity.ok(book))
        .orElse(ResponseEntity.notFound().build());
}

@PostMapping
public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
    if (repository.existsByIsbn(book.isbn())) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    Book saved = repository.save(book);
    return ResponseEntity
        .created(URI.create("/api/books/" + saved.id()))
        .body(saved);
}
```

---

## Wichtige HTTP-Statuscodes

| Code | Bedeutung | Verwendung |
| --- | --- | --- |
| `200` | OK | Erfolgreiche GET/PUT/PATCH-Requests |
| `201` | Created | Ressource wurde angelegt (POST) |
| `204` | No Content | Erfolgreich gelöscht (DELETE) |
| `400` | Bad Request | Validierungsfehler, ungültige Eingabe |
| `404` | Not Found | Ressource existiert nicht |
| `409` | Conflict | Duplicate, inkonsistenter Zustand |
| `500` | Internal Server Error | Unerwarteter Fehler (nie absichtlich!) |

---

## Jackson — JSON Serialisierung

```java
public record Book(
    Long id,

    @JsonProperty("isbn13")
    @NotBlank String isbn,

    String title,
    String author,

    @JsonProperty("year")
    int publicationYear,

    @JsonIgnore
    String internalNotes
) {}
```

---

## Jackson — JSON Serialisierung

```json
{
    "id": 1,
    "isbn13": "9783161484100",
    "title": "Clean Code",
    "author": "Robert C. Martin",
    "year": 2008
    // internalNotes wird ignoriert
}
```

---

## Projekt: REST-API für deine Domäne

<div class="highlight-box">
<ol>
<li>Wähle eine Entität aus deiner Domäne (z.B. Book, Customer, Product)</li>
<li>Erstelle einen <code>@RestController</code> mit vollem CRUD</li>
<li>Verwende <code>ResponseEntity</code> mit korrekten Statuscodes</li>
<li>Füge <code>@Valid</code> und Query-Parameter-Filter hinzu</li>
<li>Teste alle Endpoints mit curl, httpie oder Postman</li>
</ol>
</div>

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>REST-Prinzipien und HTTP-Methoden</li>
<li>@RestController vs @Controller</li>
<li>Request Mapping (@GetMapping, @PostMapping, etc.)</li>
<li>@RequestParam, @PathVariable, @RequestBody</li>
<li>ResponseEntity und HTTP-Statuscodes</li>
</ul>
</div>
