/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  1234
 * Created: 04/05/2021
 */

INSERT INTO USERTABLE (FIRSTNAME, LASTNAME, PASSWORD, DOB, PHONENUMBER, EMAILADDRESS)
VALUES 
('James', 'Hunt', '1234', '1992-05-26', '1832901', 'james.hunt@example.com'),
('Ashley', 'Cheng', '14512', '1990-09-12', '123213', 'ashley.cheng@example.com'),
('Gregory', 'Smith', '512', '1998-06-28', '23213', 'gregory.smith@example.com'),
('Fiona', 'Lee', '643', '1992-07-21', '5476758', 'fiona.lee@example.com'),
('Simone', 'Aster', '12747534', '1997-07-10', '456282', 'simone.aster@example.com');

INSERT INTO CUSTOMERTABLE (USERID, CUSTOMERID, ORDERID)
VALUES
(1000, 4000, 5000),
(1001, 4001, 5001),
(1002, 4002, 5002),
(1003, 4003, 5003),
(1004, 4004, 5004);

INSERT INTO ORDERTABLE (ORDERID, PRODUCTID, CUSTOMERID, PRODUCTNAME, PRODUCTQUANTITY, DATEORDERED, ORDERTOTAL)
VALUES
(5000, 3000, 4000, 'telephone', 2, '2021-06-02', 100.00),
(5001, 3001, 4001, 'headphones', 5, '2021-06-02', 50.00),
(5002, 3002, 4002, 'keyboard', 10, '2021-06-02', 10.00),
(5003, 3003, 4003, 'mouse', 3, '2021-06-02', 25.00),
(5004, 3004, 4004, 'tv', 1, '2021-06-02', 1500.00);

INSERT INTO PRODUCTTABLE (PRODUCTID, PRODUCTNAME, PRODUCTDESCRIPTION, PRODUCTCATEGORY, PRODUCTPRICE, PRODUCESTOCK)
VALUES
(3000, 'telephone', 'asdhakld', 'electronics', 60.00, 100),
(3001, 'headphones', 'asdhakld', 'electronics', 250.00, 321),
(3002, 'keyboard', 'asdhakld', 'electronics', 150.00, 123),
(3003, 'mouse', 'asdhakld', 'electronics', 12.00, 233),
(3004, 'tv', 'asdhakld', 'electronics', 1000.00, 222);

INSERT INTO PAYMENTTABLE (PAYMENT ID, ORDERID, PAYMENTTYPE)
VALUES
(8000, 5000, 1),
(8001, 5001, 1),
(8002, 5002, 2),
(8003, 5003, 1),
(8004, 5004, 2);