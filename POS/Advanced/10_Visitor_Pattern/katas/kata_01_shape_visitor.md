# Kata 1: Shape Visitor

| Feld | Wert |
|------|------|
| Konzepte | Visitor Interface, accept-Methode, Double Dispatch |
| Schwierigkeit | 2/5 |
| Dauer | ca. 35 min |

### Aufgabenstellung

Implementiere das Visitor Pattern für eine Shape-Hierarchie.

1. Definiere das Interface `ShapeVisitor` mit Methoden für:
   - `visitCircle(Circle c)`
   - `visitRectangle(Rectangle r)`

2. Definiere das Interface `Shape` mit der Methode `void accept(ShapeVisitor visitor)`.

3. Implementiere die konkreten Elemente:
   - `Circle` mit Attribut `radius`
   - `Rectangle` mit Attributen `width, height`

4. Implementiere zwei konkrete Visitor:
   - `AreaCalculator` — berechnet die Gesamtflache aller Shapes
   - `PerimeterCalculator` — berechnet den Gesamtumfang aller Shapes

5. Teste in einer `main`-Methode mit mindestens 3 Shapes.

### Beispiel-Output

```
Shapes: Circle(r=5.0), Rectangle(3.0x4.0), Circle(r=2.5)
Total area: 106.31
Total perimeter: 63.41
```

### Erweiterung

Füge einen dritten Elementtyp `Triangle` (mit Seiten a, b, c) hinzu und erweitere beide Visitor entsprechend. Beobachte, welche Code-Stellen geändert werden müssen.
