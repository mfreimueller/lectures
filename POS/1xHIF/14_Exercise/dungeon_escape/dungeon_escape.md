# Dungeon Escape - Woche 14: Exercise

## Aufgabe: Dungeon Escape von Grund auf neu schreiben

Schreibe das gesamte Dungeon Escape Spiel komplett neu. Du bekommst keine Vorlage. Ueberlege dir die Struktur selbst.

### Anforderungen

1. Der Spieler hat einen Namen und HP (Lebenspunkte)
2. Der Spieler kann durch Raeume gehen (z.B. Norden, Sueden, Osten, Westen)
3. Es gibt mindestens einen Raum mit einem Gegner
4. Der Spieler kann kaempfen: Angriff gegen Verteidigung, HP werden abgezogen
5. Gib Status-Informationen aus: Name, HP, aktueller Raum
6. Das Spiel laeuft in einer while-Schleife, bis der Spieler gewinnt oder stirbt
7. Verwende Scanner fuer Benutzereingaben

### Befehle, die der Spieler eingeben kann

- `gehe <richtung>` - bewege dich in eine Richtung
- `kaempfe` - kaempfe gegen den Gegner im Raum
- `status` - zeige Spieler-Status an
- `hilfe` - zeige alle Befehle an
- `ende` - beende das Spiel

### Beispiel-Output

```
=== Dungeon Escape ===
Du bist in einem dunklen Raum.
Ausgaenge: Norden, Osten
Was moechtest du tun? status
Name: Held, HP: 100, Angriff: 15, Verteidigung: 8
Was moechtest du tun? gehe Norden
Du bist in einem Gang. Ein Goblin greift an!
Was moechtest du tun? kaempfe
Du greifst an! Schaden: 7. Goblin HP: 13
Was moechtest du tun? kaempfe
Du greifst an! Schaden: 5. Goblin HP: 8
```

### Hinweise

- Beginne mit einer einfachen Struktur: while-Schleife, if-Bedingungen fuer Befehle
- Verwende Variablen fuer Spieler-Status (name, hp, angriff, verteidigung)
- Raeume koennen mit Strings oder int-Konstanten repraesentiert werden
- Kaempfe: ziehe Gegner-HP ab, bis einer 0 erreicht
- Denke daran: Dies ist eine Uebung zur Festigung aller bisherigen Themen
