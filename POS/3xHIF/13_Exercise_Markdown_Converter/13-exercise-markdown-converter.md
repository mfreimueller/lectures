---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 13 - Exercise, Markdown, Converter
## POS - 3xHIF

---

## Agenda

1. Exercise Overview
2. Tokenizer
3. Parser and AST
4. HTML Renderer

---

## Learning Objectives

- I can build a tokenizer that classifies Markdown text using sealed interfaces
- I can parse tokens into an AST using records and sealed classes
- I can render an AST to HTML using switch expressions and streams
- I can apply TDD to each stage of a multi-stage text processing pipeline
- I can explain why separating Tokenizer, Parser, and Renderer is good design

---

## Exercise Overview

Build a Markdown to HTML converter in three stages:

1. **Tokenizer** — split input into lines, classify each line
2. **Parser** — build an AST from tokens using records
3. **Renderer** — walk the AST and emit HTML

<div class="highlight-box"><p>Use TDD for every stage — write the test first!</p></div>

---

## Tokenizer

```java
sealed interface Token permits HeadingToken, ParagraphToken, CodeToken {}
record HeadingToken(int level, String content) implements Token {}
record ParagraphToken(String content) implements Token {}
record CodeToken(String content) implements Token {}
```

- Read input line by line
- Classify lines starting with # as headings
- Classify lines starting with ``` as code blocks
- Everything else is a paragraph

---

## Parser and AST

```java
sealed interface Block permits Heading, Paragraph, CodeBlock {}
record Heading(int level, String text) implements Block {}
record Paragraph(String text) implements Block {}
record CodeBlock(String code) implements Block {}
```

The parser converts a list of tokens into a list of block-level AST nodes.

---

## Reflection: Why Three Stages?

<div class="highlight-box">
<p>Why is separating Tokenizer, Parser, and Renderer into distinct stages good design? What would break if they were combined into one monolithic class? Think about testability, reusability, and adding new output formats.</p>
</div>

---

## HTML Renderer

```java
public String render(List<Block> blocks) {
    return blocks.stream()
        .map(this::renderBlock)
        .collect(Collectors.joining("\n"));
}

private String renderBlock(Block block) {
    return switch (block) {
        case Heading h  -> "<h" + h.level() + ">" + h.text() + "</h" + h.level() + ">";
        case Paragraph p -> "<p>" + p.text() + "</p>";
        case CodeBlock c -> "<pre><code>" + c.code() + "</code></pre>";
    };
}
```

---

## Summary and Goals

- Practice records, sealed classes, and switch expressions
- Apply TDD throughout the development
- Process text line-by-line using streams
- Support headings, paragraphs, bold, italic, and code blocks
