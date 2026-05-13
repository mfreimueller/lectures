# Kata 4: Advanced flatMap

| Field | Value |
|-------|-------|
| Concepts | flatMap, nested collections, Optional.stream |
| Difficulty | 3/5 |
| Duration | approx. 20 min |

### Task

Given a `School` with nested structure, use flatMap to extract and analyze data.

Define these classes:
- `Teacher` with `String name`, `List<String> skills`, `Optional<String> certification`
- `Department` with `String name`, `List<Teacher> teachers`
- `School` with `List<Department> departments`

Implement methods using flatMap:
1. `List<Teacher> allTeachers()` -- list all teachers across all departments
2. `List<String> allUniqueSkills()` -- collect all unique skills across the school
3. `List<Department> departmentsWithSkill(String skill)` -- find departments with teachers having a specific skill
4. Use `flatMap(Optional::stream)` to collect non-empty certifications

### Extension

Use flatMap with `Optional` to handle nullable nested data. For example, some teachers may have a `mentor` field of type `Optional<Teacher>`.
