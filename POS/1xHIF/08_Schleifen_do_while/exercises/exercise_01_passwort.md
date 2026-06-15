# Exercise: Passwortabfrage

Der Benutzer wird solange nach einem Passwort gefragt, bis er das richtige eingibt. Verwende eine `do-while`-Schleife, da die Eingabe mindestens einmal erfolgen muss. Gib "Zugriff gewährt" oder "Falsches Passwort" aus. Verwende zusätzlich einen Zähler für die Anzahl der Versuche.

**Beispielablauf (Passwort = "geheim", Benutzereingabe fett):**

```
Passwort: hallo
Falsches Passwort! Versuch 1

Passwort: test
Falsches Passwort! Versuch 2

Passwort: geheim
Zugriff gewaehrt! (benoetigte Versuche: 3)
```

### Hinweise

- Lege das richtige Passwort als String fest (z. B. `String passwort = "geheim"`).
- Verwende `do-while` für die Eingabeschleife.
- Vergleiche Strings mit `equals()`, nicht mit `==`.
- Führe einen Zähler `versuche`, der bei jedem Durchlauf erhöht wird.

### Erweiterung

- Brich das Programm ab, wenn der Benutzer 5 mal das falsche Passwort eingegeben hat.
- Gib "Zu viele Versuche. Zugriff verweigert." aus und beende das Programm.
