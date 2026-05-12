# Kata 02: Notenverwaltung OO

Verwalte Schuelernoten mit einer Klasse.

## Anforderungen
- Klasse Schueler mit Attributen: name (String), noten (int[])
- Methode durchschnitt(): berechnet den Notendurchschnitt
- Methode besteNote(): gibt die beste Note zurueck
- Methode schlechtesteNote(): gibt die schlechteste Note zurueck
- Methode anzahlDurchgefallen(): zaehlt Noten &gt; 4 (im oesterreichischen System)
- Erstelle mehrere Schueler und gib ihre Statistiken aus

## Beispiel
```java
Schueler s1 = new Schueler("Anna", new int[]{1, 2, 3, 1, 2});
System.out.println(s1.durchschnitt()); // 1.8
```
