# Kata 1: Front Controller Setup

| Field | Value |
|-------|-------|
| Concepts | Front Controller pattern, Command interface, routing |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Build a Front Controller servlet mapped at `/api/*` that:
1. Defines a `Command` interface with an `execute(req, resp)` method
2. Stores routes in a `Map<String, Command>` keyed by `method:path`
3. Dispatches to the matching command in `service()`
4. Returns 404 for unknown routes

Register two commands: `GET:/api/hello` (returns "Hello!") and `GET:/api/time` (returns current time as JSON).

### Extension

Add a `POST:/api/echo` command that reads the request body and writes it back as the response.