# Kata 2: DDD Event Storming

| Field | Value |
|-------|-------|
| Concepts | domain events, bounded context, ubiquitous language |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

Run a simplified event storming session for a **library** domain. Use sticky notes (physical or digital like Miro) to identify:

1. **Domain Events** (orange) — things that happen in the domain
   - e.g., `BookCheckedOut`, `BookReturned`, `MemberRegistered`
2. **Commands** (blue) — actions that trigger events
   - e.g., `CheckOutBook`, `RegisterMember`, `PayFine`
3. **Aggregates** (yellow) — clusters of domain objects
   - e.g., `Book`, `Member`, `Loan`
4. **External Systems** (pink) — actors outside the system
   - e.g., `PaymentGateway`, `EmailService`
5. **Bounded Contexts** (draw boundaries around related events)

Arrange the sticky notes in chronological flow and draw context boundaries around related groups.

### Extension

Identify at least one event that belongs to a different bounded context (e.g., `InventoryUpdated` in a warehouse context).
