# K3: public/private

**Ziel:** Access-Modifier verstehen.

Mache die Attribute der `Person`-Klasse `private`. Füge Methoden `void setName(String name)`, `String getName()`, `void setAlter(int alter)` und `int getAlter()` hinzu. Zeige in `main`, dass man nicht mehr direkt auf die Attribute zugreifen kann (das führt zu einem Compiler-Fehler).

**Beispielablauf (Kommentar):**
```
// p.name = "Anna";  // Fehler! name ist private
p.setName("Anna");
System.out.println(p.getName()); // funktioniert
```
