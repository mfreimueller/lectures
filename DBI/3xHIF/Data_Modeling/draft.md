# 3xHIF Data Modeling

The goal of data modeling class in 3rd grade is to introduce students to the chen notation and to give them
first hands on practice in modeling databases on a logical level. While the SQL part is moved into a separate 
sub-class, this class (data modeling) only focuses on the logical part of how to structure a data model, but 
focuses not on how to actually implement it.

All relevant resources that the students would receive as well, and that have been used in previous classes,
can be found under res/. Note, that some files are only given the students at a specific point in time, which
I noted under class structure and the specific lesson. This is to ensure that we don't overburden students with
too much information.

## Class Structure

Most of the lectures below have one exercise the students need to complete. The exercises have the same number
as the lecture (format: NN-Some_Name.pdf). Lesson number 7 has a task where students have to go to a real website
and figure out the data model from there.

### 00 Group work - Intro data modeling

### 01 - Diploma thesis example - first steps

### 02 - Diploma thesis DB - Conceptual data model (1:n)

### 03 - Bike Workshop- Conceptual data model (1:n)

### 04 - Serienverwaltung - Conceptual data model (1:n, n:m, Composite Key)

### 05 IS-A Relationship, min max notation

Students receive the "ERM-Logische Datenmodellierung" file here the first time.

### 06 min max notation

Students receive the "Min Max Notation" file here the first time.

### 07 weak entity

Students receive the "erm-weak-entity" file here the first time.

### 08 Equipment rental

First "real world" application of all the students learned thus far by having to go to https://www.zgonc.at/at/unternehmen/maschinenverleih and search the website, to understand and design a data model for the equipment rental process.

### 09 historization

Students receive the "dm-historization" file here the first time.

### 10 assoziative Entities, rekursive Beziehung, 3-Schichtenmodell

Students receive the "ANSI 3 Schichtenmodell" and "Gleichzeitig ES_RS.png" files here the first time.
This is a pure lecture, as students get to experience the 3 layer model themselves, using an erm file for MySQL workbench, 
the SQL script and an image of the data model.

### 11 Transformation ERM -> RM

Students are tasked to transform the ERM from 03 Bike Workshop into a relational model and the SQL script.

### 12 Transformation EER -> RM

Students receive the "Transformation ERM-RM Beispiele" and "Transformation ERModell_RelationaleModell" files here the first time.

### 13 Transformation EER -> RM

Show and explain to them the difference between identity/direct, rollup and rolldown mapping.