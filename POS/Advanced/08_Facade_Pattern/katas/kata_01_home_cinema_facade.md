# Kata 1: Home Cinema Facade

| Feld | Wert |
|------|------|
| Konzepte | Facade, Subsystem, Vereinfachte API |
| Schwierigkeit | 2/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Erstelle ein Home-Entertainment-Subsystem mit folgenden Klassen:

1. `Amplifier` — on(), off(), setVolume(int), setSource(Player)
2. `DvdPlayer` — on(), off(), play(String movie), stop()
3. `BluRayPlayer` — on(), off(), play(String movie), stop()
4. `Projector` — on(), off(), setInput(Player)
5. `Screen` — up(), down()
6. `PopcornMachine` — on(), off(), makePopcorn()

Jede Methode gibt eine beschreibende System.out.println()-Ausgabe aus.

Implementiere eine `HomeCinemaFacade`, die folgende Methoden bereitstellt:
- `watchMovie(String movie, boolean isBluRay)` — schaltet alles ein, fahrt die Leinwand herunter, startet den Film
- `endMovie()` — stoppt den Film, schaltet alles aus, fahrt Leinwand hoch

### Beispiel-Output

```
HomeCinemaFacade homeCinema = new HomeCinemaFacade(amp, dvd, bluray, projector, screen, popcorn);
homeCinema.watchMovie("Inception", true);

// Output:
// Popcorn machine: ON
// Making popcorn...
// Screen: DOWN
// Projector: ON
// Projector input set to BluRay
// Amplifier: ON
// Amplifier volume set to 8
// Amplifier source set to BluRay
// BluRay: ON
// Playing movie: Inception
```

### Erweiterung

Füge eine Methode `setVolume(int level)` in der Facade hinzu, die die Lautstärke während des Films ändert. Stelle sicher, dass die Lautstärke nicht über 10 gesetzt werden kann.
