# Speaker Notes — 29: Projekt WMC Setup

**Woche 33** | **Typ: Projekt — Sprint 2**

---

## 0. Check-in (15 min)

- Stand-up: Was ist seit letzter Woche passiert?
- Probleme besprechen
- Nächste Ziele setzen

## 1. Fokus dieser Woche (10 min)

- **Authentication & Registration**
- User-Entity mit Passwort-Hashing (BCrypt)
- Login-Endpoint
- Session/Token-Handling

## 2. Technische Guidance (20 min)

- **BCrypt für Passwort-Hashing** — niemals Plain-Text-Passwörter!
- **User-Entity:** id, username, passwordHash, email, role
- **Auth-Service:** register(), login(), validateToken()
- **REST-Endpoints:**
  - POST /api/auth/register
  - POST /api/auth/login
  - GET /api/auth/me (geschützt)

## 3. Code Review (20 min)

- Pull Requests der Schüler reviewen
- Feedback geben: SOLID, Testing, Architektur
- Häufige Probleme besprechen

## 4. Arbeitsphase (2h)

- Schüler arbeiten eigenständig
- Individuelle Beratung bei Bedarf
- Check-in nach 1h: Fortschritt?

## 5. Wrap-up (15 min)

- Was ist fertig?
- Was blockiert?
- Nächste Woche: Domain Model

---

## Häufige Probleme

- Passwörter nicht gehasht → Sicherheitslücke
- Keine Validierung bei Registration → ungültige User
- Auth-Logik im Controller → gehört in Service
- Keine Tests für Auth-Service → schwer zu debuggen
- Token-Handling fehlt → keine geschützten Endpoints
