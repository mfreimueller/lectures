# Kata 1: TOC und Cross-References

## Ziel

Lerne, wie man in AsciiDoc ein Inhaltsverzeichnis erstellt, Sections nummeriert und interne Querverweise setzt.

## Aufgabenstellung

Schreibe einen **Reiseführer über deine Lieblingsstadt** mit Inhaltsverzeichnis, nummerierten Kapiteln und Cross-References zwischen den Abschnitten.

### Schritt 1: Grundgerüst mit TOC

Erstelle eine Datei `reisefuehrer.adoc`.

```asciidoc
= Reiseführer: [Name deiner Stadt]
:author: [Dein Name]
:toc: left
:toc-title: Auf einen Blick
:sectnums:
```

| Direktive | Erklärung |
|-----------|-----------|
| `:toc: left` | Inhaltsverzeichnis links positionieren |
| `:toc-title: Auf einen Blick` | Eigener Titel für das TOC |
| `:sectnums:` | Alle Sections automatisch nummerieren |

---

### Schritt 2: Drei Kapitel mit Ankern

Erstelle 3 Kapitel. Setze vor jede `==` Überschrift einen **Anchor** (`[[id]]`).

```asciidoc
[[anreise]]
== Anreise

=== Mit dem Auto
Beschreibe die Anreise mit dem Auto.

=== Mit der Bahn
Beschreibe die Anreise mit der Bahn.

=== Mit dem Flugzeug
Optional: Beschreibe die Anreise per Flug.

[[sehenswuerdigkeiten]]
== Sehenswürdigkeiten

=== Historische Gebäude
Welche historischen Gebäude gibt es?

=== Museen
Welche Museen sind einen Besuch wert?

[[kulinarik]]
== Kulinarische Highlights

=== Traditionelle Gerichte
Was isst man dort typischerweise?

=== Restaurants
Empfehle 2-3 Restaurants.
```

---

### Schritt 3: Cross-References

Füge am Ende einen Abschnitt `== Siehe auch` ein.

Verweise von dort aus auf alle 3 Kapitel, und zwar **mit benutzerdefiniertem Text**:

```asciidoc
== Siehe auch

* Wie du anreist, erfährst du unter <<anreise,Anreise>>
* Die wichtigsten <<sehenswuerdigkeiten,Sehenswürdigkeiten>>
* Kulinarische Tipps unter <<kulinarik,Essen & Trinken>>
```

Alternativ mit `xref:`-Syntax:
```asciidoc
* Wie du anreist, erfährst du unter xref:anreise[Anreise]
```

---

### Schritt 4: Zusätzliche Cross-References

Füge **innerhalb der Kapitel** mindestens einen zusätzlichen Verweis ein.

Beispiel: Im Kapitel "Anreise → Mit dem Auto" ein Verweis auf einen Parkplatz, der bei "Sehenswürdigkeiten" erwähnt wird:

```asciidoc
=== Mit dem Auto

... Parke am besten am [[parkplatz]]Praterstern. ...
```

Und in einem anderen Abschnitt:
```asciidoc
Parkmöglichkeiten gibt es am <<parkplatz,Praterstern>>.
```

---

### Schritt 5: Rendern

```bash
asciidoctor reisefuehrer.adoc
```

Öffne `reisefuehrer.html` im Browser.

**Kontrolliere:**
- Siehst du das Inhaltsverzeichnis auf der linken Seite?
- Sind die Kapitel nummeriert (1., 1.1., 2., 2.1., ...)?
- Funktionieren die Links im "Siehe auch"-Abschnitt?

---

## Kontrolle

- [ ] `:toc: left` erzeugt ein Inhaltsverzeichnis
- [ ] `:toc-title:` ändert den TOC-Titel
- [ ] `:sectnums:` nummeriert alle Sections
- [ ] Jedes Hauptkapitel hat einen `[[anchor]]`
- [ ] Cross-References mit `<<id,Text>>` funktionieren
- [ ] Mindestens ein Cross-Reference innerhalb eines Kapitels
- [ ] HTML wird fehlerfrei gerendert

## Erweiterung (optional)

1. Füge ein 4. Kapitel "Fazit" hinzu und verweise von dort zurück auf alle anderen Kapitel
2. Experimentiere mit `:toc: right` und `:toclevels: 3`
3. Füge eine Tabelle mit Öffnungszeiten der Museen ein
4. Verwende `xref:id[Text]` statt `<<id,Text>>` für alle Verweise
