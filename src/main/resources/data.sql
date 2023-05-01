CREATE TABLE account (
  accountId integer PRIMARY KEY,
  firstName varchar(255),
  lastName varchar(255),
  phoneNumber varchar(255),
  email varchar(255),
  password varchar(255),
  role varchar(255)
);

CREATE TABLE reservation (
  reservationId integer PRIMARY KEY,
  customerId integer,
  tableId integer,
  startTime DATETIME,
  startDate DATE,
  addBabyChair boolean
);

CREATE TABLE customer (
  customerId integer PRIMARY KEY,
  paymentId integer,
  firstName varchar(255),
  lastName varchar(255),
  phoneNumber varchar(255),
  email varchar(255),
  address varchar(255),
  isGuest boolean
  );

CREATE TABLE tables (
  tableId integer PRIMARY KEY,
  seat integer,
  isMergeable boolean,
  isAvailable boolean
);

CREATE TABLE orders (
  orderId integer PRIMARY KEY,
  customerId integer,
  menuItemId integer,
  orderDate date,
  orderTime datetime
);

CREATE TABLE menuItem (
  menuItemId integer PRIMARY KEY,
  itemName varchar(255),
  type varchar(255),
  description varchar(255),
  price double,
  isAlcoholic boolean,
  imagePath varchar(255)
);

CREATE TABLE paymentMethod (
  paymentId integer PRIMARY KEY,
  description varchar(255)
);
INSERT INTO account (accountId, firstName, lastName, phoneNumber, email, password, role)
VALUES (1234, 'John', 'Doe', '555-555-1234', 'johndoe@email.com', 'password123', 'user');
INSERT INTO account (accountId, firstName, lastName, phoneNumber, email, password, role)
VALUES (91011, 'Bob', 'Smith', '555-555-9101', 'bobsmith@email.com', 'password789', 'user');
INSERT INTO account (accountId, firstName, lastName, phoneNumber, email, password, role)
VALUES (121314, 'Alice', 'Johnson', '555-555-1213', 'alicejohnson@email.com', 'password101112', 'admin');

INSERT INTO reservation (reservationId, customerId, tableId, startTime, startDate)
VALUES (1, 123, 4, '2023-05-01 18:30:00', '2023-05-01');
INSERT INTO reservation (reservationId, customerId, tableId, startTime, startDate)
VALUES (2, 456, 2, '2023-05-02 19:00:00', '2023-05-02');
INSERT INTO reservation (reservationId, customerId, tableId, startTime, startDate)
VALUES (3, 789, 6, '2023-05-03 20:30:00', '2023-05-03');


INSERT INTO customer (customerId, paymentId, firstName, lastName, phoneNumber, email, address, isGuest)
VALUES
(1, 101, 'John', 'Doe', '555-555-1234', 'johndoe@email.com', '123 Main St, Anytown USA', false),
(2, 102, 'Jane', 'Smith', '555-555-5678', 'janesmith@email.com', '456 Elm St, Anytown USA', false),
(3, 103, 'Bob', 'Johnson', '555-555-9101', 'bobjohnson@email.com', '789 Oak St, Anytown USA', false),
(4, NULL, 'Sarah', 'Lee', '555-555-1212', 'sarahlee@email.com', '321 Maple St, Anytown USA', true),
(5, NULL, 'Mark', 'Johnson', NULL, 'markjohnson@email.com', '10 Pine St, Anytown USA', true);

INSERT INTO tables (tableId, seat, isMergeable, isAvailable)
VALUES (1, 4, true, true);
INSERT INTO tables (tableId, seat, isMergeable, isAvailable)
VALUES (2, 6, false, true);
INSERT INTO tables (tableId, seat, isMergeable, isAvailable)
VALUES (3, 2, true, false);
INSERT INTO tables (tableId, seat, isMergeable, isAvailable)
VALUES (4, 8, true, true);
INSERT INTO tables (tableId, seat, isMergeable, isAvailable)
VALUES (5, 4, false, false);

INSERT INTO menuItem (menuItemId, itemName, type, description, price, isAlcoholic, imagePath)
VALUES (1, 'Classic Margherita Pizza', 'Pizza', 'Tomato sauce, mozzarella cheese, and basil leaves', 10.99, false, '/images/margherita.jpg');
INSERT INTO menuItem (menuItemId, itemName, type, description, price, isAlcoholic, imagePath)
VALUES (2, 'Chicken Alfredo Pasta', 'Pasta', 'Fettuccine pasta in a creamy Alfredo sauce with grilled chicken', 13.99, false, '/images/chicken-alfredo.jpg');
INSERT INTO menuItem (menuItemId, itemName, type, description, price, isAlcoholic, imagePath)
VALUES (3, 'Grilled Salmon', 'Seafood', 'Grilled Atlantic salmon fillet with lemon butter sauce, served with roasted vegetables and mashed potatoes', 18.99, false, '/images/grilled-salmon.jpg');
INSERT INTO menuItem (menuItemId, itemName, type, description, price, isAlcoholic, imagePath)
VALUES (4, 'Mojito', 'Cocktail', 'A classic Cuban cocktail made with fresh mint, lime juice, sugar, and white rum', 8.99, true, '/images/mojito.jpg');
INSERT INTO menuItem (menuItemId, itemName, type, description, price, isAlcoholic, imagePath)
VALUES (5, 'Tiramisu', 'Dessert', 'Layers of ladyfingers soaked in espresso and Marsala wine, with mascarpone cheese and cocoa powder', 6.99, false, '/images/tiramisu.jpg');

INSERT INTO paymentMethod (paymentId, description) VALUES (1, 'credit card');
INSERT INTO paymentMethod (paymentId, description) VALUES (2, 'Alipay');
INSERT INTO paymentMethod (paymentId, description) VALUES (3, 'cash');

INSERT INTO menuItem (menuItemId, itemName, type, description, price, isAlcoholic, imagePath)
VALUES (7, 'Hamburger', 'Hamburger Mushroom', 'Mushroom, cheddar, and meat', 15.99, false, '/images/Mushroom.jpg');
