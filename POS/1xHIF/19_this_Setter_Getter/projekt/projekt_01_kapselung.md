# Jahresprojekt: Dungeon Crawler — Kapselung

Füge die Kapselung (private Attribute + Setter/Getter) zu deinen Dungeon Crawler-Klassen hinzu.

## Player

- `setName(String name)` — Name darf nicht leer sein
- `getName()` — gibt den Namen zurück
- `getHp()` — gibt aktuelle HP zurück (kein Setter)
- `getMaxHp()` — gibt maximale HP zurück (kein Setter)
- `getAttack()` — gibt Angriffswert zurück
- `setAttack(int attack)` — Angriff muss positiv sein

HP werden nur über `takeDamage(int damage)` und `heal(int amount)` verändert.

## Enemy

- `getName()`, `getHp()`, `getAttack()`, `getXpReward()`
- `void takeDamage(int damage)` — verwendet `this` für den Attribut-Zugriff

## Item

- Getter für `name`, `heilung`, `schaden`
- Setter nur für `name`

Der Dungeon Crawler verwendet jetzt durchgängig private Attribute mit öffentlichen Methoden.