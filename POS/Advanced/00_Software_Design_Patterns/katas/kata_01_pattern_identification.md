# Kata 1: Pattern Identification

| Feld | Wert |
|------|------|
| Konzepte | GoF Kategorien, Pattern Recognition |
| Schwierigkeit | 2/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Gegeben sind die folgenden Code-Snippets. Ordnen Sie jedes Snippet einer GoF-Pattern-Kategorie zu (Creational, Structural oder Behavioral) und begrunden Sie Ihre Entscheidung.

**Snippet A:**
```java
public class Logger {
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }
}
```

**Snippet B:**
```java
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
```

**Snippet C:**
```java
public class FileReader {
    private BufferedSource source;
    public FileReader(String path) {
        this.source = new BufferedSource(new FileInputStream(path));
    }
    public String readLine() { return source.readLine(); }
}
```

**Snippet D:**
```java
public abstract class Pizza {
    public abstract void prepare();
    public abstract void bake();
}
public class MargheritaPizza extends Pizza { ... }
public class PepperoniPizza extends Pizza { ... }
public class PizzaFactory {
    public Pizza createPizza(String type) {
        if (type.equals("margherita")) return new MargheritaPizza();
        if (type.equals("pepperoni")) return new PepperoniPizza();
        throw new IllegalArgumentException();
    }
}
```

### Beispiel-Output

```
Snippet A: Creational (Singleton)
Snippet B: Behavioral (Iterator)
Snippet C: Structural (Facade)
Snippet D: Creational (Factory Method)
```

### Erweiterung

Fugen Sie zu jeder Kategorie ein weiteres selbst gewahltes Beispiel hinzu und implementieren Sie einen kurzen Code-Ausschnitt.
