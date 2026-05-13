-- Database setup for JDBC katas
-- Run with: psql -U postgres -f init.sql

CREATE DATABASE school;

\c school;

-- Student table for CRUD and transaction exercises
CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    grade INT DEFAULT 1
);

-- Seed data for K3 (transactions: duplicate email test)
INSERT INTO student (name, email, grade) VALUES ('Alice', 'alice@school.com', 1);
INSERT INTO student (name, email, grade) VALUES ('Bob', 'bob@school.com', 2);
INSERT INTO student (name, email, grade) VALUES ('Charlie', 'charlie@school.com', 1);
