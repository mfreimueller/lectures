---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 03 - Optimistic Locking
## POS - Advanced

---

## Agenda

1. Das Lost Update Problem
2. Optimistic vs Pessimistic Locking
3. Version Field Pattern
4. Compare-and-Swap (CAS)
5. CAS in Java
6. Retry-Logik
7. JPA @Version Annotation
8. JPA — Beispiel

---

## Lernziele

- Ich kann das Lost-Update-Problem erklären
- Ich kenne den Unterschied zwischen Optimistic und Pessimistic Locking
- Ich kann das Version-Field-Pattern und Compare-and-Swap anwenden
- Ich kann Optimistic Locking mit JPA @Version umsetzen

---

## Das Lost Update Problem

```java
// Benutzer A liest (Version 1)
Product p1 = repo.findById(1); // stock=10

// Benutzer B liest (Version 1)
Product p2 = repo.findById(1); // stock=10

// A schreibt: stock = 10 - 2 = 8
repo.update(p1.setStock(8));

// B schreibt: stock = 10 - 5 = 5  (Lost Update!)
repo.update(p2.setStock(5));
```

Änderung von A wurde überschrieben! Endstand: 5 statt 8 oder 3

---

## Optimistic vs Pessimistic Locking

| Kriterium | Optimistic | Pessimistic |
| --- | --- | --- |
| Annahme | Wenig Konflikte | Viele Konflikte |
| Sperrmechanismus | Version prufen beim Schreiben | Ressource gleich sperren |
| Durchsatz | Hoch bei wenig Konflikten | Niedriger (Wartezeiten) |
| Deadlocks | Nicht möglich | möglich |
| Typisch für | Webanwendungen, Leselastig | Batch-Verarbeitung, Schreibintensiv |

---

## Version Field Pattern

- Jede Tabelle bekommt eine zusätzliche Versionsspalte
- Version wird bei jedem Update inkrementiert
- Beim Update wird gepruft: Ist die Version noch aktuell?

```sql
CREATE TABLE product (
    id    INT PRIMARY KEY,
    name  VARCHAR(100),
    stock INT,
    version INT DEFAULT 1
);
```

---

## Compare-and-Swap (CAS)

```sql
UPDATE product
SET stock = 8, version = version + 1
WHERE id = 1 AND version = 1;
-- Wenn 0 Zeilen betroffen: Konflikt!
```

- Der WHERE-Teil pruft die alte Version
- Nur wenn die Version noch aktuell ist, wird aktualisiert
- Die AND-Operation ist atomar in der Datenbank

---

## CAS in Java

```java
public boolean update(Product expected, Product updated) {
    Product current = store.get(expected.getId());
    if (current.getVersion() != expected.getVersion()) {
        throw new OptimisticLockException(
            "Version conflict: expected " +
            expected.getVersion() +
            " but was " + current.getVersion());
    }
    updated.setVersion(expected.getVersion() + 1);
    store.put(expected.getId(), updated);
    return true;
}
```

---

## Retry-Logik

```java
public void reduceStock(int productId, int quantity) {
    for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
        try {
            Product p = repo.findById(productId);
            p.setStock(p.getStock() - quantity);
            repo.update(p, /* alte Version */);
            return; // Erfolg
        } catch (OptimisticLockException e) {
            if (attempt == MAX_RETRIES) throw e;
            // Erneut versuchen (mit aktualisierten Daten)
        }
    }
}
```

---

## JPA @Version Annotation

```java
@Entity
public class Product {
    @Id
    private Long id;

    private String name;
    private int stock;

    @Version
    private int version;
}
```

- JPA erhöht die Version automatisch bei jedem Update
- Bei Konflikt: `OptimisticLockException` (oder `StaleObjectStateException`)
- Funktioniert mit `EntityManager.merge()` und `flush()`

---

## JPA — Beispiel

```java
@Service
public class ProductService {
    @Transactional
    public void buyProduct(Long productId, int quantity) {
        Product p = repo.findById(productId)
            .orElseThrow();
        p.setStock(p.getStock() - quantity);
        // JPA erhöht @Version beim flush()
    }
}

// Bei Konflikt:
try { productService.buyProduct(1L, 2); }
catch (OptimisticLockException e) {
    // Retry mit frisch geladenem Produkt
}
```

---

## Zusammenfassung

- Optimistic Locking lost das Lost Update Problem ohne langfristige Sperren
- Version-Felder und CAS ermoglichen Konflikterkennung beim Schreiben
- Retry-Logik behandelt OptimisticLockExceptions
- JPA @Version automatisiert das Version-Management
- Geeignet für Systeme mit wenigen Schreibkonflikten
