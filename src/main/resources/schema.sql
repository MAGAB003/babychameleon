CREATE TABLE Customer(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
First_Name VARCHAR(50) NOT NULL,
Last_Name VARCHAR(50) NOT NULL,
Email VARCHAR(50),
Street_Address VARCHAR(50),
Postal_Code VARCHAR(50),
City VARCHAR(50),
Country VARCHAR(50),
Credit_Card_Number VARCHAR(50),
Card_Expiration_Date VARCHAR(50),
Cvv_Code VARCHAR(50)
);

CREATE TABLE Admin(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
FirstName VARCHAR(50) NOT NULL,
LastName VARCHAR(50) NOT NULL,
Email VARCHAR(50) NOT NULL
);

CREATE TABLE Subscription(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(50) NOT NULL,
Description VARCHAR(80) NOT NULL,
Img1 VARCHAR(50) NOT NULL,
Img2 VARCHAR(50) NOT NULL,
Img3 VARCHAR(50) NOT NULL,
Img4 VARCHAR(50) NOT NULL,
Age_Group VARCHAR(50) NOT NULL,
Theme VARCHAR(50) NOT NULL,
Price INT NOT NULL
);

CREATE TABLE BabyChameleonUser(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
Username VARCHAR(50) NOT NULL,
Password VARCHAR(100) NOT NULL,
CustomerID VARCHAR(50),
AdminID BIGINT
);

CREATE TABLE Child(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(50) NOT NULL,
Birthdate VARCHAR(50) NOT NULL,
Starting_Size VARCHAR(50),
Wears_Dress BIT,
Favorite_Color VARCHAR(50),
ParentID BIGINT NOT NULL,
SubscriptionID BIGINT
);


ALTER TABLE BabyChameleonUser ADD FOREIGN KEY (CustomerID) REFERENCES Customer(ID);
ALTER TABLE BabyChameleonUser ADD FOREIGN KEY (AdminID) REFERENCES Admin(ID);
ALTER TABLE Child ADD FOREIGN KEY (ParentID) REFERENCES Customer(ID);
ALTER TABLE Child ADD FOREIGN KEY (SubscriptionID) REFERENCES Subscription(ID);