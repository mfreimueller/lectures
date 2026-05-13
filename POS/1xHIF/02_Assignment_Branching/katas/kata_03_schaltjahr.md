# Kata 3: Schaltjahr-Prüfung

## Ziel

Lerne komplexe Bedingungen mit logischen Operatoren (&&, ||) zu formulieren.

## Aufgabenstellung

Schreibe ein Programm `Schaltjahr.java`, das prüft, ob ein gegebenes Jahr ein Schaltjahr ist.

Schaltjahr-Regel:
Ein Jahr ist ein Schaltjahr, wenn
- es durch 400 teilbar ist, ODER
- es durch 4 teilbar ist, ABER NICHT durch 100

1. Deklariere `jahr` als int (z.B. 2024)
2. Formuliere die Bedingung als boolean-Ausdruck
3. Gib das Ergebnis aus

## Beispiel-Output

Bei `jahr = 2024`:
```
2024 ist ein Schaltjahr.
```

Bei `jahr = 1900`:
```
1900 ist kein Schaltjahr.
```

## Hinweise

- Teilerkennung mit Modulo: `jahr % 400 == 0`
- Die vollständige Bedingung: `(jahr % 400 == 0) || (jahr % 4 == 0 && jahr % 100 != 0)`

## Erweiterung (optional)

Teste mehrere Jahre (2024, 1900, 2000, 2025) in einem Programm.
Erstelle eine Tabelle als Output.
