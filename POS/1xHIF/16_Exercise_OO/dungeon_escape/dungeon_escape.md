# Dungeon Escape - Woche 16: Spieler-Methoden

## Aufgabe: Erweitere die Spieler-Klasse

Fuege der Spieler-Klasse aus Woche 15 drei neue Methoden hinzu.

### Anforderungen

1. Methode `nimmSchaden(int schaden)`
   - Zieht den Schaden von hp ab
   - Gibt aus: "NAME nimmt SCHADEN Schaden! HP: NEUE_HP"

2. Methode `heilen(int betrag)`
   - Erhoeht hp um den Betrag
   - Gibt aus: "NAME heilt BETRAG HP. HP: NEUE_HP"

3. Methode `istLebendig()` mit Rueckgabetyp boolean
   - Gibt true zurueck, wenn hp > 0
   - Gibt false zurueck, wenn hp <= 0

4. Teste alle Methoden in einer main-Methode

### Beispiel-Output

```
Spieler: Held (HP: 100)
Held nimmt 20 Schaden! HP: 80
Held heilt 10 HP. HP: 90
Ist der Held lebendig? true
Held nimmt 100 Schaden! HP: -10
Ist der Held lebendig? false
```
