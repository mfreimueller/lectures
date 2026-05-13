# Kata 3: CompletableFuture

| Feld | Wert |
|------|------|
| Konzepte | CompletableFuture, thenApply, thenCompose, thenCombine, exceptionally |
| Schwierigkeit | 3/5 |
| Dauer | ca. 50 min |

### Aufgabenstellung

Simuliere einen asynchronen Bestellungsablauf mit `CompletableFuture`.

1. Erstelle drei Dienste, die asynchrone Aufrufe simulieren (jeweils 500-1500ms Verzogerung):
   - `UserService.getUser(int userId)` -> gibt User-Objekt mit id, name, email zuruck
   - `OrderService.getOrders(int userId)` -> gibt Liste von Order-Objekten zuruck
   - `PaymentService.getPaymentStatus(int orderId)` -> gibt "PAID" oder "PENDING" zuruck

2. Implementiere folgende Ablaufe mit CompletableFuture:
   - **Abfrage 1:** Hole User-Daten, dann dessen Bestellungen (thenCompose)
   - **Abfrage 2:** Hole User-Daten und parallel dazu dessen Bestellungen (thenCombine)
   - **Abfrage 3:** Hole fur jede Bestellung den Zahlungsstatus (mehrere parallele Futures)

3. Gib die Ergebnisse strukturiert aus.

### Beispiel-Output

```
=== Abfrage 1: User mit Bestellungen (sequenziell) ===
User: Alice (alice@example.com)
Orders:
  Order 101: Laptop - 1299.99
  Order 102: Mouse - 29.99
Time: 2120 ms

=== Abfrage 2: User und Bestellungen (parallel) ===
User: Alice
Orders: 2
Time: 1120 ms

=== Abfrage 3: Zahlungsstatus (parallel) ===
Order 101: PAID
Order 102: PENDING
Time: 1540 ms
```

### Erweiterung

Fuge Fehlerbehandlung mit `exceptionally()` hinzu. Simuliere einen Fehler im PaymentService (z.B. bei Order 999: Exception werfen) und fange diesen ab.
