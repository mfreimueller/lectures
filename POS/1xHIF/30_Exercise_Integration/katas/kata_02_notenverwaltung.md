# Kata 02: Notenverwaltung OO

Verwalte Schülernoten mit einer Klasse.

## Anforderungen
- Klasse Schüler mit Attributen: name (String), noten (int[])
- Methode durchschnitt(): berechnet den Notendurchschnitt
- Methode besteNote(): gibt die beste Note zurück
- Methode schlechtesteNote(): gibt die schlechteste Note zurück
- Methode anzahlDurchgefallen(): zählt Noten &gt; 4 (im österreichischen System)
- Erstelle mehrere Schüler und gib ihre Statistiken aus

## Beispiel
```java
Schueler s1 = new Schueler("Anna", new int[]{1, 2, 3, 1, 2});
System.out.println(s1.durchschnitt()); // 1.8
```
