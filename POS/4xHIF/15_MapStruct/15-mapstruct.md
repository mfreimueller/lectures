---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 15 - Map Struct
## POS - 4xHIF

---

## Warum DTOs?

- **API ≠ Domain** — Die REST-API soll nicht das interne Datenmodell exposed
- **Sicherheit** — Felder wie Passwörter, interne IDs, Versionen ausblenden
- **Versionierung** — API kann sich unabhängig vom Domain-Modell entwickeln
- **Performance** — Nur benötigte Felder übertragen (Lazy Loading vermeiden)

---

## DTOs vs. Entities

| Entity | DTO |
| --- | --- |
| JPA-annotiert (`@Entity`) | Einfaches POJO/Record |
| Hat Datenbank-Identität (`@Id`) | Nur Datencontainer, keine Identität |
| Kann Lazy-Loading-Proxies haben | Alle Werte sind eager geladen |
| Darf zirkuläre Referenzen haben | Flache, serialisierbare Struktur |
| Nicht für JSON-Serialisierung optimiert | Optimiert für API-Verträge |

---

## Manuelles Mapping — Boilerplate

```java
// Ohne MapStruct: viel Code, fehleranfällig
public BookDTO toDto(Book book) {
    if (book == null) return null;
    String authorName = book.getAuthor() != null
        ? book.getAuthor().getName() : null;
    return new BookDTO(
        book.getId(),
        book.getIsbn(),
        book.getTitle(),
        authorName,
        book.getPublicationYear()
    );
}
```

Pro Entity = ~10-15 Zeilen Boilerplate. Bei 10 Entities = 100+ Zeilen.

---

## MapStruct — Setup

```xml
<!-- pom.xml -->
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
    <version>1.6.3</version>
</dependency>

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
        <annotationProcessorPaths>
            <path>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct-processor</artifactId>
                <version>1.6.3</version>
            </path>
        </annotationProcessorPaths>
    </configuration>
</plugin>
```

MapStruct generiert zur Compile-Zeit die Implementierung.

---

## @Mapper — Der einfache Fall

```java
// Entity
@Entity
public class Book {
    @Id Long id;
    String isbn;
    String title;
    String author;
    int publicationYear;
}

// DTO
public record BookDTO(
    Long id, String isbn13,
    String title, String author, int year
) {}

// Mapper (Interface — MapStruct generiert die Impl!)
@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toDto(Book book);
}
```

MapStruct matched Felder automatisch nach Namen.

---

## @Mapping — Felder umbenennen

```java
@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "isbn", target = "isbn13")
    @Mapping(source = "publicationYear", target = "year")
    BookDTO toDto(Book book);
}
```

- `source` — Feld im Quellobjekt
- `target` — Feld im Zielobjekt
- `ignore = true` — Feld nicht mappen

---

## Beziehungen Mappen — Flattened

```java
// Ziel: book.author.name → bookDTO.authorName
@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "author.name", target = "authorName")
    @Mapping(source = "author.birthYear", target = "authorBirthYear")
    BookDTO toDto(Book book);
}

// Resultierendes JSON
{
    "id": 1,
    "title": "Clean Code",
    "authorName": "Robert C. Martin",
    "authorBirthYear": 1952
}
```

Punkt-Notation für verschachtelte Felder — MapStruct navigiert automatisch.

---

## Beziehungen Mappen — Nested

```java
// AuthorDTO
public record AuthorDTO(Long id, String name, int birthYear) {}

// Mapper mit verschachteltem DTO
@Mapper(componentModel = "spring", uses = AuthorMapper.class)
public interface BookMapper {

    @Mapping(source = "author", target = "author")
    BookDTO toDto(Book book);
}

// Resultierendes JSON
{
    "id": 1,
    "title": "Clean Code",
    "author": {
        "id": 1,
        "name": "Robert C. Martin",
        "birthYear": 1952
    }
}
```

`uses = AuthorMapper.class` — MapStruct delegiert automatisch.

---

## Custom Mappings — @Named

```java
@Mapper(componentModel = "spring")
public abstract class BookMapper {

    @Mapping(source = "createdAt", target = "createdAtFormatted",
             qualifiedByName = "formatTimestamp")
    public abstract BookDTO toDto(Book book);

    @Named("formatTimestamp")
    protected String formatLocalDateTime(LocalDateTime dt) {
        if (dt == null) return null;
        return dt.format(
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
    }
}
```

Alternativ: `@Mapping(expression = "java(...)")` für einfache Ausdrücke.

---

## MapStruct im Service-Layer

```java
@Service
@Transactional
public class BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    public BookService(BookRepository repository, BookMapper mapper) {
        this.repository = repository;
        this.mapper = mapper; // MapStruct-Impl wird injiziert
    }

    public BookDTO getById(Long id) {
        return repository.findById(id)
            .map(mapper::toDto)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND));
    }

    public List<BookDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }
}
```

---

## Projekt: DTO-Schicht für deine Domäne

<div class="highlight-box">
<ol>
<li>Erstelle für jede Entity ein passendes DTO (Record)</li>
<li>Lege Mapper-Interfaces mit <code>@Mapper(componentModel = "spring")</code> an</li>
<li>Optimiere Feldnamen für die API (<code>@Mapping</code>)</li>
<li>Entscheide: Flattened oder Nested für Beziehungen?</li>
<li>Ersetze manuelle Mapping-Methoden im Service durch MapStruct</li>
</ol>
</div>

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>Warum DTOs wichtig sind (Sicherheit, Versionierung, Performance)</li>
<li>MapStruct Setup mit Maven/Gradle</li>
<li>@Mapper und automatisches Field-Matching</li>
<li>@Mapping für Feld-Umbenennungen und Ignorieren</li>
<li>Flattened vs. Nested Relationship Mapping</li>
</ul>
</div>
