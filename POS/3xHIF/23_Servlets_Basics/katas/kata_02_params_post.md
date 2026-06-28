# Kata 2: Query Params and POST Body

| Field | Value |
|-------|-------|
| Concepts | getParameter, getReader, doPost, content types |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Write a servlet mapped at `/echo` that:
1. On GET: reads the `text` query parameter and echoes it back as plain text
2. On POST: reads the raw request body and echoes it back as plain text
3. Returns 405 for methods other than GET and POST

### Example Output

```
$ curl "http://localhost:8080/echo?text=hello"
hello

$ curl -X POST -d 'world' http://localhost:8080/echo
world

$ curl -X DELETE http://localhost:8080/echo
405 Method Not Allowed (implicit)
```

### Extension

Return JSON `{"echoed":"..."}` instead of plain text. Set the Content-Type header accordingly.