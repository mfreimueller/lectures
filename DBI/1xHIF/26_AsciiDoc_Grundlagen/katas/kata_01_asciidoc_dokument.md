# Kata 1: Kurzdokument in AsciiDoc

## Ziel

Lerne die AsciiDoc Grundsyntax: Überschriften, Textformatierung, Listen, Links, Bilder, Code-Blöcke.

## Der wichtigste Unterschied zu Markdown

| Element | Markdown | AsciiDoc |
|---------|----------|----------|
| H1 | `# Titel` | `= Titel` |
| H2 | `## H2` | `== H2` |
| Fett | `**fett**` | `*fett*` |
| Kursiv | `*kursiv*` | `_kursiv_` |
| Link | `[Text](URL)` | `link:URL[Text]` |
| Bild | `![Alt](URL)` | `image::URL[Alt]` |

---

## Aufgabenstellung

Schreibe einen **Steckbrief über dich** als AsciiDoc-Dokument. Verwende alle wichtigen AsciiDoc-Elemente.

### Schritt 1: Grundgerüst

Erstelle eine Datei `steckbrief.adoc`.

Beginne mit dem Titel (H1) und deinem Namen:

```asciidoc
= Steckbrief über mich
Vorname Nachname
```

Der Titel kommt nach `=` (H1) und dein Name direkt darunter (wird als Autor interpretiert).

**Tipp:** Füge auch ein Datum als Attribut hinzu:
```asciidoc
:date: September 2026
```

---

### Schritt 2: Persönliche Daten

Füge eine `==` (H2) Überschrift und eine ungeordnete Liste ein:

```asciidoc
== Persönliche Daten

* Name: Vorname Nachname
* Alter: ...
* Klasse: 1xHIF
* Wohnort: ...
```

---

### Schritt 3: Hobbys

Füge eine weitere `==` Überschrift ein.

Erstelle eine **geordnete Liste** mit 3 Hobbys.
Verwende `*fett*` und `_kursiv_` an mindestens einer Stelle.

```asciidoc
== Meine Hobbys

. Fussball -- ich spiele *jede Woche* im Verein
. Programmieren -- _Python_ und Java
. Lesen -- am liebsten Fantasy-Romane
```

---

### Schritt 4: Lieblingsfach

Füge eine `===` (H3) Überschrift `=== Mein Lieblingsfach` ein.

Schreibe einen Satz zu deinem Lieblingsfach und verlinke ein passendes Thema:

```asciidoc
=== Mein Lieblingsfach

Mein Lieblingsfach ist ...
Mehr dazu auf link:https://de.wikipedia.org/wiki/Informatik[Wikipedia - Informatik]
```

---

### Schritt 5: Bild

Füge eine `===` Überschrift `=== Ein Bild` ein und ein Bild:

```asciidoc
=== Ein Bild

image::https://via.placeholder.com/300x100[Platzhalter-Bild]
```

**Hinweis:** `image::` mit zwei Doppelpunkten! Das ist anders als in Markdown (`![]()`).

---

### Schritt 6: Code-Block

Füge eine `==` Überschrift `== Ein Code-Beispiel` ein.
Darunter einen Code-Block mit Sprachangabe:

```asciidoc
== Ein Code-Beispiel

Hier ist ein kurzes Programm:

[source,python]
----
print("Hallo von meinem Steckbrief!")
for i in range(3):
    print(f"Durchlauf {i+1}")
----
```

---

### Schritt 7: Rendern

Öffne die Vorschau in VS Code:
1. Rechtsklick auf `steckbrief.adoc`
2. "AsciiDoc: Open Preview" (oder `Cmd+Shift+V`)

Oder rendere mit dem Terminal:
```bash
asciidoctor steckbrief.adoc
```

Öffne `steckbrief.html` im Browser.

---

## Kontrolle

Dein Dokument sollte enthalten:

- [ ] `= Titel` als erste Zeile
- [ ] Autor (dein Name) in der zweiten Zeile
- [ ] Mindestens eine `==` H2-Überschrift
- [ ] Mindestens eine `===` H3-Überschrift
- [ ] `*fett*` Text
- [ ] `_kursiv_` Text
- [ ] Ungeordnete Liste mit `*`
- [ ] Geordnete Liste mit `.`
- [ ] Link mit `link:URL[Text]`
- [ ] Bild mit `image::URL[Alt]`
- [ ] Code-Block mit `[source,sprache]` und `----`
- [ ] Vorschau funktioniert (VS Code Preview oder HTML)

## Erweiterung (optional)

1. Füge eine Tabelle hinzu (siehe nächste Woche, aber probier sie jetzt schon):
   ```
   |===
   | Sprache | Level
   | Python | Fortgeschritten
   | Java | Mittel
   |===
   ```
2. Füge ein Zitat mit `____` (4 Unterstriche) hinzu.
3. Füge einen horizontalen Strich mit `'''` (3 Apostrophe) hinzu.
