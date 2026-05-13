# Kata 2: Logger Singleton

| Feld | Wert |
|------|------|
| Konzepte | Singleton, Logging, Zustandsverwaltung |
| Schwierigkeit | 3/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Baue einen einfachen Logging-Service `Logger` als Singleton mit folgenden Features:

1. Verwalten Sie Log-Level: DEBUG, INFO, WARN, ERROR (als Enum)
2. Methode `void log(Level level, String message)` gibt formatierte Nachrichten aus
3. Hilfsmethoden: `info()`, `debug()`, `warn()`, `error()` delegieren an log()
4. Der Logger soll konfigurierbar sein: `setMinLevel(Level level)` unterdruckt Nachrichten unterhalb des Schwellwerts
5. Alle Log-Nachrichten werden in einer internen `List<String>` gespeichert und sind über `getLogHistory()` abrufbar

### Beispiel-Output

```
Logger logger = Logger.getInstance();
logger.setMinLevel(Level.INFO);

logger.debug("This should not appear");  // unterdruckt
logger.info("Application started");
logger.warn("Low memory");
logger.error("Null pointer detected");

for (String entry : logger.getLogHistory()) {
    System.out.println(entry);
}

// Output:
// [INFO] Application started
// [WARN] Low memory
// [ERROR] Null pointer detected
```

### Erweiterung

Füge einen timestamp zu jedem Log-Eintrag hinzu (Instant.now()) und formatieren Sie die Ausgabe als `[2026-05-13 10:30:00] [INFO] Application started`.
