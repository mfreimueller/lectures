# Exercise: BMI-Rechner

**Ziel:** Ein BMI-Rechner, der Gewicht und Größe als Text einliest und mit `Double.parseDouble` umwandelt.

## Anforderungen

1. Der Benutzer gibt sein Gewicht in kg ein (z. B. "75").
2. Der Benutzer gibt seine Größe in Metern ein (z. B. "1,85").
3. Wandle beide mit `Double.parseDouble` um (ersetze Komma durch Punkt).
4. Berechne den BMI: `bmi = gewicht / (groesse * groesse)`.
5. Gib den BMI aus.
6. Gib eine Kategorie aus:
   - BMI < 18.5 → "Untergewicht"
   - BMI < 25 → "Normalgewicht"
   - BMI < 30 → "Übergewicht"
   - Sonst → "Adipositas"

## Beispielablauf

```
Gib dein Gewicht in kg ein: 75
Gib deine Größe in Metern ein: 1,85
Dein BMI: 21.91
Kategorie: Normalgewicht
```

## Erweiterung (optional)

Fange ungültige Eingaben ab (z. B. Buchstaben statt Zahlen) und gib eine Fehlermeldung aus.
