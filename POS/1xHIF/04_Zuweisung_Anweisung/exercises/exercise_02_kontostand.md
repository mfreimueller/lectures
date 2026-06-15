# Große Übung: Kontostand-Simulation

Simuliere einen einfachen Bankkontostand über mehrere Transaktionen.

### Anforderungen

1. Starte mit einem Anfangsbetrag (z. B. 1000.00).
2. Führe nacheinander folgende Transaktionen aus:
   - Einzahlung von 250.00 (+=)
   - Auszahlung von 80.00 (-=)
   - Zinsgutschrift von 2% (*= 1.02)
   - Gebührenabzug von 5.50 (-=)
3. Gib nach jeder Transaktion den aktuellen Kontostand aus.
4. Verwende zusammengesetzte Zuweisungen.

### Beispiel

```java
public class Kontostand {
    public static void main(String[] args) {
        double konto = 1000.0;
        System.out.println("Start: " + konto + " EUR");

        konto += 250.0;
        System.out.println("Nach Einzahlung: " + konto + " EUR");

        konto -= 80.0;
        System.out.println("Nach Auszahlung: " + konto + " EUR");

        konto *= 1.02;
        System.out.println("Nach Zinsen (2%): " + konto + " EUR");

        konto -= 5.50;
        System.out.println("Nach Gebuehren: " + konto + " EUR");
    }
}
```

### Erweiterung

Berechne auch, wie viele Transaktionen durchgeführt wurden (Zählvariable). Gib die Anzahl am Ende aus.
