# Kata 2: Game-of-Life Zelle

| Feld | Wert |
|------|------|
| Konzepte | Klassenmodellierung, Zustand, Methode mit Logik |
| Schwierigkeit | 3/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Conways Game of Life ist ein zellularer Automat. In dieser Kata modellierst du eine einzelne Zelle als Java-Klasse.

1. **Klasse `Zelle`** mit folgenden Attributen:
   - `lebendig` (boolean): true = Zelle lebt, false = Zelle ist tot
   - `nachbarn` (int): Anzahl der lebenden Nachbarn (wird von aussen gesetzt)

2. **Methoden:**
   - Konstruktor: `Zelle(boolean lebendig)`
   - Getter/Setter fur `lebendig` und `nachbarn`
   - Methode `naechsteGeneration()`: Berechne, ob die Zelle in der nachsten Generation lebt, basierend auf den Game-of-Life-Regeln:
     - Eine lebende Zelle mit weniger als 2 lebenden Nachbarn stirbt (Unterbevolkerung)
     - Eine lebende Zelle mit 2 oder 3 lebenden Nachbarn lebt weiter
     - Eine lebende Zelle mit mehr als 3 lebenden Nachbarn stirbt (Uberbevolkerung)
     - Eine tote Zelle mit genau 3 lebenden Nachbarn wird lebendig (Reproduktion)
   - Die Methode `naechsteGeneration()` gibt einen boolean zuruck (true = lebt in der nachsten Generation, false = tot)

### Beispiel-Output

```
Zelle z = new Zelle(true);  // lebendig
z.setNachbarn(1);            // nur 1 Nachbar -> stirbt
boolean naechste = z.naechsteGeneration();
System.out.println(naechste); // false

z.setNachbarn(2);            // 2 Nachbarn -> lebt weiter
naechste = z.naechsteGeneration();
System.out.println(naechste); // true

Zelle tot = new Zelle(false); // tot
tot.setNachbarn(3);           // 3 Nachbarn -> wird lebendig
naechste = tot.naechsteGeneration();
System.out.println(naechste); // true
```
