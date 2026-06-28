# K3: HTML Renderer

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Switch expressions, Streams, Collectors | 3/5 | 30 min |

## Task

Build an HTML renderer that walks the AST and produces valid HTML output.

```java
public class HtmlRenderer {
    public String render(List<Block> blocks) { ... }
}
```

Mapping:
- `Heading(level, text)` → `<h{level}>{text}</h{level}>`
- `Paragraph(text)` → `<p>{text}</p>`
- `CodeBlock(code)` → `<pre><code>{code}</code></pre>`

Join blocks with newlines.

## Example Output

```
Input blocks: [Heading[level=1, text=Welcome], Paragraph[text=Hello world]]
Output:
<h1>Welcome</h1>
<p>Hello world</p>
```

## Extension

Add inline rendering: detect `**bold**`, `*italic*`, and `` `code` `` within paragraph text and wrap with `<strong>`, `<em>`, and `<code>` tags respectively.
