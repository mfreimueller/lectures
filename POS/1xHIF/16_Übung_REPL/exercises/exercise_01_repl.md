# Exercise: Mini-Befehlsinterpreter

**Ziel:** Baue eine REPL mit mehreren Befehlen (case-insensitive).

## Anforderungen

Unterstütze folgende Befehle:
- `help` — zeigt alle verfügbaren Befehle an
- `echo <text>` — gibt den Text aus
- `add <zahl1> <zahl2>` — addiert zwei Zahlen
- `reverse <text>` — gibt den Text rückwärts aus
- `len <text>` — gibt die Länge des Textes aus
- `exit` — beendet die REPL

Verwende String-Methoden und switch-case für die Befehlsauswertung. Die Befehle sollen case-insensitive sein (groß/klein egal).

## Beispielablauf

```
> help
Verfügbare Befehle: help, echo, add, reverse, len, exit
> echo Hallo Welt
Hallo Welt
> add 10 20
= 30.0
> reverse Test
tseT
> len Hallo
5
> EXIT
Programm beendet.
```
