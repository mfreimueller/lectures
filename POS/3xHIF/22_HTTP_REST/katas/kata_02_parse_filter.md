# Kata 2: Parse and Filter Posts

| Field | Value |
|-------|-------|
| Concepts | JSON parsing, Records, stream filtering |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Write a Java program that:
1. Defines a `Post` record with fields: userId, id, title, body
2. Fetches posts from `https://jsonplaceholder.typicode.com/posts`
3. Parses the JSON array into a list of Post records
4. Filters posts by userId (e.g., userId == 1)
5. Prints the titles of matching posts

### Example Output

```
Posts by user 1:
1 - sunt aut facere repellat provident occaecati excepturi optio reprehenderit
2 - qui est esse
...
```

### Extension

Add a command-line argument to specify the userId filter.
