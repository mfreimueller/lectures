# K1: Markdown Tokenizer

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Records, Sealed classes, Pattern matching | 1/5 | 20 min |

## Task

Create a tokenizer that reads Markdown text and produces a list of tokens. Use a sealed interface for the token types.

- Lines starting with `#` → `HeadingToken(level, content)`
- Lines starting with `##` → level 2, etc.
- Lines starting with `` ``` `` → `CodeToken(content)`
- All other lines → `ParagraphToken(content)`

```java
sealed interface Token permits HeadingToken, ParagraphToken, CodeToken {}
record HeadingToken(int level, String content) implements Token {}
record ParagraphToken(String content) implements Token {}
record CodeToken(String content) implements Token {}
```

## Example Output

```
Input:
# Welcome
This is a paragraph.
## Subsection
Another paragraph.

Output:
[HeadingToken[level=1, content=Welcome],
 ParagraphToken[content=This is a paragraph.],
 HeadingToken[level=2, content=Subsection],
 ParagraphToken[content=Another paragraph.]]
```

## Extension

Add support for `- ` list items as a `ListItemToken`.
