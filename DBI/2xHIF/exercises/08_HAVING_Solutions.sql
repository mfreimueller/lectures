-- Task 1

SELECT k.K_Nr AS class, COUNT(st.St_Stunde) AS count
FROM Klasse k
	LEFT JOIN Stunde st ON st.St_Klasse = k.K_Nr
GROUP BY k.K_Nr;

-- Task 2

SELECT l.L_Name AS name, COUNT(st.St_Stunde) AS count
FROM Lehrer l
	-- here, inner join makes sense, as we only want teacher that actually teach lessons
	INNER JOIN Stunde st ON st.St_Lehrer = l.L_Nr
GROUP BY l.L_Name
	HAVING COUNT(st.St_Stunde) > 10;

-- Task 3

-- NOTE: the way this task is given doesn't make sense for what we've learned so far.
-- 		The obvious solution would be (although this gives us not one but multiple rows in return):
SELECT
	(SELECT COUNT(p2.P_DatumZeit) FROM Pruefung p2 WHERE p2.P_Note = 1) AS A,
	(SELECT COUNT(p2.P_DatumZeit) FROM Pruefung p2 WHERE p2.P_Note = 2) AS B,
	(SELECT COUNT(p2.P_DatumZeit) FROM Pruefung p2 WHERE p2.P_Note = 3) AS C,
	(SELECT COUNT(p2.P_DatumZeit) FROM Pruefung p2 WHERE p2.P_Note = 4) AS D,
	(SELECT COUNT(p2.P_DatumZeit) FROM Pruefung p2 WHERE p2.P_Note = 5) AS F
FROM Pruefung p;

-- This makes more sense:
SELECT
	COUNT(CASE WHEN p.P_Note = 1 THEN 1 ELSE NULL END) AS A,
	COUNT(CASE WHEN p.P_Note = 1 THEN 2 ELSE NULL END) AS B,
	COUNT(CASE WHEN p.P_Note = 1 THEN 3 ELSE NULL END) AS C,
	COUNT(CASE WHEN p.P_Note = 1 THEN 4 ELSE NULL END) AS D,
	COUNT(CASE WHEN p.P_Note = 1 THEN 5 ELSE NULL END) AS F
FROM Pruefung p;

-- Task 4

SELECT
	COALESCE(L_Chef, '???') AS head_teacher, 
	COUNT(l.L_Nr) AS subordinates,
	AVG(l.L_Gehalt) AS avg_salary,
	AVG(DATEDIFF(YEAR, l.L_Gebdat, GETDATE())) AS avg_age
FROM Lehrer l
GROUP BY l.L_Chef;

-- Task 5

SELECT s.St_Tag AS weekday, COUNT(s.St_Stunde) AS no_lessons
FROM Stunde s
GROUP BY s.St_Tag
ORDER BY s.St_Tag;