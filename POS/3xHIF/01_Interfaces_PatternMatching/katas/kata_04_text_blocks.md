# Kata 3: Text Blocks

| Field | Value |
|-------|-------|
| Concepts | text blocks, string formatting, JSON generation |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Create a record `Person(String name, int age, String email)`
2. Write a method that generates an HTML profile card using a Text Block
3. Write a method that generates a JSON representation using a Text Block
4. Use `String.formatted()` or `String.replace()` to insert dynamic values

### Example Output

```html
<div class="card">
  <h2>Alice</h2>
  <p>Age: 30</p>
  <p>Email: alice@example.com</p>
</div>
```

```json
{
  "name": "Bob",
  "age": 25,
  "email": "bob@example.com"
}
```

### Extension

Generate a full HTML page with multiple persons displayed as a table using text blocks and a stream.
