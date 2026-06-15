# Jahresprojekt: Dungeon Crawler — Raum-Karte

Erstelle eine Klasse `Room` mit folgenden Attributen:

- `String name`
- `String beschreibung`
- `Room north` (Referenz auf Raum im Norden)
- `Room south` (Referenz auf Raum im Süden)
- `Room east` (Referenz auf Raum im Osten)
- `Room west` (Referenz auf Raum im Westen)
- `Enemy enemy` (optional, kann null sein)
- `Item item` (optional, kann null sein)

## Anforderungen

- Konstruktor: `Room(String name, String beschreibung)`
- Getter und Setter für alle Attribute
- Eine Methode `void printDescription()`, die Name, Beschreibung und eventuell Gegner/Items ausgibt

## Karte erstellen

Baue eine kleine Karte (3-4 Räume), die über Referenzen verbunden ist:

```java
Room eingang = new Room("Eingang", "Ein dunkler Gang");
Room halle = new Room("Halle", "Eine große Halle mit Saulen");
Room schatz = new Room("Schatzkammer", "Hier glitzert Gold!");

eingang.north = halle;
halle.south = eingang;
halle.north = schatz;
schatz.south = halle;
```

## Navigation

Der Spieler kann mit `gehe norden`, `gehe süden` etc. zwischen Räumen navigieren.
Die null-Prüfung stellt sicher, dass der Spieler nicht aus der Karte fällt.

```java
public void gehe(Richtung r) {
    Room next = null;
    if (r == Richtung.NORDEN) next = currentRoom.getNorth();
    // ...
    if (next != null) {
        currentRoom = next;
    } else {
        System.out.println("Dort geht es nicht weiter!");
    }
}
```