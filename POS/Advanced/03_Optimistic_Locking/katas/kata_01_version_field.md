# Kata 1: Version Field

| Feld | Wert |
|------|------|
| Konzepte | Version Field, Optimistic Locking, Compare-and-Swap, Retry |
| Schwierigkeit | 3/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Implementiere ein optimistisches Locking-System für ein in-memory Inventory-System. Ein `Product`-Objekt hat einen Namen, einen Lagerbestand (stock) und eine Versionsnummer.

Implementiere:
1. Eine `InventoryRepository`-Klasse mit den Methoden `findById` und `update`
2. Die `update`-Methode führt einen Compare-and-Swap durch: Sie aktualisiert nur, wenn die Version noch aktuell ist
3. Eine `OptimisticLockException`-Klasse
4. Eine Retry-Logik für den Fall einer fehlschlagenden Aktualisierung
5. Simuliere zwei gleichzeitige Benutzer, die versuchen, den Lagerbestand zu ändern

### Beispiel-Output

```
Initial: Product{id=1, name='Laptop', stock=10, version=1}
Thread A: stock von 10 auf 8 reduzieren (2 kaufen)
Thread B: stock von 10 auf 5 reduzieren (5 kaufen)
Thread A: Update erfolgreich (Version 1 -> 2)
Thread B: OptimisticLockException (erwartete Version 1, aktuelle Version 2)
Thread B: Retry (1/3) - erneuter Versuch...
Thread B: stock von 8 auf 3 reduzieren (5 kaufen, aktualisierter Stand 8)
Thread B: Update erfolgreich (Version 2 -> 3)
Final: Product{id=1, name='Laptop', stock=3, version=3}
```

### Erweiterung

Implementiere zusätzlich eine optimistische Transaktion über mehrere Produkte hinweg (z.B. Warenkorb mit 2 Produkten).
