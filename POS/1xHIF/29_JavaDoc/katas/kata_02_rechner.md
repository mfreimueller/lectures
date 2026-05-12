# Kata 02: Code-Review - Rechner dokumentieren

Der folgende Code muss mit JavaDoc versehen werden.

## Aufgaben
1. Ergaenze JavaDoc fuer die Klasse Rechner
2. Ergaenze JavaDoc fuer jede Methode
3. Lass einen Partner deine Dokumentation ueberpruefen

## Code
```java
class Rechner {
    public int addieren(int a, int b) {
        return a + b;
    }

    public int subtrahieren(int a, int b) {
        return a - b;
    }

    public int multiplizieren(int a, int b) {
        return a * b;
    }

    public int dividieren(int a, int b) {
        return a / b;
    }
}
```

## Review-Checkliste
- [ ] Ist die Klasse dokumentiert?
- [ ] Haben alle Methoden @param und @return?
- [ ] Ist der Text verstaendlich?
- [ ] Werden Sonderfaelle (z.B. Division durch 0) erwahnt?
