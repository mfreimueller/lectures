---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 07 - Singleton Pattern
## POS - Advanced

---

## Agenda

1. Was ist ein Singleton?
2. Klassisches Singleton
3. Thread-Safety mit synchronized
4. Double-Checked Locking
5. Bill Pugh — Holder Pattern
6. Enum Singleton
7. Vor- und Nachteile
8. Wann Singleton, wann nicht?

---

## Lernziele

- Ich kann ein klassisches Singleton implementieren
- Ich kenne die Thread-Safety-Probleme naiver Singleton-Implementierungen
- Ich kann Double-Checked Locking, Bill-Pugh-Holder und Enum-Singleton unterscheiden
- Ich kann einschätzen, wann ein Singleton angebracht ist und wann nicht

---

## Was ist ein Singleton?

- Stellt sicher, dass eine Klasse genau eine Instanz hat
- Bietet einen globalen Zugriffspunkt auf diese Instanz
- GoF Creational Pattern

<div class="highlight-box">
"Ensure a class only has one instance, and provide a global point of access to it." — GoF
</div>

---

## Klassisches Singleton

```java
public class ClassicSingleton {
    private static ClassicSingleton instance;

    private ClassicSingleton() {}

    public static ClassicSingleton getInstance() {
        if (instance == null) {
            instance = new ClassicSingleton();
        }
        return instance;
    }
}
```

Problem: Nicht thread-safe — zwei Threads könnten gleichzeitig new aufrufen

---

## Thread-Safety mit synchronized

```java
public synchronized static
        ClassicSingleton getInstance() {
    if (instance == null) {
        instance = new ClassicSingleton();
    }
    return instance;
}
```

- Einfach, aber teuer: jeder Aufruf wird synchronisiert
- Synchronisation nur beim ersten Aufruf nötig

---

## Double-Checked Locking

```java
private static volatile Singleton instance;

public static Singleton getInstance() {
    if (instance == null) {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
    }
    return instance;
}
```

- Erst prüfen, dann synchronisieren
- `volatile` verhindert das "halb konstruierte Objekt"-Problem

---

## Bill Pugh — Holder Pattern

```java
public class Singleton {
    private Singleton() {}

    private static class Holder {
        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

- Nutzt den Java Classloader-Mechanismus
- Holder wird erst bei getInstance() geladen
- Garantiert thread-safe ohne synchronized

---

## Enum Singleton

```java
public enum Singleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Singleton is working!");
    }
}

// Usage:
Singleton.INSTANCE.doSomething();
```

- Von Haus aus serialisierbar und reflection-sicher
- Die eleganteste Lösung laut Effective Java

---

## Vor- und Nachteile

| Vorteile | Nachteile |
| --- | --- |
| Eine Instanz garantiert | Versteckte Abhängigkeiten (globaler Zustand) |
| Lazy Initialization möglich | Testbarkeit erschwert ( schwer zu mocken) |
| Speicherschonend | Verletzt Single Responsibility Principle |
| Thread-Safety implementierbar | Oft überflüssig ( DI ersetzt Singleton) |

---

## Wann Singleton, wann nicht?

<div class="highlight-box">
<b>Geeignet für:</b> Logger, Config-Manager, Connection-Pools, Caches
</div>

<div class="highlight-box">
<b>Nicht geeignet für:</b> Services mit vielen Abhängigkeiten, Stateful Components, wo Testbarkeit wichtig ist
</div>

---

## Zusammenfassung

- Singleton = genau eine Instanz + globaler Zugriff
- Vier Varianten: synchronized, DCL, Bill Pugh, Enum
- Enum Singleton ist die sicherste Variante
