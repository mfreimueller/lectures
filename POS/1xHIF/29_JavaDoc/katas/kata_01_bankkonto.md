# Kata 01: Bankkonto dokumentieren

Dokumentiere die Klasse Bankkonto vollständig mit JavaDoc.

## Anforderungen
- Dokumentiere die Klasse mit @author
- Dokumentiere alle Methoden mit @param und @return
- Verwende @version für die Version

## Vorlage
```java
class Bankkonto {
    private double kontostand;

    public void einzahlen(double betrag) {
        kontostand += betrag;
    }

    public void auszahlen(double betrag) {
        kontostand -= betrag;
    }

    public double getKontostand() {
        return kontostand;
    }
}
```

## Hinweise
- Beschreibe WAS die Methode tut, nicht WIE
- Gib an, ob der Betrag positiv sein muss
- Beschreibe mögliche Fehlerfälle
