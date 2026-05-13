# Kata 2: Structured Concurrency

| Feld | Wert |
|------|------|
| Konzepte | StructuredTaskScope, ShutdownOnFailure, ShutdownOnSuccess |
| Schwierigkeit | 3/5 |
| Dauer | ca. 40 min |

### Aufgabenstellung

Implementiere eine parallele Datenabfrage mit `StructuredTaskScope`.

1. Definiere drei Services (simuliere 500-1500ms Antwortzeit):
   - `UserService.getUser(id)` -> User-Daten
   - `InventoryService.checkStock(productId)` -> "IN_STOCK" / "OUT_OF_STOCK"
   - `ShippingService.getShippingOptions(addressId)` -> Liste von Optionen

2. **Teil 1: ShutdownOnFailure**
   - Rufe parallel getUser, checkStock und getShippingOptions auf
   - Wenn einer fehlschlägt: alle anderen abbrechen
   - Gib das Gesamtergebnis aus

3. **Teil 2: ShutdownOnSuccess**
   - Simuliere drei Replikate eines Dienstes (z.B. drei verschiedene Datenbank-Knoten)
   - Nimm das erste erfolgreiche Ergebnis

### Beispiel-Output

```
=== Teil 1: ShutdownOnFailure ===
User: Alice
Stock: IN_STOCK
Shipping Options: [Standard, Express, Same-Day]
All tasks completed successfully.

=== Teil 2: ShutdownOnSuccess ===
Querying 3 replicas for product price...
First successful result: Price = 29.99 (from Replica 2)
```

### Erweiterung

Simuliere einen Fehler im Stock-Service (wirft Exception). Zeige, dass die anderen Tasks abgebrochen werden und das Gesamtergebnis einen Fehler meldet.
