# Jahresprojekt: Dungeon Crawler — JavaDoc

Dokumentiere den gesamten Dungeon Crawler vollständig mit JavaDoc.

## Anforderungen

Jede Klasse erhält:
- Klassen-JavaDoc mit Beschreibung, @author (dein Name), @since (aktuelles Datum)

Jede öffentliche Methode erhält:
- Beschreibung, was die Methode tut
- @param für jeden Parameter
- @return falls die Methode etwas zurückgibt

## Mindestanforderungen für Player

```java
/**
 * Repräsentiert den Spieler im Dungeon Crawler.
 * Verwaltet HP, Angriff, Erfahrungspunkte und Level.
 *
 * @author Dein Name
 * @since 2024
 */
public class Player {
    // ...

    /**
     * Erzeugt einen neuen Spieler.
     *
     * @param name   Der Name des Spielers
     * @param maxHp  Die maximalen Lebenspunkte
     * @param attack Der Angriffswert
     */
    public Player(String name, int maxHp, int attack) { ... }

    /**
     * Fügt dem Spieler Schaden zu.
     *
     * @param damage Die Höhe des Schadens
     */
    public void takeDamage(int damage) { ... }

    /**
     * Heilt den Spieler um einen bestimmten Betrag.
     *
     * @param amount Die Heilungsmenge
     */
    public void heal(int amount) { ... }

    /**
     * Prüft, ob der Spieler noch lebt.
     *
     * @return true wenn HP > 0, sonst false
     */
    public boolean isAlive() { ... }
}
```

## Generierung

Generiere am Ende die HTML-Dokumentation:

```bash
javadoc -d doc *.java
```

Öffne `doc/index.html` im Browser. Betrachte dein fertig dokumentiertes Projekt als Portfolionachweis.