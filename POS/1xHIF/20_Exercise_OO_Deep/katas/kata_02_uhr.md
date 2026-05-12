# Kata 2: Uhr mit tick()

| Feld | Wert |
|------|------|
| Konzepte | Objektzustand andern, Uberlauf-Behandlung |
| Schwierigkeit | 2/5 |
| Dauer | ca. 15 min |

### Aufgabenstellung

Erstelle eine Klasse `Uhr`, die eine digitale Uhr modelliert.

- Attribute: `stunden` (int), `minuten` (int)
- Konstruktor: `Uhr(int stunden, int minuten)`
- Methode `tick()`: Erhoht die Minute um 1. Wenn Minuten == 60, setze Minuten = 0 und erhohe Stunden um 1. Wenn Stunden == 24, setze Stunden = 0.
- Methode `toString()`: Gib die Uhrzeit im Format "HH:MM" aus (immer zweistellig, also 09:05 statt 9:5).

### Beispiel-Output

```
Uhr u = new Uhr(9, 59);
System.out.println(u); // 09:59
u.tick();
System.out.println(u); // 10:00
u.tick();
System.out.println(u); // 10:01
```

Tipp: Verwende `String.format("%02d", wert)` fur die zweistellige Ausgabe.
