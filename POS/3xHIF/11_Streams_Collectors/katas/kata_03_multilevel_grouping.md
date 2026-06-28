# Kata 5: Multi-level Grouping

| Field | Value |
|-------|-------|
| Concepts | groupingBy, downstream collectors, mapping, filtering, teeing |
| Difficulty | 4/5 |
| Duration | approx. 25 min |

### Task

Given a list of `Employee` records, use multi-level grouping with downstream collectors.

Define `Employee` record with `String name`, `String department`, `String city`, `double salary`, `boolean isManager`.

Tasks:
1. Group employees by department, then by city (Map<String, Map<String, List<Employee>>>)
2. Compute average salary per department
3. Count employees per city
4. Partition managers vs non-managers per department
5. Use `Collectors.teeing` for parallel aggregation (compute both count and average in one pass per department)

### Extension

Format the output as a readable text-block report showing all groupings and aggregations.
