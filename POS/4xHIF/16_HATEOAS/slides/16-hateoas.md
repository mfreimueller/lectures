---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 16 - HATEOAS
## POS - 4xHIF

---

## Richardson Maturity Model

- **Level 0** — Swamp of POX (Plain Old XML): Ein Endpoint, eine Methode
- **Level 1** — Resources: Verschiedene URIs für verschiedene Ressourcen
- **Level 2** — HTTP Verbs: Nutzung von GET, POST, PUT, DELETE
- **Level 3** — Hypermedia Controls: Die API sagt dem Client, was er als nächstes tun kann

Level 3 = HATEOAS — Der Goldstandard für REST-APIs

---

## Was ist HATEOAS?

> "Hypertext as the Engine of Application State" — Roy Fielding

- Der Server liefert **Links** mit jeder Response
- Der Client navigiert ausschließlich über diese Links
- Keine hardcodierten URIs im Client!
- Die API ist **selbstbeschreibend** und **entkoppelt**

---

## Ohne HATEOAS — Hartcodierte Clients

```java
// Client muss URIs kennen — bricht bei API-Änderungen
ResponseEntity<Book> response = restTemplate.getForEntity(
    "http://api.example.com/books/42", Book.class);

Long authorId = response.getBody().getAuthorId();
restTemplate.getForEntity(
    "http://api.example.com/authors/" + authorId, Author.class);
```

Problem: Ändert sich die URI-Struktur, ist der Client kaputt.

---

## Mit HATEOAS — Navigierbar

```java
ResponseEntity<EntityModel<BookDTO>> response = restTemplate
    .getForEntity("http://api.example.com/books/42", ...);

// Client folgt dem "author"-Link
Link authorLink = response.getBody()
    .getLink("author").orElseThrow();
ResponseEntity<AuthorDTO> authorResponse = restTemplate
    .getForEntity(authorLink.getUri(), AuthorDTO.class);
```

Der Client kennt nur Link-Relation-Namen — URIs sind austauschbar.

---

## Spring HATEOAS Dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>
```

Enthält: EntityModel, CollectionModel, Link, WebMvcLinkBuilder — alles was man braucht.

---

## EntityModel — Self-Links

```java
@GetMapping("/{id}")
public EntityModel<BookDTO> getById(@PathVariable Long id) {
    BookDTO dto = service.getById(id);
    return EntityModel.of(dto,
        linkTo(methodOn(BookController.class).getById(id))
            .withSelfRel());
}
```

```json
{
    "id": 1,
    "title": "Clean Code",
    "_links": {
        "self": { "href": "http://localhost:8080/api/books/1" }
    }
}
```

---

## CollectionModel — Ressourcensammlungen

```java
@GetMapping
public CollectionModel<BookDTO> getAll() {
    List<BookDTO> books = service.getAll();
    return CollectionModel.of(books,
        linkTo(methodOn(BookController.class).getAll())
            .withSelfRel());
}
```

```json
{
    "_embedded": {
        "bookDTOList": [
            { "id": 1, "title": "Clean Code", "_links": {...} },
            { "id": 2, "title": "Pragmatic Programmer", "_links": {...} }
        ]
    },
    "_links": {
        "self": { "href": "http://localhost:8080/api/books" }
    }
}
```

---

## WebMvcLinkBuilder — Links bauen

```java
import static org.springframework.hateoas.server.mvc
    .WebMvcLinkBuilder.*;

// Typischer Weg: linkTo + methodOn
linkTo(methodOn(BookController.class).getById(1L)).withSelfRel();

// Ohne methodOn (manuelle Pfadangabe)
linkTo(BookController.class).slash(1L).withSelfRel();

// Link zu einer anderen Controller-Methode
linkTo(methodOn(AuthorController.class).getById(1L))
    .withRel("author");

// Externer Link
Link.of("https://api.example.com/docs", "profile");
```

`methodOn` ist typsicher und nutzt die `@RequestMapping`-Annotationen.

---

## Pagination + HATEOAS

```java
@GetMapping
public CollectionModel<BookDTO> getPage(
        @RequestParam int page,
        @RequestParam int size) {

    Page<BookDTO> bookPage = service.getPage(page, size);

    List<Link> links = new ArrayList<>();
    links.add(linkTo(methodOn(BookController.class)
        .getPage(page, size)).withSelfRel());

    if (bookPage.hasNext())
        links.add(linkTo(methodOn(BookController.class)
            .getPage(page + 1, size)).withRel("next"));
    if (bookPage.hasPrevious())
        links.add(linkTo(methodOn(BookController.class)
            .getPage(page - 1, size)).withRel("prev"));

    return CollectionModel.of(bookPage.getContent(), links);
}
```

---

## API Root Endpoint

```java
@RestController
@RequestMapping("/api")
public class ApiRootController {

    @GetMapping
    public CollectionModel<Void> root() {
        return CollectionModel.of(List.of(),
            linkTo(methodOn(ApiRootController.class).root())
                .withSelfRel(),
            linkTo(methodOn(BookController.class).getAll())
                .withRel("books"),
            linkTo(methodOn(AuthorController.class).getAll())
                .withRel("authors"),
            linkTo(methodOn(LoanController.class).getAll())
                .withRel("loans")
        );
    }
}
```

Ein einziger Einstiegspunkt — der Client findet alles über Links.

---

## HATEOAS + DTOs mit MapStruct

```java
@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "links", ignore = true)
    BookDTO toDto(Book book);

    // Im Service: DTO erzeugen, dann Links hinzufügen
    default EntityModel<BookDTO> toEntityModel(Book book) {
        BookDTO dto = toDto(book);
        return EntityModel.of(dto,
            linkTo(methodOn(BookController.class)
                .getById(book.getId())).withSelfRel());
    }
}
```

Die Links werden erst im Service/Controller hinzugefügt — der Mapper bleibt fokussiert.

---

## Projekt: HATEOAS für deine API

<div class="highlight-box">
<ol>
<li>Füge Spring HATEOAS als Dependency hinzu</li>
<li>Erweitere deine DTOs mit <code>RepresentationModel</code></li>
<li>Füge Self-Links zu allen Einzelressourcen-Endpoints hinzu</li>
<li>Erstelle einen <code>/api</code> Root-Endpoint</li>
<li>Teste die Navigierbarkeit: Starte bei <code>/api</code> und folge den Links</li>
</ol>
</div>

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>Richardson Maturity Model (Level 0-3)</li>
<li>HATEOAS-Prinzip — API als Hypertext</li>
<li>EntityModel und CollectionModel</li>
<li>WebMvcLinkBuilder und methodOn</li>
<li>API Root Endpoint für vollständige Navigierbarkeit</li>
</ul>
</div>
