DROP TABLE IF EXISTS ShoppingCarts;
CREATE TABLE ShoppingCart (
   workerID          INT(11)           NOT NULL,
   productID         VARCHAR(45)       NOT NULL,
   stock             INT(4)            NOT NULL
   //orderID         DATE              NOT NULL ???
);


DROP TABLE IF EXISTS SaleRecords;
CREATE TABLE RecordSale (
   workerID          INT(11)           NOT NULL,
   productID         INT(11)           NOT NULL,
   date              DATE              NOT NULL,
   numItems          DECIMAL(20,2)     NOT NULL,
   orderID           INT(11)           NOT NULL
);


DROP TABLE IF EXISTS Products;
CREATE TABLE Products` (
   productID         INT(11)           NOT NULL,
   productTypeID     INT(11)           NOT NULL,
   price             DECIMAL(X)        NOT NULL,
   name              VARCHAR(45)       NOT NULL,
   brand             VARCHAR(45)       NOT NULL,
   stock             INT(11)           NOT NULL,

   PRIMARY KEY (productID)
);


DROP TABLE IF EXISTS Workers;
CREATE TABLE Workers (
   workerID          INT(11)           NOT NULL,
   name              VARCHAR(45)       NOT NULL,
   mail              VARCHAR(45)       NOT NULL,
   telephone         INT(9)            NOT NULL,
   direction         VARCHAR(45)       NOT NULL,
   password          VARCHAR(45)       NOT NULL,
   type              ENUM()            NOT NULL,
   
   PRIMARY KEY (workerID)
);


DROP TABLE IF EXISTS ProductTypes;
CREATE TABLE ProductTypes (
  productTypeID      INT(11)           NOT NULL AUTO_INCREMENT,
  clothes            VARCHAR(45)       NOT NULL,
  colour             VARCHAR(45)       NOT NULL,
  style              VARCHAR           NOT NULL,
  image              VARCHAR           NOT NULL,
  size               VARCHAR           NOT NULL,

  PRIMARY KEY (productTypeID)
);
