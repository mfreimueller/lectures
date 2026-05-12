# Kata 1: Auto mit Konstruktor

| Feld | Wert |
|------|------|
| Konzepte | Parametrisierter Konstruktor, Standardkonstruktor |
| Schwierigkeit | 2/5 |
| Dauer | ca. 15 min |

### Aufgabenstellung

Erstelle die Klasse `Auto` mit:

1. Attributen: `marke` (String), `baujahr` (int)
2. Standardkonstruktor: setzt marke = "Unbekannt", baujahr = 0
3. Parametrisierten Konstruktor: `Auto(String marke, int baujahr)`
4. Methode: `printInfo()` gibt Marke und Baujahr aus

Erstelle eine Test-Klasse, die ein Auto mit dem Standardkonstruktor und eines mit dem parametrisierten Konstruktor erzeugt und printInfo() aufruft.

### Beispiel-Output

```
Auto 1: Marke=Unbekannt, Baujahr=0
Auto 2: Marke=VW, Baujahr=2020
```
