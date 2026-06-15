# Exercise: Vollständig dokumentierte Bibliothek

Nimm die `Student`-Klasse aus Woche 18 (oder eine andere bekannte Klasse mit mindestens 3-4 Methoden) und dokumentiere sie vollständig mit JavaDoc.

## Anforderungen

1. **Klassen-JavaDoc**: Beschreibe, was die Klasse repräsentiert. Füge @author und @since hinzu.
2. **Jede Methode**: Beschreibung + @param für alle Parameter + @return falls vorhanden
3. **Attribute**: Optional mit Kurzbeschreibung

## Beispiel für die Student-Klasse

```java
/**
 * Repräsentiert einen Studenten mit Namen, Matrikelnummer und Note.
 *
 * @author Max Mustermann
 * @since 2024
 */
public class Student {
    /** Der vollständige Name des Studenten */
    private String name;
    /** Die eindeutige Matrikelnummer */
    private int matrikelnummer;
    /** Die aktuelle Note (1-5) */
    private int note;

    /**
     * Erzeugt einen neuen Studenten mit allen Daten.
     *
     * @param name          Der Name des Studenten
     * @param matrikelnummer Die eindeutige Matrikelnummer
     * @param note          Die Startnote
     */
    public Student(String name, int matrikelnummer, int note) {
        // ...
    }
}
```

## Generierung

Generiere am Ende die HTML-Dokumentation über die Kommandozeile oder die IDE und öffne sie im Browser.