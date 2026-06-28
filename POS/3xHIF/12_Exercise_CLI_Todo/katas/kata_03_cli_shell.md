# K3: CLI Shell with Switch Expressions

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Switch expressions, Scanner, REPL loop | 3/5 | 30 min |

## Task

Build an interactive CLI shell for the todo application using switch expressions for command parsing.

Commands:
- `add <title> <priority>` — add a new task
- `list [all|completed|pending]` — list tasks
- `done <id>` — mark task as completed
- `remove <id>` — delete a task
- `exit` — quit the application

Use a `Scanner` for input and a `TaskRepository` for data access.

## Example Output

```
Todo App CLI — type help for commands
> add Buy milk HIGH
Added task 1: Buy milk
> add Read book LOW
Added task 2: Read book
> list all
1: Buy milk [HIGH] - not done
2: Read book [LOW] - not done
> done 1
Task 1 marked as done
> list completed
1: Buy milk [HIGH] - done
> exit
Goodbye!
```

## Extension

Add an `edit <id> <title>` command and a `help` command that lists all available commands.
