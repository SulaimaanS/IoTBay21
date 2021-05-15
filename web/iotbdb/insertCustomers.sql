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
INSERT INTO CUSTOMERTABLE(USERID, CUSTOMERTYPE, ORDERID, REGISTERED)
VALUES 
(8, 'Individual', 1, true);

