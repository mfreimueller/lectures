# Kata 2: CRUD Form

| Field | Value |
|-------|-------|
| Concepts | th:object, th:field, form binding, POST handling |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Create a create book page `templates/books/create.html`:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Create Book</title>
</head>
<body>
    <h1>Create Book</h1>

    <form th:action="@{/ui/books}" th:object="${book}" method="post">
        <div>
            <label>ISBN:</label>
            <input type="text" th:field="*{isbn}" />
            <span th:if="${#fields.hasErrors('isbn')}"
                  th:errors="*{isbn}">Error</span>
        </div>
        <div>
            <label>Title:</label>
            <input type="text" th:field="*{title}" />
            <span th:if="${#fields.hasErrors('title')}"
                  th:errors="*{title}">Error</span>
        </div>
        <div>
            <label>Author:</label>
            <input type="text" th:field="*{author}" />
        </div>
        <div>
            <label>Year:</label>
            <input type="number" th:field="*{publicationYear}" />
        </div>
        <button type="submit">Save</button>
    </form>

    <a th:href="@{/ui/books}">Back to list</a>
</body>
</html>
```

2. Add controller methods for GET (form) and POST (submit):

```java
@GetMapping("/create")
public String showCreateForm(Model model) {
    model.addAttribute("book", new BookDTO(null, "", "", "", 2025));
    return "books/create";
}

@PostMapping
public String createBook(@Valid @ModelAttribute("book") BookDTO dto,
                         BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "books/create";
    }
    bookService.create(dto);
    return "redirect:/ui/books";
}
```

3. Add an edit form (pre-filled) and a delete button to the list view

### Extension

Add client-side validation with HTML5 attributes (`required`, `min`, `max`) in addition to server-side validation. Add a confirm dialog before delete using JavaScript.
