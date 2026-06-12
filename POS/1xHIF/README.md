# Programmieren und Softwareentwicklung 1xHIF

Die folgende Datei beschreibt die einzelnen Themen des Unterrichtsgegenstandes "Programmieren und Softwareentwicklung" in der Klasse 1xHIF. Die Liste der Themen ist keine 1:1 Ummünzung auf Unterrichtswochen.

- Unterrichtssprache: Deutsch
- Programmiersprache: Java
- Niveau: blutige Anfänger

## Übungen

Jede Lektion bietet Übungen an. Übungen haben zwei Arten:

- Katas
- Exercise

Ein Kata is eine kleine, atomare Übung, welche ein Thema einer Lektion durch Wiederholung festigt. Katas sind atomar, beziehen sich also nur auf ein kleines, abgegrenztes Themengebiet und sind von anderen Katas oder Exercises unabhängig. Beispiel: Das Üben von Zählschleifen durch das Implementieren verschiedener Figuren in kleinen Katas.

Eine Exercise ist eine größere Übung, welche mehrere Konzepte auch lektionsübergreifend miteinander verbindet. Exercises sind per defintionem nicht atomar, sondern können auch aufeinander aufbauen. Beispiel: Das Implementieren einer "Verkehrsverwaltung" mit zwei Klassen: Bus und Ticket. In einer Übung wird die Ticket-Klasse implementiert, in der zweiten, darauf aufbauenden, der Bus.

Eine Übung darf keine Konzepte verwenden, die erst in einer späteren Lektion vermittelt werden. Ausnahmen-Beispiel: "User Input - Scanner, Random": "Code für Convert vorgeben (kommt erst später)" -> in diesem Fall muss der entsprechende Code im Kata/in der Exercise angegeben werden.

Pro Lektion soll es 3-5 Katas geben.

Pro Lektion soll es zumindest 1 Übung geben. Alle Lektionen, die den Vermerk "Große Übung" beinhalten, sollen **zusätzlich** noch eine größere Übung beinhalten, welche in einer eigenen Stunde bearbeitet werden soll.

Die erste Lektion "Was ist Programmieren? Java & JVM" beinhaltet noch keine Programmieraufgaben. Stattdessen soll eine Exercise generiert werden, welche als Reflexionsaufgabe dient. Eine zweite Exercise soll das Computational Thinking vertiefen, indem Schüler Flowcharts zu einem Problemfall zeichnen müssen.

## Jahresprojekt

Im Kern des Gegenstandes steht das Jahresprojekt, ein textbasierter Dungeon Crawler, den die Schüler mit jeder Lektion weiter ausbauen und vertiefen. Das Projekt stellt das Portfolio dar, welches die Schüler am Ende vorweisen können.

Die Weiterentwicklung am Projekt erfolgt über spezielle Projekt-Aufgaben, welche zusätzlich zu den Übungen ausgegeben werden. Das Ziel ist hier weniger (gerade zu anfangs), komplexen Code zu schreiben, sondern vielmehr, den Zusammenhang des Ganzen zu sehen.

## Lektionen

Jeder der folgenden Abschnitte beschreibt eine Lektion. Sofern ein Abschnitt Aufzählungen aufweist, geben dies ihm Richtung.

Die Titel der Lektionen sind Vorschläge und können gegebenenfalls adaptiert werden.

### Was ist Programmieren? Java & JVM

- Grundlegendes Einführen in das Computational Thinking
- Leitfrage: Was machen wir, wenn wir programmieren?
- Einführung in Programmiersprache (Warum benötigt es verschiedene?)
- Unterscheidung kompiliert & interpretiert
- Unterscheidung nativ & VM

### Datentypen, Operatoren

- Basic-Datentypen: boolean, int, float, String, char
- Arithmetische Operatoren: +, -, *, /

### Zuweisung, Anweisung

- Differenz zwischen Zuweisung und Anweisung

### Verzweigung

- Vergleichsoperatoren: <, >, ==, !=, !

### User Input - Scanner, Random

- Ziel: Programmieren interaktiv gestalten
- einfache Eingaben lesen: String, int
- Code für Convert vorgeben (kommt erst später)
- Zufallszahl ziehen

### Schleifen - while

- Einstieg in das Konzept der Wiederholung
- Endlosschleife
- Basic: while (i < 10) i++ ...

### Schleifen - do-while

- break + continue einführen
- Konzept der kopf- und fußgesteuerten Schleife

### Schleifen - for

- Aus while-Schleife umbauen
- Unterschiede & Nutzen besprechen

### Arrays

- 1-D Arrays

### Sortieren von Arrays

- Bubblesort

### String Methoden
- length, equals, charAt, startsWith, endsWith

### Convert (String to Int, String to float, String to boolean)

### switch-case

### Funktionen

- Quasi imperative Programmierparadigma

### Übung: REPL

### OO Intro

- Konzepte: Klasse, Attribut, Methode
- Accessors (public, private)
- Diff: Attribut, Parameter, Variable

### Konstruktoren

- Default-Konstruktor
- Parameterisierter Konstruktur

### this, Setter, Getter

### Referenzen

### UML (Übung: Klassen daraus erstellen & UML aus Klassen erstellen)

### JavaDoc
