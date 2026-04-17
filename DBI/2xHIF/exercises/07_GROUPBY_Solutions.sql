-- Task 1

SELECT COUNT(k.K_Nr) AS number_classes, sj.Sja_Nr AS school_term
FROM Schuljahr sj
	LEFT JOIN Klasse k ON k.K_Schuljahr = sj.Sja_Nr
GROUP BY sj.Sja_Nr;

-- Task 2

SELECT COUNT(s.S_Nr) AS count, COALESCE(s.S_Postleitzahl, -1) AS Postalcode
FROM Schueler s
WHERE s.S_Geschlecht = (SELECT Ges_ID FROM Geschlecht WHERE Ges_Mw = 'm')
GROUP BY s.S_Postleitzahl;

-- Task 3

SELECT 
	k.K_Nr AS class,
	MIN(s.S_Zuname) AS first_student,
	MAX(s.S_Zuname) AS last_student,
	MIN(s.S_Gebdatum) AS oldest_student,
	MAX(s.S_Gebdatum) AS youngest_student
FROM Klasse k
INNER JOIN Schueler s ON s.S_Klasse = k.K_Nr
GROUP BY k.K_Nr;

-- Task 4
-- Note: simply grouping Schueler by S_Klasse doesn't work, because
--		this way we exclude any empty classes (as we can only group
--		students by classes that are entered in S_Klasse).

SELECT COUNT(s.S_Nr) AS student_count, k.K_Nr AS class
FROM Klasse k
	LEFT JOIN Schueler s ON s.S_Klasse = k.K_Nr
GROUP BY k.K_Nr;

-- Task 5

SELECT COALESCE(s.S_Gebdatum, '1970-01-01') AS birthdate, COUNT(s.S_Nr) AS count 
FROM Schueler s
GROUP BY s.S_Gebdatum
	HAVING COUNT(s.S_Nr) > 1;

-- Task 6

SELECT
	k.K_Nr AS class,
	(
		SELECT COUNT(s.S_Nr)
		FROM Schueler s
		WHERE s.S_Klasse = k.K_Nr AND s.S_Geschlecht = 1
	) AS no_male_students,
	(
		SELECT COUNT(s.S_Nr)
		FROM Schueler s
		WHERE s.S_Klasse = k.K_Nr AND s.S_Geschlecht = 2
	) AS no_female_students
FROM Klasse k;
