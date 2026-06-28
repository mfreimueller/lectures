# Speaker Notes — 31: Projekt WMC REST

**Woche 35** | **Typ: Projekt — Sprint 4**

---

## 0. Check-in (15 min)

- Stand-up: Entities fertig?
- Probleme besprechen
- Nächste Ziele setzen

## 1. Fokus dieser Woche (10 min)

- **REST API Implementierung**
- CRUD-Endpoints für alle Entities
- DTOs für Request/Response
- Validierung und Error Handling

## 2. Technische Guidance (20 min)

- **Architektur:** Controller → Service → Repository
- **Front Controller** mit Command Pattern
- **DTOs:** CreateXxxRequest, XxxResponse
- **Validation:** @NotBlank, @MinLength, custom Annotations
- **Error Handling:** ErrorResponse, Custom Exceptions
- **HTTP-Semantik:** Richtige Methoden, Status-Codes

## 3. Code Review (20 min)

- API-Endpoints reviewen
- REST-Prinzipien prüfen
- DTO-Design besprechen

## 4. Arbeitsphase (2h)

- Schüler arbeiten eigenständig
- Individuelle Beratung bei Bedarf
- Check-in nach 1h: Fortschritt?

## 5. Wrap-up (15 min)

- API-Endpoints fertig?
- Nächste Woche: Testing

---

## Häufige Probleme

- Domain-Objekte direkt als Response → interne Felder exponiert
- Falsche HTTP-Methoden → POST statt PUT, GET statt DELETE
- Status-Codes inkonsistent → 200 statt 201, 500 statt 400
- Validierung fehlt → ungültige Daten in der DB
- Error-Handling nicht zentral → Code-Duplikation
- Pagination fehlt → große Datenmengen brechen API
