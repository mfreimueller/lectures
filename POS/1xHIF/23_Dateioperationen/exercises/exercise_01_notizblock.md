# Exercise: Notizblock

Schreibe ein Programm, das einen einfachen Notizblock realisiert. Die Notizen werden in der Datei `notizen.txt` gespeichert.

## Menü

Das Programm zeigt ein Menü und führt die gewählte Aktion aus:

```
=== Notizblock ===
1 - Neue Notiz hinzufügen
2 - Alle Notizen anzeigen
3 - Alle Notizen löschen
4 - Beenden
Deine Wahl: _
```

## Funktionen

1. **Neue Notiz hinzufügen**: Der Benutzer gibt eine Zeile Text ein. Diese wird an die Datei `notizen.txt` angehängt (nicht überschreiben!).
2. **Alle Notizen anzeigen**: Die gesamte Datei wird gelesen und jede Zeile nummeriert ausgegeben.
3. **Alle Notizen löschen**: Die Datei wird geleert (überschreiben mit leerem Inhalt).
4. **Beenden**: Programm beenden.

## Anforderungen

- Verwende try-with-resources für alle Dateizugriffe
- Behandle IOException mit try-catch
- Prüfe, ob die Datei existiert, bevor du sie liest

## Beispiel

```
=== Notizblock ===
1 - Neue Notiz hinzufügen
2 - Alle Notizen anzeigen
3 - Alle Notizen löschen
4 - Beenden
Deine Wahl: 1
Notiz: Heute Java gelernt!
Notiz hinzugefügt.

Deine Wahl: 2
1: Heute Java gelernt!

Deine Wahl: 4
Auf Wiedersehen!
```