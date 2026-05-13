# Kata 2: Race Condition

| Feld | Wert |
|------|------|
| Konzepte | Race Condition, synchronized, Atomaritat |
| Schwierigkeit | 2/5 |
| Dauer | ca. 35 min |

### Aufgabenstellung

Implementiere ein Bankkonto und demonstriere eine Race Condition.

1. Erstelle eine Klasse `BankAccount` mit:
   - Privatem Feld `int balance`
   - Methode `void deposit(int amount)` (erhoht Kontostand)
   - Methode `void withdraw(int amount)` (verringert Kontostand)
   - Methode `int getBalance()`

2. Erstelle eine Klasse `TransactionTask implements Runnable`:
   - Fuhrt 1000 Ein- und Auszahlungen von 10 EUR durch
   - Fuhrt 1000 Ein- und Auszahlungen von 20 EUR durch

3. Starte in main():
   - 10 Threads parallel auf DEM SELBEN Konto
   - Nach allen Threads: Ausgabe des Endkontostands

4. **Beobachtung:** Der Endkontostand sollte 0 sein, ist es aber nicht (Race Condition).

5. **Fix:** Mache `deposit()`, `withdraw()` und `getBalance()` mit `synchronized` thread-safe.

### Beispiel-Output (vor Fix)

```
Starting balance: 0
All transactions completed
Final balance: 580 (sollte 0 sein!)
```

### Beispiel-Output (nach Fix)

```
Starting balance: 0
All transactions completed
Final balance: 0
```

### Erweiterung

Verwende einen `synchronized`-Block statt einer `synchronized`-Methode. Welche Unterschiede gibt es?
