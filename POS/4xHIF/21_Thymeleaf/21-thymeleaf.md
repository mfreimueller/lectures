---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 21 - Thymeleaf
## POS - 4xHIF

---

## Server-Side Rendering

- Thymeleaf = HTML-Templates auf dem Server
- Einfach: Designer können HTML direkt bearbeiten
- Natürliches Templating: Templates funktionieren auch im Browser ohne Server
- Ideale Wahl für einfache WebUIs, Admins, Prototypen

---

## Thymeleaf Setup

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

Templates in `src/main/resources/templates/`, statische Dateien in `static/`.

---

## @Controller für Thymeleaf

```java
@Controller
@RequestMapping("/ui/books")
public class BookWebController {

    private final BookService bookService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAll());
        model.addAttribute("pageTitle", "Book Library");
        return "books/list"; // templates/books/list.html
    }
}
```

`@Controller` (nicht `@RestController`) gibt Template-Namen zurück.

---

## th:each — Listen durchlaufen

```html
<table>
    <tr th:each="book : ${books}">
        <td th:text="${book.id}">1</td>
        <td th:text="${book.title}">Title</td>
        <td th:text="${book.author}">Author</td>
        <td th:text="${book.year}">2025</td>
    </tr>
</table>

<p th:if="${#lists.isEmpty(books)}">No books found.</p>
```

---

## th:if / th:unless — Bedingungen

```html
<div th:if="${book.publicationYear} > 2000">
    <p>Dieses Buch ist aus dem 21. Jahrhundert.</p>
</div>

<div th:unless="${book.publicationYear} > 2000">
    <p>Klassiker!</p>
</div>

<div th:switch="${book.publicationYear}">
    <p th:case="1949">1984 - Ein besonderes Jahr!</p>
    <p th:case="*">Normales Jahr</p>
</div>
```

---

## th:object + th:field — Form Binding

```html
<form th:action="@{/ui/books}" th:object="${book}"
      method="post">
    <div>
        <label>ISBN:</label>
        <input type="text" th:field="*{isbn}" />
        <span th:if="${#fields.hasErrors('isbn')}"
              th:errors="*{isbn}">Error</span>
    </div>
    <div>
        <label>Title:</label>
        <input type="text" th:field="*{title}" />
    </div>
    <button type="submit">Save</button>
</form>
```

`th:field` setzt name, id, value und zeigt Validation-Fehler an.

---

## Fragment-Layouts — Wiederverwendbarkeit

```html
<!-- fragments/layout.html -->
<nav th:fragment="header">
    <a th:href="@{/ui/books}">Books</a>
    <a th:href="@{/ui/authors}">Authors</a>
</nav>

<footer th:fragment="footer">
    <p>© 2025 4xHIF Library App</p>
</footer>

<!-- Nutzung in einer Seite -->
<div th:replace="~{fragments/layout :: header}"></div>
<div th:replace="~{fragments/layout :: footer}"></div>
```

---

## Projekt: WebUI für deine Domäne

<div class="highlight-box">
<ol>
<li>Erstelle @Controller für deine Hauptentitäten</li>
<li>Baue eine Listenseite mit th:each und Filter</li>
<li>Erstelle Create/Edit-Formulare mit th:object</li>
<li>Erstelle ein wiederverwendbares Layout mit Navigation</li>
<li>Füge CSS für ein ansprechendes Design hinzu</li>
</ol>
</div>

---

## What We Learned Today

- Thymeleaf als Server-Side Template Engine
- @Controller für View-Rendering
- th:each, th:if, th:switch für Logik
- th:object + th:field für Formulare
- Fragment-Layouts mit th:replace
