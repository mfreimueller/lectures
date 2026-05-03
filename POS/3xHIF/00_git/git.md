# LECTURE NOTES: Advanced Git Practices - Professional Version Control

## Learning Objectives
By the end of this lecture, students will be able to:
- [ ] Write clear, professional commit messages following conventional commits standards
- [ ] Diagnose and resolve common merge conflicts using Git's conflict resolution workflow
- [ ] Use `git rebase` appropriately versus `git merge` in team workflows
- [ ] Apply advanced troubleshooting techniques for problematic repository states

---

## Pre-Lecture Preparation
**Required Reading**: Students should have completed basic Git training (add, commit, push, pull, branch, checkout)  
**Prerequisite Knowledge**: Understanding of version control concepts, familiarity with terminal/command line interface  
**Pre-Class Assignment**: Create a practice environment by cloning a repository and creating two branches to simulate merge scenarios

---

## Key Vocabulary & Definitions

| Term | Definition | Context/Example |
|------|------------|-----------------|
| Conventional Commits | Standardized commit message format (type: description) | `feat:` for new features, `fix:` for bug fixes |
| Merge Conflict | Git cannot automatically merge changes in the same file section | Two developers edit the same line of code differently |
| Interactive Rebase (`git rebase -i`) | Rewrites history by combining/squashing commits before merging | Cleaning up commit history before PR/MR |
| Cherry-pick | Apply specific commit from one branch to another without merging entire branch | Applying a critical fix from develop to main |
| Detached HEAD | Working on a commit instead of a branch (no branch pointer) | After checking out a specific commit hash |

---

## Lecture Content

### Section 1: Why Commit Messages Matter in Professional Development (8 minutes)

**Key Points**: 
- Bad commit messages create technical debt and make debugging nearly impossible
- Good commit messages serve as documentation for future developers (including yourself!)
- Conventional commits enable automated changelog generation and semantic versioning
- Git history becomes a project narrative that explains "why" not just "what"

**Teaching Notes**: Start by showing a real example of terrible commit messages: `asdf`, `fixed stuff`, `update`. Then show the difference with proper conventional commits. Emphasize this is what employers expect to see in their portfolios and GitHub profiles after graduation.

