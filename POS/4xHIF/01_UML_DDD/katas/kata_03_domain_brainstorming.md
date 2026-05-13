# Kata 3: Domain Brainstorming

| Field | Value |
|-------|-------|
| Concepts | project scoping, domain evaluation |
| Difficulty | 1/5 |
| Duration | approx. 20 min |

### Task

In your team, brainstorm **3 potential domains** for the year-long project. For each domain, document:

1. **Domain name** — e.g., "Gym Management System"
2. **Core entities** — list at least 6 entities (e.g., Member, Trainer, Course, Booking, Payment, Schedule)
3. **Business logic** — what operations go beyond simple CRUD? (e.g., conflict detection for bookings)
4. **Search/filter requirements** — what lists need paging, sorting, filtering?
5. **Potential for REST API** — what resources would be exposed?
6. **Potential for Thymeleaf UI** — what screens would be needed?

### Example

```
Domain: Restaurant Reservation System
Entities: Restaurant, Table, Customer, Reservation, MenuItem, Order, Payment
Business logic: Table availability check, double-booking prevention
Search: Find restaurants by cuisine/location, available tables by date/time
REST: /restaurants, /tables, /reservations, /menu-items
Thymeleaf: Dashboard, reservation form, admin panel
```

### Extension

For your top candidate, sketch a rough ER diagram with at least 6 tables and all relationships.
