# Kata 5: OCP with Specification Pattern

| Field | Value |
|-------|-------|
| Concepts | OCP, Specification pattern, interfaces, composition |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Build a flexible product filtering system using the Specification pattern (OCP-compliant).

Define:
- `Product` record with `String name`, `String category`, `double price`, `boolean inStock`
- `Specification` interface with `boolean isSatisfied(Product p)`

Implement:
- `CategorySpec` -- matches product category
- `PriceRangeSpec` -- matches products within a price range (min, max)
- `InStockSpec` -- matches products that are in stock
- `AndSpec` -- combines two specifications with logical AND
- `OrSpec` -- combines two specifications with logical OR

Create a `ProductFilter` that takes a `Specification` and returns matching products.

### Extension

Add a `NotSpec` for negation.
