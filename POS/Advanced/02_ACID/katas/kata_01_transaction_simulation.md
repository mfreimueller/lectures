# Kata 1: Transaction Simulation

| Feld | Wert |
|------|------|
| Konzepte | Atomicity, Commit, Rollback, Transaktionslog |
| Schwierigkeit | 3/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Implementiere eine einfache Transaktionssimulation in Java, die Atomicity demonstriert. Gegeben ist ein in-memory Konto-System mit `Konto`-Objekten, die einen Kontostand haben.

Implementiere:
1. Eine `TransactionManager`-Klasse, die Transaktionen mit Begin, Commit und Rollback unterstutzt
2. Einen `TransactionLog`, der alle Änderungen aufzeichnet
3. Bei einem Rollback werden die ursprunglichen Werte wiederhergestellt
4. Ein Hauptprogramm, das eine Überweisung von Konto A nach Konto B durchführt und sowohl erfolgreiche als auch fehlschlagende Transaktionen demonstriert

### Beispiel-Output

```
Vor Transaktion: Konto A=1000, Konto B=500
Transaktion gestartet: Überweisung 200 von A nach B
Konto A=800, B=700
Commit erfolgreich
Nach Commit: Konto A=800, Konto B=700

Vor Transaktion: Konto A=800, Konto B=700
Transaktion gestartet: Überweisung 1000 von A nach B
Fehler: Nicht gedeckt
Rollback ausgeführt
Nach Rollback: Konto A=800, Konto B=700
```

### Erweiterung

Implementiere Savepoints innerhalb einer Transaktion.
