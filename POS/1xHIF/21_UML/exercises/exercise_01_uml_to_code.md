# Exercise: UML → Code

Gegeben ist folgendes UML-Diagramm (als Text beschrieben):

```
+----------------+          +----------------+
|     Student    |          |     Course     |
+----------------+          +----------------+
| - name: String |*        1| - title: String|
| - id: int      |◄─────────| - teacher: Str |
| - grades: int[]|          | - maxStudents  |
+----------------+          +----------------+
| + Student(...) |          | + Course(...)  |
| + addGrade(int)|          | + getTitle()   |
| + getAvg():dbl |          | + addStudent() |
+----------------+          +----------------+
```

Schreibe den vollständigen Java-Code für beide Klassen.

## Klasse Student

- Attribute: name (String), id (int), grades (int[])
- Konstruktor: initialisiert name, id und ein leeres Array für grades
- Methode: `void addGrade(int grade)` — fügt eine Note hinzu (Werte 1-5)
- Methode: `double getAvg()` — berechnet den Notendurchschnitt
- Getter für name, id, grades

## Klasse Course

- Attribute: title (String), teacher (String), maxStudents (int), students (Student[])
- Konstruktor: initialisiert title, teacher, maxStudents und das Array
- Methode: `boolean addStudent(Student s)` — fügt einen Studenten hinzu (wenn Platz)
- Getter für title

## Test

Erzeuge 2-3 Studenten und einen Course. Füge die Studenten zum Course hinzu. Gib für jeden Studenten den Namen und die Noten aus.