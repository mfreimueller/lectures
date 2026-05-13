# Kata 3: GitHub Classroom Setup

| Field | Value |
|-------|-------|
| Concepts | Git, GitHub, remote collaboration |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

1. Accept the GitHub Classroom invitation link (provided in class)
2. Create or join your team (2-3 members)
3. Clone the generated repository to your local machine
4. Copy your Spring Boot project into the repository
5. Add a `.gitignore` with entries for `target/`, `*.iml`, `.idea/`, `*.class`
6. Commit and push the initial project:
   ```bash
   git add .
   git commit -m "Initial Spring Boot project setup"
   git push
   ```
7. Verify all team members can:
   - Clone the repository
   - Open the project in IntelliJ
   - Make a small change (e.g., modify the greeting message)
   - Commit and push
   - Pull each other's changes

### Extension

Set up a branch protection rule for `main` that requires at least one review before merging.
