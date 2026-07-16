---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 05 - Code Review: JPA & Tests
## POS - 4xHIF

---

## Warum Code Reviews?

- Bugs finden bevor sie in Produktion gehen
- Wissen im Team weitergeben
- Einheitliche Codequalität sicherstellen
- Von den Ansätzen anderer lernen

---

## Review-Etikett

- Sei konkret: "Zeile 42: Fetch Type LAZY wäre hier besser, weil..."
- Fragen stellen, nicht vorwurfsvoll sein: "Warum hast du CascadeType.ALL gewählt?"
- Auch gute Lösungen loben!
- Fokus auf den Code, nicht auf die Person

---

## Checkliste: Entities

- @Entity auf allen persistenter Klassen?
- @Id und @GeneratedValue korrekt konfiguriert?
- @Column Annotationen mit nullable, unique, length wo nötig?
- Tabellennamen folgen Namenskonvention (kleinbuchstaben, Plural)?

---

## Checkliste: Beziehungen

- Korrekter Beziehungstyp (@OneToMany vs @ManyToMany)?
- mappedBy auf der inversen Seite von bidirektionalen Beziehungen verwendet?
- Hilfsmethoden (addLoan, removeLoan) vorhanden?
- Join-Tabellennamen folgen Konvention?

---

## Checkliste: Cascade & Fetch

- Cascade Typen nicht zu aggressiv (CascadeType.ALL auf @ManyToMany vermeiden)?
- CascadeType.REMOVE nur wo es Sinn ergibt?
- FetchType.LAZY überall verwendet (außer in seltenen Fällen)?
- Offensichtliche N+1 Abfrage-Risiken?

---

## Checkliste: Tests

- @DataJpaTest für Repository Tests verwendet?
- Tests decken ab: CRUD, Beziehungen, benutzerdefinierte Abfragen?
- Edge Cases getestet (leere Ergebnisse, nulls)?
- AssertJ für lesbare Assertions verwendet?
- Testdaten in @BeforeEach aufgesetzt?

---

## Review-Prozess

1. **Zuweisen** — Jedes Team wird mit einem anderen gepaart (30 Min)
2. **Review** — Checkliste durchgehen, GitHub Issues erstellen (30 Min)
3. **Diskutieren** — Reviewer stellen den Befunde dem Review-Team vor (15 Min)
4. **Beheben** — Jedes Team behebt die Issues im eigenen Repo (30 Min)
5. **Überprüfen** — Reviewer prüfen ob die Behebungen umgesetzt wurden (15 Min)
