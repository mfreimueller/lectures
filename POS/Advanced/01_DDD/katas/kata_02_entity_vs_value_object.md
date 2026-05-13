# Kata 2: Entity vs Value Object

| Feld | Wert |
|------|------|
| Konzepte | Entity, Value Object, Identity, Immutability |
| Schwierigkeit | 3/5 |
| Dauer | ca. 25 min |

## Aufgabenstellung

Gegeben sind die folgenden Domanenkonzepte eines Online-Shops. Klassifiziere jedes Konzept als **Entity** oder **Value Object** und begrunde deine Entscheidung. Implementiere anschlieend drei der Konzepte in Java (mindestens eine Entity und ein Value Object).

Konzepte:
1. **Bestellung** — Ein Kunde bestellt Waren
2. **Geldbetrag** — Ein Betrag bestehend aus Wert und Währung
3. **Kunde** — Ein registrierter Benutzer des Shops
4. **Adresse** — Eine Lieferadresse (Straße, PLZ, Ort, Land)
5. **Bestellposition** — Eine Zeile in einer Bestellung (Produkt, Menge, Preis)
6. **Produkt** — Eine verkaufbare Einheit mit SKU

Kriterien zur Entscheidung:
- Hat das Konzept eine eindeutige, über die Zeit stabile Identitat? -> Entity
- Wird das Konzept nur durch seine Attribute definiert und ist unveranderlich? -> Value Object

### Beispiel-Output

```
Kunde -> Entity (hat Kundennummer als Identitat)
Adresse -> Value Object (wird durch ihre Attribute definiert, unveranderlich)
```

### Erweiterung

Identifiziere, ob eines der Value Objects ein "Nested Value Object" enthalt (z.B. Adresse enthalt Land als Value Object).
