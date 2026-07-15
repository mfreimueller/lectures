---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 18 - Paging & Sorting
## POS - 4xHIF

---

## Warum Pagination?

- 10.000 Bücher auf einmal laden = langsam, speicherintensiv, schlechte UX
- Mobile Clients brauchen kleine Antworten
- Pagination = effizient, skalierbar, benutzerfreundlich
- Spring Data bietet `Pageable` und `Page` out-of-the-box

---

## Pageable — Das Interface

```java
public interface Pageable {
    int getPageNumber();    // aktuelle Seite (0-indexed)
    int getPageSize();      // Elemente pro Seite
    Sort getSort();         // Sortierung
    long getOffset();       // Berechneter Offset
    Pageable next();        // Nächste Seite
    Pageable previousOrFirst(); // Vorherige Seite
}
```

Spring extrahiert `page`, `size`, `sort` aus Query-Parametern.

---

## @PageableDefault — Standardwerte

```java
@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping
    public Page<BookDTO> getAll(
            @PageableDefault(
                page = 0,
                size = 20,
                sort = "title",
                direction = Sort.Direction.ASC)
            Pageable pageable) {

        return service.getAll(pageable);
    }
}
```

Wenn der Client keine Parameter schickt: Seite 0, 20 Einträge, sortiert nach title aufsteigend.

---

## Page<T> — Response mit Metadaten

```json
{
    "content": [
        { "id": 1, "title": "Clean Code", ... },
        { "id": 2, "title": "Pragmatic Programmer", ... }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 5,
        "sort": { "sorted": true, "unsorted": false }
    },
    "totalElements": 42,
    "totalPages": 9,
    "first": true,
    "last": false,
    "number": 0,
    "size": 5,
    "numberOfElements": 5,
    "empty": false
}
```

---

## Sort — Sortierung definieren

```java
Sort sort = Sort.by("title").ascending();

Sort sort = Sort.by("author").ascending()
                .and(Sort.by("publicationYear").descending());

Sort sort = Sort.by(
    new Sort.Order(Sort.Direction.ASC, "author"),
    new Sort.Order(Sort.Direction.DESC, "publicationYear")
);
```

Client: `?sort=author,asc&sort=publicationYear,desc`

---

## Sort Injection verhindern

```java
private Sort sanitize(Sort sort) {
    return sort.stream()
        .filter(o -> ALLOWED_SORT_FIELDS.contains(o.getProperty()))
        .reduce(Sort::and)
        .orElse(Sort.by("id"));
}
```

Nie blind `sort` akzeptieren — whitelist erlaubte Felder!

---

## Pagination im Service-Layer

```java
@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    public Page<BookDTO> getAll(Pageable pageable) {
        return repository.findAll(pageable)
            .map(mapper::toDto);
    }

    public Page<BookDTO> search(
            String author, Integer year, Pageable pageable) {
        return repository.searchBooks(author, year, pageable)
            .map(mapper::toDto);
    }
}
```

Service leitet Pageable an Repository weiter — Query wird mit LIMIT/OFFSET ausgeführt.

---

## Custom Page DTO

```java
public record PagedResponse<T>(
    List<T> content,
    int page,
    int size,
    long totalElements,
    int totalPages,
    boolean first,
    boolean last,
    Map<String, String> links
) {
    public static <T> PagedResponse<T> of(Page<T> page) {
        return new PagedResponse<>(
            page.getContent(),
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages(),
            page.isFirst(),
            page.isLast(),
            new HashMap<>()
        );
    }
}
```

---

## Pagination + HATEOAS

```java
@GetMapping
public PagedResponse<BookDTO> getAll(
        @PageableDefault(size = 5) Pageable pageable,
        UriComponentsBuilder uriBuilder) {

    Page<BookDTO> page = service.getAll(pageable);
    PagedResponse<BookDTO> response = PagedResponse.of(page);

    String baseUri = uriBuilder.path("/api/books").toUriString();
    response.links().put("self",
        baseUri + "?page=" + pageable.getPageNumber()
        + "&size=" + pageable.getPageSize());

    if (!page.isFirst()) {
        response.links().put("first",
            baseUri + "?page=0&size=" + pageable.getPageSize());
        response.links().put("prev",
            baseUri + "?page=" + (pageable.getPageNumber() - 1)
            + "&size=" + pageable.getPageSize());
    }
    if (!page.isLast()) {
        response.links().put("next",
            baseUri + "?page=" + (pageable.getPageNumber() + 1)
            + "&size=" + pageable.getPageSize());
        response.links().put("last",
            baseUri + "?page=" + (page.getTotalPages() - 1)
            + "&size=" + pageable.getPageSize());
    }
    return response;
}
```

---

## Projekt: Paging für deine Endpoints

<div class="highlight-box">
<ol>
<li>Füge <code>Pageable</code> zu allen Listen-Endpoints hinzu</li>
<li>Konfiguriere sinnvolle Defaults (size=10 oder 20)</li>
<li>Erlaube Sortierung nur für whitelistete Felder</li>
<li>Erstelle einen Custom Page DTO für saubere API-Responses</li>
<li>Füge Navigation-Links (first/prev/next/last) hinzu</li>
</ol>
</div>

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>Pageable und @PageableDefault</li>
<li>Page&lt;T&gt; als standardisierte Response</li>
<li>Sort.by() und multiple Sortierkriterien</li>
<li>Sort Injection verhindern (Whitelist)</li>
<li>Pagination im Service-Layer</li>
</ul>
</div>
