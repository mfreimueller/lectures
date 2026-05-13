# Kata 2: Pattern Comparison

| Feld | Wert |
|------|------|
| Konzepte | Singleton, Factory Method, Creational Patterns |
| Schwierigkeit | 3/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Vergleiche die beiden Creational Patterns **Singleton** und **Factory Method**. Implementiere ein Mini-Beispiel, das beide Patterns kombiniert: Eine LoggerFactory, die als Singleton implementiert ist und verschiedene Logger-Typen (FileLogger, ConsoleLogger) per Factory Method erzeugt.

Anforderungen:
1. Logger-Interface mit Methode `void log(String message)`
2. Zwei konkrete Implementierungen: `FileLogger` und `ConsoleLogger`
3. Eine `LoggerFactory` als Singleton, die Logger-Instanzen erzeugt
4. Ein Hauptprogramm zur Demonstration

### Beispiel-Output

```
[Console] Pattern Comparison gestartet
[File] 2024-01-01: App started
[Console] Singleton LoggerFactory verwendet
```

### Erweiterung

Füge einen dritten Logger-Typ (z.B. `DatabaseLogger`) hinzu, ohne die Factory-Klasse zu ändern (Open/Closed Principle).
