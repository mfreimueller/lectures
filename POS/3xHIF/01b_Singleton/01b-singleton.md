---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 01b - Singleton
## POS - 3xHIF

---

## Agenda (1/2)

1. Singleton: Motivation
2. Singleton: What Is It?
3. Singleton: Classic Implementation
4. Singleton: Thread Safety

---

## Agenda (2/2)

5. Singleton: Enum Singleton
6. Singleton: Notable Examples
7. Discussion: Singleton - Anti-Pattern?
8. Summary

---

## Learning Objectives

- I can explain the Singleton pattern and implement it safely
- I can explain why naive lazy initialization isn't thread-safe
- I can implement a Singleton using an enum
- I can recognize Singleton usage in the JDK
- I can discuss when Singleton is a good fit, and when it isn't

---

## Singleton: Motivation

- Some things should only exist once: one configuration, one connection pool, one logger registry
- Passing that single instance around everywhere is tedious
- The Singleton pattern gives one well-known access point to the one instance

---

## Singleton: What Is It?

<div class="highlight-box"><p>Singleton: a creational design pattern that ensures a class has exactly one instance, and provides a global point of access to it.</p></div>

- Constructor is private -- nobody outside the class can create an instance
- The class manages its own single instance internally
- Access happens through a static method (or field)

---

## Singleton: Classic Implementation

```java
public class AppConfig {
    private static AppConfig instance;

    private AppConfig() { /* load config */ }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }
}

AppConfig config = AppConfig.getInstance();
```

<div class="highlight-box"><p>Lazy initialization: the instance is only created the first time it's needed.</p></div>

---

## Singleton: Thread Safety

```java
public class AppConfig {
    private static volatile AppConfig instance;

    private AppConfig() { }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }
}
```

<div class="highlight-box"><p>The naive lazy version can create two instances under concurrent access. Double-checked locking (with volatile) fixes that, at the cost of complexity.</p></div>

---

## Singleton: Enum Singleton

```java
public enum AppConfig {
    INSTANCE;

    private final Map<String, String> settings = new HashMap<>();

    public String get(String key) {
        return settings.get(key);
    }
}

AppConfig.INSTANCE.get("timeout");
```

<div class="highlight-box"><p>Java guarantees an enum constant is instantiated exactly once, even under concurrent access -- so this is thread-safe "for free" and considered the safest way to write a Singleton.</p></div>

---

## Singleton: Notable Examples

- `Runtime.getRuntime()` -- one Runtime instance per JVM
- `Desktop.getDesktop()` -- one Desktop integration per platform
- Spring beans with default scope `singleton` -- one instance per application context
- Loggers are often implemented as singletons (one registry per class/name)

---

## Discussion: Singleton - Anti-Pattern?

<div class="highlight-box">
<p>Singletons are sometimes called "global variables in disguise" because they introduce hidden, shared state that's hard to test and hard to replace. When is a Singleton a good fit, and when would dependency injection (passing the instance in) be the better choice?</p>
</div>

---

## Summary

<div class="highlight-box">
<ul>
<li>Singleton ensures a class has exactly one instance with one well-known access point</li>
<li>Constructor is private; the class manages its own instance internally</li>
<li>Naive lazy initialization isn't thread-safe -- double-checked locking (with volatile) fixes that</li>
<li>Enum singletons are thread-safe "for free" and considered the safest form</li>
<li>Notable JDK examples: Runtime.getRuntime(), Desktop.getDesktop(), Spring singleton-scoped beans</li>
<li>Singletons introduce hidden shared state -- weigh them against dependency injection</li>
</ul>
</div>
