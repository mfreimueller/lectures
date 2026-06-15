# Exercise: Datenprofil

Erstelle ein Programm, das ein detailliertes Profil einer fiktiven Person oder eines Charakters ausgibt. Du kannst eine reale Person, eine Spielfigur oder eine Fantasiegestalt beschreiben.

### Anforderungen

1. Alle fünf Datentypen (`boolean`, `int`, `double`, `String`, `char`) müssen mindestens einmal vorkommen.
2. Verwende aussagekräftige Variablennamen.
3. Gib die Daten strukturiert auf der Konsole aus (z. B. "Name: ..., Alter: ..., Größe: ...").
4. Das Programm muss compilierbar und ausführbar sein.

### Beispiel

```java
public class Datenprofil {
    public static void main(String[] args) {
        String name = "Elena Stolz";
        int alter = 25;
        double groesse = 1.68;
        char initial = 'E';
        boolean istVolljaehrig = true;

        System.out.println("=== Persoenliches Profil ===");
        System.out.println("Name: " + name);
        System.out.println("Alter: " + alter);
        System.out.println("Groesse: " + groesse + " m");
        System.out.println("Initial: " + initial);
        System.out.println("Volljaehrig: " + istVolljaehrig);
    }
}
```

### Erweiterung

Füge eine zweite Person hinzu und gib beide Profile nebeneinander aus (z. B. mit erklärendem Text).
