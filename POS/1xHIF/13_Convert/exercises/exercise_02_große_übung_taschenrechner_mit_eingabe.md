# Große Übung: Taschenrechner mit Eingabe

**Ziel:** Ein Taschenrechner, der zwei Zahlen und einen Operator als Text einliest und das Ergebnis berechnet.

## Anforderungen

1. Der Benutzer gibt zwei Zahlen und einen Operator (`+`, `-`, `*`, `/`) als Text ein.
2. Wandle die Zahlen mit `Double.parseDouble` um.
3. Führe die Rechnung mit einer `switch-case`- oder `if`-`else`-Kaskade aus.
4. Gib das Ergebnis aus.
5. Wenn die Eingabe ungültig ist (z. B. Buchstaben statt Zahlen), gib eine Fehlermeldung aus.

## Beispielablauf

```
Erste Zahl: 10
Zweite Zahl: 3
Operator (+ - * /): *
Ergebnis: 30.0
```

## Erweiterung

Wiederhole die Eingabe in einer Schleife, bis der Benutzer "ende" eingibt.

```
Erste Zahl: 10
Zweite Zahl: 3
Operator (+ - * /): /
Ergebnis: 3.333...
Erste Zahl: ende
Programm beendet.
```
