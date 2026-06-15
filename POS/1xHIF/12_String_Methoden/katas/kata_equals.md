# K3: equals vs. ==

Vergleiche zwei gleiche Strings mit `==` und mit `equals`. Gib beide Ergebnisse aus.

**Beispielausgabe:**

```
String a = "Hallo"
String b = "Hallo"
String c = new String("Hallo")

a == b: true
a == c: false
a.equals(b): true
a.equals(c): true
```

Erkläre den Unterschied im Kommentar:

```java
// == vergleicht die Speicheradresse (Referenz)
// equals vergleicht den Inhalt der Strings
```

### Hinweise

- Lege einen String mit `= "Hallo"` und einen mit `new String("Hallo")` an.
- Beide haben den gleichen Inhalt, aber unterschiedliche Referenzen.
