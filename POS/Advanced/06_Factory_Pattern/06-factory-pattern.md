---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 06 - Factory Pattern
## POS - Advanced

---

## Warum Factory Patterns?

- Objekt-Erzeugung soll nicht über das ganze Projekt verstreut sein
- Austausch konkreter Implementierungen ohne Client-Änderungen
- Zentrale Kontrolle über den Erstellungsprozess

<div class="highlight-box">
"Program to an interface, not an implementation." — GoF
</div>

---

## Simple Factory — Konzept

- Eine Klasse kapselt die Erzeugungslogik
- Statische Methode liefert das passende Produkt
- Kein GoF-Pattern, aber haufig verwendet

```java
public class ShapeFactory {
    public static Shape create(String type) {
        return switch (type) {
            case "circle" -> new Circle();
            case "square" -> new Square();
            case "triangle" -> new Triangle();
            default -> throw new IllegalArgumentException();
        };
    }
}
```

---

## Simple Factory — Beispiel

```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a square");
    }
}
```

---

## Factory Method — Konzept

- Definiert ein Interface für die Objekterzeugung
- Subklassen entscheiden, welche konkrete Klasse instanziiert wird
- GoF Creational Pattern

```java
abstract class DocumentCreator {
    public abstract Document createDocument();

    public void openDocument() {
        Document doc = createDocument();
        doc.open();
    }
}
```

---

## Factory Method — DocumentFactory

```java
class PdfCreator extends DocumentCreator {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class WordCreator extends DocumentCreator {
    public Document createDocument() {
        return new WordDocument();
    }
}

class HtmlCreator extends DocumentCreator {
    public Document createDocument() {
        return new HtmlDocument();
    }
}
```

---

## Abstract Factory — Konzept

- Erzeugt Familien verwandter Produkte
- Besteht aus mehreren Factory Methods
- Concrete Factories implementieren das Interface

```java
interface UIFactory {
    Button createButton();
    TextField createTextField();
    Checkbox createCheckbox();
}
```

---

## Abstract Factory — UI Beispiel

```java
class WindowsFactory implements UIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public TextField createTextField() {
        return new WindowsTextField();
    }
}

class MacFactory implements UIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public TextField createTextField() {
        return new MacTextField();
    }
}
```

---

## Vergleich der drei Varianten

| Kriterium | Simple Factory | Factory Method | Abstract Factory |
| --- | --- | --- | --- |
| Komplexitat | Niedrig | Mittel | Hoch |
| Produkte | Einzelne Produkte | Einzelne Produkte | Produktfamilien |
| Erweiterbarkeit | Switch/Case erweitern | Neue Creator-Subklasse | Neue Factory-Implementierung |
| GoF | Nein (Idiom) | Ja | Ja |

---

## Zusammenfassung

- Simple Factory: zentrale Switch-Logik für Objekterzeugung
- Factory Method: Subklassen entscheiden über konkrete Produkte
- Abstract Factory: zusammengehorige Produktfamilien
- Nachstes Mal: Singleton Pattern
