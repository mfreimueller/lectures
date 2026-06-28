# Speaker Notes — 24: DTOs & Validation

**Woche 28** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- Servlets: HttpServlet, embedded Tomcat, Request/Response
- JSON mit ObjectMapper
- **Frage:** Warum nicht Domain-Objekte direkt als API-Response verwenden?

## 1. DTO-Pattern (25 min)

- **DTO** = Data Transfer Object — separates Modell für API
- **Request-DTO** — was der Client sendet
- **Response-DTO** — was der Server zurückgibt
- **Warum?**
  - Domain-Modell von API trennen
  - Interne Felder nicht exponieren (Passwort, interne IDs)
  - API-Versionierung ermöglichen
  - Validierung am Eingang
- **Live Coding:** CreateArticleRequest + ArticleResponse DTOs

## 2. Manuelle Validierung (20 min)

- if/else-Checks für jedes Feld
- Fehler sammeln in Liste
- Structured Error Response:
  ```json
  {
    "status": 400,
    "message": "Validation failed",
    "details": ["Field 'name' must not be blank"]
  }
  ```
- **Live Coding:** Manuelles Validieren im Servlet

## 3. Annotation-basierte Validierung (25 min)

- **Custom Annotations:** @NotBlank, @MinLength
- **@Retention(RUNTIME)** + **@Target(FIELD)**
- **Validator.validate()** — Reflection-basiert
- Felder durchlaufen, Annotationen prüfen, Werte lesen
- **Live Coding:** Validator mit @NotBlank und @MinLength

## 4. Error Handling (15 min)

- **Custom Exceptions:** ValidationException, NotFoundException
- **Front Controller:** Exceptions zentral fangen
- **ErrorResponse-Record** für konsistente Fehlerantworten
- **Live Coding:** Exception-Handling im Servlet

## 5. Praxis-Übergang (10 min)

- Katas: K1 DTO Mapping, K2 Custom Validation, K3 Error Handling

## 6. Wrap-up (10 min)

- Nächste Woche: Front Controller & Command Pattern
- Hausübung: DTOs + Validation für eigene API

---

## Häufige Fehler

- Domain-Objekt direkt als Response → interne Felder exponiert
- Validierung nur im Client → Server muss IMMER validieren
- @Retention(SOURCE) statt RUNTIME → Validator findet Annotation nicht
- ErrorResponse ohne Status-Code → Client weiß nicht, was schiefging
- Exceptions nicht gefangen → 500 statt 400/404
- DTO-Mapper vergessen → manuelle Mapping-Fehler
