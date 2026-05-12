# Dungeon Escape - Woche 22: UML und Gegner

## Aufgabe

In dieser Woche erstellst du ein UML-Diagramm deines Dungeon Escape und implementierst eine Gegner-Klasse.

### Teil 1: UML zeichnen

Zeichne das UML-Klassendiagramm deines bisherigen Dungeon Escape. Verwende Text-Notation:

```
+---------------------+
| Klassenname         |
+---------------------+
| - attribut: Typ     |
+---------------------+
| + methode(): Typ    |
+---------------------+
```

Berucksichtige alle bisherigen Klassen:
- Raum (mit Attributen und Methoden)
- Spieler (mit Inventar, Bewegung)
- Gegenstand (falls bereits vorhanden)

Vergiss die Assoziationen (Linien) und Multiplizitaten nicht.

### Teil 2: Gegner-Klasse implementieren

Aus dem UML-Diagramm:

```
+---------------------+
| Gegner              |
+---------------------+
| - name: String      |
| - hp: int           |
| - schaden: int      |
+---------------------+
| + Gegner(n,h,s)     |
| + angreifen(): String|
| + getHp(): int      |
| + setHp(int): void  |
+---------------------+
```

### Teil 3: Integration

- Fuge der Klasse Raum ein Attribut `gegner` (Gegner) hinzu
- Wenn der Spieler einen Raum betritt und dort ein Gegner ist, greift der Gegner an
- Der Spieler bekommt Lebenspunkte (hp) - starte mit 20 HP
- Ausgabe: "Ein Goblin greift dich an! (-3 HP)"

### Beispiel-Output

```
Du betrittst den Dungeon.
Ein Goblin greift dich an! (-3 HP)
Du hast noch 17 HP.

> norden
Du gehst nach Norden.
Hier ist es ruhig. Kein Gegner in Sicht.
```
