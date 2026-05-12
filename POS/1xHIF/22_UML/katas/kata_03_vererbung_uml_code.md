# Kata 3: Vererbung in UML (Tier -> Hund, Katze)

| Feld | Wert |
|------|------|
| Konzepte | Vererbung in UML, Generalisierung |
| Schwierigkeit | 3/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Gegeben ist folgendes UML-Klassendiagramm mit Vererbung. Schreibe den Java-Code.

```
+-----------------------------+
|          Tier               |
+-----------------------------+
| - name: String              |
| - alter: int                |
+-----------------------------+
| + Tier(name, alter)         |
| + getName(): String         |
| + getAlter(): int           |
| + lautGeben(): String       |
+-----------------------------+
          |        |
          |        |
    +-----+        +-----+
    |                     |
+-----------+     +-----------+
|   Hund    |     |   Katze   |
+-----------+     +-----------+
| - rasse   |     | - frisst  |
+-----------+     +-----------+
| + Hund    |     | + Katze   |
| + laut    |     | + laut    |
| + bewachen|     | + jagen   |
+-----------+     +-----------+
```

1. Erstelle die Klasse `Tier` mit den Attributen und Methoden aus dem UML.
2. Erstelle die Klasse `Hund`, die von `Tier` erbt. Uberschreibe `lautGeben()` zuruck "Wuff!".
3. Erstelle die Klasse `Katze`, die von `Tier` erbt. Uberschreibe `lautGeben()` zuruck "Miau!".
4. Teste alle Klassen in einer main()-Methode.

### Beispiel-Output

```
Tier tier = new Tier("Tier", 5);
System.out.println(tier.lautGeben()); // "..."

Hund hund = new Hund("Rex", 3, "Schaeferhund");
System.out.println(hund.lautGeben()); // "Wuff!"
System.out.println(hund.bewachen()); // "Rex bewacht das Haus!"

Katze katze = new Katze("Minka", 2, "Maeusee");
System.out.println(katze.lautGeben()); // "Miau!"
System.out.println(katze.jagen()); // "Minka jagt Maeusee!"
```
