# Kata 2: Entity vs Value Object

| Feld | Wert |
|------|------|
| Konzepte | Entity, Value Object, Identity, Immutability |
| Schwierigkeit | 3/5 |
| Dauer | ca. 25 min |

## Aufgabenstellung

Gegeben sind die folgenden Domanenkonzepte eines Online-Shops. Klassifizieren Sie jedes Konzept als **Entity** oder **Value Object** und begrunden Sie Ihre Entscheidung. Implementieren Sie anschlieend drei der Konzepte in Java (mindestens eine Entity und ein Value Object).

Konzepte:
1. **Bestellung** — Ein Kunde bestellt Waren
2. **Geldbetrag** — Ein Betrag bestehend aus Wert und Wahrung
3. **Kunde** — Ein registrierter Benutzer des Shops
4. **Adresse** — Eine Lieferadresse (Strae, PLZ, Ort, Land)
5. **Bestellposition** — Eine Zeile in einer Bestellung (Produkt, Menge, Preis)
6. **Produkt** — Eine verkaufbare Einheit mit SKU

Kriterien zur Entscheidung:
- Hat das Konzept eine eindeutige, uber die Zeit stabile Identitat? -> Entity
- Wird das Konzept nur durch seine Attribute definiert und ist unveranderlich? -> Value Object

### Beispiel-Output

```
Kunde -> Entity (hat Kundennummer als Identitat)
Adresse -> Value Object (wird durch ihre Attribute definiert, unveranderlich)
```

### Erweiterung

Identifizieren Sie, ob eines der Value Objects ein "Nested Value Object" enthalt (z.B. Adresse enthalt Land als Value Object).
