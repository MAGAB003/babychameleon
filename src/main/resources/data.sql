INSERT INTO Subscription (Name, Description, Img1, Img2, Img3, Img4, Age_Group, Theme, Price) VALUES ('Small package', 'Only the most necessary', '/img/subscriptions/newborn_small_1.jpg', '/img/subscriptions/newborn_small_2.jpg', '/img/subscriptions/newborn_small_3.jpg', '/img/subscriptions/newborn_small_4.jpg', 'NEWBORN', 'standard', 200);
INSERT INTO Subscription (Name, Description, Img1, Img2, Img3, Img4, Age_Group, Theme, Price) VALUES ('Complete package', 'Everything that your child will need', '/img/subscriptions/baby_complete_1.jpg','/img/subscriptions/baby_complete_2.jpg','/img/subscriptions/baby_complete_3.jpg','/img/subscriptions/baby_complete_4.jpg', 'BABY', 'standard', 300);

INSERT INTO Customer (First_Name, Last_Name, Email, Street_Address, Postal_Code, City, Country) VALUES ('Pippi', 'Långstrump', 'pippi@langstrump.com', 'Villavillekullavägen 2', '11111', 'LindgrenCity', 'Sweden');
INSERT INTO Customer (First_Name, Last_Name, Email, Street_Address, Postal_Code, City, Country) VALUES ('Anton', 'Svensson', 'anton@svensson.se', 'Katthult', '577 94', ' Lönneberga', 'Sweden');

INSERT INTO Child (Name, Birthdate, Wears_Dress, Favorite_Color, ParentID, SubscriptionID) VALUES ('Emil', '2014-12-14', 0, 'Blue', (SELECT id FROM Customer WHERE First_Name='Anton' AND Last_Name='Svensson'), (SELECT id FROM Subscription WHERE Name='Small package'));

INSERT INTO BabyChameleonUser (Username, Password) VALUES ('user', '$2a$11$8It8N/w53Kb9vm.BlsA2i.Rfwit5KsIyJ.YD5I8oHHcdApF1c5EXS');
