CREATE DATABASE business_db;

-- Part 1:

CREATE TABLE Customers (
	CustomerID INT PRIMARY KEY,
	Name VARCHAR(128) NOT NULL,
	Street VARCHAR(256) NOT NULL,
	Postalcode CHAR(6) NOT NULL,
	City VARCHAR(256) NOT NULL,
	Phone VARCHAR(16) UNIQUE
);

CREATE TABLE Products (
	ProductID INT PRIMARY KEY,
	Name VARCHAR(256) NOT NULL,
	Category VARCHAR(256),
	Price DECIMAL NOT NULL,
	Amount INT
);

CREATE TABLE Orders (
	OrderID INT PRIMARY KEY,
	CustomerID INT REFERENCES Customers(CustomerID),
	Date DATETIME2 NOT NULL,
	Status CHAR(12)
);

CREATE TABLE OrderPositions(
	PositionID INT PRIMARY KEY,
	OrderID INT REFERENCES Orders(OrderID),
	ProductID INT REFERENCES Products(ProductID),
	Amount INT NOT NULL,
	Price DECIMAL NOT NULL
);

-- Part 2:

ALTER TABLE Customers
	ADD Email VARCHAR(64) UNIQUE;

ALTER TABLE Products DROP COLUMN Category;
ALTER TABLE Products ADD ProductGroup VARCHAR(256);

ALTER TABLE Orders
	ADD DeliveryDate DATETIME2;

-- Part 3:
-- Given that OrderPositions has a foreign key constraint on Orders, we have two
-- 		options: drop OrderPositions as well, or alter the table to remove the
--		constraint. Because it doesn't make sense to have order positions without
--		orders, we choose the first approach.
-- Using an Oracle Database, you could add CASCADE CONSTRAINTS to the drop table
--		statement to remove any conflicting constraints automatically.

DROP TABLE OrderPositions;
DROP TABLE Orders;




