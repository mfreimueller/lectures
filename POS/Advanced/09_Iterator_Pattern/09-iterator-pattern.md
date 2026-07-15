---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 09 - Iterator Pattern
## POS - Advanced

---

## Motivation

- Verschiedene Datenstrukturen (Liste, Set, Baum, Graph) sollen einheitlich durchlaufen werden
- Der Client soll nicht die interne Struktur kennen müssen
- Verschiedene Traversal-Arten (vorwärts, rückwärts, inorder, ...)

<div class="highlight-box">
"Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation." — GoF
</div>

---

## Java Iterable Interface

```java
public interface Iterable<T> {
    Iterator<T> iterator();

    // Default-Methoden (Java 8+)
    default void forEach(Consumer<? super T> action) { ... }
    default Spliterator<T> spliterator() { ... }
}
```

- iterator() ist die Factory-Methode für Iteratoren
- Ermöglicht die for-each-Schleife: `for (T item : iterable)`

---

## Java Iterator Interface

```java
public interface Iterator<E> {
    boolean hasNext();
    E next();

    default void remove() { throw new UnsupportedOperationException(); }
    default void forEachRemaining(Consumer<? super E> action) { ... }
}
```

Wichtig: next() darf nur aufgerufen werden, wenn hasNext() true ist!

---

## For-Each Schleife

```java
List<String> names = List.of("Alice", "Bob", "Charlie");

// For-Each (syntactic sugar)
for (String name : names) {
    System.out.println(name);
}

// Eigene Klasse for-each-fahig
Range range = new Range(1, 5);
for (int n : range) {
    System.out.println(n);  // 1, 2, 3, 4
}
```

---

## Custom Iterable — Range

```java
public class Range implements Iterable<Integer> {
    private final int start;
    private final int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int current = start;

            @Override
            public boolean hasNext() {
                return current < end;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                return current++;
            }
        };
    }
}
```

---

## Baum-Iterator — Inorder

```java
class BinaryTree<T> implements Iterable<T> {
    private Node root;

    private static class Node {
        T value;
        Node left, right;
    }

    @Override
    public Iterator<T> iterator() {
        return new InorderIterator(root);
    }
}
```

---

## InorderIterator — Implementierung

```java
class InorderIterator<T> implements Iterator<T> {
    private final Stack<Node> stack = new Stack<>();

    public InorderIterator(Node root) {
        pushLeft(root);
    }

    private void pushLeft(Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        Node node = stack.pop();
        pushLeft(node.right);
        return node.value;
    }
}
```

---

## Externer vs. Interner Iterator

| Extern (aktiv) | Intern (passiv) |
| --- | --- |
| Client steuert die Iteration | Framework steuert die Iteration |
| hasNext() / next() | forEach(Lambda) |
| Mehr Kontrolle (break, return) | Weniger Boilerplate |
| Entspricht GoF Iterator | Functional Programming Stil |

---

## Vorteile und Nachteile

| Vorteile | Nachteile |
| --- | --- |
| Einheitliche API für alle Datenstrukturen | Overhead durch Iterator-Objekt |
| Trennung von Struktur und Traversal | Nicht immer der effizienteste Weg |
| Mehrere Iteratoren gleichzeitig möglich | zustandsbehaftet (nicht thread-safe) |
| For-Each-Schleife als syntaktischer Zucker | remove() wird selten unterstutzt |

---

## Zusammenfassung

- Iterable + Iterator = standardisierte Iteration in Java
- For-Each funktioniert mit allem, was Iterable implementiert
- Custom Iterators für spezielle Traversal-Arten (Inorder, ...)
- Iterator ist eines der meistgenutzten GoF Patterns
