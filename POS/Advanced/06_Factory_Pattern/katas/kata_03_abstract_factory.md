# Kata 3: Abstract Factory - UI Component Factory

| Feld | Wert |
|------|------|
| Konzepte | Abstract Factory, Produktfamilien, plattformspezifische Implementierung |
| Schwierigkeit | 4/5 |
| Dauer | ca. 35 min |

## Aufgabenstellung

Implementiere eine Abstract Factory für plattformspezifische UI-Komponenten.

1. Erstelle zwei Produkt-Interfaces:
   - `Button` mit Methode `void render()` und `void onClick()`
   - `TextField` mit Methode `void render()` und `void setText(String text)`

2. Erstelle ein Abstract Factory Interface `UIFactory` mit Methoden:
   - `Button createButton()`
   - `TextField createTextField()`

3. Implementiere drei konkrete Fabriken:
   - `WindowsFactory` — produziert WindowsButton und WindowsTextField
   - `MacFactory` — produziert MacButton und MacTextField
   - `LinuxFactory` — produziert LinuxButton und LinuxTextField

4. Jede konkrete Komponente gibt in `render()` eine plattformspezifische Ausgabe aus.

### Beispiel-Output

```
UIFactory factory = new WindowsFactory();
Button btn = factory.createButton();
btn.render();
// Output: [Windows] Rendering a button with Windows style

TextField tf = factory.createTextField();
tf.render();
// Output: [Windows] Rendering a text field with Windows style
```

### Erweiterung

Füge ein neues Produkt `Checkbox` zur Produktfamilie hinzu. Aktualisiere alle konkreten Fabriken. Beobachte, wie viele Klassen geändert werden müssen — dies illustriert die "Erweiterbarkeit"-Problematik von Abstract Factories.
