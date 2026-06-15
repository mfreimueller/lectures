# Exercise: Team-Verwaltung

Schreibe zwei Klassen: `Team` und `Member`.

## Klasse Member

- Attribute: `name` (String), `alter` (int)
- Konstruktor: `Member(String name, int alter)`
- Getter und Setter für beide Attribute

## Klasse Team

- Attribute: `name` (String), `members` (Member[])
- Konstruktor: `Team(String name, int maxMembers)` — erzeugt das Array
- Methode: `void addMember(Member m)` — fügt ein Mitglied am nächsten freien Platz hinzu
- Methode: `void printTeam()` — gibt alle Mitglieder aus
- Methode: `Member getMember(int index)` — gibt das Mitglied an Position index zurück

## Test

Erzeuge ein Team und füge 3 Mitglieder hinzu.
Gib das gesamte Team aus.
Ändere dann den Namen eines Members über die Referenz, die du von `getMember` bekommst.
Gib das Team erneut aus — die Änderung sollte sichtbar sein, weil es sich um dieselbe Referenz handelt.