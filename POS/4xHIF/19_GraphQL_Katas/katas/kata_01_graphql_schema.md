# Kata 1: GraphQL Schema

| Field | Value |
|-------|-------|
| Concepts | Schema Definition Language (SDL), types, fields |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Add the GraphQL Spring Boot dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-graphql</artifactId>
</dependency>
```

2. Create `src/main/resources/graphql/schema.graphqls`:

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

type Query {
    books: [Book!]!
    bookById(id: ID!): Book
    booksByAuthor(authorName: String!): [Book!]!
}

type Mutation {
    createBook(input: BookInput!): Book!
    updateBook(id: ID!, input: BookInput!): Book!
    deleteBook(id: ID!): Boolean!
}

input BookInput {
    isbn: String!
    title: String!
    authorId: ID!
    publicationYear: Int!
}
```

3. Verify the schema by starting the app — Spring Boot GraphQL auto-loads `.graphqls` files from the `graphql/` directory

### Extension

Add a `rating` field (Float, 1-5) to Book and a `reviews` field ([Review!]!). Create the corresponding Review type in the schema.
