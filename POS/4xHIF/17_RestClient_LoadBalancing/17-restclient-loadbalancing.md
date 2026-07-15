---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 17 - Rest Client & Load Balancing
## POS - 4xHIF

---

## Warum externe APIs?

- Keine App ist eine Insel — Integration von Drittanbietern
- Beispiele: Zahlungsdienstleister, Wetterdaten, Karten, Auth-Anbieter
- Microservices kommunizieren untereinander über HTTP
- Spring bietet: `RestClient`, `WebClient`, `RestTemplate` (deprecated)

---

## RestTemplate vs RestClient

| RestTemplate (alt) | RestClient (neu) |
| --- | --- |
| Seit Spring 3 (2009) | Seit Spring 6 / Boot 3 (2022) |
| Synchron, blockierend | Synchron, aber modernere API |
| Schwer testbar (viele Overloads) | Builder-Pattern, einfach testbar |
| Fehlerbehandlung umständlich | `onStatus()` — fließend |
| Wird in Zukunft entfernt | Ersatz für RestTemplate |

---

## RestClient Setup

```java
@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder
            .baseUrl("https://jsonplaceholder.typicode.com")
            .defaultHeader(HttpHeaders.CONTENT_TYPE,
                MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader("X-API-Key", "${api.key}")
            .requestInterceptor((request, body, execution) -> {
                log.info("Request: {} {}", request.getMethod(),
                    request.getURI());
                return execution.execute(request, body);
            })
            .build();
    }
}
```

---

## GET mit RestClient

```java
// Einfaches Objekt
Todo todo = restClient.get()
    .uri("/todos/{id}", 1L)
    .retrieve()
    .body(Todo.class);

// Liste (mit TypeReference)
List<Todo> todos = restClient.get()
    .uri("/todos")
    .retrieve()
    .body(new ParameterizedTypeReference<>() {});

// Query-Parameter
List<Todo> filtered = restClient.get()
    .uri("/todos?userId={userId}", 1)
    .retrieve()
    .body(new ParameterizedTypeReference<>() {});
```

---

## POST / PUT / DELETE

```java
// POST — neuen Todo erstellen
Todo created = restClient.post()
    .uri("/todos")
    .body(new Todo(null, 1L, "New task", false))
    .retrieve()
    .body(Todo.class);

// PUT — komplett ersetzen
restClient.put()
    .uri("/todos/{id}", 1L)
    .body(updatedTodo)
    .retrieve()
    .toBodilessEntity();

// DELETE — löschen
restClient.delete()
    .uri("/todos/{id}", 1L)
    .retrieve()
    .toBodilessEntity();
```

---

## Fehlerbehandlung mit onStatus

```java
Todo result = restClient.get()
    .uri("/todos/{id}", id)
    .retrieve()
    .onStatus(HttpStatusCode::is4xxClientError,
        (request, response) -> {
            if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Todo " + id + " nicht gefunden");
            }
            throw new ExternalServiceException(
                "Fehler: " + response.getStatusCode());
        })
    .onStatus(HttpStatusCode::is5xxServerError,
        (request, response) -> {
            throw new ExternalServiceException(
                "Serverfehler: " + response.getStatusCode());
        })
    .body(Todo.class);
```

---

## Retry mit Spring Retry

```java
@Service
public class ResilientTodoService {

    private final RestClient restClient;

    @Retryable(
        retryFor = ExternalServiceException.class,
        maxAttempts = 3,
        backoff = @Backoff(delay = 1000, multiplier = 2))
    public Todo findById(Long id) {
        return restClient.get()
            .uri("/todos/{id}", id)
            .retrieve()
            .onStatus(HttpStatusCode::is5xxServerError,
                (req, res) -> {
                    throw new ExternalServiceException("API error");
                })
            .body(Todo.class);
    }

    @Recover
    public Todo fallback(Long id, ExternalServiceException e) {
        log.warn("Fallback für Todo {} nach Fehler", id);
        return new Todo(null, null, "Fallback-Todo", false);
    }
}
```

---

## Timeouts konfigurieren

```java
@Bean
public RestClient restClient() {
    return RestClient.builder()
        .requestFactory(new JdkClientHttpRequestFactory(
            HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build()))
        .build();
}

// Alternativ mit Apache HTTP Client:
// @Bean
// public RestClient restClient() {
//     return RestClient.builder()
//         .requestFactory(new HttpComponentsClientHttpRequestFactory(
//             HttpClientBuilder.create()
//                 .setConnectionTimeToLive(5, TimeUnit.SECONDS)
//                 .build()))
//         .build();
// }
```

---

## Load Balancing — Konzepte

- **Client-Side LB:** Der Client wählt die Zielinstanz aus
- **Server-Side LB:** Ein Load Balancer (z.B. Nginx) verteilt Anfragen
- **Round-Robin:** Anfragen werden der Reihe nach verteilt
- **Weighted:** Instanzen mit mehr Kapazität bekommen mehr Traffic
- **Health Check:** Ausfallende Instanzen werden aus dem Pool entfernt

---

## Client-Side Load Balancing

```java
@Service
public class LoadBalancingClient {

    private final List<String> instances = List.of(
        "http://localhost:8081",
        "http://localhost:8082"
    );
    private final AtomicInteger counter = new AtomicInteger(0);

    public Map<String, Object> fetchFromInstance() {
        int index = Math.abs(
            counter.getAndIncrement() % instances.size());
        String url = instances.get(index) + "/api/instance";

        return restClient.get()
            .uri(url)
            .retrieve()
            .body(new ParameterizedTypeReference<>() {});
    }
}
```

---

## Projekt: Externe API integrieren

<div class="highlight-box">
<ol>
<li>Wähle eine öffentliche API (z.B. OpenWeather, GitHub, JSONPlaceholder)</li>
<li>Integriere sie mit RestClient in dein Projekt</li>
<li>Füge Fehlerbehandlung mit onStatus + Retry hinzu</li>
<li>Mappe die externen DTOs auf deine eigenen Records</li>
<li>Optional: Caching für die externe API (nächste Wochen)</li>
</ol>
</div>

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>RestClient als moderne Alternative zu RestTemplate</li>
<li>GET, POST, PUT, DELETE mit RestClient</li>
<li>Fehlerbehandlung mit onStatus</li>
<li>Retry-Logik mit Spring Retry</li>
<li>Timeouts und Connection-Pool-Konfiguration</li>
</ul>
</div>
