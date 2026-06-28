# Speaker Notes — 22: HTTP & REST

**Woche 25** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (10 min)

- JPA: Entities, Relationships, Inheritance, Repository
- **Frage:** Wie kommunizieren Anwendungen über das Netzwerk?

## 1. HTTP-Protokoll (25 min)

- **Request:** Methode + URL + Headers + Body
- **Response:** Status-Code + Headers + Body
- **HTTP-Methoden:**
  - GET → Lesen (idempotent, safe)
  - POST → Erstellen
  - PUT → Ersetzen (idempotent)
  - DELETE → Löschen (idempotent)
  - PATCH → Teilweise Aktualisierung
- **Status-Codes:**
  - 200 OK, 201 Created, 204 No Content
  - 400 Bad Request, 404 Not Found, 500 Internal Server Error
- **Live Coding:** HTTP-Request/Response mit curl zeigen

## 2. REST-Prinzipien (20 min)

- **Resource-orientiert** — URIs für Ressourcen, nicht Aktionen
- **Zustandslos** — Jeder Request enthält alle nötigen Infos
- **Einheitliches Interface** — HTTP-Methoden + Status-Codes
- **URI-Design:**
  - `/api/users` → Collection
  - `/api/users/42` → Einzelne Ressource
  - NICHT: `/api/getUsers`, `/api/createUser`
- **Representations** — JSON, XML, etc.

## 3. Java HttpClient (30 min)

- **Java 11+** — built-in, kein externes Library nötig
- **Aufbau:**
  ```java
  HttpClient client = HttpClient.newHttpClient();
  HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("https://api.example.com/users"))
      .GET()
      .build();
  HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
  ```
- **BodyPublishers:** ofString(), ofFile(), fromInputStream()
- **BodyHandlers:** ofString(), ofFile(), ofByteArray()
- **Live Coding:** JSONPlaceholder API aufrufen

## 4. JSON Parsing mit Jackson (15 min)

- **ObjectMapper:** `readValue(json, Class)` → Record/Objekt
- **Records für JSON:** Feldnamen müssen JSON-Keys entsprechen
- **@JsonProperty** für abweichende Namen
- **Live Coding:** JSON → Record → Ausgabe

## 5. Praxis-Übergang (10 min)

- Katas: K1 Fetch Posts, K2 Parse/Filter, K3 REST Client

## 6. Wrap-up (10 min)

- Nächste Woche: Servlets Basics
- Hausübung: REST Client für öffentliche API

---

## Häufige Fehler

- POST vs. PUT verwechselt → POST = erstellen, PUT = ersetzen
- URI mit Verben → REST: Ressourcen, nicht Aktionen
- HttpClient ohne Timeout → hängt ewig
- JSON-Parsing ohne Exception-Handling → fehlerhafte API-Antworten
- Status-Codes ignoriert → immer response.statusCode() prüfen
- BodyHandlers.ofString() für große Responses → Memory-Probleme
