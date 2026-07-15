---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 19 - Graph QL
## POS - 4xHIF

---

## GraphQL vs REST

| REST | GraphQL |
| --- | --- |
| Mehrere Endpoints (resources) | Ein Endpoint (`/graphql`) |
| Server bestimmt Response-Struktur | Client bestimmt, welche Felder er braucht |
| Over- / Under-Fetching möglich | Nur angeforderte Felder werden geliefert |
| Versionierung über URI (v1, v2) | Evolution ohne Versionierung |
| HTTP-Caching einfach | Caching komplexer |

GraphQL ist kein REST-Ersatz, sondern eine Alternative für bestimmte Anwendungsfälle.

---

## Schema — Typen definieren (1/2)

```graphql
type Book {
    id: ID!
    isbn: String!
    title: String!
    author: Author!
    publicationYear: Int!
}

type Author {
    id: ID!
    name: String!
    birthYear: Int
    books: [Book!]
}
```

---

## Schema — Query, Mutation, Input (2/2)

```graphql
type Query {
    books: [Book!]!
    bookById(id: ID!): Book
}

type Mutation {
    createBook(input: BookInput!): Book!
}

input BookInput {
    isbn: String!
    title: String!
    authorId: ID!
    publicationYear: Int!
}
```

---

## Queries — Einfache Abfragen

```graphql
query {
    books {
        id
        title
        author {
            name
        }
    }
}
```

---

## Queries — Verschachtelte Abfragen

```graphql
query {
    bookById(id: 1) {
        title
        author {
            name
            birthYear
            books {
                title
            }
        }
    }
}
```

---

## Mutations — Daten schreiben

```graphql
mutation {
    createBook(input: {
        isbn: "9783161484100"
        title: "Clean Code"
        authorId: 1
        publicationYear: 2008
    }) {
        id
        title
        author { name }
    }
}
```

Mutations können auch Daten zurückgeben — nützlich für den aktualisierten Zustand.

---

## GraphQL in Spring Boot — Setup

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-graphql</artifactId>
</dependency>
```

GraphiQL (Web-IDE) unter `/graphiql` verfügbar.

---

## GraphQL in Spring Boot — Controller

```java
@Controller
public class BookController {
    @QueryMapping
    public List<BookDTO> books() { ... }
    @QueryMapping
    public BookDTO bookById(@Argument Long id) { ... }
    @MutationMapping
    public BookDTO createBook(@Valid @Argument BookInput input) { ... }
    @SchemaMapping
    public AuthorDTO getAuthor(BookDTO book) { ... }
}
```

---

## Katas + Projektarbeit

<div class="highlight-box">
<p>Die zweite Hälfte der Stunde gehört der Projektarbeit:</p>
<ol>
<li>Schließe fehlende REST-Endpoints ab</li>
<li>Integriere Paging + HATEOAS</li>
<li>Optional: Probiere GraphQL für deine Domäne</li>
</ol>
</div>
