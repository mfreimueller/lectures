# K3: Taschenrechner-REPL

**Ziel:** Eine REPL, die einfache Rechnungen ausführt.

Der Benutzer gibt eine Rechnung im Format "zahl operator zahl" ein (z. B. "5 + 3"). Die REPL gibt das Ergebnis aus. Unterstütze `+`, `-`, `*`, `/`. Verwende String-Methoden zum Zerlegen der Eingabe.

**Beispielablauf:**
```
> 5 + 3
= 8.0
> 10 / 4
= 2.5
> exit
Programm beendet.
```

**Hinweis:** Zerlege die Eingabe mit `split(" ")` in ein String-Array.
