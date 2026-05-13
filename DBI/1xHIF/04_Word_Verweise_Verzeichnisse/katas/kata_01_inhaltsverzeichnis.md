# Kata 1: Inhaltsverzeichnis erstellen

## Ziel

Lerne ein automatisches Inhaltsverzeichnis aus Überschriften-Stilen zu generieren.

**Wichtig:** Inhaltsverzeichnis funktioniert NUR mit den Stilen "Überschrift 1", "Überschrift 2" usw. Nicht mit manuell formatiertem Text!

## Aufgabenstellung

Erstelle ein Dokument mit Überschriften und lass Word automatisch ein Inhaltsverzeichnis generieren.

---

### Schritt 1: Dokument mit Stilen erstellen

Neues Word-Dokument. Schreibe folgenden Text und wende die richtigen Stile an:

| Text | Stil | Tastenkürzel |
|------|------|--------------|
| `1. Einleitung` | Überschrift 1 | `Strg+Alt+1` |
| Text darunter | Standard | `Strg+Umsch+N` |
| `1.1 Hintergrund` | Überschrift 2 | `Strg+Alt+2` |
| Text darunter | Standard | |
| `2. Hauptteil` | Überschrift 1 | `Strg+Alt+1` |
| Text darunter | Standard | |
| `2.1 Methodik` | Überschrift 2 | `Strg+Alt+2` |
| Text darunter | Standard | |
| `2.1.1 Vorgehensweise` | Überschrift 3 | `Strg+Alt+3` |
| Text darunter | Standard | |
| `2.2 Ergebnisse` | Überschrift 2 | `Strg+Alt+2` |
| Text darunter | Standard | |
| `3. Zusammenfassung` | Überschrift 1 | `Strg+Alt+1` |
| Text darunter | Standard | |

**Beispiel-Text zum Kopieren:**

```
1. Einleitung

Diese Hausarbeit behandelt das Thema Word für wissenschaftliche Arbeiten.
Die korrekte Formatierung ist wichtig für eine gute Benotung.

1.1 Hintergrund

Früher wurden Dokumente von Hand geschrieben und formatiert.
Heute übernimmt das der Computer.

2. Hauptteil

Im Hauptteil geht es um die Kernkonzepte.

2.1 Methodik

Die richtige Methodik ist entscheidend.

2.1.1 Vorgehensweise

Zuerst wird dies gemacht, dann jenes.

2.2 Ergebnisse

Die Ergebnisse zeigen...

3. Zusammenfassung

Am Ende folgt die Zusammenfassung.
```

Denk dran: **Immer die Stile anwenden!** Nicht nur fett und groß machen!

Überprüfe im **Navigationsbereich**:
- Menü: Ansicht → Hake "Navigationsbereich" an
- Du solltest dort eine Hierarchie deiner Überschriften sehen

---

### Schritt 2: Inhaltsverzeichnis einfügen

1. Gehe an den **ANFANG** des Dokuments (vor "1. Einleitung")
2. `Strg+Enter` → Neue Seite
3. Gehe auf die neue Seite 1
4. Schreibe: **"Inhaltsverzeichnis"** (als Überschrift 1 oder manuell fett)
5. Drücke `Enter` einmal
6. Menü: **Referenzen → Inhaltsverzeichnis**
7. Klicke auf eine der automatischen Vorlagen (z.B. "Automatisches Inhaltsverzeichnis 1")

**Fertig!** Word hat automatisch:
- Alle Überschriften 1, 2, 3 erkannt
- Die Seitenzahlen ermittelt
- Füllzeichen (Punkte) zwischen Text und Seitenzahl erstellt
- Ein klickbares Verzeichnis erstellt

---

### Schritt 3: Aktualisieren testen

**Wichtig:** Das Inhaltsverzeichnis aktualisiert sich NICHT automatisch!

Teste es:

1. Ändere im Text:
   - Gehe zu "1. Einleitung"
   - Schreibe statt "1. Einleitung" → **"1. NEUE EINLEITUNG"**
2. Oder: Füge Text hinzu und drücke `Strg+Enter` (Seitenumbruch), sodass sich die Seitenzahlen verschieben

3. Jetzt aktualisieren:
   - Klicke **ins Inhaltsverzeichnis** (irgendwo drauf)
   - Oben erscheint ein grauer Balken mit **"Inhaltsverzeichnis aktualisieren"**
   - Klicke drauf, ODER:
   - **Rechtsklick → Feld aktualisieren**

4. Wähle:
   - **Nur Seitenzahlen aktualisieren** → Wenn nur Seitenzahlen geändert
   - **Ganzes Inhaltsverzeichnis aktualisieren** → Wenn Überschriften hinzugefügt/gelöscht/umbenannt

5. OK

→ Jetzt sollte die Änderung sichtbar sein!

## Hinweise

- **KEINE STILE = KEIN INHALTSVERZEICHNIS!**
- Überschriften nur manuell (fett, groß) formatieren → geht nicht!
- `Strg+Alt+1/2/3` sind deine Freunde!
- Immer aktualisieren, wenn sich etwas ändert
- Vor dem PDF-Export: Einmal Inhaltsverzeichnis aktualisieren!

## Erweiterung (optional)

### Benutzerdefiniertes Inhaltsverzeichnis

1. Referenzen → Inhaltsverzeichnis → **Benutzerdefiniertes Inhaltsverzeichnis**
2. Probiere die Einstellungen:
   - **Füllzeichen:** Punkte, Striche, oder keins
   - **Ebenen anzeigen:** 1 (nur Überschrift 1) bis 9
   - **Hyperlinks statt Seitenzahlen:** Für PDFs

### Weitere Verzeichnisse

Wenn du Lust hast, schau dir auch an:
- Literaturverzeichnis (Referenzen → Literaturverzeichnis)
- Index (Referenzen → Index)
