import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public record Post(int userId, int id, String title, String body) {}

public class ParseFilterPosts {
    public static void main(String[] args) throws Exception {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
            .GET()
            .build();

        var response = client.send(request, BodyHandlers.ofString());
        var json = response.body();

        // Simple manual parsing (without Jackson)
        var entries = json.split("\\},\\{");
        System.out.println("Posts by user 1:");
        for (var entry : entries) {
            if (entry.contains("\"userId\":1")) {
                var id = entry.replaceAll(".*\"id\":(\\d+).*", "$1");
                var title = entry.replaceAll(".*\"title\":\"([^\"]+)\".*", "$1");
                System.out.println(id + " - " + title);
            }
        }
    }
}
