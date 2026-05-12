# Kata 01: Labyrinth ausgeben

Schreibe eine Methode `void labyrinthAusgeben(int[][] labyrinth)`, die ein 2D-Array mit 0 und 1 als Karte ausgibt:
- 0 = Weg (Leerzeichen)
- 1 = Wand (#)

Teste mit folgendem Labyrinth:

```java
int[][] labyrinth = {
    {1, 1, 1, 1, 1},
    {1, 0, 0, 0, 1},
    {1, 0, 1, 0, 1},
    {1, 0, 0, 0, 1},
    {1, 1, 1, 1, 1}
};
```

Erwartete Ausgabe:
```
#####
#   #
# # #
#   #
#####
```

Hinweise:
- Verwende zwei verschachtelte for-Schleifen
- Gib fuer 0 ein Leerzeichen aus, fuer 1 ein #
- Nach jeder Zeile einen Zeilenumbruch
