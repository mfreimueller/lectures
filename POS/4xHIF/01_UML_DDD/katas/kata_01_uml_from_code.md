# Kata 1: UML from Code

| Field | Value |
|-------|-------|
| Concepts | association, aggregation, composition, inheritance, class diagram |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Given the following Java classes, draw a UML class diagram showing:

- All classes and interfaces
- All attributes and methods (with types)
- Relationships (association, aggregation, composition, inheritance, realization)
- Multiplicities and navigability

```java
public interface Borrowable {
    boolean isAvailable();
    void borrow(Member member);
    void returnItem();
}

public class Book implements Borrowable {
    private String isbn;
    private String title;
    private Author author;
    private boolean available;
    private List<Loan> loanHistory;
    // ...
}

public class Member {
    private String memberId;
    private String name;
    private List<Loan> activeLoans;
    // ...
}

public class Loan {
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    // ...
}

public class Author {
    private String name;
    private String biography;
    private List<Book> books;
    // ...
}

public class Library {
    private String name;
    private Address address;
    private List<Book> catalog;
    private List<Member> members;
    // ...
}

public class Address {
    private String street;
    private String city;
    private String zipCode;
    // ...
}
```

### Extension

Add a `Magazine` class that also implements `Borrowable` and determine which inheritance strategy to use.
