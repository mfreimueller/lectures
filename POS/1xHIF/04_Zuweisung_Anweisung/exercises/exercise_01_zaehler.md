# Exercise: Zähl-Programm

Schreibe ein Programm, das einen Zählerstand simuliert.

### Anforderungen

1. Starte einen Zähler bei 0.
2. Erhöhe um 5 (verwende +=).
3. Verdopple den Wert (verwende *=).
4. Ziehe 3 ab (verwende -=).
5. Halbiere den Wert (verwende /=).
6. Gib nach jedem Schritt den aktuellen Wert aus.
7. Verwende ausschließlich zusammengesetzte Zuweisungen.

### Beispiel

```java
public class Zaehler {
    public static void main(String[] args) {
        int zaehler = 0;
        System.out.println("Start: " + zaehler);

        zaehler += 5;
        System.out.println("Nach +5: " + zaehler);

        zaehler *= 2;
        System.out.println("Nach *2: " + zaehler);

        zaehler -= 3;
        System.out.println("Nach -3: " + zaehler);

        zaehler /= 2;
        System.out.println("Nach /2: " + zaehler);
    }
}
```

### Erweiterung

Füge eine zweite Variable `anzahlSchritte` hinzu, die zählt, wie viele Operationen durchgeführt wurden. Erhöhe sie bei jedem Schritt um 1.
