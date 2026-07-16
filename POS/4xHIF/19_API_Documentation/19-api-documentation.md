---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 19 - API Documentation
## POS - 4xHIF

---

## Warum API-Dokumentation?

- Entwickler müssen deine API verstehen und nutzen können
- Reduziert Support-Fragen ("Welchen Endpoint muss ich aufrufen?")
- Ermöglicht automatisierte Client-Generierung
- Wichtig für APIs, die von externen Teams genutzt werden

---

## OpenAPI / Swagger

- **OpenAPI** = Spezifikation (Standard)
- **Swagger** = Tooling (UI, Editor, Codegen)
- **springdoc-openapi** = Spring Boot Integration
- Auto-generiert aus Annotationen (`@RestController`, `@GetMapping`, etc.)
- Interaktive UI zum Testen der Endpoints

---

## springdoc-openapi — Zero-Config

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>3.0.3</version>
</dependency>
```

Nach dem Hinzufügen: Swagger UI unter `/swagger-ui.html` und OpenAPI JSON unter `/v3/api-docs` verfügbar.

---

## OpenAPI Customization

```java
@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Library Management API",
        version = "1.0.0",
        description = "REST API for our library project",
        contact = @Contact(name = "4xHIF", email = "team@spengergasse.at")
    )
)
public class OpenApiConfig {}

@RestController
@Tag(name = "Books", description = "CRUD for books")
public class BookController {

    @GetMapping("/{id}")
    @Operation(summary = "Find book by ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Not found")
    public BookDTO getById(@PathVariable Long id) { ... }
}
```

---

## Spring REST Docs

- Test-getriebene Dokumentation
- Erzeugt Snippets aus **passierten** Tests (nie veraltet!)
- Snippets werden in AsciiDoc-Dokumente eingebunden
- Vorteil: Dokumentation ist immer korrekt (sonst fliegt der Test)
- Nachteil: Aufwändiger, kein interaktives UI

---

## REST Docs vs OpenAPI

| Kriterium | Spring REST Docs | OpenAPI (springdoc) |
| --- | --- | --- |
| Setup | Aufwändig | Minimal (1 Dependency) |
| Korrektheit | 100% (test-basiert) | 90% (annotation-basiert) |
| Interaktivität | Keine | Swagger UI |
| Client-Generierung | Nicht direkt | OpenAPI Generator |
| Wartungsaufwand | Höher | Geringer |

---

## Projekt: API-Dokumentation

<div class="highlight-box">
<ol>
<li>Füge springdoc-openapi zu deinem Projekt hinzu</li>
<li>Konfiguriere Titel, Version, und Beschreibung</li>
<li>Dekoriere Endpoints mit @Operation und @ApiResponse</li>
<li>Gruppiere Endpoints mit @Tag</li>
<li>Teste die interaktive Swagger UI</li>
</ol>
</div>

---

## What We Learned Today

- OpenAPI/Swagger als API-Dokumentationsstandard
- springdoc-openapi Integration
- Swagger UI Customization
- Spring REST Docs (Test-getrieben)
- REST Docs vs OpenAPI — Vergleich
