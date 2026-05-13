# Kata 5: Document Generator with Text Blocks

| Field | Value |
|-------|-------|
| Concepts | text blocks, interfaces, Records, string formatting |
| Difficulty | 3/5 |
| Duration | approx. 20 min |

### Task

1. Define a `Document` interface with a `String render()` method
2. Implement `HtmlDocument` record (wrapping `String title, String body`) that renders HTML using text blocks
3. Implement `MarkdownDocument` record (wrapping `String title, String body`) that renders Markdown using text blocks
4. Write a `Main` class that creates both document types and prints them

### Example Output

```
=== HTML ===
<!DOCTYPE html>
<html>
<head><title>Hello</title></head>
<body><p>World</p></body>
</html>

=== Markdown ===
# Hello

World
```

### Extension

Add a `renderToFile(String path)` default method to the Document interface.
