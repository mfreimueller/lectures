# Kata 2: Array umkehren

| Feld | Wert |
|------|------|
| Konzepte | Neues Array erstellen, Index-Berechnung |
| Schwierigkeit | 3/5 |
| Dauer | ca. 15 min |

### Aufgabenstellung

Implementiere eine statische Methode `int[] umkehren(int[] original)` in der Klasse `ArrayUtils`, die ein neues Array mit den Elementen in umgekehrter Reihenfolge zuruckgibt.

Das ursprungliche Array darf nicht verandert werden!

### Beispiel-Output

```
int[] original = {1, 2, 3, 4, 5};
int[] umgekehrt = ArrayUtils.umkehren(original);

// original bleibt: {1, 2, 3, 4, 5}
// umgekehrt: {5, 4, 3, 2, 1}

for (int i = 0; i < umgekehrt.length; i++) {
    System.out.print(umgekehrt[i] + " ");
}
// Ausgabe: 5 4 3 2 1
```
