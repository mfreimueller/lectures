# Patterns

## Lesson Goal

Increase the students awareness for well thought through patterns in software engineering that help them increase the quality of their code base, even in case of time pressure.

## Lesson Structure

1. Introduction: what we are talking about
2. Patterns: what are they, why are they?
3. Think-Pair-Share
4. Group-Task: Strategy pattern
5. Conclusion

### Introduction

Intro-Question: **What is good code?** - Collect ideas.

Suggestions:
- readable
- maintainable
- extensible
- simple

**Is this always achievable in real-world scenarios? And do you think that writing good code is easy?** - Think about deadline, moving target, budget pressure etc.

**If not, how could we mitigate? Could there be something that helps us increase the quality of our codebase?**

Think about writing an essay. Do you always reinvent the wheel, coming up with a new structure? Or do you more or less stick to the structure: introduction - main part - conclusion?

What could be a name for this 'structure'? **Patterns**

### Patterns

Find a working definition for 'pattern':

```
A pattern describes the core of a solution to a problem you encounter over and over again.
```

What are problem categories we encountered this year?

- design problems
- architecture problems

For more, see: https://martinfowler.com/articles/enterprisePatterns.html

### Think-Pair-Share

**Think about patterns you encountered this year.**

Collect the results on the blackboard as a mind-map.

Show and pass around both books.

#### Some ideas...

- Design patterns
    - Factory
    - Builder/SuperBuilder
    - Façade
    - Command

- Architectural patterns
    - Repository
    - Optimistic Locking
    - Data Transfer Object
    - Mapper
    - Service Layer
    - Inheritance Strategies
        - Single
        - Joined
        - Table per Class
    - ValueObject
    - Layer Supertype
        - A superclass in a layer holding methods/fields relevant to all layer classes (think: AbstractEntity)

**Group them by _design patterns_ and _architectural patterns_**.

Is **Layered Architecture** (Domain, Persistance, Service, Presentation) a pattern? ... yes, it is an architectural pattern.

Is **DDD (Domain Driven Design)** a pattern? ... it is a software design methodology or design philosophy. It consists of various patterns (entity, value object etc.)

Could most of our services classes also be considered as following a specific pattern? **Façade**, i.e. a unified interface to a set of interfaces in a subsystem, i.e. one point for our presentation layer to communicate, instead of calling repositories, loggers etc. manually

### Design Patterns

Question: when thinking about writing software, which categories for different patterns could you come up with?

- Creational Patterns
    - abstract the instantiation process
    - help make a system independent of how its objects are created, composed and represented
    - **Builder pattern**
- Structural Patterns
    - how classes and objects are composed to form larger structures
        - structural _class_ patterns: use inheritance to compose interfaces or implementations (**Composite**)
        - structural _object_ patterns: ways to compose objects to realize new functionality (**Flyweight**)
- Behavioral Patterns
    - concerned with algorithms and the assignments of responsibility between objects
    - describe patterns of objects, classes and their communication
        - behavioral _class_ patterns: use inheritance to distribute behavior between classes (**Template Method** or **Interpreter**)
        - behavioral _object_ patterns: use object composition instead of inheritance (**Command**)

### Group Task

https://refactoring.guru/

```
Get together in teams of 2-3 an read up on the strategy pattern.

Think about a problem scenario, where this pattern would come in handy.

Write the pre-pattern code, and then provide a solution that uses the strategy pattern to improve the code quality. NOTE: I want an explanation of why the strategy pattern matches your specific problem - not just AI generated slop.

Maybe: spin that wheel!
```

### Conclusion

Think back to suggested good code principles:
- readable
- maintainable
- extensible
- simple

Which principles do patterns apply to (and why)?

Do you think that you always have to apply certain patterns? (relate Florian story about the colleague that always added way too much patterns, just for the sake of patterns).

Is there a fine line between too much and too little patterns? Where is it? (open question, don't know the answer)
