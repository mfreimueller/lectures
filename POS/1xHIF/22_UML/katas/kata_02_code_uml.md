# Kata 2: Code -> UML (Mitarbeiter und Abteilung)

| Feld | Wert |
|------|------|
| Konzepte | Reverse Engineering aus Code, Textuelle UML-Notation |
| Schwierigkeit | 3/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Gegeben ist folgender Java-Code. Zeichne das UML-Klassendiagramm in Textform.

```java
public class Mitarbeiter {
    private String name;
    private double gehalt;

    public Mitarbeiter(String name, double gehalt) {
        this.name = name;
        this.gehalt = gehalt;
    }

    public String getName() { return name; }

    public double getGehalt() { return gehalt; }

    public void gehaltErhoehen(double prozent) {
        this.gehalt *= (1 + prozent / 100);
    }

    @Override
    public String toString() {
        return name + " (" + gehalt + " EUR)";
    }
}

public class Abteilung {
    private String name;
    private Mitarbeiter chef;

    public Abteilung(String name, Mitarbeiter chef) {
        this.name = name;
        this.chef = chef;
    }

    public String getName() { return name; }

    public Mitarbeiter getChef() { return chef; }

    public void printInfo() {
        System.out.println("Abteilung: " + name);
        System.out.println("Chef: " + chef);
    }
}
```

Zeichne das UML-Klassendiagramm mit:
- Allen Klassen, Attributen und Methoden
- Sichtbarkeiten (+/-)
- Datentypen
- Assoziation zwischen den Klassen inklusive Multiplizitat

Verwende folgende Text-Notation:

```
+-------------------+
| Klassenname       |
+-------------------+
| - attribut: Typ   |
+-------------------+
| + methode(): void |
+-------------------+
```
