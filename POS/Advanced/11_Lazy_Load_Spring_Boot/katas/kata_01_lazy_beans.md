# Kata 1: @Lazy Beans

| Feld | Wert |
|------|------|
| Konzepte | @Lazy, ApplicationContext, Bean-Initialisierung |
| Schwierigkeit | 2/5 |
| Dauer | ca. 30 min |

### Aufgabenstellung

Erstelle eine Spring Boot Anwendung, die das Verhalten von Eager vs. Lazy Bean-Initialisierung demonstriert.

1. Erstelle drei Komponenten mit Konstruktor-Ausgaben:
   - `DatabaseService` (eager — Standard)
   - `ReportService` (@Lazy)
   - `CacheService` (@Lazy)

2. Erstelle einen `StartupListener`, der nach dem Start eine Ubersicht uber initialisierte Beans ausgibt.

3. Greife in einer `CommandLineRunner`-Implementierung auf `ReportService` zu und beobachte die Initialisierung.

4. Aktiviere globale Lazy-Initialisierung und beobachte, wie sich das Verhalten andert.

### Beispiel-Output (Eager)

```
Starting application...
DatabaseService: initialized!
Startup complete.

[Accessing ReportService for the first time]
ReportService: initialized!
```

### Beispiel-Output (Global Lazy)

```
Starting application...
Startup complete.

[Accessing DatabaseService for the first time]
DatabaseService: initialized!

[Accessing ReportService for the first time]
ReportService: initialized!
```

### Erweiterung

Fuge eine `@Configuration`-Klasse mit `@Lazy` hinzu und uberschreibe einzelne Beans mit `@Lazy(false)`.
