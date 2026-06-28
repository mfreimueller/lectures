# Speaker Notes — 09: SOLID II (LSP, ISP, DIP)

**Woche 11** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- SRP: Eine Klasse, ein Grund zu ändern
- OCP: Offen für Erweiterung, geschlossen für Modifikation
- Strategy Pattern als OCP-Implementierung
- **Frage:** SRP-Beispiel aus dem Alltag?

## 1. LSP — Liskov Substitution (25 min)

- "Subtypen müssen den Basistyp ersetzen können, ohne das Programm zu brechen"
- **Klassisches Beispiel:** Square extends Rectangle → verletzt LSP
  - Rectangle: setWidth und setHeight unabhängig
  - Square: setWidth ändert auch Height → unerwartetes Verhalten
- **Lösung:** Composition over Inheritance
- **Regeln:**
  - Vorbedingungen dürfen nicht verstärkt werden
  - Nachbedingungen dürfen nicht abgeschwächt werden
  - Invarianten müssen erhalten bleiben
- **Live Coding:** Rectangle/Square-Verletzung finden und fixen

## 2. ISP — Interface Segregation (25 min)

- "Kein Client darf Methoden implementieren müssen, die er nicht benutzt"
- **Problem:** Fat Interface `Worker` mit work(), eat(), sleep()
  - Robot muss eat() implementieren → UnsupportedOperationException
- **Lösung:** Kleine, fokussierte Interfaces
  - `Workable` → work()
  - `Eatable` → eat()
  - `Sleepable` → sleep()
- **Live Coding:** Fat Interface aufsplitten

## 3. DIP — Dependency Inversion (25 min)

- "Abhängigkeiten zu Abstraktionen, nicht zu Konkretionen"
- **Problem:** `new EmailSender()` direkt in der Klasse
- **Lösung:** Constructor Injection mit Interface
  ```java
  public class NotificationService {
      private final MessageSender sender;
      public NotificationService(MessageSender sender) {
          this.sender = sender;
      }
  }
  ```
- **Vorteile:** Testbarkeit (Mock), Austauschbarkeit, lose Kopplung
- **Live Coding:** `new` durch Constructor Injection ersetzen

## 4. SOLID-Gesamtübung (20 min)

- Alle 5 Prinzipien in einer Übung kombinieren
- **Kata 5:** Full SOLID Refactoring — gegebener Code hat alle 5 Verletzungen

## 5. Praxis-Übergang (10 min)

- Katas: K1 LSP Rectangle/Square, K2 ISP Printer, K3 DIP Notification, K4 DIP Factory, K5 Full SOLID Refactoring
- **Großübung:** SOLID Refactoring (Invoice System) — siehe exercise/README.md, bis PLÜ 2 abgeben

## 6. Wrap-up (10 min)

- Nächste Woche: Streams I
- PLÜ 2 in Woche 14 — Stoff: Testing, TDD, SOLID, Streams

---

## Häufige Fehler

- LSP: "Es kompiliert" ≠ LSP-konform → Verhalten muss gleich sein
- ISP: Zu viele Interfaces → Overhead, Balance finden
- DIP: Interface für alles → YAGNI, nur wo es Sinn macht
- Constructor Injection vergessen → `new` im Code versteckt
- Vererbung wo Composition besser wäre → "is-a" vs. "has-a" prüfen