[https://medium.com/@iambonitheuri/the-art-of-writing-meaningful-git-commit-messages-a56887a4cb49]

**Example/Case Study**: 
Show two Git histories side-by-side:
- **Bad History**: 50+ commits with messages like "fix", "wip", "again" - impossible to understand project evolution
- **Good History**: Clear `feat:` `fix:` `docs:` prefixes, references to issue numbers (#123), scope descriptions

**Teaching Tip**: Have students look at their own Git history from previous projects and identify what they would change.

---

### Section 2: Conventional Commits Standard (10 minutes)

**Key Points**: 
- **Format**: `<type>(<scope>): <description>`
- **Types**: `feat`, `fix`, `docs`, `style`, `refactor`, `test`, `chore`
- **When to write**: Before committing, not as an afterthought
- **Body text**: Explain WHY changes were made, not just WHAT

**Teaching Notes**: Use a whiteboard or slide showing the full conventional commits specification. Emphasize that Austrian/European tech companies often follow this standard (especially in larger organizations). Show examples of good vs. bad commit messages for common HTL project scenarios.

| Type | Description | Example Message |
|------|-------------|-----------------|
| `feat` | New feature | `feat(auth): add OAuth2 login support` |
| `fix` | Bug fix | `fix(api): resolve null pointer in user endpoint` |
| `docs` | Documentation changes | `docs(readme): update installation instructions` |
| `refactor` | Code restructuring without changing behavior | `refactor(utils): extract date formatting to separate module` |

**Example/Case Study**: 
Present a real PR description from an open-source project and show how the commit messages follow conventional commits. Ask students: "What information do you get from this that would help you understand the code later?"

---

### Section 3: Understanding & Solving Merge Conflicts (15 minutes)

**Key Points**: 
- **When conflicts occur**: Same file, same lines changed by different branches
- **Conflict markers**: `<<<<<<<`, `=======`, `>>>>>>>` indicate conflict zones
- **Resolution workflow**: Understand → Choose/Combine → Stage → Commit
- **Prevention strategies**: Smaller commits, frequent merges, communication

**Teaching Notes**: This is the most hands-on section. If possible, have students work on their own laptops with a pre-configured conflict scenario. Walk through each step slowly. Common mistakes: not staging resolved files before committing, forgetting to open the conflicted file.

**Step-by-Step Demo Script**:
```bash
# 1. See what's in conflict
git status

# 2. Open and examine the conflict markers
code app.js  # or use your preferred editor

<<<<<<< HEAD
console.log("old version");
=======
console.log("new version from branch");
>>>>>>> feature-branch

# 3. Choose/combine the changes you want to keep
# (manually edit, delete markers)

# 4. Stage resolved files
git add app.js

# 5. Complete the merge commit
git commit -m "Merge: resolve conflict in app.js"
```

**Example/Case Study**: 
Show a real-world scenario where a merge conflict caused production issues because it was resolved incorrectly (e.g., keeping old code by accident). Discuss how team communication could have prevented this.

---

### Section 4: Rebase vs. Merge - When to Use Each (10 minutes)

**Key Points**: 
- **`git merge`**: Creates a merge commit, preserves history exactly as it happened
- **`git rebase`**: Rewrites commits onto new base, creates linear history
- **Rule of thumb**: Never rebase public/shared branches; use for feature branch cleanup before PR/MR
- **Interactive rebase (`git rebase -i`)**: Squash, reorder, edit commits

**Teaching Notes**: This is conceptually difficult—use analogies. Merge = "we both worked in parallel and now we're combining." Rebase = "I'm taking my work and putting it on top of your latest changes as if I started from there." Show visual diagrams of commit history before/after each operation.

| Scenario | Recommended Approach | Why |
|----------|---------------------|-----|
| Personal feature branch | `rebase` to keep history clean | Makes PR easier to review |
| Shared team branch | `merge` only | Prevents rewriting others' work |
| Before submitting MR/PR | Interactive rebase + squash | Cleaner commit history for maintainers |
| Hotfix on production branch | Cherry-pick specific commits | Targeted fix without full merge |

**Example/Case Study**: 
Show a GitHub PR where the contributor used interactive rebase to clean up 15 messy commits into 3 meaningful ones before merging. Contrast this with a PR that had all the intermediate "wip" and "test" commits visible in history.

---

### Section 5: Advanced Troubleshooting Scenarios (7 minutes)

**Key Points**: 
- **Detached HEAD state**: How to return safely to your branch
- **Amending last commit**: `git commit --amend` for fixing mistakes
- **Undoing recent changes**: `git reset`, `git revert` when appropriate
- **Stashing work in progress**: `git stash` before switching branches

**Teaching Notes**: Keep this practical. Students will encounter these situations and need to know the commands but more importantly understand WHEN to use each one. Emphasize that mistakes happen—and Git has tools to recover from them safely.

**Quick Reference Commands**:
```bash
# Return from detached HEAD to your branch
git checkout <branch-name>

# Add current changes to previous commit (before pushing)
git add . && git commit --amend -m "Updated message"

# Undo last commit but keep changes staged
git reset HEAD~1

# Create a temporary stash before switching branches
git stash push -m "WIP on feature"
git stash pop  # Reapply when ready
```

**Example/Case Study**: 
Present a scenario: A student made the wrong commit, pushed to remote, and now wants to fix it. Walk through options (amend + force push vs. revert) and discuss which is appropriate based on whether others have pulled those commits.

---

## Visual Aid Recommendations

1. **Commit Message Template Poster**: Conventional commits format with all types and examples - Purpose: Reference poster students can print for their workspace
2. **Merge Conflict Resolution Flowchart**: Step-by-step decision tree for resolving conflicts - Purpose: Quick reference during actual conflict resolution
3. **Rebase vs. Merge Visual Diagrams**: Before/after commit history graphs showing both approaches - Purpose: Helps visualize the difference conceptually

---

## Student Activities & Discussion

### In-Class Activity 1: "4xHIF website" (10 minutes)
**Time Required**: ?? minutes  
**Instructions**: Use repo, create GitHub classroom assignment.

**Learning Goal**: Hands-on practice with `git rebase -i` and writing professional commit messages

### Discussion Questions:
1. **Professional Impact**: "When you're job hunting, how will your Git history reflect on you? What would a hiring manager look for?"

2. **Team Communication**: "What communication practices between developers could reduce merge conflicts before they happen?"

3. **Ethical Consideration**: "If you discover someone else's bad commit message in the team repository, is it okay to rewrite their commits? When should you not touch other people's history?"

---

## Summary & Key Takeaways

- **Core Concept 1**: Commit messages are documentation that future developers will read—write them as if explaining your work to a colleague
- **Core Concept 2**: Merge conflicts are normal in team development; the key is resolving them correctly and learning from causes
- **Connection Points**: Professional Git practices directly impact employability, code quality, and team collaboration success

---

## Assessment Materials

### Quick Quiz (5 questions):
1. What does `git commit --amend` do?

2. Which merge strategy should you use for a shared branch that multiple developers are working on: `merge` or `rebase`? Why?

3. True or False: Conflict markers (`<<<<<<<`, `=======`, `>>>>>>>`) indicate code sections that Git couldn't automatically resolve.

4. What is the correct format for a conventional commit message adding new authentication functionality?

5. When would you use `git stash` instead of committing your work?

**Answer Key**: 
1. Combines current staged changes with the previous commit, allowing you to modify the last commit's content or message | 2. Merge only - never rebase shared/public branches because it rewrites history that others may have based their work on | 3. True | 4. `feat(auth): add OAuth2 login support` (or similar feat type with description) | 5. When you need to switch branches but aren't ready to commit your current changes

### Assignment/Homework:
1. **Portfolio Cleanup**: Review your personal GitHub repositories from previous projects. Identify commits with poor messages and practice rewriting them locally using interactive rebase (do NOT force push if others have cloned). Document what you learned in a one-page reflection.

2. **Conflict Simulation**: Create two branches in a test repository, make conflicting changes to the same file on both branches, then resolve the conflict. Take screenshots of the process and write a brief explanation of your resolution strategy.

3. **Commit Message Practice**: For your current HTL final project (or next assignment), commit at least 5 times using conventional commits format. Share the Git log with instructor for feedback.

### Extension Resources:
- **Documentation**: [Conventional Commits Specification](https://www.conventionalcommits.org/)
- **Tool**: `commitlint` - Automated linting of commit messages in CI/CD pipelines
- **Book Chapter**: "Pro Git" book, chapters on rebasing and conflict resolution (free online)
- **Advanced Challenge**: Set up a personal project with automated changelog generation from conventional commits

---

## Teaching Tips for Instructor

⚠️ **Timing Note**: This is content-dense material. Sections 2 & 3 are most critical for immediate application; Section 4 can be skimmed initially and explored deeper later if students ask questions.

⚠️ **Common Misconceptions to Address Early**:
- "Rebase makes my commits disappear" (incorrect: it rewrites them onto new base)
- "I should never use `git reset` because I'll lose everything" (partially correct—can recover but requires care)
- "Merge conflicts mean something went wrong" (not necessarily—they're normal in team development, just need proper resolution)

⚠️ **Safety Note**: Warn about force-pushing to public/shared branches—this can delete other people's work. Emphasize communication before rewriting history on team repositories.

[https://gitbybit.com/]

[https://gitvana.pixari.dev/]