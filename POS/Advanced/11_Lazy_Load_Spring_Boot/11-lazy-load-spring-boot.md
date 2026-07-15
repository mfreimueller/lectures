---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 11 - Lazy Load (Spring Boot)
## POS - Advanced

---

## Agenda (1/2)

1. Motivation
2. Motivation - Beispiel
3. Lazy vs. Eager Loading
4. Lazy vs. Eager - Wann was?
5. @Lazy in Spring
6. Globale Lazy-Initialisierung
7. @Lazy auf @Configuration

---

## Agenda (2/2)

8. @Lazy auf @Bean
9. JPA: FetchType.LAZY (1/2)
10. JPA: FetchType.LAZY (2/2)
11. Hibernate Proxies
12. Das N+1 Problem
13. N+1 Problem - Erkennung
14. Lösung: JOIN FETCH
15. Lösung: @EntityGraph

---

## Lernziele

- Ich kenne den Unterschied zwischen Lazy und Eager Loading
- Ich kann @Lazy in Spring auf Beans und Konfigurationen anwenden
- Ich kann FetchType.LAZY in JPA einsetzen und Hibernate-Proxies erklären
- Ich kann das N+1-Problem erkennen
- Ich kann das N+1-Problem mit JOIN FETCH oder @EntityGraph lösen

---

## Motivation

- Eine Spring-Anwendung kann Dutzende oder Hunderte von Beans haben
- Nicht alle Beans werden beim Start benötigt
- Manche Beans sind teuer in der Initialisierung (Datenbankverbindungen, externe APIs, Caches)
- Lazy Loading = Initialisierung nur bei Bedarf

---

## Motivation - Beispiel

```java
@Component
public class ExpensiveService {
    public ExpensiveService() {
        System.out.println("ExpensiveService initialisiert!");
        // z.B. Datenbankverbindung, externer API-Client
    }
}
```

- Bei Eager Loading: Initialisierung beim Start der Anwendung
- Bei Lazy Loading: Initialisierung erst beim ersten Zugriff
- Vorteil: Schnellerer Start, weniger Ressourcenverbrauch

---

## Lazy vs. Eager Loading

Eager Loading (Default)

Alle Beans werden beim Context-Start initialisiert
Fruhzeitige Fehlererkennung
Langsamerer Start, hoherer Speicherverbrauch

Lazy Loading

Initialisierung erst bei Bedarf
Schnellerer Start, weniger Speicher
Spatere Fehlererkennung (erst bei Zugriff)

---

## Lazy vs. Eager - Wann was?

<div class="highlight-box">
<p>Faustregel: Kritische Infrastruktur (Datenquellen, Sicherheit) eager, optionale Dienste lazy.</p>
</div>

- Eager: Datenbank-Connection-Pool, Sicherheitsfilter, zentrale Dienste
- Lazy: Selten genutzte Services, Report-Generierung, Batch-Jobs

---

## @Lazy in Spring

```java
@Component
@Lazy
public class LazyService {
    public LazyService() {
        System.out.println("LazyService: erst jetzt initialisiert!");
    }
}

@Component
public class EagerService {
    public EagerService() {
        System.out.println("EagerService: sofort initialisiert!");
    }
}
```

Output beim Start: "EagerService: sofort initialisiert!"

Output beim ersten Zugriff auf LazyService: "LazyService: erst jetzt initialisiert!"

---

## Globale Lazy-Initialisierung

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setLazyInitialization(true);
        app.run(args);
    }
}
```

Oder in application.properties:

```properties
spring.main.lazy-initialization=true
```

Überschreibbar pro Bean mit `@Lazy(false)`

---

## @Lazy auf @Configuration

```java
@Configuration
@Lazy
public class AppConfig {

    @Bean
    public ServiceA serviceA() {
        return new ServiceA();
    }

    @Bean
    public ServiceB serviceB() {
        return new ServiceB();
    }
}
```

- Alle Beans in dieser @Configuration-Klasse werden lazy
- Einzelne Beans können mit `@Lazy(false)` überschrieben werden

---

## @Lazy auf @Bean

```java
@Configuration
public class AppConfig {

    @Bean
    @Lazy
    public ExpensiveService expensiveService() {
        return new ExpensiveService();
    }

    @Bean
    public SimpleService simpleService() {
        return new SimpleService();
    }
}
```

---

## JPA: FetchType.LAZY (1/2)

```java
@Entity
public class Order {
    @Id
    private Long id;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> items;
}

@Entity
public class OrderItem {
    @Id
    private Long id;
    private String product;
    private int quantity;
}
```

---

## JPA: FetchType.LAZY (2/2)

- FetchType.LAZY: items werden erst bei Zugriff geladen
- FetchType.EAGER: items werden sofort per JOIN geladen

---

## Hibernate Proxies

- Bei FetchType.LAZY erzeugt Hibernate einen Proxy
- Der Proxy ist eine Unterklasse der Entitat (z.B. `Order$HibernateProxy$...`)
- Beim ersten Methodenaufruf auf dem Proxy wird die SQL-Query ausgeführt

```java
Order order = em.find(Order.class, 1L);
// order.getItems() ist ein Proxy (noch nicht geladen)

List<OrderItem> items = order.getItems();
// Beim Zugriff: Hibernate führt SELECT ... FROM order_item WHERE order_id = 1 aus
```

---

## Das N+1 Problem

```java
List<Order> orders = em.createQuery(
    "SELECT o FROM Order o", Order.class)
    .getResultList();
// 1 Query: SELECT * FROM orders

for (Order o : orders) {
    System.out.println(o.getItems().size());
    // N Queries: SELECT * FROM order_item WHERE order_id = ?
}
// Gesamt: 1 + N Queries!
```

<div class="highlight-box">
<p>N+1 = 1 Query für die Haupt-Entitaten + N Queries für jede Assoziation</p>
</div>

---

## N+1 Problem - Erkennung

- Aktivieren von Hibernate SQL Logging:

```properties
logging.level.org.hibernate.SQL=DEBUG
spring.jpa.show-sql=true
```

- Oder mit Datenbank-Monitoring-Tools
- Oder mit Hibernate Statistics (hibernate.generate_statistics=true)

---

## Lösung: JOIN FETCH

```java
// Statt:
// SELECT o FROM Order o

// Mit JOIN FETCH:
List<Order> orders = em.createQuery(
    "SELECT DISTINCT o FROM Order o JOIN FETCH o.items", Order.class)
    .getResultList();
// 1 Query: SELECT o.*, i.* FROM orders o JOIN order_item i ON o.id = i.order_id
```

- Ladt alle Daten in einer einzigen Query
- FetchType.LAZY wird für diese Query überschrieben

---

## Lösung: @EntityGraph

```java
@Entity
@NamedEntityGraph(name = "Order.withItems",
    attributeNodes = @NamedAttributeNode("items"))
public class Order { ... }

// Im Repository:
public interface OrderRepository extends JpaRepository<Order, Long> {

    @EntityGraph("Order.withItems")
    List<Order> findAllWithItems();
}
```

- Deklarativer Ansatz statt JPQL
- Flexibler: mehrere EntityGraphs pro Entitat möglich

---

## Zusammenfassung

- @Lazy: Verzögerte Bean-Initialisierung in Spring
- Global: spring.main.lazy-initialization=true
- FetchType.LAZY: Assoziationen werden erst bei Bedarf geladen
- Hibernate verwendet Proxys für Lazy Loading
- N+1 Problem: zu viele Queries durch Lazy Loading
- Lösungen: JOIN FETCH, EntityGraph, Batch-Fetching
