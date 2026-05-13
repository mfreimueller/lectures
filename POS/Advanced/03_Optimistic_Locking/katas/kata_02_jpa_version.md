# Kata 2: JPA @Version

| Feld | Wert |
|------|------|
| Konzepte | JPA, @Version, Optimistic Locking, Spring Boot |
| Schwierigkeit | 4/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Implementieren Sie ein vollstandiges Spring Boot Beispiel, das JPA @Version fur optimistisches Locking verwendet. Da keine laufende Datenbank zur Verfugung steht, implementieren Sie eine In-Memory-Version, die demonstriert, wie @Version in JPA funktioniert.

Erstellen Sie:
1. Eine `Account`-Entity mit einem `@Version`-Feld
2. Ein `AccountRepository` (extends JpaRepository)
3. Eine `TransferService`, die zwei Konten aktualisiert (Gutschrift/Lastschrift)
4. Eine Hauptklasse, die gleichzeitige Transfers simuliert und OptimisticLockException behandelt

Hinweis: Da keine echte JPA-Umgebung im Test verfugbar ist, simulieren Sie das Verhalten mit einer eigenen Annotation und Proxy-basierter Versionierung.

### Beispiel-Output

```
Initial: Account(id=1, owner='Alice', balance=1000.0, version=1)
         Account(id=2, owner='Bob', balance=500.0, version=1)
Gleichzeitige Transfers gestartet...
Transfer 1: Alice -> Bob 200.0 (erfolgreich)
Transfer 2: Alice -> Bob 900.0 (OptimisticLockException -> Retry)
Transfer 2 nach Retry: erfolgreich mit aktualisiertem Stand
Final: Account(id=1, owner='Alice', balance=0.0, version=3)
       Account(id=2, owner='Bob', balance=1500.0, version=3)
```

### Erweiterung

Fugen Sie eine Verteilte-Sperren-Komponente (z.B. Redis basiert) hinzu, die zusatzlich pessimistisches Locking auf Account-Ebene ermoglicht.
