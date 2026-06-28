# Speaker Notes — 28: Projekt WMC (Kickoff)

**Woche 32** | **Typ: Projekt**

---

## 0. Rückblick (15 min)

- Alles was wir gelernt haben: Java 17+, TDD, SOLID, Streams, Reflection, JDBC, JPA, REST
- **Frage:** Was war das Wichtigste dieses Jahr?

## 1. Projekt-Übersicht (20 min)

- **POS** = Backend (REST API mit Servlets + JPA)
- **WMC** = Frontend (Web-UI)
- **Anforderungen:**
  - 6+ Tabellen mit Beziehungen
  - Vererbung (JPA Inheritance)
  - Authentifizierung
  - Vollständiges CRUD
- **Eigene Domain wählen:** Bibliothek, Fitnessstudio, Restaurant, Hotel, E-Commerce, etc.

## 2. Setup-Phase (30 min)

- Maven-Projekt mit Dependencies:
  - Tomcat, Hibernate, PostgreSQL, Jackson, JUnit, Mockito
- Layered Architecture planen:
  - Controller → Service → Repository → Entity
- ER-Diagramm erstellen
- Domain-Modell brainstormen

## 3. Wochenplanung (15 min)

- **Woche 28:** Setup, Architektur-Planung
- **Woche 29:** Authentication, Registration
- **Woche 30:** Domain Model, JPA Entities
- **Woche 31:** REST API
- **Woche 32:** Testing, Integration
- **Woche 33:** Finalisierung, Präsentation
- **Wöchentliche Check-ins** — Stand-ups, Code Reviews

## 4. Erste Schritte (30 min)

- Repo aufsetzen
- Maven-Dependencies eintragen
- Embedded Tomcat starten
- Erste Entity-Klasse mit @Entity
- PostgreSQL-Connection testen

## 5. Wrap-up (10 min)

- Wöchentliche Deadlines einhalten
- Code Reviews ernst nehmen
- Fragen stellen!

---

## Projekt-Tipps

- Klein anfangen — erst CRUD für eine Entität, dann erweitern
- Tests von Anfang an schreiben
- Git-Commits mit aussagekräftigen Messages
- Dokumentation im README
- Nicht zu lange planen — anfangen!
