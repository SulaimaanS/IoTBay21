<<<<<<< HEAD
CREATE TABLE USERTABLE(
    userID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
=======
/*SCRIPT TO EXECUTE TO CREATE ALL TABLES NEEDED FOR IOTBAY DATABASE*/
CREATE TABLE USERTABLE(
    userID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1000, INCREMENT BY 1), 
>>>>>>> 74a5f79779ad2c549c76c1a35812c5009cf9fa8c
    firstName varchar(30) NOT NULL,
    lastName varchar(30) NOT NULL,
    emailAddress varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
<<<<<<< HEAD
    phoneNumber varchar(20) NOT NULL,
    PRIMARY KEY (userID)
);
CREATE TABLE CUSTOMERTABLE(
    customerID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    userID int NOT NULL, 
    dob date NOT NULL,
    streetNumber int,
    streetName varchar(20),
    postCode int NOT NULL,
    registered boolean,
    PRIMARY KEY (customerID),
    FOREIGN KEY (userID) REFERENCES USERTABLE(userID)
);
CREATE TABLE STAFFTABLE(
    userID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    staffID int NOT NULL,
    PRIMARY KEY (staffID),
    FOREIGN KEY (userID) REFERENCES USERTABLE(userID)
);
CREATE TABLE APPLICATIONLOGTABLE(
    LogID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    userID int NOT NULL,
    staffID int NOT NULL,
    accessed date NOT NULL,
    PRIMARY KEY (LogID),
    FOREIGN KEY (userID) REFERENCES USERTABLE(userID),
    FOREIGN KEY (staffID) REFERENCES STAFFTABLE(staffID)
);

CREATE TABLE ORDERTABLE(
    orderID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
    customerID int NOT NULL,
=======
    dob date NOT NULL,
    gender varchar(15) NOT NULL,
    phoneNumber varchar(20) NOT NULL,
    streetNumber int,
    streetName varchar(20),
    postCode int,
    PRIMARY KEY (userID)
);

CREATE TABLE STAFFTABLE(
    userID int NOT NULL, 
    staffID int NOT NULL,
    authorised boolean,
    PRIMARY KEY (staffID),
    FOREIGN KEY (userID) REFERENCES USERTABLE(userID)
);

CREATE TABLE APPLICATIONLOGTABLE(
    LogID int NOT NULL,
    userID int NOT NULL, 
    PRIMARY KEY (LogID),
    FOREIGN KEY (userID) REFERENCES USERTABLE(userID),
);

CREATE TABLE CUSTOMERTABLE(
    userID int NOT NULL, 
    customerID int NOT NULL,
    orderID int NOT NULL,
    registered boolean,
    PRIMARY KEY (customerID),
    FOREIGN KEY (userID) REFERENCES USERTABLE(userID)
);

CREATE TABLE ORDERLINETABLE(
    orderID int NOT NULL, 
    productID int NOT NULL,
    PRIMARY KEY (orderID,productID)
);

CREATE TABLE ORDERTABLE(
    orderID int NOT NULL, 
    productID int NOT NULL,
    customerID int NOT NULL,
    productName varchar(50) NOT NULL,
    productQuantity int NOT NULL,
>>>>>>> 74a5f79779ad2c549c76c1a35812c5009cf9fa8c
    dateOrdered date NOT NULL,
    orderTotal float NOT NULL,
    PRIMARY KEY (orderID),
    FOREIGN KEY (customerID) REFERENCES CUSTOMERTABLE(customerID)
);
<<<<<<< HEAD

CREATE TABLE PRODUCTTABLE(
    productID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
    productName varchar(50) NOT NULL,
    productDescription varchar(50) NOT NULL,
    productCategory varchar(30) NOT NULL,
    productPrice float NOT NULL,
    productStock int,
    PRIMARY KEY (productID)
);

CREATE TABLE ORDERLINETABLE(
    orderID int NOT NULL, 
    productID int NOT NULL,
    quantity int NOT NULL,
    PRIMARY KEY (orderID,productID),
    FOREIGN KEY (orderID) REFERENCES ORDERTABLE(orderID),
    FOREIGN KEY (productID) REFERENCES PRODUCTTABLE(productID)
);

