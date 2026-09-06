Der Grund für die Langeweile ist wahrscheinlich, dass die Aufgaben reproduktiv sind: Die Schüler kennen die Knöpfe, also ist alles, was sie tun sollen, ein Nachbauen. Der Ausweg ist nicht, seltenere Knöpfe zu suchen, sondern die Anforderung zu verschieben – weg vom Bedienen, hin zum Konstruieren, Automatisieren und Beurteilen. Genau das lässt sich in beiden Programmen erstaunlich weit treiben, und es passt zur Informatik.

## Word

**Trennung von Inhalt und Darstellung als eigentliches Thema.** Fast alle Unterstufen-Absolventen formatieren direkt. Gib ihnen ein bewusst schlecht gemachtes Dokument (Einrückungen mit Leerzeichen, händische Nummerierung, Überschriften einfach fett und größer, Seitenumbrüche mit Enter) und lass sie es refaktorieren, mit dem Erfolgskriterium: Das komplette Layout muss sich anschließend durch Wechsel des Formatvorlagensatzes in fünf Sekunden umstellen lassen. Das ist inhaltlich derselbe Gedanke wie später HTML/CSS und lässt sich objektiv prüfen.

**Ein .docx ist ein ZIP-Archiv voller XML.** Umbenennen, entpacken, `document.xml` ansehen, eine Formulierung im XML ändern, wieder packen, in Word öffnen. Dieser Moment holt fast jede Klasse ab, weil das Programm plötzlich aufhört, eine Blackbox zu sein. Von dort kommst du zu strukturierten Daten, XML und später zu allem, was du bei Excel ohnehin vorhast. Ein Nebeneffekt: Du kannst ankündigen, dass du bei der Abgabe per Skript prüfst, ob wirklich Formatvorlagen verwendet wurden. Direkt formatierte Abgaben fallen damit auf, und die Schüler finden es meist fair und lustig.

**Serienbrief und Feldfunktionen als Template-Engine.** Datenquelle in Excel, Vorlage in Word, mit Bedingungsfeldern (`{ IF … }`), Alt+F9 für die Feldcodes. Das ist Datenverarbeitung mit Verzweigungen und eine saubere Brücke zu deinem Excel- und Datenbankstrang. Aufgabe: 200 personalisierte Zertifikate oder Mahnungen, bei denen der Text je nach Datenwert unterschiedlich ausfällt.

**Ein Produkt für andere bauen.** Statt ein Dokument zu formatieren, entwickeln sie eine `.dotx`-Vorlage mit Deckblatt, Kopf-/Fußzeile, Schnellbausteinen und definierten Formatvorlagen – zum Beispiel die Protokollvorlage, die sie in den Werkstätten- und Laborfächern die nächsten Jahre wirklich brauchen. Anschließend Cross-Test: Die Vorlage einer anderen Gruppe wird benutzt und bewertet. Das erzeugt Ernstfall-Charakter.

**Änderungsverfolgung und Dokumentvergleich** kannst du explizit als Vorläufer von Diff und Merge einführen. Zwei Gruppen bearbeiten dasselbe Dokument parallel, dann müssen die Versionen zusammengeführt werden. Wenn du Lust hast: dasselbe Dokument zusätzlich als Markdown, mit Pandoc konvertieren und vergleichen, was verloren geht.

## PowerPoint

**Folienmaster statt Folien.** Dasselbe Prinzip wie bei den Formatvorlagen: Sie bauen ein Design-System mit eigenen Layouts und Platzhaltern nach einem vorgegebenen Corporate-Design-Blatt (exakte Hex-Werte, Schriftgrößen, Abstände). Bewertet wird die Einhaltung der Spezifikation, nicht der Geschmack.

**Harte Formatvorgaben statt freier Themen.** Pecha Kucha mit 20 Folien à 20 Sekunden und automatischem Weiterschalten zwingt zu Timing, Bildsprache und Automatisierung. Eine Variante ohne jeden Fließtext, nur Bilder. Und PowerPoint-Karaoke, bei dem jemand eine fremde, unbekannte Präsentation live moderieren muss, ist für den Sprechteil das Wertvollste, was ich kenne, und kostet dich wenig Vorbereitung.

**Interaktives statt linear.** Mit Hyperlinks, Triggern und Animationen lässt sich in PowerPoint ein Quiz, ein Escape Room oder ein Entscheidungsspiel bauen. Das ist verkappte Ereignis- und Zustandslogik: Was passiert bei welchem Klick, in welchem Zustand ist die Präsentation gerade. Für eine erste Informatikklasse ein guter Vorgriff auf Verzweigungen, und es entsteht etwas, das sie herzeigen wollen.

**Automatisiert erzeugen.** Wenn Zeit bleibt: Folien aus Daten generieren, entweder aus Excel oder mit `python-pptx`, und daneben eine Präsentation, die als Markdown geschrieben und mit Marp oder reveal.js gerendert wird. Die Frage „Wann ist ein Klick-Tool sinnvoll und wann Code?" ist eine sehr HTL-taugliche Diskussion.

**Ein Anti-Beispiel bauen** funktioniert erfahrungsgemäß besser als ein gutes: die schlimmstmögliche Folie erstellen und danach für jedes Element begründen, warum es schlecht ist. Danach dieselbe Aussage in guter Form.

## Zum Rahmen

Zwei Dinge machen viel aus. Erstens ein durchgehendes Szenario über alle drei Programme, etwa eine fiktive Firma oder ein Produkt: Dokumentation und Vorlage in Word, Pitch in PowerPoint, Kalkulation und Auswertung in Excel, mit denselben Daten. Dann fühlt sich der Word-Teil nicht wie ein abgetrennter Pflichtblock an.

Zweitens eine kurze Diagnose in der ersten Einheit, weil das Vorwissen aus der Digitalen Grundbildung sehr ungleich verteilt ist. Wer die Basics sicher hat, bekommt sofort die Ausbaustufe und übernimmt zusätzlich eine Expertenrolle für den Rest. Das ist auch die realistischste Absicherung dagegen, dass es für die Starken wieder zäh wird.
