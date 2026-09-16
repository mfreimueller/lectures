---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 05 - Exercise, Consolidation
## POS - 3xHIF

---

## Agenda

1. Quick Recap: Weeks 00-04
2. Exercise Overview
3. Tips

---

## Learning Objectives

- I can combine Records, Optional, and streams to build data-driven applications
- I can design sealed class hierarchies for domain modeling
- I can process CSV files using the Files API and streams
- I can identify and fix anti-patterns in legacy Java code

---

## Quick Recap: Weeks 00-04

- Records and var
- Default/static interface methods, pattern matching for instanceof, Text Blocks
- Optional, switch expressions, sealed classes
- Unnamed variables, flexible constructor bodies, utility APIs
- Refactoring to modern Java

---

## Reflection: Your Modern Java Journey

<div class="highlight-box">
<p>Looking back at the features covered so far: which modern Java feature do you find most useful in your own code? Which one do you find hardest to apply in practice? Why do you think that is?</p>
</div>

---

## Exercise Overview

Today you will solve integrated problems that combine:

- Records for data modeling
- Pattern matching and sealed classes for type hierarchies
- Optional for safe null handling
- Streams for data processing
- Switch expressions for concise branching

---

## Tips

- Start with the data model (Records)
- Use sealed classes when you have a fixed set of subtypes
- Prefer streams over loops for collections
- Use Optional rather than null for optional values
- Let the compiler help you with exhaustive switches
