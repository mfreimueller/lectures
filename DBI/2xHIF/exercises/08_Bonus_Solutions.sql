-- Task 1

SELECT
	l.L_Nr AS teacher,
	l.L_Vorname + ' ' + l.L_Name AS name, 
	COALESCE(COUNT(k.K_Nr), 0) AS class_count
FROM Lehrer l
	LEFT JOIN Klasse k ON k.K_Vorstand = l.L_Nr
GROUP BY l.L_Nr, l.L_Vorname, l.L_Name
ORDER BY l.l_Nr;

-- Task 2

SELECT g.Ges_Mw AS gender, COALESCE(COUNT(l.L_Nr), 0) AS no_teachers
-- We need to go from Geschlecht to Lehrer, as we also want to show Geschlechter that 
-- 		aren't in use currently.
FROM Geschlecht g
	LEFT JOIN Lehrer l ON l.L_Geschlecht = g.Ges_ID
GROUP BY g.Ges_Mw; -- "Display L_Geschlecht" doesn't make sense, as there mustn't always be teacher for a gender

-- Task 3

SELECT sja.Sja_Nr AS school_term, COUNT(k.K_Nr) AS no_classes
FROM Schuljahr sja
	LEFT JOIN Klasse k ON k.K_Schuljahr = sja.Sja_Nr
GROUP BY sja.Sja_Nr;

-- Task 4

SELECT a.Abt_Name, COALESCE(COUNT(s.S_Nr), 0) AS no_students
FROM Abteilung a
	LEFT JOIN Klasse k ON k.K_Abteilung = a.Abt_Nr
	LEFT JOIN Schueler s ON s.S_Klasse = k.K_Nr
GROUP BY a.Abt_Name;

-- Task 5

SELECT g.G_Bez AS subject, COALESCE(AVG(p.P_Note), 0) AS avg_grade
FROM Gegenstand g
	LEFT JOIN Pruefung p ON p.P_Gegenstand = g.G_Nr
GROUP BY g.G_Bez;

-- Task 6

SELECT s.S_Vorname + ' ' + s.S_Zuname AS student, COUNT(p.P_DatumZeit) AS no_exams
FROM Schueler s
	LEFT JOIN Pruefung p ON p.P_Kandidat = s.S_Nr
WHERE p.P_Note <= 2
GROUP BY s.S_Vorname, s.S_Zuname;