# K2: InMemoryTaskRepository

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Streams (sorted, groupingBy, partitioningBy), Interfaces | 2/5 | 30 min |

## Task

Define a `TaskRepository` interface and implement `InMemoryTaskRepository` using streams.

Interface methods:
- `List<Task> findAll()`
- `Optional<Task> findById(int id)`
- `List<Task> findByCompleted(boolean completed)`
- `List<Task> findByPriority(Priority priority)`
- `Map<Priority, List<Task>> groupByPriority()`
- `Map<Boolean, List<Task>> partitionByCompleted()`
- `List<Task> findAllSorted(Comparator<Task> comparator)`

Use `ArrayList` as the backing store.

## Example Output

```
All tasks sorted by priority: [Task[title=Buy milk, priority=HIGH], Task[title=Write report, priority=MEDIUM], Task[title=Read book, priority=LOW]]
Grouped by priority: {HIGH=[Buy milk], MEDIUM=[Write report], LOW=[Read book]}
Completed partition: {false=[Buy milk, Write report], true=[Read book]}
```

## Extension

Add a `findByTag(String tag)` method that filters tasks whose tags list contains the given tag.
