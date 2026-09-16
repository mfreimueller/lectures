---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 17 - OO Intro
## POS - 1xHIF

---

## Agenda (1/2)

1. Bisher: prozedural
2. Objektorientierung: Idee
3. Klasse = Bauplan
4. Objekt = Exemplar

---

## Agenda (2/3)

5. Attribute
6. Methoden
7. Beispiel: Person-Klasse
8. Objekte erzeugen (instanziieren)

---

## Agenda (3/3)

9. public vs. private
10. Attribut vs. Parameter vs. lokale Variable
11. Vorteile von OO

---

## Lernziele

- Ich kann das Konzept der objektorientierten Programmierung erklären
- Ich kann Klassen und Objekte unterscheiden
- Ich kann einfache Klassen mit Attributen und Methoden definieren

---

## Bisher: prozedural

- Bisher haben wir **prozedural** programmiert
- Daten (Variablen) und Verhalten (Methoden) sind getrennt
- Wir rufen Funktionen auf, die Daten verarbeiten
- Nachteil: Zusammenhängende Daten liegen oft verteilt

```java
String name = "Anna";
int alter = 20;
System.out.println(name + " ist " + alter);
```

---

## Partneraktivität: Objekte im Alltag

<div class="highlight-box">
<p>Beschreibt ein reales Objekt (z. B. «ein Auto» oder «eine Schülerin»). Euer Partner listet die Attribute (Farbe, Geschwindigkeit / Name, Note) und Methoden (fahren, bremsen / lernen, Prüfung ablegen) auf, die es als Java-Klasse hätte. Vergleicht eure Ergebnisse.</p>
</div>

---

## Objektorientierung: Idee

- Objekte kapseln **Daten** (Attribute) und **Verhalten** (Methoden)
- Eine Person hat einen Namen und ein Alter — und kann sich vorstellen
- Ein Auto hat eine Marke und eine Geschwindigkeit — und kann beschleunigen
- Daten und die dazugehörigen Operationen bleiben zusammen

---

## Klasse = Bauplan

- Eine **Klasse** ist der Bauplan für Objekte
- Sie definiert, welche Attribute und Methoden ein Objekt hat
- Vergleich: Ein Bauplan für ein Haus — das Haus selbst ist das Objekt

```java
public class Person {
    String name;
    int alter;
    void vorstellen() { ... }
}
```

---

## Objekt = Exemplar

- Ein **Objekt** ist ein konkretes Exemplar einer Klasse
- Erzeugt wird es mit `new`: `new Person()`
- Jedes Objekt hat seine eigenen Werte für die Attribute
- Von einer Klasse können beliebig viele Objekte erzeugt werden

```java
Person p1 = new Person();
Person p2 = new Person();
// p1 und p2 sind unabhängige Objekte
```

---

## Attribute

- **Attribute** (auch Felder oder Fields) speichern den Zustand eines Objekts
- Sie werden in der Klasse deklariert (außerhalb von Methoden)
- Jedes Objekt hat seine eigenen Attribute mit eigenen Werten

```java
public class Person {
    String name;   // Attribut
    int alter;     // Attribut
}
```

Beide Attribute haben einen **Default-Wert**: `null` für String, `0` für int.

---

## Methoden

- **Methoden** definieren das Verhalten eines Objekts
- Sie können auf die Attribute des Objekts zugreifen
- Sie werden auf einem konkreten Objekt aufgerufen

```java
public class Person {
    String name;
    void vorstellen() {
        System.out.println("Hallo, ich bin " + name);
    }
}
```

---

## Beispiel: Person-Klasse

```java
public class Person {
    String name;
    int alter;

    void vorstellen() {
        System.out.println("Hallo, ich bin " + name +
                " und bin " + alter + " Jahre alt.");
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Anna";
        p.alter = 20;
        p.vorstellen();
    }
}
```

---

## Objekte erzeugen (instanziieren)

- Mit `new Klassenname()` wird ein neues Objekt erzeugt
- Das Objekt wird einer Variable zugewiesen
- Über die Variable kann man auf Attribute und Methoden zugreifen

```java
Person p1 = new Person();
p1.name = "Anna";
p1.vorstellen();
Person p2 = new Person();
p2.name = "Max";
p2.vorstellen();
```

Zwei unabhängige Personen mit eigenen Namen!

---

## public vs. private

- `public` — von überall zugreifbar (auch von außerhalb der Klasse)
- `private` — nur innerhalb der eigenen Klasse zugreifbar
- Private Attribute schützen die Daten vor direktem Zugriff von außen
- **Kapselung:** Daten sind privat, Methoden (Getter/Setter) sind öffentlich

```java
public class Person {
    private String name;
    public void setName(String name) {
        this.name = name;
    }
}
```

---

## Attribut vs. Parameter vs. lokale Variable

| Typ | Gültigkeitsbereich | Beispiel |
| --- | --- | --- |
| Attribut | In der ganzen Klasse | `String name;` |
| Parameter | In der Methode | `void setName(String name)` |
| Lokale Variable | Im aktuellen Block { } | `int x = 5;` |

<div class="highlight-box">
<p><strong>Merke:</strong> Das <code>this</code>-Schlüsselwort unterscheidet Attribut von Parameter.</p>
</div>

---

## Vorteile von OO

- **Kapselung:** Daten und Methoden bleiben zusammen
- **Wiederverwendbarkeit:** Klassen können mehrfach verwendet werden
- **Wartbarkeit:** Änderungen betreffen nur eine Klasse
- **Nähe zur Realität:** Wir modellieren reale Dinge als Objekte
- **Erweiterbarkeit:** Neue Klassen können existierende erweitern (später: Vererbung)

---

## Zusammenfassung

<div class="highlight-box">
<ul>
<li><strong>Klasse</strong> = Bauplan, <strong>Objekt</strong> = konkretes Exemplar</li>
<li><strong>Attribute</strong> speichern den Zustand eines Objekts</li>
<li><strong>Methoden</strong> definieren das Verhalten</li>
<li>Objekterzeugung mit <code>new</code></li>
<li>Kapselung: <code>private</code> Attribute, <code>public</code> Methoden</li>
</ul>
</div>

---

## Ausblick

<div class="highlight-box"><p>Nächste Woche lernen wir Konstruktoren kennen — damit können wir Objekte mit Anfangswerten erstellen.</p></div>

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Baue den Dungeon Crawler objektorientiert um.</p>
</div>
