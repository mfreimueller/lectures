public class Book {
    private String title;
    private int pages;

    // Default-Konstruktor (wird automatisch erzeugt,
    // wenn kein anderer Konstruktor definiert ist)
    public Book() {
        title = "Unbekannt";
        pages = 0;
    }

    // Parametrisierter Konstruktor
    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    // Überladener Konstruktor (nur title)
    public Book(String title) {
        this.title = title;
        this.pages = 0;
    }

    public void printInfo() {
        System.out.println("Titel: " + title);
        System.out.println("Seiten: " + pages);
    }

    public static void main(String[] args) {
        Book b1 = new Book("Java für Anfänger", 350);
        Book b2 = new Book("Kurzgeschichte");
        Book b3 = new Book();

        b1.printInfo();
        System.out.println();
        b2.printInfo();
        System.out.println();
        b3.printInfo();
    }
}
