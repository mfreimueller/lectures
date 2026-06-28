# Speaker Notes — 23: Servlets Basics

**Woche 26** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- HTTP: Methoden, Status-Codes, REST-Prinzipien
- Java HttpClient: REST-Client bauen
- **Frage:** Wie baut man einen HTTP-Server in Java?

## 1. Servlet-Konzept (20 min)

- **Jakarta Servlet API** — Standard für Web-Komponenten (nicht javax.servlet!)
- **Servlet Container** = Tomcat — verwaltet Servlet-Lifecycle
- **Embedded Tomcat** — Tomcat programmatisch starten, kein XML
- **Setup:**
  ```java
  Tomcat tomcat = new Tomcat();
  tomcat.setPort(8080);
  Context ctx = tomcat.addContext("", System.getProperty("java.io.tmpdir"));
  Tomcat.addServlet(ctx, "hello", new HelloServlet());
  ctx.addServletMappingDecoded("/hello", "hello");
  tomcat.start();
  tomcat.getServer().await();
  ```

## 2. HttpServlet Lifecycle (25 min)

- **init()** — einmalig beim Start
- **service()** → ruft doGet/doPost/doPut/doDelete auf
- **doGet(), doPost(), doPut(), doDelete()** — pro Request
- **destroy()** — einmalig beim Shutdown
- **Thread-Safety:** Instanzvariablen sind shared! → Nur lokale Variablen
- **Live Coding:** Erster HttpServlet mit doGet

## 3. Request/Response Handling (25 min)

- **HttpServletRequest:**
  - getMethod(), getRequestURI(), getPathInfo()
  - getParameter() — Query-Parameter
  - getHeader() — HTTP-Header
  - getReader() — Request-Body
- **HttpServletResponse:**
  - setStatus(), setContentType(), getWriter()
  - setHeader(), sendError()
- **Live Coding:** EchoServlet mit Query-Parametern und POST-Body

## 4. JSON Responses (15 min)

- **ObjectMapper** für JSON-Serialisierung
- Content-Type: application/json
- **Live Coding:** JSON-Todo-API mit Servlets

## 5. Praxis-Übergang (10 min)

- Katas: K1 Hello Servlet, K2 Params/POST, K3 JSON Todo API
- Embedded Tomcat einrichten

## 6. Wrap-up (10 min)

- Nächste Woche: PLÜ 3
- Hausübung: Servlet mit JSON-Response

---

## Häufige Fehler

- javax.servlet statt jakarta.servlet → Tomcat 10+ braucht Jakarta!
- Instanzvariablen im Servlet → Thread-Safety-Problem
- Content-Type nicht gesetzt → Browser zeigt JSON als Text
- getReader() nur einmal aufrufbar → Stream ist verbraucht
- Tomcat-Port bereits belegt → Address already in use
- Embedded Tomcat ohne await() → Server startet und stoppt sofort
