DROP TABLE IF EXISTS ProductTypes;
CREATE TABLE ProductTypes (
   productTypeID        INT(9)         NOT NULL AUTO_INCREMENT,
   clothes              VARCHAR(45)    NOT NULL,
   colour               VARCHAR(15)    NOT NULL,
   style                VARCHAR(15)        NOT NULL,
   image                VARCHAR(45)        NOT NULL,
   size                 VARCHAR(4)        NOT NULL,

   PRIMARY KEY (productTypeID)
);


DROP TABLE IF EXISTS Products;
CREATE TABLE Products (
   productID            INT(9)         NOT NULL,
   productTypeID        INT(9)         NOT NULL,
   brand                VARCHAR(25)    NOT NULL,
   name                 VARCHAR(45)    NOT NULL,
   price                DECIMAL(5,2)   NOT NULL,
   stock                INT(11)        NOT NULL,

   PRIMARY KEY (productID)
);


DROP TABLE IF EXISTS Customers;
CREATE TABLE Customers (
   customerID           INT(9)         NOT NULL,
   username             VARCHAR(20)    NOT NULL,
   password             VARCHAR(20)    NOT NULL,
   name                 VARCHAR(20)    NOT NULL,
   surname              VARCHAR(25)    NOT NULL,
   deliveringAddress    VARCHAR(45)    NOT NULL,
   mailAddress          VARCHAR(45)    NOT NULL,
   telephone            INT(9)         NOT NULL,

   PRIMARY KEY (customerID)
);


DROP TABLE IF EXISTS ShoppingCarts;
CREATE TABLE ShoppingCart (
   customerID           INT(9)         NOT NULL,
   productID            INT(9)         NOT NULL,
   numItems             INT(3)         NOT NULL,
   
   FOREIGN KEY (customerID) references Customers(customerID),
   FOREIGN KEY (productID) references Products(productID),
   PRIMARY KEY (customerID, productID)
);


DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders (
   orderID              INT(9)         NOT NULL,
   customerID           INT(9)         NOT NULL,
   date                 DATE           NOT NULL,
   totalPrice           DECIMAL(9,2)   NOT NULL,

   FOREIGN KEY (customerID) references Customers(customerID),
   PRIMARY KEY (orderID)
);


DROP TABLE IF EXISTS OrderRecords;
CREATE TABLE OrderRecords (
   orderID              INT(9)         NOT NULL,
   orderRecordID        INT(3)         NOT NULL,
   productID            INT(9)         NOT NULL,
   numItems             INT(3)         NOT NULL,
   pricePerItem         DECIMAL(9,2)   NOT NULL,

   FOREIGN KEY (orderID) references Orders(orderID),
   FOREIGN KEY (productID) references Products(productID),
   PRIMARY KEY (orderID, orderRecordID)
);
