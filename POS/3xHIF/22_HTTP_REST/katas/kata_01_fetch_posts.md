# Kata 1: Fetch Posts

| Field | Value |
|-------|-------|
| Concepts | HttpClient, GET request, HttpResponse |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Write a Java program that:
1. Creates an HttpClient instance
2. Sends a GET request to `https://jsonplaceholder.typicode.com/posts`
3. Prints the HTTP status code
4. Prints the response body

### Example Output

```
Status: 200
Body: [
  {
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit..."
  },
  ...
]
```

### Extension

Print only the first 5 posts by limiting the output.
