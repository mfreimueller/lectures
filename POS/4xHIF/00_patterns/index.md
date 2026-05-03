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

Intro-Question: **What is good code?**
_Collect ideas._

Suggestions:
- readable
- maintainable
- extensible
- simple

**Is this always achievable in real-world scenarios? And do you think that writing good code is easy?**
_Think about deadline, moving target, budget pressure etc._

In OO world: **SOLID** principles (if lesson is 50 minutes: briefly touch, otherwise dive into it slightly deeper):
- **Single responsibility principle**: each class should have one responsibility (responsibility = reason to change)
    - suppose a class printing reports: reasons to change are:
        1. content of report could change
        2. format of report could change
    - 2 reasons mean two responsibilities -> should split in two classes
- **Open-closed principle**: classes should be open for extension but closed for modification
    - historically: classes in libraries, when changed, require many programs to change
    - openness to extension prevents this - simply make class parent
- _Liskov substitution principle_: (a subclass may replace a class without breaking the program)
    - basic idea of polymorphism: the parent class 'Content' should be replacable with 'VideoContent' without breaking the program
- _Interface segregation principle_: (not being forced to depend on methods that aren't used)
    - split interfaces into small units to only depend on what you need
- **Dependency inversion principle**: thou should depend upon abstractions, not concretes
    - repositories in our projects (we depend on the interfaces - abstractions - not the implementations)
    - wofür noch? unit testing und mocking!

**If not, how could we mitigate? Could there be something that helps us increase the quality of our codebase?**

Think about writing an essay. Do you always reinvent the wheel, coming up with a new structure? Or do you more or less stick to the structure: introduction - main part - conclusion?

What could be a name for this 'structure'? **Patterns**

### Patterns

Find a working definition for 'pattern':

```
A pattern describes the core of a solution to a problem you encounter over and over again.
```

> Design patterns give programmers a way to talk about problems and solutions without talking about code.

What are problem categories we encountered this year?

- design problems
- architecture problems

For more, see: https://martinfowler.com/articles/enterprisePatterns.html

**Think about patterns you encountered this year via Think-Pair-Share.**

_Collect the results on the blackboard as a mind-map._

_Show and pass around both books._

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

**Group them by design patterns and architectural patterns**.

Is **Layered Architecture** (Domain, Persistance, Service, Presentation) a pattern? ... yes, it is an architectural pattern.

Is **DDD (Domain Driven Design)** a pattern? ... it is a software design methodology or design philosophy. It consists of various patterns (entity, value object etc.)

**Discuss in more detail**:
- Builder pattern (ask why it makes sense, especially for domain classes)
- Repository pattern (ask what the alternative is - show and discuss the sample project)
- Façade:
    - Could most of our services classes also be considered as following a specific pattern? **Façade**, i.e. a unified interface to a set of interfaces in a subsystem, i.e. one point for our presentation layer to communicate, instead of calling repositories, loggers etc. manually
    - **Showcase and discuss the façade pattern in the project** - for services, ask: what are the alternatives (multiple dependencies in controller?)

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

_Showcase the dummy project for the strategy pattern. Ask them for their gut feeling about issues with this solution. Then ask them to read up on the strategy pattern._

```
Get together in teams of 2-3 and fork the project on GitHub classrooms.

Look over the code and try to refactor it, by applying the principles and patterns we discussed today.

Do 5 minute blocks of driver and reviewer.

At the end I pick 1-3 teams via wheel-spinning and let them show their solutions via MS Teams on the beamer.
```

_Teams should be able to answer:_
- which issues did you spot?
- why was X an issue to you?
- how did you solve it?
- are there any downsides to your solution?

### Anti-Patterns

If there are software patterns, are there also anti-patterns?

https://dev.to/yogini16/anti-patterns-that-every-developer-should-know-4nph

- God classes
- Spaghetti code
- Magic numbers and strings
    - i.e. undocumented values (move to constants instead) (why, for example, is it x > 5???)
- Excessive use of Singletons
- Excessive interface complexity
    - one interface doing too much
- Yoda conditions
    - if (100 == your_number) ...
    - vs. if (your_number == 100) ...
- Duplication in programming

### Conclusion

Think back to suggested good code principles:
- readable
- maintainable
- extensible
- simple

... and SOLID.

Which principles do patterns apply to (and why)?

Do you think that you always have to apply certain patterns? (relate Florian story about the colleague that always added way too much patterns, just for the sake of patterns).

Is there a fine line between too much and too little patterns? Where is it?

**YAGNI (You Aren't Gonna Need It)** principle: principle from Extreme Programming (XP) _stating that functionality should only be added when necessary, not when anticipated_
- prevent over-engineering
- reduce code bloat
- save development time by focusing strictly on current requirements rather than future, speculative needs
