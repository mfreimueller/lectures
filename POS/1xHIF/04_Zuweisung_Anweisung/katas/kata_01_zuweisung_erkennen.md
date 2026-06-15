# Kata 1: Zuweisung erkennen

| Feld | Wert |
|------|------|
| Konzepte | Ausdruck, Anweisung, Zuweisung |
| Schwierigkeit | 1/5 |
| Dauer | ca. 10 min |

### Aufgabenstellung

Gegeben sind die folgenden Codezeilen. Markiere für jede Zeile, ob es sich um eine Zuweisung, einen Ausdruck oder eine Anweisung handelt. Begründe deine Antwort.

```java
int a;                  // Zeile 1
a = 5;                  // Zeile 2
5 + 3                   // Zeile 3
int b = a + 2;          // Zeile 4
System.out.println(b);  // Zeile 5
b = a + 2               // Zeile 6
b += 3;                 // Zeile 7
```

### Beispiel-Lösung (nur als Formatvorlage)

| Zeile | Typ | Begründung |
|-------|-----|------------|
| 1 | Deklarations-Anweisung | Variable wird deklariert, endet mit ; |
| 3 | Ausdruck (Expression) | 5 + 3 ergibt einen Wert, kein Semikolon |

### Erweiterung

Formuliere zu jedem Ausdruck aus der Liste eine passende Anweisung (füge Semikolon hinzu oder weise einer Variable zu).
