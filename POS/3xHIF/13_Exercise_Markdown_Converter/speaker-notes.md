# Speaker Notes — 13: Exercise Markdown Converter

**Woche 16** | **Theorie 2h | Praxis 3h** | **Typ: Übung**

---

## 0. Wiederholung (10 min)

- CLI Todo App: Task-Record, Repository-Interface, CLI-Shell
- Streams für Queries, switch-Expression für Commands
- **Frage:** Wer hat die Todo App fertig? Welche Probleme?

## 1. Übungseinleitung (20 min)

- Ziel: Markdown → HTML Converter
- **Pipeline:** Tokenizer → Parser → Renderer
- **Domain:** Sealed Token-Hierarchie, Records für AST
- **Unterstützt:** `# Heading`, `**bold**`, `*italic*`, `` `code` ``, `- list`
- TDD für jede Stufe!

## 2. Kata 1: Tokenizer (30 min)

- Eingabe: Markdown-Text (String)
- Ausgabe: List<Token>
- Sealed Interface Token: HeadingToken, ParagraphToken, CodeToken, BoldToken, ItalicToken, ListToken
- Zeilenweise Verarbeitung mit Streams
- TDD: Jede Token-Art einzeln testen

## 3. Kata 2: Parser/AST (30 min)

- Eingabe: List<Token>
- Ausgabe: List<Block> (AST)
- Records für AST: Heading, Paragraph, CodeBlock, Bold, Italic, ListItem
- Pattern Matching switch für Token→Block-Konvertierung
- TDD: Parser für jede Block-Art testen

## 4. Kata 3: HTML Renderer (30 min)

- Eingabe: List<Block> (AST)
- Ausgabe: HTML-String
- switch-Expression für Block→HTML
- `Collectors.joining()` für HTML-Zusammenbau
- TDD: Renderer für jede Block-Art testen

## 5. Besprechung (20 min)

- Musterlösungen zeigen
- Pipeline-Architektur diskutieren
- Code Review am Ende — Partner tauschen Code aus

## 6. Wrap-up (10 min)

- Nächste Woche: Reflection I
- Weihnachtspause vorbei — weiter mit Meta-Programmierung

---

## Häufige Fehler

- Tokenizer zu komplex → erst einfache Fälle, dann verschachtelte
- Parser: Token-Reihenfolge nicht beachtet → falsche Block-Zuordnung
- Renderer: HTML nicht escaped → XSS-Lücke (für Übung OK, aber erwähnen)
- TDD vergessen → erst Code, dann Tests → kein TDD
- Pipeline nicht trennbar → Tokenizer, Parser, Renderer müssen unabhängig testbar sein
