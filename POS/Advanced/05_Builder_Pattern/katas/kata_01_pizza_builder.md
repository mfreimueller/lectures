# Kata 1: Pizza Builder

| Feld | Wert |
|------|------|
| Konzepte | Builder Pattern, Fluent Interface, Immutability |
| Schwierigkeit | 2/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Erstellen Sie eine Klasse `Pizza` mit einem inneren `Builder`. Die Pizza soll folgende Eigenschaften haben:

- `size` (String, erforderlich, Werte: "small", "medium", "large")
- `cheese` (boolean, optional, default: false)
- `pepperoni` (boolean, optional, default: false)
- `mushrooms` (boolean, optional, default: false)
- `olives` (boolean, optional, default: false)

Der Builder soll:
1. Eine `build()`-Methode haben, die das Pizza-Objekt erstellt
2. Validierung in `build()`: size darf nicht null sein
3. Eine `toString()`-Methode in Pizza, die alle Eigenschaften ausgibt

### Beispiel-Output

```
Pizza{size='large', cheese=true, pepperoni=true, mushrooms=false, olives=true}
```

### Erweiterung

Fugen Sie ein weiteres Feld `extraToppings` (List<String>) hinzu, das uber Varargs im Builder gesetzt werden kann: `.addToppings("ham", "pineapple")`.
