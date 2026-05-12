# Dungeon Escape - Woche 21: Raum-Netzwerk aufbauen

## Aufgabe

In dieser Woche erweiterst du dein Dungeon zu einem vollstandigen, begehbaren Netzwerk mit mindestens 6 Raumen.

### Anforderungen

1. **Raum-Netzwerk**
   - Erstelle mindestens 6 Raume mit unterschiedlichen Namen und Beschreibungen
   - Jeder Raum soll mindestens 2 Ausgange haben
   - Erstelle einen Kreislauf (man kann durch mehrere Raume wieder zum Ausgang zuruckkehren)
   - Verwende die setNorden()/setSueden()/... -Methoden, um die Raume zu verlinken

2. **Navigation testen**
   - Teste alle Richtungen (Norden, Suden, Osten, Westen)
   - Teste, dass "Dort ist keine Tur." erscheint, wenn kein Ausgang existiert
   - Laufe einen Kreislauf und uberprufe, ob du zum Start zuruckkehrst

3. **Gegenstande in Raumen**
   - Lege in einigen Raumen Gegenstande ab (der Raum bekommt ein Gegenstand-Attribut)
   - Der Spieler kann Gegenstande vom Raum aufnehmen: `gegenstandAufnehmen(raum.getGegenstand())`

### Beispiel-Output

```
Du bist in der Eingangshalle.
Eine grosse, steinerne Halle mit Kerzenleuchtern.
Ausgange: norden, osten

Du siehst einen Gegenstand: Altes Buch
Moechtest du ihn aufheben? (j/n): j
Altes Buch wurde ins Inventar aufgenommen.

> norden
Du gehst nach Norden.
Du bist im Gang.
Ein langer, schmaler Gang mit Bildern an den Wanden.
Ausgange: suden, norden, osten
```
