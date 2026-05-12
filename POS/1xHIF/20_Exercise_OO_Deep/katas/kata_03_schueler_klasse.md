# Kata 3: Schuler und Klasse

| Feld | Wert |
|------|------|
| Konzepte | Zwei Klassen mit Assoziation, Notenverwaltung mit Array |
| Schwierigkeit | 4/5 |
| Dauer | ca. 25 min |

### Aufgabenstellung

Erstelle die Klassen `Schueler` und `Klasse` fur eine Notenverwaltung.

1. **Klasse `Schueler`**:
   - Attribute: `name` (String), `note` (int, 1-5)
   - Konstruktor, Getter, toString()

2. **Klasse `Klasse`**:
   - Attribute: `name` (String), `schueler` (Schueler[20]), `anzahl` (int)
   - Methode `addSchueler(Schueler s)`: Fuge einen Schuler hinzu
   - Methode `printNoten()`: Gib alle Schuler mit Noten aus
   - Methode `getDurchschnitt()`: Berechne den Notendurchschnitt (double)
   - Methode `getBesteNote()`: Gib die beste Note (kleinster Wert) zuruck
   - Methode `getSchlechtesteNote()`: Gib die schlechteste Note (grosster Wert) zuruck
   - Methode `getAnzahlDurchgefallen()`: Zahle die Anzahl der Schulern mit Note 5

### Beispiel-Output

```
Klasse k = new Klasse("1AHIF");
k.addSchueler(new Schueler("Anna", 2));
k.addSchueler(new Schueler("Ben", 5));
k.addSchueler(new Schueler("Clara", 1));
k.printNoten();
// Anna: 2
// Ben: 5
// Clara: 1
System.out.println("Durchschnitt: " + k.getDurchschnitt()); // ~2.67
System.out.println("Beste Note: " + k.getBesteNote()); // 1
System.out.println("Durchgefallen: " + k.getAnzahlDurchgefallen()); // 1
```
