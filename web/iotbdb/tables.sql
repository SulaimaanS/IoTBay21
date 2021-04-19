CREATE TABLE PRODUCTTABLE(
    productID int NOT NULL, 
    "name" varchar(30) NOT NULL,
    description varchar(100),
    category varchar(30),
    price float(10),
    stock int,
    PRIMARY KEY (productID)
);