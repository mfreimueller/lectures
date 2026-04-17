-- Version 1

INSERT INTO Customers(CustomerID, Name, Street, Postalcode, City, Phone, Email) VALUES
	(1, 'Anna Müller', 'Hauptstraße 12', '80331', 'München', '089 1234567', 'anna.mueller@mail.de'),
	(2, 'Peter Schmidt', 'Lindenweg 5', '10115', 'Berlin', '030 9876543', 'p.schmidt@mail.de'),
	(3, 'Laura Keller', 'Bahnhofstraße 8', '50667', 'Köln', '0221 5558899', 'laura.keller@mail.de'),
	(4, 'Tobias Weber', 'Schulweg 3', '20095', 'Hamburg', '040 33445566', 'tobias.weber@mail.de');

INSERT INTO Products(ProductID, Name, ProductGroup, Price, Amount) VALUES
(1, 'Laptop Pro 15', 'Elektronik', 1499.00, 2),
(2, 'Wireless Mouse', 'Zubehör', 29.90, 20),
(3, 'Office Chair', 'Möbel', 249.00, 5);


INSERT INTO Orders(OrderID, CustomerID, [Date], Status, DeliveryDate) VALUES
(1, 1, '2025-03-01', 'bestellt', '2025-03-05'),
(2, 2, '2025-03-02', 'geliefert', '2025-03-06'),
(3, 1, '2025-03-05', 'offen', NULL);

INSERT INTO OrderPositions(PositionID, OrderID, ProductID, Amount, Price) VALUES
(1, 1, 1, 1, 1499.00),
(2, 1, 2, 1, 29.90),
(3, 2, 3, 2, 249.00),
(4, 3, 2, 2, 29.90);

-- Version 2

UPDATE Customers
	SET Street = 'Schulstraße 3'
	WHERE CustomerID = 4;

UPDATE Products
	SET Name = 'Office Chair Deluxe', Amount = 1
	WHERE ProductID = 3;

UPDATE Orders
	SET Status = 'geliefert', DeliveryDate = '2025-03-09'
	WHERE OrderID = 1;

UPDATE Orders
	SET DeliveryDate = '2025-03-10'
	WHERE OrderID = 3;

-- Version 3

DELETE FROM Customers WHERE Name = 'Laura Keller';

-- to remove the order, we have to remove any rows referencing it via foreign keys first
DELETE FROM OrderPositions
	WHERE OrderID = (
		SELECT OrderID
		FROM Orders
		WHERE
			[Date] = '2025-03-05' AND
			CustomerID = (SELECT CustomerID FROM Customers WHERE Name = 'Anna Müller')
	);

DELETE FROM Orders
	WHERE
		[Date] = '2025-03-05' AND
		CustomerID = (SELECT CustomerID FROM Customers WHERE Name = 'Anna Müller');