# Kata 2: Checkboxen und mehr

## Ziel

Lerne, wie man Task-Listen (Checkboxen), horizontale Linien und alle bisher gelernten Markdown-Elemente kombiniert. Verstehe die Rendering-Unterschiede zwischen verschiedenen Plattformen.

---

## Aufgabenstellung

Erstelle eine Datei namens `projektplan.md` für ein **Schulprojekt** — die Planung einer Webseite für den Schulball.

### Schritt 1: Titel und Übersicht

```markdown
# Projektplan: Schulball-Webseite

> Ein gemeinsames Projekt der 1xHIF
>
> **Deadline:** 15. Dezember 2026
```

---

### Schritt 2: Aufgaben (Task-Liste mit Kategorien)

```markdown
## Aufgaben

### Design

- [x] Farbschema festlegen
- [x] Logo erstellen
- [x] Mockups für Startseite
- [ ] Responsive Design umsetzen
- [ ] Mobile Navigation testen

### Entwicklung

- [ ] HTML-Grundgerüst
- [ ] CSS-Styling
- [ ] Formular für Ticketbestellung
- [ ] Google Maps API für Anfahrt
- [ ] Impressum und Datenschutz

### Inhalt

- [ ] Texte für alle Seiten schreiben
- [x] Fotos vom letzten Schulball aussuchen
- [ ] Programmablauf erstellen
- [ ] Speisekarte digitalisieren
```

**Wichtig:** Die Einrückung mit Leerzeichen unter `## Aufgaben` gruppiert die Aufgaben in Kategorien!

---

### Schritt 3: Zeitplan (Tabelle)

```markdown
## Zeitplan

| Phase | Aufgabe | Wer | Status |
|:------|:--------|:----|:-------|
| KW 38 | Design-Festlegung | Team 1 | ✅ |
| KW 39 | HTML-Struktur | Team 2 | ⏳ |
| KW 40 | CSS & Responsive | Team 3 | ❌ |
| KW 41 | Inhalte einpflegen | Team 1 | ❌ |
| KW 42 | Testen & Deployment | Alle | ❌ |

**Legende:**
- ✅ = Erledigt
- ⏳ = In Arbeit
- ❌ = Offen
```

---

### Schritt 4: Meilensteine (Zitate + Liste)

```markdown
## Meilensteine

> **Meilenstein 1 (KW 39):** Design abgeschlossen
>
> Alle Mockups sind freigegeben, Farbschema steht.

> **Meilenstein 2 (KW 41):** Entwicklung abgeschlossen
>
> Die Webseite ist voll funktionsfähig auf dem Testserver.

> **Meilenstein 3 (KW 42):** Go-Live
>
> Die Webseite ist unter schulball.example.com erreichbar.
```

---

### Schritt 5: Teammitglieder (Tabelle mit Links)

```markdown
## Team

| Name | Rolle | Aufgaben |
|:-----|:------|:---------|
| [Anna](https://github.com/anna) | Projektleitung | Koordination, Qualitätssicherung |
| [Ben](https://github.com/ben)   | Frontend-Dev  | HTML, CSS, JavaScript          |
| [Clara](https://github.com/clara) | Backend-Dev  | Formular, E-Mail-Versand       |
| [David](https://github.com/david) | Design       | Mockups, Grafiken, Farben      |
```

---

### Schritt 6: Abschluss

```markdown
---

*Projektplan erstellt von [Dein Name] — Stand: September 2026*

> *"Gemeinsam schaffen wir das!"*
```

---

### Schritt 7: Rendering-Unterschiede testen (optional)

**Aufgabe:**
1. Erstelle ein **öffentliches GitHub-Repository** (z.B. `schulball-plan`)
2. Lade `projektplan.md` hoch
3. Betrachte die Datei auf GitHub
4. **Vergleiche** mit der VS Code Vorschau:

| Element | VS Code | GitHub | Unterschiede |
|---------|---------|--------|--------------|
| Checkboxen | | | |
| ✅ / ⏳ / ❌ | | | |
| Tabellen | | | |
| Zitate | | | |
| Horizontale Linien | | | |

Notiere die Unterschiede in einer Textdatei `unterschiede.txt`.

---

## Hinweise

- Checkboxen (`- [ ]`) sind **GitHub Flavored Markdown (GFM)** — sie funktionieren nicht in allen Markdown-Editoren
- In VS Code werden Checkboxen angezeigt, sind aber nicht klickbar
- Auf GitHub sind Checkboxen **klickbar** — ein Klick togglt den Status
- Einrückung ist wichtig: 2 oder 4 Leerzeichen für Unterpunkte
- `⏳` (Sanduhr) ist ein Unicode-Emoji — nicht alle Systeme zeigen es gleich an

## Erweiterung (optional)

1. Erstelle eine **Fortschrittsanzeige** mit einer Tabelle:
   ```markdown
   | Phase | Fortschritt |
   |:------|:-----------:|
   | Design | 60 % |
   ```
   Verwende `█` und `░` Unicode-Zeichen für eine visuelle Fortschrittsanzeige!

2. Füge eine **verschachtelte Task-Liste** hinzu (Unteraufgaben unter Hauptaufgaben)

3. Erstelle einen **Inhaltsbaustein** mit einer Tabelle, die Hyperlinks, Fett und Code enthält

4. Teste die Datei in **GitLab** — gibt es Rendering-Unterschiede zu GitHub?
