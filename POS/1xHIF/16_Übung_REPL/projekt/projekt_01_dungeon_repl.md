# Jahresprojekt: Dungeon Crawler — REPL

Stelle den Dungeon Crawler auf eine REPL-Architektur um.

## Aufgaben

1. **REPL-Schleife:** Der Spieler gibt Kommandos in einer Schleife ein.
2. **Befehle:**
   - `hilfe` — zeigt Befehle an
   - `status` — zeigt Spielerwerte
   - `gehe <richtung>` — bewegt den Spieler
   - `kämpfe` — startet einen Kampf
   - `inventar` — zeigt Inventar
   - `quit` — beendet das Spiel
3. **Befehlsauswertung:** Verwende `switch` auf dem ersten Wort der Eingabe. Zerlege die Eingabe mit `split(" ")`.
