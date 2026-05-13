# Kata 1: Ubiquitous Language

| Feld | Wert |
|------|------|
| Konzepte | Ubiquitous Language, Domain Modeling, Glossar |
| Schwierigkeit | 2/5 |
| Dauer | ca. 25 min |

## Aufgabenstellung

Du arbeitest an einem System für eine **Bibliothek**. Die Fachexperten verwenden folgende Begriffe:

- "Ausleihe" — Ein Vorgang, bei dem ein Mitglied ein Medium entleiht
- "Medium" — Ein physisches Objekt (Buch, DVD, Zeitschrift)
- "Mitglied" — Eine Person, die Medien ausleihen darf
- "Reservierung" — Ein Vorgang, bei dem ein Mitglied ein aktuell verliehenes Medium vormerkt
- "Mahnung" — Eine Erinnerung an die Rückgabe eines überfälligen Mediums
- "Gebühr" — Ein Geldbetrag, der für verspätete Rückgabe oder Verlust fällig wird

Erstelle ein Ubiquitous Language Glossar mit:
1. Definitionen der Kernbegriffe (mindestens 6)
2. Beziehungen zwischen den Begriffen (z.B. "Ein Mitglied kann mehrere Ausleihen haben")
3. Jeweils den passenden DDD-Baustein (Entity, Value Object, Domain Event, Aggregate oder Repository)

### Beispiel-Output

```
Begriff: Ausleihe
Definition: Ein Vorgang zur Verbuchung der Entleihung eines Mediums durch ein Mitglied
Beziehungen: betrifft genau ein Medium, wird von genau einem Mitglied getatigt
DDD-Typ: Entity (Aggregate Root)
```

### Erweiterung

Identifiziere zusätzlich die Bounded Contexts der Bibliotheksdomane (z.B. Ausleihkontext, Katalogkontext, Mitgliederverwaltung).
