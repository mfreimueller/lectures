# Exercise: Notendurchschnitt

Schreibe ein Programm, das für drei fiktive Schüler Noten speichert und den Durchschnitt berechnet.

### Anforderungen

1. Lege drei `double`-Variablen für die Noten an (z. B. 4.5, 3.0, 2.5).
2. Berechne die Summe aller Noten.
3. Berechne den Durchschnitt (Summe geteilt durch Anzahl).
4. Gib jede Note sowie die Summe und den Durchschnitt formatiert aus.

### Beispiel

```java
public class Notendurchschnitt {
    public static void main(String[] args) {
        double note1 = 4.5;
        double note2 = 3.0;
        double note3 = 2.5;

        double summe = note1 + note2 + note3;
        double durchschnitt = summe / 3;

        System.out.println("Note 1: " + note1);
        System.out.println("Note 2: " + note2);
        System.out.println("Note 3: " + note3);
        System.out.println("Summe: " + summe);
        System.out.println("Durchschnitt: " + durchschnitt);
    }
}
```

### Erweiterung

Berechne auch das Produkt aller Noten (note1 * note2 * note3). Was fällt dir am Ergebnis auf?
