# Kata 2: Payment Strategies

| Feld | Wert |
|------|------|
| Konzepte | Strategy Pattern, Runtime Selection, Polymorphie |
| Schwierigkeit | 2/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Implementiere das Strategy Pattern für ein Zahlungssystem mit verschiedenen Zahlungsmethoden.

Erstelle:
1. Ein `PaymentStrategy`-Interface mit `void pay(double amount)` und `String getMethodName()`
2. Drei konkrete Strategien: `CreditCardStrategy`, `PayPalStrategy`, `BitcoinStrategy`
3. Eine `ShoppingCart`-Context-Klasse, die Artikel sammelt und mit einer gewählten Strategie bezahlt
4. Ein Hauptprogramm, das verschiedene Zahlungsmethoden demonstriert

### Beispiel-Output

```
Article: Laptop (999.99 EUR)
Article: Mouse (29.99 EUR)
Article: Keyboard (79.99 EUR)

Warenkorb Summe: 1109.97 EUR
Zahlungsmethode: Kreditkarte (****-1234)
Zahlung von 1109.97 EUR mit Kreditkarte (****-1234) erfolgreich

Neue Bestellung:
Warenkorb Summe: 1109.97 EUR
Zahlungsmethode: PayPal (user@example.com)
Zahlung von 1109.97 EUR mit PayPal (user@example.com) erfolgreich
```

### Erweiterung

Füge eine Strategie `GiftCardStrategy` hinzu, die zusätzlich den Gutscheincode validiert und den Gutscheinbetrag vom Gesamtbetrag abzieht.
