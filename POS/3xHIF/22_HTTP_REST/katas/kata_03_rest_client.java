import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest.BodyPublishers;

class HttpException extends RuntimeException {
    private final int statusCode;
    public HttpException(int statusCode, String body) {
        super("HTTP " + statusCode + ": " + body);
        this.statusCode = statusCode;
    }
    public int getStatusCode() { return statusCode; }
}

class RestClient {
    private final HttpClient client = HttpClient.newHttpClient();
    private final String baseUrl;

    public RestClient(String baseUrl) {
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
    }

    public String get(String path) {
        var request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + path))
            .GET()
            .build();
        return send(request);
    }

    public String post(String path, String json) {
        var request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + path))
            .header("Content-Type", "application/json")
            .POST(BodyPublishers.ofString(json))
            .build();
        return send(request);
    }

    public String put(String path, String json) {
        var request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + path))
            .header("Content-Type", "application/json")
            .PUT(BodyPublishers.ofString(json))
            .build();
        return send(request);
    }

    public String delete(String path) {
        var request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + path))
            .DELETE()
            .build();
        return send(request);
    }

    private String send(HttpRequest request) {
        try {
            var response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() >= 400) {
                throw new HttpException(response.statusCode(), response.body());
            }
            return response.body();
        } catch (HttpException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Request failed", e);
        }
    }
}

public class RestClientApp {
    public static void main(String[] args) {
        var api = new RestClient("https://jsonplaceholder.typicode.com");

        try {
            var response = api.get("/posts/1");
            System.out.println("GET /posts/1 -> " + response);
        } catch (HttpException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
