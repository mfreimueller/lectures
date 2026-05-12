# Kata 3: Schueler mit Noten-Prüfung

| Feld | Wert |
|------|------|
| Konzepte | Setter mit Validierung, Bereichspruefung |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle eine gekapselte Klasse `Schueler`:

1. Attribute: `private String name`, `private int note`
2. Getter: `getName()`, `getNote()`
3. Setter: `setName(String name)`, `setNote(int note)`
4. `setNote(int note)` akzeptiert nur Werte von 1 bis 5 (oesterreichisches Notensystem)
5. Bei ungueltiger Note: Fehlermeldung ausgeben, Wert nicht setzen
6. Konstruktor: `Schueler(String name, int note)` mit Pruefung

### Beispiel-Output

```
Schueler: Max Mustermann, Note: 2
Note auf 6 setzen... Fehler: Note muss zwischen 1 und 5 liegen!
Note auf 3 setzen... Erfolgreich.
Schueler: Max Mustermann, Note: 3
```
