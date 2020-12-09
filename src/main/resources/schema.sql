CREATE TABLE Customer(
CustomerID VARCHAR AUTOINCREMENT PRIMARY KEY,
CustomerFirstName VARCHAR(50) NOT NULL,
CustomerLastName VARCHAR(50) NOT NULL,
CustomerEmail VARCHAR(50) NOT NULL,
CustomerStreetAddress VARCHAR(50) NOT NULL,
PostalCode VARCHAR(50) NOT NULL,
City VARCHAR(50) NOT NULL,
CreditCardNumber INT,
CreditCardExpirationDate VARCHAR(50),
CvvCode INT,
IDCounter INT NOT NULL
);

CREATE TABLE Subscription(
SubscriptionID VARCHAR AUTOINCREMENT PRIMARY KEY,
SubscriptionName VARCHAR(50) NOT NULL,
SubscriptionDescription VARCHAR(50) NOT NULL,
ImgID VARCHAR(50) NOT NULL,
AgeGroup VARCHAR(50) NOT NULL,
Theme VARCHAR(50) NOT NULL,
);

)