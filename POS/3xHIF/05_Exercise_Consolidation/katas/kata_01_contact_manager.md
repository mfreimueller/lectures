# Kata 1: Contact Manager

| Field | Value |
|-------|-------|
| Concepts | Records, Optional, streams, var |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

Build a contact management system:

1. Define a `Contact` record with `name`, `email`, `phone` (all Strings, phone can be blank)
2. Create a `ContactRepository` class with:
   - `addContact(Contact)` method
   - `findByName(String name)` returning `Optional<Contact>`
   - `findByEmail(String email)` returning `Optional<Contact>`
   - `allContacts()` returning List of all contacts
   - `search(String query)` that matches name or email (case-insensitive contains)
3. In main, create several contacts, search for them, and print results

### Example Output

```
All contacts:
  Alice (alice@example.com)
  Bob (bob@example.com)

Search results for "alice":
  Alice (alice@example.com)

Search results for "nonexistent":
  No contacts found
```

### Extension

Add a `groupByFirstLetter()` method that returns a `Map<Character, List<Contact>>` grouping contacts by the first letter of their name.
