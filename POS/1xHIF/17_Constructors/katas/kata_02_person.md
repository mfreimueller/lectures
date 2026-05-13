# Kata 2: Person mit Konstruktor-Überladung

| Feld | Wert |
|------|------|
| Konzepte | Konstruktor-Überladung, this() |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle die Klasse `Person` mit:

1. Attributen: `name` (String), `alter` (int)
2. `Person()` - name = "Unbekannt", alter = 0
3. `Person(String name)` - name wird gesetzt, alter = 0
4. `Person(String name, int alter)` - beide Attribute werden gesetzt
5. Verwende this() um Code-Wiederholung zu vermeiden
6. Methode: `printInfo()` gibt Name und Alter aus

Erstelle eine Test-Klasse, die alle drei Konstruktoren testet.

### Beispiel-Output

```
Person 1: Name=Unbekannt, Alter=0
Person 2: Name=Max, Alter=0
Person 3: Name=Anna, Alter=25
```
