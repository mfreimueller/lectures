# Speaker Notes — 25: REST mit Servlets — Front Controller

**Woche 28** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- DTOs: Request/Response-Trennung
- Validation: @NotBlank, @MinLength, Validator
- Error Handling: ErrorResponse, Custom Exceptions
- **Frage:** Warum ein Servlet pro Endpoint schlecht skaliert?

## 1. Front Controller Pattern (25 min)

- **Ein Servlet** empfängt ALLE Requests
- **Dispatching** an Command-Objekte
- **Route-Registration:** `Map<String, Command>` mit "METHOD:/path"-Keys
- **Vorteile:**
  - Zentrale Fehlerbehandlung
  - CORS/Encoding Filter an einer Stelle
  - Einheitliches Routing
- **Brücke zu Spring:** DispatcherServlet funktioniert genauso!
- **Live Coding:** FrontControllerServlet + Command-Interface

## 2. Command Pattern (25 min)

- **Command-Interface:** `void execute(HttpServletRequest, HttpServletResponse)`
- **Konkrete Commands:** CreateArticleCommand, GetArticleCommand, etc.
- **Route-Registration:**
  ```java
  routes.put("GET:/api/articles", new GetArticlesCommand());
  routes.put("POST:/api/articles", new CreateArticleCommand());
  routes.put("GET:/api/articles/{id}", new GetArticleCommand());
  ```

## 3. Path Variables & Jackson (20 min)

- **Regex für Path-Matching:** `Pattern.compile("/api/articles/(\\d+)")`
- **Matcher.group(1)** → ID extrahieren
- **Jackson ObjectMapper:**
  - `readValue(request.getInputStream(), CreateArticleRequest.class)`
  - `writeValue(response.getWriter(), articleResponse)`
- **Live Coding:** CRUD-Commands mit Path Variables

## 4. Zentrale Fehlerbehandlung (15 min)

- **try-catch im Front Controller** — alle Commands wrapped
- **ErrorResponse** bei ValidationException → 400
- **ErrorResponse** bei NotFoundException → 404
- **ErrorResponse** bei Exception → 500
- **Live Coding:** Error-Handling-Filter

## 5. Praxis-Übergang (10 min)

- Katas: K1 Front Controller, K2 CRUD Commands, K3 Error Handling

## 6. Wrap-up (10 min)

- Nächste Woche: Layered Architecture
- Hausübung: Front Controller für eigene API

---

## Häufige Fehler

- Front Controller ohne try-catch → 500 für alle Fehler
- Path-Variable-Regex falsch → ID nicht extrahiert
- Command-Interface ohne execute-Methode → kein Dispatching
- Routes case-sensitive → "GET" vs "get" Problem
- ObjectMapper ohne Exception-Handling → 500 bei ungültigem JSON
- CORS-Header vergessen → Browser blockiert Requests
