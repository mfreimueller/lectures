import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Media {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private int year;

    public Media() {}
    public Media(String title, int year) { this.title = title; this.year = year; }
}

@Entity
class Book extends Media {
    private String author;
    private String isbn;

    public Book() {}
    public Book(String title, int year, String author, String isbn) {
        super(title, year);
        this.author = author;
        this.isbn = isbn;
    }
}

@Entity
class DVD extends Media {
    private String director;
    private int duration;

    public DVD() {}
    public DVD(String title, int year, String director, int duration) {
        super(title, year);
        this.director = director;
        this.duration = duration;
    }
}

public class InheritanceMapping {
    public static void main(String[] args) {
        System.out.println("Inheritance: Media -> Book, DVD (JOINED strategy)");
    }
}
