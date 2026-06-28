# Exercise: Build a REST API from Spec (Pre-WMC Dry Run)

**Type:** Implement from Specification (Type 2) — Students build a complete REST API from scratch based on a detailed specification.

**Domain:** Inventory Management System (Product, Warehouse, StockMovement)

**Assigned:** Week 31 (after Dynamic API)
**Due:** Week 32 (overlaps with WMC kickoff)

---

## Objective

This is your **final practice exercise** before starting the 6-week WMC project. You will build a complete REST API from scratch based on the specification below. No starter code is provided — you design and implement everything yourself.

This exercise tests whether you can:
- Design a data model with relationships
- Implement a layered architecture
- Build REST endpoints with proper HTTP semantics
- Handle validation and error responses
- Write tests for your service layer

---

## Domain: Inventory Management System

A company manages inventory across multiple warehouses. They need a REST API to track products, warehouses, and stock movements.

### Entities

**Product**
- `id` (Long, auto-generated)
- `name` (String, required, 2-100 chars)
- `sku` (String, required, unique, format: `XXX-XXXXX`, e.g. `ELC-12345`)
- `category` (String, required)
- `price` (Double, required, must be > 0)

**Warehouse**
- `id` (Long, auto-generated)
- `name` (String, required, 2-100 chars)
- `location` (String, required)
- `capacity` (Integer, required, must be > 0)

**StockMovement**
- `id` (Long, auto-generated)
- `productId` (Long, required, must reference existing product)
- `warehouseId` (Long, required, must reference existing warehouse)
- `quantity` (Integer, required, non-zero: positive = incoming, negative = outgoing)
- `timestamp` (Instant, auto-generated on creation)
- `type` (String, derived: `"IN"` if quantity > 0, `"OUT"` if quantity < 0)

### Business Rules

1. A product's SKU must be unique.
2. A stock movement cannot be deleted or modified after creation.
3. A product cannot be deleted if it has stock movements.
4. A warehouse cannot be deleted if it has stock movements.
5. The current stock level for a product in a warehouse is the sum of all its stock movements.
6. Stock level cannot go negative (outgoing movement is rejected if it would result in negative stock).

---

## API Specification

### Products

| Method | Path | Description | Request Body | Response |
|--------|------|-------------|-------------|----------|
| GET | `/api/products` | List all products | — | `200` List\<ProductResponse\> |
| GET | `/api/products/{id}` | Get product by ID | — | `200` ProductResponse, `404` |
| POST | `/api/products` | Create product | CreateProductRequest | `201` ProductResponse, `400` |
| PUT | `/api/products/{id}` | Update product | UpdateProductRequest | `200` ProductResponse, `400`, `404` |
| DELETE | `/api/products/{id}` | Delete product | — | `204`, `404`, `409` (has movements) |

### Warehouses

| Method | Path | Description | Request Body | Response |
|--------|------|-------------|-------------|----------|
| GET | `/api/warehouses` | List all warehouses | — | `200` List\<WarehouseResponse\> |
| GET | `/api/warehouses/{id}` | Get warehouse by ID | — | `200` WarehouseResponse, `404` |
| POST | `/api/warehouses` | Create warehouse | CreateWarehouseRequest | `201` WarehouseResponse, `400` |
| PUT | `/api/warehouses/{id}` | Update warehouse | UpdateWarehouseRequest | `200` WarehouseResponse, `400`, `404` |
| DELETE | `/api/warehouses/{id}` | Delete warehouse | — | `204`, `404`, `409` (has movements) |

### Stock Movements

| Method | Path | Description | Request Body | Response |
|--------|------|-------------|-------------|----------|
| GET | `/api/stock-movements` | List all movements | — | `200` List\<StockMovementResponse\> |
| GET | `/api/stock-movements/{id}` | Get movement by ID | — | `200` StockMovementResponse, `404` |
| POST | `/api/stock-movements` | Create movement | CreateStockMovementRequest | `201` StockMovementResponse, `400`, `404` |
| GET | `/api/stock-movements/product/{productId}/warehouse/{warehouseId}` | Current stock level | — | `200` { "productId": ..., "warehouseId": ..., "stockLevel": N } |

### Error Response Format

All error responses use this format:
```json
{
  "status": 400,
  "message": "Validation failed",
  "details": ["Field 'name' must not be blank", "Field 'price' must be greater than 0"]
}
```

---

## Technical Requirements

1. **Architecture**: Layered (Controller → Service → Repository)
2. **HTTP**: Jakarta Servlets + embedded Tomcat (no Spring, no Javalin)
3. **JSON**: Jackson `ObjectMapper` for serialization/deserialization
4. **Persistence**: Choose one:
   - In-memory (ConcurrentHashMap) — acceptable for this exercise
   - JDBC with PostgreSQL — bonus points
   - JPA with Hibernate — bonus points
5. **Validation**: Custom annotation-based or manual validation
6. **Tests**: JUnit 5 tests for the service layer (minimum)
7. **Code quality**: SOLID principles, clean naming, no code duplication

---

## Deliverables

1. **Working REST API** — All endpoints implemented and tested
2. **Tests** — Service layer tests with JUnit 5
3. **README** — Explains your architecture, how to run it, and any design decisions
4. **PR** — Submit as a PR for peer code review

---

## Evaluation Criteria

| Criterion | Points |
|-----------|--------|
| All endpoints implemented correctly | 30% |
| Proper HTTP semantics (status codes, methods) | 15% |
| Layered architecture | 15% |
| Validation and error handling | 15% |
| Business rules enforced | 10% |
| Tests for service layer | 10% |
| Code quality + peer code review | 5% |

---

## Hints

- Start with the **data model** — define your entities and repositories first
- Then build the **service layer** — implement business rules and validation
- Finally, build the **controllers** — map HTTP requests to service calls
- Test as you go — write service tests before building controllers
- Use the Front Controller pattern from the katas as a reference
