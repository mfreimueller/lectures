# Katas - Week 10: Service_Layer

## K1: Basic Service
**Concepts:** @Service, constructor injection, CRUD delegation
**Task:** Create a `LibraryService` with methods for registering members, adding books, listing loans, and returning books. Each method delegates to the appropriate repository.
**Duration:** 20 min

## K2: Transactional Service
**Concept:** @Transactional, composite operations, rollback
**Task:** Add a `checkOutBook(memberId, bookId)` method that: (1) validates the book is available, (2) creates a Loan, (3) marks the book as unavailable. Use @Transactional so that a failure at any point rolls back the entire operation.
**Duration:** 25 min