CREATE TABLE INVOICETABLE(
    customerID int NOT NULL, 
=======
ALTER TABLE CUSTOMERTABLE
ADD FOREIGN KEY (orderID) REFERENCES ORDERTABLE(orderID);

CREATE TABLE PRODUCTTABLE(
    productID int NOT NULL, 
    productName varchar(50) NOT NULL,
    productCategory varchar(30) NOT NULL,
    productPrice float NOT NULL,
    productStock int NOT NULL,
    PRIMARY KEY (productID),
);
ALTER TABLE ORDERTABLE
ADD FOREIGN KEY (productID) REFERENCES ORDERLINETABLE(productID);

ALTER TABLE ORDERLINETABLE
ADD FOREIGN KEY (orderID) REFERENCES ORDERTABLE(orderID),
ADD FOREIGN KEY (productID) REFERENCES PRODUCTTABLE(productID);

CREATE TABLE INVOICETABLE(
    invoiceID int NOT NULL, 
>>>>>>> 74a5f79779ad2c549c76c1a35812c5009cf9fa8c
    orderID int NOT NULL,
    productName varchar(50) NOT NULL,
    productQuantity int NOT NULL,
    dateOrdered date NOT NULL,
    orderTotal float NOT NULL,
<<<<<<< HEAD
    billingAddress varchar(100) NOT NULL,
    PRIMARY KEY (customerID, orderID),
    FOREIGN KEY (customerID) REFERENCES CUSTOMERTABLE(customerID),
=======
    deliveryAddress varchar(100) NOT NULL,
    billingAddress varchar(100) NOT NULL,
    PRIMARY KEY (invoiceID),
>>>>>>> 74a5f79779ad2c549c76c1a35812c5009cf9fa8c
    FOREIGN KEY (orderID) REFERENCES ORDERTABLE(orderID)
);

CREATE TABLE PAYMENTTABLE(
<<<<<<< HEAD
    paymentID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
    orderID int NOT NULL,
    paymentType int NOT NULL, /*1 is credit card, 2 is paypal*/
=======
    paymentID int NOT NULL, 
    orderID int NOT NULL,
    paymentType int NOT NULL,
>>>>>>> 74a5f79779ad2c549c76c1a35812c5009cf9fa8c
    PRIMARY KEY (paymentID),
    FOREIGN KEY (orderID) REFERENCES ORDERTABLE(orderID)
);

<<<<<<< HEAD
CREATE TABLE CREDITCARDTABLE(
    paymentID int NOT NULL,
    CardID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
=======
CREATE TABLE SHIPPINGTABLE(
    shipmentID int NOT NULL, 
    orderID int NOT NULL,
    shippingToken varchar(1000) NOT NULL,
    PRIMARY KEY (shipmentID),
    FOREIGN KEY (orderID) REFERENCES ORDERTABLE(orderID)
);

CREATE TABLE CREDITCARDTABLE(
    paymentID int NOT NULL,
    CardID int NOT NULL, 
>>>>>>> 74a5f79779ad2c549c76c1a35812c5009cf9fa8c
    cardNumber varchar(40) NOT NULL,
    expiryDate date NOT NULL,
    holderName varchar(50) NOT NULL,
    CVV int NOT NULL,
    PRIMARY KEY (CardID),
    FOREIGN KEY (paymentID) REFERENCES PAYMENTTABLE(paymentID)
);

CREATE TABLE PAYPALTABLE(
<<<<<<< HEAD
    paypalID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
=======
    paypalID int NOT NULL, 
>>>>>>> 74a5f79779ad2c549c76c1a35812c5009cf9fa8c
    paymentID int NOT NULL,
    paypalToken varchar(200) NOT NULL,
    PRIMARY KEY (paypalID),
    FOREIGN KEY (paymentID) REFERENCES PAYMENTTABLE(paymentID)
);
<<<<<<< HEAD

CREATE TABLE SHIPPINGTABLE(
    shipmentID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
    orderID int NOT NULL,
    shippingToken varchar(1000) NOT NULL,
    PRIMARY KEY (shipmentID),
    FOREIGN KEY (orderID) REFERENCES ORDERTABLE(orderID)
);
=======
>>>>>>> 74a5f79779ad2c549c76c1a35812c5009cf9fa8c
