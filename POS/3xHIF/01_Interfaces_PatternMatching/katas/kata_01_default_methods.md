# Kata 1: Default Methods

| Field | Value |
|-------|-------|
| Concepts | default methods, interfaces, diamond problem |
| Difficulty | 2/5 |
| Duration | approx. 15 min |

### Task

1. Define an interface `Animal` with a method `name()` and a default method `speak()` that returns "..." by default
2. Create records `Dog` and `Cat` that implement `Animal` and override `speak()`
3. Create a `Robot` record that does NOT override speak (uses the default)
4. Print each animal's name and sound

### Example Output

```
Dog Buddy says: Woof
Cat Luna says: Meow
Robot R2D2 says: ...
```

### Extension

Add a second interface `Pet` with a default method `cuddle()` and resolve the diamond problem.
