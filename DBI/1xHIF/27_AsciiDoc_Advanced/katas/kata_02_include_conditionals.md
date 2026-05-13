# Kata 2: Include und Conditionals

## Ziel

Lerne, wie man große Dokumente mit `include::` modular aufbaut, konditionelle Inhalte für verschiedene Ausgabekanäle erstellt, und Attribute sowie Tabellen einsetzt.

## Aufgabenstellung

Erstelle einen **modularen Projektbericht** aus mehreren Dateien, der auf GitHub anders aussieht als im PDF-Druck.

### Schritt 1: Attribute in der Hauptdatei

Erstelle die Hauptdatei `bericht.adoc`:

```asciidoc
= Projektbericht
:author: [Dein Name]
:projektname: [Name deines Projekts]
:version: 1.0
:datum: September 2026
:toc: left
:sectnums:
```

---

### Schritt 2: Attribut-Referenzen im Text

Verwende die Attribute im Fließtext:

```asciidoc
== Einleitung

Dies ist der Projektbericht für *{projektname}* (Version {version}).
Erstellt von {author} am {datum}.
```

---

### Schritt 3: Konditionelle Inhalte

Füge konditionelle Blöcke für unterschiedliche Ausgabekanäle ein:

```asciidoc
ifdef::env-github[]
[NOTE]
====
Du siehst diesen Bericht auf GitHub.
Die interaktiven Elemente funktionieren nur in der HTML-Ansicht.
====
endif::[]

ifdef::backend-pdf[]
[WARNING]
====
Dies ist eine PDF-Version des Berichts.
Für die beste Erfahrung öffne die HTML-Version.
====
endif::[]
```

---

### Schritt 4: Include-Dateien erstellen

Erstelle drei separate Dateien:

**`einleitung.adoc`:**
```asciidoc
=== Ziel des Projekts

Beschreibe in 2-3 Sätzen das Ziel deines Projekts.

=== Anforderungen

* Anforderung 1
* Anforderung 2
* Anforderung 3
```

**`umsetzung.adoc`:**
```asciidoc
=== Verwendete Technologien

* Technologie 1
* Technologie 2
* Technologie 3

=== Meilensteine

|===
| Meilenstein | Datum | Status
| Planung | KW 35 | ✅ Abgeschlossen
| Entwicklung | KW 36-38 | 🔄 In Arbeit
| Test | KW 39 | ⏳ Ausstehend
| Abgabe | KW 40 | ⏳ Ausstehend
|===
```

**`ergebnisse.adoc`:**
```asciidoc
=== Zusammenfassung

Hier stehen die Ergebnisse des Projekts.

=== Nächste Schritte

. Ergebnisse präsentieren
. Feedback einholen
. Projekt archivieren
```

---

### Schritt 5: Includes in der Hauptdatei

Füge in `bericht.adoc` die Includes ein:

```asciidoc
== Einleitung

include::einleitung.adoc[]

== Umsetzung

include::umsetzung.adoc[]

== Ergebnisse

include::ergebnisse.adoc[]
```

---

### Schritt 6: Rendern

```bash
asciidoctor bericht.adoc
asciidoctor -b pdf bericht.adoc   # falls asciidoctor-pdf installiert ist
```

Öffne `bericht.html` im Browser.

**Kontrolliere:**
- Werden alle 3 included Dateien angezeigt?
- Siehst du den GitHub-Hinweis (`env-github` wird im Browser gerendert)?
- Siehst du die Tabelle mit den Meilensteinen?
- Werden die Attribute ({projektname}, {author}) korrekt ersetzt?

---

## Kontrolle

- [ ] Hauptdatei `bericht.adoc` mit Attributen
- [ ] Attribute werden im Text verwendet (`{projektname}`, `{author}`, etc.)
- [ ] `ifdef::env-github[]` Block ist sichtbar
- [ ] Drei include-Dateien existieren
- [ ] `include::` funktioniert fehlerfrei
- [ ] Tabelle mit `|===` ist vorhanden
- [ ] HTML wird fehlerfrei gerendert

## Erweiterung (optional)

1. Füge einen `ifndef::env-github[]` Block hinzu, der Inhalte zeigt, die NICHT auf GitHub erscheinen
2. Verwende `leveloffset=+1` beim Include, um die Überschriftenebenen anzupassen
3. Füge ein zusätzliches Attribut `:status:` und zeige es im conditional-Block an
4. Erstelle ein `glossar.adoc` und binde es am Ende des Dokuments ein
5. Experimentiere mit der Tabelle: Füge eine Spalte "Verantwortlich" hinzu
