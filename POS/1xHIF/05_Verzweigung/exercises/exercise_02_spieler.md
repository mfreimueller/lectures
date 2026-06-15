# Große Übung: Spieler-Typisierung

Ein Rollenspiel-Charakter hat drei Eigenschaften: Stärke, Geschicklichkeit, Intelligenz (jeweils 1–10). Bestimme anhand der Werte die Klasse des Charakters.

### Anforderungen

1. Lege drei Variablen an: staerke, geschicklichkeit, intelligenz (Werte zwischen 1 und 10).
2. Bestimme die Klasse nach folgenden Regeln:
   - Stärke > 7 → Krieger
   - Geschicklichkeit > 7 → Schurke
   - Intelligenz > 7 → Magier
   - Kein Wert > 7 aber mindestens zwei > 5 → Waldläufer
   - Sonst → Bauer
3. Gib die Klasse und eine kurze Beschreibung aus.

### Beispiel

```java
public class SpielerTypisierung {
    public static void main(String[] args) {
        int staerke = 8;
        int geschicklichkeit = 4;
        int intelligenz = 3;

        String klasse;

        if (staerke > 7) {
            klasse = "Krieger";
        } else if (geschicklichkeit > 7) {
            klasse = "Schurke";
        } else if (intelligenz > 7) {
            klasse = "Magier";
        } else if (staerke > 5 && geschicklichkeit > 5
                   || staerke > 5 && intelligenz > 5
                   || geschicklichkeit > 5 && intelligenz > 5) {
            klasse = "Waldlaeufer";
        } else {
            klasse = "Bauer";
        }

        System.out.println("Staerke: " + staerke);
        System.out.println("Geschicklichkeit: " + geschicklichkeit);
        System.out.println("Intelligenz: " + intelligenz);
        System.out.println("Klasse: " + klasse);
    }
}
```

### Erweiterung

Experimentiere mit verschiedenen Werte-Kombinationen und dokumentiere die Ergebnisse. Welche Kombination ergibt welche Klasse?
