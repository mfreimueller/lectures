---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 18 - Konstruktoren
## POS - 1xHIF

---

## Agenda (1/2)

1. Problem: Objekte nachträglich setzen
2. Was ist ein Konstruktor?
3. Default-Konstruktor
4. Parametrisierter Konstruktor

---

## Agenda (2/2)

5. Beispiel: Book-Klasse
6. Konstruktor-Überladung
7. this-Schlüsselwort

---

## Lernziele

- Ich kann den Zweck von Konstruktoren erklären
- Ich kann Konstruktoren mit Parametern definieren
- Ich kann mehrere Konstruktoren überladen

---

## Problem: Objekte nachträglich setzen

```java
Person p = new Person();
p.setName("Anna");
p.setAlter(20);
// Drei Schritte für ein Objekt — umständlich!
```

- Bisher: Objekt erzeugen, dann Werte einzeln setzen
- Besser: Werte direkt bei der Erzeugung übergeben
- Lösung: **Konstruktoren**

---

## Partnerdiskussion: Wozu Konstruktoren?

<div class="highlight-box">
<p>Warum ist es besser, Werte direkt bei der Objekterzeugung zu übergeben, statt sie nachträglich mit Settern zu setzen? Diskutiert: Was, wenn man vergisst, einen Wert zu setzen? Was ist sicherer?</p>
</div>

---

## Was ist ein Konstruktor?

- Ein Konstruktor ist eine spezielle Methode zur Initialisierung von Objekten
- Er heißt genau wie die Klasse
- Er hat **keinen** Rückgabetyp (auch nicht `void`)
- Er wird automatisch beim Erzeugen eines Objekts aufgerufen (`new`)

```java
public class Person {
    String name; int alter;
    public Person(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }
}
```

---

## Default-Konstruktor

- Der **Default-Konstruktor** hat keine Parameter
- Java erzeugt ihn automatisch, wenn kein anderer Konstruktor definiert ist
- Er setzt die Attribute auf ihre Default-Werte (0, null, false)

```java
public Person() {
}
Person p = new Person();
```

**Achtung:** Sobald du einen eigenen Konstruktor definierst, gibt es keinen Default-Konstruktor mehr — außer du schreibst ihn selbst!

---

## Parametrisierter Konstruktor

- Ein Konstruktor mit Parametern setzt die Attribute direkt bei der Erzeugung
- Das ist kürzer und sicherer als nachträgliches Setzen

```java
public class Person {
    private String name; private int alter;
    public Person(String name, int alter) {
        this.name = name; this.alter = alter;
    }
}
```

---

## Beispiel: Book-Klasse

```java
public class Book {
    private String title;
    private int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public void printInfo() {
        System.out.println("Titel: " + title);
        System.out.println("Seiten: " + pages);
    }

    public static void main(String[] args) {
        Book b = new Book("Java lernen", 350);
        b.printInfo();
    }
}
```

---

## Konstruktor-Überladung (1/2)

```java
public class Book {
    private String title;
    private int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public Book(String title) {
        this.title = title;
        this.pages = 0;
    }
}
```

---

## Konstruktor-Überladung (2/2)

- Eine Klasse kann mehrere Konstruktoren haben (Überladung)
- Sie müssen sich in der Parameterliste unterscheiden

```java
public Book() {
    this.title = "Unbekannt";
    this.pages = 0;
}
```

---

## this-Schlüsselwort

- `this` bezieht sich auf das aktuelle Objekt
- Es wird verwendet, um Attribut von Parameter zu unterscheiden

```java
public Book(String title, int pages) {
    // this.title = Attribut
    // title = Parameter
    this.title = title;
    this.pages = pages;
}
```

Ohne `this` würde `title = title` den Parameter mit sich selbst überschreiben!

---

## Konstruktor vs. Methode

| Konstruktor | Methode |
| --- | --- |
| Heißt wie die Klasse | Hat einen frei wählbaren Namen |
| Kein Rückgabetyp | Hat einen Rückgabetyp (oder void) |
| Wird nur bei `new` aufgerufen | Kann beliebig oft aufgerufen werden |
| Initialisiert das Objekt | Führt Aktionen aus / liefert Werte |

---

## Best Practices

- Verwende Konstruktoren, um Objekte vollständig zu initialisieren
- Vermeide zu viele Konstruktoren — ab 3-4 wird es unübersichtlich
- Verwende sprechende Parameternamen
- Nutze `this` für klare Unterscheidung
- Ein Konstruktor sollte keine komplexe Logik enthalten

---

## Zusammenfassung

<div class="highlight-box">
<ul>
<li>Konstruktor = spezielle Methode zur Objekt-Initialisierung</li>
<li>Heißt wie die Klasse, kein Rückgabetyp</li>
<li>Default- und parametrisierte Konstruktoren möglich</li>
<li>Überladung: mehrere Konstruktoren in einer Klasse</li>
<li><code>this</code> unterscheidet Attribut von Parameter</li>
</ul>
</div>

---

## Ausblick

<div class="highlight-box"><p>Nächste Woche vertiefen wir die Objektorientierung mit <code>this</code>, Settern und Gettern.</p></div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Baue Konstruktoren in den Dungeon Crawler ein.</p>
</div>
