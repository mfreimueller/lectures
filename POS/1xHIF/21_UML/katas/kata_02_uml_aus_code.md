# K2: UML aus Code

Gegeben ist folgender Java-Code:

```java
public class Auto {
    private String kennzeichen;
    private String marke;
    private Rad[] raeder;

    public Auto(String kennzeichen, String marke) {
        this.kennzeichen = kennzeichen;
        this.marke = marke;
        this.raeder = new Rad[4];
    }

    public void setRad(int index, Rad r) {
        raeder[index] = r;
    }
}

public class Rad {
    private int zoll;
    private String typ;

    public Rad(int zoll, String typ) {
        this.zoll = zoll;
        this.typ = typ;
    }
}
```

Zeichne (auf Papier) das dazugehörige UML-Klassendiagramm mit:
- Klassenname, Attributen und Methoden
- Sichtbarkeiten (+ und -)
- Assoziation mit Multiplizität