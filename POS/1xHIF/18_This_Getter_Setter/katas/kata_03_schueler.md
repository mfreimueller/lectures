# Kata 3: Schüler mit Noten-PrÃ¼fung

| Feld | Wert |
|------|------|
| Konzepte | Setter mit Validierung, Bereichsprüfung |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle eine gekapselte Klasse `Schüler`:

1. Attribute: `private String name`, `private int note`
2. Getter: `getName()`, `getNote()`
3. Setter: `setName(String name)`, `setNote(int note)`
4. `setNote(int note)` akzeptiert nur Werte von 1 bis 5 (österreichisches Notensystem)
5. Bei ungültiger Note: Fehlermeldung ausgeben, Wert nicht setzen
6. Konstruktor: `Schüler(String name, int note)` mit Prüfung

### Beispiel-Output

```
Schüler: Max Mustermann, Note: 2
Note auf 6 setzen... Fehler: Note muss zwischen 1 und 5 liegen!
Note auf 3 setzen... Erfolgreich.
Schüler: Max Mustermann, Note: 3
```
