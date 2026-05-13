# Kata 2: Isolation Levels

| Feld | Wert |
|------|------|
| Konzepte | Dirty Read, Non-Repeatable Read, Phantom Read, Isolation Levels |
| Schwierigkeit | 4/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Implementiere ein Programm, das die verschiedenen Isolationsanomalien demonstriert. Verwende zwei Threads, die gleichzeitig auf eine gemeinsame Datenstruktur zugreifen.

Simuliere folgende Szenarien:
1. **Dirty Read**: Thread A schreibt, Thread B liest vor Commit/Rollback von A
2. **Non-Repeatable Read**: Thread A liest zweimal, Thread B ändert den Wert dazwischen
3. **Phantom Read**: Thread A führt eine Bereichsabfrage zweimal aus, Thread B fügt einen neuen Datensatz ein

Verwende dazu eine eigene Implementierung von Isolationsmechanismen (Read/Write Locks, Versionierung).

### Beispiel-Output

```
=== Dirty Read Simulation ===
Thread B liest Wert=200 (von nicht-committeter Transaktion)
Thread A führt Rollback durch
Thread B hat ungültigen Dirty Read-Wert gelesen!

=== Non-Repeatable Read Simulation ===
Thread A liest Wert=100
Thread A liest Wert=150 (Non-Repeatable Read! Thread B hat geändert)
```

### Erweiterung

Implementiere eine `Serializable`-Isolation mittels 2PL (Two-Phase Locking), die alle Anomalien verhindert.
