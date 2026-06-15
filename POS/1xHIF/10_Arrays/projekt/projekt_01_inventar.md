# Jahresprojekt — Dungeon Crawler: Inventar

Der Spieler bekommt ein Inventar als `String`-Array (z. B. `{"Schwert", "Heiltrank", "Schluessel", "Fackel"}`). Gib mit einer `for`-Schleife alle Items aus. Der Spieler kann ein Item über den Index auswählen. Zeige eine Inventar-Verwaltung: Liste anzeigen, Item benutzen (entfernen — hier nur simulieren).

### Aufgaben

1. Erstelle ein String-Array mit 4 Items: `"Schwert"`, `"Heiltrank"`, `"Schluessel"`, `"Fackel"`.

2. Zeige ein Inventar-Menü in einer Schleife:
   - `1: Inventar anzeigen`
   - `2: Item benutzen`
   - `0: Zurueck`

3. Bei Option 1:
   - Durchlaufe das Array mit einer `for`-Schleife.
   - Gib jedes Item mit Index aus: `"0: Schwert"`, `"1: Heiltrank"`, ...

4. Bei Option 2:
   - Frage: "Welches Item moechtest du benutzen? (Index)"
   - Lies den Index ein.
   - Gib aus: "Du hast ITEM benutzt."
   - Wenn der Index ungültig ist: "Ungueltiger Index!"

**Beispielablauf:**

```
=== INVENTAR ===
1. Inventar anzeigen
2. Item benutzen
0. Zurueck
Auswahl: 1

Inventar:
0: Schwert
1: Heiltrank
2: Schluessel
3: Fackel

1. Inventar anzeigen
2. Item benutzen
0. Zurueck
Auswahl: 2
Welches Item? (Index): 1
Du hast Heiltrank benutzt.

...
```

### Hinweise

- Prüfe, ob der eingegebene Index gültig ist (`>= 0 && < array.length`).
- Bei ungültigem Index: Fehlermeldung ausgeben.
- Die Items werden noch nicht tatsächlich entfernt — das kommt später.
