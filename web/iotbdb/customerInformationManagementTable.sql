/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  timmy
 * Created: 15/05/2021
 */
/*
SELECT 
CUSTOMERTABLE.CUSTOMERID, CUSTOMERTABLE.CUSTOMERTYPE,
USERTABLE.FIRSTNAME, USERTABLE.LASTNAME, USERTABLE.DOB, USERTABLE.GENDER, USERTABLE.EMAILADDRESS, 
USERTABLE.PASSWORD, USERTABLE.PHONENUMBER, USERTABLE.STREETNUMBER, USERTABLE.STREETNAME, USERTABLE.POSTCODE,
CUSTOMERTABLE.ORDERID, CUSTOMERTABLE.REGISTERED
FROM USERTABLE
INNER JOIN CUSTOMERTABLE ON USERTABLE.USERID = CUSTOMERTABLE.USERID
WHERE USERTABLE.FIRSTNAME = 'Jim'
AND USERTABLE.LASTNAME = 'Neil' AND CUSTOMERTABLE.CUSTOMERTYPE = 'Individual';
*/

CREATE TABLE CUSTOMERINFORMATIONMANAGEMENTTABLE(
    CUSTOMERID varchar(20),
    CUSTOMERTYPE varchar(20),
    FIRSTNAME varchar(30),
    LASTNAME varchar(30),
    DOB varchar(20),
    GENDER varchar(8),
    EMAILADDRESS varchar(50),
    PASSWORD varchar(50),
    PHONENUMBER varchar(20),
    STREETNUMBER varchar(10),
    STREETNAME varchar(20),
    POSTCODE varchar(10),
    ORDERID varchar(20),
    REGISTERED varchar(10)
);
/*
INSERT INTO CUSTOMERINFORMATIONMANAGEMENT
(CUSTOMERID, CUSTOMERTYPE, FIRSTNAME, LASTNAME, DOB, GENDER, EMAILADDRESS, PASSWORD, PHONENUMBER,
STREETNUMBER, STREETNAME, POSTCODE, ORDERID, REGISTERED)
VALUES 
(1, 'Individual', 'John', 'Seed', '02/02/2020', 'Male', 'somethin@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 1, true),
(2, 'Company', 'Ron', 'Seed', '02/02/2020', 'Male', 'ron@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 2, true),
(3, 'Individual', 'Tom', 'See', '02/02/2020', 'Male', 'tom@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 3, true),
(4, 'Individual', 'Joh', 'Sed', '02/02/2020', 'Male', 'joh@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 4, false),
(5, 'Company', 'Ohn', 'Eed', '02/02/2020', 'Male', 'ohn@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 5, true),
(6, 'Company', 'Jhn', 'Seed', '02/02/2020', 'Male', 'jhn@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 7, true),
(12, 'Individual', 'Joseph', 'Seesd', '02/02/2020', 'Male', 'joseph@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 6, true),
(13, 'Individual', 'Joshua', 'Sesed', '02/02/2020', 'Male', 'joshua@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 7, true),
(14, 'Individual', 'Jeremy', 'Sseed', '02/02/2020', 'Male', 'jeremy@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 8, true),
(15, 'Company', 'James', 'Seeddd', '02/02/2020', 'Male', 'james@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 9, true ),
(16, 'Company', 'Jam', 'Seed', '02/02/2020', 'Male', 'jam@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 10, true),
(17, 'Individual', 'Joel', 'Sed', '02/02/2020', 'Male', 'joel@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 11, true),
(18, 'Company', 'Rohn', 'Sede', '02/02/2020', 'Male', 'Rohn@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 12, true),
(19, 'Individual', 'jom', 'Seedee', '02/02/2020', 'Male', 'jom@email.com', 'password',  '123123123',  23 , 'phlips street', 1233, 13, true);
*/

INSERT INTO CUSTOMERINFORMATIONMANAGEMENTTABLE
(CUSTOMERID, CUSTOMERTYPE, FIRSTNAME, LASTNAME, DOB, GENDER, EMAILADDRESS, PASSWORD, PHONENUMBER,
STREETNUMBER, STREETNAME, POSTCODE, ORDERID, REGISTERED)
VALUES 
('1', 'Individual', 'John', 'Seed', '02/02/2020', 'Male', 'somethin@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '1', 'true'),
('2', 'Company', 'Ron', 'Seed', '02/02/2020', 'Male', 'ron@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '2', 'true'),
('3', 'Individual', 'Tom', 'See', '02/02/2020', 'Male', 'tom@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '3', 'true'),
('4', 'Individual', 'Joh', 'Sed', '02/02/2020', 'Male', 'joh@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '4', 'false'),
('5', 'Company', 'Ohn', 'Eed', '02/02/2020', 'Male', 'ohn@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '5', 'true'),
('6', 'Company', 'Jhn', 'Seed', '02/02/2020', 'Male', 'jhn@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '7', 'true'),
('12', 'Individual', 'Joseph', 'Seesd', '02/02/2020', 'Male', 'joseph@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '6', 'true'),
('13', 'Individual', 'Joshua', 'Sesed', '02/02/2020', 'Male', 'joshua@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '7', 'true'),
('14', 'Individual', 'Jeremy', 'Sseed', '02/02/2020', 'Male', 'jeremy@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '8', 'true'),
('15', 'Company', 'James', 'Seeddd', '02/02/2020', 'Male', 'james@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '9', 'true'),
('16', 'Company', 'Jam', 'Seed', '02/02/2020', 'Male', 'jam@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '10', 'true'),
('17', 'Individual', 'Joel', 'Sed', '02/02/2020', 'Male', 'joel@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '11', 'true'),
('18', 'Company', 'Rohn', 'Sede', '02/02/2020', 'Male', 'Rohn@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '12', 'true'),
('19', 'Individual', 'jom', 'Seedee', '02/02/2020', 'Male', 'jom@email.com', 'password',  '123123123',  '23' , 'phlips street', '1233', '13', 'true');