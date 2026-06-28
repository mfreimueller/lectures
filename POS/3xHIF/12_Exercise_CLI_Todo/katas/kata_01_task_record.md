# K1: Task Record with Stream Filtering

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Records, Streams (filter, map) | 1/5 | 20 min |

## Task

Create a `Task` record and a `TaskFilter` class that filters a list of tasks using streams.

```java
public record Task(int id, String title, boolean completed, Priority priority) {}
```

Implement these methods in `TaskFilter`:
- `List<Task> filterCompleted(List<Task> tasks)`
- `List<Task> filterByPriority(List<Task> tasks, Priority priority)`
- `List<String> getTitles(List<Task> tasks)`

## Example Output

```
Tasks: [Task[id=1, title=Buy milk, completed=false, priority=HIGH], Task[id=2, title=Read book, completed=true, priority=LOW]]
Completed: [Task[id=2, title=Read book, completed=true, priority=LOW]]
High priority: [Task[id=1, title=Buy milk, completed=false, priority=HIGH]]
Titles: [Buy milk, Read book]
```

## Extension

Add a `dueDate` field of type `Optional<LocalDate>` and filter tasks that are overdue.
