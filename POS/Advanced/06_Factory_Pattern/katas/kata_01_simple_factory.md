# Kata 1: Simple Factory - ShapeFactory

| Feld | Wert |
|------|------|
| Konzepte | Simple Factory, Interface, Polymorphie |
| Schwierigkeit | 1/5 |
| Dauer | ca. 25 min |

## Aufgabenstellung

Erstellen Sie ein Interface `Shape` mit der Methode `void draw()`. Implementieren Sie drei konkrete Klassen: `Circle`, `Square` und `Triangle`. Jede Klasse gibt in `draw()` eine entsprechende Form im Terminal aus.

Erstellen Sie eine `ShapeFactory` mit einer statischen Methode `Shape create(String type)`, die je nach ubergebenem Typ die passende Shape-Instanz erzeugt.

### Beispiel-Output

```
Shape c = ShapeFactory.create("circle");
c.draw();  // Output: Drawing a circle (O)

Shape s = ShapeFactory.create("square");
s.draw();  // Output: Drawing a square

Shape t = ShapeFactory.create("triangle");
t.draw();  // Output: Drawing a triangle
```

### Erweiterung

Fugen Sie einen neuen Shape-Typ `Rectangle` hinzu, ohne den Client-Code zu andern. Verwenden Sie eine Map<String, Supplier<Shape>> anstelle von switch/case in der Factory.
