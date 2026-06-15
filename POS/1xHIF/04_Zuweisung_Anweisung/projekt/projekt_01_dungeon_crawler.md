# Jahresprojekt — Dungeon Crawler: Kampfrunde

Der Spieler hat jetzt Lebenspunkte, die sich im Kampf ändern. Simuliere eine Kampfrunde mit zusammengesetzten Zuweisungen.

### Aufgaben

1. Starte mit 100 HP (Lebenspunkte).
2. Der Spieler erhält 25 Schaden (HP -= 25).
3. Der Spieler trinkt einen Heiltrank (HP += 15).
4. Der Spieler findet einen Schatz, der die Angriffskraft erhöht (angriff *= 1.2). Start-Angriffskraft: 15.
5. Gib nach jeder Aktion den aktuellen Wert aus.
6. Verwende ausschließlich zusammengesetzte Zuweisungen.

### Beispiel-Output

```
=== Kampfrunde ===
Start HP: 100
Start Angriff: 15
Nach Schaden (-25): 75 HP
Nach Heiltrank (+15): 90 HP
Nach Schatz (*1.2): 18 Angriff
```

### Erweiterung

Füge eine Zählvariable für die Anzahl der Kampfrunden hinzu. Erhöhe sie bei jedem Schritt.
