---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 19 - this, Setter, Getter
## POS - 1xHIF

---

## Agenda (1/2)

1. Wiederholung: Konstruktoren
2. Das this-Schlüsselwort
3. this ist optional
4. Private Attribute

---

## Agenda (2/3)

5. Getter
6. Setter
7. Validierung im Setter
8. Validierungsbeispiele

---

## Agenda (3/3)

9. Kein Setter für schreibgeschützte Attribute
10. Kapselung (Encapsulation)
11. Übersicht: Setter/Getter-Muster

---

## Lernziele

- Ich kann das Schlüsselwort this verwenden
- Ich kann Setter und Getter zur Kapselung einsetzen
- Ich kann den Nutzen von Datenkapselung erklären

---

## Wiederholung: Konstruktoren

<div class="highlight-box"><p>Ein Konstruktor initialisiert ein neues Objekt.</p></div>

```java
public class Person {
    String name;
    public Person(String name) {
        name = name;   // Problem!
    }
}
```

Was ist das Problem? Der Parameter `name` verdeckt das Attribut.

---

## Partnerdiskussion: Warum Kapselung?

<div class="highlight-box">
<p>Warum sollten Attribute privat sein? Diskutiert: Was passiert, wenn jeder Code direkt die Daten eines Objekts ändern kann? Stellt euch ein Bankkonto vor — sollte jeder den Kontostand einfach auf 1.000.000 setzen können?</p>
</div>

---

## Das this-Schlüsselwort

`this` verweist auf das aktuelle Objekt.

```java
public class Person {
    String name;
    int alter;

    public Person(String name, int alter) {
        this.name = name;   // this.name = Attribut
        this.alter = alter; // name = Parameter
    }
}
```

Löst die Kollision zwischen Parameter und Attribut.

---

## this ist optional

Wenn keine Kollision besteht, kann `this` weggelassen werden.

```java
public class Person {
    String name;

    public Person(String n) {
        name = n;  // kein this nötig
    }

    public void print() {
        System.out.println(name); // this.name wäre auch ok
    }
}
```

Viele Teams verwenden `this` trotzdem konsequent zur Klarheit.

---

## Private Attribute

Attribute sollten `private` sein — nur innerhalb der Klasse sichtbar.

```java
public class Person {
    private String name;
    private int alter;
}
```

<div class="highlight-box"><p>Warum private? Kapselung (Encapsulation)!</p></div>

- Zugriff kontrollieren
- Interne Implementierung ändern ohne externe Effekte
- Ungültige Werte verhindern

---

## Getter

Getter geben den Wert eines privaten Attributs zurück.

```java
public class Person {
    private String name;
    private int alter;

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }
}
```

Konvention: `get` + Attributname mit Großbuchstaben.

---

## Setter

Setter setzen den Wert eines privaten Attributs.

```java
public class Person {
    private String name;
    private int alter;

    public void setName(String name) {
        this.name = name;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }
}
```

Konvention: `set` + Attributname mit Großbuchstaben.

---

## Validierung im Setter

Die Kontrolle: Setter können Werte prüfen und ablehnen.

```java
public void setAlter(int alter) {
    if (alter > 0 && alter < 150)
        this.alter = alter;
    else
        System.out.println("Ungültiges Alter: " + alter);
}
```

<div class="highlight-box"><p>Der Setter schützt das Objekt vor ungültigen Zuständen.</p></div>

---

## Validierungsbeispiele

```java
public void setName(String name) {
    if (name != null && !name.isEmpty()) {
        this.name = name;
    } else {
        System.out.println("Name darf nicht leer sein!");
    }
}

public void setPreis(double preis) {
    if (preis > 0) {
        this.preis = preis;
    } else {
        System.out.println("Preis muss positiv sein!");
    }
}
```

---

## Read-only Attribute — Person mit ID (1/2)

Nicht jedes Attribut braucht einen Setter.

```java
public class Person {
    private final int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
```

Die ID wird nur im Konstruktor gesetzt — kein Setter!

---

## Read-only — getName und setName (2/2)

```java
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

Der Name ist änderbar, die ID bleibt konstant.

---

## Kapselung (Encapsulation)

Daten und Methoden gehören zusammen — Zugriff von außen nur über definierte Schnittstellen.

<div class="highlight-box"><p>Prinzip: <strong>private</strong> Attribute, <strong>public</strong> Methoden</p></div>

- Änderungen am Inneren der Klasse möglich
- Zugriffe können protokolliert werden
- Gültigkeitsprüfungen sind zentral möglich

---

## Übersicht: Setter/Getter-Muster

```java
private int alter;

public int getAlter() {
    return alter;
}

public void setAlter(int alter) {
    if (alter > 0) {
        this.alter = alter;
    }
}

private boolean aktiv;
public boolean isAktiv() {
    return aktiv;
}
```

---

## Zusammenfassung

- `this` = Verweis auf aktuelles Objekt
- Setter/Getter = öffentliche Schnittstelle zu privaten Attributen
- Validierung in Settern = Schutz vor ungültigen Werten
- Kapselung = Kontrolle über den Zugriff auf Daten
- Nicht für jedes Attribut braucht es einen Setter

---

## Übungen

- **Exercise:** Bankkonto mit Setter/Getter
- **Große Übung:** Online-Shop (Artikel + Warenkorb)

---

## Jahresprojekt: Dungeon Crawler

<div class="highlight-box">
<p>Füge die Kapselung (private Attribute + Setter/Getter) zu deinen Dungeon Crawler-Klassen hinzu.</p>
</div>
