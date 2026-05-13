public class Records {
    public static void main(String[] args) {
        var book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        var book2 = new Book("Dune", "Frank Herbert", 1965);

        System.out.println(book1);
        System.out.println(book2);

        System.out.println(book1.title() + " is " + book1.age() + " years old");
        System.out.println(book2.title() + " is " + book2.age() + " years old");
    }
}
