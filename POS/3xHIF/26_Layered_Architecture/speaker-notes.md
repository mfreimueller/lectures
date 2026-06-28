# Speaker Notes — 26: Layered Architecture

**Woche 29** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- Front Controller: Ein Servlet, Command Pattern, Routing
- Path Variables, Jackson, Error Handling
- **Frage:** Was passiert, wenn Business-Logik im Command steckt?

## 1. Drei-Schichten-Architektur (30 min)

- **Controller** (HTTP) → Empfangt Requests, delegiert an Service
- **Service** (Business Logic) → Validierung, Berechnungen, Orchestrierung
- **Repository** (Data Access) → CRUD-Operationen, Datenbankzugriff
- **Dependency Flow:** Controller → Service → Repository
- **Constructor Injection** — Abhängigkeiten im Konstruktor übergeben
- **Vorteile:**
  - Testbarkeit (Service ohne HTTP testbar)
  - Austauschbarkeit (Repository-Implementierung tauschbar)
  - Wiederverwendbarkeit (Service von mehreren Controllern nutzbar)
- **Live Coding:** Todo-App in 3 Schichten aufteilen

## 2. Service Layer (25 min)

- **Service-Interface** mit Business-Methoden
- **Validierung** im Service, nicht im Controller
- **Business Rules** hier implementieren
- **Beispiel:**
  ```java
  public class ArticleService {
      private final ArticleRepository repository;
      public ArticleService(ArticleRepository repository) {
          this.repository = repository;
      }
      public Article create(CreateArticleRequest request) {
          // Validierung, Business Rules, Repository-Aufruf
      }
  }
  ```

## 3. Constructor Injection & Wiring (15 min)

- **Manuelles Wiring** in der App-Klasse:
  ```java
  var repository = new InMemoryArticleRepository();
  var service = new ArticleService(repository);
  var controller = new ArticleController(service);
  ```
- **Kein Framework** — alles von Hand
- **Thread-Safety:** Lokale Variablen in Servlets, keine Instanzvariablen!

## 4. Praxis-Übergang (10 min)

- Katas: K1 Service Layer, K2 Split Command, K3 Test Service
- **Großübung:** Monolith → Layered Refactoring — siehe exercise/README.md

## 5. Wrap-up (10 min)

- Nächste Woche: Dynamic API mit Reflection
- Hausübung: Service Layer für eigene API bauen

---

## Häufige Fehler

- Business-Logik im Controller → schwer testbar
- Service ohne Interface → nicht mockbar
- Repository direkt im Controller → Schichten vermischt
- Instanzvariablen im Servlet → Thread-Safety-Problem
- Constructor Injection vergessen → `new` im Code versteckt
- Service-Validierung fehlt → ungültige Daten im Repository
