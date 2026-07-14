---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 08 - Facade Pattern
## POS - Advanced

---

## Problem: Komplexe Subsysteme

```java
// Client muss viele Klassen kennen und richtig initialisieren
Amplifier amp = new Amplifier();
Tuner tuner = new Tuner();
DvdPlayer dvd = new DvdPlayer();
Projector projector = new Projector();
Screen screen = new Screen();
PopcornMachine popcorn = new PopcornMachine();

amp.on();
amp.setSource(dvd);
amp.setVolume(5);
projector.on();
projector.setInput(dvd);
screen.down();
// ...und so weiter
```

Der Client ist eng an die Details des Subsystems gekoppelt.

---

## Facade Pattern — Konzept

- Bietet eine vereinfachte Schnittstelle zu einem komplexen Subsystem
- Kapselt die Interaktion mehrerer Klassen
- Reduziert Abhängigkeiten (loose coupling)

<div class="highlight-box">
"Provide a unified interface to a set of interfaces in a subsystem." — GoF
</div>

---

## Facade vs Adapter

| Facade | Adapter |
| --- | --- |
| Vereinfacht ein Subsystem | Passt ein Interface an ein anderes an |
| Neue, einfachere API | Übersetzt Aufrufe in bestehende API |
| Arbeitet mit vielen Klassen | Wrapper für eine Klasse |
| Subsystem bleibt nutzbar | Altes Interface wird verborgen |

---

## Home Cinema — Subsystem-Klassen

```java
class Amplifier {
    void on() { }
    void off() { }
    void setSource(DvdPlayer dvd) { }
    void setVolume(int level) { }
}

class DvdPlayer {
    void on() { }
    void play(String movie) { }
    void stop() { }
    void off() { }
}

class Screen {
    void up() { }
    void down() { }
}
```

---

## HomeCinemaFacade

```java
public class HomeCinemaFacade {
    private Amplifier amp;
    private DvdPlayer dvd;
    private Screen screen;
    private Projector projector;

    public HomeCinemaFacade(Amplifier amp, DvdPlayer dvd,
                            Screen screen, Projector projector) {
        this.amp = amp;
        this.dvd = dvd;
        this.screen = screen;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        screen.down();
        projector.on();
        amp.on();
        amp.setVolume(8);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        dvd.stop();
        dvd.off();
        amp.off();
        projector.off();
        screen.up();
    }
}
```

---

## Database Facade — Idee

```java
// Vorher (viel Boilerplate)
Connection conn = DriverManager.getConnection(url, user, pass);
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
while (rs.next()) { /* ... */ }
rs.close(); stmt.close(); conn.close();

// Nachher (mit Facade)
Database db = new Database(url, user, pass);
List<User> users = db.query("SELECT * FROM users",
    rs -> new User(rs.getInt("id"), rs.getString("name")));
```

---

## Vor- und Nachteile

| Vorteile | Nachteile |
| --- | --- |
| Vereinfachte Client-API | Facade kann zum God Object werden |
| Geringere Kopplung | Zusatzliche Abstraktionsebene |
| Subsystem unabhängig wartbar | Kann Performance-Overhead bedeuten |
| Optional für Clients | Facade muss bei Subsystem-Änderungen aktualisiert werden |

---

## Facade im realen Einsatz

- Spring Data JPA: Repository-Facade über EntityManager
- SLF4J: Facade über verschiedene Logging-Frameworks
- Java Naming and Directory Interface (JNDI)
- REST-Controller als Facade für Service-Schicht

---

## Zusammenfassung

- Facade vereinfacht komplexe Subsysteme
- Reduziert Kopplung zwischen Client und Subsystem
- Facade != Adapter (vereinfachen vs. anpassen)
- Nachstes Mal: Iterator Pattern
