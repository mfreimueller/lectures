# K3: JavaDoc generieren

Nimm die Klasse aus K1 oder K2 (oder eine eigene Klasse) und generiere die HTML-Dokumentation.

## Via Kommandozeile

```bash
javadoc -d doc Rechner.java
```

Öffne die generierte Datei `doc/index.html` im Browser.

## Via IDE (IntelliJ)

1. Tools → Generate JavaDoc...
2. Wähle die Datei(en) aus
3. Wähle ein Ausgabeverzeichnis
4. Klicke OK
5. Öffne die index.html im Browser

Betrachte die generierte HTML-Seite. Vergleiche sie mit der offiziellen Java-Dokumentation (z. B. https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html).