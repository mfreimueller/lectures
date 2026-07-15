---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 04 - Strategy Pattern
## POS - Advanced

---

## Agenda (1/2)

1. Das Problem
2. Lösung: Strategy Pattern
3. Struktur des Strategy Patterns
4. Beispiel: Sortierstrategien
5. BubbleSort als Strategie

---

## Agenda (2/2)

6. Nutzung der Strategien
7. Beispiel: Payment-Strategien
8. Payment — Kontext
9. Vor- und Nachteile

---

## Lernziele

- Ich kann das Problem erklären, das das Strategy Pattern löst
- Ich kenne die Struktur des Strategy Patterns (Context, Strategy-Interface, konkrete Strategien)
- Ich kann das Strategy Pattern an einem eigenen Beispiel implementieren
- Ich kann Vor- und Nachteile des Strategy Patterns abwägen

---

## Das Problem

```java
public void sort(int[] data, String algorithm) {
    if (algorithm.equals("bubble")) {
        // Bubble Sort
    } else if (algorithm.equals("quick")) {
        // Quick Sort
    } else if (algorithm.equals("merge")) {
        // Merge Sort
    }
}
```

- Lange if/else-Ketten
- Schwer erweiterbar (neue Algorithmen)
- Verletzung des Open/Closed-Prinzips

---

## Lösung: Strategy Pattern

- Kapselt Algorithmen in eigenen Klassen
- Macht sie austauschbar (zur Laufzeit)
- Trennt die Nutzung von der Implementierung

<div class="highlight-box">
<p>"Define a family of algorithms, encapsulate each one, and make them interchangeable." — GoF</p>
</div>

---

## Struktur des Strategy Patterns

```java
// 1. Strategy Interface
public interface SortStrategy {
    void sort(int[] data);
}

// 2. Concrete Strategies
public class BubbleSortStrategy implements SortStrategy { ... }
public class QuickSortStrategy implements SortStrategy { ... }

// 3. Context
public class Sorter {
    private SortStrategy strategy;
    public void setStrategy(SortStrategy s) { this.strategy = s; }
    public void sort(int[] data) { strategy.sort(data); }
}
```

---

## Beispiel: Sortierstrategien

```java
public class Sorter {
    private SortStrategy strategy;
    private String strategyName;

    public Sorter(SortStrategy strategy, String name) {
        this.strategy = strategy;
        this.strategyName = name;
    }

    public void executeSort(int[] data) {
        System.out.println("Using: " + strategyName);
        int[] copy = data.clone();
        long start = System.nanoTime();
        strategy.sort(copy);
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1e6 + " ms");
    }
}
```

---

## BubbleSort als Strategie

```java
public class BubbleSortStrategy implements SortStrategy {
    public void sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
```

---

## Nutzung der Strategien

```java
int[] data = {5, 2, 9, 1, 5, 6};

Sorter sorter = new Sorter(new BubbleSortStrategy(), "Bubble Sort");
sorter.executeSort(data);

// Einfach wechseln:
sorter = new Sorter(new QuickSortStrategy(), "Quick Sort");
sorter.executeSort(data);
```

Keine if/else — einfach neue Strategie übergeben

---

## Beispiel: Payment-Strategien

```java
public interface PaymentStrategy {
    void pay(double amount);
    String getMethodName();
}

public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    public void pay(double amount) {
        System.out.println(cardNumber + ": " + amount + " EUR belastet");
    }
}

public class PayPalStrategy implements PaymentStrategy {
    private String email;
    public void pay(double amount) {
        System.out.println(email + ": " + amount + " EUR über PayPal");
    }
}
```

---

## Payment — Kontext

```java
public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy s) {
        this.paymentStrategy = s;
    }

    public void checkout() {
        double total = items.stream()
            .mapToDouble(Item::getPrice).sum();
        paymentStrategy.pay(total);
    }
}
```

---

## Vor- und Nachteile

| Vorteile | Nachteile |
| --- | --- |
| Open/Closed Principle | Mehr Klassen |
| Austauschbar zur Laufzeit | Client muss Strategien kennen |
| if/else eliminieren | Overhead bei wenigen Strategien |
| Einzeln testbar | Strategie-Objekte verwalten |

---

## Zusammenfassung

- Strategy = austauschbare Algorithmen (Behavioral Pattern)
- Drei Rollen: Strategy Interface, Concrete Strategies, Context
- Ermöglicht Erweiterung ohne Modifikation (OCP)
- Typische Anwendungen: Sortieren, Bezahlen, Validieren, Komprimieren
