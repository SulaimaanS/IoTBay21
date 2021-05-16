/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  timmy
 * Created: 15/05/2021
 */

/*Inserting customers */
INSERT INTO CUSTOMERTABLE(USERID, CUSTOMERTYPE, REGISTERED)
VALUES 
(7, 'Individual', false);

/* Inserting customers who have an orderID and therefore are registered*/
INSERT INTO CUSTOMERTABLE(USERID, CUSTOMERTYPE, REGISTERED)
VALUES 
(8, 'Individual','Individual', 1, true);

/*Inserting customers using userID finalised*/
INSERT INTO CUSTOMERTABLE(USERID, TYPE, REGISTERED)
VALUES 
((SELECT USERID FROM USERTABLE WHERE USERID= 4), 'Company', true),
((SELECT USERID FROM USERTABLE WHERE USERID = 8), 'Company', true),
((SELECT USERID FROM USERTABLE WHERE USERID = 9), 'Individual', false),
((SELECT USERID FROM USERTABLE WHERE USERID = 10), 'Individual', false),
((SELECT USERID FROM USERTABLE WHERE USERID = 1), 'Individual', false),
((SELECT USERID FROM USERTABLE WHERE USERID = 2), 'Individual', true ),
((SELECT USERID FROM USERTABLE WHERE USERID = 5), 'Company', true),
((SELECT USERID FROM USERTABLE WHERE USERID = 6), 'Company', true),
((SELECT USERID FROM USERTABLE WHERE USERID = 12), 'Individual', true),
((SELECT USERID FROM USERTABLE WHERE USERID = 13), 'Company', true),
((SELECT USERID FROM USERTABLE WHERE USERID = 14), 'Individual', true),
((SELECT USERID FROM USERTABLE WHERE USERID = 7), 'Company', true),
((SELECT USERID FROM USERTABLE WHERE USERID = 11), 'Company', true),
((SELECT USERID FROM USERTABLE WHERE USERID = 15), 'Individual', true);

