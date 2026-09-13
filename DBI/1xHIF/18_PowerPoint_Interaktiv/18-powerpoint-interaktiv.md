---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 18 - Interaktive Präsentationen
## DBI - 1xHIF

---

## Agenda

1. Linear vs. interaktiv
2. Hyperlinks zwischen Folien
3. Aktionsschaltflächen
4. Trigger
5. Auftrag: Mini-Quiz oder Entscheidungs-Pfad

---

## Lernziele

- Ich kann Folien per Hyperlink nicht-linear verknüpfen
- Ich kann Aktionsschaltflächen einfügen, die zu einer bestimmten Folie springen
- Ich kann Trigger einsetzen, damit ein Klick auf ein Element eine Animation auslöst
- Ich kann damit ein einfaches interaktives Quiz oder einen Entscheidungspfad bauen

---

## Linear vs. interaktiv

- Normalerweise: Folie 1 → 2 → 3 → … in fester Reihenfolge
- **Interaktiv:** Der Klick des Publikums entscheidet, wohin es als Nächstes geht
- Genau das braucht ihr für ein Quiz, ein Entscheidungsspiel, einen Mini-Escape-Room

---

## Hyperlinks zwischen Folien

- Text/Objekt markieren → **Einfügen > Link > In diesem Dokument**
- Ziel: eine bestimmte Folie (z. B. „Richtig!" oder „Falsch, versuch's nochmal")
- Jede Antwortmöglichkeit kann zu einer **anderen** Folie führen

---

## Aktionsschaltflächen

- **Einfügen > Formen** — ganz unten: Aktionsschaltflächen
- Fertige Buttons: Zurück, Weiter, Start, Ende, Info, …
- Verhalten pro Button einstellbar: Hyperlink zu einer Folie, Sound abspielen, …

---

## Trigger

- **Animationen > Trigger > Beim Klicken auf...**
- Eine Animation läuft erst, wenn ein **bestimmtes Objekt** angeklickt wird — nicht
  automatisch beim Folienwechsel
- Nützlich, um z. B. eine Lösung erst nach einem Klick einzublenden

---

## Auftrag: Mini-Quiz oder Entscheidungs-Pfad

Baut eines von beidem:

1. Mindestens **3 Fragen/Entscheidungspunkte**, je mit mindestens 2 Antwortmöglichkeiten
2. Jede Antwort führt per Hyperlink zur passenden Folgefolie
3. Mindestens **ein Trigger**, der etwas erst nach einem Klick zeigt

---

<!-- _class: invert -->

## Summary

- Hyperlinks machen aus einer linearen Folge eine verzweigte Struktur
- Aktionsschaltflächen sind fertige, klickbare Sprungziele
- Trigger lösen eine Animation erst bei einem gezielten Klick aus
- Nächste Woche: Folien automatisiert erzeugen
