1. Title Page - Patterns Lesson
- Author: Michael Freimüller
- Institution: HTL Spengergasse
2. Lesson Goal Slide
- Increase students awareness for well thought through patterns in software engineering
- Help increase quality of code base even under time pressure
3. Think-Pair-Share Activity
- Brief explanation: Think-Pair-Share is an instructional strategy where students first think individually about a question, then pair up to discuss their ideas with a partner, and finally share with the larger group
4. Introduction - What is Good Code?
- Think-Pair-Share activity prompt: What is good code?
5. Metrics of Good Code - A suggestion
- readable
- maintainable
- extensible
- simple
6. Real-World Considerations
- Deadline
- moving target
- budget pressure considerations
7. SOLID Principles (Brief Overview)
- Single responsibility principle: each class should have one responsibility
    - suppose a class printing reports: reasons to change are:
        1. content of report could change
        2. format of report could change
    - 2 reasons mean two responsibilities -> should split in two classes
- Open-closed principle: classes should be open for extension but closed for modification _briefly expand on this_
    - historically: classes in libraries, when changed, require many programs to change
    - openness to extension prevents this - simply make class parent
- Liskov substitution principle: a subclass may replace a parent without breaking the program _only name this_
- Interface segregation principle: not being forced to depend on methods that aren't used _only name this_
- Dependency inversion principle: depend upon abstractions, not concretes _briefly expand on this_
    - Depending on interfaces (abstractions) not implementations
    - Example: Repositories in our projects
        - Unit testing
        - Mocking
8. Transition to Patterns
- Analogy with essay structure (introduction - main part - conclusion)
- Introduction of concept: Patterns
9. What is a Pattern?
- Definition: "A pattern describes the core of a solution to a problem you encounter over and over again." _place on separate slide_
- Design patterns give programmers a way to talk about problems and solutions without talking about code
10. Problem Categories
- design problems
- architecture problems
- Think-Pair-Share activity prompt: Which patterns have you encountered this year?
11. Pattern Categories Overview
- Creational Patterns: abstract instantiation process, help make system independent of object creation/composition/representation
- Structural Patterns: how classes and objects are composed to form larger structures
- Behavioral Patterns: concerned with algorithms and assignment of responsibility between objects
12. Design Patterns We'll Focus On (Only These 4)
- Builder pattern
- Repository pattern
- Façade pattern
- Strategy pattern
13. Builder Pattern
- Purpose: Creational pattern that abstracts instantiation process
- Short code example:
```
class User {
  constructor() {}
  setName(name) { this.name = name; return this; }
  setEmail(email) { this.email = email; return this; }
  build() { return new User(this); }
}
const user = new User().setName("John").setEmail("john@example.com").build();
```
14. Repository Pattern
- Purpose: Architectural pattern for data access abstraction
- Short code example:
```
interface UserRepository {
  findById(id);
  save(user);
}
class UserService {
  constructor(private repository: UserRepository) {}
  getUser(id) { return this.repository.findById(id); }
}
```
15. Façade Pattern
- Purpose: Provides unified interface to a set of interfaces in a subsystem
- Short code example:
```
class OrderFacade {
  constructor(private orderRepo, private logger, private paymentService) {}
  
  createOrder(orderData) {
    const order = this.orderRepo.create(orderData);
    this.logger.log("Order created");
    return order;
  }
}
```
16. Strategy Pattern
- Purpose: Behavioral pattern for defining interchangeable algorithms
- Short code example:
```
class PaymentStrategy {
  pay(amount) {}
}
class CreditCardPayment extends PaymentStrategy {
  pay(amount) { /* credit card logic */ }
}
class PayPalPayment extends PaymentStrategy {
  pay(amount) { /* paypal logic */ }
}
```
17. Group Task
- Teams of 2-3
- Refactoring of vibe coded project
- Project source: GitHub classroom
18. Team Discussion Questions
- Which issues did you spot?
- Why was X an issue to you?
- How did you solve it?
- Are there any downsides to your solution?
19. Anti-Patterns Overview
- _Show Link:_ https://dev.to/yogini16/anti-patterns-that-every-developer-should-know-4nph 
20. Conclusion - Reflection on Patterns
- Question: What is the benefit of patterns?
- Question: Could there be too much pattern-usage?
21. YAGNI Principle
- You Aren't Gonna Need It principle from Extreme Programming (XP)
- Stating that functionality should only be added when necessary, not when anticipated
    - Prevent over-engineering
    - Reduce code bloat
    - Save development time by focusing strictly on current requirements rather than future, speculative needs
