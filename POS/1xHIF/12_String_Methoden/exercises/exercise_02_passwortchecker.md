# Große Übung: Passwort-Checker

Schreibe einen Passwort-Checker. Der Benutzer gibt ein Passwort ein. Das Programm prüft:

- Mindestens 8 Zeichen lang (`length`)
- Enthält mindestens eine Ziffer (durchlaufe mit `charAt`)
- Enthält mindestens einen Großbuchstaben
- Enthält mindestens einen Kleinbuchstaben
- Endet nicht mit einem Sonderzeichen (`endsWith`)

Gib für jede Regel aus, ob sie erfüllt ist. Am Ende: "Passwort gültig" oder "Passwort zu schwach".

**Beispielablauf (Benutzereingabe fett):**

```
Passwort eingeben: Hallo123

Pruefung:
  Min. 8 Zeichen: ja
  Enthaelt Ziffer: ja
  Enthaelt Grossbuchstaben: ja
  Enthaelt Kleinbuchstaben: ja
  Endet nicht mit Sonderzeichen: ja

Passwort gueltig!
```

**Bei schwachem Passwort:**

```
Passwort eingeben: kurz

Pruefung:
  Min. 8 Zeichen: nein (5)
  Enthaelt Ziffer: nein
  Enthaelt Grossbuchstaben: nein
  Enthaelt Kleinbuchstaben: ja
  Endet nicht mit Sonderzeichen: ja

Passwort zu schwach!
```

### Hinweise

- Durchlaufe das Passwort mit einer `for`-Schleife und `charAt(i)`.
- Prüfe jedes Zeichen: Ist es eine Ziffer? (`c >= '0' && c <= '9'`)
- Ist es ein Großbuchstabe? (`c >= 'A' && c <= 'Z'`)
- Ist es ein Kleinbuchstabe? (`c >= 'a' && c <= 'z'`)
- Für die Sonderzeichen-Prüfung: `endsWith("!")` oder `endsWith("?")` oder `endsWith(".")` usw.
- Führe für jede Regel eine boolean-Variable, die zu Beginn false ist.

### Erweiterung

- Prüfe zusätzlich, ob das Passwort ein häufig verwendetens Passwort ist (z. B. "password", "12345678", "passwort").
- Gib eine Bewertung von 1–5 Sternen aus, je nachdem wie viele Regeln erfüllt sind.
- Fordere den Benutzer auf, das Passwort zweimal einzugeben und prüfe, ob beide Eingaben identisch sind.
