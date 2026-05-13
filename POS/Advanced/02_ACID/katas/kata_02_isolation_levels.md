# Kata 2: Isolation Levels

| Feld | Wert |
|------|------|
| Konzepte | Dirty Read, Non-Repeatable Read, Phantom Read, Isolation Levels |
| Schwierigkeit | 4/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Implementieren Sie ein Programm, das die verschiedenen Isolationsanomalien demonstriert. Verwenden Sie zwei Threads, die gleichzeitig auf eine gemeinsame Datenstruktur zugreifen.

Simulieren Sie folgende Szenarien:
1. **Dirty Read**: Thread A schreibt, Thread B liest vor Commit/Rollback von A
2. **Non-Repeatable Read**: Thread A liest zweimal, Thread B andert den Wert dazwischen
3. **Phantom Read**: Thread A fuhrt eine Bereichsabfrage zweimal aus, Thread B fugt einen neuen Datensatz ein

Verwenden Sie dazu eine eigene Implementierung von Isolationsmechanismen (Read/Write Locks, Versionierung).

### Beispiel-Output

```
=== Dirty Read Simulation ===
Thread B liest Wert=200 (von nicht-committeter Transaktion)
Thread A fuhrt Rollback durch
Thread B hat ungultigen Dirty Read-Wert gelesen!

=== Non-Repeatable Read Simulation ===
Thread A liest Wert=100
Thread A liest Wert=150 (Non-Repeatable Read! Thread B hat geandert)
```

### Erweiterung

Implementieren Sie eine `Serializable`-Isolation mittels 2PL (Two-Phase Locking), die alle Anomalien verhindert.
