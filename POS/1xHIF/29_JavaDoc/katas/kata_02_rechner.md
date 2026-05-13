# Kata 02: Code-Review - Rechner dokumentieren

Der folgende Code muss mit JavaDoc versehen werden.

## Aufgaben
1. Ergänze JavaDoc für die Klasse Rechner
2. Ergänze JavaDoc für jede Methode
3. Lass einen Partner deine Dokumentation überprüfen

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
- [ ] Ist der Text verständlich?
- [ ] Werden Sonderfälle (z.B. Division durch 0) erwahnt?
