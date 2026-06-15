# Exercise: Taschenrechner mit Verzweigung

Schreibe ein Programm, das zwei Zahlen und einen Operator (+, -, *, /) als String speichert und dann die passende Rechnung ausführt.

### Anforderungen

1. Lege zwei Zahlen (int) an.
2. Lege einen Operator als String an (z. B. "+").
3. Verwende eine if-else if-else-Kaskade, um den Operator zu prüfen.
4. Führe die passende Rechnung aus und gib das Ergebnis aus.
5. Achtung bei Division: Wenn der Operator "/" ist, prüfe, ob die zweite Zahl 0 ist. Gib eine Fehlermeldung aus, falls ja.

### Beispiel

```java
public class Taschenrechner {
    public static void main(String[] args) {
        int a = 20;
        int b = 5;
        String operator = "/";

        if (operator.equals("+")) {
            System.out.println(a + " + " + b + " = " + (a + b));
        } else if (operator.equals("-")) {
            System.out.println(a + " - " + b + " = " + (a - b));
        } else if (operator.equals("*")) {
            System.out.println(a + " * " + b + " = " + (a * b));
        } else if (operator.equals("/")) {
            if (b == 0) {
                System.out.println("Fehler: Division durch 0!");
            } else {
                System.out.println(a + " / " + b + " = " + (a / b));
            }
        } else {
            System.out.println("Unbekannter Operator: " + operator);
        }
    }
}
```

### Erweiterung

Erweitere den Taschenrechner um den Modulo-Operator (%) für den Rest einer Division.
