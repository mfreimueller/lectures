# Kata 1: Dokumentation mit Tabellen

## Ziel

Lerne, wie man in Markdown Tabellen erstellt, Spalten ausrichtet, Zitate einfügt und Dokumente mit horizontalen Linien strukturiert.

---

## Aufgabenstellung

Erstelle eine Datei namens `produkt.md` für ein fiktives Produkt **"CloudSync Pro"** — eine Cloud-Synchronisations-Software.

### Schritt 1: Titel und Einleitung

```markdown
# CloudSync Pro — Dokumentation

> CloudSync Pro ist die **führende** Synchronisationslösung für Unternehmen.
>
> Version 3.2 — Letztes Update: September 2026
```

**Erklärung:** `>` erzeugt ein Zitat (Blockquote). Zeilen innerhalb des Zitats beginnen ebenfalls mit `>`.

---

### Schritt 2: Horizontale Linie

Verwende `---` um Abschnitte zu trennen:

```markdown
---
```

---

### Schritt 3: Versionstabelle

Erstelle eine Tabelle mit verschiedenen Produktversionen:

```markdown
## Verfügbare Versionen

| Version | Preis | Speicher | Support |
|:--------|:-----:|:--------:|:-------:|
| Free    | 0 €   | 5 GB     | Community |
| Pro     | 9 €   | 100 GB   | E-Mail     |
| Team    | 29 €  | 1 TB     | Priority   |
| Enterprise | Individuell | Unbegrenzt | 24/7 |
```

**Beachte die Ausrichtung:**
- `:--------` = linksbündig (Version, Preis)
- `:-------:` = zentriert (Speicher, Support)

---

### Schritt 4: Feature-Tabelle

```markdown
## Feature-Vergleich

| Feature | Free | Pro | Team | Enterprise |
|:--------|:----:|:---:|:----:|:----------:|
| Datei-Sync | ✅ | ✅ | ✅ | ✅ |
| Verschlüsselung | ❌ | ✅ | ✅ | ✅ |
| Team-Ordner | ❌ | ❌ | ✅ | ✅ |
| API-Zugriff | ❌ | ❌ | ❌ | ✅ |
| Prioritäts-Support | ❌ | ❌ | ❌ | ✅ |
```

---

### Schritt 5: Systemanforderungen

```markdown
## Systemanforderungen

| Komponente | Minimum | Empfohlen |
|:-----------|:--------|:----------|
| Betriebssystem | Windows 10 / macOS 12 / Ubuntu 20.04 | Windows 11 / macOS 15 / Ubuntu 24.04 |
| RAM | 2 GB | 8 GB |
| Speicher | 500 MB | 2 GB |
| Internet | 10 Mbit/s | 50 Mbit/s |

> **Hinweis:** CloudSync Pro benötigt eine aktive Internetverbindung für die Synchronisation.
```

---

### Schritt 6: Letzte horizontale Linie und Footer

```markdown
---

*Dokumentation erstellt von [Dein Name](https://example.com)*
```

---

### Schritt 7: Vorschau prüfen

Öffne die Datei in VS Code und drücke **`Cmd+Shift+V`** (macOS) oder **`Ctrl+Shift+V`** (Windows).

**Prüfe:**
- Sind die Tabellen sauber formatiert?
- Ist die Spaltenausrichtung korrekt (links/zentriert)?
- Sieht das Zitat eingerückt aus?
- Werden horizontale Linien als durchgezogene Linien angezeigt?
- Sind ✅ und ❌ sichtbar?

---

## Hinweise

- Die Anzahl der Striche in der Trennlinie ist egal — `|---|---|` reicht genau so wie `|------------|------------|`
- Tabellen müssen **nicht** in der Breite ausgerichtet sein — die Darstellung passt sich an
- ✅ und ❌ sind Unicode-Zeichen — sie funktionieren in den meisten Editoren
- In manchen Editoren müssen Tabellen von Leerzeilen umgeben sein
- Zitate können andere Markdown-Elemente enthalten (fett, Listen, Tabellen!)

## Erweiterung (optional)

1. Füge eine Tabelle mit **Preisen pro Jahr** hinzu (rechtsbündig ausgerichtet)
2. Erstelle ein **verschachteltes Zitat** (`> > Text`)
3. Füge eine **Task-Liste** der geplanten Features für Version 4.0 hinzu
4. Teste die Datei auf **GitHub**: Erstelle ein Repository und lade die Datei hoch — sieht sie anders aus?
