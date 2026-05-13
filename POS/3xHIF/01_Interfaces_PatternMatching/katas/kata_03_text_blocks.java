public class TextBlocks {
    public static void main(String[] args) {
        var p = new PersonTB("Alice", 30, "alice@example.com");
        System.out.println(toHtml(p));
        System.out.println();
        System.out.println(toJson(p));
    }

    static String toHtml(PersonTB p) {
        return """
            <div class="card">
              <h2>%s</h2>
              <p>Age: %d</p>
              <p>Email: %s</p>
            </div>
            """.formatted(p.name(), p.age(), p.email());
    }

    static String toJson(PersonTB p) {
        return """
            {
              "name": "%s",
              "age": %d,
              "email": "%s"
            }
            """.formatted(p.name(), p.age(), p.email());
    }
}
