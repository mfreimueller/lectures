---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# Word – Serienbrief
## DBI 1xHIF

---

## Agenda

1. Grundidee: Hauptdokument + Datenquelle
2. Seriendruckfelder einfügen
3. Bedingte Felder: `{ IF ... }`
4. Feldcodes anzeigen (`Alt+F9`)
5. Vorschau & Zusammenführen
6. Auftrag: Personalisierte Zertifikate

---

## Lernziele

- Ich kann eine Datenquelle mit einem Word-Hauptdokument verknüpfen
- Ich kann Seriendruckfelder einfügen
- Ich kann mit einem `{ IF ... }`-Feld den Text abhängig vom Datenwert verändern
- Ich kann den fertigen Serienbrief in einzelne Dokumente zusammenführen

---

## Grundidee

**Hauptdokument** (Text + Platzhalter) + **Datenquelle** (eine Zeile pro Empfänger) =
viele individuelle Briefe auf einmal.

Menü: **Sendungen**

```
Hauptdokument:      "Liebe/r <<Vorname>>, ..."
Datenquelle (Excel): Vorname | Nachname | Abteilung | Punkte
                     Anna    | Bauer    | Vertrieb  | 87
```

---

## Seriendruckfelder einfügen

1. **Sendungen > Empfänger auswählen > Vorhandene Liste verwenden** (Excel-Datei wählen)
2. **Sendungen > Seriendruckfeld einfügen** — z. B. `<<Vorname>>`
3. Word ersetzt das Feld pro Empfänger automatisch mit dem passenden Wert

---

## Bedingte Felder: `{ IF ... }`

**Problem:** Nicht nur der Name soll sich ändern — auch der Text selbst, je nach Wert
(z. B. „Bestanden" vs. „Nicht bestanden" je nach Punktestand).

**Lösung:** Sendungen > Regeln > **Wenn...Dann...Sonst**

```
{ IF { MERGEFIELD Punkte } >= 50 "Bestanden mit Auszeichnung" "Teilgenommen" }
```

---

## Feldcodes anzeigen (`Alt+F9`)

- Zeigt Felder als **Code** statt als Ergebnis
- Hilfreich, wenn ein bedingtes Feld nicht das tut, was erwartet wird
- Nochmal `Alt+F9` schaltet zurück zur normalen Ansicht

---

## Vorschau & Zusammenführen

- **Sendungen > Vorschau Ergebnisse** — vor dem Abschluss immer prüfen!
- **Fertigstellen > Einzelne Dokumente bearbeiten** — erzeugt echte, fertige Dokumente
  (keine Platzhalter mehr, jedes einzeln bearbeitbar)

---

## Auftrag: Personalisierte Zertifikate

Erstellt Zertifikate/Einladungen für eine fiktive Veranstaltung eures Unternehmens:

- Datenquelle mit mehreren Personen und mindestens einem Zahlenwert
- Mindestens **ein bedingtes Feld** — der Text soll sich je nach Datenwert unterscheiden

---

<!-- _class: invert -->

## Summary

- Ein Serienbrief kombiniert ein Hauptdokument mit einer Datenquelle
- `{ IF ... }`-Felder verändern nicht nur Werte, sondern den Text selbst
- `Alt+F9` zeigt Feldcodes zum Debuggen
- Nächste Woche: Lebenslauf
