# Kata 1: Classic Singleton

| Feld | Wert |
|------|------|
| Konzepte | Singleton, Thread-Safety, Bill Pugh, Enum |
| Schwierigkeit | 2/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Implementieren Sie ein thread-sicheres Singleton auf drei verschiedene Arten. Alle Varianten sollen dieselbe Funktionalitat bieten: einen Zähler, der bei jedem Aufruf von `incrementAndGet()` erhoht wird.

1. **synchronized Singleton** — Klassisches Singleton mit synchronized getInstance()
2. **Bill Pugh Singleton** — Holder-Pattern mit privater statischer innerer Klasse
3. **Enum Singleton** — Singleton als Enum-Konstante

Testen Sie alle drei Varianten, indem Sie in einer main()-Methode die getInstance()-Methode mehrfach aufrufen und uberprufen, dass immer dieselbe Instanz zuruckgegeben wird (== Vergleich).

### Beispiel-Output

```
Synchronized Singleton:
1: 1
2: 2
3: 3
Same instance: true

Bill Pugh Singleton:
1: 1
2: 2
Same instance: true

Enum Singleton:
1: 1
2: 2
Same instance: true
```

### Erweiterung

Fugen Sie eine `reset()`-Methode hinzu und testen Sie das Singleton-Verhalten in einem Multi-Threading-Szenario mit 10 Threads.
