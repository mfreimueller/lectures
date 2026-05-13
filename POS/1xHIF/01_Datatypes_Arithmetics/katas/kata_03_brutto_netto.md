# Kata 3: Brutto-Netto-Rechner

## Ziel

Lerne den Umgang mit double-Variablen, Division und formatierter Ausgabe.

## Aufgabenstellung

Schreibe ein Programm `BruttoNetto.java`, das aus einem Bruttobetrag
den Nettobetrag und die enthaltene MWST berechnet (20% MWST).

1. Deklariere `brutto` als double (z.B. 120.0)
2. Deklariere `mwst` als 0.2 (entspricht 20%)
3. Berechne `netto = brutto / (1 + mwst)`
4. Berechne `steuer = brutto - netto`
5. Gib alle Werte formatiert mit zwei Nachkommastellen aus

## Beispiel-Output

```
Brutto:   120,00
Netto:    100,00
MWST:      20,00
```

## Hinweise

- Verwende `printf` mit `%.2f` für zwei Nachkommastellen
- Denke an den Unterschied zwischen int und double bei der Division

## Erweiterung (optional)

Berechne auch mit einem anderen Steuersatz, z.B. 10% (mwst = 0.1).
