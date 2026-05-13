# K2: Markdown Parser with AST

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Records, Switch expressions, Recursive data structures | 2/5 | 30 min |

## Task

Build a parser that converts tokens into an AST of `Block` records.

```java
sealed interface Block permits Heading, Paragraph, CodeBlock {}
record Heading(int level, String text) implements Block {}
record Paragraph(String text) implements Block {}
record CodeBlock(String code) implements Block {}
```

Implement a `Parser` class with a method `List<Block> parse(List<Token> tokens)`.

## Example Output

```
Tokens: [HeadingToken[level=1, content=Welcome], ParagraphToken[content=Hello world]]
Blocks: [Heading[level=1, text=Welcome], Paragraph[text=Hello world]]
```

## Extension

Add support for inline elements: `BoldText`, `ItalicText`, and `InlineCode` records within paragraph text. Parse `**bold**`, `*italic*`, and `` `code` `` within paragraphs.
