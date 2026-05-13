# Kata 2: Tree Iterator

| Feld | Wert |
|------|------|
| Konzepte | Iterator, Baum-Traversal, Stack |
| Schwierigkeit | 4/5 |
| Dauer | ca. 35 min |

## Aufgabenstellung

Implementieren Sie einen Binarbaum `BinaryTree<T>`, der `Iterable<T>` implementiert und einen Inorder-Iterator (Links, Wurzel, Rechts) bereitstellt.

1. Erstellen Sie eine verschachtelte Klasse `Node<T>` mit den Feldern value, left, right.
2. Implementieren Sie `BinaryTree<T>` mit Methoden:
   - `void insert(T value)` — fugt einen Wert sortiert ein (fur Comparable<T>)
   - `Iterator<T> iterator()` — gibt einen Inorder-Iterator zuruck
3. Der Iterator soll mit einem Stack arbeiten und eine Laufzeit von O(1) amortisiert pro next() haben.

### Beispiel-Output

```
BinaryTree<Integer> tree = new BinaryTree<>();
tree.insert(5);
tree.insert(3);
tree.insert(7);
tree.insert(2);
tree.insert(4);
tree.insert(6);
tree.insert(8);

for (int val : tree) {
    System.out.print(val + " ");
}
// Output: 2 3 4 5 6 7 8
```

### Erweiterung

Implementieren Sie einen Preorder-Iterator (Wurzel, Links, Rechts) und einen Postorder-Iterator (Links, Rechts, Wurzel). Machen Sie den Traversal-Modus uber einen Parameter im Konstruktor oder uber separate Methoden wahllbar (`Iterable<T> preOrder()`, `Iterable<T> postOrder()`).
