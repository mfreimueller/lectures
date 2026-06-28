# Kata 1: Password Hashing

| Field | Value |
|-------|-------|
| Concepts | BCrypt, security, password storage |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Write a Java program that:
1. Reads a password from the command line
2. Hashes it using BCrypt with cost factor 12
3. Prints the hash
4. Asks for the password again and verifies it against the hash
5. Prints "Password matches" or "Password does not match"

### Example Output

```
Enter password: mySecret123
Hash: $2a$12$LJ3m4ysnw5f6K7b8c9d0eO...
Enter password again: mySecret123
Password matches
```

### Extension

Add support for reading passwords from a file and hashing all of them.
