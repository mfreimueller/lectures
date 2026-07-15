---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 22 - Java Doc
## POS - 1xHIF

---

## Agenda (1/2)

1. Warum Dokumentation?
2. Kommentar-Arten in Java
3. JavaDoc für eine Methode
4. Der @param-Tag

---

## Agenda (2/3)

5. Der @return-Tag
6. Der @author-Tag
7. Der @see-Tag
8. JavaDoc für Klassen

---

## Agenda (3/3)

9. JavaDoc für Attribute
10. Vollständiges Beispiel
11. JavaDoc generieren
12. Best Practices

---

## Lernziele

- Ich kann JavaDoc-Kommentare für Klassen und Methoden schreiben
- Ich kann die wichtigsten JavaDoc-Tags (@param, @return) anwenden
- Ich kann JavaDoc-Dokumentation generieren

---

## Warum Dokumentation?

- Code wird einmal geschrieben, aber oft gelesen
- Andere Entwickler müssen deinen Code verstehen
- Du selbst vergisst nach Wochen, was dein Code tut

<div class="highlight-box"><p>Guter Code ist selbsterklärend — aber nicht immer!</p></div>

---

## Partnerdiskussion: Wann sind Kommentare hilfreich?

<div class="highlight-box">
<p>Findet eine Methode, die ihr oder euer Partner kürzlich geschrieben habt. Könntet ihr ohne Kommentare verstehen, was sie tut? Diskutiert: Wann ist ein Kommentar hilfreich, wann ist er nur Lärm? Was macht einen guten JavaDoc-Kommentar aus?</p>
</div>

---

## Kommentar-Arten in Java

```java
// Einzeiliger Kommentar

/* Mehrzeiliger
   Kommentar */

/**
 * JavaDoc-Kommentar:
 * Beschreibt die API für andere Entwickler.
 * Wird von javadoc-Tool zu HTML verarbeitet.
 */
```

JavaDoc-Kommentare beginnen mit `/**` und enden mit `*/`.

---

## JavaDoc für eine Methode

```java
/**
 * Berechnet die Summe aller Zahlen in einem Array.
 *
 * @param zahlen Ein Array von ganzen Zahlen
 * @return Die Summe aller Elemente
 */
public int summe(int[] zahlen) {
    int sum = 0;
    for (int z : zahlen) {
        sum += z;
    }
    return sum;
}
```

---

## Der @param-Tag

`@param` beschreibt einen Parameter der Methode.

```java
/**
 * Setzt das Alter einer Person.
 *
 * @param alter Das neue Alter (muss zwischen 0 und 150 liegen)
 */
public void setAlter(int alter) {
    if (alter > 0 && alter < 150) {
        this.alter = alter;
    }
}
```

Format: `@param parameterName Beschreibung`

---

## Der @return-Tag

`@return` beschreibt den Rückgabewert.

```java
/**
 * Prüft, ob die Person volljährig ist.
 *
 * @return true wenn alter >= 18, sonst false
 */
public boolean isVolljaehrig() {
    return alter >= 18;
}

/**
 * Gibt den Namen der Person zurück.
 *
 * @return Der Name als String
 */
public String getName() {
    return name;
}
```

---

## Der @author-Tag

`@author` gibt den Autor der Klasse an.

```java
/**
 * Repräsentiert einen Studenten mit Namen und Noten.
 *
 * @author Max Mustermann
 * @since 2024-03-15
 */
public class Student {
    // ...
}
```

`@since` gibt die Version oder das Datum an, seit der die Klasse existiert.

---

## Der @see-Tag

`@see` erstellt einen Verweis auf verwandte Klassen oder Methoden.

```java
/**
 * Fügt einen Studenten zu diesem Kurs hinzu.
 *
 * @param student Der hinzuzufügende Student
 * @return true wenn erfolgreich, false wenn Kurs voll
 * @see Student#addGrade(int)
 */
public boolean addStudent(Student student) {
    // ...
}
```

---

## JavaDoc für Klassen

```java
/**
 * Ein Bankkonto mit Ein- und Auszahlungsmöglichkeit.
 * Jedes Konto hat einen Kontoinhaber, einen Kontostand
 * und ein Überziehungslimit.
 *
 * @author Max Mustermann
 * @since 2024
 */
public class Bankkonto {
    private String kontoinhaber;
    private double kontostand;
    private double ueberzugsLimit;
    // ...
}
```

---

## JavaDoc für Attribute

Auch Attribute können JavaDoc erhalten (optional).

```java
/**
 * Der Name des Studenten. Darf nicht leer sein.
 */
private String name;

/**
 * Die Noten des Studenten (1-5).
 */
private int[] grades;
```

Oft reicht ein guter Variablenname — JavaDoc für Attribute ist nicht immer nötig.

---

## Vollständiges Beispiel — Klasse und Konstruktor (1/2)

```java
/**
 * Repräsentiert einen Studenten mit Notenverwaltung.
 *
 * @author Max Mustermann
 * @since 2024
 */
public class Student {
    private String name;
    /**
     * Erzeugt einen neuen Studenten.
     * @param name Der Name des Studenten
     * @param id   Die eindeutige ID
     */
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
```

---

## Vollständiges Beispiel — Methoden (2/2)

```java
    /**
     * Gibt den Namen des Studenten zurück.
     * @return Der Name als String
     */
    public String getName() {
        return name;
    }
}
```

---

## JavaDoc generieren

Über die Kommandozeile:

```bash
javadoc -d doc *.java
```

In der IDE (IntelliJ):

- Tools → Generate JavaDoc
- Oder: Rechte Maus auf Datei → Generate JavaDoc

Das Ergebnis ist eine HTML-Seite wie die offizielle Java-Dokumentation!

---

## Best Practices

- Jede öffentliche Methode sollte JavaDoc haben
- Beschreibe das **Was**, nicht das **Wie**
- @param und @return bei Methoden mit Parametern/Rückgabe
- @author und @since bei jeder Klasse
- Halte JavaDoc aktuell — alter Code ist schlimmer als kein Code

---

## Katas

<div class="highlight-box">
<p>Löst die folgenden Katas in eurer Entwicklungsumgebung:</p>
<ul>
<li><strong>Methode dokumentieren</strong> – Dokumentiert Methoden mit JavaDoc.</li>
<li><strong>Klasse dokumentieren</strong> – Dokumentiert Klassen mit JavaDoc.</li>
<li><strong>JavaDoc generieren</strong> – Generiert HTML-Dokumentation aus JavaDoc.</li>
</ul>
</div>

---

## Zusammenfassung

- JavaDoc = `/** ... */` für Dokumentation
- Wichtige Tags: @param, @return, @author, @since, @see
- JavaDoc wird zu HTML-Dokumentation generiert
- Gute Dokumentation hilft allen Entwicklern

---

## Übungen

- **Exercise:** Bibliothek vollständig dokumentieren

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Dokumentiere den gesamten Dungeon Crawler vollständig mit JavaDoc.</p>
</div>
