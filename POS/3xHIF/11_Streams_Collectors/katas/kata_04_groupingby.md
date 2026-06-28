# Kata 2: GroupingBy for Data Classification

| Field | Value |
|-------|-------|
| Concepts | groupingBy, downstream collectors, counting |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Given a `Person` record with `name`, `city`, and `age`, write methods that:

1. `Map<String, List<Person>> groupByCity(List<Person> people)` -- group people by city
2. `Map<String, Long> countByCity(List<Person> people)` -- count people per city
3. `Map<String, List<String>> namesByCity(List<Person> people)` -- group names (not Person objects) by city

```java
record Person(String name, String city, int age) {}
```

### Example Output

```java
groupByCity: {
  "Vienna"=[Person("Alice","Vienna",25), Person("Bob","Vienna",30)],
  "Graz"=[Person("Charlie","Graz",22)]
}
countByCity: {"Vienna"=2, "Graz"=1}
namesByCity: {"Vienna"=["Alice", "Bob"], "Graz"=["Charlie"]}
```

### Extension

Compute the average age per city using `Collectors.averagingInt()`.
