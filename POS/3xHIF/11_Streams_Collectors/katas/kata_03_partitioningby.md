# Kata 3: PartitioningBy with Downstream

| Field | Value |
|-------|-------|
| Concepts | partitioningBy, downstream collectors, mapping |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Given a `Product` record with `name`, `category`, and `price`, write:

1. `Map<Boolean, List<Product>> partitionByPrice(List<Product> products, double threshold)` -- partition into cheap vs expensive
2. `Map<Boolean, Long> countByPriceRange(List<Product> products, double threshold)` -- count in each partition
3. `Map<Boolean, List<String>> namesByPriceRange(List<Product> products, double threshold)` -- product names in each partition
4. `Map<String, Map<Boolean, List<Product>>> categoryPricePartition(List<Product> products, double threshold)` -- group by category, then partition each category by price

```java
record Product(String name, String category, double price) {}
```

### Example Output

```java
partitionByPrice(50.0): {
  true=[Product("Mouse","Peripherals",25.0)],
  false=[Product("Monitor","Peripherals",200.0), Product("Keyboard","Peripherals",80.0)]
}
```

### Extension

For each partition, compute the average price using `Collectors.averagingDouble()`.
