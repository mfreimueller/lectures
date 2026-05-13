# Kata 3: Post API with Search

| Field | Value |
|-------|-------|
| Concepts | Path params, query params, filtering, error handling |
| Difficulty | 3/5 |
| Duration | approx. 30 min |

### Task

Write a Java program that builds a Post API with:
1. POST /api/posts - create a post (userId, title, body)
2. GET /api/posts - list all posts, with optional filtering:
   - `?userId=1` - filter by userId
   - `?search=keyword` - search in title and body
3. GET /api/posts/{id} - get a single post
4. DELETE /api/posts/{id} - delete a post
5. Return proper error responses as JSON: `{"error": "message", "status": 404}`

### Example Output

```
$ curl -X POST -H "Content-Type: application/json" \
  -d '{"userId":1,"title":"Hello","body":"World"}' \
  http://localhost:7070/api/posts
{"id":1,"userId":1,"title":"Hello","body":"World"}

$ curl "http://localhost:7070/api/posts?search=Hello"
[{"id":1,"userId":1,"title":"Hello","body":"World"}]

$ curl http://localhost:7070/api/posts/999
{"error":"Post not found","status":404}
```

### Extension

Add PATCH /api/posts/{id} for partial updates and include a createdAt timestamp.
