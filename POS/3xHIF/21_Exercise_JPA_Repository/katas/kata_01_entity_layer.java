import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.*;

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
    private String value;
    public Email() {}
    public Email(String value) {
        if (value == null || !value.contains("@"))
            throw new IllegalArgumentException("Invalid email");
        this.value = value;
    }
    public String getValue() { return value; }
}

@Embeddable
class Money {
    private BigDecimal amount;
    private String currency;
    public Money() {}
    public Money(BigDecimal amount, String currency) {
        this.amount = amount; this.currency = currency;
    }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    @Override public String toString() { return currency + " " + amount; }
}

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "person_type")
abstract class Person {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Embedded private Email email;
    @Embedded private Address address;

    public Person() {}
    public Person(String name, Email email, Address address) {
        this.name = name; this.email = email; this.address = address;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public Email getEmail() { return email; }
    public Address getAddress() { return address; }
}

@Entity
@DiscriminatorValue("STU")
class Student extends Person {
    private String studentId;
    private int grade;

    @ManyToMany
    @JoinTable(name = "student_elective",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "elective_id"))
    private List<Elective> electives = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments = new ArrayList<>();

    public Student() {}
    public Student(String name, Email email, Address address, String studentId, int grade) {
        super(name, email, address); this.studentId = studentId; this.grade = grade;
    }
    public String getStudentId() { return studentId; }
    public int getGrade() { return grade; }
    public List<Elective> getElectives() { return electives; }
    public List<Enrollment> getEnrollments() { return enrollments; }
}

@Entity
@DiscriminatorValue("TCH")
class Teacher extends Person {
    private String employeeId;
    private String subject;
    @Embedded private Money salary;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses = new ArrayList<>();

    public Teacher() {}
    public Teacher(String name, Email email, Address address, String employeeId, String subject, Money salary) {
        super(name, email, address); this.employeeId = employeeId; this.subject = subject; this.salary = salary;
    }
    public String getEmployeeId() { return employeeId; }
    public String getSubject() { return subject; }
    public Money getSalary() { return salary; }
}

@Entity
class Course {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course() {}
    public Course(String title, Teacher teacher) {
        this.title = title; this.teacher = teacher;
    }
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public Teacher getTeacher() { return teacher; }
    public List<Enrollment> getEnrollments() { return enrollments; }
}

@Entity
@Table(name = "enrollment")
class Enrollment {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne @JoinColumn(name = "course_id")
    private Course course;

    private int grade;
    private String semester;

    public Enrollment() {}
    public Enrollment(Student student, Course course, int grade, String semester) {
        this.student = student; this.course = course; this.grade = grade; this.semester = semester;
    }
    public Long getId() { return id; }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public int getGrade() { return grade; }
    public String getSemester() { return semester; }
}

@Entity
class Elective {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int maxStudents;

    @ManyToMany(mappedBy = "electives")
    private List<Student> students = new ArrayList<>();

    public Elective() {}
    public Elective(String name, int maxStudents) {
        this.name = name; this.maxStudents = maxStudents;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getMaxStudents() { return maxStudents; }
    public List<Student> getStudents() { return students; }
}
