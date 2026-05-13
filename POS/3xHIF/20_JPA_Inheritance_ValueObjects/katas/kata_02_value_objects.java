import jakarta.persistence.*;
import java.math.BigDecimal;

@Embeddable
class Address {
    private String street;
    private String city;
    private String zipCode;
    private String country;

    public Address() {}
    public Address(String street, String city, String zipCode, String country) {
        this.street = street; this.city = city; this.zipCode = zipCode; this.country = country;
    }

    @Override public String toString() {
        return street + ", " + city + ", " + zipCode + ", " + country;
    }
}

@Embeddable
class Email {
    @Column(name = "email_address")
    private String value;

    public Email() {}
    public Email(String value) {
        if (value == null || !value.contains("@"))
            throw new IllegalArgumentException("Invalid email: " + value);
        this.value = value;
    }

    public String getValue() { return value; }
    @Override public String toString() { return value; }
}

@Embeddable
class Money {
    private BigDecimal amount;
    private String currency;

    public Money() {}
    public Money(BigDecimal amount, String currency) {
        this.amount = amount; this.currency = currency;
    }

    @Override public String toString() {
        return currency + " " + amount;
    }
}

@Entity
class Student {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @Embedded
    private Address address;

    @Embedded
    private Email email;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "street", column = @Column(name = "parent_street")),
        @AttributeOverride(name = "city", column = @Column(name = "parent_city")),
        @AttributeOverride(name = "zipCode", column = @Column(name = "parent_zip")),
        @AttributeOverride(name = "country", column = @Column(name = "parent_country"))
    })
    private Address parentAddress;

    public Student() {}
    public Student(String name, Address address, Email email) {
        this.name = name; this.address = address; this.email = email;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Address getAddress() { return address; }
    public Address getParentAddress() { return parentAddress; }
    public void setParentAddress(Address a) { this.parentAddress = a; }
}

@Entity
class Teacher {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @Embedded
    private Address address;

    @Embedded
    private Email email;

    @Embedded
    private Money salary;

    public Teacher() {}
    public Teacher(String name, Address address, Email email, Money salary) {
        this.name = name; this.address = address; this.email = email; this.salary = salary;
    }

    public String getName() { return name; }
    public Money getSalary() { return salary; }
}

public class ValueObjectsDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        var addr1 = new Address("123 Main St", "Vienna", "1010", "AT");
        var addr2 = new Address("456 Parent Rd", "Vienna", "1020", "AT");
        var email = new Email("alice@school.com");

        var alice = new Student("Alice", addr1, email);
        alice.setParentAddress(addr2);
        em.persist(alice);

        var teacherAddr = new Address("789 Oak Ave", "Vienna", "1030", "AT");
        var teacherEmail = new Email("smith@school.com");
        var salary = new Money(new BigDecimal("45000.00"), "EUR");
        em.persist(new Teacher("Mr. Smith", teacherAddr, teacherEmail, salary));

        em.getTransaction().commit();

        System.out.println("--- Value Objects ---");

        Student s = em.find(Student.class, alice.getId());
        System.out.println("Student: " + s.getName() + ", lives at " + s.getAddress());
        System.out.println("Student (parent): " + s.getParentAddress());

        Teacher t = em.createQuery("SELECT t FROM Teacher t WHERE t.name = :name", Teacher.class)
            .setParameter("name", "Mr. Smith")
            .getSingleResult();
        System.out.println("Teacher: " + t.getName() + ", salary: " + t.getSalary());

        em.close();
        emf.close();
    }
}
