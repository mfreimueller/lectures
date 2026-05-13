# Kata 3: Layout with Fragments

| Field | Value |
|-------|-------|
| Concepts | th:fragment, th:insert, th:replace, layout dialect |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Create a layout fragment `templates/fragments/layout.html`:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:fragment="head(title)">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title th:text="${title}">My App</title>
    <link rel="stylesheet" th:href="@{/css/style.css}">
</head>
<body>
    <header th:fragment="header">
        <nav>
            <a th:href="@{/ui/books}">Books</a>
            <a th:href="@{/ui/authors}">Authors</a>
            <a th:href="@{/ui/books/create}">Add Book</a>
        </nav>
    </header>

    <main th:fragment="content">
        <!-- Page content goes here -->
    </main>

    <footer th:fragment="footer">
        <p>&copy; 2025 4xHIF Library App</p>
    </footer>
</body>
</html>
```

2. Refactor `books/list.html` to use the layout:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      th:replace="~{fragments/layout :: head(title = 'Book List')}">
<head></head>
<body>
    <div th:replace="~{fragments/layout :: header}"></div>

    <main th:fragment="content">
        <h1>Book List</h1>
        <table>...</table>
    </main>

    <div th:replace="~{fragments/layout :: footer}"></div>
</body>
</html>
```

3. Create a CSS file at `src/main/resources/static/css/style.css`:

```css
body { font-family: Arial, sans-serif; margin: 0; }
nav { background: #333; padding: 1em; }
nav a { color: white; margin-right: 1em; text-decoration: none; }
table { width: 100%; border-collapse: collapse; }
th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }
```

### Extension

Add a sidebar fragment with category links and book count. Make the layout responsive with CSS media queries. Add a dark mode toggle using a fragment parameter.
