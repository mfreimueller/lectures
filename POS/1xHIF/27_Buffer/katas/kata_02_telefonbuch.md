# Kata 02: Telefonbuch

Schreibe ein Programm für ein Telefonbuch mit zwei parallelen Arrays:

- `String[] namen` - die Namen der Personen
- `String[] nummern` - die Telefonnummern

Implementiere eine Methode `String sucheNummer(String name)`, die einen Namen sucht und die zugehörige Telefonnummer zurückgibt.

Beispiel:

```java
String[] namen = {"Aragorn", "Frodo", "Gandalf", "Gimli", "Legolas"};
String[] nummern = {"+43 1 2345678", "+43 1 3456789", "+43 1 4567890", "+43 1 5678901", "+43 1 6789012"};

sucheNummer("Gandalf"); // +43 1 4567890
sucheNummer("Sauron");  // Nicht gefunden
```

Hinweise:
- Verwende sequenzielle Suche (for-Schleife)
- Vergleiche mit `equalsIgnoreCase()` für Gross-/Kleinschreibung
- Gib "Nicht gefunden" zurück, wenn der Name nicht existiert
