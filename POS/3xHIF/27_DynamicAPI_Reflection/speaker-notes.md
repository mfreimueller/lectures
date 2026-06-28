# Speaker Notes — 27: Dynamic API mit Reflection

**Woche 31** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- Layered Architecture: Controller → Service → Repository
- Constructor Injection, manuelles Wiring
- **Frage:** Wie registriert Spring Boot Controllers automatisch?

## 1. Annotation-basiertes Routing (25 min)

- **Custom Annotations:**
  - `@Controller(path = "/api/articles")`
  - `@GetMapping(path = "")`
  - `@PostMapping(path = "")`
  - `@PathVariable` — Pfad-Parameter
  - `@Body` — Request-Body
- **Vorteil:** Deklaratives Routing statt manueller Registrierung
- **Live Coding:** Annotations definieren

## 2. Classpath Scanning (25 min)

- **ClassLoader.getResources()** — .class-Dateien finden
- **Rekursives Directory-Scanning** — alle Klassen durchsuchen
- **Class.forName()** — Klasse laden
- **Annotation-Prüfung:** `isAnnotationPresent(Controller.class)`
- **Live Coding:** ClasspathScanner implementieren

## 3. Route Registration (20 min)

- **Controller instanziieren** → `clazz.getDeclaredConstructor().newInstance()`
- **Methoden inspizieren** → `getDeclaredMethods()`
- **Annotationen lesen** → `@GetMapping`, `@PostMapping`
- **Routes registrieren** → Front Controller Map
- **Live Coding:** RouteRegistrar implementieren

## 4. Handler Argument Resolution (15 min)

- **Methoden-Parameter inspizieren** → `getParameterTypes()`
- **@Body** → Request-Body lesen, ObjectMapper.readValue()
- **@PathVariable** → URI extrahieren, Typ konvertieren
- **HttpServletRequest/HttpServletResponse** → direkt durchreichen
- **Live Coding:** Argument Resolver implementieren

## 5. Mini-Framework komplett (10 min)

- **ClasspathScanner** + **RouteRegistrar** + **FrontControllerServlet**
- **Vergleich mit Spring Boot:**
  - @RestController ≈ @Controller
  - @GetMapping ≈ @GetMapping
  - DispatcherServlet ≈ FrontControllerServlet
  - Auto-Configuration ≈ Classpath Scanning

## 6. Praxis-Übergang (10 min)

- Katas: K1 @Endpoint Annotation, K2 Classpath Scanner, K3 Auto-Register Routes
- **Großübung:** REST API from Spec — siehe exercise/README.md

## 7. Wrap-up (10 min)

- Nächste Woche: Projekt WMC beginnt!
- Alles was ihr gelernt habt kommt jetzt zum Einsatz

---

## Häufige Fehler

- Classpath-Scanner findet keine Klassen → Package-Name falsch
- Class.forName() ohne Exception-Handling → ClassNotFoundException
- Controller ohne Default-Konstruktor → InstantiationException
- @PathVariable-Typ-Konvertierung vergessen → String statt Long
- Annotation-Retention nicht auf RUNTIME → nicht lesbar zur Laufzeit
- Route-Registration ohne Thread-Safety → ConcurrentHashMap verwenden
