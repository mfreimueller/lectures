# Kata 3: ScopedValue

| Feld | Wert |
|------|------|
| Konzepte | ScopedValue, where, run, Context-Weitergabe |
| Schwierigkeit | 3/5 |
| Dauer | ca. 45 min |

### Aufgabenstellung

Implementiere eine Middleware-artige Request-Verarbeitung mit `ScopedValue`.

1. Definiere zwei `ScopedValue`-Instanzen:
   - `REQUEST_ID` (String)
   - `CURRENT_USER` (String)

2. Implementiere eine `RequestContext`-Klasse mit:
   - `static void processRequest(String requestId, String user, Runnable handler)`
     - Setzt die ScopedValues und fuhrt den Handler aus
   - Logger-Methoden, die auf die ScopedValues zugreifen

3. Implementiere einen simulierten Request-Handler:
   - Ruft `log()` auf (gibt Request-ID und User aus)
   - Macht eine simulierte async DB-Abfrage (Thread.sleep + Ausgabe)
   - Macht eine simulierte async API- Anfrage (Thread.sleep + Ausgabe)
   - Die Abfragen sollen die ScopedValues ebenfalls verwenden konnen

4. Starte mehrere Requests parallel mit Virtual Threads.

### Beispiel-Output

```
[INFO] Request req-1 | User: alice | Processing started
[INFO] Request req-1 | User: alice | DB query: SELECT * FROM users
[INFO] Request req-2 | User: bob | Processing started
[INFO] Request req-2 | User: bob | DB query: SELECT * FROM users
[INFO] Request req-1 | User: alice | API call: GET /payments
[INFO] Request req-2 | User: bob | API call: GET /payments
[INFO] Request req-1 | User: alice | Processing complete
[INFO] Request req-2 | User: bob | Processing complete
```

### Erweiterung

Zeige, dass ScopedValue im Gegensatz zu ThreadLocal nicht geandert werden kann (final/immutable). Versuche `REQUEST_ID.set("neue-id")` und zeige den Compiler-Fehler (oder die Laufzeitausnahme).
